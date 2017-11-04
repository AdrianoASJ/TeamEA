package teamea

class Edicao {
	
	Integer ano
	
	static belongsTo = [campeonato: Campeonato]

    static constraints = {
    }
}
