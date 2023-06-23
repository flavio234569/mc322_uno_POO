package classes;


public class JogadorRobo extends Jogador {
		private String corCoringa;
		public JogadorRobo(String nome, Baralho baralho, boolean humano) {
			super(nome, baralho, humano);
			this.corCoringa = "Az"; // ele sempre vai escolher azul 
		}
		
		public String  getCorCoringa() {
			return corCoringa;
		}
		
		public void setCorCoringa(String cor) {
			this.corCoringa = cor;
		}
		
		//public Carta realizaJogada(String cor, int valor) {
			/* Ordem das jogadas:
			 * 	- mesma cor (numero, +2, block, retorno)
			 * 	- mesmo numero
			 * 	- carta de acao (escolhe cor, +4)
			 */
			/*
			Carta cartaDescarte = null; 
			int controle = 0;
			for(Carta carta : listaCarta) { // percorre a lista de cartas que ele tem 
				if((carta.getCor().equals(cor)) && controle == 0) {	// ve se tem carta compativel por cor (block, ret e +2 sao inclusos aqui)
					cartaDescarte = carta;
					this.listaCarta.remove(cartaDescarte);
					System.out.println("Teste Cor");
					//controle = 1;
					//break;
				} else if(((CartaTipos)carta).getValor() == valor && controle == 0) { // ve se e' compativel o valor
					cartaDescarte = carta;
					this.listaCarta.remove(cartaDescarte);	
					System.out.println("Teste Valor");
					//break;
					//controle = 1;
				} else if(((((CartaTipos)carta).getValor() == 13) || (((CartaTipos)carta).getValor() == 14)) && controle == 0) { // +4 e escolhe cor 
					cartaDescarte = carta;
					this.listaCarta.remove(cartaDescarte);
					System.out.println("Quero a cor " + corCoringa);
					//break;
					//controle = 1;
				} 
			}
			if(controle == 0) {
				comprarCarta(1, baralho);
				} 	
					
			 return cartaDescarte;
			
		
		}*/
			public Carta realizaJogada(String cor, int valor) {
				/* Ordem das jogadas:
				 * 	- mesma cor (numero, +2, block, retorno)
				 * 	- mesmo numero
				 * 	- carta de acao (escolhe cor, +4)
				 */
				
				Carta cartaDescarte = null; 
				int controle = 0;
				for(Carta carta : listaCarta) { // percorre a lista de cartas que ele tem 
					if((carta.getCor().equals(cor)) ) {	// ve se tem carta compativel por cor (block, ret e +2 sao inclusos aqui)
						cartaDescarte = carta;
						this.listaCarta.remove(cartaDescarte);
						System.out.println("Teste Cor");
						controle = 1;
						break;
					} else if(((CartaTipos)carta).getValor() == valor ) { // ve se e' compativel o valor
						cartaDescarte = carta;
						this.listaCarta.remove(cartaDescarte);	
						System.out.println("Teste Valor");
						controle = 1;
						break;
					} else if((((CartaTipos)carta).getValor() == 13) || (((CartaTipos)carta).getValor() == 14)) { // +4 e escolhe cor 
						cartaDescarte = carta;
						this.listaCarta.remove(cartaDescarte);
						System.out.println("Quero a cor " + corCoringa);
						controle = 1;
						break;
						
					} 
				} 
				if(controle == 0) {
					comprarCarta(1, baralho);
					} 	
						
				 return cartaDescarte;
				
			
			}

	}
