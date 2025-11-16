package Taller3poo;

public class ActivarVisitor implements TareaVisitor {
	public void visit(tareaBug bug) {
		System.out.println("Visitor: El Bug (" + bug.getId() + ") afecta la criticidad del proyecto");
	}

	public void visit(tareaFeature feature) {
		System.out.println("Visitor: El Feature (" + feature.getId() + ") impacta en la estimación del tiempo");
	}

	public void visit(tareaDocumentacion documentacion) {
		System.out.println("Visitor: La Documentacion (" + documentacion.getId()+ ") mejora la calidad del proyecto");
	}

}
