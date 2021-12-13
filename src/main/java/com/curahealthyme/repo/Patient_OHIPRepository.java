package com.curahealthyme.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.curahealthyme.model.Appointments;
import com.curahealthyme.model.Patient_Doctor_Join;
import com.curahealthyme.model.Patient_OHIP;

public interface Patient_OHIPRepository  extends CrudRepository<Patient_OHIP, Long>{
	@Query("SELECT u.Ohip FROM Patient_OHIP u WHERE u.PatientId = ?1")
    public String findPatientOHIP(long patientId);
	
}
