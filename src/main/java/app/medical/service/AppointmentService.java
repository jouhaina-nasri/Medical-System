package app.medical.service;

import java.time.Instant;
import java.util.List;

import app.medical.dto.AppointmentDto;
import app.medical.entity.Appointment;


public interface AppointmentService {

	public void save(Long IdClient,Long IdDoctor,Appointment appointment);
    public void delete(Long id);
    public List<AppointmentDto> findAll();
    public AppointmentDto findByDate(Instant date);
}
