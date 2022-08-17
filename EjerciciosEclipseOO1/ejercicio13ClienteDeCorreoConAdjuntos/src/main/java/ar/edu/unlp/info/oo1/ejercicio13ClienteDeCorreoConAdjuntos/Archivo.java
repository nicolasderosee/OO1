package ar.edu.unlp.info.oo1.ejercicio13ClienteDeCorreoConAdjuntos;

public class Archivo {
	
	private String nombre;
	
	public Archivo(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getTamaño() {
		return this.nombre.length();
	}
	
}
