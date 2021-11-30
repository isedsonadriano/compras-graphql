package br.com.isedsonadriano.produto.service;

import br.com.isedsonadriano.produto.domain.Produto;
import br.com.isedsonadriano.produto.external.ProdutoInput;
import br.com.isedsonadriano.produto.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto findById(Long id){
        return this.produtoRepository.findById(id).orElse(null);
    }

    public List<Produto> findAll(){
        return this.produtoRepository.findAll();
    }

    @Transactional
    public Produto save(Produto produto){
        return this.produtoRepository.save(produto);
    }

    @Transactional
    public Boolean deleteProduto(Long id){
        Produto p = this.produtoRepository.findById(id).orElseThrow(() -> new IllegalStateException("Produto inválido"));
        this.produtoRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
