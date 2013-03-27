package com.spring.util;

import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.MalformedURLException;
import javax.servlet.http.HttpServletResponse;

public class FileDownloadUtil {
	
	public static void setUrlFileWrite(HttpServletResponse response, String fullUrl, String saveFileName ) {
    	java.net.URL url = null; 
        try{ 
             url = new java.net.URL(fullUrl ); 
        }catch(MalformedURLException e){ 
             e.printStackTrace(); 
        } 
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition","attachment; filename="+saveFileName);

        BufferedInputStream bin = null;
        BufferedOutputStream bos = null;

		byte[] b = new byte[5 * 1024 * 1024];

        try {
            bin = new BufferedInputStream(url.openConnection().getInputStream());
            bos = new BufferedOutputStream( response.getOutputStream());

            int i=0;
            while ((i = bin.read(b)) != -1){
				bos.write(b,0,i); 
			}
            bos.flush();                 
             
            if(bos != null) bos.close();
            if(bin != null) bin.close();
     
        } catch(IOException e) {
        	e.printStackTrace();
        } finally {
			if(bos != null)	try{ bos.close();	}catch(IOException e){}
			if(bin != null)	try{ bin.close();	}catch(IOException e){}
        } 		
	}
}
