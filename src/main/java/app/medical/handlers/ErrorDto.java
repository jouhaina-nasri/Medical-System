package app.medical.handlers;

import java.util.ArrayList;
import java.util.List;

import app.medical.exception.ErrorsCodes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDto {

	private int HttpCode;
	
	private ErrorsCodes errorCode;
	
	private String message;

	private List<String> errors = new ArrayList<String>();
	
	
}
