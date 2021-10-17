package br.com.mvc.mudi.controller;

import br.com.mvc.mudi.model.StatusPedido;
import br.com.mvc.mudi.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public String home(Model model){
        model.addAttribute("pedidos", pedidoService.findAll());
        return "home";
    }
    @GetMapping("/{status}")
    public String porStatus(@PathVariable(value = "status") String status, Model model){
        model.addAttribute("pedidos",
                pedidoService.findByStatus(StatusPedido.valueOf(status.toUpperCase())));
        model.addAttribute("status", status);
        return "home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError(){
        return  "redirect:/home";
    }
}
