//MatíasCollao/22.060.152-8/ICCI//LucasRiquelme/21.943.208-9/ICCI
package Taller3poo;

import java.io.*;
/**
 * Clase principal con la que arranca la aplicación.
 * <p>
 * Aquí es donde empieza. Su función es llamar al Sistema para que
 * cargue los datos y muestre el menú.
 * </p>
 * * @author Matías Collao
 * @author Lucas Riquelme
 * @version 1.0
 */
public class App {
	/**
	 * Método main del programa.
	 * <p>
	 * Oobtiene la instancia única del {@link Sistema} y
	 * lo ejecuta.
	 * </p>.
	 * @throws tiene IOException por si falla la lectura de los archivos al iniciar.
	 */
	public static void main(String[] args) throws IOException {
		Sistema s = Sistema.getSistema();
		s.sistema();
	}
}
