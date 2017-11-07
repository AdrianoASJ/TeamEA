package teamea

import grails.gorm.services.Service

@Service(TimeDeDota)
interface TimeDeDotaService {

    TimeDeDota get(Serializable id)

    List<TimeDeDota> list(Map args)

    Long count()

    void delete(Serializable id)

    TimeDeDota save(TimeDeDota timeDeDota)

}