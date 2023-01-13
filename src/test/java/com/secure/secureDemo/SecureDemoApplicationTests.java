package com.secure.secureDemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;

@SpringBootTest
class SecureDemoApplicationTests {

	@MockBean
	private JwtDecoder jwtDecoder;

	@MockBean
	private JwtEncoder jwtEncoder;

	@Test
	void contextLoads() {
	}

}
