package com.curahealthyme.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curahealthyme.model.Patient;

public interface PatientRepository  extends JpaRepository<Patient, Integer>{

}
