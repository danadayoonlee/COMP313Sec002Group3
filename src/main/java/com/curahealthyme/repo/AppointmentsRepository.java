package com.curahealthyme.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curahealthyme.model.Appointments;

public interface AppointmentsRepository extends JpaRepository<Appointments, Integer>{

  List<Appointments> findByDoctorName(String doctorName);


  List<Appointments> findByPatientById(long id);

  	//@Query(value="", nativeQuery=true) Query needs to be corrected
  List<Appointments> findByDate(String date,String doctorName);

}
