package Taller3poo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Clase que controla todo lo que puede hacer el Administrador.
 * <p>
 * Es el centro de mando. Desde aquí se gestionan los proyectos y tareas,
 * se generan reportes y se decide cómo priorizar el trabajo (usando Patrón Strategy).
 * </p>
 * @author Matías Collao
 * @author Lucas Riquelme
 * @version 1.0
 */
public class MenuAdministrador {
	
	/**
	 * Inicia el bucle principal del menú del administrador.
	 * <p>
	 * Mantiene al usuario dentro del sistema mostrando las opciones una y otra vez
	 * hasta que decida salir (Opción 6).
	 * </p>
	 * @param listProyecto La lista de todos los proyectos actuales.
	 * @param listTarea La lista global de todas las tareas.
	 * @throws IOException Si ocurre un error al guardar o leer archivos.
	 */
	public void iniciarMenu(ArrayList<Proyecto> listProyecto, ArrayList<Tarea> listTarea) throws IOException {
		System.out.println("\nBienvenido administrador, qué desea hacer?");
		boolean validacion1 = true;
		do {
			pirntearOpciones();
			System.out.print("Ingrese una opcion: ");
			int op = Integer.valueOf(escanearDesdeTeclado());
			if (op < 1 || op > 6) {
				System.out.println("Opcion invalida");
				System.out.println();
			}
			switch (op) {

			case 1:
				verListaProyectos(listProyecto);
				break;
			case 2:
				agregarEliminarProyecto(listProyecto, listTarea);
				break;
			case 3:
				agregarEliminarTarea(listProyecto, listTarea);
				break;
			case 4:
				configEstrategia(listTarea);
				break;
			case 5:
				generarReporte(listProyecto);
				break;
			case 6:
				System.out.println("Saliendo del menu...");
				validacion1 = false;
				break;

			}

		} while (validacion1 == true);

	}
	
	/**
	 * Implementación del Patrón Strategy.
	 * <p>
	 * Permite elegir "al vuelo" cómo queremos ordenar las tareas (por fecha,
	 * impacto o complejidad) y aplica ese orden inmediatamente a la lista.
	 * </p>
	 * @param listTarea La lista de tareas que vamos a reordenar.
	 */
	private void configEstrategia(ArrayList<Tarea> listTarea) {
		System.out.println("\n--- Asignar Prioridades (Strategy) ---");
		System.out.println("Selecciona la estrategia de priorización:");
		System.out.println("1) Fecha de Creación (Más antiguas primero)");
		System.out.println("2) Impacto (Bug > Feature > Doc)");
		System.out.println("3) Complejidad (Alta > Media > Baja)");
		System.out.print("Ingrese opción: ");

		String op = escanearDesdeTeclado();
		EstrategiaPriorizacion estrategiaSeleccionada = null;
		switch (op) {
		case "1":
			estrategiaSeleccionada = new PrioridadFecha();
			System.out.println("Estrategia: Prioridad por Fecha.");
			break;
		case "2":
			estrategiaSeleccionada = new PrioridadImpacto();
			System.out.println("Estrategia: Prioridad por Impacto.");
			break;
		case "3":
			estrategiaSeleccionada = new PrioridadComplejidad();
			System.out.println("Estrategia: Prioridad por Complejidad.");
			break;
		default:
			System.out.println("Opción inválida. No se cambió la estrategia.");
			return;
		}
		estrategiaSeleccionada.ordenar(listTarea);
		System.out.println("\n--- Lista de Tareas Reordenada ---");
		for (Tarea t : listTarea) {
			System.out.println(t);
		}
		System.out.println("----------------------------------");

	}
	
	/**
	 * Crea un archivo de texto (reporte.txt) con el estado actual de todo.
	 * <p>
	 * Recorre cada proyecto y escribe sus detalles y tareas en el archivo.
	 * </p>
	 * @param listProyecto Lista de proyectos a incluir en el reporte.
	 * @throws IOException Si falla la escritura del archivo.
	 */
	private void generarReporte(ArrayList<Proyecto> listProyecto) throws IOException {
		System.out.println(" ");
		System.out.println("Generando reporte...");

		try (FileWriter writer = new FileWriter("reporte.txt", false)) {

			for (Proyecto p : listProyecto) {

				writer.write(p.reporte() + "\n");

			}

			System.out.println("Reporte generado correctamente");

		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}

	}
	
	/**
	 * Submenú simple para gestionar Proyectos (Crear o Borrar).
	 */
	private void agregarEliminarProyecto(ArrayList<Proyecto> listProyecto, ArrayList<Tarea> listTarea) {
		System.out.println();
		System.out.println("--- Gestión de Proyectos ---");
		System.out.println("1) Agregar Proyecto");
		System.out.println("2) Eliminar Proyecto");
		System.out.print("Ingrese opción: ");
		String op = escanearDesdeTeclado();
		if (op.equals("1")) {
			agregarProyecto(listProyecto);
		} else if (op.equals("2")) {
			eliminarProyecto(listProyecto, listTarea);
		} else {
			System.out.println("Opcion invalida.");
		}
	}
	
	/**
	 * Elimina un proyecto y hace limpieza.
	 * <p>
	 * Borra el proyecto y, muy importante, también borra todas las tareas
	 * asociadas a él para no dejar datos huérfanos.
	 * </p>
	 */
	private void eliminarProyecto(ArrayList<Proyecto> listProyecto, ArrayList<Tarea> listTarea) {
		Sistema s = Sistema.getSistema();
		System.out.println();
		System.out.println("--- Proyectos Actuales ---");
		for (Proyecto p : listProyecto) {
			System.out.println(p.getId() + " | " + p.getNombre());
		}

		System.out.print("Ingrese el ID del proyecto a eliminar (ej: PR001): ");
		String idEliminar = escanearDesdeTeclado();
		Proyecto proyectoEliminar = null;
		for (Proyecto p : listProyecto) {
			if (p.getId().equals(idEliminar)) {
				proyectoEliminar = p;
				break;
			}
		}

		if (proyectoEliminar == null) {
			System.out.println("ERROR: Proyecto con ID " + idEliminar + " no encontrado.");
			return;
		}

		listProyecto.remove(proyectoEliminar);
		Iterator<Tarea> iter = listTarea.iterator();
		int tareasEliminadas = 0;
		while (iter.hasNext()) {
			Tarea t = iter.next();
			if (t.getProyecto().equals(idEliminar)) {
				iter.remove();
				tareasEliminadas++;
			}
		}

		s.guardarProyectos();
		s.guardarTareas();
		System.out.println("Proyecto " + idEliminar + " eliminado.");
		System.out.println(tareasEliminadas + " tareas asociadas fueron eliminadas.");
		System.out.println();
	}
	
	/**
	 * Pide los datos y crea un nuevo proyecto en el sistema.
	 */
	private void agregarProyecto(ArrayList<Proyecto> listProyecto) {
		Sistema s = Sistema.getSistema();
		System.out.print("Ingrese Nombre del nuevo proyecto: ");
		String nombre = escanearDesdeTeclado();
		System.out.print("Ingrese Responsable del proyecto (Username): ");
		String responsable = escanearDesdeTeclado();
		String nuevoId = "PR" + String.format("%03d", listProyecto.size() + 1);
		System.out.println("ID Proyecto a crear: " + nuevoId);
		Proyecto nuevoProyecto = new Proyecto(nuevoId, nombre, responsable);
		listProyecto.add(nuevoProyecto);
		s.guardarProyectos();
		System.out.println("Proyecto " + nuevoId + " (" + nombre + ") creado exitosamente.");
		System.out.println();

	}
	
	/**
	 * Submenú simple para gestionar Tareas (Crear o Borrar).
	 */
	private void agregarEliminarTarea(ArrayList<Proyecto> listProyecto, ArrayList<Tarea> listTarea) {
		System.out.println();
		System.out.println("--- Gestión de Tareas ---");
		System.out.println("1) Agregar Tarea");
		System.out.println("2) Eliminar Tarea");
		System.out.println("Ingrese opción:");
		String op = escanearDesdeTeclado();

		if (op.equals("1")) {
			agregarTarea(listProyecto, listTarea);
		} else if (op.equals("2")) {
			eliminarTarea(listProyecto, listTarea);
		} else {
			System.out.println("Opcion invalida.");
		}

	}
	
	/**
	 * Borra una tarea específica.
	 * <p>
	 * La busca por ID y la elimina de dos lugares: la lista general y la lista
	 * interna del proyecto al que pertenecía.
	 * </p>
	 */
	private void eliminarTarea(ArrayList<Proyecto> listProyecto, ArrayList<Tarea> listTarea) {
		Sistema s = Sistema.getSistema();
		System.out.println();
		System.out.println("--- Tareas Actuales ---");
		verListaProyectos(listProyecto);
		System.out.print("Ingrese el ID de la tarea a eliminar (ej: T001): ");
		String idEliminar = escanearDesdeTeclado();
		Tarea tareaEliminar = null;
		for (Tarea t : listTarea) {
			if (t.getId().equals(idEliminar)) {
				tareaEliminar = t;
				break;
			}
		}

		if (tareaEliminar == null) {
			System.out.println("ERROR: Tarea con ID " + idEliminar + " no encontrada.");
			System.out.println();
			return;
		}

		Proyecto proyectoPadre = null;
		for (Proyecto p : listProyecto) {
			if (p.getId().equals(tareaEliminar.getProyecto())) {
				proyectoPadre = p;
				break;
			}
		}

		if (proyectoPadre != null) {
			proyectoPadre.getListaTarea().remove(tareaEliminar);
		}

		listTarea.remove(tareaEliminar);
		s.guardarTareas();

		System.out.println("Tarea " + idEliminar + " eliminada exitosamente.");
	}
	
	/**
	 * Crea una tarea nueva.
	 * <p>
	 * Este método hace tres cosas importantes:
	 * 1. Valida que el usuario no esté ocupado ese día (Requisito clave).
	 * 2. Usa el {@link TareaFactory} para crear el objeto correcto.
	 * 3. Guarda todo en el archivo de texto.
	 * </p>
	 */
	private void agregarTarea(ArrayList<Proyecto> listProyecto, ArrayList<Tarea> listTarea) {
		Sistema s = Sistema.getSistema();
		System.out.println("Proyectos disponibles (ID | Nombre):");
		for (Proyecto p : listProyecto) {
			System.out.println(p.getId() + " | " + p.getNombre());
		}
		System.out.print("Ingrese ID del proyecto para la tarea: ");
		String idProyecto = escanearDesdeTeclado();
		Proyecto proyectoSeleccionado = null;
		for (Proyecto p : listProyecto) {
			if (p.getId().equals(idProyecto)) {
				proyectoSeleccionado = p;
				break;
			}
		}

		if (proyectoSeleccionado == null) {
			System.out.println("ERROR: Proyecto con ID " + idProyecto + " no encontrado.");
			return;
		}

		String nuevoId = "T" + String.format("%03d", listTarea.size() + 1);
		System.out.println("ID Tarea a crear: " + nuevoId);

		System.out.print("Tipo de tarea (Bug, Feature, Documentacion): ");
		String tipo = escanearDesdeTeclado();

		System.out.print("Descripcion: ");
		String desc = escanearDesdeTeclado();

		String estadoInicial = "Pendiente";

		System.out.print("Responsable (Username): ");
		String responsable = escanearDesdeTeclado();

		System.out.print("Complejidad (Baja, Media, Alta): ");
		String complejidad = escanearDesdeTeclado();

		System.out.print("Fecha de creacion (YYYY-MM-DD): ");
		String fecha = escanearDesdeTeclado();

		boolean disponible = s.verificarDisponibilidad(responsable, fecha, listTarea);

		if (!disponible) {
			System.out.println("ERROR: El colaborador " + responsable + " ya tiene una tarea asignada el " + fecha
					+ ". Tarea no creada.");
			return;
		}
		TareaFactory factory = new TareaFactory();
		Tarea nuevaTarea = factory.crearTarea(idProyecto, nuevoId, tipo, desc, estadoInicial, responsable, complejidad,
				fecha);

		if (nuevaTarea != null) {
			listTarea.add(nuevaTarea);
			proyectoSeleccionado.agregarTarea(nuevaTarea);
			s.guardarTareas();
			System.out.println("Tarea " + nuevoId + " creada y asignada con exito.");
		} else {
			System.out.println("ERROR: Tipo de tarea invalido. Tarea no creada.");
		}
	}
	
	/**
	 * Muestra en pantalla todos los proyectos y sus tareas asociadas.
	 */
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
	}
	
	/**
	 * Método auxiliar para leer texto del teclado de forma segura.
	 * @return El texto ingresado por el usuario.
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
	 * Imprime las opciones del menú en consola.
	 */
	private void pirntearOpciones() {
		System.out.println();
		System.out.println("1) Ver lista completa de proyectos y tareas:");
		System.out.println("2) Agregar o eliminar un proyecto:");
		System.out.println("3) Agregar o eliminar una tarea en un proyecto:");
		System.out.println("4) Asignar prioridades con Strategy:");
		System.out.println("5) Generar reporte de proyectos:");
		System.out.println("6) Salir:");
	}

}
