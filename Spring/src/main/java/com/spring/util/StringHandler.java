package com.spring.util;

import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

/*
* @author �̵���
*/
public class StringHandler
{
    public static String toString(String str)
    {
        if(str==null || str.equals("null") || str.equals("NULL")) return "";
        else return str.trim();
    }

    public static String toString(String inputVal, String defaultVal)
    {
        if(inputVal==null || inputVal.equals("null") || inputVal.equals("NULL") || inputVal.length() < 1) return defaultVal;
        else return inputVal.trim();
    }

    private static String[][] convertStr={
        { "document","docuM"},
        { "cookie","cooie"},
        {"<","&lt;"},
        {">","&gt;"},
        {"'","’"},
        {"\"","&quot;"},
        {"alert","alart"}
    };
    
    private static String[][] convertStr2={
    	{ "document","docuM"},
    	{ "cookie","cooie"},
    	{"<","〈"},
    	{">","〉"},
    	{"'","’"},
    	{"\"","＂"},
    	{"alert","alart"}
    };


    public static String toStringWithoutTag(String inputVal,String defaultVal){
        String returnVal = inputVal;
        if(returnVal==null || returnVal.equals("null") || returnVal.equals("NULL") || returnVal.length() < 1) return defaultVal;
        else{
            returnVal = returnVal.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "").trim();
            for(int i=0;i<convertStr.length;i++){
                returnVal = returnVal.replaceAll(convertStr[i][0], convertStr[i][1]).trim();
            }

            return returnVal;
        }

    }

    public static int toIntWithoutTag(String inputVal,int defaultVal){

        int returnVal = 0;
        String tempVal = inputVal;
        if(tempVal==null || tempVal.equals("null") || tempVal.equals("NULL") || tempVal.length() < 1) return defaultVal;
        else{
            tempVal = tempVal.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "").trim();
            for(int i=0;i<convertStr.length;i++){
                tempVal = tempVal.replaceAll(convertStr[i][0], convertStr[i][1]).trim();
            }

            try{
                returnVal = Integer.parseInt(tempVal);
            }catch(Exception e){
                returnVal = defaultVal;
            }

            return returnVal;
        }
    }

    public static String toStringWithoutTag(String inputVal){
        String returnVal = inputVal;
        if(returnVal==null || returnVal.equals("null") || returnVal.equals("NULL") || returnVal.length() < 1) return "";
        else{
            returnVal = returnVal.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "").trim();
            for(int i=0;i<convertStr.length;i++){
                returnVal = returnVal.replaceAll(convertStr[i][0], convertStr[i][1]).trim();
            }

            return returnVal;
        }

    }

    public static int toIntWithoutTag(String inputVal){

        int returnVal = 0;
        String tempVal = inputVal;
        if(tempVal==null || tempVal.equals("null") || tempVal.equals("NULL") || tempVal.length() < 1) return returnVal;
        else{
            tempVal = tempVal.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "").trim();
            for(int i=0;i<convertStr.length;i++){
                tempVal = tempVal.replaceAll(convertStr[i][0], convertStr[i][1]).trim();
            }

            try{
                returnVal = Integer.parseInt(tempVal);
            }catch(Exception e){
                returnVal = 0;
            }

            return returnVal;
        }
    }

    public static String makeStarPhoneFormat(String phone) {
        String result = phone;

        String[] arr = phone.split("[-]");

        if(arr.length == 3) {
            result = arr[0];
            result += "-"+arr[1].replaceAll("[A-Za-z0-9]", "*");
            result += "-"+arr[2];
        }
        else {
            result = "";
        }

        return result;
    }

    public static String makeStarEmailFormat(String email) {
        String result = email;

        String[] arr = email.split("@");

        if(arr.length == 2) {
            int idLen = arr[0].length();
            if(idLen > 2)
                result = arr[0].substring(0, 2)+arr[0].substring(2).replaceAll("[A-Za-z0-9]", "*");
            else
                result = arr[0];

            result += "@"+arr[1];
        }
        else {
            result = "";
        }

        return result;
    }


    public static String nullCheck(String str)
    {
        if(str==null || str.equals("null") || str.equals("NULL")) return "";
        else return str;
    }

    public static String getSQLString(String str)
    {
        return "'"+str+"'";
    }
    public static String getSQLString(char ch)
    {
        return "'"+String.valueOf(ch)+"'";
    }
    public static String getSQLString(int i)
    {
        return "'"+String.valueOf(i)+"'";
    }
    public static String getZeroString(int i, int len)
    {
        String s = Integer.toString(i);
        int gap = len - s.length();
        for(int j=0; j<gap;j++) s = "0"+s;
        return s;
    }
    public static String getZeroString(long i, int len)
    {
        String s = Long.toString(i);
        int gap = len - s.length();
        for(int j=0; j<gap;j++) s = "0"+s;
        return s;
    }
    public static boolean isEmpty(String str)
    {
        return str == null || str.trim().equals("");
    }
    public static boolean containsSpace(String str)
    {
        return str.indexOf(" ") >= 0;
    }

    public static String fillNumericString(String value, int len){
        if(value == null) value ="";

        StringBuffer buffer = new StringBuffer(len);

        int loop = len - value.length();

        for(int  i= 0 ; i < loop ; i++)	buffer.append("0");

        buffer.append(value);

        return buffer.toString();

    }

    public static String fillSpaceString(String value, int len){
        if(value == null) value ="";

        StringBuffer buffer = new StringBuffer(len);

        buffer.append(value);
        int loop = len - value.getBytes().length;

        for(int  i= 0 ; i < loop ; i++)	buffer.append(" ");

        return buffer.toString();
    }

    public static String fillSpaceString(float value, int len){
        return fillSpaceString(String.valueOf(value), len);
    }

    public static String fillSpaceString(int value, int len){
        return fillSpaceString(String.valueOf(value), len);
    }

    public static String fillNullString(String value, int len){
        if(value == null) value ="";
        if(value.length() >= len) return value.substring(0,len);

        StringBuffer buffer = new StringBuffer(len);

        buffer.append(value);
        int loop = len - value.getBytes().length;

        for(int  i= 0 ; i < loop ; i++)	buffer.append((char)0x00);

        return buffer.toString();
    }

    public static String emailTrans(String str){
        if(str == null) str ="";
        if(str.length() <= 0) return "";

        int idx = 0;

        if((idx=str.indexOf("@")) < 0){
            return "";
        }

        //PrintManager.debug("idx = "+idx);
        if(idx>3){
            return str.substring(0,(idx-3))+"***"+str.substring(idx,str.length());
        }else{
            return "***"+str.substring(idx, str.length());
        }

    }

    public static String toMoneyStr(int amount)
    {

        if(amount < 1000){	return String.valueOf(amount);	}

        int addCommaNum = 1;
        int namuzi = amount;

        while(true)
        {
            if(namuzi < 1000) break;

            addCommaNum++;
            namuzi = namuzi / 1000;
        }

        String amount_str = null;

        try
        {
        }catch(Exception e){
            e.printStackTrace();
        }
//		PrintManager.debug("amount_str  :: "+amount_str);

        int totalLen = amount_str.length();
        int highNumLen = totalLen % 3;
        int curLen = 0;
//		PrintManager.debug("totalLen  :: "+totalLen);
//		PrintManager.debug("highNumLen  :: "+highNumLen);
//		PrintManager.debug("curLen  :: "+curLen);
//		PrintManager.debug("addCommaNum  :: "+addCommaNum);

        StringBuffer sb = new StringBuffer();

        if(highNumLen > 0)
        {
            sb.append(amount_str.substring(curLen,highNumLen));
            sb.append(",");
            addCommaNum--;
        }

        curLen += highNumLen;
        if(addCommaNum > 0)
        {
            for(int i=0;i<addCommaNum;i++)
            {
//				PrintManager.debug("i  : "+i+"   curLen  :: "+curLen);
                sb.append(amount_str.substring(curLen,curLen+3));
                curLen+=3;
                if(curLen < totalLen) 				sb.append(",");

            }
        }
        return sb.toString();
    }
    public static String replaceBR(String str, String pattern, String replace) {

        int s = 0; // ã�� ������ ��ġ
        int e = 0; // StringBuffer�� append �� ��ġ
        StringBuffer result = new StringBuffer(); // ��� ���ڿ� ��ŵ� ��

        while ((e = str.indexOf(pattern, s)) >= 0) {
                result.append(str.substring(s, e));
                if(!replace.equals(""))
                        result.append(replace);
                s = e + pattern.length();
        }

        result.append(str.substring(s));
        return result.toString();
    }
    @SuppressWarnings("null")
	public static String convertToBR(String oldString){
        StringBuffer newString = new StringBuffer(64);
        if(oldString == null && oldString.equals("")){
                return "";
        }else{
                for(int i=0 ; i< oldString.length(); i++){

                        if(oldString.charAt(i) == '\r' || oldString.charAt(i) == '\n'|| oldString.charAt(i) == '\n'){
                                newString.append("<br>");
                        }else{
                                newString.append(oldString.charAt(i));
                        }
                }
        }
        return newString.toString();
    }

    /**
     * ���ڿ��� �����ڸ� �Ѱܹ޾� �����ڷ� �и��� ���ڹ迭�� ��ȯ�ϴ� �޼ҵ�.
     *
     * @param String pm_sSrc       : �迭�� �и��� ���ڿ�
     * @param String pm_sDelim     : ������
     * @return String[] lm_sResult : �����ڷ� �и��� �迭
     */
    public static String[] split(String pm_sSrc, String pm_sDelim) {

        if(pm_sSrc==null || pm_sSrc.length()==0) {
            return null;
        }

        String[] lm_sResult = null;
        String lm_sSrc = pm_sSrc;
        int lm_iIndex = 0;

        ArrayList<String> lm_oList = new ArrayList<String>();

        while(true) {
            lm_iIndex = lm_sSrc.indexOf(pm_sDelim);

            if(lm_iIndex == -1) {
                lm_oList.add(lm_sSrc);
                break;
            } else {
                lm_oList.add(lm_sSrc.substring(0, lm_iIndex));
                lm_sSrc = lm_sSrc.substring(lm_iIndex + pm_sDelim.length());
            }
        }

        lm_sResult = new String[lm_oList.size()];

        for(int i=0; i<lm_oList.size(); i++) {
            lm_sResult[i] = lm_oList.get(i);
        }

        return lm_sResult;

    }

    /**
     * ���ڿ��� �����ڸ� �Ѱܹ޾� �����ڷ� �и��� ��ū ���� ��ȯ�ϴ� �޼ҵ�.
     *
     * @param String pm_sSrc   : �迭�� �и��� ���ڿ�
     * @param String pm_sDelim : ������
     * @return int lm_iCnt     : �����ڷ� �и��� ��ū ��
     */
    public static int countToken(String pm_sSrc, String pm_sDelim) {

        if(pm_sSrc==null || pm_sSrc.length()==0) {
            return 0;
        }

        int lm_iCnt = 0; //��ū ��
        String lm_sSrc = pm_sSrc;
        int lm_iIndex = 0;

        while(true) {
            lm_iIndex = lm_sSrc.indexOf(pm_sDelim);

            if(lm_iIndex == -1) {
                lm_iCnt++;
                break;
            } else {
                lm_iCnt++;
                lm_sSrc = lm_sSrc.substring(lm_iIndex + pm_sDelim.length());
            }
        }

        return lm_iCnt;

    }

    public static String replace(String strSrc, String strOri, String strDes) {
        StringBuffer sbTmp = new StringBuffer("");

        int intSrc = 0;
        int intOri = 0;

        if(strSrc == null || strOri == null || strDes == null) {
            return null;
        }

        intSrc = strSrc.length();
        intOri = strOri.length();

        for(int i = 0; i < strSrc.length(); i++) {
            if (i <= (intSrc-intOri) && strOri.equals(strSrc.substring(i, i+intOri))) {
                sbTmp.append(strDes);
                i = i + intOri-1;
            } else {
                sbTmp.append( strSrc.charAt(i) );
            }
        }

        return sbTmp.toString();
    }

    public static int getStrLen(String str) {
        return str.getBytes().length;
    }

    public static void main(String[] args){
        //PrintManager.debug("moneny :"+StringHandler.toMoneyStr(0));
        System.out.println(StringHandler.replaceBR("http://%IPADDRESS%/tmpupload.kth", "%IPADDRESS%", "61.73.60.61"));
        String defaultImg = "/img/img_profile/profile_"+StringHandler.getZeroString(new Random().nextInt(50),2)+".jpg";
        System.out.println(defaultImg);
    }




    /**
     * õ������ , ����ֱ�..
     * @param str
     * @return
     */
    public static String reformNum (String str){
        String rst = "";
        while(str.length()>3){
            rst = ","+str.substring(str.length()-3)+rst;
            str = str.substring(0,str.length()-2);
        }
        rst = str+rst;
        return rst;
    }
    /**
     * õ������ , ����ֱ�..
     * @param num
     * @return
     */
    public static String reformNum (int num){
        String rst = "";
        String str = num+"";
        while(str.length()>3){
            rst = ","+str.substring(str.length()-3)+rst;
            str = str.substring(0,str.length()-2);
        }
        rst = str+rst;
        return rst;
    }

    /**
    * ��Ʈ�� �ڸ���
    * ������ ������ ���� ��ŭ ��ĭ(" ")�� ��Ʈ���� ���Ѵ�.
    * ��ܵ� String�� ����Ʈ ���� �ڸ� ����Ʈ ������ ���� �ʵ��� �Ѵ�.
    *
    * @param str �� String
    * @param int �ڸ� ����Ʈ ����
    * @param char + or -
    * @return String ��ܵ� String
    */
    public static String cutStr(String str, int length ,char type) {
        byte[] bytes = str.getBytes();
        int len = bytes.length;
        int counter = 0;

        if (length >= len) {
            StringBuffer sb = new StringBuffer();
            sb.append(str);
            for(int i=0;i<length-len;i++){
                sb.append(' ');
            }
            return sb.toString();
        }

        for (int i = length - 1; i >= 0; i--) {
            if (((int)bytes[i] & 0x80) != 0)
                counter++;
        }

        String f_str = null;

        if(type == '+'){
            f_str = new String(bytes, 0, length + (counter % 2));
        }else if(type == '-'){
            f_str = new String(bytes, 0, length - (counter % 2));
        }else{
            f_str = new String(bytes, 0, length - (counter % 2));
        }

        return f_str;
    }
    //----------------------------------------------------------------------------------------------------//

    /**
     * ������ ��� ��ȭ��ȣ�� ������ �־� ����
     * @param inStr : ��� ���ڿ�
     * @param delim : ������
     * @return
     */
    public String telFormat(String inStr, char delim) {

        StringBuffer sb  = new StringBuffer("");
        String       str = null;

        if (inStr == null)
            return null;

        str = inStr.trim();

        if (str.length() < 1)
            return null;

        if (!chkNum(str))
            return str;

        //������ȣ  2�ڸ�
        if (str.substring(0,2).equals("02")) {

            if (str.length() == 9) {
                sb.append(str.substring(0, 2));
                sb.append(delim);
                sb.append(str.substring(2, 5));
                sb.append(delim);
                sb.append(str.substring(5, 9));

            } else if (str.length() == 10) {
                sb.append(str.substring(0, 2));
                sb.append(delim);
                sb.append(str.substring(2, 6));
                sb.append(delim);
                sb.append(str.substring(6, 10));

            } else	{
                sb.append(str);
            }

        }

        //����� �� ������ȣ 3�ڸ�
        else {

            if (str.length() == 10) {
                sb.append(str.substring(0, 3));
                sb.append(delim);
                sb.append(str.substring(3, 6));
                sb.append(delim);
                sb.append(str.substring(6, 10));

            } else if (str.length() == 11) {
                sb.append(str.substring(0, 3));
                sb.append(delim);
                sb.append(str.substring(3, 7));
                sb.append(delim);
                sb.append(str.substring(7, 11));

            } else {
                sb.append(str);
            }

        }

        return sb.toString();

    }

//----------------------------------------------------------------------------------------------------//

    /**
     * ���ڷ� ������ ���ڿ����� üũ�Ͽ�, ��� �����̸� true
     * @param str : ��� ���ڿ�
     * @return
     */
    public boolean chkNum(String str)	{

        boolean rCode = true;

        for(int i=0; i < str.length(); i++) {

            if ((str.substring(i, i+1).compareTo("0") >= 0) && (str.substring(i, i+1).compareTo("9") <= 0)) {

            } else	{
                rCode = false;
                break;
            }

        }

        return rCode;

    }

    //----------------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------------//
    public static String TelFor(String Tel) {
                 String tel1, tel2, tel3, tel4 = "-", Telnumber;

                 if(Tel.length() == 11) {
                     tel1 = Tel.substring(0,3);
                     tel2 = Tel.substring(3,7);
                     tel3 = Tel.substring(7,11);

                     Telnumber = tel1 + tel4 + tel2 + tel4 + tel3;

                     return Telnumber;
                 }
                 else if (Tel.length() == 10) {
                     if ("02".equals(Tel.substring(0,2))) {
                         tel1 = Tel.substring(0,2);
                         tel2 = Tel.substring(2,6);
                         tel3 = Tel.substring(6);
                     } else {
                        tel1 = Tel.substring(0,3);
                        tel2 = Tel.substring(3,6);
                        tel3 = Tel.substring(6,10);
                     }
                     Telnumber = tel1 + tel4 + tel2 + tel4 + tel3;

                     return Telnumber;
                 }
                 else if (Tel.length() == 9) {
                     tel1 = Tel.substring(0,2);
                     tel2 = Tel.substring(2,5);
                     tel3 = Tel.substring(5,9);

                     Telnumber = tel1 + tel4 + tel2 + tel4 + tel3;

                     return Telnumber;
                 }
                 else {
                     Telnumber = Tel;
                     return Telnumber;
                 }
             }

	public static String toStringChangeTag(String inputVal) {
		String returnVal = inputVal;
        if(returnVal==null || returnVal.equals("null") || returnVal.equals("NULL") || returnVal.length() < 1) return "";
        else{
            for(int i=0;i<convertStr.length;i++){
                returnVal = returnVal.replaceAll(convertStr[i][0], convertStr[i][1]).trim();
            }

            return convertToBR(returnVal);
        }
	}
	
	public static String toStringChangeTag2(String inputVal) {
		String returnVal = "";
		if(inputVal==null || inputVal.equals("null") || inputVal.equals("NULL") || inputVal.length() < 1) return "";
		else{
			for(int i=0;i<convertStr2.length;i++){
				inputVal = inputVal.replaceAll(convertStr2[i][0], convertStr2[i][1]).trim();
				
			}
			
			if (inputVal.length() > 1 && inputVal.substring(0, 1).equals("〈")) {
				
				StringTokenizer st = new StringTokenizer(inputVal, "〈");
				
				while(st.hasMoreTokens()) {
					
					String nt = st.nextToken();
						if (nt.substring(0, 1).equals("/")) {
							nt = "<font class='b13px'>〈"+nt.substring(0,nt.indexOf("〉")+1)+"</font>"+nt.substring(nt.indexOf("〉")+1,nt.length());
							returnVal += nt+" ";
						} else {
							nt = "<br><font class='b13px'>〈"+nt.substring(0,nt.indexOf("〉")+1)+"</font><B style='color:#000000'>"+nt.substring(nt.indexOf("〉")+1,nt.length())+"</B>";
							returnVal += nt+" ";
						}
				}
			} else {
				returnVal = inputVal;
			}
			//returnVal = returnVal.replaceAll("〈","<br><font class='b13px'>〈");
			//returnVal = returnVal.replaceAll("〉","〉</font>");
			return returnVal;
		}
	}

	public static String toStringChangeTag3(String inputVal) {
		String returnVal = "";
		if(inputVal==null || inputVal.equals("null") || inputVal.equals("NULL") || inputVal.length() < 1) return "";
		else{
			
			/*
			for(int i=0;i<convertStr2.length;i++){
				inputVal = inputVal.replaceAll(convertStr2[i][0], convertStr2[i][1]).trim();
				
			}
			*/
			
			//System.out.println("inputVal.(0,4) ::: " + inputVal.substring(0, 4));
			
			if (inputVal.length() > 4 && inputVal.substring(0, 4).equals("&lt;")) {
				
				String st []  = inputVal.split("&lt;");
				
				for (int j=0 ; j<st.length ; j++) {
					
					String nt = st[j];
					//System.out.println("nt == " + nt);
					
					if (nt.length() > 0 && nt.substring(0, 1).equals("/")) {
						nt = "<font class='b13px'>&lt;"+nt.substring(0,nt.indexOf("&gt;")+4)+"</font>"+nt.substring(nt.indexOf("&gt;")+4,nt.length());
						returnVal += nt+" ";
					} else if (nt.length() > 0 && !nt.substring(0, 1).equals("/")){
						nt = "<br><font class='b13px'>&lt;"+nt.substring(0,nt.indexOf("&gt;")+4)+"</font><B style='color:#000000'>"+nt.substring(nt.indexOf("&gt;")+4,nt.length())+"</B>";
						returnVal += nt+" ";
					}
				}
					
				
			} else {
				returnVal = inputVal;
			}
			//returnVal = returnVal.replaceAll("〈","<br><font class='b13px'>〈");
			//returnVal = returnVal.replaceAll("〉","〉</font>");
			return returnVal;
		}
	}

}

