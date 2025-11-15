package Taller3poo;

import java.util.*;

public class MenuAdministrador {

	public void iniciarMenu(ArrayList<Proyecto> listProyecto, ArrayList<Tarea> listTarea) {
		System.out.println("Bienvenido administrador, qué desea hacer?");
		boolean validacion1= true;
		do {
			pirntearOpciones();
			System.out.print("Ingrese una opcion: ");
			int op = Integer.valueOf(escanearDesdeTeclado());
			if(op<1 || op>6) {
				System.out.println("Opcion invalida");
				System.out.println();
			}
			switch (op) {

			case 1:
				verListaProyectos(listProyecto);
//			case 2: agregarEliminarProyecto(listProyecto);
			case 3: agregarEliminarTarea(listProyecto, listTarea);
//			case 4: configEstrategia();
//			case 5: generarReporte(); 
			case 6:
				System.out.println("Saliendo del menu...");
				validacion1= false;
				break;

			}

		} while (validacion1==true);

	}

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

	private void eliminarTarea(ArrayList<Proyecto> listProyecto, ArrayList<Tarea> listTarea) {
		//pendiente
	}

	private void agregarTarea(ArrayList<Proyecto> listProyecto, ArrayList<Tarea> listTarea) {
		Sistema s= Sistema.getSistema();
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
			System.out.println("ERROR: El colaborador " + responsable + " ya tiene una tarea asignada el " + fecha + ". Tarea no creada.");
			return;
		}
		TareaFactory factory = new TareaFactory();
		Tarea nuevaTarea = factory.crearTarea(idProyecto, nuevoId, tipo, desc, estadoInicial, responsable, complejidad, fecha);

		if (nuevaTarea != null) {
			listTarea.add(nuevaTarea);
			proyectoSeleccionado.agregarTarea(nuevaTarea);
			s.guardarTareas();
			System.out.println("Tarea " + nuevoId + " creada y asignada con exito.");
		} else {
			System.out.println("ERROR: Tipo de tarea invalido. Tarea no creada.");
		}
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
