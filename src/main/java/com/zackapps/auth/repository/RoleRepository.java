package com.zackapps.auth.repository;

import com.zackapps.auth.entity.ERole;
import com.zackapps.auth.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);
}
