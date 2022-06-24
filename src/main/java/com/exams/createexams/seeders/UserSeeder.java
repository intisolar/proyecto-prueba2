package com.exams.createexams.seeders;

import com.exams.createexams.common.enums.RoleType;
import com.exams.createexams.models.entities.Role;
import com.exams.createexams.models.entities.User;
import com.exams.createexams.repositories.IRoleRepository;
import com.exams.createexams.repositories.IUserRepository;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserSeeder implements CommandLineRunner {

    private static final List<String> NAMES_ADMIN = List.of("Inti");
    private static final List<String> LAST_NAMES_ADMIN = List.of("Garcia");
    private static final List<String> EMAILS_ADMIN = List.of("insolgar@gmail.com");
    private static final List<String> PASSWORDS_ADMIN = List.of("admin2022");
    private static final List<String> NAMES_USER = List.of("María", "John");
    private static final List<String> LAST_NAMES_USER = List.of("Nadie", "Smith");
    private static final List<String> EMAILS_USER = List.of("marianadie@gmail.com",
        "johnsmith@gmail.com");
    private static final List<String> PASSWORDS_USER = List.of("1234567", "7654321");

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {  seedUserTable();  }

    private void seedUserTable() {
        if (userRepository.count() == 0) {
            createAdminUsers();
            createStandardUsers();
        }
    }

    private void createAdminUsers() {
        List<Role> roleAdmin = Collections.singletonList(
            roleRepository.findByName(RoleType.ADMIN.getFullRoleName()));

        int listSize = NAMES_ADMIN.size();

        for (int i = 0; i < listSize; i++) {
            createUser(NAMES_ADMIN.get(i),
                LAST_NAMES_ADMIN.get(i),
                EMAILS_ADMIN.get(i),
                PASSWORDS_ADMIN.get(i),
                roleAdmin);
        }
    }

    private void createStandardUsers() {
        List<Role> roleUser = Collections.singletonList(
            roleRepository.findByName(RoleType.USER.getFullRoleName()));
        int listSize = NAMES_USER.size();
        for (int i = 0; i < listSize; i++) {
            createUser(NAMES_USER.get(i),
                LAST_NAMES_USER.get(i),
                EMAILS_USER.get(i),
                PASSWORDS_USER.get(i),
                roleUser);
        }
    }

    private void createUser(String firstName, String lastName, String email, String password,
        List<Role> role) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setPhoto("image.jpg");
        user.setSoftDelete(false);
        userRepository.save(user);
        user.setRoles(role);
        userRepository.save(user);
    }
}
