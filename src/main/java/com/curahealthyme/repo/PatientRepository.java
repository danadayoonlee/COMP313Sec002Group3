package com.curahealthyme.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.curahealthyme.model.Patient;
import com.curahealthyme.model.UserAccess;

import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository  extends CrudRepository<Patient, Long>{
	@Query("SELECT u FROM Patient u WHERE u.LoginId = ?1")
    public Patient findPatientByLoginId(long id);
	@Query("SELECT u FROM Patient u WHERE u.PatientId = ?1")
    public Patient findByPatientId(long id);
	@Query("SELECT u FROM Patient u WHERE u.PatientId in ?1")
    public List<Patient> findByIds(List<Long> id);
}
