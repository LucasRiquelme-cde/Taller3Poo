package Taller3poo;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuAdministrador {

	public void iniciarMenu(ArrayList<Proyecto> listProyecto, ArrayList<Tarea> listTarea) {
		System.out.println("Bienvenido administrador, qué desea hacer?");
		do {
			pirntearOpciones();
			int op = Integer.valueOf(escanearDesdeTeclado());
			switch (op) {

			case 1:
				verListaProyectos(listProyecto);
//			case 2: agregarEliminarProyecto(listProyecto);
//			case 3: agregarEliminarTarea(listProyecto, listTarea);
//			case 4: configEstrategia();
//			case 5: generarReporte(); 
			case 6:
				break;

			}

		} while (true);

	}

	private void verListaProyectos(ArrayList<Proyecto> listProyecto) {

		System.out.println(" ");

		for (Proyecto p : listProyecto) {
			System.out.println(p.getNombre() + " Tareas: ");
			ArrayList<Tarea> aux = p.getListaTarea();
			for (Tarea t : aux) {
				System.out.println(t);
			}
			System.out.println(" ");
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
		System.out.println("1) Ver lista completa de proyectos y tareas:");
		System.out.println("2) Agregar o eliminar un proyecto:");
		System.out.println("3) Agregar o eliminar una tarea en un proyecto:");
		System.out.println("4) Asignar prioridades con Strategy:");
		System.out.println("5) Generar reporte de proyectos:");
		System.out.println("6) Salir:");
	}

}
