package br.com.usuario.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.usuario.model.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

	void deleteByIdUsuario(Integer idUsuario);

	Optional<Usuario> findByNome(String nome);

}
