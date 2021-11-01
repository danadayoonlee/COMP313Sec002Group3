package com.curahealthyme.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curahealthyme.model.Prescription;

public interface PrescriptionRepository  extends JpaRepository<Prescription, Integer>{

}
