package br.com.produto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProdutoDTO {
	
	private String nome;
	private String preco;
	private Integer quantidadeEstoque;
	private String categoria;

}
