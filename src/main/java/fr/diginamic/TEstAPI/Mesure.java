package fr.diginamic.TEstAPI;

import java.util.Date;

public class Mesure {
	
	double valeur;
	String typeDeDonnee;
	String date;
	int idStationDeMesure;
	
	
	
	
	public Mesure(double valeur, String typeDeDonnee, String date, int idStationDeMesure) {
		super();
		this.valeur = valeur;
		this.typeDeDonnee = typeDeDonnee;
		this.date = date;
		this.idStationDeMesure = idStationDeMesure;
	}
	
	
	public double getValeur() {
		return valeur;
	}
	public void setValeur(double valeur) {
		this.valeur = valeur;
	}
	public String getTypeDeDonnee() {
		return typeDeDonnee;
	}
	public void setTypeDeDonnee(String typeDeDonnee) {
		this.typeDeDonnee = typeDeDonnee;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getIdStationDeMesure() {
		return idStationDeMesure;
	}
	public void setIdStationDeMesure(int idStationDeMesure) {
		this.idStationDeMesure = idStationDeMesure;
	}

}
