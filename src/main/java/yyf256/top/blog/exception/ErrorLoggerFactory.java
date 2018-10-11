package yyf256.top.blog.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;

public class ErrorLoggerFactory {
	private Logger logger=Logger.getLogger(getClass());
	
	private static ErrorLoggerFactory factory;
	
	private ErrorLoggerFactory(){}
	
	public static final ErrorLoggerFactory getInstance(){
		if(factory==null){
			factory=new ErrorLoggerFactory();
		}
		return factory;
	}
	
	
	public void LoggerException(BaseException e){
		logger.error("异常类型："+e.getExceptionType().getName()+"\r\n"+getStackTraceInfo(e));
	}
	
	/**
	 * 获取异常栈中的异常信息
	 * @param e
	 * @return
	 */
   public static String getStackTraceInfo(Exception e) {

        StringWriter sw = null;
        PrintWriter pw = null;

        try {
            sw = new StringWriter();
            pw = new PrintWriter(sw);
            e.printStackTrace(pw);//将出错的栈信息输出到printWriter中
            pw.flush();
            sw.flush();

            return sw.toString();
        } catch (Exception ex) {

            return "获取异常栈中信息发生错误";
        } finally {
            if (sw != null) {
                try {
                    sw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (pw != null) {
                pw.close();
            }
        }

    }

}
