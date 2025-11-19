package Taller3poo;

import java.util.*;

/**
 * Estrategia concreta para ordenar tareas según su impacto en el proyecto.
 * <p>
 * Esta clase define que lo más urgente son los errores (Bugs), seguidos de las
 * nuevas funcionalidades (Features) y finalmente la documentación.
 * </p>
 * @author Matías Collao
 * @author Lucas Riquelme
 * @version 1.0
 */
public class PrioridadImpacto implements EstrategiaPriorizacion {

	/**
	 * Ordena la lista de tareas por nivel de impacto (de mayor a menor urgencia).
	 * <p>
	 * Utiliza un algoritmo manual (Burbuja) para dejar los Bugs al principio
	 * y la Documentación al final.
	 * </p>
	 * @param tareas La lista de tareas a ordenar.
	 */
	public void ordenar(ArrayList<Tarea> tareas) {
		int n = tareas.size();
		for (int i = 0; i < n - 1; i++) {

			for (int j = 0; j < n - i - 1; j++) {

				Tarea t1 = tareas.get(j);
				Tarea t2 = tareas.get(j + 1);
				int prioridadT1 = getValorPrioridad(t1);

				int prioridadT2 = getValorPrioridad(t2);
				if (prioridadT1 > prioridadT2) {
					Tarea temp = t1;
					tareas.set(j, t2);

					tareas.set(j + 1, temp);
				}
			}
		}
	}
	
	/**
	 * Asigna un valor numérico a la tarea según su tipo.
	 * <p>
	 * La lógica es:
	 * 1 -> Bug (Máxima prioridad)
	 * 2 -> Feature (Prioridad media)
	 * 3 -> Documentacion (Prioridad baja)
	 * </p>
	 * @param t La tarea a evaluar.
	 * @return El número de prioridad correspondiente.
	 */
	private int getValorPrioridad(Tarea t) {

		switch (t.getTipo()) {
		case "Bug":
			return 1;
		case "Feature":
			return 2;
		case "Documentacion":
			return 3;
		default:
			return 4;

		}
	}
}
