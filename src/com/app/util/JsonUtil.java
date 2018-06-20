package com.app.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class JsonUtil {

	public Object convertJsontoObject(String json,Class cls){
		Object ob=null;
		try {
			ObjectMapper om=new ObjectMapper();
			ob=om.readValue(json, cls);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ob;
	}

	public String convertObjtoJson(Object ob){
		String json=null;
		try {
			ObjectMapper om=new ObjectMapper();
			json=om.writeValueAsString(ob);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}

}
