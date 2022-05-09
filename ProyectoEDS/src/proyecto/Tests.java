package proyecto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Tests {
	/**
	 * Creamos un objeto de la clase Persona para probar que el cálculo del IMC es correcto
	 */
	
	Persona p1 = new Persona(51, 1.64);
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

	@Test
	void test() {
		double resultadoIMC=Math.round((p1.getPeso()/Math.pow(p1.getAltura(), 2))*100.00)/100.00;
		assertEquals(18.96,resultadoIMC);
	}

}
