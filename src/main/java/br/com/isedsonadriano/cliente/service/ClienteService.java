package br.com.isedsonadriano.cliente.service;

import br.com.isedsonadriano.cliente.domain.Cliente;
import br.com.isedsonadriano.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public Cliente findCliente(Long id) {
        return this.clienteRepository.findById(id).orElse(null);
    }

    @Cacheable("clientes")
    public List<Cliente> findAll() {
        return this.clienteRepository.findAll();
    }

    @Transactional
    @CacheEvict
    public Cliente saveCliente(Cliente c) {
        return this.clienteRepository.save(c);
    }

    @Transactional
    public void deleteCliente(Long id) {
        Cliente c = this.clienteRepository.findById(id).orElseThrow(() -> new IllegalStateException("Cliente inválido"));
        this.clienteRepository.deleteById(id);
    }
}
