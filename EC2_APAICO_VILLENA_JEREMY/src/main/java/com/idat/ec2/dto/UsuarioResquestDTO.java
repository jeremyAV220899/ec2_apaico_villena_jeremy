package com.idat.ec2.dto;

public class UsuarioResquestDTO {

	private String usuario;
	private String contrasenia;
	
	
	public UsuarioResquestDTO() {
		super();
	}
	public UsuarioResquestDTO(String usuario, String contrasenia) {
		super();
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	
}
