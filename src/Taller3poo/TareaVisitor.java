package Taller3poo;

public interface TareaVisitor {
	void visit(tareaBug bug);
	void visit(tareaFeature feature);
	void visit(tareaDocumentacion documentacion);
}
