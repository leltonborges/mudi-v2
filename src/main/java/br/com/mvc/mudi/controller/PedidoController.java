package br.com.mvc.mudi.controller;

import br.com.mvc.mudi.dto.RequisicaoNovoPedido;
import br.com.mvc.mudi.model.Pedido;
import br.com.mvc.mudi.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("formulario")
    public String formulario(RequisicaoNovoPedido requisicaoNovoPedido){
        return "pedido/formulario";
    }

    @RequestMapping(method =  RequestMethod.POST,value = "novo")
    public String salvarNovo(@Valid RequisicaoNovoPedido requisicaoNovoPedido, BindingResult result){
        Pedido pedido = requisicaoNovoPedido.toPedido();
        pedidoService.save(pedido);
        if(result.hasErrors()){
            return "pedido/formulario";
        }
        return "redirect:/home";
    }

}
