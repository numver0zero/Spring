package com.spring.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.NumberFormat;
import java.util.Vector;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

/**
 * Common method
 *
 * @version 1.0, 2005/02/03
 * @author  kim Sungtaek <webzest@commerceware.co.kr>
 */
public class ComUtils {

	/**
	 * APPLICATION FIXED CONFIG
	 */
	/** 최종 소수점 유효 자리수 **/
	public static final int DEFAULT_FINAL_SIZE         = 2;
	/** 기본 반올림 정책  [ 1:버림  2:반올림 3:올림 ] **/
	public static final int DEFAULT_MODE               = 4;
	/** 계산시 유효 소수점 자리수 **/
	public static final int VALID_DECIMAL              = 6;
	/** 반올림 정책 : 올림   BigDecimal.ROUND_CEILING **/
	public static final int MODE_CEIL                  = 2;
	/** 반올림 정책 : 버림   BigDecimal.ROUND_FLOOR   **/
	public static final int MODE_FLOOR                 = 3;
	/** 반올림 정책 : 반올림 BigDecimal.ROUND_HALF_UP **/
	public static final int MODE_ROUND                 = 4;

   	public static String convertScriptValue(String str) {

		if ( str == null ) return null;

		StringBuffer buff = new StringBuffer();
		char charArray[] = str.toCharArray();
		for (int i = 0; i<charArray.length; i++) {
			if (charArray[i]==39) {
				buff.append("\'");
			}else{
				buff.append(charArray[i]);
			}
		}
		str = new String(buff);
		return str;
	}

	/**
	 * 일정한 길이 까지 자른 후 ... 표기
	 * @param str
	 * @param limit
	 * @return
	 */
	public static String shortCutString(String str, int limit) {
	    String tempStr = "";
	    if (str == null) return str;

	    if (limit <= 0) {
	        return str;
	    }

	    byte[] strbyte = str.getBytes();

	    if (strbyte.length <= limit) {
	        return str;
	    }

	    char[] charArray = str.toCharArray();

	    int checkLimit = limit;
	    for (int i = 0; i < charArray.length; i++) {
	        if (charArray[i] < 256) {
	            checkLimit -= 1;
	        } else {
	            checkLimit -= 2;
	        }

	        if (checkLimit <= 0) {
	            break;
	        }
	    }

	    // 자를려는 마지막 자리가 2바이트 의 중간일경우
	    // 제거한다.
	    byte[] newByte = new byte[limit + checkLimit];

	    for (int i = 0; i < newByte.length; i++) {
	        newByte[i] = strbyte[i];
	    }

	    tempStr = new String(newByte);
	    if(!tempStr.equals(str)){
	        tempStr = tempStr+"...";
	    }

	    return tempStr;
	}

	/**
	 * 부동 소수점 연산 오류 보정 및 반올림 정책 적용
	 * @param argAmt : 최종 금액
	 * @return
	 */
	public static double modAmt ( double argAmt){
		return modAmt ( argAmt, DEFAULT_MODE, DEFAULT_FINAL_SIZE );
	}

	/**
	 * 한국의 경우 원단위 절사 처리
	 * @param argAmt
	 * @return
	 */
	public static double modAmtKorea ( double argAmt){
		return modAmt( modAmt ( argAmt / 10, MODE_FLOOR, 0) * 10 ,DEFAULT_MODE, 0);
	}


	/**
	 * 부동 소수점 연산 오류 보정 및 반올림 정책 적용
	 * @param argAmt : 최종 금액
	 * @param argMod : 반올림 정책
	 * @return
	 */
	public static double modAmt ( double argAmt, int argMod ){
		return modAmt ( argAmt, argMod, DEFAULT_FINAL_SIZE );
	}

	/**
	 * 부동 소수점 연산 오류 보정 및 반올림 정책 적용
     * 모든 연산의 반올림을 사용한다. default
     * 최종 할인금액과 적립금을 계산하는 순간만 버림으로 사용
     *
     * 고려대상
     * 금액 할인의 금액 분배         ; 금액 할인 상품단위로 분배되는 경우        >> 반올림
     * 상품 할인의 금액 분배         ; Set상품일 경우 구성상품으로 분배되는 경우  >> 반올림
     * 부분반품, 부분취소 접수받을 때  ;  반품, 취소되어 분배되는 경우            >> 반올림
     * 적립금 분배                  ; Set상품일 경우 구성상품으로 분배되는 경우  >> 반올림
	 * @param argAmt       : 최종 금액
	 * @param argMod       : 반올림 정책
	 * @param argFinalSize : 최종 소수점 유효 자리수
	 * @return double
	 */
	public static double modAmt ( double argAmt, int argMod, int argFinalSize ){
		BigDecimal decimalValue = null;
		try{
			if(argAmt == 0) return 0;

			decimalValue = BigDecimal.valueOf(argAmt);

			//= VALID_DECIMAL 까지 넘는 size 일 경우  VALID_DECIMAL, DEFAULT_MODE 로 세팅
			decimalValue = decimalValue.setScale(VALID_DECIMAL, DEFAULT_MODE);

			//= argMod, argFinalSize 로 재조정.
			decimalValue = decimalValue.setScale(argFinalSize, argMod);

		}catch(ArithmeticException e){ return 0;}

		return decimalValue.doubleValue();
	}

    // Right Left a String with a specified character.
    public static String lpad(String s, int n , String replace )
    {
        return  StringUtils.leftPad(s, n, replace);
    }
    // Right pad a String with a specified character.
    public static String rpad(String s, int n , String replace )
    {
        return  StringUtils.rightPad(s, n, replace);
    }
    // +1 => Left pad a String with a specified character.
    public static String increaseLpad(String s, int n , String replace )
    {
        long tempValue = Long.parseLong(s);
        tempValue = tempValue + 1;
        s = Long.toString(tempValue);
        return  lpad(s, n, replace);
    }

    // Object - > String
    public static String objToStr(Object objVal, String emptyValue){
        if(objVal == null)		return emptyValue;
        if(objVal.equals(""))	return emptyValue;
        emptyValue = objVal.toString();
        return emptyValue;
    }
    // Object - > int
    public static int objToInt(Object objVal, int emptyValue){
        if(objVal == null) return emptyValue;
        if(objVal.equals("")) return emptyValue;
        emptyValue = Integer.parseInt(objVal.toString());
        return emptyValue;
    }
    // Object - > long
    public static long objToLong(Object objVal, long emptyValue){
        if(objVal == null) return emptyValue;
        if(objVal.equals("")) return emptyValue;
        emptyValue = Long.parseLong(objVal.toString());
        return emptyValue;
    }
    // Object - > Double
    public static double objToDouble(Object objVal){
        return objToDouble(objVal, 0);
    }
    // Object - > Double
    public static double objToDouble(Object objVal, double emptyValue){
        if(objVal == null) return emptyValue;
        if(objVal.equals("")) return emptyValue;
        emptyValue = Double.parseDouble(objVal.toString());
        return emptyValue;
    }

	/**
     * db에서 사용할수 없는 값들을 변환(&,',^)   web --> db
     * @param dbstring 바꿀 문자열
     * @return temp 바꾼 문자열
     */
    public static String script2web(String dbstring){
        int index=0;
        String temp = dbstring;
        String lastStr1 = "";

        if(dbstring.equals("")){
        	return dbstring;
        }

        while((index=temp.indexOf("~&"))>=0) {
            temp = temp.substring(0,index)+"{"+temp.substring(index+2);
        }
        while((index=temp.indexOf("~`"))>=0) {
            temp = temp.substring(0,index)+'\\'+temp.substring(index+2);
        }
        while((index=temp.indexOf("~^"))>=0) {
            temp = temp.substring(0,index)+"\r\n"+temp.substring(index+2);
			//temp = temp.substring(0,index)+"<br>"+temp.substring(index+2);
        }
        while((index=temp.indexOf('"'))>=0) {
            temp = temp.substring(0,index)+"'"+temp.substring(index+1);
			//temp = temp.substring(0,index)+"<br>"+temp.substring(index+2);
        }

        temp = temp.replaceAll("\r\n", "\n");
        lastStr1 = temp.substring(temp.length()-1, temp.length());

        if (lastStr1.equals("\\") ){
        	temp = temp.substring(0, temp.length()-1) + " ";
        }
        return temp;
    }

	/**
     * web에서 사용할수 없는 값들을 변환   db --> web
     * @param desc 바꿀 문자열
     * @return temp 바꾼 문자열
     */
    public static String db2script(String desc){
        if(desc==null || desc.length()==0 )
			return "";

        String temp = desc;
        int index=-2;

//        while((index=temp.indexOf('\'',index+2))>=0) {
//            temp = temp.substring(0,index)+"\'\'"+temp.substring(index+1);
//            temp = temp.substring(0,index)+"\'\'"+temp.substring(index+1);
//
//        }
        while((index=temp.indexOf('{'))>=0) {
            temp = temp.substring(0,index)+"~&"+temp.substring(index+1);
        }
        while((index=temp.indexOf('\\'))>=0) {
            temp = temp.substring(0,index)+"~`"+temp.substring(index+1);
        }
        while((index=temp.indexOf("\r\n"))>=0) {
//            temp = temp.substring(0,index)+"~^"+temp.substring(index+2);
            temp = temp.substring(0,index)+"<br>"+temp.substring(index+2);

        }
        while((index=temp.indexOf('\n'))>=0) {
//            temp = temp.substring(0,index)+"~^"+temp.substring(index+1);
            temp = temp.substring(0,index)+"<br>"+temp.substring(index+1);

        }
        while((index=temp.indexOf('"'))>=0) {
            temp = temp.substring(0,index)+"'"+temp.substring(index+1);
        }
        while((index=temp.indexOf("'",index+2))>=0) {
            temp = temp.substring(0,index)+"`"+temp.substring(index+2);
        }
        return temp;
    }

    /**
     * <PRE>
     * Desc     : 특정문자 변환 Check
     * </PRE>
     * @param   str     : 바꾸려는 문자열을 가진 원본
     * @param   pattern : 찾을 문자열
     * @param   replace : 바꿔줄 문자열
     * @return  String
     */
    public static String replace(String str, String pattern, String replace)
    {
      int s = 0;
      int e = 0;
      StringBuffer result = new StringBuffer();

      while ((e = str.indexOf(pattern, s)) >= 0)
      {
        result.append(str.substring(s, e));
        result.append(replace);
        s = e+pattern.length();
      }

      result.append(str.substring(s));
      return result.toString();
    }

    /**
     * <PRE>
     * Desc     : 특수 char(& , " ) 를 ( , , ' ) 로 변환
     * </PRE>
     * @param   str : 특수 char(& , " )
     * @return  String
     */
    public static String charReplace(String str)
    {
      str = str.replace('&',',');
      str = str.replace('"', ' ');
      return str;
    }

	/**
	 * <PRE>
	 * Desc     : Null String을 "" String으로 바꿔준다.
	 * </PRE>
	 * @param   String  문자열
	 * @return  String  문자열 or ""
	 */
	public static String NVL(String str){
		if(str == null || str.length() <= 0)
			return "";
		else
			return str;
	}


	/**
	 * <PRE>
	 * Desc     : Null String을 replace String으로 바꿔준다.
	 * </PRE>
	 * @param   String  검사 문자열
	 * @param   String  바뀔 문자열
	 * @return  String  문자열
	 */
	public static String NVL(String str, String replace){
		if(str == null || str.length() <= 0)
			return replace;
		else
			return str;
	}

    /**
     * 문자열이 알파벳인지 검사
     *
     * @param   str 검사 하고자 하는 문자열
     * @return  알파벳인지의 여부에 따라 'true' or 'false'
     */
    public static boolean isAlpha(String str) {
        if (str == null) return false;

        str = str.trim();
        int len = str.length();
        if (len == 0)
            return false;

        for (int i = 0; i < len; i++) {
            if (!isAlpha(str.charAt(i)))
                return false;
        }
        return true;
    }

    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////

/**
   * <PRE>
   * Desc     : Splits the provided text into an array, separators specified. This is an alternative to using StringTokenizer.
   * </PRE>
   * @param   str       : 원본
   * @param   separator : 구분자
   * @return  String[]
   */
    public static String[] split(String str, String separator){
        return StringUtils.split(str, separator);
    }

  /**
   * <PRE>
   * Desc     : Replaces multiple characters in a String in one go.
   * </PRE>
   * @param   str     : 바꾸려는 문자열을 가진 원본
   * @param   pattern : 찾을 문자열
   * @param   replace : 바꿔줄 문자열
   * @return  String
   */
  public static String replaceChars(String text, String repl, String with)
  {
    return StringUtils.replaceChars(text, repl, with);
  }



    // get Parse Pay Month
    public static String getParsePayMonth(String norest_allot_months){
        String convertStr = StringUtils.leftPad(norest_allot_months,36,"0");
        String rtnValue   = "";
        String sep        = "";

        for(int i=0 ; i < 36 ; i++){
            if( convertStr.substring(i,i+1).equals("1") ){
                if(!sep.equals("-")){
                    rtnValue += ",";
                    if( i == 0 ) {
                        rtnValue += "일시불";
                    }else{
                        rtnValue += ""+(i+1);
                    }
                    if( i < 34 ){
                        if( convertStr.substring(i+1,i+2).equals("1") && convertStr.substring(i+2,i+3).equals("1") ){
                            sep = "-";
                            rtnValue += sep;
                        }
                    }
                }else{
                    if( i < 35 ){
                        if( !convertStr.substring(i+1,i+2).equals("1")){
                            rtnValue += ""+(i+1);
                            sep = "";
                        }
                    }else{
                        rtnValue += ""+(i+1);
                    }
                }
            }
        }

        if(!rtnValue.equals("")) rtnValue = rtnValue.substring(1);
        if(rtnValue.equals(""))  rtnValue = "불가";

        return rtnValue;
    }



    // CheckBox Value Mapping
    // i)   0  >> 1
    // ii) any >> 0
    public static String checkBoxValueSet(String inputValue){
        String rtnValue = "0";
        if( inputValue == null ) return rtnValue;
        if( inputValue.equals("") ) return rtnValue;
        if( !inputValue.equals("0") ) rtnValue = "1";
        return rtnValue;
    }



    /** String 을 구분자에 따라 잘라서 배열에 저장 **/
  public static String[] getStringToArray(String strVale, String CheckValue, int ArrayCount){
    String [] tempArray = new String[ArrayCount];
    if(strVale == null)    return tempArray;
    if(strVale.equals("")) return tempArray;

    int s = 0;
    int e = 0;
    int i = 0;

    while ((e = strVale.indexOf(CheckValue, s)) >= 0)
    {
      tempArray[i] = strVale.substring(s, e);
      s = e+CheckValue.length();
      i++;
    }
    return tempArray;
  }

  /**
   * <PRE>
   * Desc     : 123,456 -> int type convert.
   * </PRE>
   * @param   paramMoney : \123,456 Format
   * @return  int
   */
  public static int setCurrencyToInt(String paramMoney){
    int money = 0;
    StringBuffer strMoney = new StringBuffer(paramMoney);

    for (int i=0; i<strMoney.length(); i++)
    {
      if (strMoney.charAt(i) == ',')
      {
        strMoney.deleteCharAt(i);
      }
    }

    try
    {
      money = Integer.parseInt(strMoney.toString());
    } catch (NumberFormatException nfe) {
      money = -1; // error -1 return
    }
    return money;
  }

  /**
   * <PRE>
   * Desc     : 123,456 -> double type convert.
   * </PRE>
   * @param   paramMoney : \123,456 Format
   * @return  double
   */
  public static double setCurrencyToDouble(String paramMoney){
    double money = 0;
    StringBuffer strMoney = new StringBuffer(paramMoney);
    for (int i=0; i<strMoney.length(); i++)
    {
      if (strMoney.charAt(i) == ',')
      {
          strMoney.deleteCharAt(i);
      }
    }

    try
    {
      money = Double.parseDouble(strMoney.toString());
    } catch (NumberFormatException nfe) {
      money = -1; // error -1 return
    }
    return money;
  }

  /**
   * <PRE>
   * Desc     : 123,456 -> String type convert.
   * </PRE>
   * @param   paramMoney : \123,456 Format
   * @return  String
   */
  public static String setCurrencyToStr(String paramMoney)
  {

    if (paramMoney == null)
    {
      paramMoney = "";
    }

    StringBuffer strMoney = new StringBuffer(paramMoney);
    for (int i=0; i<strMoney.length(); i++)
    {
      if (strMoney.charAt(i) == ',' || strMoney.charAt(i) == '-' || strMoney.charAt(i) == '/')
      {
        strMoney.deleteCharAt(i);
      }
    }

    if (isNumber(strMoney.toString()))
    {
      return strMoney.toString();
    } else {
      return null;
    }
  }

  /**
   * <PRE>
   * Desc     : int -> 123,456 type convert.
   * </PRE>
   * @param   paramMoney : int
   * @return  String
   */
  public static String setIntToCurrency(int paramMoney)
  {
    NumberFormat nf = NumberFormat.getNumberInstance();
    return nf.format(paramMoney);
  }

  /**
   * <PRE>
   * Desc     : double -> 123,456 type convert.
   * </PRE>
   * @param   paramMoney : double
   * @return  String
   */
  public static String setIntToCurrency(double paramMoney)
  {
    NumberFormat nf = NumberFormat.getNumberInstance();
    return nf.format(paramMoney);
  }

  /**
   * <PRE>
   * Desc     : double -> 123,456 type convert.
   * </PRE>
   * @param   paramMoney : double
   * @return  String
   */
  public static String setLongToCurrency(long paramMoney)
  {
    NumberFormat nf = NumberFormat.getNumberInstance();
    return nf.format(paramMoney);
  }

  /**
   * <PRE>
   * Desc     : String -> 123,456 type convert.
   * </PRE>
   * @param   paramMoney : String
   * @return  String
   */
  public static String setStrToCurrency(String paramMoney)
  {
    if (paramMoney.equals(""))
      return "0";
    if (!isNumber(paramMoney))
      return null;

    Long paramLong = new Long(paramMoney);
    NumberFormat nf = NumberFormat.getNumberInstance();
    return nf.format(paramLong.longValue());
  }

  /**
   * <PRE>
   * Desc     : number check
   * </PRE>
   * @param   strNumber : String
   * @return  boolean
   */
  public static boolean isNumber(String strNumber)
  {
    Long longValue = null;
    boolean isSuccess = true;

    try
    {
      longValue = new Long(strNumber);
    } catch (NumberFormatException nfe) {
      isSuccess = false;
    }
    return isSuccess;
  }

  /**
   * <PRE>
   * Desc     : 숫자에 대해(금액) TRUNC
   * </PRE>
   * @param   param : 숫자
   * @param   param : 숫자
   * @return  float
   */
  public static float Truncate(float param, float tunc)
  {
    param = param / tunc;
    Float floatTrunc = new Float(param);
    Integer IntTrunc = new Integer(floatTrunc.intValue());
    param = IntTrunc.floatValue();
    param = param  * tunc;
    return param;
  }

  /**
   * <PRE>
   * Desc     : 정수를 받아서 반올림(5이하 버림, 5이상 올림)
   * </PRE>
   * @param   number : 정수
   * @return  long
   */
  public static long Round(int number)
  {
    Integer i = new Integer(number);
    double d_number = i.doubleValue();
    long round_number = Math.round(d_number/10);
    long exchange_number = round_number * 10;
    return exchange_number;
  }

  /**
   * <PRE>
   * Desc     : double를 받아서 반올림(5이하 버림, 5이상 올림)
   * </PRE>
   * @param   number : double
   * @return  long
   */
  public static long Round(double number)
  {
    long round_number = Math.round(number/10);
    long exchange_number = round_number * 10;
    return exchange_number;
  }

  /**
   * <PRE>
   * Desc     : String 형식을 받아서 Html 형식으로 변환
   * </PRE>
   * @param   comment : String
   * @return  String
   */
  public static String convertHtmlBr(String comment)
  {
    int length = comment.length();
    StringBuffer buffer = new StringBuffer();

    if (comment.equals(null))
    {
      buffer.append("");
      return buffer.toString();
    }

    for (int i = 0; i < length; ++i)
    {
      String comp = comment.substring(i, i+1);
      if ("\r".compareTo(comp) == 0)
      {
        comp = comment.substring(++i, i+1);
        if ("\n".compareTo(comp) == 0)
          buffer.append("<BR>\r");
        else
          buffer.append("\r");
      }
      buffer.append(comp);
    }
    return buffer.toString();
  }

	/**
     * db에서 사용할수 없는 값들을 변환()   text --> db
     * @param dbstring 바꿀 문자열
     * @return temp 바꾼 문자열
     */
    public static String text2db(String desc){
        return desc;
    }

  /**
   * <PRE>
   * Desc     : 변수가 한글이 포함되어 있는지 Check
   * </PRE>
   * @param   argStr : 문자열
   * @return  boolean
   */
  public static boolean isString(String argStr)
  {
    // 문자열의 길이와 문자열의 바이트배열의 길이를 비교해서 체크
    if (argStr.length() == argStr.getBytes().length)
      return false;
    else
      return true;
  }

  /**
   * <PRE>
   * Desc     : String[] => Integer[]으로 변환
   * </PRE>
   * @param   strs : String[]
   * @return  Integer[]
   */
  public static Integer[] setStrToInteger(String[] strs)
  {
    if ( strs == null ) return null;
    Integer[] ints = new Integer[strs.length];
    for (int i=0 ; i< ints.length ; i++)
    {
      try
      {
        ints[i] = new Integer(strs[i]);
      } catch (NumberFormatException e) {
        ints[i] = new Integer(0);
      }
    }
    return ints;
  }

  /**
   * <PRE>
   * Desc     : 원하는 값의 존재 유무 (해당번째)
   * </PRE>
   * @param   strs : 해당문자열
   * @param   comp : 비교값
   * @return  int
   */
  public static int getArrayCompare(String strs, String comp)
  {
    return strs.indexOf(comp, 0);
  }

  /**
   * <PRE>
   * Desc     : 원하는 값의 존재 유무
   * </PRE>
   * @param   strs[] : 해당문자열
   * @param   comp   : 비교값
   * @return  boolean
   */
  public static boolean getArrayCompare(String[] strs, String comp)
  {
    if ( strs == null ) return false;

    for (int i=0 ; i< strs.length ; i++)
    {
      if (strs[i].equals(comp)) return true;
    }
    return false;
  }

  /**
   * <PRE>
   * Desc     : 원하는 위치값의 존재 유무
   * </PRE>
   * @param   strs[]   : 해당문자열
   * @param   position : 위치값
   * @param   comp     : 비교값
   * @return  boolean
   */
  public static boolean getArrayCompare(String[] strs, int position, String comp)
  {
    if ( strs == null ) return false;
    if ( strs.length < position ) return false;
    if ( strs[position].equals(comp) ) return true;

    return false;
  }

  /**
   * <PRE>
   * Desc     : 유효한 값의 갯수
   * </PRE>
   * @param   strs[] : 문자열
   * @return  int
   */
  public static int getArrayCount(String[] strs)
  {
    int count = 0;
    try
    {
      if ( strs == null ) return count;
      for (int i=0 ; i< strs.length ; i++)
      {
        if (!strs[i].equals("") && strs[i] != null)
          count++;
      }
    } catch (Exception e) {
    }

    return count;
  }

  /**
   * <PRE>
   * Desc     : String[] => Double[]으로 변환
   * </PRE>
   * @param   strs[]
   * @return  Double[]
   */
  public static Double[] setStrToDouble(String[] strs)
  {
    if ( strs == null ) return null;
    Double[] doubles = new Double[strs.length];

    for (int i=0 ; i< doubles.length ; i++)
    {
      try
      {
        doubles[i] = new Double(strs[i]);
      } catch (NumberFormatException e) {
        doubles[i] = new Double(0);
      }
    }
    return doubles;
  }

  /**
   * <PRE>
   * Desc     : String 으로 받은 인수를 size 1 씩 짤라서 지정된 size 의 배열에 저장
   * </PRE>
   * @param   Amt   : 문자열
   * @param   Count : size
   * @return  String[] : 문자열을 배열에 setting
   */
  public static String[] arrayAmtSetting(String Amt, int Count)
  {
    String [] AmtArray = new String[Count];
    int AmtLength = Amt.length();
    int compLength = Count - AmtLength;

    for (int i = 0 ; i < Count ; i++)
    {
      if (compLength > i)
      {
        AmtArray[i] = "";
      } else {
        AmtArray[i] = Amt.substring(i-compLength,i-compLength+1);
      }
    }
    return AmtArray;
  }


  /**
   * <PRE>
   * Desc     : KOREA 로 변경
   * </PRE>
   * @param   en 문자열
   * @return  String
   */
  public static String enToKo(String en)
  {
    String korean=null;
    try
    {
      korean = new String(en.getBytes("8859_1"),"KSC5601");
    } catch(Exception e) {
      //e.printStackTrace();
      return korean;
    }
    return korean;
  }

  /**
   * <PRE>
   * Desc     : DB에 Data를 저장할때
   * </PRE>
   * @param   ko : korea 문자열
   * @return  String
   */
  public static String koToEn(String ko)
  {
    String english=null;
    try
    {
      english = new String(ko.getBytes("KSC5601"),"8859_1");
    } catch(Exception e) {
      e.printStackTrace();
      //return english;
    }
    return english;
  }

    // get norest allot months
    public static Vector getAllotMonthCal(String norest_allot_months){
        String convertStr = StringUtils.leftPad(norest_allot_months,36,"0");
        Vector vtRtn = new Vector();

        for(int i=0 ; i < 36 ; i++){
            if( convertStr.substring(i,i+1).equals("1") ){
                vtRtn.add(new Integer(i+1));
            }
        }
        return vtRtn;

/**
        String arrayVal[] = new String[36];
        int cnt = 0;
        for ( int i = 0 ; i < 36 ; i++ ){
            if(convertStr.substring(i,i+1).equals("1")){;
                arrayVal[cnt] = Integer.toString(i+1);
                cnt++;
            }
        }

        String rtnArray[] = new String[cnt];
        for( int j = 0 ; j < cnt; j++){
            rtnArray[j] = arrayVal[j];
        }
        return rtnArray;
**/
    }

	/**
	 * <PRE>
	 * Desc     : Null String을 replace String으로 바꿔준다.
	 *            Null 인 경우만 check 해서 replace 해주도록 변경
	 * </PRE>
	 * @param   String  검사 문자열
	 * @param   String  바뀔 문자열
	 * @return  String  문자열
	 */
	public static String isNull(String str, String replace){
		if(str == null)
			return replace;
		else
			return str;
	}

   	public static String replaceQue(String str) {

		if ( str == null ) return null;

		StringBuffer buff = new StringBuffer();
		char charArray[] = str.toCharArray();
		for (int i = 0; i<charArray.length; i++) {
			if (charArray[i] != 39 && charArray[i] != 34) {
				buff.append(charArray[i]);
			}
		}
		str = new String(buff);
		return str;
	}

     /**
     * 문자 하나가 알파벳인지 검사
     *
     * @param   str 검사 하고자 하는 문자
     * @return  알파벳인지의 여부에 따라 'true' or 'false'
     */
    public static boolean isAlpha(char c) {
        if ((c < 'a' || c > 'z') &&
            (c < 'A' || c > 'Z') &&
            c != '_' && c != ' ')
            return false;
        return true;
    }

    /**
     * 상품 코드를 Barcode로 변환
     *
     * @param   str1 상품코드
     * @param   str2 단품코드
     * @return  Barcode
     */
    public static String getBarcode(String str1, String str2) {
        //= CODE 39
        String[] code = {   "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A",
    						"B", "C", "D", "E", "F", "G", "H", "I", "G", "K", "L",
    						"M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",
    						"X", "Y", "Z", "-", ",", " ", "$", "/", "+", "%"};
        String barcode = (str1 + str2).toUpperCase();
        int lencode = barcode.length();
        int sumcode = 0;
        int k = 0;
        String cutcode = "";
        for(int i=0; i<lencode; i++){
        	cutcode = barcode.substring(i, i+1);
        	k=0;
        	for(int j=0; j<43; j++){
        		//= CODE39에 대응되는 값의 위치를 찾는다.
        		k=j;
        		if( cutcode.equals(code[j]) ) break;
        	}
        	//= 대응되는 위치값을 더한다.
        	sumcode = sumcode + k;
        }

        //= BarCode를 생성한다.
        barcode = barcode + code[(sumcode % 43)];

        return barcode;
    }

    /**
     * 쿠키에서 정보를 조회
     * @param request
     * @param name
     * @return
     * @throws ServletException
     * @throws IOException
     */
	public static String getCookie(HttpServletRequest request, String name) {
		String value = null;
		Cookie[] cookies = null;
		try{
			cookies = request.getCookies();
	        if(cookies == null) return null;
			if (cookies.length > 0) {
				for (int i = 0; i < cookies.length; i++){
					if ( cookies[i].getName().equals(name) ){
						value = cookies[i].getValue();
						return value;
					}
				}
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
		return null;
	}

	/**
	 * 쿠키에서 정보를 세팅
	 * @param response
	 * @param cookieName
	 * @param cookieContents
	 * @param maxAgem
	 * @param doamin
	 * @throws ServletException
	 * @throws IOException
	 * @throws Exception
	 */
    public static void setCookie(HttpServletResponse response, String cookieName,
    		String cookieContents, int maxAgem, String doamin) throws ServletException, IOException, Exception {
    	Cookie newCookie = new Cookie(cookieName,  cookieContents);
    	newCookie.setPath("/");
    	newCookie.setMaxAge(maxAgem);
    	newCookie.setDomain(doamin);
    	response.addCookie(newCookie);
    }

    /**
     * 쿠키에서 정보를 삭제
     * @param request
     * @param response
     * @param name
     * @throws ServletException
     * @throws IOException
     * @throws Exception
     */
    public static void delCookie(HttpServletRequest request, HttpServletResponse response, String name)
    		throws ServletException, IOException, Exception {
//		String value = null;
//		Cookie delCookie = null;
//		Cookie[] cookies = request.getCookies();
//        if(cookies == null) return;
//		if (cookies.length > 0) {
//			for (int i = 0; i < cookies.length; i++){
//				if ( cookies[i].getName().equals(name) ){
//					delCookie = cookies[i];
//					delCookie.setMaxAge(0);
//					delCookie.setValue("");
////					delCookie.setPath("/");
//					response.addCookie(delCookie);
//					break;
//				}
//			}
//		}

    	Cookie cookie = new Cookie(name, "");
    	cookie.setMaxAge(0);
    	cookie.setPath("/");
    	cookie.setDomain(".okcashbag.com");
    	response.addCookie(cookie);

    }


    /**
     * Deflater byte[] 압축
     * @param bytesToCompress
     * @return
     * @throws IOException
     */
    public static byte[] compress(byte[] bytesToCompress) throws IOException {
        // Compressor with highest level of compression.
        Deflater compressor = new Deflater(Deflater.BEST_COMPRESSION);
        compressor.setInput(bytesToCompress); // Give the compressor the data to compress.
        compressor.finish();

        // Create an expandable byte array to hold the compressed data.
        // It is not necessary that the compressed data will be smaller than
        // the uncompressed data.
        ByteArrayOutputStream bos = new ByteArrayOutputStream(bytesToCompress.length);

        // Compress the data
        byte[] buf = new byte[bytesToCompress.length + 100];
        while (!compressor.finished()){
            bos.write(buf, 0, compressor.deflate(buf));
        }

        bos.close();

        // Get the compressed data
        return bos.toByteArray();
    }

    /**
     * Deflater byte[] 압축  풀기
     * @param compressedBytes
     * @return
     * @throws IOException
     * @throws DataFormatException
     */
    public static byte[] decompress(byte[] compressedBytes) throws IOException, DataFormatException {
        // Initialize decompressor.
        Inflater decompressor = new Inflater();
        decompressor.setInput(compressedBytes);  // Give the decompressor the data to decompress.
        decompressor.finished();

        // Create an expandable byte array to hold the decompressed data.
        // It is not necessary that the decompressed data will be larger than
        // the compressed data.
        ByteArrayOutputStream bos = new ByteArrayOutputStream(compressedBytes.length);

        // Decompress the data
        byte[] buf = new byte[compressedBytes.length + 100];
        while (!decompressor.finished()){
            bos.write(buf, 0, decompressor.inflate(buf));
        }

        bos.close();

        // Get the decompressed data.
        return bos.toByteArray();
    }

    public static void setCookieObject(HttpServletResponse response, String cookieName,
    		String cookieSetValue, int maxAgem, String doamin) throws ServletException, IOException, Exception {
    	cookieSetValue = URLEncoder.encode(cookieSetValue, "UTF-8"); //=urlencoding
    	cookieSetValue = new String(compress(cookieSetValue.getBytes("ISO-8859-1")),"ISO-8859-1"); //=compress
    	cookieSetValue = new String(Base64.encodeBase64(cookieSetValue.getBytes("ISO-8859-1")),"ISO-8859-1"); //=base64 encoding
		ComUtils.setCookie(response, cookieName, cookieSetValue, maxAgem, doamin); //=cookie set
    }

	public static String getCookieObject(HttpServletRequest request, String cookieName) throws ServletException, IOException, DataFormatException {
		String cookieGetValue = ComUtils.getCookie(request, cookieName); //=cookie get
	    if(cookieGetValue != null){
	    	cookieGetValue = new String(Base64.decodeBase64(cookieGetValue.getBytes("ISO-8859-1")),"ISO-8859-1"); //=base64 decoding
		    cookieGetValue = new String(decompress(cookieGetValue.getBytes("ISO-8859-1")),"ISO-8859-1"); //=decompress
		    cookieGetValue = URLDecoder.decode(cookieGetValue, "UTF-8"); //=urldecoding
	    }
	    return cookieGetValue;
	}

    public static String setCookieObjectMobile(String cookieSetValue) throws ServletException, IOException, Exception {
    	cookieSetValue = URLEncoder.encode(cookieSetValue, "UTF-8"); //=urlencoding
    	cookieSetValue = new String(compress(cookieSetValue.getBytes("ISO-8859-1")),"ISO-8859-1"); //=compress
    	cookieSetValue = new String(Base64.encodeBase64(cookieSetValue.getBytes("ISO-8859-1")),"ISO-8859-1"); //=base64 encoding
    	return cookieSetValue;
    }

	public static String getCookieObjectMobile(String cookieValue) throws ServletException, IOException, DataFormatException {
	    if(cookieValue != null){
	    	cookieValue = new String(Base64.decodeBase64(cookieValue.getBytes("ISO-8859-1")),"ISO-8859-1"); //=base64 decoding
	    	cookieValue = new String(decompress(cookieValue.getBytes("ISO-8859-1")),"ISO-8859-1"); //=decompress
	    	cookieValue = URLDecoder.decode(cookieValue, "UTF-8"); //=urldecoding
	    }
	    return cookieValue;
	}



	/**
	 * 페이징 처리 html 생성
	 * @param kinds
	 * @param currentPage
	 * @param rowsPerPage
	 * @param totalcount
	 * @return
	 */
	public static String makePagingHtml(String pageKinds, int currentPage, int rowsPerPage, int totalCount ){
		int endPage = 0;
		StringBuffer makeHtml = new StringBuffer();

		endPage = totalCount / rowsPerPage;

		if(totalCount % rowsPerPage > 0){
			endPage = endPage + 1;
		}
		if (totalCount > 0) {
			if(pageKinds.equals("myCouponOrderList") || pageKinds.equals("myCouponCancelList")|| pageKinds.equals("MyCouponZone")||pageKinds.equals("MyCouponBrand")||pageKinds.equals("MyCouponWishList")||pageKinds.equals("couponList")||pageKinds.equals("faqFrm")
					            ||pageKinds.equals("brandList")||pageKinds.equals("eventList")||pageKinds.equals("noticeFrm") || pageKinds.equals("keywordSearchList") || pageKinds.equals("mcouponTokTokList") || pageKinds.equals("mcouponTokTokReview")){  
				makeHtml.append("<div class='morePage2'>");
			}else{
				makeHtml.append("<div class='morePage'>");
			}
			makeHtml.append("<p>"+currentPage+"/"+endPage+" page</p>");
			if (currentPage < endPage){
				makeHtml.append("<button onclick=\"javascript:mpaging('"+pageKinds+"', '"+(currentPage+1)+"', '"+rowsPerPage+"', '"+totalCount+"');return false;\"><span>더 보기</span></button>");
	        }
			makeHtml.append("</div>");
		}
		return makeHtml.toString();
	}

}