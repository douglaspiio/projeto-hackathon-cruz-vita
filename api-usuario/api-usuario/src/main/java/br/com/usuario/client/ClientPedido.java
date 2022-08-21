package br.com.usuario.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.usuario.dto.PedidoDTO;
import br.com.usuario.model.Pedido;
import br.com.usuario.model.Status;

@FeignClient(value = "api-pedido", url = "http://localhost:8080")
public interface ClientPedido {
	
	@PostMapping(path = "/cadastro")
	void cadastrarPedido(@RequestBody PedidoDTO pedidoDTO);
	
	@GetMapping(path = "/gerente/pedidos")
	public List<Pedido> buscarPedidos();
	
	@DeleteMapping(path = "/gerente/pedido/{idPedido}")
	void deletarPedido(@PathVariable Integer idPedido);

	@PatchMapping(path = "/gerente/atualizarProduto/")
	void atualizarPedidos(@RequestBody PedidoDTO pedidoDTO);
	
	@GetMapping(path = "/gerente/pedidoPorId/{idPedido}")
	Pedido buscarPedidoPorIdPedido(@PathVariable Integer idPedido);
	
	@GetMapping(path = "/gerente/pedidoPorStatus/{status}")
	Pedido buscarPedidoPorStatus(@PathVariable Status status);
	
	@GetMapping(path = "/gerente/pedidoPorUsuario/{usuario}")
	Pedido buscarPedidoPorUsuario(@PathVariable String usuario);
	
	@PutMapping(path = "/gerente/pedido/status/{status}/{usuario}")
	 void alterarStatusPedido(@PathVariable Status status, @PathVariable String usuario);
}