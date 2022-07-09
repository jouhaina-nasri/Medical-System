package app.medical.service;

import java.util.List;

import app.medical.dto.ClientDto;

public interface ClientService {

	public ClientDto save(ClientDto client);
    public void delete(Long id);
    public List<ClientDto> findAll(); 
    public ClientDto findById(Long id);
}
