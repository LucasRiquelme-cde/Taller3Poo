package Taller3poo;

public class tareaDocumentacion extends Tarea {

	public tareaDocumentacion(String proyecto, String id, String tipo, String desc, String estado, String responsable,
			String complejidad, String fecha) {
		super(proyecto, id, tipo, desc, estado, responsable, complejidad, fecha);
	}
	public void aceptar(TareaVisitor visitor) {
		visitor.visit(this);
	}

}
