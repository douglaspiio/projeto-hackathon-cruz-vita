package br.com.usuario.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.usuario.client.ClientPedido;
import br.com.usuario.client.ClientProduto;
import br.com.usuario.constantes.Constantes;
import br.com.usuario.dto.PedidoDTO;
import br.com.usuario.dto.ProdutoDTO;
import br.com.usuario.dto.UsuarioDTO;
import br.com.usuario.model.Pedido;
import br.com.usuario.model.Status;
import br.com.usuario.model.Usuario;
import br.com.usuario.repository.UsuarioRepository;

@Service
public class GerenteService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ClientProduto clientProduto;
	
	@Autowired
	private ClientPedido clientPedido;
	
	

	public ResponseEntity<String> cadastrarUsuario(UsuarioDTO usuario) {
		try {
			Usuario usuarioMap = modelMapper.map(usuario, Usuario.class);
			usuarioMap.setIdUsuario(consultarTodosUsuarios().size() + Constantes.UM);
			usuarioMap.setNome(usuario.getNome());
			usuarioMap.setEndereco(usuario.getEndereco());
			usuarioMap.setTelefone(usuario.getTelefone());
			usuarioRepository.save(usuarioMap);
			return ResponseEntity.accepted().body(Constantes.USUARIO_CADASTRADO);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(Constantes.ERRO_CADASTRO_USUARIO);
		}
	}

	public List<UsuarioDTO> consultarTodosUsuarios() {
		return modelMapper.map(usuarioRepository.findAll(), new TypeToken<List<UsuarioDTO>>() {
		}.getType());
	}

	public ResponseEntity<String> deletarUsuario(Integer idUsuario) {
		try {
			usuarioRepository.deleteByIdUsuario(idUsuario);
			return ResponseEntity.accepted().body(Constantes.USUARIO_DELETADO);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(Constantes.ERRO_DELETAR_USUARIO);
		}
	}

	public ResponseEntity<String> atualizarUsuario(UsuarioDTO usuarioDTO) {
		try {
			Optional<Usuario> usuario = usuarioRepository.findByNome(usuarioDTO.getNome());
			usuario.get().setNome(usuarioDTO.getNome());
			usuario.get().setEndereco(usuarioDTO.getEndereco());
			usuario.get().setTelefone(usuarioDTO.getTelefone());
			salvar(usuario);
			return ResponseEntity.accepted().body(Constantes.USUARIO_ATUALIZADO);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(Constantes.ERRO_ATUALIZAR_USUARIO);
		}
	}

	private void salvar(Optional<Usuario> usuario) {
		usuarioRepository.save(usuario.get());
	}

	public void cadastrarProduto(ProdutoDTO produtoDTO) {
		try {
			clientProduto.cadastrarProdutos(produtoDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deletarProduto(Integer idProduto) {
		try {
			clientProduto.deletarProdutos(idProduto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void atualizarProduto(ProdutoDTO produtoDTO) {
		try {
			clientProduto.atualizarProdutos(produtoDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void cadastrarPedido(PedidoDTO pedidoDTO) {
		try {
			clientPedido.cadastrarPedido(pedidoDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Pedido> consultarPedidos() {
		try {
			return clientPedido.buscarPedidos();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void deletarPedido(Integer idPedido) {
		try {
			clientPedido.deletarPedido(idPedido);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void alterarPedido(PedidoDTO pedidoDTO) {
		try {
			clientPedido.atualizarPedidos(pedidoDTO);
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

	public Pedido consultarPedidoPorId(Integer idPedido) {
		try {
			return clientPedido.buscarPedidoPorIdPedido(idPedido);
		} catch (Exception e) {
			e.printStackTrace();
			return new Pedido();
		}
	}

	public Pedido consultarPedidoPorStatus(Status status) {
		try {
			return clientPedido.buscarPedidoPorStatus(status);
		} catch (Exception e) {
			e.printStackTrace();
			return new Pedido();
		}
	}

	public Pedido consultarPedidoPorUsuario(String usuario) {
		try {
			return clientPedido.buscarPedidoPorUsuario(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			return new Pedido();
		}
	}

	public void alterarStatusPedido(Status status, String usuario) {
		try {
			 clientPedido.alterarStatusPedido(status, usuario);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}


}
