package Taller3poo;

/**
 * Fábrica de Tareas (Patrón Factory).
 * <p>
 * Esta clase se encarga de crear los objetos de tipo Tarea.
 * Su trabajo es recibir todos los datos en bruto (strings) y decidir qué tipo
 * de tarea crear (Bug, Feature o Documentación) para devolver el objeto listo.
 * </p>
 * @author Matías Collao
 * @author Lucas Riquelme
 * @version 1.0
 */
public class TareaFactory {

	/**
	 * Crea y devuelve una instancia de Tarea según el tipo especificado.
	 * <p>
	 * Recibe todos los datos necesarios y usa el tercer parámetro (el tipo)
	 * para decidir si instancia un {@link tareaBug}, {@link tareaFeature} o {@link tareaDocumentacion}.
	 * </p>
	 * @param string ID del Proyecto.
	 * @param string2 ID de la Tarea.
	 * @param string3 Tipo de Tarea (Bug, Feature, Documentacion).
	 * @param string4 Descripción de la tarea.
	 * @param string5 Estado inicial (ej: Pendiente).
	 * @param string6 Responsable asignado.
	 * @param string7 Nivel de complejidad.
	 * @param string8 Fecha de creación.
	 * @return Un objeto de tipo Tarea (Bug, Feature o Documentación) o null si el tipo no existe.
	 */
	public Tarea crearTarea(String string, String string2, String string3, String string4, String string5,
			String string6, String string7, String string8) {
		
		switch (string3) {
		case "Bug": return new tareaBug(string, string2, string3, string4, string5,string6,string7,string8);
		case "Feature": return new tareaFeature(string, string2, string3, string4, string5,string6,string7,string8);
		case "Documentacion": return new tareaDocumentacion(string, string2, string3, string4, string5,string6,string7,string8);
		default : return null;
		}
	
	
	}
	
}
