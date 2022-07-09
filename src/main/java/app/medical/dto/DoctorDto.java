package app.medical.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import app.medical.entity.Appointment;
import app.medical.entity.Doctor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DoctorDto {
	
	private Long id;

	private String firstname;

	private String lastname;

	private String specialty;

	private String address;

	private String phone;
	
	@JsonIgnore
	private List<Appointment> appointment;
	
	public static DoctorDto fromEntity(Doctor doctor)
	{
		if(doctor == null)
		{
			return null;
		}
		
		return DoctorDto.builder()
				.id(doctor.getId())
				.firstname(doctor.getFirstname())
				.lastname(doctor.getLastname())
				.specialty(doctor.getSpecialty())
				.address(doctor.getAddress())
				.phone(doctor.getPhone())
				.build();
	}
	//Mapping Entity to DTO 
	
	public static Doctor toEntity(DoctorDto doctorDto)
	{
		if(doctorDto == null)
		{
			return null;
		}
		
		Doctor doctor = new Doctor();
		doctor.setId(doctorDto.getId());
		doctor.setFirstname(doctorDto.getFirstname());
		doctor.setLastname(doctorDto.getLastname());
		doctor.setSpecialty(doctorDto.getSpecialty());
		doctor.setAddress(doctorDto.getAddress());
		doctor.setPhone(doctorDto.getPhone());
		
		return doctor;
	}
	//Mapping DTO to Entity 
}
