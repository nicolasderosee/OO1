package ar.edu.unlp.info.oo1.ejercicio3Presupuestos;

public class Item {
	
	private String detalle;
	private int cantidad; 
	private double costoUnitario;
	
	
	public String getDetalle() {
		return detalle;
	}
	
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public double getCostoUnitario() {
		return costoUnitario;
	}
	
	public void setCostoUnitario(double costoUnitario) {
		this.costoUnitario = costoUnitario;
	}

	public Item detalle(String unDetalle) {
		this.setDetalle(unDetalle);
		return this;
	}

	public Item costoUnitario(int unCostoUnitario) {
		this.setCostoUnitario(unCostoUnitario);
		return this;
	}

	public Item cantidad(int unaCantidad) {
		this.setCantidad(unaCantidad);
		return this;
	}

	public Double costo() {
		return this.getCantidad() * this.getCostoUnitario();
	} 
		

}
