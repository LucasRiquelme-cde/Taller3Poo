package Taller3poo;

public abstract class Tarea {

	protected String proyecto, id, tipo, desc, estado, responsable, complejidad, fecha;

	public Tarea(String proyecto, String id, String tipo, String desc, String estado, String responsable,
			String complejidad, String fecha) {
		this.proyecto = proyecto;
		this.id = id;
		this.tipo = tipo;
		this.desc = desc;
		this.estado = estado;
		this.responsable = responsable;
		this.complejidad = complejidad;
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Tarea [proyecto=" + proyecto + ", id=" + id + ", tipo=" + tipo + ", desc=" + desc + ", estado=" + estado
				+ ", responsable=" + responsable + ", complejidad=" + complejidad + ", fecha=" + fecha + "]";
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getId() {
		return id;
	}

	public String getResponsable() {
		return responsable;
	}

}
