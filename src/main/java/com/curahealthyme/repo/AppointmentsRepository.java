package com.curahealthyme.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.curahealthyme.model.Appointments;

public interface AppointmentsRepository extends CrudRepository<Appointments, Long>{
	@Query("SELECT u FROM Appointments u WHERE u.DoctorId = ?1")
    public List<Appointments> findBookedAppointmentsByDoctor(long doctorId);
	@Query("SELECT u FROM Appointments u WHERE u.DoctorId = ?1 AND u.AppointmentDate = ?2")
    public List<Appointments> findBookedAppointmentsByDoctorAndDate(long doctorId, Date date);
	@Query("SELECT u FROM Appointments u WHERE u.JoinId = ?1")
    public List<Appointments> findBookedAppointmentsByPatient(long joinId);
	@Query("SELECT u FROM Appointments u WHERE u.AppointmentId = ?1")
    public Appointments findByAppointmentId(long appointmentId);
}
