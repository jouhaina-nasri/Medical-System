package app.medical.exception;

import java.util.List;

import lombok.Getter;

public class InvalidEntityException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	@Getter
	private ErrorsCodes errorCode;
	@Getter
	private List<String> errors;
	
	public InvalidEntityException(String message) {
		super(message);
	}
	
	public InvalidEntityException(String message, Throwable cause ) {
		super(message, cause);
	}
	
	public InvalidEntityException(String message, Throwable cause,ErrorsCodes errorCode ) {
		super(message, cause);
		this.errorCode = errorCode;
	}
	
	public InvalidEntityException(String message,ErrorsCodes errorCode ) {
		super(message);
		this.errorCode = errorCode;
	}
	
	public InvalidEntityException(String message,ErrorsCodes errorCode, List<String> errors ) {
		super(message);
		this.errorCode = errorCode;
		this.errors    = errors;
	}

}
