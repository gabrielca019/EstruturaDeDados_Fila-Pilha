package pilha;
import listaLigada.ListaLigada;

public class Pilha {
	
	private ListaLigada pilha = new ListaLigada();
	
	public void push(Object novoElemento) {
		pilha.adicionarNoFinal(novoElemento);
	}
	
	public void pop() {
		pilha.removeDoFinal();
	}
	
	public Object top() {
		return pilha.pegarUltimoElemento();
	}
	
	public int getTamanho() {
		return pilha.getTotalElementos();
	}
	
	public boolean contemElementoEspecificado(Object elementoBuscado) {
		return pilha.contemElementoEspecificado(elementoBuscado);
	}

}
