package com.curahealthyme.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curahealthyme.model.PatientCOVID19Screening;

public interface PatientCovid19Repository  extends JpaRepository<PatientCOVID19Screening, Integer>{

}
