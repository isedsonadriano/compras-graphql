package br.com.isedsonadriano.produto.repository;

import br.com.isedsonadriano.produto.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
