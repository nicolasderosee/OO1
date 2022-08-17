package ar.edu.unlp.info.oo1.ejercicio7Empleados;

public class Gerente extends EmpleadoJerarquico {
	
	public Gerente(String nombre) {
		super.setNombre(nombre);
	}

	public double aportes () {
		return this.montoBasico() * 0.05d;
	}

	public double montoBasico() {
		return 57000;
	}
}
