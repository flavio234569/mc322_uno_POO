package classes;


public class JogadorRobo extends Jogador {

		public JogadorRobo(String nome, Baralho baralho, boolean humano) {
			super(nome, baralho, humano);
		}
		
		public Carta realizaJogada(String cor, int valor) {
			/* Ordem das jogadas:
			 * 	- mesma cor (numero, +2, block, retorno)
			 * 	- mesmo numero
			 * 	- carta de acao (escolhe cor, +4)
			 */
			
			Carta cartaDescarte = null; ;
			for(Carta carta : listaCarta) { // percorre a lista de cartas que ele tem 
				if(carta.getCor().equals(cor)) {	// ve se tem carta compativel por cor (block, ret e +2 sao inclusos aqui)
					cartaDescarte = carta;
					
				} else if(carta.getValor() == valor) { // ve se e' compativel o valor
					cartaDescarte = carta;
						
				} else if((carta.getValor() == 13) || (carta.getValor() == 14)) { // +4 e escolhe cor 
					cartaDescarte = carta;
					
				} else {
					comprarCarta(1, baralho);
				} 	
					
			} return cartaDescarte;
		}
	}
