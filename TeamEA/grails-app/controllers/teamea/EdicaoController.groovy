package teamea

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class EdicaoController {

    EdicaoService edicaoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond edicaoService.list(params), model:[edicaoCount: edicaoService.count()]
    }

    def show(Long id) {
        respond edicaoService.get(id)
    }

    def create() {
        respond new Edicao(params)
    }

    def save(Edicao edicao) {
        if (edicao == null) {
            notFound()
            return
        }

        try {
            edicaoService.save(edicao)
        } catch (ValidationException e) {
            respond edicao.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'edicao.label', default: 'Edicao'), edicao.id])
                redirect edicao
            }
            '*' { respond edicao, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond edicaoService.get(id)
    }

    def update(Edicao edicao) {
        if (edicao == null) {
            notFound()
            return
        }

        try {
            edicaoService.save(edicao)
        } catch (ValidationException e) {
            respond edicao.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'edicao.label', default: 'Edicao'), edicao.id])
                redirect edicao
            }
            '*'{ respond edicao, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        edicaoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'edicao.label', default: 'Edicao'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'edicao.label', default: 'Edicao'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
