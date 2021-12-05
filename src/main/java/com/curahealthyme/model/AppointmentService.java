package com.curahealthyme.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curahealthyme.model.Appointments;

@Service
@Transactional
public class AppointmentService {

		@Autowired
		private AppointmentsRepository bookAppointment;



		public List<Appointments> listAll(){
			return bookAppointment.findAll();
		}

		public void save(Appointments appointments) {
			bookAppointment.save(appointments);
		}


		public void delete(Integer id) {
			bookAppointment.deleteById(id);
		}






		public Optional<Appointments> get(Integer id) {
			return bookAppointment.findById(id);

		}

		public List<Appointments> findByPatientId(long id)
		{
			return bookAppointment.findByPatientById(id);
		}

		public List<Appointments> findByDoctorName(String doctorName)
		{
			return bookAppointment.findByDoctorName(doctorName);
		}

		public List<Appointments> findByDate(String date, String doctorName){
			return bookAppointment.findByDate(date, doctorName);
		}

}
