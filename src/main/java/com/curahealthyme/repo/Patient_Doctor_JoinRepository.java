package com.curahealthyme.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.curahealthyme.model.Patient;
import com.curahealthyme.model.Patient_Doctor_Join;

@Repository
public interface Patient_Doctor_JoinRepository  extends CrudRepository<Patient_Doctor_Join, Long>{
	@Query("SELECT u FROM Patient_Doctor_Join u WHERE u.PatientId = ?1")
    public Patient_Doctor_Join getFamilyDoctorId(long patientId);
	
	@Query("SELECT u.PatientId FROM Patient_Doctor_Join u WHERE u.DoctorId = ?1")
    public List<Long> getDataByDoctor(long doctorId);
	@Query("SELECT u.Id FROM Patient_Doctor_Join u WHERE u.DoctorId = ?1 AND u.PatientId = ?2")
    public long getJoinIdBypatientdoctorId(long doctorId, long patientId);
	@Query("SELECT u FROM Patient_Doctor_Join u WHERE u.Id = ?1")
    public Patient_Doctor_Join findByJoinId(long id);
}
