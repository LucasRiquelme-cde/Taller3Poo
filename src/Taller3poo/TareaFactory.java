package Taller3poo;

public class TareaFactory {

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
