package Taller3poo;

import java.util.*;
/**
 * Estrategia concreta para ordenar tareas según su nivel de dificultad.
 * <p>
 * Esta clase implementa la lógica para que las tareas más complejas ("Alta")
 * aparezcan primero en la lista, seguidas de "Media" y luego "Baja".
 * Utiliza un algoritmo de ordenamiento manual (Burbuja).
 * </p>
 * @author Matías Collao
 * @author Lucas Riquelme
 * @version 1.0
 */
public class PrioridadComplejidad implements EstrategiaPriorizacion {

	/**
	 * Ordena la lista de tareas por complejidad de mayor a menor.
	 * <p>
	 * Recorre la lista comparando elementos adyacentes e intercambiándolos
	 * si no están en el orden correcto (Algoritmo Bubble Sort).
	 * </p>
	 * @param tareas La lista de tareas a ordenar.
	 */
	public void ordenar(ArrayList<Tarea> tareas) {
		int n = tareas.size();
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				Tarea t1 = tareas.get(j);
				Tarea t2 = tareas.get(j + 1);
				int complejidadT1 = getValorComplejidad(t1);
				int complejidadT2 = getValorComplejidad(t2);

				if (complejidadT1 > complejidadT2) {
					Tarea temp = t1;
					tareas.set(j, t2);
					tareas.set(j + 1, temp);
				}
			}
		}
	}
	
	/**
	 * Convierte la complejidad (texto) en un valor numérico para comparar.
	 * <p>
	 * Asigna:
	 * 1 -> Alta (Mayor prioridad)
	 * 2 -> Media
	 * 3 -> Baja (Menor prioridad)
	 * </p>
	 * @param t La tarea cuya complejidad queremos evaluar.
	 * @return Un número entero que representa el nivel de prioridad.
	 */
	private int getValorComplejidad(Tarea t) {

		switch (t.getTipo()) {
		case "Alta":
			return 1;
		case "Media":
			return 2;
		case "Baja":
			return 3;
		default:
			return 4;

		}
	}

}
