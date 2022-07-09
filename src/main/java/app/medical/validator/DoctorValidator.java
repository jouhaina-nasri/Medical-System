package app.medical.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import app.medical.dto.DoctorDto;

public class DoctorValidator {
	
	public static List<String> validate(DoctorDto doctorDto)
	{
		List<String> errors = new ArrayList<String>();
		
		if(doctorDto == null) {
			
			errors.add("Please enter firstname!");
			errors.add("Please enter lastname!");
			errors.add("Please enter speciality!");
			errors.add("Please enter address!");
			errors.add("Please enter phone number!");
			return errors;
		}
		
		if(!StringUtils.hasLength(doctorDto.getFirstname())) {
			
			errors.add("Please enter firstname!");
		}
		
		if(!StringUtils.hasLength(doctorDto.getLastname())) {
			
			errors.add("Please enter lastname!");
		}
		
		if(!StringUtils.hasLength(doctorDto.getSpecialty())) {
			
			errors.add("Please enter speciality!");
		}
		
		if(!StringUtils.hasLength(doctorDto.getAddress())) {
			
			errors.add("Please enter address!");
		}
		
		if(!StringUtils.hasLength(doctorDto.getPhone())) {
			
			errors.add("Please enter phone number!");
		}
		
		return errors;
	}

}
