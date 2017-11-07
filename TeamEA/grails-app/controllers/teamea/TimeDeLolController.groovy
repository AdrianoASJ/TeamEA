package teamea

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TimeDeLolController {

    TimeDeLolService timeDeLolService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond timeDeLolService.list(params), model:[timeDeLolCount: timeDeLolService.count()]
    }

    def show(Long id) {
        respond timeDeLolService.get(id)
    }

    def create() {
        respond new TimeDeLol(params)
    }

    def save(TimeDeLol timeDeLol) {
        if (timeDeLol == null) {
            notFound()
            return
        }

        try {
            timeDeLolService.save(timeDeLol)
        } catch (ValidationException e) {
            respond timeDeLol.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'timeDeLol.label', default: 'TimeDeLol'), timeDeLol.id])
                redirect timeDeLol
            }
            '*' { respond timeDeLol, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond timeDeLolService.get(id)
    }

    def update(TimeDeLol timeDeLol) {
        if (timeDeLol == null) {
            notFound()
            return
        }

        try {
            timeDeLolService.save(timeDeLol)
        } catch (ValidationException e) {
            respond timeDeLol.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'timeDeLol.label', default: 'TimeDeLol'), timeDeLol.id])
                redirect timeDeLol
            }
            '*'{ respond timeDeLol, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        timeDeLolService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'timeDeLol.label', default: 'TimeDeLol'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'timeDeLol.label', default: 'TimeDeLol'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
