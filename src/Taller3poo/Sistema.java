package Taller3poo;

import java.io.*;
import java.util.*;

/**
 * Clase principal del sistema encargada de iniciar el programa, cargar datos
 * desde archivos, gestionar usuarios, proyectos y tareas, y dirigir el flujo
 * según el rol del usuario. Implementa el patrón Singleton para asegurar una
 * única instancia.
 */
public class Sistema {

	private static Sistema instancia;
	private ArrayList<Usuario> listUsuario;
	private ArrayList<Proyecto> listProyecto;
	private ArrayList<Tarea> listTarea;

	/**
	 * Método principal que inicializa el programa, carga usuarios, proyectos y
	 * tareas, solicita el inicio de sesión y ejecuta el menú correspondiente según
	 * el rol del usuario (Administrador o Colaborador).
	 *
	 * @throws IOException si ocurre un problema al leer los archivos de datos
	 */
	public void sistema() throws IOException {

		System.out.println("Iniciando el programa... ");
		this.listUsuario = creadoraUsuarios();
		this.listProyecto = creadoraProyectos();
		this.listTarea = creadoraTareas(listProyecto);

		String username = ingresarUsuario(listUsuario);

		String opcion = " ";
		for (Usuario u : listUsuario) {
			if (u.getUsername().equals(username)) {
				opcion = u.getRol();
			}
		}

		if (opcion.equals("Administrador")) {
			MenuAdministrador m = new MenuAdministrador();
			m.iniciarMenu(listProyecto, listTarea);

		} else if (opcion.equals("Colaborador")) {
			MenuUsuario me = new MenuUsuario();
			me.iniciarMenu(listProyecto, listTarea, username);
		} else {
			System.out.println("Usuario no existe");
		}

	}

	/**
	 * Obtiene la lista completa de tareas cargadas en el sistema.
	 *
	 * @return lista de tareas
	 */
	public ArrayList<Tarea> getListTarea() {
		return listTarea;
	}

	/**
	 * Obtiene la lista completa de usuarios registrados en el sistema.
	 *
	 * @return lista de usuarios
	 */
	public ArrayList<Usuario> getListUsuario() {
		return listUsuario;
	}

	/**
	 * Solicita el nombre de usuario y contraseña por consola y verifica si existe
	 * un usuario válido en la lista entregada.
	 *
	 * @param listUsuario lista de usuarios disponibles
	 * @return nombre de usuario si las credenciales son correctas; cadena vacía si
	 *         no lo son
	 */
	private String ingresarUsuario(ArrayList<Usuario> listUsuario) {

		System.out.print("Ingresa usuario: ");

		String usuario = escanearTecldo();
		for (Usuario u : listUsuario) {
			if (u.getUsername().equals(usuario)) {
				System.out.println("Usuario encontrado");
				System.out.print("Ingrese contraseña: ");
				String contraseña = escanearTecldo();
				if (u.getContraseña().equals(contraseña)) {
					System.out.println("Contraseña Correcta");
					return u.getUsername();
				} else {
					System.out.println("Contraseña Incorrecta");
				}
			}

		}

		return "";
	}

	/**
	 * Lee y retorna una línea ingresada por teclado.
	 *
	 * @return texto ingresado por el usuario; retorna cadena vacía si ocurre un
	 *         error
	 */
	private String escanearTecldo() {
		Scanner s = new Scanner(System.in);
		String a = "";
		try {
			a = s.nextLine();
		} catch (Exception e) {
			System.out.println("Ingreso no adecuado");
		}
		return a;
	}

	/**
	 * Carga todas las tareas desde el archivo "tareas.txt", crea objetos Tarea con
	 * la fábrica correspondiente e incorpora cada tarea al proyecto al que
	 * pertenece.
	 *
	 * @param listProyecto lista de proyectos existentes a los cuales se asociarán
	 *                     las tareas
	 * @return lista completa de tareas cargadas
	 * @throws FileNotFoundException si el archivo "tareas.txt" no se encuentra
	 */
	private ArrayList<Tarea> creadoraTareas(ArrayList<Proyecto> listProyecto) throws FileNotFoundException {

		Scanner s = new Scanner(new File("tareas.txt"));
		ArrayList<Tarea> lista = new ArrayList<>();

		TareaFactory tareaFactory = new TareaFactory();

		while (s.hasNextLine()) {
			String linea = s.nextLine();
			String[] parte = linea.split("\\|");

			Tarea t = tareaFactory.crearTarea(parte[0], parte[1], parte[2], parte[3], parte[4], parte[5], parte[6],
					parte[7]);

			lista.add(t);

			for (Proyecto p : listProyecto) {
				if (p.getId().equals(parte[0])) {
					p.agregarTarea(t);
				}
			}

		}
		return lista;

	}

	/**
	 * Carga todos los proyectos desde el archivo "proyectos.txt" y los transforma
	 * en objetos Proyecto.
	 *
	 * @return lista completa de proyectos cargados
	 * @throws FileNotFoundException si el archivo "proyectos.txt" no se encuentra
	 */
	private ArrayList<Proyecto> creadoraProyectos() throws FileNotFoundException {
		Scanner s = new Scanner(new File("proyectos.txt"));
		ArrayList<Proyecto> lista = new ArrayList<>();

		while (s.hasNextLine()) {
			String linea = s.nextLine();
			String[] parte = linea.split("\\|");
			Proyecto p = new Proyecto(parte[0], parte[1], parte[2]);
			lista.add(p);

		}
		return lista;
	}

	/**
	 * Carga todos los usuarios desde el archivo "usuarios.txt" y los representa
	 * como objetos Usuario.
	 *
	 * @return lista completa de usuarios cargados
	 * @throws FileNotFoundException si el archivo "usuarios.txt" no se encuentra
	 */
	private ArrayList<Usuario> creadoraUsuarios() throws FileNotFoundException {

		Scanner s = new Scanner(new File("usuarios.txt"));
		ArrayList<Usuario> lista = new ArrayList<>();

		while (s.hasNextLine()) {
			String linea = s.nextLine();
			String[] parte = linea.split("\\|");
			Usuario u = new Usuario(parte[0], parte[1], parte[2]);
			lista.add(u);

		}
		return lista;
	}

	/**
	 * Retorna la instancia única del sistema (patrón Singleton).
	 *
	 * @return instancia única de {@link Sistema}
	 */
	public static Sistema getSistema() {
		if (instancia == null) {
			instancia = new Sistema();
		}
		return instancia;
	}

	/**
	 * Verifica si un responsable tiene disponibilidad para una fecha dada, es
	 * decir, si no tiene otra tarea asignada para la misma fecha.
	 *
	 * @param responsable nombre del responsable a verificar
	 * @param fecha       fecha a validar
	 * @param listaTareas lista de todas las tareas existentes
	 * @return true si está disponible, false si ya tiene una tarea asignada ese día
	 */
	public boolean verificarDisponibilidad(String responsable, String fecha, ArrayList<Tarea> listaTareas) {
		for (Tarea t : listaTareas) {
			if (t.getResponsable().equalsIgnoreCase(responsable) && t.getFecha().equals(fecha)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Guarda todas las tareas del sistema en el archivo "tareas.txt" utilizando el
	 * formato separado por barras verticales (|). Notifica si la operación fue
	 * exitosa o si ocurrió un error.
	 */
	public void guardarTareas() {
		try (FileWriter fw = new FileWriter("tareas.txt"); BufferedWriter bw = new BufferedWriter(fw)) {

			for (Tarea t : this.listTarea) {
				String linea = t.getProyecto() + "|" + t.getId() + "|" + t.getTipo() + "|" + t.getDesc() + "|"
						+ t.getEstado() + "|" + t.getResponsable() + "|" + t.getComplejidad() + "|" + t.getFecha();
				bw.write(linea);
				bw.newLine();
			}
			System.out.println("Tareas guardadas exitosamente en tareas.txt.");

		} catch (IOException e) {
			System.out.println("Error al guardar las tareas en el archivo: " + e.getMessage());
		}
	}

	/**
	 * Guarda todos los proyectos del sistema en el archivo "proyectos.txt"
	 * utilizando el formato separado por barras verticales (|). Notifica si la
	 * operación fue exitosa o si ocurrió un error.
	 */
	public void guardarProyectos() {
		try (FileWriter fw = new FileWriter("proyectos.txt"); BufferedWriter bw = new BufferedWriter(fw)) {

			for (Proyecto p : this.listProyecto) {
				String linea = p.getId() + "|" + p.getNombre() + "|" + p.getResponsable();
				bw.write(linea);
				bw.newLine();
			}
			System.out.println("Proyectos guardados exitosamente en proyectos.txt.");

		} catch (IOException e) {
			System.out.println("Error al guardar los proyectos en el archivo: " + e.getMessage());
		}
	}
}
