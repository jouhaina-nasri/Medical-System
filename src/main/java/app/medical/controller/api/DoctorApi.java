package app.medical.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import app.medical.dto.DoctorDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("/doctor")
public interface DoctorApi {
	
	@PostMapping
	@ApiOperation(value="Save a doctor",notes="This method is used to save a doctor",response=DoctorDto.class)
	@ApiResponses(value = {
			@ApiResponse(code=200,message="Data successfully saved / updated"),
			@ApiResponse(code=400,message="Data not valid")
	})
	public DoctorDto save(@RequestBody DoctorDto doctor);
	
	@DeleteMapping("/{id}")
	@ApiOperation(value="Delete a doctor",notes="This method is used to delete a doctor",response=DoctorDto.class)
	@ApiResponses(value = {
			@ApiResponse(code=200,message="Data successfully deleted")
	})
    public void delete(@PathVariable("id") Long id);
	
	@GetMapping
	@ApiOperation(value="Find all appointments",notes="This method is used to find all appointments",responseContainer="List<DoctorDto>")
	@ApiResponses(value = {
			@ApiResponse(code=200,message="Data successfully find")
	})
    public List<DoctorDto> findAll();
	
	@GetMapping("/{specialty}")
	@ApiOperation(value="Find a doctor",notes="This method is used to search a doctor by specialty",response=DoctorDto.class)
	@ApiResponses(value = {
			@ApiResponse(code=200,message="Data successfully find"),
			@ApiResponse(code=404,message="Data not find")
	})
	public DoctorDto findBySpecialty(@PathVariable("specialty") String specialty);
	
	@GetMapping("/{specialty}/{address}")
	@ApiOperation(value="Find a doctor",notes="This method is used to search a doctor by specialty and address",response=DoctorDto.class)
	@ApiResponses(value = {
			@ApiResponse(code=200,message="Data successfully find"),
			@ApiResponse(code=404,message="Data not find")
	})
	public DoctorDto findBySpecialtyAndAddress(@PathVariable("specialty") String specialty, @PathVariable("address")String address);
}