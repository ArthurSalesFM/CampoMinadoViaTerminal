package Arthur.cm.modelo;

import java.util.ArrayList;
import java.util.List;

import Arthur.cm.excecao.ExplosaoException;

public class Campo {

	private final int linha;
	private final int coluna;
	
	private boolean aberto = false;
	
	private boolean marcado = false;	
	private boolean minado = false;
	
	private List<Campo> vizinhos = new ArrayList<>();
	
	//visualização em pacote do construtor
	Campo(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}
	
	//Metodo para verificar vizinhança
	boolean adicionarVizinho(Campo vizinho) {
		
		boolean linhaDiferente = linha != vizinho.linha;
		boolean colunaDiferente = coluna != vizinho.coluna;
		boolean diagonal = linhaDiferente && colunaDiferente;
		
		//verificando a distancia entre os vizinhos
		int deltaLinha = Math.abs(linha - vizinho.linha);
		int deltaColuna = Math.abs(coluna - vizinho.coluna);
		
		// somatorio das distancias
		int deltaGeral = deltaColuna + deltaLinha;
		
		//teste para verificar o resultado e adicionar se for vizinhos
		if(deltaGeral == 1 && !diagonal) {
			vizinhos.add(vizinho);
			return true;
		}
		//teste para verificar o resultado e adicionar se for vizinhos
		else if(deltaGeral == 2 && diagonal) {
			vizinhos.add(vizinho);
			return true;
		}		
		return false;		
	}
	
	//Aplicar marcação de celulas potencialmente com mina
	void alternarMarcacao() {
		
		if(!aberto) {
			marcado = !marcado;
		}
	}
	
	//Método que verifica se algum capo foi aberto, ou quando abrir e tiver
	// uma mina, encerra o jogo
	boolean abrir() {
		
		if(!aberto && !marcado) {
			aberto = true;
			
			if(minado) {
				throw new ExplosaoException();
			}
			
			if(vizinhancaSegura()) {
				vizinhos.forEach(v -> v.abrir());
			}
			return true;
		}
		else{
			return false;
		}
	} 
	
	//verifica se a vizinhança está segura, sem minas
	boolean vizinhancaSegura() {
		return vizinhos.stream().noneMatch(v -> v.minado);
	}
	
	//setar minar como verdadeiro
	void minar() {
		minado = true;	
	}
	
	public boolean isMinado() {
		return minado;
	}
	
	//verifica e a posição já foi marcada
	public boolean isMarcado() {
		return marcado;
	}
	
	void setAberto(boolean aberto) {
		this.aberto = aberto;
	}
	
	////verifica se o campo foi aberto
	public boolean isAberto() {
		return aberto;
	}
	
	//verifica se o campo esta fechado
	public boolean isFechado() {
		return !isAberto();
	}
	
	//retorna a linha
	public int getLinha() {
		return linha;
	}

	//retorna a coluna
	public int getColuna() {
		return coluna;
	}
	
	//verifica os objetivos do jogo
	boolean objetivoAlcancado() {
		boolean desvendado = !minado && aberto;
		boolean protegido = minado && marcado;		
		return desvendado || protegido;
	}
	
	//verifica as minas vizinhas
	long minasNaVizinhanca() {
		return vizinhos.stream().filter(v -> v.minado).count();
	}
	
	//reinicia o jogo
	void reiniciar() {
		aberto = false;
		minado = false;
		marcado = false;
	}
	
	//setando os simbolos do jogo
	public String toString() {
		if(marcado) {
			return "x";
		}
		else if(aberto && minado) {
			return "*";
		}
		else if(aberto && minasNaVizinhanca() > 0 ) {
			return Long.toString(minasNaVizinhanca());
		}
		else if(aberto) {
			return " ";
		}
		else{
			return "?";
		}
	}
	
}