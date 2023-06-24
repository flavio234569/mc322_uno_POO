package classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {
	private String Id;
	private List<Carta> listaCarta;
	
	public Baralho(String id) {
		super();
		Id = id;
		this.listaCarta = new ArrayList<Carta>();
		
	}
	
	
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}


	public List<Carta> getListaCarta() {
		return listaCarta;
	}

	public void setListaCarta(List<Carta> listaCarta) {
		this.listaCarta = listaCarta;
	}



	public void adicionarCarta(Carta carta) {
		this.listaCarta.add(carta);
		
	}
	
	public void removerCarta() {
		this.listaCarta.remove(this.listaCarta.size()-1);
	}
	
	public void embaralhar() {
		Collections.shuffle(this.listaCarta); 
	}
	
	public void monteVazio(Descarte descarte){
		for (int i = 0; i < descarte.getListaCarta().size()-1; i++) {
			this.adicionarCarta(descarte.getListaCarta().get(i));
			descarte.getListaCarta().remove(i);
		}
	}
	
	
}