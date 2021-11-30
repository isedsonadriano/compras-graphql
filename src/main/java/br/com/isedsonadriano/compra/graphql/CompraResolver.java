package br.com.isedsonadriano.compra.graphql;

import br.com.isedsonadriano.cliente.domain.Cliente;
import br.com.isedsonadriano.cliente.service.ClienteService;
import br.com.isedsonadriano.compra.domain.Compra;
import br.com.isedsonadriano.produto.domain.Produto;
import br.com.isedsonadriano.produto.service.ProdutoService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompraResolver implements GraphQLResolver<Compra> {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    public String status (Compra c){
        return "teste: " + c.getStatus();
    }

    public Cliente cliente(Compra c){
        return clienteService.findCliente(c.getCliente().getId());
    }

    public Produto produto(Compra c){
        return produtoService.findById(c.getProduto().getId());
    }
}
