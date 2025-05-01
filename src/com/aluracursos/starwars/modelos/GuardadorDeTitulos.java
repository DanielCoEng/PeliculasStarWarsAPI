package com.aluracursos.starwars.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

//Esta clase tiene la responsabilidad de guardar una lista de películas (Titulo) en un archivo JSON.

public class GuardadorDeTitulos {

    //Parámetros:
    //List<Titulo> titulos: es la lista de películas que quieres guardar.
    //String nombreArchivo: es el nombre (o ruta) del archivo donde se guardará el JSON.

    public void guardarComoJson(List<Titulo> titulos, String nombreArchivo) throws IOException {

       //GsonBuilder() → Se usa para configurar cómo se va a generar el JSON.
        //.registerTypeAdapter(LocalDate.class, new LocalDateAdapter()) → Esto es muy importante: le estás diciendo a Gson cómo convertir objetos LocalDate a texto, porque por defecto Gson no puede trabajar con LocalDate. LocalDateAdapter es una clase personalizada que tú (o el curso) debió haber creado para manejar eso.
        //.setPrettyPrinting() → Hace que el JSON se guarde bonito, con saltos de línea y sangría.
        //.create() → Crea el objeto Gson configurado.

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .setPrettyPrinting()
                .create();

        //Crea un objeto para escribir en el archivo cuyo nombre recibiste como parámetro.
        FileWriter escritura = new FileWriter(nombreArchivo);
        //Convierte la lista de Titulo a JSON y la escribe en el archivo.
        escritura.write(gson.toJson(titulos));
        //Cierra el archivo para que se guarden correctamente los datos.
        escritura.close();
    }

}
