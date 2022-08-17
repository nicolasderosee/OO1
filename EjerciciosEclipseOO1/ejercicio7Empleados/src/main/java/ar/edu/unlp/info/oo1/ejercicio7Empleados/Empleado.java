package ar.edu.unlp.info.oo1.ejercicio7Empleados;

public class Empleado {
	
	private String nombre;
	
	public void setNombre(String unNombre) {
		this.nombre = unNombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public double montoBasico(){
		return 35000;
	}
	
	public double aportes() {
		return 13200;
	}
	
	public double sueldoBasico() {
		return this.montoBasico() + this.aportes();
	}

}
