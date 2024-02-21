package com.futuro;

import org.junit.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.junit.jupiter.*;
import org.springframework.test.context.web.*;

@ExtendWith(MockitoExtension.class)
@WebAppConfiguration
public class FuturoApplicationTests {

	@Test
	public void contextLoads() {
	}
}