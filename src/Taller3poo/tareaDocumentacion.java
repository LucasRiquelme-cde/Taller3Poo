package Taller3poo;

public class tareaDocumentacion extends Tarea {

	/**
	 * Representa una tarea de documentación dentro de un proyecto. Esta clase
	 * extiende a {@link Tarea} y define el comportamiento específico de una tarea
	 * cuyo propósito es generar, revisar o actualizar documentación del proyecto.
	 *
	 * <p>
	 * Incluye información como el proyecto asociado, el identificador, el tipo de
	 * tarea, su descripción, estado actual, responsable asignado, nivel de
	 * complejidad y fecha correspondiente.
	 * </p>
	 *
	 * <p>
	 * Implementa el método {@code aceptar} para permitir la aplicación del patrón
	 * Visitor, delegando la operación al {@link TareaVisitor} que gestione este
	 * tipo de tarea.
	 * </p>
	 *
	 * @param proyecto    Nombre del proyecto al que pertenece la tarea.
	 * @param id          Identificador único de la tarea.
	 * @param tipo        Tipo de tarea, en este caso relacionada a documentación.
	 * @param desc        Descripción detallada de la tarea.
	 * @param estado      Estado actual de la tarea (ej. "Pendiente", "En
	 *                    progreso").
	 * @param responsable Persona encargada de realizar la tarea.
	 * @param complejidad Nivel de complejidad asignado a la tarea.
	 * @param fecha       Fecha de creación o asignación de la tarea.
	 */
	public tareaDocumentacion(String proyecto, String id, String tipo, String desc, String estado, String responsable,
			String complejidad, String fecha) {
		super(proyecto, id, tipo, desc, estado, responsable, complejidad, fecha);
	}

	public void aceptar(TareaVisitor visitor) {
		visitor.visit(this);
	}

}
