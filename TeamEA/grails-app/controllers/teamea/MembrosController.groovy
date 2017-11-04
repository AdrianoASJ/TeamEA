package teamea

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MembrosController {

    MembrosService membrosService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond membrosService.list(params), model:[membrosCount: membrosService.count()]
    }

    def show(Long id) {
        respond membrosService.get(id)
    }

    def create() {
        respond new Membros(params)
    }

    def save(Membros membros) {
        if (membros == null) {
            notFound()
            return
        }

        try {
            membrosService.save(membros)
        } catch (ValidationException e) {
            respond membros.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'membros.label', default: 'Membros'), membros.id])
                redirect membros
            }
            '*' { respond membros, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond membrosService.get(id)
    }

    def update(Membros membros) {
        if (membros == null) {
            notFound()
            return
        }

        try {
            membrosService.save(membros)
        } catch (ValidationException e) {
            respond membros.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'membros.label', default: 'Membros'), membros.id])
                redirect membros
            }
            '*'{ respond membros, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        membrosService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'membros.label', default: 'Membros'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'membros.label', default: 'Membros'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
