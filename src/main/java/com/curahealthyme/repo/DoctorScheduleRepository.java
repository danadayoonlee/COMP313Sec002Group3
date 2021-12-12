package com.curahealthyme.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.curahealthyme.model.DoctorSchedule;
import com.curahealthyme.model.MedicalStaff;

public interface DoctorScheduleRepository  extends CrudRepository<DoctorSchedule, Long>{
	@Query("SELECT u FROM DoctorSchedule u WHERE u.DoctorId = ?1")
    public List<DoctorSchedule> findByDoctorSchedulesId(long id);
	@Query("SELECT u FROM DoctorSchedule u WHERE u.DoctorId = ?1 AND u.Date = ?2")
    public List<DoctorSchedule> findByDoctorSchedulesId(long id, Date date);
}
