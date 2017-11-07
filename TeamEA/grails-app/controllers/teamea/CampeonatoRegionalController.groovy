package teamea

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CampeonatoRegionalController {

    CampeonatoRegionalService campeonatoRegionalService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond campeonatoRegionalService.list(params), model:[campeonatoRegionalCount: campeonatoRegionalService.count()]
    }

    def show(Long id) {
        respond campeonatoRegionalService.get(id)
    }

    def create() {
        respond new CampeonatoRegional(params)
    }

    def save(CampeonatoRegional campeonatoRegional) {
        if (campeonatoRegional == null) {
            notFound()
            return
        }

        try {
            campeonatoRegionalService.save(campeonatoRegional)
        } catch (ValidationException e) {
            respond campeonatoRegional.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'campeonatoRegional.label', default: 'CampeonatoRegional'), campeonatoRegional.id])
                redirect campeonatoRegional
            }
            '*' { respond campeonatoRegional, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond campeonatoRegionalService.get(id)
    }

    def update(CampeonatoRegional campeonatoRegional) {
        if (campeonatoRegional == null) {
            notFound()
            return
        }

        try {
            campeonatoRegionalService.save(campeonatoRegional)
        } catch (ValidationException e) {
            respond campeonatoRegional.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'campeonatoRegional.label', default: 'CampeonatoRegional'), campeonatoRegional.id])
                redirect campeonatoRegional
            }
            '*'{ respond campeonatoRegional, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        campeonatoRegionalService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'campeonatoRegional.label', default: 'CampeonatoRegional'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'campeonatoRegional.label', default: 'CampeonatoRegional'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
