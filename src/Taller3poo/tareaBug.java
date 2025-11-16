package Taller3poo;

public class tareaBug extends Tarea {

	public tareaBug(String proyecto, String id, String tipo, String desc, String estado, String responsable,
			String complejidad, String fecha) {
		super(proyecto, id, tipo, desc, estado, responsable, complejidad, fecha);
	}
	public void aceptar(TareaVisitor visitor) {
		visitor.visit(this);
	}

}
