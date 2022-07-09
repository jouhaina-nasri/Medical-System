package app.medical.exception;

import lombok.Getter;

public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	@Getter
	private ErrorsCodes errorCode;

	public EntityNotFoundException(String message) {
		super(message);
	}
	
	public EntityNotFoundException(String message, Throwable cause ) {
		super(message, cause);
	}
	
	public EntityNotFoundException(String message,ErrorsCodes errorCode ) {
		super(message);
		this.errorCode = errorCode;
	}
	
	public EntityNotFoundException(String message, Throwable cause,ErrorsCodes errorCode ) {
		super(message, cause);
		this.errorCode = errorCode;
	}

}
