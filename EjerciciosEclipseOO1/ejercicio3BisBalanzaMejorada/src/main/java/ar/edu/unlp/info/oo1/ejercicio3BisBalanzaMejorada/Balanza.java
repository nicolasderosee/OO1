package ar.edu.unlp.info.oo1.ejercicio3BisBalanzaMejorada;

import java.util.ArrayList;
import java.util.List;


public class Balanza {
	
	
	private List<Producto> productos = new ArrayList<Producto>(); 
	
	
	public List <Producto> getProductos(){
		return this.productos;
		
	}
	
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public void ponerEnCero() {
		this.productos.clear();
	}

	public void agregarProducto(Producto unProducto) {
		this.productos.add(unProducto);
	}
	
	public double getPesoTotal() {
		double total = 0;
		for(Producto prod: productos ) {
			total+= prod.getPeso();
		}	
	    return total;
	}
	
	public double getPrecioTotal() {
		double total = 0;
		for(Producto prod: productos) {
			total+= prod.getPrecio();
		}
		return total;
	}
	
	public int getCantidadDeProductos() {
		return this.productos.size();
	}

	public Ticket emitirTicket() {
		Ticket t = new Ticket(this.getCantidadDeProductos(), this.getPesoTotal(), this.getPrecioTotal());	
		t.setProductos(this.getProductos());
		return t;
	}
	
}
