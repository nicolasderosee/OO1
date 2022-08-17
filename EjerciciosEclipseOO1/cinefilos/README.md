# CinéfilOOs

Este ejercicio propone construir un sistema (solo el modelo de dominio) en el que fanáticos del cine pueden indicar que películas vieron, pueden encontrar películas adecuadas a sus gustos, y pueden encontrar a otros usuarios que sean parecidos a ellos. 

Cinefiloos es un sitio para llevar registro de las películas que uno ha visto, seguir a otros fanáticos del cine, y obtener sugerencias. El sistema se apoya en IMDB, un sitio en el que ya están registradas la mayoría de las películas. Eso hace innecesario cargar toda la información. 

Esto es solo una implementación de referencia; dado que este trabajo se desarrolla en formato taller, siempre llegamos a una implementación diferente. 

A continuación se describen los casos de uso en formato breve (en la carpeta doc vas a encontrar un diagrama de casos de uso, creado con Plantuml.

El administrador del sistema podrá:

**Cargar película**: ingresa título, la URL de la película en IMDB, y la URL de la imagen de portada de la película (también tomada de IMDB). Adicionalmente indica el "perfil de género" de la película. El perfil de género indica en una escala de 0 a 9, cuánto de cada género tiene una película. Los géneros que se consideran son: horror, action, romance, suspense, comedy, y sci-fi. Si no se indica perfil de género, tomará 0 para todos los géneros (sin género definido). Cinefiloos (el sistema) registra la pelicula.

Los usuarios (cinéfilos) podrán:

**Registrarse como cinéfilos**: el cinéfilo ingresa su nombre completo, y su email. El sistema registra al cinéfilo y lo retorna.

**Obtener películas**: El sistema retorna la lista de películas.

**Obtener cinéfilos**: El sistema retorna la lista de cinéfilos.

**Marcar una película como vista**: Se indica un cinéfilo y una película. El sistema registra la película, como vista por el cinéfilo.

**Obtener películas vistas por un cinéfilo**: Dado un cinéfilo, el sistema retorna la lista de películas vistas por el cinéfilo.

**Obtener cinéfilos que vieron una película**: Dada una película, el sistema retorna la lista de cinéfilos que la vieron.

**Encontrar películas similares**: Retornar todas las películas que son similares a una que se indique. Retorna todas las películas cuyo "índice de similitud" a la película indicada es menor a 6 (menor índice implica, más parecidas). La lista no está ordenada. La película indicada también está en la lista. El cálculo de similitud se describe más abajo.

**Obtener la preferencia de género de cine un cinéfilo**: Dado un cinéfilo obtener su preferencia de genero de cine. Al igual que en el caso de las películas, la preferencia de género de cine de un cinéfilo indica en una escala de 0 a 9, cuánto le interesa cada género (de idéntica manera a como ocurre con el perfil de género de las peliculas). La preferencia de género de cine de un cinéfilo se calcula a partir del perfil de las películas que vió (asumimos que le gustaron). Si no vio ninguna, se retorna 4.5 (ni muy muy, ni tan tan). Cada nueva película que ve, impactará  (para arriba o para abajo) sobre ese valor de base (se promedia ese valor base con el de la películas que ve).

**Encontrar cinéfilos con gustos similares**: Dado un cinéfilo, encontrar todos aquellos que tienen preferencias de género parecidas. Para calcular la similitud entre dos cinéfilos, se toman las preferencias de género de cine de cada uno. Retorna todos los cinéfilos cuyo "índice de similitud" al indicado es menor a 6 (menor índice significa más parecido). La lista no está ordenada. El cinéfilo está en la lista también.  El cálculo de índice de similitud se describe más abajo (se hace el mismo cálculo que se hace para la similitud entre películas).

**Encontrar películas que pueden gustar, no vistas**: Dado un cinéfilo, retorna todas las películas cuyo "índice de similitud" a la preferencia del cinéfilo es menor a 6, y que el cinéfilo no vió. La lista no está ordenada. El cálculo de similitud se describe más abajo (se hace el mismo cálculo que se hace para la similitud entre películas).

Cálculo del índice de similitud entre películas, entre cinéfilos, y entre películas y cinéfilos.

Piense al perfil de género de una película como una tabla en la que para cada género (los géneros son fijos) hay un valor de 0 a 9. Un 0 significa que no tiene nada de ese género, 9 que tiene el máximo posible. De la misma manera puede pensar el perfil de preferencias de género de cine de un cinéfilo.

Para calcular la similitud entre dos de esas "tablas" hacemos lo siguiente:
* género por género restamos el valor de la primer tabla al valor de la segunda.
* sumamos los valores absolutos de esas restas.

El resultado de la suma será nuestro indicador de similitud.  


