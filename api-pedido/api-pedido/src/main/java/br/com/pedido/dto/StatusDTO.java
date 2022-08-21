package br.com.pedido.dto;

import br.com.pedido.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusDTO {
	
	private Status status;
	private String usuario;

}
