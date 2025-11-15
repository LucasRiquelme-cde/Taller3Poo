package Taller3poo;

import java.io.*;
import java.util.*;

public class Sistema {

private static Sistema instancia;
	private ArrayList<Usuario> listUsuario;
	private ArrayList<Proyecto> listProyecto;
	private ArrayList<Tarea> listTarea;


	public void sistema() throws FileNotFoundException {
		
		System.out.println("Iniciando programa: ");
		this.listUsuario = creadoraUsuarios();
		this.listProyecto = creadoraProyectos();
		this.listTarea = creadoraTareas(listProyecto);

		for (int i = 0; i < listUsuario.size(); i++) {
			System.out.println(listUsuario.get(i));
		}

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
	
	public ArrayList<Tarea> getListTarea() {
		return listTarea;
	}
	
	public ArrayList<Usuario> getListUsuario() {
		return listUsuario;
	}

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

	public static Sistema getSistema() {
		if (instancia == null) {
			instancia = new Sistema();
		}
		return instancia;
	}
	public boolean verificarDisponibilidad(String responsable, String fecha, ArrayList<Tarea> listaTareas) {
		for (Tarea t : listaTareas) {
			if (t.getResponsable().equalsIgnoreCase(responsable) && t.getFecha().equals(fecha)) {
				return false;
			}
		}
		return true;
	}
	public void guardarTareas() {
		try (FileWriter fw = new FileWriter("tareas.txt");
			 BufferedWriter bw = new BufferedWriter(fw)) {
			
			for (Tarea t : this.listTarea) {
				String linea = t.getProyecto() +"|" + t.getId()+"|" + t.getTipo()+"|" + t.getDesc()+"|" + t.getEstado()+"|" +t.getResponsable()+ "|"+ t.getComplejidad()+ "|" +t.getFecha();
				bw.write(linea);
				bw.newLine();
			}
			System.out.println("Tareas guardadas exitosamente en tareas.txt.");
			
		} catch (IOException e) {
			System.out.println("Error al guardar las tareas en el archivo: " + e.getMessage());
		}
	}
	public ArrayList<Proyecto> getListProyecto() {
		return listProyecto;
	}
	
	public void guardarProyectos() {
		try (FileWriter fw = new FileWriter("proyectos.txt");
			 BufferedWriter bw = new BufferedWriter(fw)) {
			
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

