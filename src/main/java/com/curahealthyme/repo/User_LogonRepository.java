package com.curahealthyme.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curahealthyme.model.User_Logon;
import org.springframework.data.jpa.repository.Query;

public interface User_LogonRepository  extends JpaRepository<User_Logon, Integer>{
	
	@Query("SELECT u FROM User_Logon u WHERE u.Username = ?1 and u.Password = ?2")
    public User_Logon findByUsername(String username, String password);

}
