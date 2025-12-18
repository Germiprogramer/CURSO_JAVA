
# EjFeedbackUno – Gestor de Películas

Para el primer ejercicio feedback de la asignatura se ha optado por realizar una aplicación que haga de gestor de películas. La razón por la que se ha optado por esta idea es porque resultaba sencillo pensar en implementar vistas requeridas como ImageView, CheckBox o ListView bajo este contexto.

## Funcionalidades principales

La aplicación es muy simple. Es un simulador de gestor de películas, en el que el usuario puede añadir películas facilmente. Lo malo es que por temas de la base de datos y que luego al volver a entrar en la aplicación no funcionaba bien porque no se veían bien las imagenes añadidas, pues no se ha hecho que guarde las peliculas sino que borre la base de datos y la vuelva a crear con las peliculas default. Por eso, se puede decir que no tiene un uso practico como tal

## Estructura de la aplicación

La aplicación está organizada en varias Activities:

- **MainActivity**: muestra la lista principal de películas. Hay tres peliculas defalut al inicio y luego se ven mas
- **CrearPeliculaActivity**: permite añadir o editar una película.
A parte de los campos que se meten (titulo, año, genero), se puede añadir una imagen para el poster desde la galería.
- **StatsActivity**: muestra estadísticas de la aplicación: numero de peliculas, peliculas favoritas y peliculas por tipo de genero

Además, se utilizan adapters personalizados para los elementos de los ListView y clases modelo para representar los datos.

---

## Modo de uso

1. Al iniciar la aplicación se muestra la lista de películas.
2. Desde el botón o el menú se puede añadir una nueva película.
3. Pulsando sobre una película se accede a su edición.
4. Se puede marcar una película como favorita desde la lista.
5. Desde el menú se puede acceder a la pantalla de estadísticas.
6. El menú también permite acceder a la información "Acerca de".

---

# Partes que me han parecido mas dificles

## Posibles mejoras

- Mantener los datos entre ejecuciones de la aplicación
Encontrar una forma de que con el cambio de idioma cambien tambien los generos y los nombres de las películas. Con los generos hubiese sido mas fácil si se hubiese elegido el campo genero como habia hecho al inicio, mediante un spinner. Pero al final quise meter un edittext porque no se, no sabua muy bien cuantos generos poner. Como hice el tema de la traduccion al final, no me di cuenta.
- Añadir la posibilidad de implementar peliculas.


---

## Autor

Germiprogramer
