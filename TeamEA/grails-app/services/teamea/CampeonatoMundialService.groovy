package teamea

import grails.gorm.services.Service

@Service(CampeonatoMundial)
interface CampeonatoMundialService {

    CampeonatoMundial get(Serializable id)

    List<CampeonatoMundial> list(Map args)

    Long count()

    void delete(Serializable id)

    CampeonatoMundial save(CampeonatoMundial campeonatoMundial)

}