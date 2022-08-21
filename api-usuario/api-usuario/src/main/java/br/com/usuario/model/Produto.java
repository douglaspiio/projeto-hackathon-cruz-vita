package br.com.usuario.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
	
	private Integer idProduto;
	private String nome;
	private String preco;
	private Integer quantidadeEstoque;
	private String categoria;

}
