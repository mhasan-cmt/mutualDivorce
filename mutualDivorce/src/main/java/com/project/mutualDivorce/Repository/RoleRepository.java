package com.project.mutualDivorce.Repository;

import com.project.mutualDivorce.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
