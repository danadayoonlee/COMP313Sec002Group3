package com.curahealthyme.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curahealthyme.model.User_Logon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface User_LogonRepository  extends CrudRepository<User_Logon, Long>{
	
	@Query("SELECT u FROM User_Logon u WHERE u.Username = ?1 and u.Password = ?2")
    public User_Logon findByUsername(String username, String password);

	@Query("SELECT u FROM User_Logon u WHERE u.Username = ?1")
    public User_Logon isUserNameExist(String username);
	
	@Query("SELECT u.UserAccessId FROM User_Logon u WHERE u.Username = ?1")
    public long findUserAccessId(String username);
	@Query("SELECT u.Id FROM User_Logon u WHERE u.UserAccessId = ?1")
    public List<Long> findUserLoginIdsByAccess(long accessid);
}
