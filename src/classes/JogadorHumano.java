package classes;

public class JogadorHumano extends Jogador {
	
	public JogadorHumano(String nome, int idade, boolean humano) {
		super(nome, idade, humano);
	}
	
	public void comprarCarta(int qtdCartas, Baralho baralho){
		for(int i = 0; i < qtdCartas - 1; i++) { // loop de adicionar cartas conforme a quantidade de entrada
			this.getListaCarta().add(baralho.getListaCarta().get(baralho.getListaCarta().size()-1)); // pega a ultima carta da lista do baralho e adiciona aqui
			baralho.removerCarta(); // ja retira essa carta do baralho
		}
	}
	
	public void descartarCarta(int index){
		this.listaCarta.remove(this.listaCarta.get(index));
	}

	// funcao de declaracao de uno do jogador (a verificacao sera feita pela Mesa)
	 public boolean falarUno() {
		 System.out.println("UNO!"); // jogador fala uno se acha que tem apenas uma carta
		 
		 if(listaCarta.size() == 1) {
			 return true;  // de fato tem 1 carta logo Uno e' valido
		 }
		 else {
			 return false; // falou uno errado e a mesa vai lidar com a carta a mais
		 }
	 }
	 
	 /* Exclui essa funcao pois o efeito dela no humano e' o mesmo do "comprarCarta()"
	   
	 public void semCarta() { // se o jogador ver que nao tem carta ele aciona esse comando
		 
	 }*/
}
