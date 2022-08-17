package ar.edu.unlp.info.oo1.ejercicio5GenealogiaSalvaje;

import java.util.Date;

public class Mamifero {
	
	private String identificador;
	private String especie;
	private Date fechaDeNacimiento;
	private Mamifero madre;
	private Mamifero padre;
	
	
	public Mamifero(String unMamifero) {
		this.identificador = unMamifero;
		
	}

	public Mamifero() {
		
	}

	public String getIdentificador() {
		return identificador;
	}
	
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	public String getEspecie() {
		return especie;
	}
	
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	
	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	
	public void setPadre(Mamifero mamifero) {
		this.padre = mamifero;
	}
	
	public void setMadre(Mamifero mamifero) {
		this.madre = mamifero;
	}

	public Mamifero getMadre() {
		return this.madre;
	}
	
	public Mamifero getPadre() {
		return this.padre;
	
	}

	public Mamifero getAbuelaMaterna() {
		if(this.getMadre() != null)
			return this.getMadre().getMadre();
		else return null;
	}
	
	public Mamifero getAbueloMaterno() {
		if(this.getMadre() != null)
			return this.getMadre().getPadre();
		else return null;
	}
	
	public Mamifero getAbuelaPaterna() {
		if(this.getPadre() != null)
			return this.getPadre().getMadre();
		else return null;
	}
	
	public Mamifero getAbueloPaterno() {
		if(this.getPadre() != null)
			return this.getPadre().getPadre();
		else return null;
	}

	public boolean tieneComoAncestroA(Mamifero ancestro) {
		boolean ramaPadre = false;
		boolean ramaMadre = false;
		if(this.getPadre() == null && this.getMadre() == null)
			return false;
		if(this.getPadre() != null) {
			if(this.getPadre().getIdentificador() == ancestro.getIdentificador())
				return true;
			ramaPadre = this.getPadre().tieneComoAncestroA(ancestro);
		}
		if(this.getMadre() != null) {
			if(this.getMadre().getIdentificador() == ancestro.getIdentificador())
				return true;
			ramaMadre = this.getMadre().tieneComoAncestroA(ancestro);
		}
		return (ramaMadre || ramaPadre);	
	}

}


