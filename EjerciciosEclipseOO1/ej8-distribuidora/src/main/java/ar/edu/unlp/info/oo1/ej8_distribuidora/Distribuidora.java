package ar.edu.unlp.info.oo1.ej8_distribuidora;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Distribuidora {

	private double precioKW;
	private Set<Usuario> usuarios;

	public Distribuidora(double preciokw) {
		this.precioKW = preciokw;
		this.usuarios = new HashSet<>();
	}

	public double getPrecioKW() {
		return this.precioKW;
	}

	public void agregarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}

	public void setPrecioKW(double preciokw) {
		this.precioKW = preciokw;
	}

	public List<Usuario> getUsuarios() {
		return new ArrayList<>(this.usuarios);
	}

	public List<Factura> facturar() {
		List<Factura> result = this.usuarios
			.stream()
			.map((Usuario u) -> u.facturarEnBaseA(this.getPrecioKW()))
			.collect(Collectors.toList());
		return result;
	}

	public double consumoTotalActiva() {
		return this.usuarios 
			.stream() //a la coleccion de usuarios le indico que entienda stream 
			.mapToDouble((Usuario u) -> u.ultimoConsumoActiva()) //me quedo con la energia activa de cada uno 
			.sum(); //sumo todos sus valores para obtener el consumo total de energia activa 
	}

}
