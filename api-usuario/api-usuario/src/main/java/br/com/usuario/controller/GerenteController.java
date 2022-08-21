package br.com.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.usuario.dto.PedidoDTO;
import br.com.usuario.dto.ProdutoDTO;
import br.com.usuario.dto.UsuarioDTO;
import br.com.usuario.model.Pedido;
import br.com.usuario.model.Status;
import br.com.usuario.service.GerenteService;

@RestController
public class GerenteController {
	
	@Autowired
	private GerenteService gerenteService;
	
	@PostMapping("/gerente/usuario/cadastrarUsuarios/")
	public void cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		gerenteService.cadastrarUsuario(usuarioDTO);
	}
	
	@GetMapping(path = "/gerente/usuario/buscarUsuarios/")
	public List<UsuarioDTO> buscarUsuarios() {
		return gerenteService.consultarTodosUsuarios();
	}
	
	@DeleteMapping(path = "/gerente/usuario/deletarUsuario/{idUsuario}")
	public void deletarUsuario(@PathVariable Integer idUsuario) {
		gerenteService.deletarUsuario(idUsuario);
	}
	
	@PatchMapping(path = "/gerente/usuario/atualizarUsuario/")
	public void atualizarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		gerenteService.atualizarUsuario(usuarioDTO);
	}
	
	@PostMapping("/gerente/pedido/cadastro")
	public void cadastrarPedido(@RequestBody PedidoDTO pedidoDTO) {
		gerenteService.cadastrarPedido(pedidoDTO);
	}
	
	@GetMapping(path = "/gerente/pedido/todosPedidos")
	public List<Pedido> buscarPedidos() {
		return gerenteService.consultarPedidos();
	}
	
	@GetMapping(path = "/gerente/pedidoPorId/{idPedido}")
	public Pedido buscarPedidoPorIdPedido(@PathVariable Integer idPedido) {
		return gerenteService.consultarPedidoPorId(idPedido);
	}
	
	@GetMapping(path = "/gerente/pedidoPorStatus/{status}")
	public Pedido buscarPedidoPorStatus(@PathVariable Status status) {
		return gerenteService.consultarPedidoPorStatus(status);
	}
	
	@GetMapping(path = "/gerente/pedidoPorUsuario/{usuario}")
	public Pedido buscarPedidoPorUsuario(@PathVariable String usuario) {
		return gerenteService.consultarPedidoPorUsuario(usuario);
	}
	
	@DeleteMapping(path = "/gerente/pedido/{idPedido}")
	public void deletarPedido(@PathVariable Integer idPedido) {
		gerenteService.deletarPedido(idPedido);
	}
	
	@PatchMapping(path = "/gerente/pedido/")
	public void alterarPedido(@RequestBody PedidoDTO pedidoDTO) {
		gerenteService.alterarPedido(pedidoDTO);
	}
	
	@PutMapping(path = "/gerente/pedido/status/{status}/{usuario}")
	public void alterarStatusPedido(@PathVariable Status status, @PathVariable String usuario) {
		gerenteService.alterarStatusPedido(status,usuario);
	}
	
	@PostMapping(path = "/gerente/produto/cadastrar/")
	public void cadastrarProduto(@RequestBody ProdutoDTO produtoDTO) {
		gerenteService.cadastrarProduto(produtoDTO);
	}
	
	@DeleteMapping(path = "/gerente/produto/deletar/{idProduto}")
	public void deletarProduto(@PathVariable Integer idProduto) {
		gerenteService.deletarProduto(idProduto);
	}
	
	@PatchMapping(path = "/gerente/produto/atualizarProduto/")
	public void atualizarProduto(@RequestBody ProdutoDTO produtoDTO) {
		gerenteService.atualizarProduto(produtoDTO);
	}
	
	@GetMapping(path = "/gerente/produto/buscarProdutos/")
	public List<ProdutoDTO> buscarProdutos() {
		return gerenteService.consultarTodosProdutos();
	}

}
