package Taller3poo;

import java.util.ArrayList;

/**
 * Estrategia concreta para ordenar tareas por su fecha de creación.
 * <p>
 * Su función es organizar la lista para que las tareas más antiguas aparezcan
 * al principio y las más nuevas al final.
 * </p>
 * @author Matías Collao
 * @author Lucas Riquelme
 * @version 1.0
 */
public class PrioridadFecha implements EstrategiaPriorizacion {

	/**
	 * Ordena la lista de tareas cronológicamente (de la más vieja a la más nueva).
	 * <p>
	 * Compara las fechas de las tareas (que son textos tipo "YYYY-MM-DD") y
	 * las reordena manualmente usando el método de la burbuja.
	 * </p>
	 * @param tareas La lista de tareas que vamos a ordenar.
	 */
	public void ordenar(ArrayList<Tarea> tareas) {
		int n = tareas.size();
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {

				Tarea t1 = tareas.get(j);
				Tarea t2 = tareas.get(j + 1);
				if (t1.getFecha().compareTo(t2.getFecha()) > 0) {
					Tarea temp = t1;
					tareas.set(j, t2);
					tareas.set(j + 1, temp);
				}
			}
		}
	}
}
