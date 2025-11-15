package Taller3poo;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuUsuario {

	public void iniciarMenu(ArrayList<Proyecto> listProyecto, ArrayList<Tarea> listTarea, String username) {

		System.out.println("Bienvenido colaborador, qué deseas hacer?");

		do {
			pirntearOpciones();
			int op = Integer.valueOf(escanearDesdeTeclado());

			switch (op) {

			case 1:
				verListaProyectos(listProyecto);
			case 2:
				verTareasAsignadas(username, listTarea);
			case 3:
				actualizarEstadoDeTarea(listTarea);
//			case 4: aplicarVisitorEnTareas();
			case 5:
				break;
			}

		} while (true);

	}

	private void verTareasAsignadas(String username, ArrayList<Tarea> listTarea) {

		for (Tarea t : listTarea) {
			if (t.getResponsable().equals(username)) {
				System.out.println(t);
			}
		}
		System.out.println(" ");
	}

	private void actualizarEstadoDeTarea(ArrayList<Tarea> listTarea) {
		System.out.println("Qué tarea desea actualizar su estado? (ID): ");
		String tarea = escanearDesdeTeclado();

		for (Tarea t : listTarea) {
			if (t.getId().equals(tarea)) {

				System.out.println("Estado actual: " + t.getEstado() + "\n");
				System.out.println("Ingrese estado: \n1.Pendiente\n2.En Progreso\n3.Completada");
				int op = Integer.valueOf(escanearDesdeTeclado());
				switch (op) {
				case 1:
					t.setEstado("Pendiente");
				case 2:
					t.setEstado("En Progreso");
				case 3:
					t.setEstado("Completada");

				}
			}
		}
		System.out.println(" ");

	}

	private void verListaProyectos(ArrayList<Proyecto> listProyecto) {
		System.out.println(" ");
		System.out.println("Proyectos: \n");
		for (Proyecto p : listProyecto) {
			System.out.println("-" + p.getNombre());
		}
		System.out.println(" ");

	}

	private String escanearDesdeTeclado() {
		Scanner s = new Scanner(System.in);
		String a = "";
		try {
			a = s.nextLine();
		} catch (Exception e) {
			System.out.println("Ingreso no adecuado");
		}
		return a;
	}

	private void pirntearOpciones() {
		System.out.println("1) Ver proyectos disponibles:");
		System.out.println("2) Ver tareas asignadas:");
		System.out.println("3) Actualizar estado de una tarea:");
		System.out.println("4) Aplicar Visitor sobre tareas:");
		System.out.println("5) Salir:");

	}

}
