package com.curahealthyme.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curahealthyme.model.Symptoms;

public interface SymptomsRepository  extends JpaRepository<Symptoms, Integer>{

}
