package fr.diginamic.TEstAPI;

public class Commune {

	String nom;
	String code;
	String codesPostaux;
	PositionGps centre;
	int population;
	int idStationDeMesure;
	int idStationDeMesureSO2;
	int idStationDeMesurePM25;
	int idStationDeMesurePM10;
	int idStationDeMesureO3;
	int idStationDeMesureNO2;
	int idStationDeMesureCO;
	
	
	
	public int getIdStationDeMesureSO2() {
		return idStationDeMesureSO2;
	}




	public void setIdStationDeMesureSO2(int idStationDeMesureSO2) {
		this.idStationDeMesureSO2 = idStationDeMesureSO2;
	}




	public int getIdStationDeMesurePM25() {
		return idStationDeMesurePM25;
	}




	public void setIdStationDeMesurePM25(int idStationDeMesurePM25) {
		this.idStationDeMesurePM25 = idStationDeMesurePM25;
	}




	public int getIdStationDeMesurePM10() {
		return idStationDeMesurePM10;
	}




	public void setIdStationDeMesurePM10(int idStationDeMesurePM10) {
		this.idStationDeMesurePM10 = idStationDeMesurePM10;
	}




	public int getIdStationDeMesureO3() {
		return idStationDeMesureO3;
	}




	public void setIdStationDeMesureO3(int idStationDeMesureO3) {
		this.idStationDeMesureO3 = idStationDeMesureO3;
	}




	public int getIdStationDeMesureNO2() {
		return idStationDeMesureNO2;
	}




	public void setIdStationDeMesureNO2(int idStationDeMesureNO2) {
		this.idStationDeMesureNO2 = idStationDeMesureNO2;
	}




	public int getIdStationDeMesureCO() {
		return idStationDeMesureCO;
	}




	public void setIdStationDeMesureCO(int idStationDeMesureCO) {
		this.idStationDeMesureCO = idStationDeMesureCO;
	}




	public Commune(String nom, String code, String codesPostaux, PositionGps centre, int population,
			int idStationDeMesureSO2, int idStationDeMesurePM25, int idStationDeMesurePM10, int idStationDeMesureO3,
			int idStationDeMesureNO2, int idStationDeMesureCO) {
		super();
		this.nom = nom;
		this.code = code;
		this.codesPostaux = codesPostaux;
		this.centre = centre;
		this.population = population;
		this.idStationDeMesureSO2 = idStationDeMesureSO2;
		this.idStationDeMesurePM25 = idStationDeMesurePM25;
		this.idStationDeMesurePM10 = idStationDeMesurePM10;
		this.idStationDeMesureO3 = idStationDeMesureO3;
		this.idStationDeMesureNO2 = idStationDeMesureNO2;
		this.idStationDeMesureCO = idStationDeMesureCO;
	}

	
	
	
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
	
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodesPostaux() {
		return codesPostaux;
	}

	public void setCodesPostaux(String codesPostaux) {
		this.codesPostaux = codesPostaux;
	}

	public PositionGps getCentre() {
		return centre;
	}

	public void setCentre(PositionGps centre) {
		this.centre = centre;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public int getIdStationDeMesure() {
		return idStationDeMesure;
	}

	public void setIdStationDeMesure(int idStationDeMesure) {
		this.idStationDeMesure = idStationDeMesure;
	}

	

}
