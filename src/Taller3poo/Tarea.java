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
		return "[ID: " + id + ", Tipo: " + tipo + ", Descripción: " + desc + ", Estado: " + estado
				+ ", Responsable: " + responsable + ", Complejidad: " + complejidad + ", Fecha: " + fecha + "]";
	}

	public String getProyecto() {
		return proyecto;
	}

	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getComplejidad() {
		return complejidad;
	}

	public void setComplejidad(String complejidad) {
		this.complejidad = complejidad;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
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
