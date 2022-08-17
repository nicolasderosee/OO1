package ar.edu.unlp.info.oo1.ejercicio11El_Inversor;

public class InversionEnAcciones implements Inversion {
	
	String nombre;
	int cantidad;
	double valorUnitario;
	
	
	public InversionEnAcciones(String nombre, int cantidad, double valorUnitario) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.valorUnitario = valorUnitario;
	}


	public String getNombre() {
		return this.nombre;
	}
	
	
	public int getCantidad() {
		return this.cantidad;
	}
	

	public double getValorUnitario() {
		return this.valorUnitario;
	}


	@Override
	public double valorActual() {
		return this.getCantidad() * this.getValorUnitario();
	}
	


}
