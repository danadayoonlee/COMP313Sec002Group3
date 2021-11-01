package com.curahealthyme.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curahealthyme.model.PatientPrescriptions;

public interface PatientPrescriptionsRepository  extends JpaRepository<PatientPrescriptions, Integer>{

}
