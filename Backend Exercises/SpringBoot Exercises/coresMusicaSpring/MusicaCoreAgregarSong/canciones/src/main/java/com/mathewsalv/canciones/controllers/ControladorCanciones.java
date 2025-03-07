package com.mathewsalv.canciones.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mathewsalv.canciones.models.Cancion;
import com.mathewsalv.canciones.services.ServicioCanciones;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;



@AllArgsConstructor
@Controller
public class ControladorCanciones {
    
    @Autowired
    private ServicioCanciones servicioCanciones;

    @GetMapping("/canciones")
    public String desplegarCanciones(Model model){
        List<Cancion> listaCanciones = this.servicioCanciones.obtenerTodasLasCanciones();
        model.addAttribute("listaCanciones", listaCanciones);
        return "canciones.jsp";
    }

    @GetMapping("/canciones/detalle/{idCancion}")
    public String desplegarDetalleCancion(@PathVariable("idCancion") Long id, Model model) {
        Cancion cancion = servicioCanciones.obtenerCancionPorId(id);
        model.addAttribute("cancion", cancion);
        return "detalleCancion.jsp";
    }
    
    @GetMapping("/canciones/formulario/agregar/{idCancion}")
    public String formularioAgregarCancion(@ModelAttribute("cancion") Cancion cancion) {
        return "agregarCancion.jsp";
    }
    

    @PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(@Valid @ModelAttribute("cancion") Cancion cancion,
                                        BindingResult validaciones) {
        
        if(validaciones.hasErrors()){
            return "agregarCancion.jsp";
        }else
        {
            this.servicioCanciones.agregarCancion(cancion);
            return "redirect:/canciones";
        }
        
        
    }
    

}