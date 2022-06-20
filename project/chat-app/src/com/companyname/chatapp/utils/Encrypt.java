package com.companyname.chatapp.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface Encrypt {
     public static String passwordEncrypt(String plainPassword) throws NoSuchAlgorithmException {
    	 String encryptedPassword=null;
    	 MessageDigest messageDigest =MessageDigest.getInstance("MD5");//message digest use 
    	 messageDigest.update(plainPassword.getBytes());//update ourpassword to hashed one(bytes)
    	 byte[] encrypt=messageDigest.digest();
    	 StringBuffer sb=new StringBuffer();
    	 for(byte b:encrypt)
    	 {
    		 sb.append(b);
    	 }
    	 encryptedPassword=sb.toString();
    	 return encryptedPassword;
     }
   
}
