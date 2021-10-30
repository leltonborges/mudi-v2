package br.com.mvc.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/oferta")
public class OfertaController {

    @GetMapping
    public String getFormOfertas(){
        return  "/oferta/home";
    }
}
