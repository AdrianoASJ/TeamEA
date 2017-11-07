package teamea

 public abstract class Time {
    String regiao
    String nome
    String nomeDoTecnico
    int numeroDeJogadores  
    
    static hasMany = [membros: Membros]
    static constraints = {
    }

    public int returnNumJogadores() {
        return 1;
    }

    public String Boss() {
        return "Monstro";
    }

    public String Boss(String boss) {
        return "rochan";
    }

    public abstract listTimes();

    public String toString() {
    		return this.nome
    	}
}
