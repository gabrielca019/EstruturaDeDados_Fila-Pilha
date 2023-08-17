package fila;
import listaLigada.ListaLigada;

public class Fila {

	private ListaLigada fila = new ListaLigada();
	
	public void adicionar(Object novoElemento) {
		fila.adicionarNoFinal(novoElemento);
	}
	
	public void remover() {
		fila.removerDoComeco();
	}
	
	public boolean verificarEstaVazia() {
		return fila.verificarEstaVazia();
	}
	
	public Object poll() {
		if(verificarEstaVazia()) {
			return null;
		} else {
			Object primeroElementoFila = fila.getPrimeiro();
			fila.removerDoComeco();
			return primeroElementoFila;
		}
	}
	
	public boolean contemElementoEspecificado(Object elementoBuscado) {
		return fila.contemElementoEspecificado(elementoBuscado);
	}
	
	public int pegaTamanho() {
		return fila.getTotalElementos();
	}
	
}