package com.aluracursos.desafio4.principal;

import com.aluracursos.desafio4.modelos.ConsultaAPI;
import com.aluracursos.desafio4.modelos.ConversorJson;
import com.aluracursos.desafio4.modelos.PeliculaSWAPI;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;

public class AppStarWars {
    public static void main(String[] args) {
        var consultarApi = new ConsultaAPI();
        var conversorJson = new ConversorJson();
        Scanner teclado = new Scanner(System.in);
        var peliculas = new ArrayList<PeliculaSWAPI>();
        int numeroDePelicula =0;
        do {
            System.out.println("Escribe un numero del 1 al 7 para guardar una pelicula de StarWars");
            System.out.println("Escribe 0 para salir");
            numeroDePelicula = teclado.nextInt();
            HttpResponse<String> respuesta = consultarApi.obtenerRespuesta(numeroDePelicula);
            if(respuesta.statusCode()==200) {
                String json = respuesta.body();
                PeliculaSWAPI pelicula = conversorJson.convertirJsonAPelicula(json);
                System.out.println(pelicula);
                peliculas.add(pelicula);
            }
        }while (numeroDePelicula>0);
        conversorJson.guardarPeliculas(peliculas);
    }
}
