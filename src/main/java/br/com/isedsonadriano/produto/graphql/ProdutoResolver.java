package br.com.isedsonadriano.produto.graphql;

import br.com.isedsonadriano.produto.domain.Produto;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

@Component
public class ProdutoResolver implements GraphQLResolver<Produto> {

    public String valorReais(Produto produto){
        return "R$: " + produto.getValor();
    }
}
