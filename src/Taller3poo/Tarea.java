package Taller3poo;

/**
 * Clase abstracta que representa una tarea genérica dentro del sistema.
 * Contiene atributos comunes a todos los tipos de tareas (Bug, Mejora, Nueva) y
 * define el método abstracto {@link #aceptar(TareaVisitor)} para implementar el
 * patrón Visitor.
 *
 * Cada tarea contiene información sobre: - Proyecto al que pertenece -
 * Identificador único - Tipo de tarea - Descripción - Estado - Responsable
 * asignado - Complejidad - Fecha programada
 */
public abstract class Tarea {

	protected String proyecto, id, tipo, desc, estado, responsable, complejidad, fecha;

	/**
	 * Constructor que inicializa todos los atributos de una tarea.
	 *
	 * @param proyecto    ID del proyecto al que pertenece la tarea
	 * @param id          identificador único de la tarea
	 * @param tipo        tipo de tarea (Bug, Mejora, Nueva, etc.)
	 * @param desc        descripción detallada de la tarea
	 * @param estado      estado actual de la tarea (Pendiente, En Proceso,
	 *                    Terminada, etc.)
	 * @param responsable nombre del responsable asignado
	 * @param complejidad nivel de complejidad de la tarea
	 * @param fecha       fecha asociada a la tarea
	 */
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

	/**
	 * Retorna una representación en texto de la tarea, mostrando sus atributos
	 * principales.
	 *
	 * @return cadena con información resumida de la tarea
	 */
	@Override
	public String toString() {
		return "[ID: " + id + ", Tipo: " + tipo + ", Descripción: " + desc + ", Estado: " + estado + ", Responsable: "
				+ responsable + ", Complejidad: " + complejidad + ", Fecha: " + fecha + "]";
	}

	/** @return el identificador del proyecto al que pertenece esta tarea */
	public String getProyecto() {
		return proyecto;
	}

	/** @param proyecto nuevo proyecto al que pertenece esta tarea */
	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}

	/** @return el tipo de tarea */
	public String getTipo() {
		return tipo;
	}

	/** @param tipo nuevo tipo de tarea */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/** @return la descripción de la tarea */
	public String getDesc() {
		return desc;
	}

	/** @param desc nueva descripción de la tarea */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/** @return nivel de complejidad de la tarea */
	public String getComplejidad() {
		return complejidad;
	}

	/** @param complejidad nuevo nivel de complejidad */
	public void setComplejidad(String complejidad) {
		this.complejidad = complejidad;
	}

	/** @return fecha asociada a la tarea */
	public String getFecha() {
		return fecha;
	}

	/** @param fecha nueva fecha asociada a la tarea */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/** @param id nuevo identificador de la tarea */
	public void setId(String id) {
		this.id = id;
	}

	/** @param responsable nuevo responsable asignado */
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	/** @return estado actual de la tarea */
	public String getEstado() {
		return estado;
	}

	/** @param estado nuevo estado de la tarea */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/** @return identificador único de la tarea */
	public String getId() {
		return id;
	}

	/** @return nombre del responsable asignado */
	public String getResponsable() {
		return responsable;
	}

	/**
	 * Método abstracto del patrón Visitor. Permite que un {@link TareaVisitor}
	 * ejecute operaciones específicas dependiendo del tipo concreto de tarea.
	 *
	 * @param visitor objeto visitante que implementa la lógica correspondiente
	 */
	public abstract void aceptar(TareaVisitor visitor);

}
