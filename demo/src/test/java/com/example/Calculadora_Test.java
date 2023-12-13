package com.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.example.utils.Smoke;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class Calculadora_Test {
	private Calculadora calc;

	@BeforeEach
	void setUp() throws Exception {
		calc = new Calculadora();
	}

	@Nested
	public class Add {
		@Nested
		public class OK {
			@Test
			@Tag("smoke")
			void test_Add_1_mas_2() {
//				var calc = new Calculadora();

				var result = calc.add(1, 2);

				assertEquals(3, result);
			}

			@DisplayName("Control de IEEE")
			@Test
			void testAdd2() {
//				var calc = new Calculadora();

				var result = calc.add(0.1, 0.2);

				assertEquals(0.3, result);
				// assertEquals(0.1, calc.add(1, -0.9));
			}
			@DisplayName("Ejemplo de test parcial")
			@Test
			void testAddPartial() {
				var result = calc.add(0.1, 0.2);

				assertEquals(0.3, result);
				assumeFalse(true, "lo dejo a medias");
			}
			@ParameterizedTest(name = "{displayName} {index}: {0} + {1} = {2}")
			@CsvSource({"1,2,3","0.1,0.2,0.3","1,-0.9,0.1","-0.9,1,0.1", "0,0,0"})
			void test_Suma(double operando1, double operando2, double result ) {
				assertEquals(result, calc.add(operando1, operando2));
			}

			@DisplayName("Falsa con spy")
			@Test
			void testMock() {
				var calc = spy(Calculadora.class);
				when(calc.add(2, 2)).thenReturn(5.0);
				var result = calc.add(2, 2);

				assertEquals(5, result);
			}
		}

		@Nested
		public class KO {

		}
	}

	@Nested
	public class Divide {
		@Nested
		public class OK {
			@RepeatedTest(value = 5, name = "{displayName} {currentRepetition}/{totalRepetitions}")
			void test_Enteros() {
				assertEquals(1, calc.divide(3, 2));
			}

			@Test
			@Smoke
			void test_Reales() {
				assertEquals(0.5, calc.divide(1.0, 2));
			}
		}

		@Nested
		public class KO {
			@Test
			void test_Por_0_en_Enteros() {
				assertThrows(ArithmeticException.class, () -> calc.divide(3, 0));
			}

			@Test
			void test_Por_0_en_Reales() {
				try {
					calc.divide(1.0, 0);
					fail("Sin excepcion");
				} catch (IllegalArgumentException e) {
				} catch (Exception e) {
					fail("No es la excepcion esperada");
				}
			}

			@Test
			void test_Multiple() {
				var result = calc.divide(1.0, 1);
				assertAll("test_Multiple", 
						() -> assertEquals(1, result),
						() -> assertFalse(Double.isInfinite(result), "isInfinite"),
						() -> assertFalse(Double.isNaN(result), "isNaN"));
			}
		}
	}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

}
