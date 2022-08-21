package br.com.usuario.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "Usuario")
public class Usuario {
	
	@Id
	private String id;
	private Integer idUsuario;
	private String nome;
	private String telefone;
	private String endereco;

}
