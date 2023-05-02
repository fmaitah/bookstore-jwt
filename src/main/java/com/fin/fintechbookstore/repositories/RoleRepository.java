package com.fin.fintechbookstore.repositories;

import com.fin.fintechbookstore.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String roleName);

    boolean existsByName(String string);

}