# EjFeedbackUno – Gestor de Películas

Para el primer ejercicio de feedback de la asignatura se ha optado por desarrollar una aplicación Android que funcione como gestor de películas.  
La elección de esta temática se debe a que resulta sencilla para implementar los elementos solicitados en el enunciado, como ImageView, CheckBox y ListView, dentro de un contexto claro y fácil de entender.

---

## Funcionalidades principales

La aplicación es intencionadamente sencilla. Se trata de un simulador de gestor de películas en el que el usuario puede añadir y modificar películas de forma básica.

Debido a problemas detectados con la base de datos al reiniciar la aplicación —principalmente relacionados con la visualización de las imágenes añadidas desde la galería— se ha optado por limpiar la base de datos cada vez que se inicia la app y cargar un conjunto de películas por defecto.  
Por este motivo, la aplicación no mantiene los datos entre ejecuciones y su uso es principalmente demostrativo y académico.

---

## Estructura de la aplicación

La aplicación está organizada en varias Activities:

- **MainActivity**: muestra la lista principal de películas. Al iniciar la aplicación se cargan tres películas por defecto y posteriormente se muestran las películas añadidas durante la ejecución.
- **CrearPeliculaActivity**: permite añadir o editar una película.  
  Además de los campos básicos (título, año y género), se puede seleccionar una imagen para el póster desde la galería del dispositivo.
- **StatsActivity**: muestra estadísticas de la aplicación, como el número total de películas, el número de películas favoritas y el número de películas por género.

Además, se utilizan adapters personalizados para los ListView y clases modelo para representar los datos de la aplicación.

Todas las Activities tienen acceso a un menú de opciones, excepto la pantalla de estadísticas, ya que no se consideró necesario en ese caso.

---

## Modo de uso

1. Al iniciar la aplicación se muestra la lista de películas.
2. Desde el menú se puede navegar entre las distintas pantallas y cambiar el idioma de la aplicación.
3. Desde el botón o el menú se puede añadir una nueva película.
4. Se rellenan los campos de la película y se guarda.
5. Las películas pueden marcarse como favoritas directamente desde la lista.
6. Desde el menú se puede acceder a la pantalla de estadísticas.
7. El menú también permite acceder a la información de “Acerca de”.

---

## Partes que me han resultado más difíciles

Una de las partes que más me costó fue entender por qué no funcionaba correctamente el cambio de idioma. El problema estaba en que el idioma por defecto de la aplicación era inglés y fue necesario ajustar correctamente los recursos para que el español fuese el idioma principal.

Otra de las partes más complicadas fue la implementación de los adapters personalizados, ya que al principio resultaba difícil entender cómo se relacionaban los datos con las vistas del ListView.

---

## Posibles mejoras

- Mantener los datos entre ejecuciones de la aplicación.
- Traducir también los géneros y los nombres de las películas al cambiar el idioma.  
  Esto habría sido más sencillo si el género se hubiese implementado mediante un Spinner en lugar de un EditText, pero se optó por este último al no tener claro inicialmente cuántos géneros incluir.
- Añadir la opción de eliminar películas.
- Crear una clase específica para gestionar la base de datos en lugar de manejarla directamente desde las Activities. Se intentó implementar esta mejora, pero al no funcionar correctamente se decidió mantener la base de datos integrada en las Activities.

---

## Autor

Germiprogramer
