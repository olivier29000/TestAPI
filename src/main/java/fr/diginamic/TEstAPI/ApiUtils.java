package fr.diginamic.TEstAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiUtils {
	
	
	public static JSONObject callApi(String url)  throws Exception {
	URL obj = new URL(url);
	HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	// optional default is GET
	con.setRequestMethod("GET");
	// add request header
	con.setRequestProperty("User-Agent", "Mozilla/5.0");
	int responseCode = con.getResponseCode();
	//System.out.println("\nSending 'GET' request to URL : " + url);
	//System.out.println("Response Code : " + responseCode);
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
	
	return myResponse;
	}
	
	
	public static JSONObject callApiCommunes(String url)  throws Exception {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		// optional default is GET
		con.setRequestMethod("GET");
		// add request header
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		int responseCode = con.getResponseCode();
		//System.out.println("\nSending 'GET' request to URL : " + url);
		//System.out.println("Response Code : " + responseCode);
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		
		in.close();
		// print in String
		String maReponseDefinitive="{\"communes\":" + response.toString()+"}";
				//.substring(1, response.toString().length()-1) ;
		System.out.println(maReponseDefinitive);
		// Read JSON response and print
		JSONObject myResponse = new JSONObject(maReponseDefinitive);
		System.out.println("result after Reading JSON Response");
		System.out.println(maReponseDefinitive);
		
		return myResponse;
		}
}
