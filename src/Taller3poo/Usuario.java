package Taller3poo;

public class Usuario {
	
	private String username, contraseña, rol;

	public Usuario(String username, String contraseña, String rol) {
		this.username = username;
		this.contraseña = contraseña;
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [username=" + username + ", contraseña=" + contraseña + ", rol=" + rol + "]";
	}

	public String getUsername() {
		return username;
	}

	public String getContraseña() {
		return contraseña;
	}

	public String getRol() {
		return rol;
	}
	
	
	
	
}
