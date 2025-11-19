package Taller3poo;

/**
 * Representa una tarea de tipo "Feature" (Nueva Funcionalidad).
 * <p>
 * Son tareas enfocadas en agregar cosas nuevas al proyecto.
 * Dentro del sistema, tienen una prioridad media y su impacto se mide
 * principalmente en la estimación de tiempo (cuánto tardará en hacerse).
 * </p>
 * @author Matías Collao
 * @author Lucas Riquelme
 * @version 1.0
 */
public class tareaFeature extends Tarea {

	/**
	 * Constructor: Crea una nueva tarea de tipo Feature con todos sus datos.
	 * * @param proyecto ID del proyecto al que pertenece.
	 * @param id ID único de la tarea.
	 * @param tipo El tipo de tarea (en este caso "Feature").
	 * @param desc Descripción de qué hay que hacer.
	 * @param estado Estado actual (Pendiente, En Progreso, etc).
	 * @param responsable Usuario asignado.
	 * @param complejidad Dificultad de la tarea.
	 * @param fecha Fecha de creación.
	 */
	public tareaFeature(String proyecto, String id, String tipo, String desc, String estado, String responsable,
			String complejidad, String fecha) {
		super(proyecto, id, tipo, desc, estado, responsable, complejidad, fecha);
		
	}
	
	/**
	 * Método clave del Patrón Visitor.
	 * <p>
	 * Funciona como una "puerta de entrada". Cuando el visitante llega aquí,
	 * esta tarea le dice: "Soy una Feature, así que ejecuta tu lógica para Features".
	 * </p>
	 * @param visitor El objeto que viene a realizar una acción sobre esta tarea.
	 */
	public void aceptar(TareaVisitor visitor) {
		visitor.visit(this);
	}

}
