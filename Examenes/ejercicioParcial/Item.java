package ar.edu.unlp.info.oo1.ejercicioParcial;

public abstract class Item {
	
	private Pedido pedido;
	private String descripcion;
	
	public Item (String descripcion, Pedido pedido) {
		this.pedido = pedido;
		this.descripcion = descripcion;
	}

	public abstract double getMontoTotal();

	public Pedido getPedido() {
		return pedido;
	}

	public String getDescripcion() {
		return descripcion;
	}

}
