package com.curahealthyme.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.curahealthyme.model.Patient_Doctor_Join;
import com.curahealthyme.model.Patient_OHIP;

public interface Patient_OHIPRepository  extends CrudRepository<Patient_OHIP, Long>{

	
}
