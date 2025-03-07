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

import com.mathewsalv.canciones.models.Artista;
import com.mathewsalv.canciones.services.ServicioArtistas;

import jakarta.validation.Valid;




@Controller
public class ControladorArtistas {

    @Autowired
    private ServicioArtistas servicioArtistas;

    @GetMapping("/artistas")
    public String desplegarArtistas(Model model) {
        List<Artista> listaArtista = servicioArtistas.obtenerTodosLosArtistas();
        model.addAttribute("listaArtista", listaArtista);
        return "artistas.jsp";
    }

    @GetMapping("/artistas/detalle/{idArtista}")
    public String desplegarDetalleArtista(@PathVariable("idArtista") Long id, Model model) {
        Artista artista = servicioArtistas.obtenerArtistaPorId(id);
        model.addAttribute("artista", artista);
        return "detalleArtista.jsp";
    }
    
    @GetMapping("/artistas/formulario/agregar")
    public String formularioAgregarArtista(@ModelAttribute("artista") Artista artista) {
        return "agregarArtista.jsp";
    }
    
    @PostMapping("/artistas/procesa/agregar")
    public String procesarAgregarArtista(@Valid @ModelAttribute("artista") Artista artista,
                                        BindingResult validaciones) {
        
        if(validaciones.hasErrors()){
            return "agregarArtista.jsp";
        }else
        {
            this.servicioArtistas.agregarArtista(artista);
            return "redirect:/artistas";
        }
        
        
    }
}
