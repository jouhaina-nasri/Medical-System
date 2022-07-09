package app.medical.service;


import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.medical.dto.AppointmentDto;
import app.medical.entity.Appointment;
import app.medical.entity.Client;
import app.medical.entity.Doctor;
import app.medical.exception.EntityNotFoundException;
import app.medical.exception.ErrorsCodes;
import app.medical.repository.AppointmentRepository;
import app.medical.repository.ClientRepository;
import app.medical.repository.DoctorRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AppointmentServiceImpl implements AppointmentService {
	
	AppointmentRepository appointmentRepository; 
	ClientRepository clientRepository; 
	DoctorRepository doctorRepository; 
	
	@Autowired
	public AppointmentServiceImpl(AppointmentRepository appointmentRepository,ClientRepository clientRepository,DoctorRepository doctorRepository)
	{
		this.appointmentRepository = appointmentRepository;
		this.clientRepository = clientRepository;
		this.doctorRepository = doctorRepository;
	}

	@Override
	public void save(Long IdClient,Long IdDoctor,Appointment appointment) {
		
		Client client = clientRepository.findById(IdClient).orElse(null);
		Doctor doctor = doctorRepository.findById(IdDoctor).orElse(null);
		
		appointment.setClient(client);
		appointment.setDoctor(doctor);
		if(client==null)
		{
			log.warn("Client with ID {} was not found in the DB", IdClient);
			throw new EntityNotFoundException("Not exist any client with ID "+IdClient+" in data base",ErrorsCodes.CLIENT_NOT_FOUND);
		}
		

		if(doctor==null)
		{
			log.warn("Doctor with ID {} was not found in the DB", IdDoctor);
			throw new EntityNotFoundException("Not exist any doctor with ID "+IdDoctor+" in data base",ErrorsCodes.DOCTOR_NOT_FOUND);
		}
		
		appointmentRepository.save(appointment);
	}


	@Override
	public void delete(Long id) {
		appointmentRepository.deleteById(id);
	}

	@Override
	public List<AppointmentDto> findAll() {
		return appointmentRepository.findAll().stream().map(AppointmentDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public AppointmentDto findByDate(Instant date) {
		if(date == null)
		{
			return null;
		}
		Optional<Appointment> appointment = appointmentRepository.searchByDate(date);
		
		AppointmentDto appointmentDto = AppointmentDto.fromEntity(appointment.get());
		
		return Optional.of(appointmentDto).orElseThrow( () ->
		new EntityNotFoundException("Not exist any appointment on = "+date,ErrorsCodes.APPOINTMENT_NOT_FOUND)	
			);
	}
	
	
}
