package ar.edu.unlp.info.oo1.ejercicio4figurasYCuerpos;

public class Cuadrado implements Figura{
	
	private double lado;
	
	public void setLado(double lado) {
		this.lado = lado;
	}
	
	public double getLado() {
		return this.lado;
	}

	@Override
	public double getArea() {
		return this.lado * this.lado;
	}

	@Override
	public double getPerimetro() {
		return this.lado * 4;
	}
	

}
