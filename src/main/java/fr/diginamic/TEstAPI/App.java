package fr.diginamic.TEstAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try {
			// App.call_me();
			JSONObject myResponse = ApiUtils.callApi(
					"https://public.opendatasoft.com/api/records/1.0/search/?dataset=openaq&rows=1500&sort=measurements_lastupdated&facet=location&facet=measurements_parameter&facet=measurements_sourcename&facet=measurements_lastupdated&geofilter.polygon=(46.29001987172955%2C-2.48291015625)%2C(48.25028349849022%2C-2.48291015625)%2C(48.25028349849022%2C1.2139892578125)%2C(46.29001987172955%2C1.2139892578125)%2C(46.29001987172955%2C-2.48291015625)");

			List<StationDeMesure> listeDeStationsDeMesure = JsonManipulation.obtenirLesStationDeMesures(myResponse);
			List<Mesure> listeDesMesures = JsonManipulation.obtenirLesMesures(myResponse);

			// for (StationDeMesure stationDeMesure : listeDeStationsDeMesure) {
			//
			// System.out.println(stationDeMesure.getId()
			// + "-"+stationDeMesure.getMesureCO()
			// + "-"+stationDeMesure.getMesureNO2()
			// + "-"+stationDeMesure.getMesureO3()
			// + "-"+stationDeMesure.getMesurePM10()
			// + "-"+stationDeMesure.getMesurePM25()
			// + "-"+ "-"+stationDeMesure.getMesureSO2()
			// + "_______"+stationDeMesure.getPositionGps().getLatitude()
			// + "__"+stationDeMesure.getPositionGps().getLongitude());
			//
			// }

			JSONObject myResponseCommunes = ApiUtils.callApiCommunes(
					"https://geo.api.gouv.fr/communes?codeRegion=52&fields=nom,code,codesPostaux,centre,codeRegion,population&format=json&geometry=centre");
			List<Commune> listeDesCommunes = new ArrayList<Commune>();
			listeDesCommunes = JsonManipulation.obtenirLesCommunes(myResponseCommunes);

			listeDesCommunes = CommuneUtils.obtenirLesStationsDeMesuresLesPlusProches(listeDesCommunes,
					listeDeStationsDeMesure);

		  for (Mesure mesure : listeDesMesures) {
				System.out.println(mesure.getTypeDeDonnee() + " " + mesure.getValeur() + " " + mesure.getDate() + " "
						+ mesure.getIdStationDeMesure());
			}

			// System.out.println(myResponseCommunes.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void call_me() throws Exception {
		String url = "https://public.opendatasoft.com/api/records/1.0/search/?dataset=openaq&rows=1500&sort=measurements_lastupdated&facet=location&facet=measurements_parameter&facet=measurements_sourcename&facet=measurements_lastupdated&geofilter.polygon=(46.29001987172955%2C-2.48291015625)%2C(48.25028349849022%2C-2.48291015625)%2C(48.25028349849022%2C1.2139892578125)%2C(46.29001987172955%2C1.2139892578125)%2C(46.29001987172955%2C-2.48291015625)";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		// optional default is GET
		con.setRequestMethod("GET");
		// add request header
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		// print in String
		System.out.println(response.toString());
		// Read JSON response and print
		JSONObject myResponse = new JSONObject(response.toString());
		System.out.println("result after Reading JSON Response");
		System.out.println(myResponse);
		int count = myResponse.getJSONArray("records").length(); // get
																	// totalCount
																	// of all
																	// jsonObjects

		List<PositionGps> listeDesPositionGps = new ArrayList<PositionGps>();
		List<StationDeMesure> listeDeStationsDeMesure = new ArrayList<StationDeMesure>();

		for (int i = 0; i < count; i++) { // iterate through jsonArray

			JSONObject jsonObject = myResponse.getJSONArray("records").getJSONObject(i); // get
																							// jsonObject
																							// @
																							// i
																							// position
			System.out.println("jsonObject " + i + " ------ " + jsonObject);

			JSONObject jsonObjectGeometry = jsonObject.getJSONObject("geometry");
			double latitude = (Double) jsonObjectGeometry.getJSONArray("coordinates").get(0);
			System.out.println(jsonObjectGeometry.getJSONArray("coordinates").get(0));
			double longitude = (Double) jsonObjectGeometry.getJSONArray("coordinates").get(1);
			System.out.println(jsonObjectGeometry.getJSONArray("coordinates").get(1));

			JSONObject jsonObjectFields = jsonObject.getJSONObject("fields");
			String typeDonnee = jsonObjectFields.getString("measurements_parameter");
			System.out.println(typeDonnee);

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
		for (StationDeMesure stationDeMesure : listeDeStationsDeMesure) {

			System.out.println(stationDeMesure.getId() + "-" + stationDeMesure.getMesureCO() + "-"
					+ stationDeMesure.getMesureNO2() + "-" + stationDeMesure.getMesureO3() + "-"
					+ stationDeMesure.getMesurePM10() + "-" + stationDeMesure.getMesurePM25() + "-" + "-"
					+ stationDeMesure.getMesureSO2() + "_______" + stationDeMesure.getPositionGps().getLatitude() + "__"
					+ stationDeMesure.getPositionGps().getLongitude());

		}
		System.out.println("a" + listeDesPositionGps.size());

	}
}
