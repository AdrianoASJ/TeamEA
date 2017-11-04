package teamea

class Time {
    String regiao
    String nome
    String nomeDoTecnico
    int numeroDeJogadores  
    
    static hasMany = [membros: Membros]
    static constraints = {
    }

    public String toString() {
    		return this.nome
    	}
}
