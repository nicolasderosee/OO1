package ar.edu.unlp.info.oo1.ejercicio11El_Inversor;

import java.util.ArrayList;
import java.util.List;

public class Inversor {
	
	String nombre;
	List<Inversion> inversiones;
		
	
	public Inversor(String nombre, Inversion inversion) {
		this.nombre = nombre;
		this.inversiones = new ArrayList<Inversion>();
		this.inversiones.add(inversion);
	}


	public String getNombre() {
		return this.nombre;
	}

	
	public List<Inversion> getInversiones() {
		return this.inversiones;
	}

	
	public double valorActual() {
		return this.inversiones
				.stream()
				.mapToDouble((Inversion i) -> i.valorActual())
				.sum();	
	}
	
	
	
	


}
