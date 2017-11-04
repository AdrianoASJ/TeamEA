package teamea

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CampeonatoController {

    CampeonatoService campeonatoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond campeonatoService.list(params), model:[campeonatoCount: campeonatoService.count()]
    }

    def show(Long id) {
        respond campeonatoService.get(id)
    }

    def create() {
        respond new Campeonato(params)
    }

    def save(Campeonato campeonato) {
        if (campeonato == null) {
            notFound()
            return
        }

        try {
            campeonatoService.save(campeonato)
        } catch (ValidationException e) {
            respond campeonato.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'campeonato.label', default: 'Campeonato'), campeonato.id])
                redirect campeonato
            }
            '*' { respond campeonato, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond campeonatoService.get(id)
    }

    def update(Campeonato campeonato) {
        if (campeonato == null) {
            notFound()
            return
        }

        try {
            campeonatoService.save(campeonato)
        } catch (ValidationException e) {
            respond campeonato.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'campeonato.label', default: 'Campeonato'), campeonato.id])
                redirect campeonato
            }
            '*'{ respond campeonato, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        campeonatoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'campeonato.label', default: 'Campeonato'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'campeonato.label', default: 'Campeonato'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
