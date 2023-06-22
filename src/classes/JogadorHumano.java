package classes;

public class JogadorHumano extends Jogador {
	
	public JogadorHumano(String nome, Baralho baralho,boolean humano) {
		super(nome, baralho, humano);
		
	}
	
	// funcao para a jogada do humano
	public Carta descartarCarta(int index){
		Carta cartaDescarte = this.listaCarta.get(index); // seleciona a carta conforme o index da lista
		this.listaCarta.remove(cartaDescarte);			  // retira a carta da lista do jogador
		return cartaDescarte;
	}

	
	
}
