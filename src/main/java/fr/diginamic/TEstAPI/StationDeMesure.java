package fr.diginamic.TEstAPI;

public class StationDeMesure {

	public static int compteur;
	public int id;
	PositionGps positionGps;
	boolean mesureSO2;
	boolean mesurePM25;
	boolean mesurePM10;
	boolean mesureO3;
	boolean mesureNO2;
	boolean mesureCO;

	/**
	 * Constructeur
	 * 
	 * @param id
	 * @param positionGps
	 * @param mesureSO2
	 * @param mesurePM25
	 * @param mesurePM10
	 * @param mesureO3
	 * @param mesureNO2
	 * @param mesureCO
	 */
	public StationDeMesure(int id, PositionGps positionGps, boolean mesureSO2, boolean mesurePM25, boolean mesurePM10,
			boolean mesureO3, boolean mesureNO2, boolean mesureCO) {
		super();
		this.id = compteur;
		this.positionGps = positionGps;
		this.mesureSO2 = mesureSO2;
		this.mesurePM25 = mesurePM25;
		this.mesurePM10 = mesurePM10;
		this.mesureO3 = mesureO3;
		this.mesureNO2 = mesureNO2;
		this.mesureCO = mesureCO;
		compteur++;
	}

}
