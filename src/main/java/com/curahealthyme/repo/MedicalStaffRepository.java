package com.curahealthyme.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curahealthyme.model.MedicalStaff;
import com.curahealthyme.model.Patient;

public interface MedicalStaffRepository  extends JpaRepository<MedicalStaff, Integer>{
	@Query("SELECT u FROM MedicalStaff u WHERE u.LoginId = ?1")
    public MedicalStaff findEmployeeByLoginId(long id);
	
	@Query("SELECT u FROM MedicalStaff u WHERE u.LoginId in ?1")
    public List<MedicalStaff> findEmployeeByLoginIds(List<Long> id);
	
	@Query("SELECT u FROM MedicalStaff u WHERE u.EmployeeId = ?1")
    public MedicalStaff findById(long id);
}
