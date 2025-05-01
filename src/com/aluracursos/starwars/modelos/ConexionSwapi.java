package com.aluracursos.starwars.modelos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexionSwapi {

    //Este metodo:
    //Recibe un String con el ID de la película.
    //Devuelve un objeto de tipo TituloSwapi (una clase que tú creaste para reflejar los datos de una película en la API).
    //Lanza excepciones:
    //IOException: Si ocurre un problema al conectarse a internet.
    //InterruptedException: Si el hilo es interrumpido mientras espera la respuesta.

    public TituloSwapi buscarPelicula( String idPelicula)  {
        String url = "https://swapi.py4e.com/api/films/"+idPelicula+"/";


        //Ese bloque de código es el que se encarga de hacer la petición HTTP a la API
        // y obtener la respuesta en formato JSON como una cadena de texto (String).

        //Esto crea un cliente para enviar peticiones HTTP. Es parte de la API estándar de Java desde Java 11.
        HttpClient client = HttpClient.newHttpClient();
        //Aquí se construye una solicitud GET hacia la URL que especifiques (por ejemplo, "https://swapi.py4e.com/api/films/1/").
        HttpRequest request = HttpRequest.newBuilder(URI.create(url)).build();


        try {
            //Esto envía la solicitud al servidor y recibe la respuesta como texto (String), usando el "cuerpo" de la respuesta HTTP.
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            //Extraer el cuerpo JSON y lo guarda en la variable json
            String json = response.body();

            //Gson es una biblioteca de Google para convertir objetos Java a JSON y viceversa.
            // Es muy usada en aplicaciones Java que interactúan con APIs web o almacenan datos de forma estructurada.
            //esta en dependencias en un archivo .jar

            //Esto está construyendo una instancia de Gson con algunas configuraciones especiales:
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).setPrettyPrinting().create();
            //.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            //Esto le indica a Gson cómo mapear los nombres de los campos del JSON con los nombres de los atributos en tus clases Java.

            //.setPrettyPrinting()
            //Esto no afecta el proceso de deserialización. Solo sirve al convertir un objeto Java a JSON,
            // para que el JSON resultante sea más legible (por ejemplo, con sangría y saltos de línea).

            //.create()
            //Construye finalmente la instancia de Gson con todas las configuraciones anteriores.

            //Esto convierte la cadena JSON (que recibiste con response.body()) en un objeto Java del tipo TituloSwapi.
            return gson.fromJson(json, TituloSwapi.class);

        } catch (Exception e) {
            throw new RuntimeException("No encontré esa pelicula");
        }





    }



}
