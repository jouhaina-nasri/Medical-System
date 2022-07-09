package app.medical.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.medical.controller.api.ClientApi;
import app.medical.dto.ClientDto;
import app.medical.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController implements ClientApi {

	private final ClientService clientService;

	@Autowired
	public ClientController(ClientService clientService) {
	  this.clientService = clientService;
	 }
	
	@Override
	public ClientDto save(ClientDto client){
		return clientService.save(client);
	}
	
	@Override
    public void delete(Long id){
		 clientService.delete(id);
	}
	
	@Override
    public List<ClientDto> findAll(){
		return clientService.findAll();
	}
}
