package com.aluracursos.starwars.principal;

import com.aluracursos.starwars.exepcion.ErrorEnConversionDeDuracionException;
import com.aluracursos.starwars.modelos.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();

        //Instancias necesarias
        //Se crean objetos de las clases que se encargan de:
        //ConexionSwapi: consultar la API.
        //TransformadorTitulo: convertir el resultado JSON en un objeto Titulo.
        //GuardadorDeTitulos: guardar los resultados en un archivo.

        ConexionSwapi conexionSwapi = new ConexionSwapi();
        TransformadorTitulo transformadorTitulo = new TransformadorTitulo();
        GuardadorDeTitulos guardadorDeTitulos = new GuardadorDeTitulos();

        while (true) {
            System.out.println("Escriba el id de la película (1-7)(o 'salir'):");
            String busqueda = sc.nextLine();

            if (busqueda.equalsIgnoreCase("salir")) break;

            try {
                //Consultar película en la API
                //Llama a buscarPelicula para obtener los datos desde la API SWAPI
                TituloSwapi tituloSwapi = conexionSwapi.buscarPelicula(busqueda);

                //Transformar JSON en objeto Java
                //onvierte el TituloSwapi (datos crudos del JSON) en un Titulo (objeto con lógica propia).
                Titulo titulo = transformadorTitulo.transformar(tituloSwapi);

                //Lo agrega a la lista titulos.
                titulos.add(titulo);

            //Captura errores de conexión o de transformación. Evita que el programa se caiga.
            } catch (ErrorEnConversionDeDuracionException e) {
                System.out.println("Error de duración: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Otro error: " + e.getMessage());
            }
        }

        // Guardado final fuera del bucle
        try {
            //Ordena las películas por fecha.
            Collections.sort(titulos);
            System.out.println("Títulos ordenados por fecha de lanzamiento: " + titulos);

            //Las guarda en un archivo JSON con ayuda de Gson y LocalDateAdapter.
            guardadorDeTitulos.guardarComoJson(titulos, "titulos.json");
            System.out.println("Películas guardadas exitosamente");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizo la aplicación");
        }

        System.out.println("Programa finalizado");
    }
}
