package classes;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
	private Baralho baralho;
	private List<Jogador> listaJogador;
	private Descarte descarte;
	/**
	 * @param baralho
	 * @param listaJogador
	 * @param descarte
	 */
	public Mesa(Baralho baralho, Descarte descarte) {
		super();
		this.baralho = baralho;
		this.listaJogador = new ArrayList<Jogador>();;
		this.descarte = descarte;
	}
	
	
	
}
