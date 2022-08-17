package ar.edu.unlp.info.oo1.ejercicio12VolumenYSuperficieDeSolidos;

public abstract class Pieza {
	
	private String material;
	private String color;
	
	
	public Pieza(String material, String color) {
		this.material = material;
		this.color = color;
	}

	public String getMaterial() {
		return this.material;
	}
	
	public String getColor() {
		return this.color;
	}
	
	
	protected abstract double calcularVolumen();

	protected abstract double calcularSuperficie();

}
