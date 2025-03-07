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
import org.springframework.web.bind.annotation.PutMapping;

import com.mathewsalv.canciones.models.Cancion;
import com.mathewsalv.canciones.services.ServicioCanciones;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;





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

    @GetMapping("/canciones/formulario/editar/{idCancion}")
    public String formularioEditarCancion(@PathVariable Long idCancion, Model model) {
        Cancion cancion = servicioCanciones.obtenerCancionPorId(idCancion);
        if (cancion != null) {
            model.addAttribute("cancion", cancion);
            return "editarCancion.jsp";
        } else {
            model.addAttribute("error", "La canción no fue encontrada.");
            return "redirect:/canciones";
        }
    }

    @PostMapping("/canciones/procesa/editar/{idCancion}")
    public String procesarEditarCancion(@PathVariable Long idCancion, 
                                        @Valid @ModelAttribute("cancion") Cancion cancion, 
                                        BindingResult valid, 
                                        Model model) {
        if (valid.hasErrors()) {
            return "editarCancion.jsp";
        }

        cancion.setId(idCancion);
        servicioCanciones.actualizaCancion(cancion);
        return "redirect:/canciones";
    }
    
    
    

}