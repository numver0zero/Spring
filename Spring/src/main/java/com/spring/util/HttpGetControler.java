package com.spring.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class HttpGetControler {

	/*URL m_szUrl = null;
	String l_szLocal = "UTF-8";

	public HttpGetControler(String pszUrl) {
		try {
			this.m_szUrl = new URL(pszUrl);
		} catch (Exception e) {}
	}

	public String getHtmlMessage() {
		StringBuffer buffer = new StringBuffer();
		
		try {
			URLConnection con = m_szUrl.openConnection();
			con.setUseCaches(false);
			
			InputStream in = con.getInputStream();

			Reader reader = new InputStreamReader(in, l_szLocal);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line = "";

			while ((line = bufferedReader.readLine()) != null) {
				buffer.append((line)).append("\n");
			}
			bufferedReader.close();
			reader.close();

			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return buffer.toString();
	}
	
	public void request(String method, String xml){
		
		String body = xml;
		
		try {
			HttpURLConnection huc = (HttpURLConnection)m_szUrl.openConnection();
			huc.setRequestMethod(method);
			huc.setDoInput(true);
			huc.setDoOutput(true);
			
			huc.setRequestProperty("Content-Type" , "application/x-www-form-urlencoded");
			
			OutputStream os = huc.getOutputStream();
			
			Writer writer = new OutputStreamWriter(os, l_szLocal);
			
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			bufferedWriter.write(URLEncoder.encode(body,"UTF-8"));
			bufferedWriter.flush();
			bufferedWriter.close();
			
			OutputStream os = huc.getOutputStream();
			os.write(body.getBytes(l_szLocal));
			os.flush();
			os.close();
			
			InputStreamReader isr = new InputStreamReader(huc.getInputStream());
			BufferedReader br = new BufferedReader(isr);

			while (br.readLine() != null) {}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	URL m_szUrl = null;
	String l_szLocal = "UTF-8";

	public HttpGetControler(String pszUrl) {
		try {
			this.m_szUrl = new URL(pszUrl);
		} catch (Exception e) {}
	}

	public String getHtmlMessage() {
		StringBuffer buffer = new StringBuffer();
		
		try {
			URLConnection con = m_szUrl.openConnection();
			con.setUseCaches(false);
			
			InputStream in = con.getInputStream();

			Reader reader = new InputStreamReader(in, l_szLocal);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line = "";

			while ((line = bufferedReader.readLine()) != null) {
				buffer.append((line)).append("\n");
			}
			bufferedReader.close();
			reader.close();

			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return buffer.toString();
	}
	
	public String getHtmlOcbMessage() {
		StringBuffer buffer = new StringBuffer();
		
		try {
			URLConnection con = m_szUrl.openConnection();
			con.setUseCaches(false);
			
			InputStream in = con.getInputStream();

			Reader reader = new InputStreamReader(in, "EUC_KR");
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line = "";

			while ((line = bufferedReader.readLine()) != null) {
				buffer.append((line)).append("\n");
			}
			bufferedReader.close();
			reader.close();

			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return buffer.toString();
	}	
	
	public String request(String method, String xml){
		
		String body = xml;
		StringBuffer buffer = new StringBuffer();
		
		try {
		    	
			HttpURLConnection huc = (HttpURLConnection)m_szUrl.openConnection();
			
			huc.setRequestMethod(method);
			
			huc.setDoInput(true);
			huc.setDoOutput(true);
			
			huc.setRequestProperty("Content-Type" , "application/x-www-form-urlencoded");
			OutputStream os = huc.getOutputStream();
			Writer writer = new OutputStreamWriter(os, l_szLocal);
			
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			bufferedWriter.write(URLEncoder.encode(body,"UTF-8"));
			bufferedWriter.flush();
			bufferedWriter.close();
			
			/*OutputStream os = huc.getOutputStream();
			os.write(body.getBytes(l_szLocal));
			os.flush();
			os.close();*/
			
			InputStream in = huc.getInputStream();

			Reader reader = new InputStreamReader(in, l_szLocal);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line = "";

			while ((line = bufferedReader.readLine()) != null) {
				buffer.append((line)).append("\n");
			}
			
			
			bufferedReader.close();
			reader.close();

			in.close();
			/*
			InputStreamReader isr = new InputStreamReader(huc.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			
			String text;
			while ( (text=br.readLine())!= null) {
				sb.append(text);
			}
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return buffer.toString();
	}
}