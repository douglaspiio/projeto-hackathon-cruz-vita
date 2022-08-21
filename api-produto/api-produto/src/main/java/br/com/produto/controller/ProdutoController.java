package br.com.produto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.produto.dto.ProdutoDTO;
import br.com.produto.model.Produto;
import br.com.produto.service.ProdutoService;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping("/cadastrarProdutos/")
	public void cadastrarPedido(@RequestBody ProdutoDTO produtoDTO) {
		produtoService.cadastrarPedido(produtoDTO);
	}
	
	@GetMapping(path = "/buscarProdutos/")
	public List<ProdutoDTO> buscarProdutos() {
		return produtoService.consultarTodosProdutos();
	}
	
	@DeleteMapping(path = "/deletarProdutos/{idProduto}")
	public void deletarPedido(@PathVariable Integer idProduto) {
		produtoService.deletarPedido(idProduto);
	}
	
	@PatchMapping(path = "/atualizarProduto/")
	public void atualizarPedido(@RequestBody ProdutoDTO produtoDTO) {
		produtoService.atualizarPedido(produtoDTO);
	}
	
	@GetMapping(path = "/buscarProdutosPorNome/{nome}")
	public Produto buscarProdutoPorNome(@PathVariable String nome) {
		return produtoService.buscarProdutoPorNome(nome).get();
		
	}
	

}
