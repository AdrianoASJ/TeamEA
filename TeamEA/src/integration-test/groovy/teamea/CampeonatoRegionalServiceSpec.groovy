package teamea

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CampeonatoRegionalServiceSpec extends Specification {

    CampeonatoRegionalService campeonatoRegionalService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new CampeonatoRegional(...).save(flush: true, failOnError: true)
        //new CampeonatoRegional(...).save(flush: true, failOnError: true)
        //CampeonatoRegional campeonatoRegional = new CampeonatoRegional(...).save(flush: true, failOnError: true)
        //new CampeonatoRegional(...).save(flush: true, failOnError: true)
        //new CampeonatoRegional(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //campeonatoRegional.id
    }

    void "test get"() {
        setupData()

        expect:
        campeonatoRegionalService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<CampeonatoRegional> campeonatoRegionalList = campeonatoRegionalService.list(max: 2, offset: 2)

        then:
        campeonatoRegionalList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        campeonatoRegionalService.count() == 5
    }

    void "test delete"() {
        Long campeonatoRegionalId = setupData()

        expect:
        campeonatoRegionalService.count() == 5

        when:
        campeonatoRegionalService.delete(campeonatoRegionalId)
        sessionFactory.currentSession.flush()

        then:
        campeonatoRegionalService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        CampeonatoRegional campeonatoRegional = new CampeonatoRegional()
        campeonatoRegionalService.save(campeonatoRegional)

        then:
        campeonatoRegional.id != null
    }
}
