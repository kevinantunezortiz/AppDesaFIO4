package com.aluracursos.desafio4.principal;

import com.aluracursos.desafio4.modelos.ConsultaSWApi;
import com.aluracursos.desafio4.modelos.ArchivoSWApi;

import java.util.Scanner;

public class AppSWApi {
    public static void main(String[] args) {
        var consultaAPI = new ConsultaSWApi();
        var conversorJson = new ArchivoSWApi();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe el numero de una pelicula");
        String json = consultaAPI.obtenerJson(teclado.nextInt());
        System.out.println(json);
        conversorJson.guardarPelicula(json);
    }
}
