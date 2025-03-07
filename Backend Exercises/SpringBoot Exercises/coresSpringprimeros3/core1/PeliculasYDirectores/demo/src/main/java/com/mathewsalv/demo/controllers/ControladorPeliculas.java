package com.mathewsalv.demo.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControladorPeliculas {
    private static HashMap<String, String> listaPeliculas = new HashMap<String, String>();



    public ControladorPeliculas() {
        listaPeliculas.put("Winnie the Pooh", "Don Hall");	
        listaPeliculas.put("El zorro y el sabueso", "Ted Berman");
        listaPeliculas.put("Tarzán", "Kevin Lima");		
        listaPeliculas.put("Mulán", "Barry Cook");
        listaPeliculas.put("Oliver", "Kevin Lima");	
        listaPeliculas.put("Big Hero 6", "Don Hall");	
    }

    @GetMapping("/peliculas")
    public String obtenerTodasLasPeliculas(){
        StringBuilder peliculas = new StringBuilder();
        for (String pelicula : listaPeliculas.keySet()) {
            peliculas.append(pelicula).append(", ");
        }

        return peliculas.toString();
    }

    @GetMapping("/peliculas/{nombre}")
    public String obtenerPeliculaPorNombre(@PathVariable("nombre") String nombre){
        String pelis = listaPeliculas.get(nombre);
        if (pelis != null){
            return "Nombre de la Pelicula: " + nombre + ", Dirijido por: " + pelis;
        } else
        {
            return nombre + " no se encuentra en el catalogo.";
        }

    }

    @GetMapping("/peliculas/director/{nombre}")
    public String obtenerPeliculasPorDirector(@PathVariable("nombre") String nombre){
        StringBuilder peliculas = new StringBuilder();

        for (Map.Entry<String, String> entry : listaPeliculas.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(nombre)) {
                peliculas.append(entry.getKey()).append(", ");
            }
        }

        if (peliculas.length() > 0) {
            peliculas.setLength(peliculas.length() - 2);
            return "Películas dirigidas por " + nombre + ": " + peliculas.toString();
        } else {
            return "No contamos con películas con ese director en nuestra lista.";
        }
    }

}
