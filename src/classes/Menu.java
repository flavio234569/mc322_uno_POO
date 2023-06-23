package classes;
import java.util.Scanner;

public class Menu {
		private JogadorHumano jogador;
		private Baralho baralho;
		
		public Menu(JogadorHumano jogador, Baralho baralho) {
			this.jogador = jogador;
			this.baralho = baralho;
		}
		
		public String escolheCor() {
			Scanner usuario = new Scanner(System.in);
			String corJogar;
			System.out.println("Qual cor você deseja jogar? \n" +
								"[Am] Amarelo \n" +
								"[Az] Azul \n" +
								"[Vd] Verde \n" + 
								"[Vm] Vermelho \n");
			corJogar = usuario.nextLine();
			return corJogar;
		}
		
		public void menuExecutar(JogadorHumano jogador, Baralho baralho) {
		//int opcao = 0;  // sera a opcao que o usuario ira selecionar no menu	
		String opcao;
	
		try (Scanner usuario = new Scanner(System.in)) {
			while(true) {
		
		// Menu para jogada do Humano
			System.out.println("--------------------------");
			System.out.println("Suas cartas atuais: \n");
			jogador.printListaCartas();
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
					jogador.comprarCarta(1, baralho);
					break;
				
			} else if(opcao.equals("B"))  { // Jogar carta
					System.out.println("Qual carta você deseja jogar? Digite o número entre \'[ ]\' ");
					int indexCarta = usuario.nextInt();
					Carta descarteJog = jogador.descartarCarta(indexCarta);
					
					// se carta for 'coringa' ou '+4', pede a cor que ele quer 
					if((((CartaTipos)descarteJog).getValor() == 13) || (((CartaTipos)descarteJog).getValor() == 14)){
						String corJogar = escolheCor();
					break;
					}
					
			} else if(opcao.equals("C")) {   // Uno
					jogador.falarUno();
					break;
			}
		
			}
		}
	}
}



