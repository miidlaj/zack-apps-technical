package com.zackapps.auth.repository;

import com.zackapps.auth.entity.ERole;
import com.zackapps.auth.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests {

    @Autowired
    private RoleRepository repo;

    @Test
    public void testCreateRoles() {
        Role admin = new Role(ERole.ADMIN, " Can add, view and delete Employee details and view leave details.");
        Role hr = new Role(ERole.HR_EXECUTIVE, "Can view the Employee leave details.");
        Role jr = new Role(ERole.JR_ADMIN, "Can view Employee details.");

        repo.saveAll(List.of(admin, hr, jr));

        long count = repo.count();
        assertEquals(3, count);
    }
}
