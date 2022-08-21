package br.com.pedido.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.pedido.dto.PedidoDTO;
import br.com.pedido.model.Pedido;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.createTypeMap(Pedido.class, PedidoDTO.class);
		modelMapper.validate();
		return modelMapper;
	}

}
