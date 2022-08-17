package ar.edu.unlp.info.oo1.ejercicio3BisBalanzaMejorada;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ticket {
	
	private LocalDate fecha;
	private int cantidadDeProductos;
	private double pesoTotal;
	private double precioTotal;
	
	private List <Producto> productos = new ArrayList<Producto>();
	

	public Ticket(int cant, double peso, double precio) {
		this.fecha = LocalDate.now();
		this.cantidadDeProductos = cant;
		this.pesoTotal = peso;
		this.precioTotal = precio;
	}
	
	public List <Producto> getProductos(){
		return this.productos;
	}
	
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
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
