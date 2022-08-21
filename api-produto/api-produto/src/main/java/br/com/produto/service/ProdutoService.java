package br.com.produto.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.produto.constantes.Constantes;
import br.com.produto.dto.ProdutoDTO;
import br.com.produto.model.Produto;
import br.com.produto.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	public ResponseEntity<String> cadastrarPedido(ProdutoDTO produto) {
		try {
			Produto produtoMap = modelMapper.map(produto, Produto.class);
			produtoMap.setIdProduto(consultarTodosProdutos().size() + Constantes.UM);
			produtoMap.setNome(produto.getNome());
			produtoMap.setPreco(produto.getPreco());
			produtoMap.setQuantidadeEstoque(produto.getQuantidadeEstoque());
			produtoMap.setCategoria(produto.getCategoria());
			produtoRepository.save(produtoMap);
			return ResponseEntity.accepted().body(Constantes.PRODUTO_CADASTRADO);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(Constantes.ERRO_CADASTRO_PRODUTO);
		}
	}

	public List<ProdutoDTO> consultarTodosProdutos() {
		return modelMapper.map(produtoRepository.findAll(), new TypeToken<List<ProdutoDTO>>() {
		}.getType());
	}

	public ResponseEntity<String> deletarPedido(Integer idProduto) {
		try {
			produtoRepository.deleteByIdProduto(idProduto);
			return ResponseEntity.accepted().body(Constantes.PRODUTO_DELETADO);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(Constantes.ERRO_DELETAR_PRODUTO);
		}
	}

	public ResponseEntity<String> atualizarPedido(ProdutoDTO produtoDTO) {
		try {
			Optional<Produto> produto = produtoRepository.findByNome(produtoDTO.getNome());
			produto.get().setNome(produtoDTO.getNome());
			produto.get().setPreco(produtoDTO.getPreco());
			produto.get().setQuantidadeEstoque(produtoDTO.getQuantidadeEstoque());
			produto.get().setCategoria(produtoDTO.getCategoria());
			salvar(produto);
			return ResponseEntity.accepted().body(Constantes.PRODUTO_ATUALIZADO);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(Constantes.ERRO_DELETAR_PRODUTO);
		}
		
	}

	private void salvar(Optional<Produto> produto) {
		produtoRepository.save(produto.get());
	}

	public Optional<Produto> buscarProdutoPorNome(String nome) {
		try {
			return produtoRepository.findByNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
