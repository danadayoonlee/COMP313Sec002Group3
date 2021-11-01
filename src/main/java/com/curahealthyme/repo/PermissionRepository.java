package com.curahealthyme.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curahealthyme.model.Permission;

public interface PermissionRepository  extends JpaRepository<Permission, Integer>{

}
