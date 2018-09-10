package com.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.tomcat.util.buf.HexUtils;

public class MD5Test {
    public static final String key_ = "MD5";
    
    public static String setMd5(String message) {
    	String result = "";
    	try {
			MessageDigest md = MessageDigest.getInstance(key_);
			byte [] bts = md.digest(message.getBytes());
		
			result = toHexString(bts);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
    	
    }
    
	public static String toHexString(byte[] datas) {
		StringBuilder sb = new StringBuilder();
		for ( int i = 0; i < datas.length; i++ ) {
			String hex = Integer.toHexString(datas[i] & 0xFF);
			if ( hex.length() <= 1 ) {
				sb.append('0');
			}
			sb.append(hex);
		}
		return sb.toString();
	}
	
    /** 
     * 加密解密算法 执行一次加密，两次解密 
     */   
    public static String convertMD5(String inStr){  
  
        char[] a = inStr.toCharArray();  
        for (int i = 0; i < a.length; i++){  
            a[i] = (char) (a[i] ^ 't');  
        }  
        String s = new String(a);  
        return s;  
  
    }  
  
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String message= "123我爱你";
		String result = setMd5(message);
		System.out.println(result);
		
	    String result2 = setMd5(message);
	    
	    if(result2.equals(result)) {
	    	System.out.println(result2);
	    }
	}
	
}
