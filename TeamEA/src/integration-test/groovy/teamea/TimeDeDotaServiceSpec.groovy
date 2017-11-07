package teamea

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TimeDeDotaServiceSpec extends Specification {

    TimeDeDotaService timeDeDotaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new TimeDeDota(...).save(flush: true, failOnError: true)
        //new TimeDeDota(...).save(flush: true, failOnError: true)
        //TimeDeDota timeDeDota = new TimeDeDota(...).save(flush: true, failOnError: true)
        //new TimeDeDota(...).save(flush: true, failOnError: true)
        //new TimeDeDota(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //timeDeDota.id
    }

    void "test get"() {
        setupData()

        expect:
        timeDeDotaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<TimeDeDota> timeDeDotaList = timeDeDotaService.list(max: 2, offset: 2)

        then:
        timeDeDotaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        timeDeDotaService.count() == 5
    }

    void "test delete"() {
        Long timeDeDotaId = setupData()

        expect:
        timeDeDotaService.count() == 5

        when:
        timeDeDotaService.delete(timeDeDotaId)
        sessionFactory.currentSession.flush()

        then:
        timeDeDotaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        TimeDeDota timeDeDota = new TimeDeDota()
        timeDeDotaService.save(timeDeDota)

        then:
        timeDeDota.id != null
    }
}
