package com.zackapps.auth.dao;

import com.zackapps.auth.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserDAO {

    Optional<User> findByEmail(String email);
}
