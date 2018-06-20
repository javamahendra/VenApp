package com.app.util;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

@Component
public class CodecUtil {

	public String doEncode(String str){
		byte[] arr=Base64.encodeBase64(str.getBytes());
		return new String(arr);
	}
	public String doDecode(String str){
		byte[] arr=Base64.decodeBase64(str.getBytes());
		return new String(arr);
	}
	
	
	
	
	
	
	
	
}
