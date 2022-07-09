package app.medical.exception;

import lombok.Getter;

public enum ErrorsCodes {
	
	DOCTOR_NOT_FOUND(1000),
	DOCTOR_NOT_VALID(1001),
	CLIENT_NOT_FOUND(2000),
	CLIENT_NOT_VALID(2001),
	APPOINTMENT_NOT_FOUND(3000),
	APPOINTMENT_NOT_VALID(3001)
	;
	
	@Getter
	private int code;

	private ErrorsCodes(int code) {
		this.code = code;
	}

}
