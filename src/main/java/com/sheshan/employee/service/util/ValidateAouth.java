package com.sheshan.employee.service.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


import com.google.gson.Gson;
import com.sheshan.employee.service.dto.EmployeeGoogleProfile;



public class ValidateAouth {
	
	private final String USER_AGENT = "Mozilla/5.0";
	String CLIENT_ID = "";
	
	public EmployeeGoogleProfile validateIdToken(String idTokenString){

		String url = "https://www.googleapis.com/oauth2/v3/tokeninfo?id_token="+idTokenString;
		try{
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		// optional default is GET
		con.setRequestMethod("GET");
		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		Gson g = new Gson();
		EmployeeGoogleProfile loggedUser = g.fromJson(response.toString(), EmployeeGoogleProfile.class);
		System.out.println(loggedUser.getName());

		return loggedUser;

		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
