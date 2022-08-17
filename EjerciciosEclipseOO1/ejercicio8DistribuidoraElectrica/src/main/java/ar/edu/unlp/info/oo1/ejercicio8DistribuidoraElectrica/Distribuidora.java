package ar.edu.unlp.info.oo1.ejercicio8DistribuidoraElectrica;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Distribuidora {
	
	private double precioKW;
	private List <Usuario> usuarios;
	
	
	public Distribuidora(double precioKW) {
		this.precioKW = precioKW;
		this.usuarios = new ArrayList<Usuario>(); 
	}
	
	public void setPrecioKW(double preciokw) {
		this.precioKW = preciokw;
	}

	
	public double getPrecioKW() {
		return this.precioKW;
	}
	
	
	public void agregarUsuario(Usuario user) {
		this.usuarios.add(user);
	}


	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}
	

	public List<Factura> facturar() {
		List <Factura> resultado = this.usuarios
				.stream()
				.map(u -> u.facturarEnBaseA(this.getPrecioKW()))
				.collect(Collectors.toList());
		
		resultado.sort((f1,f2) -> f1.getFecha().compareTo(f2.getFecha()));
		return resultado;
	}
	
	
	public double consumoTotalActiva() {
		return this.usuarios
				.stream()
				.mapToDouble((Usuario u) -> u.ultimoConsumoActiva())
				.sum();
	}



	

}
