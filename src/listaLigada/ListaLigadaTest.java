package listaLigada;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ListaLigadaTest {

	@Test
	void testAdicionarNoComecoListaVazia() {

		ListaLigada lista = new ListaLigada();

		lista.adicionarNoComeco("Fernando");

		assertEquals(1, lista.getTotalElementos());
		assertEquals("Fernando", lista.getPrimeiro());
		assertEquals("Fernando", lista.pegarUltimoElemento());
	}

	@Test
	void testAdicionarNoComecoComElementos() {

		ListaLigada lista = new ListaLigada();

		lista.adicionarNoComeco("Fernando");
		lista.adicionarNoComeco("Maria");
		lista.adicionarNoComeco("Carlos");

		assertEquals(3, lista.getTotalElementos());
		assertEquals("Carlos", lista.getPrimeiro());
		assertEquals("Fernando", lista.pegarUltimoElemento());

	}

	@Test
	void testAdicionarNoFinalListaVazia() {
		
		ListaLigada lista = new ListaLigada();

		lista.adicionarNoFinal("Fernando");

		assertEquals(1, lista.getTotalElementos());
		assertEquals("Fernando", lista.getPrimeiro());
		assertEquals("Fernando", lista.pegarUltimoElemento());


	}

	@Test
	void testAdicionarNoFinalComElementos() {

		ListaLigada lista = new ListaLigada();

		lista.adicionarNoFinal("Fernando");
		lista.adicionarNoFinal("Maria");
		lista.adicionarNoFinal("Carlos");

		assertEquals(3, lista.getTotalElementos());
		assertEquals("Fernando", lista.getPrimeiro());
		assertEquals("Carlos", lista.pegarUltimoElemento());

	}
	
	@Test
	void testPegarNaPosicaoInvalidaNegativa() {
		
		ListaLigada lista = new ListaLigada();

		lista.adicionarNoFinal("Fernando");
		
		assertThrows(IllegalArgumentException.class, ()->lista.pega(-1));
		
	}
	
	@Test
	void testPegarNaPosicaoInvalidaQuantidadeElementos() {
	
		ListaLigada lista = new ListaLigada();

		lista.adicionarNoFinal("Fernando");
		
		assertThrows(IllegalArgumentException.class, ()->lista.pega(6));
	}
	
	@Test
	void testPegarNaPosicaoValida() {
		
		ListaLigada lista = new ListaLigada();

		lista.adicionarNoFinal("Fernando");
		lista.adicionarNoFinal("Maria");
		lista.adicionarNoFinal("Carlos");

		assertEquals("Fernando", lista.pega(0));
		assertEquals("Maria", lista.pega(1));
		assertEquals("Carlos", lista.pega(2));
		
		
	}
	
	@Test
	void testAdicionarNaPosicaoInvalidaNegativa() {
		
		ListaLigada lista = new ListaLigada();
		
		lista.adicionarNoFinal("Carlos");
		
		assertThrows(IllegalArgumentException.class, ()->lista.adicionarNaPosicao("Fernando", -1));
		
	}
	
	@Test
	void testAdicionarNaPosicaoInvalidaQuantidadeElementos() {
	
		ListaLigada lista = new ListaLigada();

		lista.adicionarNoFinal("Carlos");
		
		assertThrows(IllegalArgumentException.class, ()->lista.adicionarNaPosicao("Fernando", 2));
		
	}
	
	@Test
	void testAdicionarNaPosicaoValida() {
		
		ListaLigada lista = new ListaLigada();

		lista.adicionarNoFinal("Fernando");
		lista.adicionarNoFinal("Maria");
		lista.adicionarNoFinal("Carlos");

		lista.adicionarNaPosicao("Rose", 1);
		
		assertEquals("Fernando", lista.pega(0));
		assertEquals("Rose", lista.pega(1));
		assertEquals("Maria", lista.pega(2));
		assertEquals("Carlos", lista.pega(3));
		
	}
	
	@Test
	void testContemListaVazia() {
		
		ListaLigada lista = new ListaLigada();
		
		assertFalse(lista.contemElementoEspecificado("Mauro"));
		
	}
	
	@Test
	void testContemNaoAcharLista() {
		
		ListaLigada lista = new ListaLigada();

		lista.adicionarNoFinal("Fernando");
		lista.adicionarNoFinal("Maria");
		lista.adicionarNoFinal("Carlos");
		
		assertFalse(lista.contemElementoEspecificado("Mauro"));
		
	}
	
	@Test
	void testContemAcharLista() {
		
		ListaLigada lista = new ListaLigada();

		lista.adicionarNoFinal("Fernando");
		lista.adicionarNoFinal("Maria");
		lista.adicionarNoFinal("Carlos");
		
		assertTrue(lista.contemElementoEspecificado("Maria"));
		
		
	}
	
	@Test
	void testRemoveDoComecoListaVazia() {

		ListaLigada lista = new ListaLigada();

		assertThrows(RuntimeException.class, ()-> lista.removerDoComeco());
		
	}
	
	@Test
	void testRemoveDoComecoComElementos() {

		ListaLigada lista = new ListaLigada();

		lista.adicionarNoComeco("Fernando");
		lista.adicionarNoComeco("Maria");
		lista.adicionarNoComeco("Carlos");
		
		lista.removerDoComeco();
		
		assertEquals(2, lista.getTotalElementos());
		assertEquals("Maria", lista.getPrimeiro());
		assertEquals("Fernando", lista.pegarUltimoElemento());

	}
	
	@Test
	void testRemoveDoComecoComApenasUmElemento() {

		ListaLigada lista = new ListaLigada();

		lista.adicionarNoComeco("Fernando");
		
		
		lista.removerDoComeco();
		
		assertEquals(0, lista.getTotalElementos());
		assertTrue(lista.primeiroEhNulo());
		assertTrue(lista.ultimoEhNulo());

	}
	
	@Test
	void testRemoveDoFinalListaVazia() {

		ListaLigada lista = new ListaLigada();

		assertThrows(RuntimeException.class, ()-> lista.removeDoFinal());
		
	}
	
	@Test
	void testRemoveDoFinalComElementos() {

		ListaLigada lista = new ListaLigada();

		lista.adicionarNoFinal("Fernando");
		lista.adicionarNoFinal("Maria");
		lista.adicionarNoFinal("Carlos");
		
		lista.removeDoFinal();
		
		assertEquals(2, lista.getTotalElementos());
		assertEquals("Fernando", lista.getPrimeiro());
		assertEquals("Maria", lista.pegarUltimoElemento());

	}
	
	@Test
	void testRemoveDoFinalComApenasUmElemento() {

		ListaLigada lista = new ListaLigada();

		lista.adicionarNoFinal("Fernando");
		
		lista.removeDoFinal();
		
		assertEquals(0, lista.getTotalElementos());
		assertTrue(lista.primeiroEhNulo());
		assertTrue(lista.ultimoEhNulo());

	}
	
	@Test
	void testRemoverNaPosicaoInvalidaNegativa() {
		
		ListaLigada lista = new ListaLigada();
		
		lista.adicionarNoFinal("Carlos");
		
		assertThrows(IllegalArgumentException.class, ()->lista.removerNaPosicao(-1));
		
	}
	
	@Test
	void testRemoverNaPosicaoInvalidaQuantidadeElementos() {
	
		ListaLigada lista = new ListaLigada();

		lista.adicionarNoFinal("Carlos");
		
		assertThrows(IllegalArgumentException.class, ()->lista.removerNaPosicao(2));
		
	}
	
	@Test
	void testRemoverNaPosicaoValida() {
		
		ListaLigada lista = new ListaLigada();

		lista.adicionarNoFinal("Fernando");
		lista.adicionarNoFinal("Maria");
		lista.adicionarNoFinal("Carlos");

		lista.removerNaPosicao(1);
		
		assertEquals(2, lista.getTotalElementos());
		assertEquals("Fernando", lista.pega(0));
		assertEquals("Carlos", lista.pega(1));
		
	}
	
	@Test
	void testRemoverNaPosicaoValidaApenasUmElemento() {
		
		ListaLigada lista = new ListaLigada();

		lista.adicionarNoFinal("Fernando");

		lista.removerNaPosicao(0);
		
		assertEquals(0, lista.getTotalElementos());
		assertTrue(lista.primeiroEhNulo());
		assertTrue(lista.ultimoEhNulo());
		
	}

}
