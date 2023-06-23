package classes;
import java.util.Scanner;

public class Menu {
		
		
		//int opcao = 0;  // sera a opcao que o usuario ira selecionar no menu	
		String opcao;
	
		try (Scanner usuario = new Scanner(System.in)) {
			while(true) {
		
		// Menu para jogada do Humano
			System.out.println("--------------------------");
			System.out.println("Suas cartas atuais: \n");
			jogadorHumano.printListaCartas();
			System.out.println("--------------------------");
			System.out.println("O que você deseja fazer?:");
			System.out.println("[A] Comprar carta");
			System.out.println("[B] Jogar carta");
								// [B.1] +4/Coringa (Qual cor vc quer?)
			System.out.println("[C] Falar uno");
			System.out.println("--------------------------");
			System.out.println("\n");
		
		// Selecao do usuario
			System.out.println("Opção selecionada: ");
			opcao = usuario.nextLine();
			usuario.nextLine();// limpa o scanner
			
			if(opcao.equals("A")) {   // Comprar carta
					jogadorHumano.comprarCarta(1, baralho);
					break;
				
			} else if(opcao.equals("B"))  { // Jogar carta
					System.out.println("Qual carta você deseja jogar? Digite o número entre \'[ ]\' ");
					int indexCarta = usuario.nextInt();
					Carta descarteJog = jogadorHumano.descartarCarta(indexCarta);
					
					// se carta for escolhe cor ou +4, pede a cor que ele quer
					//if(descarteJog == '13') || (descarte)
					break;
					
			} else if(opcao.equals("C")) {   // Uno
					jogadorHumano.falarUno();
					break;
			}
		
		}
	}
}


