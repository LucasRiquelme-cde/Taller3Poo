package Taller3poo;

import java.util.ArrayList;



public class Sistema {
	
	private static Sistema instancia;
	

	public void sistema() {

		System.out.println("Iniciando programa: ");

		ArrayList<Usuario> listUsuario = creadoraUsuarios();
		ArrayList<Proyecto> listProyecto = creadoraProyectos();
		ArrayList<Tarea> listTarea = creadoraTareas();

		System.out.println("Ingrese Usuario: ");
		
		String opcion = ingresarUsuario();
		
		if (opcion.equals("Administrador")) {
			MenuAdministrador m = new MenuAdministrador();
			m.iniciarMenu();
			
		} else {
			MenuUsuario me = new MenuUsuario();
			
			
		}
		
		
		/*
		if (ingrsarUsuario(listUsuario)) {
			
			if (ingresarContraseña(listUsuario)) {
				
				
				
				
			} else {
				System.out.println("Contraseña incorrecta: ");
			}
		} else {
			System.out.println("No se encuentra Usuario");
		}
		*/
	}
	
	public static Sistema getSistema() {
		if (instancia == null) {
			instancia = new Sistema();
		}
		return instancia;
	}

}
