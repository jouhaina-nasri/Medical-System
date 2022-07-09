package app.medical.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import app.medical.entity.Appointment;
import app.medical.entity.Client;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDto {
	
	private Long id;

	private String firstname;

	private String lastname;

	private String phone;
	
	@JsonIgnore
	private List<Appointment> appointment;
	
	public static ClientDto fromEntity(Client client)
	{
		if(client == null)
		{
			return null;
		}
		
		return ClientDto.builder()
				.id(client.getId())
				.firstname(client.getFirstname())
				.lastname(client.getLastname())
				.phone(client.getPhone())
				.build();
	}

	public static Client toEntity(ClientDto clientDto)
	{
		if(clientDto == null)
		{
			return null;
		}
		
		Client client = new Client();
		client.setId(clientDto.getId());
		client.setFirstname(clientDto.getFirstname());
		client.setLastname(clientDto.getLastname());
		client.setPhone(clientDto.getPhone());
		
		return client;

	}

}