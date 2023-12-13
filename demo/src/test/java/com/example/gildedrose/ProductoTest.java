package com.example.gildedrose;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ProductoTest {
	@Test
	void crearProducto() {
		Producto p = new Producto("producto", 3, 4);
		
		assertNotNull(p);
		assertAll("Producto", 
				() -> assertEquals("producto", p.getName()),
				() -> assertEquals(3, p.getSellIn()),
				() -> assertEquals(4, p.getQuality())
				);
	}
	@Test
	void dominioDeDatos() {
		assertThrows(IllegalArgumentException.class, () -> new Producto(null, 3, 4));
	}
	@Test
	void dominioDeDatosCalidad() {
		assertThrows(IllegalArgumentException.class, () -> new Producto("algo", 3, -1));
	}
	@Test
	void cambiaCalidadOK() {
		Producto p = new Producto("producto", 3, 4);
		p.setQuality(0);
		assertNotNull(p);
		assertEquals(0, p.getQuality());
	}
	@Test
	void cambiaCalidadKO() {
		Producto p = new Producto("producto", 3, 4);
		assertThrows(IllegalArgumentException.class, () -> p.setQuality(-1));
	}
}
