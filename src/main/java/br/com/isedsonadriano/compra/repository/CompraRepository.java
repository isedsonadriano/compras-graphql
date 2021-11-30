package br.com.isedsonadriano.compra.repository;

import br.com.isedsonadriano.cliente.domain.Cliente;
import br.com.isedsonadriano.compra.domain.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

    List<Compra> findAllByCliente(Cliente cliente);
    List<Compra> findAllByClienteAndQuantidade(Cliente cliente, Integer quantidade);

    @Query("select c from Compra c where c.cliente = :cliente")
    List<Compra> findAllByClienteComQuery(@Param("cliente") Cliente c);

}
