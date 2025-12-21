# Peliculómetro

Para el primer ejercicio feedback de la asignatura se ha optado por realizar una aplicación que haga de gestor de películas. La razón por la que se ha optado por esta idea es porque resultaba sencillo pensar en implementar vistas requeridas como ImageView, CheckBox o ListView bajo este contexto.

---

## Funcionalidades principales

La aplicación es muy simple. Se trata de un simulador de gestor de películas en el que el usuario puede añadir y modificar peliculas. También se pueden consultar estadísticas sencillas sobre las películas.

Debido a que las imágenes añadidas no se guardaban bien entre ejecuciones y luego no aparecían asignadas a sus películas correspondientes, se ha optado por limpiar la base de datos cada vez que se inicia la app y cargar un conjunto de películas por defecto.  
Por este motivo, la aplicación no mantiene los datos entre ejecuciones y su uso es principalmente demostrativo y académico.

---

## Estructura de la aplicación

La aplicación está organizada en varias Activities:

- **MainActivity**: Muestra la lista principal de películas. Al iniciar la aplicación se cargan tres películas por defecto y posteriormente se muestran las películas añadidas durante la ejecución.

<p align="center">
  <img src="https://github.com/user-attachments/assets/92caa958-f409-47fa-941c-41b5c0e2c493" width="180">
  <img src="https://github.com/user-attachments/assets/2e248556-d5ed-4193-b52f-04808332dd0c" width="180"
    <img src="https://github.com/user-attachments/assets/2e248556-d5ed-4193-b52f-04808332dd0c" width="180">>
</p>


- **CrearPeliculaActivity**: permite añadir o editar una película. 
  Además de los campos básicos (título, año y género), se puede seleccionar una imagen para el póster desde la galería del dispositivo.

<p align="center">
  <img src="https://github.com/user-attachments/assets/92caa958-f409-47fa-941c-41b5c0e2c493" width="180">
  <img src="https://github.com/user-attachments/assets/2e248556-d5ed-4193-b52f-04808332dd0c" width="180">
  <img src="https://github.com/user-attachments/assets/2e248556-d5ed-4193-b52f-04808332dd0c" width="180">
</p>

- **StatsActivity**: muestra estadísticas de la aplicación, como el número total de películas, el número de películas favoritas y el número de películas por género.

<p align="center">
  <img src="https://github.com/user-attachments/assets/92caa958-f409-47fa-941c-41b5c0e2c493" width="180">

</p>

Además, se utilizan adapters personalizados para los ListView y clases modelo para representar los datos de la aplicación.

Todas las Activities tienen acceso a un menú de opciones, excepto la pantalla de estadísticas, ya que no parecía necesario.

---

## Modo de uso

1. Al iniciar la aplicación se muestra la lista de películas.
2. Desde el menú se puede navegar entre las distintas pantallas y cambiar el idioma de la aplicación.
3. Desde el botón "Añadir Película" o el menú se puede añadir una nueva película. También se puede editar una película existente al pulsar sobre ella en la lista.
4. Se rellenan los campos de la película y se guarda.
5. Las películas pueden marcarse como favoritas directamente desde la lista.
6. Desde el menú se puede acceder a la pantalla de estadísticas.
7. El menú también permite acceder a la información de “Acerca de”.

---

## Partes que me han resultado más difíciles

Una de las partes que más me costó fue el tema del cambio de idioma. El problema estaba en que el idioma por defecto de la aplicación era inglés y por lo que cuando intentaba hacer un cambio a la traducción inglesa de Reino Unido (poniendo solo "en", el sistema pensaba que estaba solicitando el Locale default.

Otra de las partes más complicadas fue la implementación de los adapters, ya que al principio resultaba difícil entender cómo se relacionaban los datos con las vistas del ListView. Sin embargo, parecían necesarios para que el ListView quedase bien.

Además, la parte de modificar las películas también se me complico un poco, porque no me pillaba bien el peliculaId y no salía la pelicula a modificar, sino te llevaba a la pamntalla para crear una nueva.

---

## Posibles mejoras

- Mantener los datos entre ejecuciones de la aplicación.
- Traducir también los géneros y los nombres de las películas al cambiar el idioma.  
  Con los géneros hubiese sido mas fácil si se hubiese elegido el campo genero como habia hecho al inicio, mediante un Spinner. Pero al final quise meter un EditText porque no sabía muy bien cuántos generos poner y porque cambie los posters default en función del género para que se pudiera meter una imagen a elección del usuario. Como hice el tema de la traduccion al final, no me di cuenta.
- Añadir la opción de eliminar películas.
- No hay una carpeta con un archivo java aparte para la base de datos, intente hacerlo pero no me estaba saliendo bien y decidí dejar la base de datos en las Activities.
- Hay algunas vistas que en los xml aparecen pefectamente colocadas, pero que luego en ejecución no se ven tan bien. Sucede algo parecido al cambiar el idioma, dado que los textos no se colocan del todo bien.

