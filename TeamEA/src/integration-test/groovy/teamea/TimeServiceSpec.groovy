package teamea

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TimeServiceSpec extends Specification {

    TimeService timeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Time(...).save(flush: true, failOnError: true)
        //new Time(...).save(flush: true, failOnError: true)
        //Time time = new Time(...).save(flush: true, failOnError: true)
        //new Time(...).save(flush: true, failOnError: true)
        //new Time(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //time.id
    }

    void "test get"() {
        setupData()

        expect:
        timeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Time> timeList = timeService.list(max: 2, offset: 2)

        then:
        timeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        timeService.count() == 5
    }

    void "test delete"() {
        Long timeId = setupData()

        expect:
        timeService.count() == 5

        when:
        timeService.delete(timeId)
        sessionFactory.currentSession.flush()

        then:
        timeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Time time = new Time()
        timeService.save(time)

        then:
        time.id != null
    }
}
