package servicios;

import java.util.ArrayList;
import java.util.List;

import dominio.Usuario;

public class servicioDeUsuarios {
	
	private final List<Usuario> usuarios;
	
	public servicioDeUsuarios() {
		this.usuarios = new ArrayList<Usuario>();
	}
	
	public List<Usuario> getUsuarios(){
		return this.usuarios;
	}
	
	public Usuario registrarUsuario(String nombre, String direccion, int dni) {
		Usuario usuario = new Usuario(nombre, dni, direccion); 
		usuarios.add(usuario);
		return usuario;
	}

}