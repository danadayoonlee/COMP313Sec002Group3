package com.curahealthyme.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curahealthyme.model.DiseaseSymptoms;

public interface DiseaseSymptomsRepository  extends JpaRepository<DiseaseSymptoms, Integer>{

}
