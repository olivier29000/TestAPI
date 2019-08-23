package fr.diginamic.TEstAPI;

public class Commune {

	String nom;
	String code;
	String codesPostaux;
	PositionGps centre;
	int population;
	int idStationDeMesure;

	/**
	 * Constructeur
	 * 
	 * @param nom
	 * @param code
	 * @param codesPostaux
	 * @param centre
	 * @param population
	 */
	public Commune(String nom, String code, String codesPostaux, PositionGps centre, int population,
			int idStationDeMesure) {
		super();
		this.nom = nom;
		this.code = code;
		this.codesPostaux = codesPostaux;
		this.centre = centre;
		this.population = population;
		this.idStationDeMesure = idStationDeMesure;
	}

}
