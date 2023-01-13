package com.secure.secureDemo.controllers.apiImpl;

import com.secure.secureDemo.controllers.api.AuthController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class AuthControllerImpl implements AuthController {

    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    private JwtEncoder jwtEncoder;

    public AuthControllerImpl(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }


    @Override
    public Map<String, String> jwtToken(Authentication authentication) {
        Map<String,String> idToken = new HashMap<>();
        Instant instant = Instant.now();
        String scope = authentication.getAuthorities().stream()
                .map(auth -> auth.getAuthority()).collect(Collectors.joining(" "));
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .subject(authentication.getName())
                .issuedAt(instant)
                .expiresAt(instant.plus(5, ChronoUnit.MINUTES))
                .issuer("security-service")
                .claim("scope",scope)
                .build();
        String jwtAccessToken = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
        idToken.put("acessToken",jwtAccessToken);

        return idToken;
    }
}
