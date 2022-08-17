package ar.edu.unlp.info.oo1.ejercicio2BalanzaElectronica;

public class Balanza {
	
	private int cantidadDeProductos;
	private double precioTotal;
	private double pesoTotal;
	
	public int getCantidadDeProductos() {
		return this.cantidadDeProductos;
	}
	
	public double getPrecioTotal() {
		return this.precioTotal;
	}
	
	public double getPesoTotal() {
		return this.pesoTotal;
	}
	
	public void ponerEnCero() {
		this.cantidadDeProductos = 0;
		this.precioTotal = 0;
		this.pesoTotal = 0;	
	}

	public void agregarProducto(Producto unProducto) {
		this.cantidadDeProductos++;
		this.pesoTotal = this.pesoTotal + unProducto.getPeso();
		this.precioTotal = this.precioTotal + unProducto.getPrecio();
	}

	public Ticket emitirTicket() {
		return new Ticket(this.getCantidadDeProductos(), this.getPesoTotal(), this.getPrecioTotal());
	}
	
}
