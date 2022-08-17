package ar.edu.unlp.info.oo1.ejercicio13ClienteDeCorreoConAdjuntos;

import java.util.HashSet;
import java.util.Set;

public class Carpeta {
	
	private String nombre;
	private Set <Email> emails;
	
	
	public Carpeta() {
		this.nombre = "nueva carpeta";
		this.emails = new HashSet<Email>();
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public void agregarEmail(Email email) {
		this.emails.add(email);
	}
	
	public Set<Email> getEmails() {
		return this.emails;
	}
	
	public boolean eliminarEmail(Email email) {
		if ((this.emails != null) && (this.emails.contains(email))) {
			this.emails.remove(email);
			return true;
		}
		return false;
	}
	
	/*
	 * con el filter me quedo con todos los emails que contienen el texto y luego devuelvo un valor que es el primero que coincidio.
	 * si el texto no esta contenido en ningun email, contiene retorna null y como no se devuelve ningun valor, el findFirst
	 * (que es un Optional) retorna null 
	 */
	public Email buscarEmail (String texto) {
		if(this.emails != null) {
			return this.emails
					.stream()
					.filter(e -> e.contiene(texto)).findFirst().orElse(null); //delego al email para saber si contiene el texto 
		}
		return null;
	}
	
	public int tamañoCarpeta() {
		return emails
				.stream()
				.mapToInt(e -> e.tamañoEmail()) //me quedo con el tamaño total de cada email de la carpeta 
				.sum(); //sumo el tamañoTotal de cada email que es en teoria el tamaño total de la carpeta 
	}

}
