package com.spring.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class HotelJsonConnect {

	public static String getHotelJson(String hostURL, String param) {
		
		System.out.println("Out : ");
		
		System.out.println("Input parameter : " + param);
		System.out.println("Default parameter : countryCode=JP&cityCode=993^093^&checkIn=2010-05-28&checkOut=2010-06-04&duration=7&roomCount=1&star=&hotelName=");
		
		//String param = "countryCode=JP&cityCode=993^093^&checkIn=2010-05-28&checkOut=2010-06-04&duration=7&roomCount=1&star=&hotelName=";
		
		//String hostURL = "http://203.235.206.18:8080/travel-hotel/searchHotelList.json";
		
		StringBuffer outData = new StringBuffer();
		
		try {
		
		URL url = new URL(hostURL);
		
		URLConnection conn = url.openConnection();
		conn.setDoOutput(true);
		conn.setUseCaches(false);
		conn.setRequestProperty("content-type","application/x-www-form-urlencoded");
		
		DataOutputStream dataOutputStream = new DataOutputStream(conn.getOutputStream());
		dataOutputStream.write(param.getBytes());
		dataOutputStream.flush();
		dataOutputStream.close();
		
		InputStream in = conn.getInputStream() ;
		BufferedReader reader=new BufferedReader(new InputStreamReader(in, "UTF-8"));
		String line=null;
		
		
		
		while((line=reader.readLine()) !=null) {
			
			outData.append(line);
		}
		reader.close(); 
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return outData.toString();
	}
}
