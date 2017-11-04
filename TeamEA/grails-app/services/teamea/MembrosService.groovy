package teamea

import grails.gorm.services.Service

@Service(Membros)
interface MembrosService {

    Membros get(Serializable id)

    List<Membros> list(Map args)

    Long count()

    void delete(Serializable id)

    Membros save(Membros membros)

}