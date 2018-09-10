package com.util;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.util.Base64Utils;

public class Base64Test {
	public static  String entryBase(byte[] key) {
	
		return (new String(Base64Utils.encode(key)));
		
	}
	
	public static String decryCode(String key) {
		
		return new String(Base64Utils.decodeFromString(key));
		
	}
	
	public static void decryFile(String codes) throws IOException {
		byte[] bt = Base64Utils.decodeFromString(codes);
		for(int i = 0; i<bt.length;++i) {
			if(bt[i] < 0) {
				bt[i] += 256;
			}
		}
		
		String path = "C://data/abc.png";
		try {
			OutputStream output = new FileOutputStream(path);
			output.write(bt);
			output.flush();
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
   public static void main(String[] args) throws IOException {
	   File file = new File("C://develop/weixin/weixinweb/images/home.png");
	   byte [] data = null;
	   InputStream input  = null;
	   try {
		input = new FileInputStream(file);
		data = new byte[input.available()];
		input.read(data);
		input.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   String src = "abbbbbbbbbccccccc今天是个好日子";
	   String encode = entryBase(data);
	   String enCode2 = entryBase(src.getBytes());
	   System.out.println(enCode2);
	
	   String decode = decryCode(enCode2);
	   System.out.println("decode=====" + decode);
	   
	   decryFile(encode);
}
}
