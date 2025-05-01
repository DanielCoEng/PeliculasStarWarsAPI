package com.aluracursos.starwars.modelos;

//Sirve para convertir un objeto TituloSwapi (que es el que se obtiene directamente de la API) en un objeto Titulo

public class TransformadorTitulo {

    //Este metodo simplemente:
    //1. Recibe un objeto TituloSwapi, que contiene los datos crudos de la API.
    //2. Llama al constructor de la clase Titulo que acepta un TituloSwapi como parámetro.
    // (que se debe configurar con los datos extraidos del json a los atributos establecidos en la clase Titulo).
    //3. Devuelve un objeto Titulo, que ya está en el formato que usas internamente (con sus atributos listos para guardar, mostrar, ordenar, etc.).
    public Titulo transformar(TituloSwapi tituloSwapi){
        return new Titulo(tituloSwapi);
    }
}
