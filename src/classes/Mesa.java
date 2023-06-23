package classes;

import java.util.Scanner;

public class Mesa {
	private Baralho baralho;
	//private List<Jogador> listaJogador;
	private Descarte descarte;
	private JogadorHumano jogadorHumano;
	private JogadorRobo jogadorRobo;
	//private Menu menu;
	private int ultimoJogador;
	private boolean vencedor;
	
	
	public Mesa(Baralho baralho, Descarte descarte, JogadorHumano jogadorHumano, JogadorRobo jogadorRobo) {
		
		this.baralho = baralho;
		//this.listaJogador = new ArrayList<Jogador>();;
		this.descarte = descarte;
		this.jogadorHumano = jogadorHumano;
		this.jogadorRobo = jogadorRobo;
		//this.menu = menu;
		this.ultimoJogador = 0; // primeiro jogador e' o robo (0)
		
		//this.vencedor = false;
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
			System.out.println("\nUltima carta do descarte: " + descarte.getListaCarta().get(descarte.getListaCarta().size()-1));
			//System.out.println("Cartas do Robo: " + jogadorRobo.getListaCarta() + "\n");
			proximaJogada(descarte);
			// verUno;
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
	    	System.out.println("AQUI");
	    	setVencedor(false);
	    }
	  }
	
	
	
	// vai determinar qual cor e valor pode jogar na proxima jogada
	public String defineCor(Descarte descarte) {
		Carta ultimaDesc = descarte.getListaCarta().get(descarte.getListaCarta().size()-1);
		String corDesc = ultimaDesc.getCor();
		int valorDesc = ultimaDesc.getValor();
		String corJogar = null; // MUDAR PRO +4/CORINGA
		
		// se for carta de 0-12: corDesc = ultimaDesc, se for 13 ou 14 = cor escolhida
		if(valorDesc < 13) { // se nao for carta 'preta' (+4/coringa) a cor sera a mesma da ultima carta jogada
			corJogar = corDesc;
			
		}
		else {
			if(ultimoJogador == 0) {
				corJogar = jogadorRobo.getCorCoringa(); // se for Robo pega a cor definida nele
				descarte.getListaCarta().get(descarte.getListaCarta().size()-1).setCor(corJogar);
			}
			if(ultimoJogador == 1) {
				corJogar = jogadorHumano.escolheCor(); // se for Humano pede pra ele inserir a cor
				descarte.getListaCarta().get(descarte.getListaCarta().size()-1).setCor(corJogar);
				}
			
			
		}  
		return corJogar;
	}

	//A partir da ultima carta jogada, analisa qual será o próximo jogador
    //Retorna int, sendo "0" o jogador Robo e "1" o jogador Humano
    public int vezJogador(Descarte descarte, int ultimoJogador){
    Carta ultimaCarta = descarte.getListaCarta().get(descarte.getListaCarta().size()-1);
    int jogRob = 0;
    int jogHum = 1;

    if (!ultimaCarta.getAcao() || ultimaCarta.getValor() == CartaValoresEnum.CORINGA.valor){ //Se nao eh uma carta de acao, entao prox jogador eh o outro
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
	
	/*
	public void proximaJogada(Descarte descarte) {
		int proxJogador = vezJogador(descarte, ultimoJogador);
		int valorJogar = descarte.getListaCarta().get(descarte.getListaCarta().size()-1).getValor();
		String corJogar = defineCor(descarte);
		Carta descarteAtual;
		
		if(proxJogador == 0) { // vez do robo
			descarteAtual = jogadorRobo.realizaJogada(corJogar, valorJogar);
			
		} else if(proxJogador == 1) { // vez do humano
			menu.menuExecutar(jogadorHumano, baralho);
		}
		
		descarte.getListaCarta().add(descarteAtual);
	
		this.ultimoJogador = proxJogador;
	
	} */
	

	public void proximaJogada(Descarte descarte) {
		int proxJogador = vezJogador(descarte, ultimoJogador);
		int valorJogar = descarte.getListaCarta().get(descarte.getListaCarta().size()-1).getValor();
		String corJogar = defineCor(descarte);
		Carta descarteJog = null;
		
		if(proxJogador == 0) { // vez do robo
			descarteJog = jogadorRobo.realizaJogada(corJogar, valorJogar);
			if(descarteJog == null) {
				descarteJog = descarte.getListaCarta().get(descarte.getListaCarta().size()-1); // se ele compra carta permanece no monte a ultima carta descartada
			}
			descarte.getListaCarta().add(descarteJog);
			System.out.println("Carta jogada pelo " + jogadorRobo.getNome() + ": " + ((CartaTipos)descarteJog).toString());
			
		} else if(proxJogador == 1) { // vez do humano
			String opcao;

			Scanner usuario = new Scanner(System.in);
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
				//usuario.nextLine();// limpa o scanner
				
				if(opcao.equals("A")) {   		// Comprar carta
						jogadorHumano.comprarCarta(1, baralho);
						System.out.println("Carta comprada: " + jogadorHumano.getListaCarta().get(jogadorHumano.getListaCarta().size()-1));
						System.out.println("--------------------------");
						System.out.println("Suas cartas atuais: \n");
						jogadorHumano.printListaCartas();
						System.out.println("--------------------------");
						descarteJog = descarte.getListaCarta().get(descarte.getListaCarta().size()-1); // se ele compra carta permanece no monte a ultima carta descartada
						//System.out.println("VAI CACETE");
					
				} else if(opcao.equals("B"))  { // Jogar carta
						System.out.println("Qual carta você deseja jogar? Digite o número entre \'[ ]\' ");
						int indexCarta = usuario.nextInt();
						descarteJog = jogadorHumano.descartarCarta(indexCarta);
						descarte.getListaCarta().add(descarteJog);
						//break;
						
				} else if(opcao.equals("C")) {   // Uno
						jogadorHumano.falarUno();
						//break;
				}
		}
		
		
	
		this.ultimoJogador = proxJogador;
		System.out.println("Jogador que fez a jogada:");
		if(ultimoJogador == 0) {System.out.println(" Robo\n");}
		else if(ultimoJogador == 1) {System.out.println(" Humano\n");}
	}
	
	
	


	}
