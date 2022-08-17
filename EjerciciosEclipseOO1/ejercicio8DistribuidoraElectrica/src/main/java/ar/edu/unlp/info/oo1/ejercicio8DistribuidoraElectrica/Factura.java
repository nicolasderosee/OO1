package ar.edu.unlp.info.oo1.ejercicio8DistribuidoraElectrica;

import java.time.LocalDate;

public class Factura {
	
	private double montoEnergiaActiva;
	private double descuento;
	private LocalDate fecha;
	private Usuario user;
	
		
	public Factura(double montoEnergiaActiva, double descuento, Usuario usuario) {
		this.fecha = LocalDate.now();
		this.montoEnergiaActiva = montoEnergiaActiva;
		this.descuento = descuento;
		this.user = usuario;
	}
	

	public double getMontoEnergiaActiva() {
		return this.montoEnergiaActiva;
	}
	
	
	public double getDescuento() {
		return this.descuento;
	}
	
	
	public LocalDate getFecha() {
		return this.fecha;
	}


	public Usuario getUsuario() {
		return this.user;
	}


	public double montoTotal() {
		return this.montoEnergiaActiva * (1 - this.descuento / 100);
	}
	
	
	
	

}
