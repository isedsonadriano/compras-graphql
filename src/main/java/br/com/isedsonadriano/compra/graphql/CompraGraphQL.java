package br.com.isedsonadriano.compra.graphql;

import br.com.isedsonadriano.cliente.domain.Cliente;
import br.com.isedsonadriano.cliente.external.ClienteInput;
import br.com.isedsonadriano.cliente.service.ClienteService;
import br.com.isedsonadriano.compra.domain.Compra;
import br.com.isedsonadriano.compra.external.CompraInput;
import br.com.isedsonadriano.compra.service.CompraService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class CompraGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

	@Autowired
	private CompraService compraService;

	public Compra compra(Long id){
		return this.compraService.findCompra(id);
	}

	public List<Compra> compras(int page, int size){
		Pageable pageable = PageRequest.of(page, size, Sort.by("quantidade").ascending());
		return this.compraService.findAll(pageable);
	}

	@Transactional
	public Compra saveCompra(CompraInput compraInput){
		ModelMapper m = new ModelMapper();
		Compra c  = m.map(compraInput, Compra.class);
		return this.compraService.saveCompra(c);
	}

	@Transactional
	public Boolean deleteCompra(Long id){
		this.compraService.deleteCompra(id);
		return Boolean.TRUE;
	}
}

