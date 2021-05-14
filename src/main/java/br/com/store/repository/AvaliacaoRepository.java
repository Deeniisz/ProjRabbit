package br.com.store.repository;

import br.com.store.model.Avaliacao;
import br.com.store.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoRepository extends MongoRepository<Avaliacao, String> {
}
