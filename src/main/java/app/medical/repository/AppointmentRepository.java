package app.medical.repository;

import java.time.Instant;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.medical.entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository <Appointment,Long> {

	@Query("SELECT a FROM Appointment a WHERE a.date = :date")
	Optional<Appointment> searchByDate(@Param("date") Instant date);
}
