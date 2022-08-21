package br.com.pedido.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import br.com.pedido.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {
	
	private String usuario;
	private Integer idPedido;
	private List<ProdutoDTO> produtos;
	private Integer quantidadeItens;
	private LocalDateTime dataRegistrada;
	private BigDecimal total;
	private Status status;

}
