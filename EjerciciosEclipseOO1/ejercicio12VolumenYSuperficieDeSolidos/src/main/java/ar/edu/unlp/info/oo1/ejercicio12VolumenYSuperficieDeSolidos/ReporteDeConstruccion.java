package ar.edu.unlp.info.oo1.ejercicio12VolumenYSuperficieDeSolidos;

import java.util.ArrayList;
import java.util.List;

public class ReporteDeConstruccion {
	
	private List <Pieza> piezas;
	
	
	public ReporteDeConstruccion() {
		this.piezas = new ArrayList<Pieza>();
	}

	public double getVolumenDeMaterial(String material) {
		return this.piezas
				.stream()
				.filter(p -> p.getMaterial().equals(material))
				.mapToDouble(p -> p.calcularVolumen())
				.sum();
	}
	
	public double getSuperficieDeColor(String color) {
		return this.piezas
				.stream()
				.filter(p -> p.getColor().equals(color))
				.mapToDouble(p -> p.calcularSuperficie())
				.sum();
	}
	
	public void agregarPiezas(Pieza unaPieza){
		this.piezas.add(unaPieza);
	}
	
	
	public List<Pieza> getPiezas() {
		return this.piezas;
	}
	

}
