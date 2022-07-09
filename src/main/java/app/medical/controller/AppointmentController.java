package app.medical.controller;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.medical.controller.api.AppointmentApi;
import app.medical.dto.AppointmentDto;
import app.medical.entity.Appointment;
import app.medical.service.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController implements AppointmentApi {
	
	
	AppointmentService appointmentService;
	
	@Autowired
	public AppointmentController(AppointmentService appointmentService)
	{
		this.appointmentService=appointmentService;
	}
	
	@Override
	public void save(Long idClient,Long IdDoctor,Appointment appointment)
	{
		 appointmentService.save(idClient,IdDoctor,appointment);
	}
	
	@Override
    public void delete(Long id)	{
		 appointmentService.delete(id);
	}
	
	@Override
    public List<AppointmentDto> findAll()	{
		return appointmentService.findAll();
	}
	
	@Override
    public AppointmentDto findByDate(Instant date)	{
		return appointmentService.findByDate(date);
	}

}
