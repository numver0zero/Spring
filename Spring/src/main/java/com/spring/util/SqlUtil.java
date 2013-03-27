package com.spring.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class SqlUtil {

	public static String escape(String s) { 
		if (s == null)
			return s;
		
        s = s.replaceAll("'", "\\\\'");
        s = s.replaceAll("\"", "\\\\\"");
        s = s.replaceAll("_", "\\\\_");
        
        return s;
	}
	
	public static String unescape(String s) { 
		if (s == null)
			return s;
		
        s = s.replaceAll("\\\\'", "'");
        s = s.replaceAll("\\\\\"", "\"");
        s = s.replaceAll("\\\\_", "_");
        
        return s;
	}

	public static HashMap<String, Object> escape(HashMap<String, Object> map) { 
		if (map == null || map.isEmpty())
			return map;
		
		Set<String> keys = map.keySet(); 
		Iterator<String> keyIter = keys.iterator();
		while (keyIter.hasNext()) {
		   String key = keyIter.next(); 
		   Object value = map.get(key);
		   if (value instanceof String)
			   map.put(key, escape(value.toString()));
		}
		
		return map;
	}
	
	public static HashMap<String, Object> unescape(HashMap<String, Object> map) { 
		if (map == null || map.isEmpty())
			return map;
		
		Set<String> keys = map.keySet(); 
		Iterator<String> keyIter = keys.iterator();
		while (keyIter.hasNext()) {
		   String key = keyIter.next(); 
		   Object value = map.get(key);
		   if (value instanceof String)
			   map.put(key, unescape(value.toString()));
		}
		
		return map;
	}

}
