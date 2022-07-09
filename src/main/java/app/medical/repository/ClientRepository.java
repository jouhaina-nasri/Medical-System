package app.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.medical.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository <Client,Long> {

	
}
