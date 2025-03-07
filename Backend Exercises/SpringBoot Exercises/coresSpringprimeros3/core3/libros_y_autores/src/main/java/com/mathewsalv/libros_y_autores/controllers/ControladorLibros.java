package com.mathewsalv.libros_y_autores.controllers;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class ControladorLibros {
    private static HashMap<String, String> listaLibros = new HashMap<String, String>();
    

    public ControladorLibros() {
        listaLibros.put("Odisea", "Homero");	
        listaLibros.put("Don Quijote de la Mancha", "Miguel de Cervantes");
        listaLibros.put("El Código Da Vinci", "Dan Brown");		
        listaLibros.put("Alicia en el país de las maravillas", "Lewis Carroll");
        listaLibros.put("El Hobbit", "J.R.R. Tolkien");	
        listaLibros.put("El alquimista", "Paulo Coelho");	
    }

    @GetMapping("/libros")
    public String obtenerTodosLosLibros(Model model) {
        model.addAttribute("listaLibros", listaLibros.keySet());
        return "libros.jsp";
    }

    @GetMapping("/libros/{nombre}")
    public String obtenerInformacionDeLibro(@PathVariable("nombre") String nombre, Model model) {
        if(listaLibros.containsKey(nombre)){
            model.addAttribute("nombreLibro", nombre);
            model.addAttribute("autorNombre", listaLibros.get(nombre));
        }else{
            model.addAttribute("mensaje", "El libro no se encuentra en nuestra lista.");
        }
        return "detalleLibro.jsp";
    }
    
    @GetMapping("libros/formulario")
    public String formularioLibro() {
        return "formularioLibros.jsp";
    }
    

    @PostMapping("/libros/procesa/libro")
    public String procesaLibro(@RequestParam(value = "libroNombre") String libroNombre,
                                @RequestParam(value = "autorNombre") String autorNombre) {

        listaLibros.put(libroNombre, autorNombre);
        return "redirect:/libros";
    }
    

}
