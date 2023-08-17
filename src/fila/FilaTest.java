package fila;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes unitários da Fila")
class FilaTest {
	
	Fila fila;
	
	@BeforeEach
	@DisplayName("Inicializar o objeto Fila")
	void inicializar() {
		fila = new Fila();
	}

	@Test
	@DisplayName("Adicionar um elemento numa lista vazia")
	void testAdicionarFilaVazia() {
		fila.adicionar("Fernando");
		
		assertEquals(1, fila.pegaTamanho());
		assertTrue(fila.contemElementoEspecificado("Fernando"));
		assertEquals("Fernando", fila.poll());
	}
	
	@Test
	@DisplayName("Adicionar vários elementos numa lista")
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
	@DisplayName("Exception ao tentar remover de uma lista vazia")
	void testRemoverFilaVazia() {
		assertThrows(RuntimeException.class, ()->fila.remover());
	}
	
	@Test
	@DisplayName("Remover elemento de uma lista com elementos")
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