package com.curahealthyme.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.curahealthyme.model.MedicalStaff;

public interface MedicalStaffRepository  extends CrudRepository<MedicalStaff, Long>{
	@Query("SELECT u FROM MedicalStaff u WHERE u.LoginId = ?1")
    public MedicalStaff findEmployeeByLoginId(long id);
	
	@Query("SELECT u FROM MedicalStaff u WHERE u.LoginId in ?1")
    public List<MedicalStaff> findEmployeeByLoginIds(List<Long> id);
	
	@Query("SELECT u FROM MedicalStaff u WHERE u.EmployeeId = ?1")
    public MedicalStaff findByMedicalStaffId(long id);
}
