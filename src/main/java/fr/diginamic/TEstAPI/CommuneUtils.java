package fr.diginamic.TEstAPI;

import java.util.List;

public class CommuneUtils {
	
	
	public static List<Commune> obtenirLesStationsDeMesuresLesPlusProches(List<Commune> listeDesCommunes,List<StationDeMesure> listeDeStationsDeMesure){

		int sommeDistanceStationDeMesure=0;
		int sommeDistanceStationDeMesureSO2=0;
		int sommeDistanceStationDeMesurePM25=0;
		int sommeDistanceStationDeMesurePM10=0;
		int sommeDistanceStationDeMesureO3=0;
		int sommeDistanceStationDeMesureNO2=0;
		int sommeDistanceStationDeMesureCO=0;
		int n=0;

			for (Commune commune : listeDesCommunes) {
				int idStationDeMesureLaPlusProche;
				double distanceStationDeMesureLaPlusProche = Double.MAX_VALUE;
				double distanceStationDeMesureLaPlusProcheSO2 = Double.MAX_VALUE;
				double distanceStationDeMesureLaPlusProchePM25 = Double.MAX_VALUE;
				double distanceStationDeMesureLaPlusProchePM10 = Double.MAX_VALUE;
				double distanceStationDeMesureLaPlusProcheO3 = Double.MAX_VALUE;
				double distanceStationDeMesureLaPlusProcheNO2 = Double.MAX_VALUE;
				double distanceStationDeMesureLaPlusProcheCO = Double.MAX_VALUE;
				
				
				for (StationDeMesure stationDeMesure : listeDeStationsDeMesure) {
					double distancecalculee;
					distancecalculee = Math.sqrt(Math.pow(
							stationDeMesure.getPositionGps().getLatitude() - commune.getCentre().getLatitude(), 2)
							+ Math.pow(stationDeMesure.getPositionGps().getLongitude()
									- commune.getCentre().getLongitude(), 2));
					if (distancecalculee < distanceStationDeMesureLaPlusProche) {
						distanceStationDeMesureLaPlusProche = distancecalculee;
						commune.setIdStationDeMesure((int) (distancecalculee * 111110));
					}
					if (distancecalculee < distanceStationDeMesureLaPlusProcheSO2 && stationDeMesure.getMesureSO2()==1) {
						distanceStationDeMesureLaPlusProcheSO2 = distancecalculee;
						commune.setIdStationDeMesureSO2((int) (distancecalculee * 111110));
					}
					if (distancecalculee < distanceStationDeMesureLaPlusProchePM25 && stationDeMesure.getMesurePM25()==1) {
						distanceStationDeMesureLaPlusProchePM25 = distancecalculee;
						commune.setIdStationDeMesurePM25((int) (distancecalculee * 111110));
					}
					if (distancecalculee < distanceStationDeMesureLaPlusProchePM10 && stationDeMesure.getMesurePM10()==1) {
						distanceStationDeMesureLaPlusProchePM10 = distancecalculee;
						commune.setIdStationDeMesurePM10((int) (distancecalculee * 111110));
					}
					if (distancecalculee < distanceStationDeMesureLaPlusProcheO3 && stationDeMesure.getMesureO3()==1) {
						distanceStationDeMesureLaPlusProcheO3 = distancecalculee;
						commune.setIdStationDeMesureO3((int) (distancecalculee * 111110));
					}
					if (distancecalculee < distanceStationDeMesureLaPlusProcheNO2 && stationDeMesure.getMesureNO2()==1) {
						distanceStationDeMesureLaPlusProcheNO2 = distancecalculee;
						commune.setIdStationDeMesureNO2((int) (distancecalculee * 111110));
					}
					if (distancecalculee < distanceStationDeMesureLaPlusProcheCO && stationDeMesure.getMesureCO()==1) {
						distanceStationDeMesureLaPlusProcheCO = distancecalculee;
						commune.setIdStationDeMesureCO((int) (distancecalculee * 111110));
					}
				}
				
				
				
				System.out.println(commune.getNom() + " " + commune.getIdStationDeMesure() 
				+ " " + commune.getIdStationDeMesureSO2()
				+ " " + commune.getIdStationDeMesurePM25()
				+ " " + commune.getIdStationDeMesurePM10()
				+ " " + commune.getIdStationDeMesureO3()
				+ " " + commune.getIdStationDeMesureNO2()
				+ " " + commune.getIdStationDeMesureCO());
				
				sommeDistanceStationDeMesure+=commune.getIdStationDeMesure();
				sommeDistanceStationDeMesureSO2+=commune.getIdStationDeMesureSO2();
				 sommeDistanceStationDeMesurePM25+=commune.getIdStationDeMesurePM25();
				 sommeDistanceStationDeMesurePM10+=commune.getIdStationDeMesurePM10();
				 sommeDistanceStationDeMesureO3+=commune.getIdStationDeMesureO3();
				 sommeDistanceStationDeMesureNO2+=commune.getIdStationDeMesureNO2();
				 sommeDistanceStationDeMesureCO+=commune.getIdStationDeMesureCO();
				 n++;
				
			}
			System.out.println(
			sommeDistanceStationDeMesure/n+ " " +
			sommeDistanceStationDeMesureSO2/n+ " " +
			 sommeDistanceStationDeMesurePM25/n+ " " +
			 sommeDistanceStationDeMesurePM10/n+ " " +
			 sommeDistanceStationDeMesureO3/n+ " " +
			 sommeDistanceStationDeMesureNO2/n+ " " +
			 sommeDistanceStationDeMesureCO/n+ " " +
			 n);
			
			return listeDesCommunes;
		}

}
