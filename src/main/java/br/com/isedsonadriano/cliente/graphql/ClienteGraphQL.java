package br.com.isedsonadriano.cliente.graphql;

import br.com.isedsonadriano.cliente.domain.Cliente;
import br.com.isedsonadriano.cliente.external.ClienteInput;
import br.com.isedsonadriano.cliente.service.ClienteService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class ClienteGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

	@Autowired
	private ClienteService clienteService;

	public Cliente cliente(Long id){
		return this.clienteService.findCliente(id);
	}

	public List<Cliente> clientes(){
		return this.clienteService.findAll();
	}

	@Transactional
	public Cliente saveCliente(ClienteInput clientInput){
		ModelMapper m = new ModelMapper();
		Cliente c  = m.map(clientInput, Cliente.class);
		return this.clienteService.saveCliente(c);
	}

	@Transactional
	public Boolean deleteCliente(Long id){
		this.clienteService.deleteCliente(id);
		return Boolean.TRUE;
	}
}

