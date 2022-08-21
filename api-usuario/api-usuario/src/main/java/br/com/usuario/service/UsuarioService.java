package br.com.usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.usuario.client.ClientPedido;
import br.com.usuario.client.ClientProduto;
import br.com.usuario.dto.PedidoDTO;
import br.com.usuario.dto.ProdutoDTO;

@Service
public class UsuarioService {
	
	@Autowired
	private ClientPedido clientPedido;
	
	@Autowired
	private ClientProduto clientProduto;
	
	public void cadastrarPedido(PedidoDTO pedidoDTO) {
		try {
			clientPedido.cadastrarPedido(pedidoDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public List<ProdutoDTO> consultarTodosProdutos() {
		try {
			return clientProduto.buscarProdutos();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	public ProdutoDTO consultarProdutoPorNome(String nome) {
		try {
			return clientProduto.buscarProdutoPorNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
