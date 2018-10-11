package yyf256.top.blog.exception;

public abstract class BaseException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public abstract ExceptionType getExceptionType();
	

	public BaseException(String errorMsg) {
		super(errorMsg);
	}

	public BaseException(String errorMsg,Throwable cause){
		super(errorMsg, cause);
	}
	
}
