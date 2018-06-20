package com.app.util;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class CodeUtil {

	private String getCommonStr(int length){
		return UUID.randomUUID()
		.toString()
		.replace("-", "")
		.substring(0, length);
	}
	
	public String genToken(){
		return getCommonStr(8);
	}
	public String getPwd(){
		return getCommonStr(6);
	}
	
	
	
	
	
	
	
	
	
	
}
