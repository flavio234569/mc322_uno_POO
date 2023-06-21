package classes;

import java.util.ArrayList;
import java.util.List;

public abstract class Jogador {
	private String nome;
	private int idade;
	private Boolean humano;
	protected List<Carta> listaCarta;
	
	// Construtor
	public Jogador(String nome, int idade, boolean humano) {
		this.nome = nome;
		this.idade = idade;
		this.humano = humano;
		this.listaCarta = new ArrayList<Carta>();
	}
	
	// Gets e Sets
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) { // atualiza a variavel estatica que atualiza o id
		this.nome = nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) { // atualiza a variavel estatica que atualiza o id
		this.idade = idade;
	}
	
	public Boolean getHumano() {
		return humano;
	}
	
	public void setHumano(Boolean humano) {
		this.humano = humano;
	}
	
	public List<Carta> getListaCarta(){
		return listaCarta;
	}
	
	public void setListaCarta(List<Carta> listaCarta) {
		this.listaCarta = listaCarta;
	}
	
	// Metodo toString
	public String toString () {
		return "Jogador:" +
				"\n Nome: " + this.nome +
				"\n Idade: " + this.idade +
				"\n Tipo de jogador humano: " + this.humano  
				//"\n Lista de cartas: " 
				;
	}
}
