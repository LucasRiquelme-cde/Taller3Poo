package Taller3poo;

import java.util.*;

public class PrioridadComplejidad implements EstrategiaPriorizacion {

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
