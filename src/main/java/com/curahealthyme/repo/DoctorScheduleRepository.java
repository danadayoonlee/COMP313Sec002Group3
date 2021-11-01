package com.curahealthyme.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curahealthyme.model.DoctorSchedule;

public interface DoctorScheduleRepository  extends JpaRepository<DoctorSchedule, Integer>{

}
