package com.spring.util;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;

public class DigestUtil {
	
    public static final String ALGORITHM_SHA512 = "SHA-512";

    public static byte[] digest(byte[] data, String algorithm) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(data);
            return md.digest();
        } catch (Exception ex) {
            throw new RuntimeException("Message digest error", ex);
        }
    }

    public static String digest(String s) throws Exception { 
        byte[] result = digest(s.getBytes(), ALGORITHM_SHA512);
        return Base64.encodeBase64String(result);
    }
   
}
