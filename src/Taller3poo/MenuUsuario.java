package Taller3poo;

import java.util.*;

/**
 * Clase que maneja todo lo que puede hacer un Colaborador.
 * <p>
 * Aquí el usuario ve sus tareas, actualiza en qué está trabajando y
 * puede consultar el impacto de sus asignaciones usando el Patrón Visitor.
 * </p>
 * @author Matías Collao
 * @author Lucas Riquelme
 * @version 1.0
 */
public class MenuUsuario {

	/**
	 * Inicia el menú principal para el colaborador.
	 * <p>
	 * Muestra las opciones disponibles y mantiene el programa corriendo
	 * hasta que el usuario decida salir.
	 * </p>
	 * @param listProyecto La lista de proyectos para consultar.
	 * @param listTarea La lista de tareas para filtrar las propias.
	 * @param username El nombre del usuario que inició sesión (para saber qué tareas son suyas).
	 */
	public void iniciarMenu(ArrayList<Proyecto> listProyecto, ArrayList<Tarea> listTarea, String username) {
		boolean validacion = true;
		do {
			pirntearOpciones();
			int op = Integer.valueOf(escanearDesdeTeclado());

			switch (op) {

			case 1:
				verListaProyectos(listProyecto);
				break;
			case 2:
				verTareasAsignadas(username, listTarea);
				break;
			case 3:
				actualizarEstadoDeTarea(listTarea);
				break;
			case 4:
				aplicarVisitorEnTareas(listTarea);
			case 5:
				validacion = false;
				break;
			}

		} while (validacion == true);

	}
	/**
	 * Implementación del Patrón Visitor.
	 * <p>
	 * Permite seleccionar una tarea específica y "visitarla" para ver
	 * qué efecto tiene en el proyecto (si afecta la criticidad, tiempo o calidad).
	 * </p>
	 * @param listTarea Lista de tareas donde buscaremos la indicada.
	 */
	private void aplicarVisitorEnTareas(ArrayList<Tarea> listTarea) {
		System.out.println("Tus tareas actuales:");

		int cont = 0;
		for (Tarea t : listTarea) {
			System.out.println(cont+1+") " + t);
			cont++;
		}

		if (cont == 0) {
			System.out.println("(No tienes tareas asignadas)");
			return;
		}

		System.out.print("Ingrese el ID de la tarea para ver su impacto: ");
		String idTarea = escanearDesdeTeclado();

		Tarea tareaSeleccionada = null;
		for (Tarea t : listTarea) {
			if (t.getId().equals(idTarea)) {
				tareaSeleccionada = t;
				break;
			}
		}

		if (tareaSeleccionada == null) {
			System.out.println("ERROR: Tarea no encontrada.");
			return;
		}

		TareaVisitor visitor = new ActivarVisitor();

		tareaSeleccionada.aceptar(visitor);
	}
	/**
	 * Muestra solo las tareas que pertenecen al usuario conectado.
	 * <p>
	 * Filtra la lista global comparando el responsable con el username actual.
	 * </p>
	 */
	private void verTareasAsignadas(String username, ArrayList<Tarea> listTarea) {

		for (Tarea t : listTarea) {
			if (t.getResponsable().equals(username)) {
				System.out.println(t);
			}
		}
		System.out.println(" ");
	}
	
	/**
	 * Permite cambiar el estado de una tarea (ej. de "Pendiente" a "Completada").
	 * <p>
	 * El usuario elige la tarea por ID y selecciona el nuevo estado de una lista.
	 * </p>
	 */
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
					break;

				case 2:
					t.setEstado("En Progreso");
					break;

				case 3:
					t.setEstado("Completada");
					break;

				}
			}
		}
		System.out.println(" ");

	}
	
	/**
	 * Muestra todos los proyectos existentes en el sistema.
	 */
	private void verListaProyectos(ArrayList<Proyecto> listProyecto) {
		System.out.println(" ");
		System.out.println("Proyectos: \n");
		for (Proyecto p : listProyecto) {
			System.out.println("-" + p.getNombre());
		}
		System.out.println(" ");

	}
	
	/**
	 * Lee la entrada del teclado controlando posibles errores.
	 */
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
	
	/**
	 * Imprime el menú de opciones en la consola.
	 */
	private void pirntearOpciones() {
		System.out.println("\nBienvenido colaborador, qué deseas hacer?");
		System.out.println("1) Ver proyectos disponibles:");
		System.out.println("2) Ver tareas asignadas:");
		System.out.println("3) Actualizar estado de una tarea:");
		System.out.println("4) Aplicar Visitor sobre tareas:");
		System.out.println("5) Salir:");

	}

}
