package app.medical.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import app.medical.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository <Doctor,Long>{
	
	@Query("SELECT d FROM Doctor d WHERE d.specialty = :specialty")
	Optional<Doctor> searchBySpecialty(String specialty);

	@Query("SELECT d FROM Doctor d WHERE d.specialty = :specialty and d.address = :address")
	Optional<Doctor> searchBySpecialtyAndAddress(@Param("specialty") String specialty,@Param("address") String address);

}
