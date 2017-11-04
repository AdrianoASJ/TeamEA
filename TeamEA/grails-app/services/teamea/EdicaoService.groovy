package teamea

import grails.gorm.services.Service

@Service(Edicao)
interface EdicaoService {

    Edicao get(Serializable id)

    List<Edicao> list(Map args)

    Long count()

    void delete(Serializable id)

    Edicao save(Edicao edicao)

}