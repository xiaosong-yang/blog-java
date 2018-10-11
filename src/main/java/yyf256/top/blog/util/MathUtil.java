package yyf256.top.blog.util;

import java.text.DecimalFormat;

public class MathUtil {
	public static String formatDouble(Double x,String format){
		DecimalFormat decimalFormat=new DecimalFormat(format);
		return decimalFormat.format(x);
	}
	
	public static String formatFloat(Float x,String format){
		DecimalFormat decimalFormat=new DecimalFormat(format);
		return decimalFormat.format(x);
	}
}
