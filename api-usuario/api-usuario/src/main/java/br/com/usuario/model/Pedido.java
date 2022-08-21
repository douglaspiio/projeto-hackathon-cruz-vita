package br.com.usuario.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pedido {
	
	private String usuario;
	private Integer idPedido;
	private List<Produto> produtos;
	private Integer quantidadeItens;
	private LocalDateTime dataRegistrada;
	private BigDecimal total;
	private Status status;
	
}