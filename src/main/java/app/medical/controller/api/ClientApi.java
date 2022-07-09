package app.medical.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import app.medical.dto.ClientDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("/client")
public interface ClientApi {
	
	@PostMapping
	@ApiOperation(value="Save a client",notes="This method is used to save a client",response=ClientDto.class)
	@ApiResponses(value = {
			@ApiResponse(code=200,message="Data successfully saved / updated"),
			@ApiResponse(code=400,message="Data not valid")
	})
	public ClientDto save(@RequestBody ClientDto client);
	
	@DeleteMapping("/{id}")
	@ApiOperation(value="Delete a client",notes="This method is used to delete a client",response=ClientDto.class)
	@ApiResponses(value = {
			@ApiResponse(code=200,message="Data successfully deleted")
	})
    public void delete(@PathVariable("id") Long id);
	
	@GetMapping
	@ApiOperation(value="Find all clients",notes="This method is used to find all clients",responseContainer="List<ClientDto>")
	@ApiResponses(value = {
			@ApiResponse(code=200,message="Data successfully find")
	})
    public List<ClientDto> findAll();

}