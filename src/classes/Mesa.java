package classes;

public class Mesa {
	private Baralho baralho;
	//private List<Jogador> listaJogador;
	private Descarte descarte;
	private JogadorHumano jogadorHumano;
	private JogadorRobo jogadorRobo;
	
	
	public Mesa(Baralho baralho, Descarte descarte, JogadorHumano jogadorHumano, JogadorRobo jogadorRobo) {
		super();
		this.baralho = baralho;
		//this.listaJogador = new ArrayList<Jogador>();;
		this.descarte = descarte;
		this.jogadorHumano = jogadorHumano;
		this.jogadorRobo = jogadorRobo;
	}
	
	public void jogo(Jogador proxJogador) {
		Boolean vencedor = false;
		while( vencedor == false) {
			proximaJogada()
			 verUno;
			vencedor = verVencedor();
		}
	}
	
	
	/* Menu (so pro humano)
	 *   1 - Comprar carta
	 *   2 - Jogar carta
	 *   3 - Falar uno
	 */
	
	// verificar do jogador:
		// carta jogada valida
			// se nao for: comprarCarta()
		// uno valido
			// se for falso: comprarCarta()
			// verifica se deixou passar o uno (nao falou = +1)
	
	
	// verifica vencedor:
		// se nao tem carta = venceu
	
	// loop: entre jogadas: 
		// verUno 
		// verVencedor
		// 
	
	
	// vai determinar qual cor e valor pode jogar na proxima jogada
	public String defineCor(Descarte descarte) {
		Carta ultimaDesc = descarte.getListaCarta().get(descarte.getListaCarta().size()-1);
		String corDesc = ultimaDesc.getCor();
		int valorDesc = ultimaDesc.getValor();
		String corJogar;
		
		// se for carta de 0-12: corDesc = ultimaDesc, se for 13 ou 14 = cor escolhida
		if(valorDesc < 13) { // se nao for carta 'preta' (+4/coringa) a cor sera a mesma da ultima carta jogada
			corJogar = corDesc;
			
		}/*
		else {
			"Qual cor voce quer (+4/coringa)? 
			corJogar = corEscolhida;
			valorJogar = null; // se for coringa/+4 nao tem obrigacao de jogar a mesma carta
		} */ 
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
	
	
	public void proximaJogada(Descarte descarte, int proxJogador) {
		int valorJogar = descarte.getListaCarta().get(descarte.getListaCarta().size()-1).getValor();
		String corJogar = defineCor(descarte);
		Carta descarteAtual;
		
		if(proxJogador == 0) { // vez do robo
			descarteAtual = jogadorRobo.realizaJogada(corJogar, valorJogar);
			
		} else if(proxJogador == 1) { // vez do humano
			/* chama o menu
			 * 	se for jogar carta [B]:
			 * 		-  descarteAtual = descarteJog
			 * */
		}
		
		descarte.getListaCarta().add(descarteAtual);
	
	
	
	}
	
	
	
	
	
	
		 
}
