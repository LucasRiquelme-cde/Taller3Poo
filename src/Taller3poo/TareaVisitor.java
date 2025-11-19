package Taller3poo;

/**
 * Interfaz clave para el Patrón Visitor.
 * <p>
 * Define las reglas del juego para cualquier "Visitante". Si quieres crear una clase
 * que recorra tareas y haga cosas distintas según el tipo (como mostrar mensajes de impacto),
 * debes implementar esta interfaz y definir qué hacer con cada uno de los tres tipos de tarea.
 * </p>
 * @author Matías Collao
 * @author Lucas Riquelme
 * @version 1.0
 */
public interface TareaVisitor {
	
	/**
	 * Define la acción a realizar cuando el visitante se encuentra con un Bug.
	 * @param bug La tarea de tipo Bug que estamos visitando.
	 */
	void visit(tareaBug bug);
	
	/**
	 * Define la acción a realizar cuando el visitante se encuentra con una Feature.
	 * @param feature La tarea de tipo Feature que estamos visitando.
	 */
	void visit(tareaFeature feature);
	
	/**
	 * Define la acción a realizar cuando el visitante se encuentra con Documentación.
	 * @param documentacion La tarea de tipo Documentación que estamos visitando.
	 */
	void visit(tareaDocumentacion documentacion);
}
