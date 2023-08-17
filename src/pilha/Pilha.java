package pilha;
import listaLigada.ListaLigada;

public class Pilha {
	
	private ListaLigada pilha = new ListaLigada();
	
	public void push (Object novoElemento) {
		pilha.adicionaNoFinal(novoElemento);
	}
	
	public void pop() {
		pilha.removeDoFinal();
	}
	
	public Object top() {
		return pilha.pegaUltima();
	}
	
	public int pegaTamanho() {
		return pilha.pegaTotalElementos();
	}
	
	public boolean contem(Object elementoBuscado) {
		return pilha.contem(elementoBuscado);
	}

}
