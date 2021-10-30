package br.com.mvc.mudi.repository;

import br.com.mvc.mudi.model.Pedido;
import br.com.mvc.mudi.model.StatusPedido;
import br.com.mvc.mudi.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Transactional(readOnly = true)
    public Page<Pedido> findAllByStatus(StatusPedido status, Pageable pageable);

    public List<Pedido> findAllByUser(User user);

    public List<Pedido> findAllByStatusAndUser(StatusPedido status, User user);
}
