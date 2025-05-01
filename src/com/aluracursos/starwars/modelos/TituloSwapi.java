package com.aluracursos.starwars.modelos;

//es el objeto que se crea al extraer los datos del JSON, despues pasara a la clase Titulo que es la que uso en el sistema
public record TituloSwapi(String title,
                          String episode_id,
                          String opening_crawl,
                          String director,
                          String producer,
                          String release_date) {
}
