package classes;

import javax.swing.JOptionPane;

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
		
		
			public Carta realizaJogada(String cor, int valor) {
				/* Ordem das jogadas:
				 * 	- mesma cor (numero, +2, block, retorno)
				 * 	- mesmo numero
				 */
				
				Carta cartaDescarte = null; 
				int controle = 0;
				for(Carta carta : listaCarta) { // percorre a lista de cartas que ele tem 
					if((carta.getCor().equals(cor)) ) {	// ve se tem carta compativel por cor (block, ret e +2 sao inclusos aqui)
						cartaDescarte = carta;
						this.listaCarta.remove(cartaDescarte);
						controle = 1;
						break;
					} else if(((CartaTipos)carta).getValor() == valor ) { // ve se e' compativel o valor
						cartaDescarte = carta;
						this.listaCarta.remove(cartaDescarte);	
						controle = 1;
						break;
										
					} 
				} 
				if(controle == 0) {
					comprarCarta(1, baralho);
					System.out.println("Robô comprou carta");
					JOptionPane.showMessageDialog(null, "Robô comprou carta");
					} 	
						
				 return cartaDescarte;
				
			
			}

	}
