package ar.edu.unlp.info.oo1.ejercicio3BisBalanzaMejorada;

public class Producto {
	
	private double peso; 
	private double precioPorKilo;
	private String descripcion;
	
	public double getPrecioPorKilo () {
		return this.precioPorKilo;
	}
	
	public double getPeso() {
		return this.peso;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public double getPrecio() {
		return this.getPrecioPorKilo() * this.getPeso();
	}
	
	public void setPrecioPorKilo(double unPrecio) {
		this.precioPorKilo = unPrecio;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
	
