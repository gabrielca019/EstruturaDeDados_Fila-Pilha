package pilha;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PilhaTest {

	@Test
	void testPushPilhaVazia() {
		
		Pilha pilha = new Pilha();
		pilha.push("rose");
		
		assertEquals(1, pilha.pegaTamanho());
		assertTrue(pilha.contem("rose"));
		assertEquals("rose", pilha.top());
		
	}
	@Test
	void testPushPilhaComElementos() {
		
		Pilha pilha = new Pilha();
		pilha.push("rose");
		pilha.push("marcos");
		
		assertEquals(2, pilha.pegaTamanho());
		assertTrue(pilha.contem("rose"));
		assertTrue(pilha.contem("marcos"));
		assertEquals("marcos", pilha.top());
		
		
	}
	
	@Test
	void testPopPilhaVazia() {
		
		Pilha pilha = new Pilha();
		assertThrows(RuntimeException.class, ()->pilha.pop());
		
	}
	@Test
	void testPopPilhaComElementos() {
		
		Pilha pilha = new Pilha();
		pilha.push("rose");
		pilha.push("marcos");
		pilha.push("jose");
		
		pilha.pop();
		
		assertEquals(2, pilha.pegaTamanho());
		assertTrue(pilha.contem("rose"));
		assertTrue(pilha.contem("marcos"));
		assertEquals("marcos", pilha.top());
		
	}

}
