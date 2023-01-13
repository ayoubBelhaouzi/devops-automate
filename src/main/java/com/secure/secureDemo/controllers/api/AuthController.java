package com.secure.secureDemo.controllers.api;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


@RequestMapping("/api/v2")
public interface AuthController {

    @PostMapping("/token")
    Map<String, String> jwtToken(Authentication authentication);
}
