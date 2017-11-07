package teamea

class CampeonatoMundial implements Campeonato {
	String idiomaOficial

	ArrayList<String> paises
	static hasMany = [time: Time]

	public String function dia() {
		if (diaMes > 15){
			return "segunda"
		}

		
	}

    static constraints = {
    }
}
