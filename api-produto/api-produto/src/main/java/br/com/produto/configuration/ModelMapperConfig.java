package br.com.produto.configuration;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.produto.dto.ProdutoDTO;
import br.com.produto.model.Produto;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.createTypeMap(Produto.class, ProdutoDTO.class);
		modelMapper.validate();
		return modelMapper;
	}

}
