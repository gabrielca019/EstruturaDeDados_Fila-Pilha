package fila;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FilaTest {
	
	Fila fila;
	
	@BeforeEach
	@DisplayName("Inicializar o objeto Fila")
	void inicializar() {
		fila = new Fila();
	}

	@Test
	@DisplayName("Adicionar elemento numa lista vazia")
	void testAdicionarFilaVazia() {
		fila.adicionar("Fernando");
		
		assertEquals(1, fila.pegaTamanho());
		assertTrue(fila.contemElementoEspecificado("Fernando"));
		assertEquals("Fernando", fila.poll());
	}
	
	@Test
	@DisplayName("")
	void testAdicionarFilaComElementos() {
		fila.adicionar("Fernando");
		fila.adicionar("Marcos");
		fila.adicionar("Rose");
		
		assertEquals(3, fila.pegaTamanho());
		assertTrue(fila.contemElementoEspecificado("Rose"));
		assertTrue(fila.contemElementoEspecificado("Fernando"));
		assertTrue(fila.contemElementoEspecificado("Marcos"));
		assertEquals("Fernando", fila.poll());
		assertEquals("Marcos", fila.poll());
		assertEquals("Rose", fila.poll());
	}
	
	@Test
	void testRemoverFilaVazia() {
		assertThrows(RuntimeException.class, ()->fila.remover());
	}
	
	@Test
	void testRemoverFilaComElementos() {
		fila.adicionar("Fernando");
		fila.adicionar("Marcos");
		fila.adicionar("Rose");
		
		fila.remover();
		
		assertEquals(2, fila.pegaTamanho());
		assertTrue(fila.contemElementoEspecificado("Rose"));
		assertTrue(fila.contemElementoEspecificado("Marcos"));
	}
}