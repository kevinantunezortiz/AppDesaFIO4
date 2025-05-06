package com.aluracursos.desafio4.principal;

import com.aluracursos.desafio4.modelos.ConsultaAPI;
import com.aluracursos.desafio4.modelos.SWApiArchivo;

import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        var consultaAPI = new ConsultaAPI();
        var conversorJson = new SWApiArchivo();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe el numero de una pelicula");
        String json = consultaAPI.obtenerJson(teclado.nextInt());
        System.out.println(json);
        conversorJson.guardarPelicula(json);
    }
}
