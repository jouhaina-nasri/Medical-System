package app.medical.dto;

import java.time.Instant;

import app.medical.entity.Appointment;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppointmentDto {
	
	private Long id;
	
	private Instant date;

	private ClientDto client;
	
	private DoctorDto doctor;
	
	public static AppointmentDto fromEntity(Appointment appointment)
	{
		if(appointment == null)
		{
			return null;
		}
		
		return AppointmentDto.builder()
				.id(appointment.getId())
				.date(appointment.getDate())
				.client(ClientDto.fromEntity(appointment.getClient()))
				.doctor(DoctorDto.fromEntity(appointment.getDoctor()))
				.build();
	}

	public static Appointment toEntity(AppointmentDto appointmentDto) 
	{
		if(appointmentDto == null)
		{
			return null;
		}
		Appointment appointment = new Appointment();
		appointment.setId(appointmentDto.getId());
		appointment.setDate(appointmentDto.getDate());
		return appointment;
	}
}
