package ar.edu.unlp.info.oo1.ejercicio7Empleados;

public class Implementación {
	
	public static void main (String args[]) {
		
		Gerente Alan = new Gerente("Ala Touring");
		
		double aportesDeAlan = Alan.aportes();
		double sueldoBasicoDeAlan = Alan.sueldoBasico();
		
		System.out.println(aportesDeAlan);
		
		System.out.println(sueldoBasicoDeAlan);
	}
	
}
