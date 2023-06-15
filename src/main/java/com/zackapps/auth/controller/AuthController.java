package com.zackapps.auth.controller;

import com.zackapps.auth.dto.LoginRequest;
import com.zackapps.auth.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        log.info("Inside authenticateUser() in AuthController.");

        return ResponseEntity.ok(userService.authenticateUser(loginRequest));
    }
}
