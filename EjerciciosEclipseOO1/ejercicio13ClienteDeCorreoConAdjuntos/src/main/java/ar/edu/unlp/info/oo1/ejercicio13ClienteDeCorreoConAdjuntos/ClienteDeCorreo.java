package ar.edu.unlp.info.oo1.ejercicio13ClienteDeCorreoConAdjuntos;


import java.util.HashSet;
import java.util.Set;

public class ClienteDeCorreo {
	
	private Set <Carpeta> carpetas;
	private Carpeta inbox;
	
	public ClienteDeCorreo() {
		this.inbox = new Carpeta();
		this.carpetas = new HashSet<Carpeta>();
		this.carpetas.add(inbox);
		
	}
	
	public void recibir (Email email) {
		this.inbox.agregarEmail(email);
	}
	
	public void mover (Email email, Carpeta origen, Carpeta destino) {
		destino.agregarEmail(email);
		origen.eliminarEmail(email);
	}
	
	public Email buscar(String texto) {
		return this.carpetas
				.stream()
				.map((Carpeta c) -> c.buscarEmail(texto)) //delego a la carpeta la busqueda y se retorna el email que contiene el texto. Van llegando mails de a uno por el stream
				.filter((Email e) -> e != null) //pasan solo los emails que no son null 
				.findFirst().orElse(null); // retorno el primero que llegó y termina, si no hay valor para retornar retorna null 
	}
	
	public int espacioOcupado() {
		return carpetas
				.stream()
				.mapToInt(c -> c.tamañoCarpeta()) //me quedo con el tamaño total de cada carpeta 
				.sum(); //sumo el tamaño de cada carpeta que en teoria es el espacio total ocupado 
	}
	
	public void agregarCarpeta(Carpeta carpeta) {
		this.carpetas.add(carpeta);
	}
	
	public Set<Carpeta> getCarpetas(){
		return this.carpetas;
	}
	
	public Carpeta getCarpeta() {
		return this.inbox;
	}

}
