package br.com.pedido.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pedido.dto.PedidoDTO;
import br.com.pedido.model.Pedido;
import br.com.pedido.model.Status;
import br.com.pedido.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public void cadastrarPedido(PedidoDTO pedidoDTO) {
		Pedido pedidoMap = modelMapper.map(pedidoDTO, Pedido.class);
		pedidoMap.setIdPedido(consultarPedidos().size() + 1);
		pedidoMap.setProdutos(pedidoDTO.getProdutos());
		pedidoMap.setQuantidadeItens(pedidoDTO.getQuantidadeItens());
		pedidoMap.setDataRegistrada(pedidoDTO.getDataRegistrada());
		pedidoMap.setTotal(pedidoDTO.getTotal());
		pedidoMap.setStatus(pedidoDTO.getStatus());
		pedidoRepository.save(pedidoMap);
	}

	public List<Pedido> consultarPedidos() {
		return pedidoRepository.findAll();
	}

	public void deletarPedido(Integer idPedido) {
		pedidoRepository.deleteByIdPedido(idPedido);
	}

	public void alterarPedido(PedidoDTO pedidoDTO) {
		return;
	}

	public Pedido consultarPedidoPorId(Integer idPedido) {
		return pedidoRepository.findByIdPedido(idPedido);
	}

	public Pedido consultarPedidoPorStatus(Status status) {
		return pedidoRepository.findByStatus(status);
	}

	public Pedido consultarPedidoPorUsuario(String usuario) {
		return pedidoRepository.findByUsuario(usuario);
	}

	public void alterarStatusPedido(Status status, String usuario) {
		Pedido usuarioBD = consultarPedidoPorUsuario(usuario);
		usuarioBD.setStatus(status);
		pedidoRepository.save(usuarioBD);
	}

}
