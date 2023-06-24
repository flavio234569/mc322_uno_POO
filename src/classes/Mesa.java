package classes;

import java.util.Scanner;

public class Mesa {
	private Baralho baralho;
	private Descarte descarte;
	private JogadorHumano jogadorHumano;
	private JogadorRobo jogadorRobo;
	private int ultimoJogador;
	private boolean vencedor;
	
	
	public Mesa(Baralho baralho, Descarte descarte, JogadorHumano jogadorHumano, JogadorRobo jogadorRobo) {
		
		this.baralho = baralho;
		this.descarte = descarte;
		this.jogadorHumano = jogadorHumano;
		this.jogadorRobo = jogadorRobo;
		this.ultimoJogador = 0; // primeiro jogador e' o robo (0)
		
	}
	
	public int getUltimoJogador() {
		return ultimoJogador;
	}
	
	public void setUltimoJogador(int numJogador) {
		this.ultimoJogador = numJogador;
	}
	 public boolean getVencedor() {
		  return vencedor;
	}

	 public void setVencedor(boolean vencedor) {
		  this.vencedor = vencedor;
	}
	
	public void jogo() {
		
		while(vencedor == false) {
			System.out.println("Ultima carta do descarte: " + descarte.getListaCarta().get(descarte.getListaCarta().size()-1)+"\n");
			if(baralho.getListaCarta().size() == 0) {
				baralho.monteVazio(descarte);
			}
			proximaJogada(descarte);
			verificaFim();
			jogadorHumano.setFim(-1);
			verificaVencedor();
		}
	}
	public void verificaVencedor(){
	    if(jogadorRobo.getListaCarta().size() == 0){
	      setVencedor(true);
	      System.out.println("Fim de partida! \n " + jogadorRobo.getNome() + " venceu!");
	    }
	    else if(jogadorHumano.getListaCarta().size() == 0){
	    	setVencedor(true);
	      System.out.println("Fim de partida! \n " + jogadorHumano.getNome() + " venceu!");
	    }
	    else{
	    	setVencedor(false);
	    }
	  }
	
	public void verificaFim(){
		int fimHumano = jogadorHumano.getFim();
			
	    // se jogador fala uno invalido = compra carta
	     if(jogadorRobo.getListaCarta().size() == 1){
	        jogadorRobo.falarFim(); // aqui faz o 'FIM' automatico do robo (ele nunca erra)
	        
	     }
	    else if(fimHumano == 0 && (jogadorHumano.getListaCarta().size() != 1) ){
	    	jogadorHumano.comprarCarta(1, baralho);
	    }
	}
	    

		//A partir da ultima carta jogada, analisa qual será o próximo jogador
	    //Retorna int, sendo "0" o jogador Robo e "1" o jogador Humano
	    public int vezJogador(Descarte descarte, int ultimoJogador){
	    Carta ultimaCarta = descarte.getListaCarta().get(descarte.getListaCarta().size()-1);
	    int jogRob = 0;
	    int jogHum = 1;
	
	    if (!ultimaCarta.getAcao()){ //Se nao eh uma carta de acao, entao prox jogador eh o outro
	        if (ultimoJogador == jogRob){
	            return jogHum;
	        }
	        else {
	            return jogRob;
	        }
	    } else { //Eh o mesmo jogador
	        if (ultimoJogador == jogRob){
	            return jogRob;
	        }else {
	            return jogHum;
	        }
	    }
	}
	

	public void proximaJogada(Descarte descarte) {
		int proxJogador = vezJogador(descarte, ultimoJogador);
		int valorJogar = descarte.getListaCarta().get(descarte.getListaCarta().size()-1).getValor();
		String corJogar = descarte.getListaCarta().get(descarte.getListaCarta().size()-1).getCor();
		Carta descarteJog = null;
		
		if(proxJogador == 0) { // vez do robo
			descarteJog = jogadorRobo.realizaJogada(corJogar, valorJogar);
			if(descarteJog == null) {
				descarteJog = descarte.getListaCarta().get(descarte.getListaCarta().size()-1); // se ele compra carta permanece no monte a ultima carta descartada
			}
			descarte.getListaCarta().add(descarteJog);
			
		} else if(proxJogador == 1) { // vez do humano
			String opcao;

			Scanner usuario = new Scanner(System.in);
			// Menu para jogada do Humano
				System.out.println("--------------------------");
				System.out.println("Suas cartas atuais: ");
				jogadorHumano.printListaCartas();
				System.out.println("--------------------------");
				System.out.println("O que você deseja fazer?:");
				System.out.println("[A] Comprar carta");
				System.out.println("[B] Jogar carta");
				System.out.println("[C] Falar FIM");
				System.out.println("--------------------------");
				System.out.println("\n");

			// Selecao do usuario
				System.out.println("Opção selecionada: ");
				opcao = usuario.nextLine();
				
				if(opcao.equals("A")) {   		// Comprar carta
						jogadorHumano.comprarCarta(1, baralho);
						System.out.println("Carta comprada: " + jogadorHumano.getListaCarta().get(jogadorHumano.getListaCarta().size()-1));
						System.out.println("--------------------------");
						System.out.println("\nSuas cartas atuais: ");
						jogadorHumano.printListaCartas();
						System.out.println("--------------------------");
						descarteJog = descarte.getListaCarta().get(descarte.getListaCarta().size()-1); // se ele compra carta permanece no monte a ultima carta descartada
					
				} else if(opcao.equals("B"))  { // Jogar carta
						System.out.println("Qual carta você deseja jogar? Digite o número entre \'[ ]\' ");
						int indexCarta = usuario.nextInt();
						descarteJog = jogadorHumano.descartarCarta(indexCarta);
						descarte.getListaCarta().add(descarteJog);
						
				} else if(opcao.equals("C")) {   // 'Fim'
						jogadorHumano.falarFim();
					
				}
				
		}
		
		
		this.ultimoJogador = proxJogador;
		String jogJogada;
		if(ultimoJogador == 0) {
			 jogJogada = "Robo";}
		else {jogJogada = "Humano";}
		System.out.println("Jogador que fez a jogada: " + jogJogada);
	}
	
	
	


	}
