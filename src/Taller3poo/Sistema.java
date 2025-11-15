package Taller3poo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Sistema {

	private static Sistema instancia;

	public void sistema() throws FileNotFoundException {

		System.out.println("Iniciando programa: ");

		ArrayList<Usuario> listUsuario = creadoraUsuarios();
		ArrayList<Proyecto> listProyecto = creadoraProyectos();
		ArrayList<Tarea> listTarea = creadoraTareas(listProyecto);

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

	private String ingresarUsuario(ArrayList<Usuario> listUsuario) {

		System.out.println("Ingresa usuario: ");

		String usuario = escanearTecldo();
		for (Usuario u : listUsuario) {
			if (u.getUsername().equals(usuario)) {
				System.out.println("Usuario encontrado");
				System.out.println("Ingrese contraseña:");
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

}
