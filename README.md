# Peliculómetro

Para el ejercicio final de la asignatura, se ha desarrollado una aplicación Android cuyo objetivo es gestionar y visualizar una lista de lugares de interés. La aplicación permite consultar información de distintas localizaciones, marcarlas como favoritas, aplicar filtros... entre otras opciones.

---

## Funcionalidades principales

La aplicación es muy simple. Se trata de un simulador de gestor de películas en el que el usuario puede añadir y modificar peliculas. También se pueden consultar estadísticas sencillas sobre las películas.

Debido a que las imágenes añadidas no se guardaban bien entre ejecuciones y luego no aparecían asignadas a sus películas correspondientes, se ha optado por limpiar la base de datos cada vez que se inicia la app y cargar un conjunto de películas por defecto.  
Por este motivo, la aplicación no mantiene los datos entre ejecuciones y su uso es principalmente demostrativo y académico.

---

## Estructura de la aplicación

**Activities**

La aplicación está organizada en varias Activities:

- **MainActivity**: Muestra la lista principal de lugares. Al iniciar la aplicación se cargan una serie de lugares por defecto en un RecyclerView, aunque también se puede pulsar un botón para añadir o eliminar una serie de lugares extra de forma asíncrona. Cada lugar tiene un botón asociado que al pulsarlo te lleva a una actividad con mayor información. Los luagres se pueden marcar como favoritos, y filtrar de esta forma o también por tipo. Por último, en esta pantalla también hay un botón para lanzar una notificación.

<p align="center">
  <img src="https://github.com/user-attachments/assets/92caa958-f409-47fa-941c-41b5c0e2c493" width="180">
  <img src="https://github.com/user-attachments/assets/2e248556-d5ed-4193-b52f-04808332dd0c" width="180"
    <img src="https://github.com/user-attachments/assets/2e248556-d5ed-4193-b52f-04808332dd0c" width="180">>
</p>


- **DetailActivity**: Una pantalla para la información del lugar elegido en exclusiva. Contiene un mapa con la ubicación del lugar y la ubicación del usuario.
<p align="center">
  <img src="https://github.com/user-attachments/assets/92caa958-f409-47fa-941c-41b5c0e2c493" width="180">
  <img src="https://github.com/user-attachments/assets/2e248556-d5ed-4193-b52f-04808332dd0c" width="180">
  <img src="https://github.com/user-attachments/assets/2e248556-d5ed-4193-b52f-04808332dd0c" width="180">
</p>

**Fragments**

- **MapFragment**: Contiene el mapa de Google Maps y las funciones asociadas a este. Permite seleccionar puntos sobre el mapa y ver los marcadores.

## Almacenamiento de datos

El sistema de almacenamiento de datos ha sido desarrollado mediante Room. Su implementación y su interacción con las activities se divide en varias clases.

- **PlaceEntity**: Modelo de datos que representa un lugar y que se utiliza como entidad de Room.
- **PlacesRoomManager**: Encapsula el acceso a la base de datos Room desde las activities, ofreciendo las funciones necesarias para interactuar con la BD.
- **PlacesAdapter**: Adapter personalizado para el RecyclerView, encargado de enlazar los datos con las vistas.
- **PrefsManager**: Clase para gestionar las preferencias (mostrar determinados lugares) mediante SharedPreferences. Hay dos preferencias: mostrar solo favoritos y tipo de lugar. Estas preferencias se leen al iniciar la aplicación y se pueden cambiar desde un Checkbox y un Spinner.

## Trabajo en segundo plano

Para simular la carga de datos sin bloquear la interfaz, se emplea un ExecutorService, ejecutando las operaciones en segundo plano. 
La actualización de la UI tras la carga se realiza mediante un Handler asociado al hilo principal.

Durante este proceso se muestra un ProgressBar giratorio (me gustaba más que la barra) que hace la impresión de actualizar durante un par de segundos. Al finalizar, se refresca el RecyclerView, añadiendo o quitando los datos del .json extra.

**Nota:**
*En lugar de añadir progresivamente los datos cargados desde JSON a la base de datos Room, se optó por alternar la aparición(desaparición de un conjunto de datos al pulsar el botón de actualización. En la práctica, esto implica trabajar con dos fuentes de datos distintas.*

*Aunque el enunciado indicaba que los datos debían añadirse a la base de datos, esta decisión se tomó porque durante las pruebas habría sido necesario añadir manualmente nuevos lugares en cada ejecución, lo que dificultaba el desarrollo y las pruebas continuas. Además, en la versión final de la aplicación, ese botón tendría un solo uso de todos modos. De este modo, se cumple el objetivo principal del trabajo en segundo plano aunque cambiando un poco el enfoque.*

## Notificaciones

Se ha implementado un sistema de notificaciones locales que cumple los siguientes requisitos:

- Creación de un NotificationChannel para dispositivos con Android 8.0 o superior.

- Posibilidad de lanzar una notificación manualmente mediante un botón.

- Implementación de una notificación programada una vez al día, mostrando un mensaje.

Al pulsar una notificación, se abre la aplicación.

## Análisis de rendimiento (Profiler)

Se ha utilizado Android Profiler, concretamente el Memory Profiler, para analizar el uso de memoria de la aplicación.

**Problema o riesgo detectado**

Durante las pruebas se observó un uso elevado de memoria asociado a la carga de imágenes, especialmente reflejado en la cantidad de arrays de tipo byte[] y int[] en el heap.
Esto supone un riesgo potencial si se utilizan imágenes grandes o numerosas.

<p align="center">
  <img src="https://github.com/user-attachments/assets/9335f1b3-c715-4ad1-834c-c1add5eea8f3" width="1600">
  <img src="https://github.com/user-attachments/assets/2c543887-8f2f-4981-863a-1c73d3792128" width="1600">
</p>

**Mejora aplicada**

Como mejora, se han optimizado algunas imágenes convirtiéndolas a formato WebP y reduciendo su tamaño.

<p align="center">
  <img src="https://github.com/user-attachments/assets/9335f1b3-c715-4ad1-834c-c1add5eea8f3" width="1600">
</p>

Tras esta modificación, se observó una reducción significativa en el número de asignaciones y en el tamaño ocupado en memoria, mejorando el comportamiento general de la aplicación.

<p align="center">
  <img src="https://github.com/user-attachments/assets/9335f1b3-c715-4ad1-834c-c1add5eea8f3" width="1600">
  <img src="https://github.com/user-attachments/assets/2c543887-8f2f-4981-863a-1c73d3792128" width="1600">
  <img src="https://github.com/user-attachments/assets/2c543887-8f2f-4981-863a-1c73d3792128" width="1600">
</p>

## Traducción

La aplicación permite cambiar el idioma entre español e inglés. Uno de los principales problemas surgió al intentar traducir textos almacenados en la base de datos. Inicialmente se intentó trabajar con referencias a recursos XML (strings.xml), pero esto generó errores relacionados con el Context y su disponibilidad en capas como Room. Los errores tampoco se consiguieron solucionar tras migrar a archivos .json los distintos places.

Finalmente, se optó por almacenar directamente los textos como String en la base de datos, priorizando la estabilidad y simplicidad de la aplicación frente a una solución más compleja.

---

## Partes que me han resultado más difíciles

- Problemas con la traducción de datos almacenados en Room.

- Errores de esquema al modificar la estructura de la base de datos durante el desarrollo.

- Dificultades iniciales con la configuración de notificaciones y canales.

- Se mecomplicó un poco la aparición y desaparición del fragmentMap con la ubicación del usuario.

- Integración correcta del Adapter con múltiples listeners.

---

## Posibles mejoras

- Poder añadir o eliminar lugares desde la app.
- Mejorar la traducción de los elementos place.
- Hay algunas vistas que en los xml aparecen pefectamente colocadas, pero que luego en ejecución no se ven tan bien. Me sucede en todos los trabajos, en el emulador del ordenador está genial pero en el teléfono móvil donde pruebo no.
