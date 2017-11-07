package teamea

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CampeonatoMundialController {

    CampeonatoMundialService campeonatoMundialService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond campeonatoMundialService.list(params), model:[campeonatoMundialCount: campeonatoMundialService.count()]
    }

    def show(Long id) {
        respond campeonatoMundialService.get(id)
    }

    def create() {
        respond new CampeonatoMundial(params)
    }

    def save(CampeonatoMundial campeonatoMundial) {
        if (campeonatoMundial == null) {
            notFound()
            return
        }

        try {
            campeonatoMundialService.save(campeonatoMundial)
        } catch (ValidationException e) {
            respond campeonatoMundial.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'campeonatoMundial.label', default: 'CampeonatoMundial'), campeonatoMundial.id])
                redirect campeonatoMundial
            }
            '*' { respond campeonatoMundial, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond campeonatoMundialService.get(id)
    }

    def update(CampeonatoMundial campeonatoMundial) {
        if (campeonatoMundial == null) {
            notFound()
            return
        }

        try {
            campeonatoMundialService.save(campeonatoMundial)
        } catch (ValidationException e) {
            respond campeonatoMundial.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'campeonatoMundial.label', default: 'CampeonatoMundial'), campeonatoMundial.id])
                redirect campeonatoMundial
            }
            '*'{ respond campeonatoMundial, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        campeonatoMundialService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'campeonatoMundial.label', default: 'CampeonatoMundial'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'campeonatoMundial.label', default: 'CampeonatoMundial'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
