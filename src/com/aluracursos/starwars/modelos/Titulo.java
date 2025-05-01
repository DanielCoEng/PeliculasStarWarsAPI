package com.aluracursos.starwars.modelos;

import java.time.LocalDate;

public class Titulo implements Comparable<Titulo>{
    private String titulo;
    private int episodioId;
    private String descripcion;
    private String director;
    private String productor;
    private LocalDate fechaDeLanzamiento;

    public Titulo(String titulo, LocalDate fechaDeLanzamiento, int episodioId) {
        this.titulo = titulo;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
        this.episodioId = episodioId;
    }

    public Titulo(TituloSwapi miTituloSwapi){
        this.titulo = miTituloSwapi.title();
        this.episodioId = Integer.valueOf(miTituloSwapi.episode_id());
        this.fechaDeLanzamiento = LocalDate.parse(miTituloSwapi.release_date());
        this.descripcion = miTituloSwapi.opening_crawl();
        this.director = miTituloSwapi.director();
        this.productor = miTituloSwapi.producer();
    }




    public String getTitulo() {
        return titulo;
    }

    public int getEpisodioId() {
        return episodioId;
    }

    public LocalDate getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    @Override
    public int compareTo(Titulo otroTitulo) {
        return (this.getFechaDeLanzamiento()).compareTo(otroTitulo.getFechaDeLanzamiento());
    }

    @Override
    public String toString() {
        return "Titulo{" +
                "titulo='" + titulo +
                ", episodioId=" + episodioId +
                ", fechaDeLanzamiento=" + fechaDeLanzamiento +
                '}';
    }
}
