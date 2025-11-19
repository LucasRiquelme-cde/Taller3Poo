package Taller3poo;

/**
 * Clase encargada de realizar las acciones del Patrón Visitor.
 * <p>
 * Este es el visitante real. Su trabajo es recibir una tarea y,
 * dependiendo de si es un Bug, Feature o Documentación, ejecutar
 * la acción correcta (en este caso, mostrar un mensaje específico).
 * </p>
 * @author Matías Collao
 * @author Lucas Riquelme
 * @version 1.0
 */
public class ActivarVisitor implements TareaVisitor {
	
	/**
	 * Define qué hacer cuando se visita un Bug.
	 * <p>
	 * Indica que este tipo de tarea afecta qué tan crítico es el proyecto.
	 * </p>
	 * @param bug La tarea de tipo error (Bug) que estamos procesando.
	 */
	public void visit(tareaBug bug) {
		System.out.println("Visitor: El Bug (" + bug.getId() + ") afecta la criticidad del proyecto");
	}
	
	/**
	 * Define qué hacer cuando visitamos una Feature.
	 * <p>
	 * Indica que agregar funcionalidades impacta en cuánto tiempo tomará el proyecto.
	 * </p>
	 * @param feature La tarea de tipo nueva funcionalidad (Feature).
	 */
	public void visit(tareaFeature feature) {
		System.out.println("Visitor: El Feature (" + feature.getId() + ") impacta en la estimación del tiempo");
	}
	
	/**
	 * Define qué hacer cuando visitamos Documentación.
	 * <p>
	 * Indica que documentar ayuda a mejorar la calidad general del software.
	 * </p>
	 * @param documentacion La tarea de tipo documentación.
	 */
	public void visit(tareaDocumentacion documentacion) {
		System.out.println("Visitor: La Documentacion (" + documentacion.getId()+ ") mejora la calidad del proyecto");
	}

}
