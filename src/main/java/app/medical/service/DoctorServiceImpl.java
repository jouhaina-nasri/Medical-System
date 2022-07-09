package app.medical.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import app.medical.dto.DoctorDto;
import app.medical.entity.Doctor;
import app.medical.exception.EntityNotFoundException;
import app.medical.exception.ErrorsCodes;
import app.medical.exception.InvalidEntityException;
import app.medical.repository.DoctorRepository;
import app.medical.validator.DoctorValidator;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DoctorServiceImpl implements DoctorService{
	
	DoctorRepository doctorRepository;
	
	@Autowired
	public DoctorServiceImpl(DoctorRepository doctorRepository)
	{
		this.doctorRepository=doctorRepository;
	}

	@Override
	public DoctorDto save(DoctorDto doctor) {
		
		List<String> errors = DoctorValidator.validate(doctor);
		if(!errors.isEmpty())
		{
			log.error("Doctor is not valid",doctor);
			throw new InvalidEntityException("Doctor is not valid",ErrorsCodes.DOCTOR_NOT_VALID,errors);
		}
		return DoctorDto.fromEntity(doctorRepository.save(DoctorDto.toEntity(doctor)));
	}


	@Override
	public void delete(Long id) {
		doctorRepository.deleteById(id);
	}

	@Override
	public List<DoctorDto> findAll() {
		return doctorRepository.findAll().stream().map(DoctorDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public DoctorDto findBySpecialty(String specialty) {
		if(!StringUtils.hasLength(specialty))
		{
			return null;
		}
		Optional<Doctor> doctor = doctorRepository.searchBySpecialty(specialty);
		
		DoctorDto doctorDto = DoctorDto.fromEntity(doctor.get());
		
		return Optional.of(doctorDto).orElseThrow( () ->
			new EntityNotFoundException("Not exist any doctor with speciality = "+specialty,ErrorsCodes.DOCTOR_NOT_FOUND)	
				);
	}

	@Override
	public DoctorDto findBySpecialtyAndAddress(String specialty,String address) {
		if(!StringUtils.hasLength(specialty))
		{
			return null;
		}
		Optional<Doctor> doctor = doctorRepository.searchBySpecialtyAndAddress(specialty,address);
		
		DoctorDto doctorDto = DoctorDto.fromEntity(doctor.get());
		
		return Optional.of(doctorDto).orElseThrow( () ->
			new EntityNotFoundException("Not exist any doctor with speciality = "+specialty+" and address = "+address,ErrorsCodes.DOCTOR_NOT_FOUND)	
				);
	}

	@Override
	public DoctorDto findByID(Long id) {
		if(id==null)
		{
			return null;
		}
		Optional<Doctor> doctor = doctorRepository.findById(id);
		
		DoctorDto doctorDto = DoctorDto.fromEntity(doctor.get());
		
		return Optional.of(doctorDto).orElseThrow( () ->
			new EntityNotFoundException("Not exist any doctor with id = "+id,ErrorsCodes.DOCTOR_NOT_FOUND)	
				);
	}
	
	

}
