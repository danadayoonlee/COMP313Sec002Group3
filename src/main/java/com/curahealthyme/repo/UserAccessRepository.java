package com.curahealthyme.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curahealthyme.model.UserAccess;
import com.curahealthyme.model.User_Logon;

public interface UserAccessRepository  extends JpaRepository<UserAccess, Integer>{
	@Query("SELECT u FROM UserAccess u WHERE u.UserAccessId = ?1")
    public UserAccess findById(long id);
}
