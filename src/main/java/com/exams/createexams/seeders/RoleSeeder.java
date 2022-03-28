package com.exams.createexams.seeders;

import com.exams.createexams.config.security.RoleType;
import com.exams.createexams.models.entities.Role;
import com.exams.createexams.repositories.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class RoleSeeder implements CommandLineRunner {

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    @Order(1)
    public void run(String... args) {
        seedRoleTable();
    }

    private void seedRoleTable() {
        if (roleRepository.count() == 0) {
            createRole(RoleType.ADMIN);
            createRole(RoleType.USER);
            createRole(RoleType.MEMBER);
            createRole(RoleType.STUDENT);
        }
    }

    private void createRole(RoleType roleType) {
        Role role = new Role();
        role.setName(roleType.getFullRoleName());
        role.setDescription(roleType.name());
        roleRepository.save(role);
    }

}
