package br.com.pedido.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {
	
	private String nome;
	private String preco;
	private Integer quantidadeEstoque;
	private String categoria;
	private String status;

}
