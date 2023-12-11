package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class Calculadora_Test {

	@Nested
	public class Add {
		@Nested
		public class OK {
			@Test
			void test_Add_1_mas_2() {
				var calc = new Calculadora();

				var result = calc.add(1, 2);

				assertEquals(3, result);
			}

			@DisplayName("Control de IEEE")
			@Test
			void testAdd2() {
				var calc = new Calculadora();

				var result = calc.add(0.1, 0.2);

				assertEquals(0.3, result);
			}
		}
		@Nested
		public class KO {
		
		}
	}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

}
