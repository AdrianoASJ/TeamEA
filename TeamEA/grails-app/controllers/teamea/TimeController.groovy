package teamea

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TimeController {

    TimeService timeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond timeService.list(params), model:[timeCount: timeService.count()]
    }

    def show(Long id) {
        respond timeService.get(id)
    }

    def create() {
        respond new Time(params)
    }

    def save(Time time) {
        if (time == null) {
            notFound()
            return
        }

        try {
            timeService.save(time)
        } catch (ValidationException e) {
            respond time.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'time.label', default: 'Time'), time.id])
                redirect time
            }
            '*' { respond time, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond timeService.get(id)
    }

    def update(Time time) {
        if (time == null) {
            notFound()
            return
        }

        try {
            timeService.save(time)
        } catch (ValidationException e) {
            respond time.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'time.label', default: 'Time'), time.id])
                redirect time
            }
            '*'{ respond time, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        timeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'time.label', default: 'Time'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'time.label', default: 'Time'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
