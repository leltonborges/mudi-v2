package br.com.mvc.mudi.service;

import br.com.mvc.mudi.model.Pedido;
import br.com.mvc.mudi.model.StatusPedido;
import br.com.mvc.mudi.model.User;
import br.com.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepo;

    public List<Pedido> findAllByUser(User user) {
        return pedidoRepo.findAllByUser(user);
    }

    public List<Pedido> findAll() {
        return pedidoRepo.findAll();
    }

    public void save(Pedido pedido) {
        pedidoRepo.save(pedido);
    }

    public List<Pedido> findByStatus(StatusPedido status) {
        return pedidoRepo.findByStatus(status);
    }

    public List<Pedido> findAllByStatusAndUser(StatusPedido status, User user) {
        return pedidoRepo.findAllByStatusAndUser(status, user);
    }
}
