package teamea

import grails.gorm.services.Service

@Service(TimeDeLol)
interface TimeDeLolService {

    TimeDeLol get(Serializable id)

    List<TimeDeLol> list(Map args)

    Long count()

    void delete(Serializable id)

    TimeDeLol save(TimeDeLol timeDeLol)

}