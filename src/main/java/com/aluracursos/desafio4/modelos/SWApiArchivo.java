package com.aluracursos.desafio4.modelos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;


public class SWApiArchivo {
    private Gson gson;

    public SWApiArchivo() {
        gson =  new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
    }

    public void guardarPelicula(String json ){
        try {
            PeliculaSWAPI pelicula = gson.fromJson(json, PeliculaSWAPI.class) ;
            FileWriter fileWriter = new FileWriter("starwars.txt",true);
            fileWriter.write(gson.toJson(pelicula));
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
