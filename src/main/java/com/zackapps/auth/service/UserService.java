package com.zackapps.auth.service;

import com.zackapps.auth.dto.JwtResponse;
import com.zackapps.auth.dto.LoginRequest;

public interface UserService {

    public JwtResponse authenticateUser(LoginRequest loginRequest);
}
