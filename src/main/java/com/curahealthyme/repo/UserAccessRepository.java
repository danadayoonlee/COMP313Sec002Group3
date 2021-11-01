package com.curahealthyme.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curahealthyme.model.UserAccess;

public interface UserAccessRepository  extends JpaRepository<UserAccess, Integer>{

}
