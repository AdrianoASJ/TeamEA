package teamea

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MembrosServiceSpec extends Specification {

    MembrosService membrosService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Membros(...).save(flush: true, failOnError: true)
        //new Membros(...).save(flush: true, failOnError: true)
        //Membros membros = new Membros(...).save(flush: true, failOnError: true)
        //new Membros(...).save(flush: true, failOnError: true)
        //new Membros(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //membros.id
    }

    void "test get"() {
        setupData()

        expect:
        membrosService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Membros> membrosList = membrosService.list(max: 2, offset: 2)

        then:
        membrosList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        membrosService.count() == 5
    }

    void "test delete"() {
        Long membrosId = setupData()

        expect:
        membrosService.count() == 5

        when:
        membrosService.delete(membrosId)
        sessionFactory.currentSession.flush()

        then:
        membrosService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Membros membros = new Membros()
        membrosService.save(membros)

        then:
        membros.id != null
    }
}
