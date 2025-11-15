package Taller3poo;

import java.util.ArrayList;

public class Proyecto {

	private String id, nombre, responsable;
	private ArrayList<Tarea> listaTarea;

	public Proyecto(String id, String nombre, String responsable) {
		this.id = id;
		this.nombre = nombre;
		this.responsable = responsable;
		this.listaTarea = new ArrayList<Tarea>();
	}

	public void agregarTarea(Tarea t) {
		this.listaTarea.add(t);
	}

	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", nombre=" + nombre + ", responsable=" + responsable + ", listaTarea="
				+ listaTarea + "]";
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

}
