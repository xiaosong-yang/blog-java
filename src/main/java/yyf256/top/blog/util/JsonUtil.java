package yyf256.top.blog.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	
		public static Object JsonToBean(String json,Class<?> clazz){
			Object obj=null;
	        try {
	            ObjectMapper objectMapper=new ObjectMapper();
	            obj=objectMapper.readValue(json,clazz);
	            return obj;
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	          } 
	        return obj;
		}
		
		public static <E> List<E> JsonToList(String json,Class<?> clazz){
			ObjectMapper mapper=new ObjectMapper();
			JavaType javaType=getCollectionType(ArrayList.class, clazz);
			try {
				List<E> list=mapper.readValue(json, javaType);
				return list;
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		public static JavaType getCollectionType(Class<?> collectionClass,
				Class<?>... elementClasses){
			ObjectMapper mapper=new ObjectMapper();
			return mapper.getTypeFactory().constructParametricType(collectionClass,
					elementClasses);
		}
}

