package ar.edu.unlp.info.oo1.ejercicio4figurasYCuerpos;

public class Cuerpo3D {
	
	private double altura;
	private Figura carabasal;
	
	public double getAltura() {
		return this.altura;
	}
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public void setCaraBasal(Figura carabasal) {
		this.carabasal = carabasal;
	}
	
	public double getSuperficieExterior() {
		return 2 * this.carabasal.getArea() + this.carabasal.getPerimetro() * this.getAltura();
	}
	
	public double getVolumen() {
		return this.carabasal.getArea() * this.getAltura();
	}
	
	

}
