package com.aluracursos.starwars.modelos;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Adaptador personalizado
//Esta clase permite que Gson pueda convertir correctamente objetos LocalDate a JSON y viceversa,
// porque por defecto Gson no sabe cómo manejar tipos como LocalDate

//Hereda de TypeAdapter<LocalDate>, lo que significa que es un adaptador personalizado
//que define cómo Gson debe convertir objetos de tipo LocalDate al escribir y al leer JSON.
class LocalDateAdapter extends TypeAdapter<LocalDate> {

    //e usa el formato estándar ISO (yyyy-MM-dd), que es el que generalmente usa una API como SWAPI.
    //Ejemplo de fecha: "1977-05-25".
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

    //Convierte un LocalDate a una cadena de texto
    // (por ejemplo, "1983-05-25") para que se guarde correctamente en el JSON.
    @Override
    public void write(JsonWriter out, LocalDate value) throws IOException {
        out.value(value.format(formatter));
    }

    //Convierte una cadena del JSON (como "1983-05-25") nuevamente a un objeto LocalDate
    @Override
    public LocalDate read(JsonReader in) throws IOException {
        return LocalDate.parse(in.nextString(), formatter);
    }
}