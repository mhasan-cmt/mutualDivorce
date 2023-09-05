package com.project.mutualDivorce.Configuration;

import com.project.mutualDivorce.Entity.Role;
import com.project.mutualDivorce.Repository.RoleRepository;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DbSeeder {
    private final RoleRepository roleRepository;

    public DbSeeder (RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
        initRoles();
    }

    void initRoles() {
        List<Role> roles = roleRepository.findAll();
        if (roles.isEmpty()) {
            Role roleAdmin = new Role();
            roleAdmin.setName("ROLE_ADMIN");
            roleRepository.save(roleAdmin);

            Role roleUser = new Role();
            roleUser.setName("ROLE_USER");
            roleRepository.save(roleUser);
        }
    }
}
