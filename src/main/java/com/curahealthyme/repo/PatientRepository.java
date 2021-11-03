package com.curahealthyme.repo;

import org.springframework.data.repository.CrudRepository;

import com.curahealthyme.model.Patient;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository  extends CrudRepository<Patient, Long>{

}
