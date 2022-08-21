package br.com.produto.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.produto.model.Produto;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, String>{

	void deleteByIdProduto(Integer idProduto);

	Optional<Produto> findByNome(String nome);

}
