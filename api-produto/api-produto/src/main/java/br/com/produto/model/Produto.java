package br.com.produto.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "Produto")
public class Produto {

	@Id
	private String id;
	private Integer idProduto;
	private String nome;
	private String preco;
	private Integer quantidadeEstoque;
	private String categoria;
}
