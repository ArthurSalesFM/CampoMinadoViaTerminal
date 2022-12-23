package Arthur.cm;

import java.util.Scanner;

import Arthur.cm.modelo.Tabuleiro;
import Arthur.cm.visao.TabuleiroConsole;

public class Aplicacao {

	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
//		Scanner entrada = new Scanner(System.in);
//		boolean tudoCerto = true;
//		int linha = 0;
//		int coluna = 0;
//		int quantidadeDeMinas;
//		
//		while(tudoCerto) {
//			System.out.println("Digite a quantidade de Linhas (minimo 3,  maximo 15) : ");
//			linha = entrada.nextInt();
//			
//			System.out.println("\n");
//					
//			System.out.println("Digite a quantidade de Colunas (minimo 3,  maximo 15) : ");
//			linha = entrada.nextInt();
//			
//			System.out.println("\n");		
//			
//			System.out.println("Digite a quantidade de Minas (minimo " + Math.abs((linha * coluna) / 2) + ",  maximo " + Math.abs((linha * coluna) - 6) );
//			quantidadeDeMinas = entrada.nextInt();
//			
//			if(linha < 3 || linha > 15) {
//				System.out.println("\nDigite uma valor de linhas entre 3 e 15\n");
//			}
//			if(coluna < 3 || coluna > 15) {
//				System.out.println("\nDigite uma valor de colunas entre 3 e 15\n");
//			}
//			if(quantidadeDeMinas < Math.abs((linha * coluna) / 2) || quantidadeDeMinas > Math.abs((linha * coluna) - 6)) {
//				System.out.println("\nDigite uma quantidade de minas entre " + Math.abs((linha * coluna) / 2) +" a " + Math.abs((linha * coluna) - 6) +"\n");
//			}
//			else {
//				tabuleiro = new Tabuleiro(linha, coluna, quantidadeDeMinas);
//				System.out.println("----Jogo Campo Minado----\n\n");
//				System.out.println("Digite (sair) se deseja fechar o jogo.\n");
//				
//				tudoCerto = false;
//				
//				
//			}
//		}
		
		new TabuleiroConsole(tabuleiro);
		
		
		
	}
}
