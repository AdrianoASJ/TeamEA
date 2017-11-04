package teamea

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EdicaoServiceSpec extends Specification {

    EdicaoService edicaoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Edicao(...).save(flush: true, failOnError: true)
        //new Edicao(...).save(flush: true, failOnError: true)
        //Edicao edicao = new Edicao(...).save(flush: true, failOnError: true)
        //new Edicao(...).save(flush: true, failOnError: true)
        //new Edicao(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //edicao.id
    }

    void "test get"() {
        setupData()

        expect:
        edicaoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Edicao> edicaoList = edicaoService.list(max: 2, offset: 2)

        then:
        edicaoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        edicaoService.count() == 5
    }

    void "test delete"() {
        Long edicaoId = setupData()

        expect:
        edicaoService.count() == 5

        when:
        edicaoService.delete(edicaoId)
        sessionFactory.currentSession.flush()

        then:
        edicaoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Edicao edicao = new Edicao()
        edicaoService.save(edicao)

        then:
        edicao.id != null
    }
}
