package ar.edu.unlp.info.oo1.ejercicioParcial;

public class Servicio extends Item {
	
	private double costoMateriales;
	private double costoManoObra;
	
	
	public Servicio(String descripcion, Pedido pedido, double costoMateriales, double costoManoObra) {
		super(descripcion, pedido);
		this.costoMateriales = costoMateriales;
		this.costoManoObra = costoManoObra;
	}

	@Override
	public double getMontoTotal() {
		return this.costoManoObra + this.costoMateriales;
	}

	public double getCostoMateriales() {
		return costoMateriales;
	}

	public double getCostoManoObra() {
		return costoManoObra;
	}

}
