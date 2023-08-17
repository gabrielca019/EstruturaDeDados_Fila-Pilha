package listaLigada;

public class ListaLigada {

	private Celula primeira = null;
	private Celula ultima = null;
	private int totalDeElementos = 0;

	private static final String MSG_ERRO_AO_REMOVER_CELULA_POSICAO_INVALIDA = "Erro ao remover celula: posição inválida";
	private static final String MSG_ERRO_REMOCAO_INVALIDA_LISTA_ESTA_VAZIA = "Erro ao tentar remover: nao contem elementos.";
	private static final String MSG_ERRO_AO_RECUPERAR_CELULA_POSICAO_INVALIDA = "Erro ao recuperar celula: posicao inválida.";
	private static final String MSG_ERRO_AO_RECUPERAR_PRIMEIRA_POSICAO_ESTA_VAZIA = "Erro ao recuperar: nao contem elementos.";
	private static final String MSG_ERRO_AO_INSERIR_POSICAO_INVALIDA = "Erro ao tentar inserir: posicao invalida.";

	public void adicionarNoComeco(Object novoElemento) {
		if (verificarEstaVazia()) {
			Celula novaCelula = new Celula(novoElemento);
			this.primeira = novaCelula;
			this.ultima = novaCelula;
		} else {
			Celula novaCelula = new Celula(novoElemento, this.primeira);
			this.primeira.setAnterior(novaCelula);
			this.primeira = novaCelula;
		}
		this.totalDeElementos++;
	}

	public void adicionarNoFinal(Object novoElemento) {
		if (verificarEstaVazia()) {
			adicionarNoComeco(novoElemento);
		} else {
			Celula novaCelula = new Celula(novoElemento);
			this.ultima.setProximo(novaCelula);
			novaCelula.setAnterior(this.ultima);
			this.ultima = novaCelula;
			this.totalDeElementos++;
		}
	}

	private boolean posicaoValidaInsercao(int posicao) {
		return (posicao >= 0) && (posicao <= this.totalDeElementos);
	}

	public void adicionarNaPosicao(Object novoElemento, int posicao) {
		if (!posicaoValidaInsercao(posicao)) 
			throw new IllegalArgumentException(MSG_ERRO_AO_INSERIR_POSICAO_INVALIDA);
		
		if (posicao == 0) {
			adicionarNoComeco(novoElemento);
		} else if (posicao == this.totalDeElementos) {
			adicionarNoFinal(novoElemento);
		} else {
			Celula celulaAnterior = pegaCelula(posicao - 1);
			Celula celulaProxima = celulaAnterior.getProximo();

			Celula celulaNova = new Celula(novoElemento, celulaProxima);
			celulaNova.setAnterior(celulaAnterior);
			celulaAnterior.setProximo(celulaNova);
			celulaProxima.setAnterior(celulaNova);
			this.totalDeElementos++;
		}

	}

	public boolean verificarEstaVazia() {
		return totalDeElementos == 0;
	}

	public int getTotalElementos() {
		return totalDeElementos;
	}

	public Object getPrimeiro() {
		if (this.primeira == null)
			throw new RuntimeException(MSG_ERRO_AO_RECUPERAR_PRIMEIRA_POSICAO_ESTA_VAZIA);

		return this.primeira.getElemento();
	}

	public Object pegarUltimoElemento() {
		if (this.ultima == null)
			throw new RuntimeException(MSG_ERRO_AO_RECUPERAR_PRIMEIRA_POSICAO_ESTA_VAZIA);

		return this.ultima.getElemento();
	}

	private boolean posicaoValidaRecuperar(int posicao) {
		return (posicao >= 0) && (posicao < this.totalDeElementos);
	}

	private Celula pegaCelula(int posicao) {
		if (!posicaoValidaRecuperar(posicao)) 
			throw new IllegalArgumentException(MSG_ERRO_AO_RECUPERAR_CELULA_POSICAO_INVALIDA);
		
		Celula celulaAtual = this.primeira;
		
		for (int i = 0; i < posicao; i++) {
			celulaAtual = celulaAtual.getProximo();
		}

		return celulaAtual;
	}

	public Object pega(int posicao) {
		return pegaCelula(posicao).getElemento();
	}

	public boolean contemElementoEspecificado(Object elementoBuscado) {
		Celula celulaAtual = this.primeira;

		while (celulaAtual != null) {
			if (celulaAtual.getElemento().equals(elementoBuscado)) 
				return true;
			celulaAtual = celulaAtual.getProximo();
		}
		
		return false;
	}

	public void removerDoComeco() {
		if (verificarEstaVazia()) 
			throw new RuntimeException(MSG_ERRO_REMOCAO_INVALIDA_LISTA_ESTA_VAZIA);
		
		this.primeira = this.primeira.getProximo();

		if (this.totalDeElementos > 1) {
			this.primeira.setAnterior(null);
		}
		this.totalDeElementos--;

		if (totalDeElementos == 0) {
			this.ultima = null;
		}
	}

	public void removeDoFinal() {
		if (verificarEstaVazia()) 
			throw new RuntimeException(MSG_ERRO_REMOCAO_INVALIDA_LISTA_ESTA_VAZIA);
		
		if (this.totalDeElementos == 1) {
			removerDoComeco();
		} else {
			Celula penultimaCelula = this.ultima.getAnterior();
			penultimaCelula.setProximo(null);
			this.ultima = penultimaCelula;
			totalDeElementos--;
		}
	}

	public void removerNaPosicao(int posicao) {
		if (!posicaoValidaRecuperar(posicao)) 
			throw new IllegalArgumentException(MSG_ERRO_AO_REMOVER_CELULA_POSICAO_INVALIDA);
		
		if (posicao == 0) {
			removerDoComeco();
		} 
		else if (posicao == this.totalDeElementos) {
			removeDoFinal();
		} else { 
			Celula celulaAnterior = this.pegaCelula(posicao - 1);
			Celula celulaAtual = celulaAnterior.getProximo();
			Celula celulaProxima = celulaAtual.getProximo();
			
			celulaAnterior.setProximo(celulaProxima);
			celulaProxima.setAnterior(celulaAnterior);
			
			this.totalDeElementos--;
		}
	}

	public boolean primeiroEhNulo() {
		return this.primeira == null;
	}

	public boolean ultimoEhNulo() {
		return this.ultima == null;
	}
}