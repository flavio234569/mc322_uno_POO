package classes;

import java.util.ArrayList;
import java.util.List;

public abstract class Jogador {
	private String nome;
	private Boolean humano;
	protected Baralho baralho;
	protected List<Carta> listaCarta;
	private int fim;
	
	// Construtor
	public Jogador(String nome, Baralho baralho, boolean humano) {
		this.nome = nome;
		this.humano = humano;
		this.baralho = baralho;
		this.listaCarta = new ArrayList<Carta>();
		this.fim = -1;
	}
	
	// Gets e Sets
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) { // atualiza a variavel estatica que atualiza o id
		this.nome = nome;
	}
	
	public Baralho getBaralho() {
		return baralho;
	}
	
	public void setBaralho(Baralho baralho) { // atualiza a variavel estatica que atualiza o id
		this.baralho = baralho;
	}
	
	public Boolean getHumano() {
		return humano;
	}
	
	public void setHumano(Boolean humano) {
		this.humano = humano;
	}
	
	public int getFim() {
		return fim;
	}
	
	public void setFim(int uno) {
		this.fim = uno;
	}
	
	
	public List<Carta> getListaCarta(){
		return listaCarta;
	}
	
	public void setListaCarta(List<Carta> listaCarta) {
		this.listaCarta = listaCarta;
	}
	
	// printar a lista de cartas
	public String printListaCartas() {
		String ListaDeCartas = "";
		for(int i = 0; i < listaCarta.size(); i++) {
			Carta carta = listaCarta.get(i);
			System.out.println("[" + i + "] " + ((CartaTipos) carta).toString());
			ListaDeCartas = ListaDeCartas + "[" + i + "] " + ((CartaTipos) carta).toString() + "\n";
			
		}
		return ListaDeCartas;
	}
	
	// Comprar cartas conforme a quantidade solicitada
	public void comprarCarta(int qtdCartas, Baralho baralho){
		for(int i = 0; i < qtdCartas ; i++) { 
			this.getListaCarta().add(baralho.getListaCarta().get(baralho.getListaCarta().size()-1)); // pega a ultima carta da lista do baralho e adiciona aqui
			baralho.removerCarta(); // ja retira essa carta do baralho
		}
	}
	
	
	// funcao de declaracao de uno do jogador (a verificacao sera feita pela Mesa)
	 public void falarFim() {
		 System.out.println("FIM!"); // jogador fala uno se acha que tem apenas uma carta
		 
		 if(listaCarta.size() == 1) {
			this.setFim(1);  // de fato tem 1 carta logo Uno e' valido
		 }
		 else {
			 this.setFim(0); // falou uno errado e a mesa vai lidar com a carta a mais
		 }
	 }
	 
	 // comprarCarta
	
	// Metodo toString
	public String toString () {
		return "Jogador:" +
				"\n Nome: " + this.nome +
				"\n Tipo de jogador humano: " + this.humano  
				//"\n Lista de cartas: " 
				;
	}
}
