package classes;

import java.util.Scanner;

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

	
	
}
