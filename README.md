# Taller3Poo
Taller 3 POO - Sistema de Gestión de Proyectos
Integrantes del Grupo:

-Nombre: Matías Collao
-RUT: 22.060.152-8
-Carrera: Ingeniería Civil en Computación e Informática
-GitHub User: @MatiasCollao

-Nombre: Lucas Riquelme
-RUT: 21.943.208-9
-Carrera: Ingeniería Civil en Computación e Informática
-GitHub User: @LucasRiquelme-cde

Descripción General del Proyecto:
-Este proyecto es una solución de software desarrollada en Java. El objetivo es permitir la gestión eficiente de proyectos y tareas mediante una aplicación de consola.

El sistema permite dos roles de usuario:
-Administrador: Puede crear proyectos, gestionar tareas, asignar prioridades y generar reportes.
-Colaborador: Puede ver sus tareas asignadas, cambiar el estado de las mismas y consultar el impacto de sus tareas.

Arquitectura y Patrones de Diseño Aplicados:
1. Singleton (Sistema.java)
Se utiliza para garantizar que exista una única instancia del sistema encargada de cargar y mantener los datos en memoria (listas de usuarios, proyectos y tareas). Esto evita inconsistencias en los datos al acceder desde distintos menús.

2. Factory Method (TareaFactory.java)
Implementado para la creación dinámica de tareas. Permite crear instancias de tareaBug, tareaFeature o tareaDocumentacion sin acoplar la lógica del menú a las clases concretas, facilitando la adición de nuevos tipos de tareas en el futuro.

3. Strategy (EstrategiaPriorizacion.java)
Utilizado en el Menú Administrador (Opción 4). Permite cambiar el algoritmo de ordenamiento de las tareas en tiempo de ejecución.
Estrategias implementadas:
-PrioridadFecha: Ordena por antigüedad.
-PrioridadImpacto: Ordena por tipo (Bug > Feature > Doc).
-PrioridadComplejidad: Ordena por nivel (Alta > Media > Baja).

4. Visitor (TareaVisitor.java)
Utilizado en el Menú Usuario (Opción 4). Permite ejecutar operaciones distintas sobre las tareas sin modificar sus clases.
El visitante (ActivarVisitor) recorre las tareas y muestra mensajes específicos sobre el impacto de cada una (Criticidad, Tiempo o Calidad) dependiendo si es un Bug, Feature o Documentación.

Documentación JavaDoc:
El código fuente ha sido documentado siguiendo el estándar JavaDoc.
Puedes consultar la documentación técnica completa (clases, métodos y parámetros).

Persistencia de Datos:
El sistema utiliza archivos de texto plano (.txt) como base de datos simple. Los cambios realizados en la ejecución (agregar tareas, proyectos o eliminar elementos) se guardan automáticamente.
-usuarios.txt: Credenciales y roles.
-proyectos.txt: Información de los proyectos.
-tareas.txt: Detalle de todas las tareas.
-reporte.txt: Archivo de salida generado por el administrador.

Ejecución
Para correr el proyecto:
Importar el proyecto en Eclipse como "Java Project".
Asegurarse de que los archivos .txt estén en la raíz del proyecto (al mismo nivel que la carpeta src).
Ejecutar la clase principal: Taller3poo.App.java
