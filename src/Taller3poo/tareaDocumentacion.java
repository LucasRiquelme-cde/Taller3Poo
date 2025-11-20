package Taller3poo;

/**
 * Representa una tarea de documentación dentro de un proyecto.
 * <p>
 * Esta clase extiende a {@link Tarea} y define el comportamiento específico de una tarea
 * cuyo propósito es generar, revisar o actualizar documentación del proyecto.
 * Dentro del sistema, suelen tener una prioridad baja y su impacto principal
 * es la mejora de la calidad del software.
 * </p>
 * @author Matías Collao
 * @author Lucas Riquelme
 * @version 1.0
 */
public class tareaDocumentacion extends Tarea {

	/**
	 * Constructor: Crea una nueva tarea de tipo Documentación.
	 * <p>
	 * Inicializa la tarea con todos sus atributos específicos, heredando la estructura
	 * base de la clase padre {@link Tarea}.
	 * </p>
	 * @param proyecto    Nombre o ID del proyecto al que pertenece la tarea.
	 * @param id          Identificador único de la tarea.
	 * @param tipo        Tipo de tarea (en este caso, "Documentacion").
	 * @param desc        Descripción detallada de la tarea.
	 * @param estado      Estado actual de la tarea (ej. "Pendiente", "En progreso").
	 * @param responsable Persona encargada de realizar la tarea.
	 * @param complejidad Nivel de complejidad asignado a la tarea.
	 * @param fecha       Fecha de creación o asignación de la tarea.
	 */
	public tareaDocumentacion(String proyecto, String id, String tipo, String desc, String estado, String responsable,
			String complejidad, String fecha) {
		super(proyecto, id, tipo, desc, estado, responsable, complejidad, fecha);
	}

	/**
	 * Método clave del Patrón Visitor.
	 * <p>
	 * Permite que un objeto visitante ({@link TareaVisitor}) ejecute operaciones
	 * sobre esta instancia. Al llamar a este método, se delega la ejecución
	 * al método `visit(tareaDocumentacion)` del visitante.
	 * </p>
	 * @param visitor El objeto visitante que realizará la acción (ej. análisis de impacto).
	 */
	public void aceptar(TareaVisitor visitor) {
		visitor.visit(this);
	}

}
