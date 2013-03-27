package com.spring.util;

public class EscapeTool extends org.apache.velocity.tools.generic.EscapeTool {

	public EscapeTool() { 
		
	}
	
	public String html(Object string) { 
		String s = "";
		if (string == null) { 
			return s;
		} else { 
			s = String.valueOf(string);
			s = s.replaceAll("&", "&amp;");
			s = s.replaceAll("\'", "&#039;");
			s = s.replaceAll("\"", "&#34;");
			s = s.replaceAll("<", "&lt;");
			s = s.replaceAll(">", "&gt;");
			
			//return super.html(StringUtil.unescape(string.toString()));
		}
		return s;
	}
	
}
