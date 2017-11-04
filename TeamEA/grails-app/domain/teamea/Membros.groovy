package teamea

class Membros {
    String nome
    int idade
    String funcao
    String nomeDoPai
    String nomeDaMae

    static belongsTo = [time: Time]

    static constraints = {
    }
    public String toString() {
    		return this.nome
    	}
}


