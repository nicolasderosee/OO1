package dominio;

public class Usuario {
	
	private String nombre;
	private int DNI; 
	private String direccion;
	
	
	public Usuario(String nombre, int dni, String direccion) {
		this.nombre = nombre;
		this.DNI = dni;
		this.direccion = direccion;
	}


	public String getNombre() {
		return nombre;
	}

	public int getDNI() {
		return DNI;
	}

	public String getDireccion() {
		return direccion;
	}

}
