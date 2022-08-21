package br.com.usuario.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import br.com.usuario.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PedidoDTO {
	
	private String usuario;
	private List<ProdutoDTO> produtos;
	private Integer quantidadeItens;
	private LocalDateTime dataRegistrada;
	private BigDecimal total;
	private Status status;

}
