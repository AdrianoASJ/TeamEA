package teamea

import grails.gorm.services.Service

@Service(Campeonato)
interface CampeonatoService {

    Campeonato get(Serializable id)

    List<Campeonato> list(Map args)

    Long count()

    void delete(Serializable id)

    Campeonato save(Campeonato campeonato)

}