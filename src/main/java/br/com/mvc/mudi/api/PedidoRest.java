package br.com.mvc.mudi.api;

import br.com.mvc.mudi.model.Pedido;
import br.com.mvc.mudi.model.StatusPedido;
import br.com.mvc.mudi.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/pedidos")
public class PedidoRest {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping(value = "/aguardando")
    public Page<Pedido> getPedidoAguardandoOfertas(){
        PageRequest pageRequest = PageRequest.of(0, 3, Sort.Direction.valueOf("DESC"), "id");
        Page<Pedido> pedidoPage = pedidoService.findByStatusAndSort(StatusPedido.AGUARDANDO, pageRequest);
        return pedidoPage;
    }
}
