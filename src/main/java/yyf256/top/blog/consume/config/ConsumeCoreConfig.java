package yyf256.top.blog.consume.config;

import java.util.Random;

public class ConsumeCoreConfig {
	
	/**
	 * token值
	 */
//	public static String token="";
	public static String token="123456";
	
	/**
	 * token长度
	 */
	public static final int TOKEN_LENGTH=6;
	/**
	 * 登录情况下不需要传入token，用这个默认值替代
	 */
	public static final String DEFAULT_TOKEN="NULL";
	
	
	public static String setAndGetToeken(){
		Random random=new Random();
		StringBuilder newToken=new StringBuilder();
		for(int i=0;i<TOKEN_LENGTH;i++){
			newToken.append(random.nextInt(10));
		}
		token=newToken.toString();
		return token;
	}
	
	public static boolean tokenIsCorrect(String checkToken){
		if(DEFAULT_TOKEN.equals(checkToken)){
			return true;
		}
		if(!token.equals("") && token.equals(checkToken)){
			return true;
		}else{
			return false;
		}
	}
}
