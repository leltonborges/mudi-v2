package br.com.mvc.mudi.controller;

import br.com.mvc.mudi.model.StatusPedido;
import br.com.mvc.mudi.model.User;
import br.com.mvc.mudi.service.PedidoService;
import br.com.mvc.mudi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {
    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private UserService userService;

    @GetMapping(value = "/pedidos")
    public String home(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("pedidos", pedidoService.findAllByUser(user));
        String value = "meus-pedidos";
        model.addAttribute("activeMenu", value);
        return "/usuario/home";
    }

    @GetMapping("/pedidos/{status}")
    public String porStatus(@PathVariable(value = "status") String status, Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("pedidos",
                pedidoService.findAllByStatusAndUser(StatusPedido.valueOf(status.toUpperCase()), user));
        model.addAttribute("status", status);
        String value = "meus-pedidos";
        model.addAttribute("activeMenu", value);
        return "/usuario/home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
        return "redirect:/usuario/home";
    }
}
