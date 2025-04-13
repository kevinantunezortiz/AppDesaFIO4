package com.aluracursos.desafio4.modelos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class ConversorJson {
    private Gson gson;

    public ConversorJson() {
        gson =  new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
    }

    public  PeliculaSWAPI convertirJsonAPelicula(String json){
        PeliculaSWAPI pelicula = gson.fromJson(json, PeliculaSWAPI.class) ;
        return  pelicula;
    }
    public void guardarPeliculas(ArrayList<PeliculaSWAPI> peliculas){
        try {
            FileWriter fileWriter = new FileWriter("starwars.txt");
            fileWriter.write(gson.toJson(peliculas));
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
