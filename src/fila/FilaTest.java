package fila;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FilaTest {

	@Test
	void testAdicionarFilaVazia() {
		
		Fila fila = new Fila();
		
		fila.adicionar("Fernando");
		
		assertEquals(1, fila.pegaTamanho());
		assertTrue(fila.contem("Fernando"));
		assertEquals("Fernando", fila.poll());
	}
	
	@Test
	void testAdicionarFilaComElementos() {
		
		Fila fila = new Fila();
		
		fila.adicionar("Fernando");
		fila.adicionar("Marcos");
		fila.adicionar("Rose");
		
		assertEquals(3, fila.pegaTamanho());
		assertTrue(fila.contem("Rose"));
		assertTrue(fila.contem("Fernando"));
		assertTrue(fila.contem("Marcos"));
		assertEquals("Fernando", fila.poll());
		assertEquals("Marcos", fila.poll());
		assertEquals("Rose", fila.poll());
	}
	
	@Test
	void testRemoverFilaVazia() {
		
		Fila fila = new Fila();
		
		assertThrows(RuntimeException.class, ()->fila.remover());
	}
	
	@Test
	void testRemoverFilaComElementos() {
		
		Fila fila = new Fila();
		
		fila.adicionar("Fernando");
		fila.adicionar("Marcos");
		fila.adicionar("Rose");
		
		fila.remover();
		
		assertEquals(2, fila.pegaTamanho());
		assertTrue(fila.contem("Rose"));
		assertTrue(fila.contem("Marcos"));
		
	}


}
