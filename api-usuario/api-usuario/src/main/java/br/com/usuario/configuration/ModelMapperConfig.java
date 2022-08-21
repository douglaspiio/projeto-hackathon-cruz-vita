package br.com.usuario.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.usuario.dto.UsuarioDTO;
import br.com.usuario.model.Usuario;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.createTypeMap(Usuario.class, UsuarioDTO.class);
		modelMapper.validate();
		return modelMapper;
	}

}
