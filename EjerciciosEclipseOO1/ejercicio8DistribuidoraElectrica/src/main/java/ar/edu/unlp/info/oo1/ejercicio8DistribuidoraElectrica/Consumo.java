package ar.edu.unlp.info.oo1.ejercicio8DistribuidoraElectrica;

import java.time.LocalDate;

public class Consumo {
	
	private LocalDate Fecha;
	private double consumoEnergiaActiva;
	private double consumoEnergiaReactiva;
	
	
	public Consumo(LocalDate localDate, double consumoEnergiaActiva, double consumoEnergiaReactiva) {
		this.Fecha = localDate;
		this.consumoEnergiaActiva = consumoEnergiaActiva;
		this.consumoEnergiaReactiva = consumoEnergiaReactiva;
	}
	

	public LocalDate getFecha() {
		return Fecha;
	}
	
	
	public double getConsumoEnergiaActiva() {
		return this.consumoEnergiaActiva;
	}
	
	
	public double getConsumoEnergiaReactiva() {
		return this.consumoEnergiaReactiva;
	}
	
	
	public double costoEnBaseA(double precioKWh) {
		return this.consumoEnergiaActiva * precioKWh;
	}
	
	
	public double factorDePotencia() {
		return this.getConsumoEnergiaActiva() / 
				Math.sqrt(Math.pow(this.getConsumoEnergiaActiva(),2) + Math.pow(this.getConsumoEnergiaReactiva(), 2));
	}
	
	
}
