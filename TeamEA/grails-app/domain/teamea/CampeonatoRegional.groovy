package teamea

class CampeonatoRegional implements Campeonato {

		String estado

		ArrayList<String> cidades
		static hasMany = [time: Time]

	public String function dia() {
		if (diaMes =< 15){
			return "sexta"
		}

	}

    static constraints = {
    }
}
