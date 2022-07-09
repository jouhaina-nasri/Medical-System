package app.medical.controller.api;

import java.time.Instant;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import app.medical.dto.AppointmentDto;
import app.medical.entity.Appointment;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("/appointment")
public interface AppointmentApi {
	
	@PostMapping("/{idClient}/{idDoctor}")
	@ApiOperation(value="Save an appointment",notes="This method is used to save an appointment",response=AppointmentDto.class)
	@ApiResponses(value = {
			@ApiResponse(code=200,message="Data successfully saved / updated"),
			@ApiResponse(code=400,message="Data not valid")
	})
	public void save(@PathVariable("idClient") Long idClient,@PathVariable("idDoctor") Long idDoctor,@RequestBody Appointment appointment);
	
	@DeleteMapping("/{id}")
	@ApiOperation(value="Delete an appointment",notes="This method is used to delete an appointment",response=AppointmentDto.class)
	@ApiResponses(value = {
			@ApiResponse(code=200,message="Data successfully deleted")
	})
    public void delete(@PathVariable("id") Long id);
	
	@GetMapping
	@ApiOperation(value="Find all appointments",notes="This method is used to find all appointments",responseContainer="List<AppointmentDto>")
	@ApiResponses(value = {
			@ApiResponse(code=200,message="Data successfully find")
	})
    public List<AppointmentDto> findAll();
	
	@GetMapping("/{date}")
	@ApiOperation(value="Find an appointment",notes="This method is used to search an appointment by date",response=AppointmentDto.class)
	@ApiResponses(value = {
			@ApiResponse(code=200,message="Data successfully find"),
			@ApiResponse(code=404,message="Data not find")
	})
	public AppointmentDto findByDate(@PathVariable("date") Instant date);
}
