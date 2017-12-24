package com.food.util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtil {
/*public static String convertJavaToJson(Object obj) throws JsonGenerationException, JsonMappingException, IOException{
	String json="{}";
	ObjectMapper ObjectMapper=new ObjectMapper();
	json=ObjectMapper.writeValueAsString(obj);
	return json;
}*/
public static <T> T convertJsonToJava(String jsonStr, Class<T> targetClas) throws JsonParseException, JsonMappingException, IOException{
	T response=null;
	ObjectMapper ObjectMapper=new ObjectMapper();
	response=ObjectMapper.readValue(jsonStr, targetClas);
	return response;
}
}
