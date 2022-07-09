package app.medical.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.medical.dto.ClientDto;
import app.medical.entity.Client;
import app.medical.exception.EntityNotFoundException;
import app.medical.exception.ErrorsCodes;
import app.medical.exception.InvalidEntityException;
import app.medical.repository.ClientRepository;
import app.medical.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {
	
	ClientRepository clientRepository;
	
	@Autowired
	public ClientServiceImpl(ClientRepository clientRepository)
	{
		this.clientRepository=clientRepository;
	}

	@Override
	public ClientDto save(ClientDto client) {
		List<String> errors = ClientValidator.validate(client);
		if(!errors.isEmpty())
		{
			log.error("Client is not valid",client);
			throw new InvalidEntityException("Client is not valid",ErrorsCodes.CLIENT_NOT_VALID,errors);
		}
		return ClientDto.fromEntity(clientRepository.save(ClientDto.toEntity(client)));
	}


	@Override
	public void delete(Long id) {
		clientRepository.deleteById(id);
	}

	@Override
	public List<ClientDto> findAll() {
		return clientRepository.findAll().stream().map(ClientDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public ClientDto findById(Long id) {
		if(id==null)
		{
			return null;
		}
		Optional<Client> client = clientRepository.findById(id);
		
		ClientDto clientDto = ClientDto.fromEntity(client.get());
		
		return Optional.of(clientDto).orElseThrow( () ->
			new EntityNotFoundException("Not exist any client with id = "+id,ErrorsCodes.CLIENT_NOT_FOUND)	
				);
	}

}