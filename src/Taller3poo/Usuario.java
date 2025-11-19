package Taller3poo;

/**
 * Representa a una persona que utiliza el sistema.
 * <p>
 * Guarda los datos de acceso (usuario y contraseña) y define qué nivel de
 * permisos tiene (si es Administrador o Colaborador) para saber qué menús mostrarle.
 * </p>
 * @author Matías Collao
 * @author Lucas Riquelme
 * @version 1.0
 */
public class Usuario {
	
	private String username, contraseña, rol;
	
	/**
	 * Constructor: Crea un nuevo usuario.
	 * @param username El nombre de usuario único para iniciar sesión.
	 * @param contraseña La clave de acceso.
	 * @param rol El tipo de usuario ("Administrador" o "Colaborador").
	 */
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
