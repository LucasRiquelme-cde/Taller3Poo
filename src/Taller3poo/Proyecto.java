package Taller3poo;

import java.util.*;

/**
 * Representa un proyecto real dentro de la empresa.
 * <p>
 * Esta clase funciona como un contenedor: guarda la información básica (ID, nombre, jefe)
 * y mantiene una lista con todas las tareas que pertenecen a este proyecto.
 * </p>
 * @author Matías Collao
 * @author Lucas Riquelme
 * @version 1.0
 */
public class Proyecto {

	private String id, nombre, responsable;
	private ArrayList<Tarea> listaTarea;
	
	/**
	 * Constructor: Crea un nuevo proyecto listo para trabajar.
	 * <p>
	 * Inicializa los datos básicos y crea la lista vacía donde se irán
	 * guardando las tareas.
	 * </p>
	 * @param id El código único del proyecto (ej: PR001).
	 * @param nombre El título del proyecto.
	 * @param responsable El username del usuario que está a cargo.
	 */
	public Proyecto(String id, String nombre, String responsable) {
		this.id = id;
		this.nombre = nombre;
		this.responsable = responsable;
		this.listaTarea = new ArrayList<Tarea>();
	}
	
	/**
	 * Agrega una tarea a la lista interna del proyecto.
	 * @param t La tarea que queremos vincular a este proyecto.
	 */
	public void agregarTarea(Tarea t) {
		this.listaTarea.add(t);
	}

	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", nombre=" + nombre + ", responsable=" + responsable + ", listaTarea="+ listaTarea + "]";
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Tarea> getListaTarea() {
		return listaTarea;
	}
	public String getResponsable() {
		return responsable;
	}
	
	/**
	 * Genera un texto especial para el archivo de reportes.
	 * <p>
	 * Junta toda la información del proyecto y concatena la información
	 * de todas sus tareas en una sola cadena de texto larga, lista para
	 * guardarse en el archivo 'reporte.txt'.
	 * </p>
	 * @return El String formateado con el resumen completo.
	 */
	public String reporte() {
		String x = "";
		x = x + "Proyecto: " + this.nombre + ", ID: " + this.id + ", Responsable: " + this.responsable + "Tareas: ";
		
		for (Tarea t : this.listaTarea) {
			x = x + t.toString();
		}
		
		return x;
	}
	
	 

}
