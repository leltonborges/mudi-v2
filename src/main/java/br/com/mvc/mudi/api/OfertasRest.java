package br.com.mvc.mudi.api;

import br.com.mvc.mudi.dto.RequesicaoNovaOferta;
import br.com.mvc.mudi.model.Oferta;
import br.com.mvc.mudi.model.Pedido;
import br.com.mvc.mudi.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public Oferta creaOferta(@RequestBody @Valid RequesicaoNovaOferta requesicaOferta) {
        Pedido pedido = pedidoService.getById(requesicaOferta.getPedidoId());
        Oferta nova = requesicaOferta.toOferta();
        nova.setPedido(pedido);
        pedido.getOfertas().add(nova);
        pedidoService.save(pedido);
        return nova;
    }
}
