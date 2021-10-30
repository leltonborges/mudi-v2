package br.com.mvc.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/ofertas")
public class OfertaController {

    @GetMapping
    public String getFormOfertas(Model model){
        String value = "ofertas";
        model.addAttribute("activeMenu", value);
        return  "/oferta/home";
    }
}
