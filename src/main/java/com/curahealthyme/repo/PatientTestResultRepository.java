package com.curahealthyme.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curahealthyme.model.PatientTestResult;

public interface PatientTestResultRepository  extends JpaRepository<PatientTestResult, Integer>{

}
