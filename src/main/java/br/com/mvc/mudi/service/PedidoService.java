package br.com.mvc.mudi.service;

import br.com.mvc.mudi.model.Pedido;
import br.com.mvc.mudi.model.StatusPedido;
import br.com.mvc.mudi.model.User;
import br.com.mvc.mudi.repository.PedidoRepository;
import br.com.mvc.mudi.service.exceptions.PedidoNotFoundException;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepo;

    public Pedido getById(Long id) {
        return pedidoRepo.getById(id);
    }

    public List<Pedido> findAllByUser(User user) {
        return pedidoRepo.findAllByUser(user);
    }

    public List<Pedido> findAll() {
        return pedidoRepo.findAll();
    }

    public void save(Pedido pedido) {
        pedidoRepo.save(pedido);
    }

    public Page<Pedido> findByStatusAndSort(StatusPedido status, Pageable pageable) {
        return pedidoRepo.findAllByStatus(status, pageable);
    }

    public List<Pedido> findAllByStatusAndUser(StatusPedido status, User user) {
        return pedidoRepo.findAllByStatusAndUser(status, user);
    }
}
