package com.zackapps.auth.repository;

import com.zackapps.auth.entity.ERole;
import com.zackapps.auth.entity.Role;
import com.zackapps.auth.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
// @Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private UserRepository repo;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void hrUserCreate() {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Role role = roleRepository.findByName(ERole.HR_EXECUTIVE)
                .orElseThrow(() -> new RuntimeException("Role is not found"));

        User user = User.builder()
                .email("hr@zackapps.com")
                .password(passwordEncoder.encode("12345678"))
                .name("HR MANAGER")
                .roles(Set.of(role))
                .build();

        User saved = repo.save(user);

        // assertEquals(1, repo.count());
    }

    @Test
    public void AdminUserCreate() {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Role role = roleRepository.findByName(ERole.ADMIN)
                .orElseThrow(() -> new RuntimeException("Role is not found"));

        User user = User.builder()
                .email("admin@zackapps.com")
                .password(passwordEncoder.encode("12345678"))
                .name("ADMIN")
                .roles(Set.of(role))
                .build();

        repo.save(user);

        // assertEquals(2, repo.count());
    }

    @Test
    public void JrUserCreate() {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Role role = roleRepository.findByName(ERole.JR_ADMIN)
                .orElseThrow(() -> new RuntimeException("Role is not found"));

        User user = User.builder()
                .email("jr@zackapps.com")
                .password(passwordEncoder.encode("12345678"))
                .name("JR ADMIN")
                .roles(Set.of(role))
                .build();

        repo.save(user);

        // assertEquals(3, repo.count());
    }
}
