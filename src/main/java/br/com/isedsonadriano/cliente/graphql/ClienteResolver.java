package br.com.isedsonadriano.cliente.graphql;

import br.com.isedsonadriano.cliente.domain.Cliente;
import br.com.isedsonadriano.cliente.service.ClienteService;
import br.com.isedsonadriano.compra.domain.Compra;
import br.com.isedsonadriano.compra.service.CompraService;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteResolver implements GraphQLResolver<Cliente> {


    @Autowired
    private CompraService compraService;

    public List<Compra> compras(Cliente cliente){
        return compraService.findAllByCliente(cliente);
    }

    public List<Compra> compras(Cliente cliente, Integer quantidade){
        return compraService.findAllByCliente(cliente, quantidade);
    }
}
