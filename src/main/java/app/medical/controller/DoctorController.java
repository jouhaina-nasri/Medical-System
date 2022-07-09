package app.medical.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.medical.controller.api.DoctorApi;
import app.medical.dto.DoctorDto;
import app.medical.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController implements DoctorApi{
	
	private final DoctorService doctorService; 
	
	@Autowired
	public DoctorController(DoctorService doctorService)
	{
		this.doctorService=doctorService;
	}
	
	@Override
	public DoctorDto save(DoctorDto doctor)
	{
		return doctorService.save(doctor);
	}
	
	@Override
    public void delete(Long id)
	{
		 doctorService.delete(id);
	}
	
	@Override
    public List<DoctorDto> findAll()
	{
		return doctorService.findAll();
	}
	
	@Override
    public DoctorDto findBySpecialty(String specialty)
	{
		return doctorService.findBySpecialty(specialty);
	}
    
	@Override
    public DoctorDto findBySpecialtyAndAddress(String specialty, String address)
	{
		return doctorService.findBySpecialtyAndAddress(specialty, address);
	}
}
