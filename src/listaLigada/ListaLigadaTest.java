package listaLigada;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes unitários da Pilha")
class ListaLigadaTest {
	
	ListaLigada listaLigada;
	
	@BeforeEach
	@DisplayName("Inicializar o objeto Pilha")
	void inicializar() {
		listaLigada = new ListaLigada();
	}
	
	@Test
	@DisplayName("Adicionar um elemento na lista vazia")
	void testAdicionarNoComecoListaVazia() {
		listaLigada.adicionarNoComeco("Fernando");

		assertEquals(1, listaLigada.getTotalElementos());
		assertEquals("Fernando", listaLigada.getPrimeiro());
		assertEquals("Fernando", listaLigada.pegarUltimoElemento());
	}

	@Test
	@DisplayName("Adicionar vários elementos na lista")
	void testAdicionarNoComecoComElementos() {
		listaLigada.adicionarNoComeco("Fernando");
		listaLigada.adicionarNoComeco("Maria");
		listaLigada.adicionarNoComeco("Carlos");

		assertEquals(3, listaLigada.getTotalElementos());
		assertEquals("Carlos", listaLigada.getPrimeiro());
		assertEquals("Fernando", listaLigada.pegarUltimoElemento());
	}

	@Test
	@DisplayName("Adicionar um elemento no final da lista vazia")
	void testAdicionarNoFinalListaVazia() {
		listaLigada.adicionarNoFinal("Fernando");

		assertEquals(1, listaLigada.getTotalElementos());
		assertEquals("Fernando", listaLigada.getPrimeiro());
		assertEquals("Fernando", listaLigada.pegarUltimoElemento());
	}

	@Test
	@DisplayName("Adicionar elementos no final com elementos já inseridos")
	void testAdicionarNoFinalComElementos() {
		listaLigada.adicionarNoFinal("Fernando");
		listaLigada.adicionarNoFinal("Maria");
		listaLigada.adicionarNoFinal("Carlos");

		assertEquals(3, listaLigada.getTotalElementos());
		assertEquals("Fernando", listaLigada.getPrimeiro());
		assertEquals("Carlos", listaLigada.pegarUltimoElemento());
	}
	
	@Test
	@DisplayName("Exception para get na posição negativa")
	void testPegarNaPosicaoInvalidaNegativa() {
		listaLigada.adicionarNoFinal("Fernando");
		
		assertThrows(IllegalArgumentException.class, ()->listaLigada.pega(-1));
	}
	
	@Test
	@DisplayName("Exception para get na posição sem elemento inserido")
	void testPegarNaPosicaoInvalidaQuantidadeElementos() {
		listaLigada.adicionarNoFinal("Fernando");
		
		assertThrows(IllegalArgumentException.class, ()->listaLigada.pega(6));
	}
	
	@Test
	@DisplayName("Get em uma posição válida")
	void testPegarNaPosicaoValida() {
		listaLigada.adicionarNoFinal("Fernando");
		listaLigada.adicionarNoFinal("Maria");
		listaLigada.adicionarNoFinal("Carlos");

		assertEquals("Fernando", listaLigada.pega(0));
		assertEquals("Maria", listaLigada.pega(1));
		assertEquals("Carlos", listaLigada.pega(2));
	}
	
	@Test
	@DisplayName("Exception para adicionar em uma posição negativa")
	void testAdicionarNaPosicaoInvalidaNegativa() {
		listaLigada.adicionarNoFinal("Carlos");
		
		assertThrows(IllegalArgumentException.class, ()->listaLigada.adicionarNaPosicao("Fernando", -1));
	}
	
	@Test
	@DisplayName("Exception para adicionar em uma posição inválida pela quantidade de elementos")
	void testAdicionarNaPosicaoInvalidaQuantidadeElementos() {
		listaLigada.adicionarNoFinal("Carlos");
		
		assertThrows(IllegalArgumentException.class, ()->listaLigada.adicionarNaPosicao("Fernando", 2));
	}
	
	@Test
	@DisplayName("Adicionar em uma posição válida")
	void testAdicionarNaPosicaoValida() {
		listaLigada.adicionarNoFinal("Fernando");
		listaLigada.adicionarNoFinal("Maria");
		listaLigada.adicionarNoFinal("Carlos");

		listaLigada.adicionarNaPosicao("Rose", 1);
		
		assertEquals("Fernando", listaLigada.pega(0));
		assertEquals("Rose", listaLigada.pega(1));
		assertEquals("Maria", listaLigada.pega(2));
		assertEquals("Carlos", listaLigada.pega(3));
	}
	
	@Test
	@DisplayName("False para pegar elemento que não existe na lista vazia")
	void testContemListaVazia() {
		assertFalse(listaLigada.contemElementoEspecificado("Mauro"));
	}
	
	@Test
	@DisplayName("False para pegar elemento que não existe na lista com elementos")
	void testContemNaoAcharLista() {
		listaLigada.adicionarNoFinal("Fernando");
		listaLigada.adicionarNoFinal("Maria");
		listaLigada.adicionarNoFinal("Carlos");
		
		assertFalse(listaLigada.contemElementoEspecificado("Mauro"));
	}
	
	@Test
	@DisplayName("Pegar elemento que existe na lista")
	void testContemAcharLista() {
		listaLigada.adicionarNoFinal("Fernando");
		listaLigada.adicionarNoFinal("Maria");
		listaLigada.adicionarNoFinal("Carlos");
		
		assertTrue(listaLigada.contemElementoEspecificado("Maria"));
	}
	
	@Test
	@DisplayName("Exception para remover da lista vazia")
	void testRemoveDoComecoListaVazia() {
		assertThrows(RuntimeException.class, ()-> listaLigada.removerDoComeco());
	}
	
	@Test
	@DisplayName("Remover do começo da lista com elementos")
	void testRemoveDoComecoComElementos() {
		listaLigada.adicionarNoComeco("Fernando");
		listaLigada.adicionarNoComeco("Maria");
		listaLigada.adicionarNoComeco("Carlos");
		
		listaLigada.removerDoComeco();
		
		assertEquals(2, listaLigada.getTotalElementos());
		assertEquals("Maria", listaLigada.getPrimeiro());
		assertEquals("Fernando", listaLigada.pegarUltimoElemento());
	}
	
	@Test
	@DisplayName("Remover do começo da lista que contem apenas um elemento")
	void testRemoveDoComecoComApenasUmElemento() {
		listaLigada.adicionarNoComeco("Fernando");
		
		listaLigada.removerDoComeco();
		
		assertEquals(0, listaLigada.getTotalElementos());
		assertTrue(listaLigada.primeiroEhNulo());
		assertTrue(listaLigada.ultimoEhNulo());
	}
	
	@Test
	@DisplayName("Exception para remover do final da lista vazia")
	void testRemoveDoFinalListaVazia() {
		assertThrows(RuntimeException.class, ()-> listaLigada.removeDoFinal());
	}
	
	@Test
	@DisplayName("Remover do final da lista com elementos")
	void testRemoveDoFinalComElementos() {
		listaLigada.adicionarNoFinal("Fernando");
		listaLigada.adicionarNoFinal("Maria");
		listaLigada.adicionarNoFinal("Carlos");
		
		listaLigada.removeDoFinal();
		
		assertEquals(2, listaLigada.getTotalElementos());
		assertEquals("Fernando", listaLigada.getPrimeiro());
		assertEquals("Maria", listaLigada.pegarUltimoElemento());
	}
	
	@Test
	@DisplayName("Remover do final da lista com apenas um elemento")
	void testRemoveDoFinalComApenasUmElemento() {
		listaLigada.adicionarNoFinal("Fernando");
		
		listaLigada.removeDoFinal();
		
		assertEquals(0, listaLigada.getTotalElementos());
		assertTrue(listaLigada.primeiroEhNulo());
		assertTrue(listaLigada.ultimoEhNulo());
	}
	
	@Test
	@DisplayName("Exception para remover da lista na posição negativa")
	void testRemoverNaPosicaoInvalidaNegativa() {
		listaLigada.adicionarNoFinal("Carlos");
		
		assertThrows(IllegalArgumentException.class, ()->listaLigada.removerNaPosicao(-1));
	}
	
	@Test
	@DisplayName("Exception para remover da lista na posição inválida da quantidade de elementos")
	void testRemoverNaPosicaoInvalidaQuantidadeElementos() {
		listaLigada.adicionarNoFinal("Carlos");
		
		assertThrows(IllegalArgumentException.class, ()->listaLigada.removerNaPosicao(2));
	}
	
	@Test
	@DisplayName("Remover da posição válida")
	void testRemoverNaPosicaoValida() {
		listaLigada.adicionarNoFinal("Fernando");
		listaLigada.adicionarNoFinal("Maria");
		listaLigada.adicionarNoFinal("Carlos");

		listaLigada.removerNaPosicao(1);
		
		assertEquals(2, listaLigada.getTotalElementos());
		assertEquals("Fernando", listaLigada.pega(0));
		assertEquals("Carlos", listaLigada.pega(1));
	}
	
	@Test
	@DisplayName("Remover na posição válida da lista de apenas um elemento")
	void testRemoverNaPosicaoValidaApenasUmElemento() {
		listaLigada.adicionarNoFinal("Fernando");

		listaLigada.removerNaPosicao(0);
		
		assertEquals(0, listaLigada.getTotalElementos());
		assertTrue(listaLigada.primeiroEhNulo());
		assertTrue(listaLigada.ultimoEhNulo());
	}
}