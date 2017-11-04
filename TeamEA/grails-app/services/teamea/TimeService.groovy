package teamea

import grails.gorm.services.Service

@Service(Time)
interface TimeService {

    Time get(Serializable id)

    List<Time> list(Map args)

    Long count()

    void delete(Serializable id)

    Time save(Time time)

}