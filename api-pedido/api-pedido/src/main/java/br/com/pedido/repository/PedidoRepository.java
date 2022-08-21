package br.com.pedido.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.pedido.model.Pedido;
import br.com.pedido.model.Status;

@Repository
public interface PedidoRepository extends MongoRepository<Pedido, String> {

	void deleteByIdPedido(Integer idPedido);

	Pedido findByIdPedido(Integer idPedido);

	Pedido findByStatus(Status status);

	Pedido findByUsuario(String usuario);


}
