package ar.edu.unlp.info.oo1.ejercicioParcial;

public class Bienes extends Item {
	
	private int cant;
	private double pesoKgU;
	private double valorU;
	
	public Bienes(String descripcion, Pedido pedido, int cant, double pesoKgU, double valorU) {
		super(descripcion, pedido);
		this.cant = cant;
		this.pesoKgU = pesoKgU;
		this.valorU = valorU;
	}

	@Override
	public double getMontoTotal() {
		if (this.sobrePeso()) {
			return (0.1*(this.valorU*this.cant)) + (this.valorU*this.cant);
		}
		return (this.valorU*this.cant);
	}
	
	private boolean sobrePeso() {
		return (this.cant * this.pesoKgU) > 1000;
	}
	
	
	
	

}
