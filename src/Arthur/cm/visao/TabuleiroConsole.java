package Arthur.cm.visao;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import Arthur.cm.excecao.ExplosaoException;
import Arthur.cm.excecao.SairException;
import Arthur.cm.modelo.Tabuleiro;

public class TabuleiroConsole {

	private Tabuleiro tabuleiro;
	private Scanner entrada = new Scanner(System.in);
	
	public TabuleiroConsole(Tabuleiro tabuleiro) {		
		this.tabuleiro = tabuleiro;	
		
		executarJogo();
	}

	private void executarJogo() {
		try {
			boolean continuar = true;
			
			while(continuar) {
				
				cicloDoJogo();
				
				System.out.println("Outra partida? (S/n) ");
				String resposta = entrada.nextLine();
				
				if("n".equalsIgnoreCase(resposta)) {
					continuar = false;
				}
				else {
					tabuleiro.reiniciar();
				}
			}
		}
		catch(SairException e) {
			System.out.println("\n\nSaindo do jogo!!!\n\n");
		}
		finally {
			entrada.close();
		}
	}

	private void cicloDoJogo() {
		
		try {
			
			while(!tabuleiro.objetivoAlcancado()) {
				System.out.println(tabuleiro);
				
				String digitado = capturarValorDigitado("Digite (x, y) (Linha de 0 a 5 - Coluna 0 a 5) :");
				
				Iterator<Integer> xy = Arrays.stream(digitado.split(","))
				.map(e -> Integer.parseInt(e.trim())).iterator();
				
				digitado = capturarValorDigitado("1 - Abrir  ou  2 - (Des)Marcar: ");
				
				if("1".equals(digitado)) {
					tabuleiro.abrir(xy.next(), xy.next());
				}
				else if("2".equals(digitado)) {
					tabuleiro.alternarMarcacao(xy.next(), xy.next());
				}
			}
			System.out.println(tabuleiro);
			System.out.println("\nVocê Ganhou!!!\n");
		}
		catch(ExplosaoException e) {
			System.out.println(tabuleiro);
			System.out.println("\nVocê Perdeu!!!\n");
		}		
	}
	
	private String capturarValorDigitado(String texto) {
		System.out.print(texto);
		String digitado = entrada.nextLine();
		
		if("Sair".equalsIgnoreCase(digitado)) {
			throw new SairException();
		}
		
		return digitado;
	}
}
