package app.medical.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import app.medical.dto.ClientDto;

public class ClientValidator {
	
	public static List<String> validate(ClientDto clientDto)
	{
		List<String> errors = new ArrayList<String>();
		
		if(clientDto == null) {
			
			errors.add("Please enter firstname!");
			errors.add("Please enter lastname!");
			errors.add("Please enter phone number!");
			return errors;
		}
		
		if(!StringUtils.hasLength(clientDto.getFirstname())) {
			
			errors.add("Please enter firstname!");
		}
		
		if(!StringUtils.hasLength(clientDto.getLastname())) {
			
			errors.add("Please enter lastname!");
		}
		
		if(!StringUtils.hasLength(clientDto.getPhone())) {
			
			errors.add("Please enter phone number!");
		}
		
		return errors;
	}

}
