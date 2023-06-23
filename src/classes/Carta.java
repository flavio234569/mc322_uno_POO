package classes;

public abstract class Carta {
	//Atributos
	private String cor;
	private Boolean acao;

	//Construtor
	public Carta(String cor, Boolean acao){
		this.cor = cor;
		this.acao = acao;
	}

	//getters and setters
	public String getCor(){
		return cor;
	}
	public void setCor(String cor){
		this.cor = cor;
	}

	public Boolean getAcao(){
		return acao;
	}
	public void setAcao(Boolean acao){
		this.acao = acao;
	}

	public int getValor(){
		return 0;
	}
	public void setValor(int valor){
	}
}
