package Taller3poo;

/**
 * Representa una tarea de tipo "Bug" dentro del sistema. Extiende la clase
 * {@link Tarea} y forma parte del patrón Visitor, permitiendo que un
 * {@link TareaVisitor} realice operaciones específicas sobre este tipo de
 * tarea.
 */
public class tareaBug extends Tarea {

	/**
	 * Crea una nueva tarea de tipo Bug.
	 *
	 * @param proyecto    ID del proyecto al que pertenece la tarea
	 * @param id          identificador único de la tarea
	 * @param tipo        tipo de tarea (en este caso, "Bug")
	 * @param desc        descripción de la tarea
	 * @param estado      estado actual de la tarea
	 * @param responsable nombre del responsable asignado
	 * @param complejidad nivel de complejidad de la tarea
	 * @param fecha       fecha programada para la tarea
	 */
	public tareaBug(String proyecto, String id, String tipo, String desc, String estado, String responsable,
			String complejidad, String fecha) {
		super(proyecto, id, tipo, desc, estado, responsable, complejidad, fecha);
	}

	/**
	 * Acepta un visitante según el patrón Visitor, permitiendo que este ejecute una
	 * operación específica sobre esta tarea Bug.
	 *
	 * @param visitor objeto que implementa {@link TareaVisitor}
	 */
	public void aceptar(TareaVisitor visitor) {
		visitor.visit(this);
	}

}
