package com.spring.util;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SimpleTimeZone;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.spring.util.StringUtil;

public class StringTool {
	
	public StringTool() {

	}

	public String cut(Object string, int i) {
		return cut(string, i, "");
	}

	public String cut(Object string, int i, String add) {
		if (string == null)
			return "";
		String s = String.valueOf(string);
		String s1 = StringUtil.cut(s, i);

		if (add != null && !s.equals(s1))
			s1 = s1 + add;

		return s1;
	}
	
	public int indexOf(String s, String v) {
		int i = -1;
		if (s == null){
			return -1;
		}else {
			i = s.indexOf(v);
		}

		return i;
	}
	
	 public String replace(Object string, Object string1, Object string2) {
		    if(string == null || string1 == null || string2 == null)
	            return "";

		    String s = String.valueOf(string);
		    String s1 = String.valueOf(string1);
		    String s2 = String.valueOf(string2);

		    StringBuffer stringbuffer = new StringBuffer();
	        int i = s1.length();
	        int j = 0;
	        for(int k = 0; (k = s.indexOf(s1, j)) != -1;)
	        {
	            stringbuffer.append(s.substring(j, k)).append(s2);
	            j = k + i;
	        }

	        stringbuffer.append(s.substring(j));
	        return stringbuffer.toString();
	    }

	    public static String htmlspecialchars(Object string) {

	    	String msg = String.valueOf(string);
	        String retStr = msg;
	        if (retStr == null ) retStr = "";
	        retStr = retStr.replace("&amp;", "＆");
	        retStr = retStr.replace("%", "％");
	        return retStr;
	    }

		public String upperCase(Object string) {
			if (string == null)
				return "";
			return String.valueOf(string).toUpperCase();
		}

		public String lowerCase(Object string) {
			if (string == null)
				return "";
			return String.valueOf(string).toLowerCase();
		}

		public String marker(Object string, String startFirstLast, int markers) {
			return marker(string, "*", startFirstLast, markers);
		}

		public String marker(Object string, String marker, String startFirstLast, int markers) {
			if (string == null)
				return "";

			if (markers == 0)
				return string.toString();

			int len = string.toString().length();

			StringBuffer sb = new StringBuffer();

			if (markers > len) {
				for (int i=0; i<markers; i++) {
					sb.append("*");
				}
				return sb.toString();
			}

			if ("first".equals(startFirstLast)) {
				for (int i=0; i<markers; i++) {
					sb.append("*");
				}
				sb.append(string.toString().substring(markers, len));
			} else if ("last".equals(startFirstLast)) {
				sb.append(string.toString().substring(0, len - markers));
				for (int i=0; i<markers; i++) {
					sb.append("*");
				}
			}

			return sb.toString();
		}
		
		public String[] tokenize(Object string, String delim) {
			if (string == null)
				return new String[]{};

			String[] list = StringUtil.divideStringArray(string.toString(), delim);

			return list;
		}

		public String substring(Object string, int beginIndex, int endIndex) {
			if (string == null)
				return "";
			return string.toString().substring(beginIndex, endIndex);
		}

		public String toString(Object string) {
			return string.toString();
		}

		public int stringLen(String str){

		    return str.length();
		}

		/**
		 * Map에서 KEY로 VALUE 리턴
		 * @param Map,String
		 * @return String
		 */
		public static String getMapValue(Map<String, Object> map, String key) {
			String rntValue = "";
			if(map==null||"".equals(key)||key==null){
				return rntValue;
			}else{
				rntValue = map.get(key)==null?"":map.get(key).toString();
			}
			return rntValue;
		}
		
		/**
		 * 엔터를 br로 바꿈
		 * @param str
		 * @return str(String)
		 */
		public static String CarriageReturnDecorder(String str) {
			if(str==null) str="";
			str = str.replaceAll("\r\n", "<br>");
			str = str.replaceAll("\r\n", "<BR>");
			return str;
		}

		/**
		 * 아이디뒷자리 2Char를 **로 바꿈
		 * @param str
		 * @return str(String)
		 */
		public static String frontId(String str) {
			if(str==null||"".equals(str)){
				return "";
			}
			int strLength = str.length();
			String preStr = str.substring(0, strLength-2);
			String changedId = preStr+"**";

			return changedId;
		}

		/**
		 * br 태그를 엔터로 바꿈
		 * @param str
		 * @return str(String)
		 */
		public static String CarriageReturnEncoder(String str) {
			if(str==null) str="";
			str = str.replaceAll("<br>", "\r\n");
			str = str.replaceAll("<BR>", "\r\n");
			return str;
		}

		/**
		 * 엔터를 없앰
		 * @param str
		 * @return str(String)
		 */
		public static String CarriageReturnDelete(String str) {
			if(str==null) str="";
			str = str.replaceAll("\r\n", "");
			return str;
		}

	    /**
	     * @MethodName : addComma
	     * @작성일	   : 2010. 8. 30.
	     * @작성자	   : noirfleur
	     * @변경이력   :
	     * @Method설명 : 숫자에 3자리마다 , 추가
	     * @param String
	     * @return String
	     */
	    public static String addComma(String s) {
	    	String str = "";

	    	if (s!=null && !s.trim().equals("")) {
	    		if(s.indexOf(".") > 0)
	    			s = s.substring(0, s.indexOf("."));

	    		DecimalFormat df = new DecimalFormat("#,###,###");
	    		str = df.format(Long.parseLong(s));
	    	}

	    	return str;
	    }

	    public static String priceComma(int i) {
	    	NumberFormat nf = NumberFormat.getInstance();
	    	return nf.format(i);
	    }

	    public static int parseInt(String s) {
	    	int ps = 0;
	    	if(s!=null && !"".equals(s)){
	    		ps = Integer.parseInt(s);
	    	}
	    	return ps;
	    }

	    public static int salePercent(int actualPrice, int price) {
	    	double dd = Math.round( (double) actualPrice *100 / (double) price );
	    	int salePercent = 100 - (int)dd;
	    	if(actualPrice == price && actualPrice - price == 0){
	    		salePercent = 100;
	    	}
	    	return salePercent;
	    }

	    public static int salePrice(int actualPrice, int price) {
	    	int salePrice = price - actualPrice;
	    	if(actualPrice == price && actualPrice - price == 0){
	    		salePrice = price;
	    	}
	    	return salePrice;
	    }

	    public static String strDate(String s) {
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	    	Date nDate = new Date (s.replace("KST", "+0900"));
	    	String strDate = sdf.format(nDate);
	    	return strDate;
	    }

		/**
	     * @MethodName : HtmlTagClean
	     * @작성일	   : 2010. 4. 16.
	     * @작성자	   : 김성복
	     * @변경이력   :
	     * @Method설명 : html 태그 제거
	     * @param s
	     * @return String
	     */
	    public String HtmlTagClean(String s) {
	    	if (s == null) {
	    		return null;
	    	}

	    	s = s.replace("&nbsp;", " ");

	    	Matcher m;

	    	m = Patterns.SCRIPTS.matcher(s);
	    	s = m.replaceAll("");
	    	m = Patterns.STYLE.matcher(s);
	    	s = m.replaceAll("");
	    	m = Patterns.TAGS.matcher(s);
	    	s = m.replaceAll("");
	    	m = Patterns.ENTITY_REFS.matcher(s);
	    	s = m.replaceAll("");
	    	m = Patterns.WHITESPACE.matcher(s);
	    	s = m.replaceAll(" ");

	    	return s;
	    }
	    
	    /**
	     * @FileName	 : StringUtil.java
	     * @Project      : cla-madame-core
	     * @Date         : 2010. 4. 16.
	     * @작성자       : 김성복
	     * @변경이력	 :
	     * @프로그램설명 : HTML 제거 변경 패턴
	     */
	    private interface Patterns {
	    	// javascript tags and everything in between
	    	public static final Pattern SCRIPTS = Pattern.compile("<(no)?script[^>]*>.*?</(no)?script>", Pattern.DOTALL);

	    	public static final Pattern STYLE = Pattern.compile("<style[^>]*>.*</style>", Pattern.DOTALL);
	    	// HTML/XML tags

	    	public static final Pattern TAGS = Pattern.compile("<(\"[^\"]*\"|\'[^\']*\'|[^\'\">])*>");

	    	public static final Pattern nTAGS = Pattern.compile("<\\w+\\s+[^<]*\\s*>");
	    	// entity references
	    	public static final Pattern ENTITY_REFS = Pattern.compile("&[^;]+;");
	    	// repeated whitespace
	    	public static final Pattern WHITESPACE = Pattern.compile("\\s\\s+");
	    }

	    /**
	     * @MethodName : cutString
	     * @작성일	   : 2010. 4. 16.
	     * @작성자	   : 김성복
	     * @변경이력   :
	     * @Method설명 : 바이트로 글자수 자르기
	     * @param s
	     * @param len
	     * @param tail
	     * @return String
	     */
	    public static String cutString(String s, int len, String tail) {

	    	if (s == null || s.equals("")) {
	            return "";
	    	}

	    	String rs = "";

	    	try {

		        int srcLen = realLength(s);


		        if (srcLen < len)
		            return s;

		        String tmpTail = tail;
		        if (tail == null)
		            tmpTail = "";

		        int tailLen = realLength(tmpTail);
		        if (tailLen > len)
		            return "";

		        char a;
		        int i = 0;
		        int realLen = 0;
		        for (i = 0; i < len - tailLen && realLen < len - tailLen; i++) {
		           a = s.charAt(i);
		           if ((a & 0xFF00) == 0)
		               realLen += 1;
		           else
		               realLen += 3;
		        }

		        while (realLength(s.substring(0, i)) > len - tailLen) {
		            i--;
		        }

		        rs = s.substring(0, i) + tmpTail;

	    	} catch (Exception e) {
				e.printStackTrace(System.out);
			}

	    	return rs;
	    }
	    
	    /**
	     * @MethodName : cutString
	     * @작성일	   : 2011. 6. 2.
	     * @작성자	   : 서동훈
	     * @변경이력   :
	     * @Method설명 : 바이트로 글자수 자르기(영어길이 늘림)
	     * @param s
	     * @param len
	     * @param tail
	     * @return String
	     */
	    public static String cutString2(String s, int len, String tail) {

	    	if (s == null || s.equals("")) {
	    		return "";
	    	}

	    	String rs = "";

	    	try {

	    		int srcLen = realLength(s);

	    		//System.out.println(s + "'s length == " + srcLen);
	    		if (srcLen < len)
	    			return s;

	    		String tmpTail = tail;
	    		if (tail == null)
	    			tmpTail = "";

	    		int tailLen = realLength(tmpTail);
	    		if (tailLen > len)
	    			return "";

	    		char a;
	    		int i = 0;
	    		int realLen = 0;
	    		for (i = 0; i < len - tailLen && realLen < len - tailLen; i++) {
	    			a = s.charAt(i);
	    			//System.out.println("a == " + a);
	    			//System.out.println((a & 0xFF00) == 0);
	    			if ((a & 0xFF00) == 0)
	    				realLen += 2;
	    			else
	    				realLen += 3;
	    		}

	    		while (realLength(s.substring(0, i)) > len - tailLen) {
	    			i--;
	    		}

	    		rs = s.substring(0, i) + tmpTail;

	    	} catch (Exception e) {
	    		e.printStackTrace(System.out);
	    	}

	    	return rs;
	    }

	    /**
	     * @MethodName : realLength
	     * @작성일	   : 2010. 4. 16.
	     * @작성자	   : 김성복
	     * @변경이력   :
	     * @Method설명 : string 의 바이트를 구한다
	     * @param s
	     * @return int
	     * @throws UnsupportedEncodingException
	     */
	    public static int realLength(String s) throws UnsupportedEncodingException {
	        return s.getBytes("utf-8").length;
	    }

	    /**
	     * @MethodName : extractCityName
	     * @작성일	   : 2010. 12. 07.
	     * @작성자	   : noirfleur
	     * @변경이력   :
	     * @Method설명 : 토큰에서 % 앞의 도시명만 리턴
	     * @param s
	     * @return String
	     */
	    public static String extractCityName(String s){
	    	String rtStr = "";
	    	if("".equals(s)||s==null){
	    		return rtStr;
	    	}else{
	    		rtStr = s.substring(0, s.indexOf('%'));
	    	}
	    	return rtStr;
	    }

	    /**
	     * @MethodName : splitCityNameToken
	     * @작성일	   : 2010. 12. 07.
	     * @작성자	   : noirfleur
	     * @변경이력   :
	     * @Method설명 :
	     * @param s
	     * @return String
	     */
	    public static String[] splitCityNameToken(String s){
	    	String str = "";
	    	String[] rtStr = {""};
	    	if("".equals(s)||s==null){
	    		return rtStr;
	    	}else{
	    		str = s.substring(s.indexOf('%')+1, s.length());
	    		rtStr = str.split("\\|");
	    	}
	    	return rtStr;
	    }
	    
	    /**
	     * @MethodName : addLineEndString
	     * @작성일	   : 2010. 4. 16.
	     * @작성자	   : 김성복
	     * @변경이력   :
	     * @Method설명 : 바이트 단위로 문자열 추가
	     * @param str
	     * @param len
	     * @param addStr
	     * @return String
	     */
	    public static String addLineEndString(String str, int len, String addStr){
			if(str == null) return "";

			char[] charArray = str.toCharArray();

			StringBuffer returnStr = new StringBuffer("");
			int byteSize = 0;

			for(int i=0; i< str.length(); i++){
				if(charArray[i] <256){
					byteSize += 1;
				}else{
					byteSize += 2;
				}

				if(byteSize >= len){
					byteSize = 0;
					returnStr.append(charArray[i]).append(addStr);
				}else{
					returnStr.append(charArray[i]);
				}

			}

			return returnStr.toString();
	    }
	    
	    /**
	     * 문자열을 받아들여 &, ", \, <, > 등의 문자를 &amp;, &quot;, &#039, &lt; , &gt;로 변경한다.
	     * @param msg 변경할 문자열
	     * @return 변경된 문자열
	     */
		public static String specialChar(String msg) {
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < msg.length(); i++) {
	            if (" ".equals(msg.charAt(i))) {
	                sb.append("&nbsp;");
	            } else if (msg.charAt(i) == '&') {
	                sb.append("&amp;");
	            } else if (msg.charAt(i) == '"') {
	                sb.append("&quot;");
	            } else if (msg.charAt(i) == '\'') {
	                sb.append("&#039;");
	            } else if (msg.charAt(i) == '<') {
	                sb.append("&lt;");
	            } else if (msg.charAt(i) == '>') {
	                sb.append("&gt;");

	            } else {
	                sb.append(msg.charAt(i));
	            }
	        }
	        return sb.toString();
	    }

		/**
		 * 이전/이후달 날짜반환
		 * @param str
		 * @return 날짜포맷
		 */
		public static String getMonthAgo(String format, int ago) {
			  Calendar cal = Calendar.getInstance(new SimpleTimeZone(0x1ee6280, "KST"));
			  cal.add(Calendar.MONTH ,-1);
			  java.util.Date monthago = cal.getTime();
			  SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.getDefault());
			  return formatter.format(monthago);
		}

		/**
		 * 지난달인지 여부(여행전용)
		 * @param str 날짜(yyyyMMdd)
		 * @return true/false
		 */
		public static boolean isOneMonthAgo(String today, String curDate) {

			  int todayInt = Integer.parseInt(today);
			  int curDateInt = Integer.parseInt(curDate);
			  boolean flag = false;
			  if(todayInt>curDateInt){
				  flag = true;
			  }
			  return flag;
		} 
		
		/**
		 * 한글값을 url 주소로 받을 수 있게 디코딩 함
		 * @param str
		 * @return 디코딩된 문자열
		 */
		public static String URLDecoder(String str) {
			String decodeStr = "";
			try {
				if(str==null) {
					str = "";
				}
				decodeStr = URLDecoder.decode(str, "UTF-8");
			} catch(UnsupportedEncodingException ex) {
				ex.printStackTrace(System.out);
				return null;
			}
			return decodeStr;
		}


		/**
		 * 날자를 원하는 포멧으로 반환한다
		 * @param sDate yyyyMMdd or yyyy-MM-dd
		 * @param delim ex("-")
		 * @return String delim format 형식으로 리턴
		 */
		public static String getDateFormat(String sDate, String delim) {
			//yyyyMMdd 이거나 yyyy-MM-dd 가 아니면 0리턴
			if(sDate == null || (sDate.length() != 8 && sDate.length() != 10) || (sDate.length() == 10 && sDate.indexOf("-") == -1)) {
				return "";
			}
			sDate = sDate.replaceAll("-", "");

			String yyyy = sDate.substring(0, 4);
			String MM = sDate.substring(4, 6);
			String dd = sDate.substring(6, 8);

			String dateFormat = yyyy + delim + MM + delim + dd;

			return dateFormat;

		}

		/**
		 * 날자 및 시간을 원하는 포멧으로 반환한다 (yyyy-MM-dd HH:mm:ss)
		 * @param dFormat
		 * yyyy 년, MM 월, dd 일
		 * HH 24시, mm 분, ss 초
		 * aa 오전/오후, hh 12시
		 * ww 년에 있어서 주(수치)
		 * DDD 년에 있어서 날(수치)
		 * F 월에 있어서 요일(수치)
		 * @return String
		 */
		public static String getDateTimeFormat(String sDateTime) {

			String	dFormat = "yyyy-MM-dd HH:mm:ss";


			sDateTime = sDateTime.replaceAll("-", "");
			sDateTime = sDateTime.replaceAll(":", "");
			sDateTime = sDateTime.replaceAll(" ", "");
			if(sDateTime.length() != 14) {
				return "";
			} else {
				String yyyy = sDateTime.substring(0, 4);
				String MM = sDateTime.substring(4, 6);
				String dd = sDateTime.substring(6, 8);
				String hh = sDateTime.substring(8, 10);
				String mm = sDateTime.substring(10, 12);
				String ss = sDateTime.substring(12, 14);
				Calendar cal = Calendar.getInstance();
				cal.set(Integer.parseInt(yyyy), Integer.parseInt(MM)-1, Integer.parseInt(dd), Integer.parseInt(hh), Integer.parseInt(mm), Integer.parseInt(ss)); //년월일시분초셋팅
				SimpleDateFormat formatter = new SimpleDateFormat(dFormat);
				return formatter.format(cal.getTime());
			}
		}

		/**
		 * 두날짜의 간격을 계산한다
		 *
		 * @param startDate yyyyMMdd or yyyy-MM-dd
		 * @param endDate yyyyMMdd or yyyy-MM-dd
		 * @param type 어느것을 계산할 것인가("YEAR" : 년도, "MONTH" : 월, "DAY":일)
		 * @return int 날짜간의 차이 (오류시 -1)
		 */
		public static int dateDiff(String startDate, String endDate, String type) {
			if(startDate == null || endDate == null || startDate.equals("") || endDate.equals("")
					|| (startDate.length() != 8 && startDate.length() != 10) || (startDate.length() == 10 && startDate.indexOf("-") == -1)
					|| (endDate.length() != 8 && endDate.length() != 10) || (endDate.length() == 10 && endDate.indexOf("-") == -1)) {
				return -1;
			}

			startDate = startDate.replaceAll("-", "");
			endDate = endDate.replaceAll("-", "");

			if("YEAR".equals(type.toUpperCase())) {
				return Integer.parseInt(startDate.substring(0, 4)) - Integer.parseInt(endDate.substring(0, 4));
			} else if ("MONTH".equals(type.toUpperCase())) {
				return (Integer.parseInt(startDate.substring(0, 4)) - Integer.parseInt(startDate.substring(0, 4))) * 12
						+ (Integer.parseInt(endDate.substring(4, 6)) - Integer.parseInt(endDate.substring(4, 6)));
			} else if("DAY".equals(type.toUpperCase())) {
				Calendar cal = Calendar.getInstance();
				Calendar cal2 = Calendar.getInstance();
				cal.set(Integer.parseInt(startDate.substring(0, 4)), Integer.parseInt(startDate.substring(4, 6)) - 1, Integer.parseInt(startDate.substring(6, 8)));
				cal2.set(Integer.parseInt(endDate.substring(0, 4)), Integer.parseInt(endDate.substring(4, 6)) - 1, Integer.parseInt(endDate.substring(6, 8)));
				return (int)Math.floor(Math.abs(cal2.getTime().getTime() - cal.getTime().getTime()) / 0x5265c00L);
			} else {
				return -1;
			}
		}


		public String getBlogClass(String jrefBlogUrl) {
	    	String jrefBlogClass = "";

	    	if(jrefBlogUrl == null) {
	    		jrefBlogUrl = "";
	    	}

	    	if("".equals(jrefBlogUrl)){
	    		jrefBlogClass = "";
	    	}else{
		    	if(jrefBlogUrl.indexOf("naver.com") > -1) {
		    		jrefBlogClass = "class='naver'";
		    	} else if(jrefBlogUrl.indexOf("blog.me") > -1) {
		    		jrefBlogClass = "class='naver'";
		    	} else if(jrefBlogUrl.indexOf("daum.net") > -1) {
		    		jrefBlogClass = "class='daum'";
		    	} else if(jrefBlogUrl.indexOf("dreamwiz.com") > -1) {
		    		jrefBlogClass = "class='dreamwiz'";
		    	} else if(jrefBlogUrl.indexOf("paran.com") > -1) {
		    		jrefBlogClass = "class='paran'";
		    	} else {
		    		jrefBlogClass = "class='etc'";
		    	}
	    	}
	    	return jrefBlogClass;

	    }

	    public String replace(String originString, String oldChar, String newChar) {
	    	if(originString == null) {
	    		return "";
	    	} else {
	    		return originString.replace(oldChar, newChar);
	    	}
	    }

		/**
		 * largeClassSeq로 largeClass한글명 리턴
		 *
		 * @param largeClassSeq
		 * @return largeClassName
		 */
	    public String largeClassName(String largeClassSeq) {
	    	String largeClassName = "";

	    	if(largeClassSeq == null||"".equals(largeClassSeq)) {
	    		return "";
	    	} else {
	    		if("1".equals(largeClassSeq)){
	    			largeClassName = "즐길꺼리";
	    		}else if("2".equals(largeClassSeq)){
	    			largeClassName = "숙소";
	    		}else if("3".equals(largeClassSeq)){
	    			largeClassName = "쇼핑";
	    		}else if("4".equals(largeClassSeq)){
	    			largeClassName = "명소";
	    		}else if("5".equals(largeClassSeq)){
	    			largeClassName = "맛집";
	    		}
	    		return largeClassName;
	    	}
	    }


	    /**
	     * smallClassSeq로 smallClass한글명 리턴
	     *
	     * @param smallClassSeq
	     * @return smallClassName
	     */
	    public String smallClassName(String smallClassSeq) {
	    	String smallClassName = "";

	    	if(smallClassSeq == null||"".equals(smallClassSeq)) {
	    		return "";
	    	} else {
	    		HashMap<String, Object> map = new HashMap<String, Object>();
	    		map.put("1", "현지음식");
	    		map.put("2", "레스토랑");
	    		map.put("3", "카페/디저트");
	    		map.put("4", "바/펍/호프");
	    		map.put("5", "패스트푸드/빵");
	    		map.put("6", "한식");
	    		map.put("7", "기타 맛집");
	    		map.put("8", "추천 맛집");
	    		map.put("9", "미술관/박물관");
	    		map.put("10", "건축물/유적");
	    		map.put("11", "공원/동식물원");
	    		map.put("12", "성당/교회/사원");
	    		map.put("13", "거리/광장");
	    		map.put("14", "궁전/왕궁");
	    		map.put("15", "기타 명소");
	    		map.put("16", "추천 명소");
	    		map.put("17", "백화점/면세점/쇼핑몰");
	    		map.put("18", "패션/화장품/잡화");
	    		map.put("19", "식품/슈퍼/할인마트");
	    		map.put("20", "재래시장/벼룩시장");
	    		map.put("21", "서점/기념품");
	    		map.put("22", "명품숍/아울렛");
	    		map.put("23", "기타 쇼핑");
	    		map.put("24", "추천 쇼핑");
	    		map.put("25", "호텔");
	    		map.put("26", "호스텔");
	    		map.put("27", "민박/게스트하우스");
	    		map.put("28", "리조트");
	    		map.put("29", "이색 숙소");
	    		map.put("30", "부티크 호텔");
	    		map.put("31", "추천 숙소");
	    		map.put("32", "클럽/라이브바");
	    		map.put("33", "뮤지컬/오페라/공연");
	    		map.put("34", "레포츠");
	    		map.put("35", "테마파크/카지노");
	    		map.put("36", "기타");
	    		map.put("37", "추천 즐길거리");
	    		smallClassName = (String)map.get(smallClassSeq);
	    		}

	   		return smallClassName;
	    }

		/**
		 * 한글국가명으로 한글대륙명 리턴
		 *
		 * @param nationKorName
		 * @return continentKorName
		 */
	    public String continentName(String nationName) {
	    	String europe = "영국프랑스이태리스위스네덜란드독일체코헝가리오스트리아스페인그리스터키크로아티아핀란드스웨덴덴마크";
	    	String asia = "중국싱가포르태국타이완캄보디아베트남필리핀몰디브인도네시아일본말레이시아";
	    	String america = "미국캐나다";
	    	String oceania = "호주뉴질랜드뉴칼레도니아";
	    	String africa = "남아공";
	    	String continentKorName = "";

	    	if(nationName == null) {
	    		return "";
	    	} else {
	    		if(-1 != europe.indexOf(nationName)){
	    			continentKorName = "유럽";
	    		}else if(-1 != asia.indexOf(nationName)){
	    			continentKorName = "아시아";
	    		}else if(-1 != america.indexOf(nationName)){
	    			continentKorName = "아메리카";
	    		}else if(-1 != oceania.indexOf(nationName)){
	    			continentKorName = "오세아니아";
	    		}else if(-1 != africa.indexOf(nationName)){
	    			continentKorName = "아프리카";
	    		}
	    		return continentKorName;
	    	}
	    }

	    /**
	     * 한글시티명으로 한글국가명 리턴
	     *
	     * @param cityKorName
	     * @return nationKorName
	     */
	    public String nationName(String cityName) {
	    	String nationKorName = "";

	    	String nations[][] = {{"중국","베이징상하이홍콩마카오"},{"싱가포르","싱가포르"},{"태국","방콕푸켓파타야(코)사무이"},{"타이완","타이페이"}
	    	,{"캄보디아","씨엠립(앙코르왓)"},{"베트남","하노이호치민"},{"필리핀","마닐라보라카이세부"},{"몰디브","몰디브"},{"인도네시아","발리"},{"일본","도쿄오사카교토후쿠오카유후인나고야삿포로요코하마"}
	    	,{"영국","런던에딘버러"},{"프랑스","파리니스"},{"이태리","로마베네치아피렌체밀라노"},{"스위스","루체른인터라켄취리히"},{"네덜란드","암스테르담"}
	    	,{"독일","뮌헨프랑크푸르트"},{"체코","프라하"},{"헝가리","부다페스트"}, {"오스트리아","비엔나잘츠부르크"},{"스페인","바르셀로나"},{"그리스","산토리니아테네"}
	    	,{"터키","이스탄불카파도키아"},{"크로아티아","두브로브니크"},{"미국","뉴욕샌프란시스코라스베가스사이판괌하와이"},{"캐나다","벤쿠버"},{"호주","시드니브리즈번퍼스"}
	    	,{"뉴질랜드","뉴질랜드"},{"남아공","케이프타운요하네스버그"},{"핀란드","헬싱키"},{"스웨덴","스톡홀름"},{"덴마크","코펜하겐"},{"말레이시아","코타키나발루"},{"뉴칼레도니아","뉴칼레도니아"}};

	    	if(cityName == null) {
	    		return "";
	    	} else {
	    		int arrSize = nations.length;
	    		for(int i=0;i<arrSize;i++){
	    			if(-1!=nations[i][1].indexOf(cityName)){
	    				nationKorName = nations[i][0];
	    			}
	    		}
	    		return nationKorName;
	    	}
	    }

	    /**
	     * section_code로 항공사아이콘 클래스
	     * @param sectionCd
	     * @return continentKorName
	     */
	    public String airArticleClass(String sectionCd) {

	    	String _class = "";
	    	if("1".equals(sectionCd)){_class="GIA";
	    	}else if("2".equals(sectionCd)){_class="DAL";
	    	}else if("3".equals(sectionCd)){_class="KAL";
	    	}else if("4".equals(sectionCd)){_class="DLH";
	    	}else if("5".equals(sectionCd)){_class="MAS";
	    	}else if("6".equals(sectionCd)){_class="HVN";
	    	}else if("7".equals(sectionCd)){_class="CEB";
	    	}else if("8".equals(sectionCd)){_class="SIA";
	    	}else if("9".equals(sectionCd)){_class="AAR";
	    	}else if("10".equals(sectionCd)){_class="UAE";
	    	}else if("11".equals(sectionCd)){_class="EVA";
	    	}else if("12".equals(sectionCd)){_class="AMU";
	    	}else if("13".equals(sectionCd)){_class="ACA";
	    	}else if("14".equals(sectionCd)){_class="AFR";
	    	}else if("15".equals(sectionCd)){_class="AFL";
	    	}else if("16".equals(sectionCd)){_class="OEA";
	    	}else if("17".equals(sectionCd)){_class="JAL";
	    	}else if("18".equals(sectionCd)){_class="ANA";
	    	}else if("19".equals(sectionCd)){_class="CES";
	    	}else if("20".equals(sectionCd)){_class="QTR";
	    	}else if("21".equals(sectionCd)){_class="CPA";
	    	}else if("22".equals(sectionCd)){_class="KLM";
	    	}else if("23".equals(sectionCd)){_class="THA";
	    	}else if("24".equals(sectionCd)){_class="THY";
	    	}else if("25".equals(sectionCd)){_class="FIN";
	    	}else if("26".equals(sectionCd)){_class="PAL";
	    	}else if("27".equals(sectionCd)){_class="ZIN";
	    	}
	    	return _class;
	    }

	    /**
	     * content에서 파싱한 이미지List에서 필터에 해당하는 첫번째 이미지url 리턴
	     * @param images
	     * @return url
	     */
	    public String getOneImage(List images){
	    	String filter = "file.pickl";
	    	int _size = 0;
	    	if(images==null){
	    		return "";
	    	}else{
	    		_size = images.size();
	    		String url = "";
	    		for(int i=0;i<_size;i++){
	    			url = (String)images.get(i);
	    			if(-1<url.indexOf(filter)){
	    				break;
	    			}
	    		}
	    		return url;
	    	}
	    }


	    public String firstTokenStr(String orgStr, String firToken) {
	    	String resultStr = "";
	    	int firIdx = 0;

	    	if (orgStr!=null && !"".equals(orgStr)) {
	    		firIdx = orgStr.indexOf(firToken);

	    		if (firIdx>0) {
	    			resultStr = orgStr.substring(0, firIdx);
	    		}
	    	}

	    	return resultStr;
	    }

	    public String getImgGUrl(String preFixUrl, String orgUrl, String firToken) {   	//ex) firToken==http://
	    	String resultStr = "";
	    	int firIdx = 0;

	    	if (orgUrl!=null && !"".equals(orgUrl)) {
	    		firIdx = orgUrl.indexOf(firToken);

	    		if (firIdx>0) {
	    			resultStr = orgUrl;
	    		} else {
	    			resultStr = preFixUrl + orgUrl;
	    		}
	    	}
	    	return resultStr;
	    }


	    public String getMakeStr(String str, int cutNumber){
		String makeStr = "";
		if(!("").equals(str) && str != null){
		    int strTotLen = str.length();

		    int searchZone = str.indexOf("<strong>"); // 일치한 문구가 있는곳

		    if(searchZone > cutNumber){ // 일치한 문구의 위치가 280자 이상일경우
			makeStr = str.substring(searchZone-cutNumber);
		    }else{
			makeStr = str;
		    }
		}
		makeStr = cutString(makeStr, 480, "...");
		return makeStr;
	    }

	    public String removeTag(String htmlValue){

		  StringBuffer sb = new StringBuffer(htmlValue);
		  int start = -1;
		  int end = -1;

		  /*
		  start = sb.indexOf("<");
		  end = sb.indexOf(">");

		  while(start > -1 && end > -1){
		   sb.delete(start, end+1);

		   start = sb.indexOf("<");
		   end = sb.indexOf(">");
		  }
		  */
		  start = sb.indexOf("&lt;");
		  end = sb.indexOf("&gt;");

		  while(start > -1 && end > -1){
		   sb.delete(start, end+1);

		   start = sb.indexOf("&lt;");
		   end = sb.indexOf("&gt;");
		  }

		  sb.toString().replaceAll("&lt;", "");
		  sb.toString().replaceAll("&gt;", "");
		  sb.toString().replaceAll("lt;", "");
		  sb.toString().replaceAll("gt;", "");
		  sb.toString().replaceAll("&nbsp;", "");
		  return sb.toString();
	    }

	    public static String nvl(String str, String newStr) {
	        if(str == null || str.trim().equals("")) {
	            return newStr;
	        } else {
	            return str;
	        }
	    }

	    public static String weddingFlashText(String str) {

	    	if(str != null && str.lastIndexOf("/") > -1 && str.length() == (str.lastIndexOf("/")+1)) {
	    		str = str.substring(0, str.lastIndexOf("/"));
			}
	    	if(str != null && str.lastIndexOf(",") > -1 && str.length() == (str.lastIndexOf(",")+2)) {
	    		str = str.substring(0, str.lastIndexOf(","));
			}

	    	return str;
	    }

	    public static String[][] MALL_NAME_URL = new String[][] {
	    	{"디앤샵",".dnshop.com","1"},
	    	{"신세계몰","mall.shinsegae.com","2"},
	    	{"하프클럽",".halfclub.com","3"},
	    	{"오가게",".ogage.co.kr","4"},
	    	{"보리보리",".boribori.co.kr","5"},
	    	{"롯데아이몰",".lotteimall.com","6"},
	    	{"인터파크",".interpark.com","7"},
	    	{"OTTO",".otto.kr","8"},
	    	{"위즈위드",".wizwid.com","9"},
	    	{"스킨Rx",".skinrx.co.kr","10"},
	    	{"아이스타일24",".istyle24.com","11"},
	    	{"푸드마트",".foodmart.co.kr","12"},
	    	{"NS이숍",".nseshop.com","13"},
	    	{"AKmall",".akmall.com","14"},
	    	{"CJmall",".cjmall.com","15"},
	    	{"LG패션",".lgfashionshop.com","16"},
	    	{"2001아울렛",".2001outlet.com","17"},
	    	{"아이하우스","shop.iehouse.co.kr","18"},
	    	{"다원몰",".dawonmall.com","19"},
	    	{"1300K",".1300k.com","20"},
	    	{"1200m",".1200m.com","21"},
	    	{"10Q",".10q.co.kr","22"},
	    	{"GSshop",".gsshop.com","23"},
	    	{"기탄상상몰","mall.gitan.co.kr","24"},
	    	{"패션플러스",".fashionplus.co.kr","25"},
	    	{"엔조이뉴욕",".njoyny.com","26"},
	    	{"엔조이밀란",".njoyny.com","27"},
	    	{"이마트","emart.shinsegae.com","28"},
	    	{"Hmall",".hmall.com","29"},
	    	{"바보사랑",".babosarang.co.kr","30"},
	    	{"무크",".mook.co.kr","31"},
	    	{"페프",".ffeff.com","32"},
	    	{"전자랜드",".etland.co.kr","33"},
	    	{"하이마트쇼핑몰",".e-himart.co.kr","34"},
	    	{"제로투세븐",".0to7.com","35"},
	    	{"11번가",".11st.co.kr","36"},
	    	{"롯데닷컴",".lotte.com","37"},
	    	{"옥션",".auction.co.kr","38"},
	    	{"텐바이텐",".10x10.co.kr","39"},
	    	{"G마켓",".gmarket.co.kr","40"}
	    };

	    public static String getShoppingMallNameByUrl(String url) {
	    	String name = "";

	    	if (url == null)
	    		return name;

	    	for (int i=0; i<MALL_NAME_URL.length; i++) {
	    		if (StringUtil.contains(url, MALL_NAME_URL[i][1])) {
	    			name = MALL_NAME_URL[i][0];
	    		}
	    	}

	    	return name;
	    }

	    public static int getShoppingMallIdByUrl(String url) {
	    	String id = "0";

	    	if (url == null)
	    		return Integer.parseInt(id);

	    	for (int i=0; i<MALL_NAME_URL.length; i++) {
	    		if (StringUtil.contains(url, MALL_NAME_URL[i][1])) {
	    			id = MALL_NAME_URL[i][2];
	    		}
	    	}

	    	return Integer.parseInt(id);
	    }

	    public static int randomNum(int i) {
	    	int rNum = (int) (Math.random() * i);
	    	return rNum;
	    }

	    /**
	     * String Escape
	     * @param src * @return
	     */
	    public static String escape(String src) {
	    	if(StringUtil.isEmpty(src))
	    		return "";
	    	int i;
	    	char j;
	    	StringBuffer tmp = new StringBuffer();
	    	tmp.ensureCapacity(src.length() * 6);
	    	for (i = 0; i < src.length(); i++) {
	    		j = src.charAt(i);
	    		if (Character.isDigit(j) || Character.isLowerCase(j) || Character.isUpperCase(j)) {
	    			tmp.append(j);
	    		} else if (j < 256) {
	    			tmp.append("%");
	    			if (j < 16) {
	    				tmp.append("0");
	    				tmp.append(Integer.toString(j, 16));
	    			}
	    		} else {
	    			tmp.append("%u");
	    			tmp.append(Integer.toString(j, 16));
	    		}
	    	}
	    	return tmp.toString();
	    }

	    /**
	     * String UnEscape
	     * @param src * @return
	     */
	    public static String unescape(String src) {
	    	if(StringUtil.isEmpty(src))
	    		return "";

	    	StringBuffer tmp = new StringBuffer();
	    	tmp.ensureCapacity(src.length());
	    	int lastPos = 0, pos = 0;
	    	char ch;

	    	while (lastPos < src.length()) {
	    		pos = src.indexOf("%", lastPos);
	    		if (pos == lastPos) {
	    			if (src.charAt(pos + 1) == 'u') {
	    				ch = (char) Integer.parseInt(src .substring(pos + 2, pos + 6), 16);
	    				tmp.append(ch); lastPos = pos + 6;
	    			} else {
	    				ch = (char) Integer.parseInt(src .substring(pos + 1, pos + 3), 16);
	    				tmp.append(ch);
	    				lastPos = pos + 3;
	    			}
	    		} else {
	    			if (pos == -1) {
	    				tmp.append(src.substring(lastPos));
	    				lastPos = src.length();
	    			} else {
	    				tmp.append(src.substring(lastPos, pos));
	    				lastPos = pos;
	    			}
	    		}
	    	}
	    	return tmp.toString();
	    }

	    /**
	     * @Method Name	: setUserIdMask
	     * @작성일	    : 2011. 3. 17.
	     * @작성자	    : nohjh
	     * @Method 설명	: 아이디 뒤의 두 글자를 ** 로 표기
	     * @param str
	     * @return
	     */
	    public static String setUserIdMask(String str) {
//	    	System.out.println("str="+str);
	    	String returnValue = "";
	    	if(str!=null && !"".equals(str)){
	    		if(str.length()>2){
	    			returnValue = str.substring(0, (str.length()-2))+"**";
	    		}else{
	    			returnValue = "**";
	    		}
	    	}
	    	return returnValue;
	    }

	    /**
	     * @Method Name	: restTo2
	     * @작성일	    : 2011. 3. 18.
	     * @작성자	    : sdh
	     * @Method 설명	: 2로나눈 나머지
	     * @param str
	     * @return
	     */
	    public static String restTo2(String str) {
	    	//System.out.println("str="+str);
	    	String returnValue = "";
	    	if(str!=null && !"".equals(str)){
	    		int res = Integer.parseInt(str);
	    		int res2 = res % 2;
	    		returnValue = Integer.toString(res2);
	    	}
	    	return returnValue;
	    }

	    /**
	     * @Method Name	: maskEmail
	     * @작성일	    : 2011. 2. 12.
	     * @작성자	    : DOLLY217
	     * @Method 설명	: 이메일 주소의 일부를 마스크 처리한다. dolly2**@famz.co.kr
	     * @param str
	     * @return
	     */
	    public static String maskEmail(String str) {
			String returnValue = "";

			StringTokenizer token = new StringTokenizer(str, "@");
			if(token != null){
				String email1= 	token.nextToken();
				String email2 = token.nextToken();
				returnValue = email1.substring(0,email1.length()-2)+"**@"+email2;
			}

			return returnValue;
		}

	    /**
	     * @Method Name	: maskPhoneNumber
	     * @작성일	    : 2011. 2. 12.
	     * @작성자	    : DOLLY217
	     * @Method 설명	: 전화번호의 일부를 마스크 처리한다. 010-****-2172
	     * @param str
	     * @return
	     */
	    public static String maskPhoneNumber(String str) {
			String returnValue = "";

			StringTokenizer token = new StringTokenizer(str, "-");
			if(token != null){
				String number1= 	token.nextToken();
				String number2 = token.nextToken();
				String number3 = token.nextToken();
				String mask = "";
				for(int i = 0 ; i < number2.length() ; i++){
					mask += "*";
				}
				returnValue = number1+"-"+mask+"-"+number3;
			}

			return returnValue;
		}

	    /**
	     * @Method Name	: maskCardNumber
	     * @작성일	    : 2011. 6. 10.
	     * @작성자	    : chaos
	     * @Method 설명	: 카드번호의 일부를 마스크 처리한다. 1234-1234-****-****
	     * @param str
	     * @return
	     */
	    public static String maskCardNumber(String str) {
			String returnValue = "";

			StringTokenizer token = new StringTokenizer(str, "-");
			if(token != null){
				String number1= 	token.nextToken();
				String number2 = token.nextToken();
				String mask = "";
				for(int i = 0 ; i < number2.length() ; i++){
					mask += "*";
				}
				returnValue = number1+"-"+number2+"-"+mask+"-"+mask;
			}

			return returnValue;
		}

	    /**
	     * @Method Name	: maskUserName
	     * @작성일	    : 2011. 4. 7.
	     * @작성자	    : dolly217
	     * @Method 설명	: 이름 뒤의 한 글자를 * 로 표기
	     * @param str
	     * @return
	     */
	    public static String maskUserName(String str) {
//	    	System.out.println("str="+str);
	    	String returnValue = "";
	    	if(str!=null && !"".equals(str)){
	    		if(str.length()>2){
	    			returnValue = str.substring(0, (str.length()-1))+"*";
	    		}else{
	    			returnValue = "*";
	    		}
	    	}
	    	return returnValue;
	    }

	    /**
	     * @Method Name	: convertTime
	     * @작성일	    : 2011. 6. 14.
	     * @작성자	    : sdhoon
	     * @Method 설명	: 분으로 되있는 시간을 **시간**분으로 바꿔줌
	     * @param meal
	     * @return time
		 */
	    public static String convertTime(String meal) {
			String result = "";
			int meal_tm = 0;
			if (meal!=null && !meal.equals("")) {

				meal_tm = Integer.parseInt(meal);

				if (meal_tm<60) {
					result = meal_tm+"분";
				} else if (meal_tm == 60) {
					result = "1시간";
				} else if (meal_tm > 60 && meal_tm < 120) {
					result = "1시간" + (meal_tm-60) + "분";
				} else if (meal_tm == 120) {
					result = "2시간";
				} else if (meal_tm > 120 && meal_tm < 180) {
					result = "2시간" + (meal_tm-120) + "분";
				} else if (meal_tm == 180) {
					result = "3시간";
				} else if (meal_tm > 180) {
					result = "3시간이상";
				}
			}

			System.out.println(meal + " : " + result);
			return result;
		}

	    public String encodeReturnUrl(String s) {

			byte byte0 = 10;

			byte[] bString = s.getBytes();

			StringBuffer stringbuffer = new StringBuffer(bString.length);

			ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream(
					byte0);

			OutputStreamWriter outputstreamwriter = new OutputStreamWriter(
					bytearrayoutputstream);

			int mValue = 0;

			for (int i = 0; i < bString.length; i++)

			{

				char c = (char) bString[i];

				mValue = (bString[i] < 0) ? bString[i] + 256 : bString[i];

				// if(mValue > 127){ //2byte

				// stringbuffer.append(Integer.toHexString(c));

				// }

				// else{

				if (dontNeedEncoding.get(c))

				{

					stringbuffer.append(Integer.toHexString(c));

					continue;

				}

				try

				{

					outputstreamwriter.write(c);

					outputstreamwriter.flush();

				}

				catch (IOException _ex)

				{

					bytearrayoutputstream.reset();

					continue;

				}

				byte abyte0[] = bytearrayoutputstream.toByteArray();

				for (int j = 0; j < abyte0.length; j++)

				{

					char c1 = Character.forDigit(abyte0[j] >> 4 & 0xf, 16);

					if (Character.isLetter(c1))

						c1 -= ' ';

					stringbuffer.append(c1);

					c1 = Character.forDigit(abyte0[j] & 0xf, 16);

					if (Character.isLetter(c1))

						c1 -= ' ';

					stringbuffer.append(c1);

				}

				bytearrayoutputstream.reset();

				// }

			}

			return stringbuffer.toString();

		}

		static BitSet dontNeedEncoding;

		static final int caseDiff = 32;

		static

		{

			dontNeedEncoding = new BitSet(256);

			for (int i = 97; i <= 122; i++)

				dontNeedEncoding.set(i);

			for (int j = 65; j <= 90; j++)

				dontNeedEncoding.set(j);

			for (int k = 48; k <= 57; k++)

				dontNeedEncoding.set(k);

			dontNeedEncoding.set(32);

			dontNeedEncoding.set(45);

			dontNeedEncoding.set(95);

			dontNeedEncoding.set(46);

			dontNeedEncoding.set(42);

		}

		public static String decodeReturnUrl(String cEncodeString) {

			StringBuffer stringbuffer = new StringBuffer(cEncodeString.length() / 2);

			for (int i = 0; i < cEncodeString.length(); i = i + 2) {

				stringbuffer.append((char) Integer.parseInt(cEncodeString
						.substring(i, i + 2), 16));

			}

			return stringbuffer.toString();

		}
	    
	    
	    
	    
}
