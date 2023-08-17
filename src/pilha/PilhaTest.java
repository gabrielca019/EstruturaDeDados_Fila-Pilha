package pilha;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes unitários da Pilha")
class PilhaTest {
	
	Pilha pilha;
	
	@BeforeEach
	@DisplayName("Inicializar objeto da pilha antes de cada execução de um teste")
	void inicializar() {
		pilha = new Pilha();
	}

	@Test
	@DisplayName("Adicionando elemento na pilha vazia")
	void testPushPilhaVazia() {
		pilha.push("rose");
		
		assertEquals(1, pilha.getTamanho());
		assertTrue(pilha.contemElementoEspecificado("rose"));
		assertEquals("rose", pilha.top());
		
	}
	
	@Test
	@DisplayName("Adicionar elemento na pilha com elementos")
	void testPushPilhaComElementos() {
		pilha.push("rose");
		pilha.push("marcos");
		
		assertEquals(2, pilha.getTamanho());
		assertTrue(pilha.contemElementoEspecificado("rose"));
		assertTrue(pilha.contemElementoEspecificado("marcos"));
		assertEquals("marcos", pilha.top());
	}
	
	@Test
	@DisplayName("Exception para remover na pilha vazia")
	void testPopPilhaVazia() {
		assertThrows(RuntimeException.class, ()->pilha.pop());
	}
	
	@Test
	@DisplayName("Remover elemento da pilha com elementos")
	void testPopPilhaComElementos() {
		pilha.push("rose");
		pilha.push("marcos");
		pilha.push("jose");
		
		pilha.pop();
		
		assertEquals(2, pilha.getTamanho());
		assertTrue(pilha.contemElementoEspecificado("rose"));
		assertTrue(pilha.contemElementoEspecificado("marcos"));
		assertEquals("marcos", pilha.top());
	}

}