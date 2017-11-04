package teamea

class Campeonato {
	
	String nome
	Boolean nacional
	
	static hasMany = [edicoes: Edicao]

    static constraints = {
		nome minSize: 5, maxSize: 20 
    }
}