package yyf256.top.blog.exception;

public class ConfigNullException extends BaseException{

	private static final long serialVersionUID = 1L;

	public ConfigNullException(String errorMsg) {
		super(errorMsg);
	}
	
	public ConfigNullException(String errorMsg,Throwable cause) {
		super(errorMsg, cause);
	}

	@Override
	public ExceptionType getExceptionType() {
		return ExceptionType.CONFIG_ID_NULL;
	}

}
