package com.curahealthyme.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curahealthyme.model.Disease;

public interface DiseaseRepository  extends JpaRepository<Disease, Integer>{

}
