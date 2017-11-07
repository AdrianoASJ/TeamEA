package teamea

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TimeDeDotaController {

    TimeDeDotaService timeDeDotaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond timeDeDotaService.list(params), model:[timeDeDotaCount: timeDeDotaService.count()]
    }

    def show(Long id) {
        respond timeDeDotaService.get(id)
    }

    def create() {
        respond new TimeDeDota(params)
    }

    def save(TimeDeDota timeDeDota) {
        if (timeDeDota == null) {
            notFound()
            return
        }

        try {
            timeDeDotaService.save(timeDeDota)
        } catch (ValidationException e) {
            respond timeDeDota.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'timeDeDota.label', default: 'TimeDeDota'), timeDeDota.id])
                redirect timeDeDota
            }
            '*' { respond timeDeDota, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond timeDeDotaService.get(id)
    }

    def update(TimeDeDota timeDeDota) {
        if (timeDeDota == null) {
            notFound()
            return
        }

        try {
            timeDeDotaService.save(timeDeDota)
        } catch (ValidationException e) {
            respond timeDeDota.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'timeDeDota.label', default: 'TimeDeDota'), timeDeDota.id])
                redirect timeDeDota
            }
            '*'{ respond timeDeDota, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        timeDeDotaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'timeDeDota.label', default: 'TimeDeDota'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'timeDeDota.label', default: 'TimeDeDota'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
