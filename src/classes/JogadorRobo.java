package classes;

public class JogadorRobo extends Jogador {

	public JogadorRobo(String nome, int idade, boolean humano) {
		super(nome, idade, humano);
	}
	
	public void realizaJogada() {
		// se a ultima carta do descarte nao for um +2/+4/escolheCor/bloqueio/retorno
		
			// ve se tem alguma carta da mesma cor (se tiver: joga) (aqui o 'block', 'retorno' e '+2' sao incluidos)
			
			// ve se tem uma carta do mesmo numero (se tiver joga) 
			
			// joga um 'escolheCor' ou um '+4'
		
		// se a ultima carta foi um 'escolheCor/+4' ve a cor selecionada e verifica lista a partir dai
		
		// se nao tiver nenhuma carta - compra carta do baralho direto
	}
	
	
	// nao sei fazer ele rodar isso em toda as rodadas
	public void unoAutomatico() {
		if(listaCarta.size() == 1) {
			System.out.println("UNO!");
		}
	}
}
