package ar.edu.unlp.info.oo1.ejercicio4figurasYCuerpos;

public class Circulo implements Figura{
	private double diametro;
	
	public double getDiametro() {
		return this.diametro;
	}
	
	public void setDiametro(double diametro) {
		this.diametro = diametro;
	}
	
	public double getRadio() {
		return this.diametro/2;
	}
	
	public void setRadio(double radio) {
		this.diametro = radio * 2;  
	}

	public double getArea() {
		return Math.PI * Math.pow(this.getRadio(), 2);
	}

	public double getPerimetro() {
		return this.getDiametro() * Math.PI;
	}

}
