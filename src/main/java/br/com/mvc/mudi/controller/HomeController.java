package br.com.mvc.mudi.controller;

import br.com.mvc.mudi.model.StatusPedido;
import br.com.mvc.mudi.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public String home(Model model) {
        PageRequest pageRequest = PageRequest.of(0, 5, Sort.Direction.valueOf("DESC"), "dataDaEntrega");
        model.addAttribute("pedidos", pedidoService.findByStatusAndSort(StatusPedido.ENTREGUE, pageRequest));
        String value = "home";
        model.addAttribute("activeMenu", value);
        return "home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
        return "redirect:/home";
    }
}
