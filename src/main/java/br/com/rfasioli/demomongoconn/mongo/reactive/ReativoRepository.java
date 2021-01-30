package br.com.rfasioli.demomongoconn.mongo.reactive;

import br.com.rfasioli.demomongoconn.mongo.Documento;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReativoRepository extends ReactiveMongoRepository<Documento, String> {
}
