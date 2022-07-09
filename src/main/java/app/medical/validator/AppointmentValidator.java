package app.medical.validator;

import java.util.ArrayList;
import java.util.List;

import app.medical.dto.AppointmentDto;

public class AppointmentValidator {

	public static List<String> validate(AppointmentDto appointmentDto)
	{
		List<String> errors = new ArrayList<String>();
		
		if(appointmentDto==null) {
			errors.add("Please enter a date of appointment !");
			errors.add("Please select a client !");
			errors.add("Please select a doctor !");
			return errors;
		}
		
		if(appointmentDto.getDate()==null) {
			errors.add("Please enter a date of appointment !");
		}

		if(appointmentDto.getClient()==null) {
			errors.add("Please select a client !");
		}
		
		if(appointmentDto.getDoctor()==null) {
			errors.add("Please select a doctor !");
		}
		return errors;
	}
}
