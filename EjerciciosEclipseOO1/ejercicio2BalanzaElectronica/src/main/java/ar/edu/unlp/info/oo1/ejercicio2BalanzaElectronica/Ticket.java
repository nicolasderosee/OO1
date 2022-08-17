package ar.edu.unlp.info.oo1.ejercicio2BalanzaElectronica;

import java.time.LocalDate;

public class Ticket {
	
	private LocalDate fecha;
	private int cantidadDeProductos;
	private double pesoTotal;
	private double precioTotal;
	
	
	
	public Ticket(int cant, double peso, double precio) {
		this.fecha = LocalDate.now();
		this.cantidadDeProductos = cant;
		this.pesoTotal = peso;
		this.precioTotal = precio;
	}
	

	public LocalDate getFecha() {
		return this.fecha;
	}

	public int getCantidadDeProductos() {
		return this.cantidadDeProductos;
	}


	public double getPesoTotal() {
		return this.pesoTotal;
	}


	public double getPrecioTotal() {
		return this.precioTotal;
	}


	public Double impuesto() {
		return this.getPrecioTotal() * 0.21;
	}
	
}
