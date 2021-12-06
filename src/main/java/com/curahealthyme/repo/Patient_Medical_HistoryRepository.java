package com.curahealthyme.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.curahealthyme.model.Patient_Doctor_Join;
import com.curahealthyme.model.Patient_Medical_History;

@Repository
public interface Patient_Medical_HistoryRepository  extends CrudRepository<Patient_Medical_History, Long>{
	@Query("SELECT u FROM Patient_Medical_History u WHERE u.JoinId = ?1")
    public List<Patient_Medical_History> getPatientMedicalHistory(long patientId);
	@Query("SELECT U FROM Patient_Medical_History U WHERE U.JoinId = ?1")
    public Patient_Medical_History findByJoinId(long joinId);
    @Query("SELECT u FROM Patient_Medical_History u WHERE u.Id = ?1")
    public Patient_Medical_History findByMedicalDataId(long id);
}
