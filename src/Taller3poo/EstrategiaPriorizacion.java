package Taller3poo;

import java.util.*;

/**
 * Interfaz que define cómo se deben comportar las estrategias de ordenamiento.
 * <p>
 * Cualquier clase que quiera ordenar tareas (ya sea por fecha,
 * impacto o complejidad) debe implementar esta interfaz y tener el método "ordenar".
 * Así, el administrador puede cambiar de estrategia fácilmente.
 * </p>
 * @author Matías Collao
 * @author Lucas Riquelme
 * @version 1.0
 */
public interface EstrategiaPriorizacion {
	
	/**
	 * Ordena la lista de tareas que le pasemos.
	 * <p>
	 * Este método modifica la lista original, dejándola ordenada según
	 * el criterio de la estrategia que estemos usando en ese momento.
	 * </p>
	 * @param tareas La lista de tareas que queremos reordenar.
	 */
	void ordenar(ArrayList<Tarea> tareas);

}
