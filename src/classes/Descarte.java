package classes;

import java.util.ArrayList;
import java.util.List;

public class Descarte {
	private List<Carta> listaCarta;

	/**
	 * @param listaCarta
	 */
	public Descarte() {
		super();
		this.listaCarta = new ArrayList<Carta>();
	}
	
	public void adicionarCarta(Carta carta) {
		this.listaCarta.add(carta);		
	}

	public List<Carta> getListaCarta() {
		return listaCarta;
	}

	public void setListaCarta(List<Carta> listaCarta) {
		this.listaCarta = listaCarta;
	}
	
	
	
	
	
	
	
}