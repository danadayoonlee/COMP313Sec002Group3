package com.curahealthyme.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curahealthyme.model.Appointments;

public interface AppointmentsRepository extends JpaRepository<Appointments, Integer>{

}
