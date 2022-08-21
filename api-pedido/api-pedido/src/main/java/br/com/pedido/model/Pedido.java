package br.com.pedido.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import br.com.pedido.dto.ProdutoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Pedido")
public class Pedido {
	
	@Id
	private String id;
	private String usuario;
	private Integer idPedido;
	private List<ProdutoDTO> produtos;
	private Integer quantidadeItens;
	private LocalDateTime dataRegistrada;
	private BigDecimal total;
	private Status status;
	
}
