package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ApplicationServiceTest {

	@Test
	void listaDeProducto() {
		
	}
	
	@Test
	void unProductoEncontrado() {
		var fixure = new Producto(1, "kk");
		var srv = mock(ProductoService.class);
		when(srv.getOne(anyInt())).thenReturn(Optional.of(fixure));
		// ...
		var item = srv.getOne(1);
		
		assertTrue(item.isPresent());
		assertAll("Datos del item", 
				() -> assertEquals(fixure.getId(), item.get().getId()),
				() -> assertEquals(fixure.getNombre(), item.get().getNombre())
				);
		verify(srv).getOne(1);
	}
	
	@Test
	void unProductoNoEncontrado() {
		var srv = mock(ProductoService.class);
		when(srv.getOne(anyInt())).thenReturn(Optional.empty());
		// ...
		var item = srv.getOne(1);
		
		assertTrue(item.isEmpty());
		verify(srv).getOne(1);
	}
	
	@Test
	void testAlgo() {
		var fixure = new Producto(1, "kk");
		var srv = mock(ProductoService.class);
		when(srv.getOne(anyInt())).thenReturn(Optional.of(fixure));

		var app = new ApplicationServiceImpl(srv);
		
		var result = app.algo(1);
		
		assertEquals("Producto [id=1, nombre=kk]", result);
		verify(srv).getOne(1);
		
	}
	@Test
	void testAlgoKO() {
		var srv = mock(ProductoService.class);
		when(srv.getOne(anyInt())).thenReturn(Optional.empty());
		var app = new ApplicationServiceImpl(srv);
		
		assertThrows(Exception.class, () -> app.algo(1));
		verify(srv).getOne(1);
		
	}
}








