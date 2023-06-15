package com.zackapps.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/hr")
    public ResponseEntity<?> hr() {
        return ResponseEntity.ok("HR ACCESS");
    }

    @GetMapping("/jr")
    public ResponseEntity<?> jr() {

        return ResponseEntity.ok("JR ACCESS");
    }

    @GetMapping("/admin")
    public ResponseEntity<?> admin() {

        return ResponseEntity.ok("ADMIN ACCESS");
    }
}
