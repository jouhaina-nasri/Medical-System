package app.medical.service;

import java.util.List;

import app.medical.dto.DoctorDto;

public interface DoctorService {

	public DoctorDto save(DoctorDto doctor);
    public void delete(Long id);
    public List<DoctorDto> findAll();
    public DoctorDto findBySpecialty(String specialty);
    public DoctorDto findBySpecialtyAndAddress(String specialty,String address);
    public DoctorDto findByID(Long id);
}
