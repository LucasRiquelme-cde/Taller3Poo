package Taller3poo;

import java.util.*;

public class PrioridadImpacto implements EstrategiaPriorizacion {

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
