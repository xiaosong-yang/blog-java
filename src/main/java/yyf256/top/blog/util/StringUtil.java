package yyf256.top.blog.util;

public class StringUtil {
	/**
	 * 判断字符串是否为空，null和空字符串都为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str!=null && !"".equals(str)){
			return true;
		}
		return false;
	}
}
