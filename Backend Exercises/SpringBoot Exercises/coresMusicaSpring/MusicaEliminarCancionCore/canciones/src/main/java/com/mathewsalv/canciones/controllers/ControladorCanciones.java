package com.mathewsalv.canciones.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mathewsalv.canciones.models.Artista;
import com.mathewsalv.canciones.models.Cancion;
import com.mathewsalv.canciones.services.ServicioArtistas;
import com.mathewsalv.canciones.services.ServicioCanciones;

import jakarta.validation.Valid;






@Controller
public class ControladorCanciones {
    
    @Autowired
    private final ServicioCanciones servicioCanciones;

    @Autowired
    private final ServicioArtistas servicioArtistas;
    
    public ControladorCanciones(ServicioCanciones servicioCanciones, ServicioArtistas servicioArtistas){
        this.servicioCanciones = servicioCanciones;
        this.servicioArtistas = servicioArtistas;
    }

    @GetMapping("/canciones")
    public String desplegarCanciones(Model model){
        List<Cancion> listaCanciones = this.servicioCanciones.obtenerTodasLasCanciones();
        model.addAttribute("listaCanciones", listaCanciones);
        return "canciones.jsp";
    }

    @GetMapping("/canciones/detalle/{idCancion}")
    public String desplegarDetalleCancion(@PathVariable("idCancion") Long id, Model model) {
        Cancion cancion = servicioCanciones.obtenerCancionPorId(id);
        List<Artista> listaArtistas = servicioArtistas.obtenerTodosLosArtistas();
        model.addAttribute("cancion", cancion);
        model.addAttribute("listaArtistas", listaArtistas);
        return "detalleCancion.jsp";
    }
    

    @PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(@Valid @ModelAttribute("cancion") Cancion cancion,
                                        BindingResult validaciones,
                                        Model model) {
        
        if(validaciones.hasErrors()){
            return "agregarCancion.jsp";
        }else {

                this.servicioCanciones.agregarCancion(cancion);
                return "redirect:/canciones";
        }
        
        
    }

    @GetMapping("/canciones/formulario/editar/{idCancion}")
    public String formularioEditarCancion(@PathVariable Long idCancion, Model model) {
        Cancion cancion = servicioCanciones.obtenerCancionPorId(idCancion);
        List<Artista> listaArtistas = servicioArtistas.obtenerTodosLosArtistas();
        if (cancion != null) {
            model.addAttribute("cancion", cancion);        
            model.addAttribute("listaArtistas", listaArtistas);
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
    
    @DeleteMapping("/canciones/eliminar/{idCancion}")
    public String procesarEliminarCancion(@PathVariable("idCancion") Long idCancion){
        servicioCanciones.eliminaCancion(idCancion);
        return "redirect:/canciones";
    }

    @GetMapping("/canciones/formulario/agregar")
    public String formularioAgregarCancion(Model model, @ModelAttribute("cancion") Cancion cancion) {
        List<Artista> listaArtistas = servicioArtistas.obtenerTodosLosArtistas();
        model.addAttribute("listaArtistas", listaArtistas);
        return "agregarCancion.jsp";
}
    

}