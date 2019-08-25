package fr.diginamic.TEstAPI;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonManipulation {
	
	public static List<Commune> obtenirLesCommunes(JSONObject myResponse){
		
		
		List<Commune> listeDesCommunes =new ArrayList<Commune>();
		JSONArray tableauDesCommunes =myResponse.getJSONArray("communes");
		
		for (Object object : tableauDesCommunes) {
			JSONObject commune = (JSONObject) object;
			listeDesCommunes.add(new Commune(commune.getString("nom"), 
					commune.getString("code"), 
					commune.getJSONArray("codesPostaux").getString(0), 
					new PositionGps(commune.getJSONObject("centre").getJSONArray("coordinates").getDouble(0), commune.getJSONObject("centre").getJSONArray("coordinates").getDouble(1)), 
					commune.getInt("population"), 
					1));
		}
		
		
		return listeDesCommunes;
		
	
	}
	
	public static List<StationDeMesure> obtenirLesStationDeMesures(JSONObject myResponse){
	List<PositionGps> listeDesPositionGps = new ArrayList<PositionGps>();
	List<StationDeMesure> listeDeStationsDeMesure = new ArrayList<StationDeMesure>();
	
	int count = myResponse.getJSONArray("records").length(); 
	
	for (int i = 0; i < count; i++) { // iterate through jsonArray

		JSONObject jsonObject = myResponse.getJSONArray("records").getJSONObject(i); // get
																						// jsonObject
																						// @
																						// i
																						// position
		//System.out.println("jsonObject " + i + " ------ " + jsonObject);

		JSONObject jsonObjectGeometry = jsonObject.getJSONObject("geometry");
		double latitude = (Double) jsonObjectGeometry.getJSONArray("coordinates").get(0);
		//System.out.println(jsonObjectGeometry.getJSONArray("coordinates").get(0));
		double longitude = (Double) jsonObjectGeometry.getJSONArray("coordinates").get(1);
		//System.out.println(jsonObjectGeometry.getJSONArray("coordinates").get(1));

		JSONObject jsonObjectFields = jsonObject.getJSONObject("fields");
		String typeDonnee = jsonObjectFields.getString("measurements_parameter");
		//System.out.println(typeDonnee);

		boolean positionGpsExisteDeja = false;

		

		for (PositionGps positionGps : listeDesPositionGps) {
			if (positionGps.getLatitude() == latitude && positionGps.getLongitude() == longitude) {
				positionGpsExisteDeja = true;

			}
		}
		if (positionGpsExisteDeja == false) {
			listeDesPositionGps.add(new PositionGps(latitude, longitude));
			listeDeStationsDeMesure
					.add(new StationDeMesure(new PositionGps(latitude, longitude), 0, 0, 0, 0, 0, 0));
		}

		for (StationDeMesure stationDeMesure : listeDeStationsDeMesure) {
			if (stationDeMesure.getPositionGps().getLatitude() == latitude
					&& stationDeMesure.getPositionGps().getLongitude() == longitude) {
				if (typeDonnee.equals("SO2")) {
					stationDeMesure.setMesureSO2(1);
				}
				if (typeDonnee.equals("PM2.5")) {
					stationDeMesure.setMesurePM25(1);
				}
				if (typeDonnee.equals("PM10")) {
					stationDeMesure.setMesurePM10(1);
				}
				if (typeDonnee.equals("O3")) {
					stationDeMesure.setMesureO3(1);
				}
				if (typeDonnee.equals("NO2")) {
					stationDeMesure.setMesureNO2(1);
				}
				if (typeDonnee.equals("CO")) {
					stationDeMesure.setMesureCO(1);
				}
			}

		}
		
	}
	return listeDeStationsDeMesure;
	}

	public static List<Mesure> obtenirLesMesures(JSONObject myResponse) {
		// TODO Auto-generated method stub
		
		List<Mesure> listeDesMesures = new ArrayList<Mesure>();


		int count = myResponse.getJSONArray("records").length(); 
		
		for (int i = 0; i < count; i++) { // iterate through jsonArray

			JSONObject jsonObject = myResponse.getJSONArray("records").getJSONObject(i); // get
																							// jsonObject
																							// @
																							// i
																							// position
			//System.out.println("jsonObject " + i + " ------ " + jsonObject);


			JSONObject jsonObjectFields = jsonObject.getJSONObject("fields");
			String typeDonnee = jsonObjectFields.getString("measurements_parameter");
			double valeur = jsonObjectFields.getDouble("measurements_value");
			String date = jsonObjectFields.getString("measurements_lastupdated");
			
			listeDesMesures.add(new Mesure(valeur, typeDonnee, date, 1));
		}
		return listeDesMesures;
	}
	
	
}


