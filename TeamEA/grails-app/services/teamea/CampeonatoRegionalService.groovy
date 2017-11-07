package teamea

import grails.gorm.services.Service

@Service(CampeonatoRegional)
interface CampeonatoRegionalService {

    CampeonatoRegional get(Serializable id)

    List<CampeonatoRegional> list(Map args)

    Long count()

    void delete(Serializable id)

    CampeonatoRegional save(CampeonatoRegional campeonatoRegional)

}