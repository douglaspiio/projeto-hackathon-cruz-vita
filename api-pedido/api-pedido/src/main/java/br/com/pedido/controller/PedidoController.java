package br.com.pedido.controller;

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

import br.com.pedido.dto.PedidoDTO;
import br.com.pedido.model.Pedido;
import br.com.pedido.model.Status;
import br.com.pedido.service.PedidoService;

@RestController
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping("/cadastro")
	public void cadastrarPedido(@RequestBody PedidoDTO pedidoDTO) {
		pedidoService.cadastrarPedido(pedidoDTO);
	}
	
	@GetMapping(path = "/gerente/pedidos")
	public List<Pedido> buscarPedidos() {
		return pedidoService.consultarPedidos();
	}
	
	@GetMapping(path = "/gerente/pedidoPorId/{idPedido}")
	public Pedido buscarPedidoPorIdPedido(@PathVariable Integer idPedido) {
		return pedidoService.consultarPedidoPorId(idPedido);
	}
	
	@GetMapping(path = "/gerente/pedidoPorStatus/{status}")
	public Pedido buscarPedidoPorStatus(@PathVariable Status status) {
		return pedidoService.consultarPedidoPorStatus(status);
	}
	
	@GetMapping(path = "/gerente/pedidoPorUsuario/{usuario}")
	public Pedido buscarPedidoPorUsuario(@PathVariable String usuario) {
		return pedidoService.consultarPedidoPorUsuario(usuario);
	}
	
	@DeleteMapping(path = "/gerente/pedido/{idPedido}")
	public void deletarPedido(@PathVariable Integer idPedido) {
		pedidoService.deletarPedido(idPedido);
	}
	
	@PatchMapping(path = "/gerente/pedido/")
	public void alterarPedido(@RequestBody PedidoDTO pedidoDTO) {
		pedidoService.alterarPedido(pedidoDTO);
	}
	
	@PutMapping(path = "/gerente/pedido/status/{status}/{usuario}")
	public void alterarStatusPedido(@PathVariable Status status, @PathVariable String usuario) {
		pedidoService.alterarStatusPedido(status, usuario);
	}

}
