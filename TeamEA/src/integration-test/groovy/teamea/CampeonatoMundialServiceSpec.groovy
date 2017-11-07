package teamea

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CampeonatoMundialServiceSpec extends Specification {

    CampeonatoMundialService campeonatoMundialService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new CampeonatoMundial(...).save(flush: true, failOnError: true)
        //new CampeonatoMundial(...).save(flush: true, failOnError: true)
        //CampeonatoMundial campeonatoMundial = new CampeonatoMundial(...).save(flush: true, failOnError: true)
        //new CampeonatoMundial(...).save(flush: true, failOnError: true)
        //new CampeonatoMundial(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //campeonatoMundial.id
    }

    void "test get"() {
        setupData()

        expect:
        campeonatoMundialService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<CampeonatoMundial> campeonatoMundialList = campeonatoMundialService.list(max: 2, offset: 2)

        then:
        campeonatoMundialList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        campeonatoMundialService.count() == 5
    }

    void "test delete"() {
        Long campeonatoMundialId = setupData()

        expect:
        campeonatoMundialService.count() == 5

        when:
        campeonatoMundialService.delete(campeonatoMundialId)
        sessionFactory.currentSession.flush()

        then:
        campeonatoMundialService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        CampeonatoMundial campeonatoMundial = new CampeonatoMundial()
        campeonatoMundialService.save(campeonatoMundial)

        then:
        campeonatoMundial.id != null
    }
}
