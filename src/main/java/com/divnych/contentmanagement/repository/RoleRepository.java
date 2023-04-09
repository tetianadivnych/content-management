package com.divnych.contentmanagement.repository;

import com.divnych.contentmanagement.entity.ERole;
import com.divnych.contentmanagement.entity.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);
}
