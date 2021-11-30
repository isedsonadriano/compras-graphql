package br.com.isedsonadriano.compra.service;



import br.com.isedsonadriano.cliente.domain.Cliente;
import br.com.isedsonadriano.compra.domain.Compra;
import br.com.isedsonadriano.compra.repository.CompraRepository;
import br.com.isedsonadriano.infra.exceptions.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;


    public Compra findCompra(Long id) {
        return this.compraRepository.findById(id).orElse(null);
    }

    public List<Compra> findAll(Pageable pageable) {
        return this.compraRepository.findAll(pageable).getContent();
    }

    @Transactional
    public Compra saveCompra(Compra c) {
        System.out.println("quantidade" + c.getQuantidade());
        if(c.getQuantidade() > 100){
            throw new DomainException("Não é possível comprar essa quantidade");
        }
        return this.compraRepository.save(c);

    }

    @Transactional
    public void deleteCompra(Long id) {
        Compra c = this.compraRepository.findById(id).orElseThrow(() -> new IllegalStateException("Compra inválida"));
        this.compraRepository.deleteById(id);
    }

    public List<Compra> findAllByCliente(Cliente cliente){
        return this.compraRepository.findAllByClienteComQuery(cliente);
    }

    public List<Compra> findAllByCliente(Cliente cliente, Integer quantidade){
        return this.compraRepository.findAllByClienteAndQuantidade(cliente, quantidade);
    }
}
