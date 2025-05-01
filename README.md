📽️ Películas Star Wars - Proyecto Java con API REST y JSON
Este proyecto es una aplicación Java que se conecta a la Star Wars API (SWAPI) para consultar información sobre películas de la saga Star Wars.

🚀 Funcionalidades principales:
Solicita al usuario un ID de película (1 a 7) por consola.
Realiza una petición HTTP a la API de Star Wars para obtener los datos.
Transforma la respuesta JSON en objetos Java utilizando Gson.
Convierte los datos a un modelo propio (Titulo) con campos como título, director, duración, fecha de lanzamiento, etc.
Ordena las películas por fecha de lanzamiento.
Guarda la información en un archivo titulos.json.

🛠️ Tecnologías utilizadas:
Java 17+
API REST con HttpClient
Gson (parseo y escritura de JSON)
Manejo de fechas con LocalDate
Programación orientada a objetos (POO)
Manejo de excepciones personalizado

📦 Estructura del proyecto:
├── modelos/
│   ├── Titulo.java
│   ├── TituloSwapi.java
│   ├── TransformadorTitulo.java
│   ├── GuardadorDeTitulos.java
│   └── LocalDateAdapter.java
├── principal/
│   └── Main.java
├── util/
│   └── ConexionSwapi.java
└── titulos.json
