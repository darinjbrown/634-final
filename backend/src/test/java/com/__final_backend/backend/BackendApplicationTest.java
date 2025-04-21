package com.__final_backend.backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BackendApplicationTest {

	@Test
	void contextLoads() {
		// This test verifies that the Spring application context loads successfully
	}

	@Test
	void mainMethodStartsWithoutError() {
		// Test that the main method can be called without throwing exceptions
		BackendApplication.main(new String[]{});
	}
}