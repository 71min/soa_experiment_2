package com.example.restful;

import com.example.restful.controller.OperatorController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestfulApplicationTests {

	@Test
	void contextLoads() {
		System.out.println(new OperatorController().getAll());

	}

}
