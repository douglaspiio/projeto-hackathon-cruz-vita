package br.com.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.usuario.dto.PedidoDTO;
import br.com.usuario.dto.ProdutoDTO;
import br.com.usuario.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/pedido/cadastroPedido")
	public void cadastrarPedido(@RequestBody PedidoDTO pedidoDTO) {
		usuarioService.cadastrarPedido(pedidoDTO);
	}
	
	@GetMapping(path = "/produto/buscarProdutos/")
	public List<ProdutoDTO> buscarProdutos() {
		return usuarioService.consultarTodosProdutos();
	}
	
	@GetMapping(path = "/produto/buscarProdutosPorNome/{nome}")
	public ProdutoDTO buscarProdutosPorNome(@PathVariable String nome) {
		return usuarioService.consultarProdutoPorNome(nome);
	}
	

}
