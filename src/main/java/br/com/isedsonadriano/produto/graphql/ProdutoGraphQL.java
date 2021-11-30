package br.com.isedsonadriano.produto.graphql;

import br.com.isedsonadriano.produto.domain.Produto;
import br.com.isedsonadriano.produto.external.ProdutoInput;
import br.com.isedsonadriano.produto.service.ProdutoService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class ProdutoGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ProdutoService produtoService;

    public Produto produto(Long id){
        return this.produtoService.findById(id);
    }

    public List<Produto> produtos(){
        return this.produtoService.findAll();
    }

    @Transactional
    public Produto saveProduto(ProdutoInput produtoInput){
        ModelMapper m = new ModelMapper();
        Produto p  = m.map(produtoInput, Produto.class);
        return this.produtoService.save(p);
    }

    @Transactional
    public Boolean deleteProduto(Long id){
        this.produtoService.deleteProduto(id);
        return Boolean.TRUE;
    }
}
