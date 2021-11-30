package br.com.isedsonadriano.compra.external;

import br.com.isedsonadriano.cliente.domain.Cliente;
import br.com.isedsonadriano.produto.domain.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraInput {

    private Long id;
    private Long produtoId;
    private Long clienteId;
    private String quantidade;
    private String status;
    private String data;

}
