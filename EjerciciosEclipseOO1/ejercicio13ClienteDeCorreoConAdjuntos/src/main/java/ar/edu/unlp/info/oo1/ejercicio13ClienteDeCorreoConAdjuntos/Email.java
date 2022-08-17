package ar.edu.unlp.info.oo1.ejercicio13ClienteDeCorreoConAdjuntos;

import java.util.ArrayList;
import java.util.List;

public class Email {
	
	private String titulo;
	private String cuerpo;
	private List <Archivo> adjuntos;
	
	
	
	public Email(String titulo, String cuerpo) {
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		this.adjuntos = new ArrayList<Archivo>();
	}
	

	public String getCuerpo() {
		return this.cuerpo;
	}

	public List<Archivo> getAdjuntos() {
		return adjuntos;
	}
	
	public void adjuntarArchivo(Archivo arch) {
		this.adjuntos.add(arch);
	}


	public String getTitulo() {
		return this.titulo;
	}
	
	public boolean contiene(String texto) {
		return (this.titulo.equals(texto) || this.cuerpo.equals(texto));
	}
	
	public int tamañoEmail() {
		double archivos = this.adjuntos.stream()
				.mapToInt(a -> a.getTamaño()) //me quedo con el tamaño de cada archivo 
				.sum(); //sumo todos los tamaños de cada archivo y lo guardo en archivos 
		return (int) (archivos + this.getCuerpo().length() + this.getTitulo().length());
	}

}
