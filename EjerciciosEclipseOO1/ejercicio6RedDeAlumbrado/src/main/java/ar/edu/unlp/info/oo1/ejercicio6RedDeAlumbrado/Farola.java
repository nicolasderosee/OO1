package ar.edu.unlp.info.oo1.ejercicio6RedDeAlumbrado;

import java.util.ArrayList;
import java.util.List;

public class Farola {
	
	private boolean apagada; //apagada = false, esta prendida 
	private List <Farola> vecinas;
	
	
	/*
	* Crear una farola. Debe inicializarla como apagada
	*/
	public Farola () {
		this.apagada = true; //esta apagada
		vecinas = new ArrayList<Farola>();
	}
	
	
	/*
	* Crea la relación de vecinos entre las farolas. La relación de vecinos entre las farolas es recíproca, 
	* es decir el receptor del mensaje será vecino de otraFarola, al igual que otraFarola también se convertirá en vecina del receptor del mensaje
	*/
	public void pairWithNeighbor(Farola otraFarola) {
		this.addNeighbor(otraFarola);
		otraFarola.addNeighbor(this);
		
	}
	
	
	private void addNeighbor(Farola unaFarola) {
		this.vecinas.add(unaFarola);
	}
	
	/*
	* Retorna sus farolas vecinas
	*/
	public List<Farola> getNeighbors (){
		return this.vecinas;
	}


	/*
	* Si la farola no está encendida, la enciende y propaga la acción.
	*/
	public void turnOn() {
		if(!this.isOn()) {
			this.apagada = false;
			vecinas.forEach(Farola::turnOn);
		}
	}
	

	/*
	* Si la farola no está apagada, la apaga y propaga la acción.
	*/
	public void turnOff() {
		if(this.isOn()) {
			this.apagada = true;
			vecinas.forEach(Farola::turnOff);
		}
	}
	
	
	/*
	* Retorna true si la farola está encendida.
	*/
	public boolean isOn() {
		if(this.apagada == false)
			return true;
		else return false;
	}
	
}
	
