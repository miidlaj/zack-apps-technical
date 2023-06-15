package com.zackapps.auth.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class JwtResponse {

    private String token;

    private Long id;

    private String email;

    private List<String> roles;

}
