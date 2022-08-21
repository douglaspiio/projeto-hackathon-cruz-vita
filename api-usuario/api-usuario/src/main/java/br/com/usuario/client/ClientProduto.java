package br.com.usuario.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.usuario.dto.ProdutoDTO;

@FeignClient(value = "api-produto", url = "http://localhost:8081/produtos")
public interface ClientProduto {

	@PostMapping(path = "/cadastrarProdutos/")
	void cadastrarProdutos(@RequestBody ProdutoDTO produto);
	
	@DeleteMapping(path = "/deletarProdutos/{idProduto}")
	void deletarProdutos(@PathVariable Integer idProduto);

	@PatchMapping(path = "/atualizarProduto/")
	void atualizarProdutos(@RequestBody ProdutoDTO produtoDTO);

	@GetMapping(path = "/buscarProdutos/")
	List<ProdutoDTO>  buscarProdutos();

	@GetMapping(path = "/buscarProdutosPorNome/{nome}")
	ProdutoDTO buscarProdutoPorNome(@PathVariable String nome);
	
}
