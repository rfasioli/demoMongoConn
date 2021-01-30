package br.com.rfasioli.demomongoconn.mongo.nosql;

import br.com.rfasioli.demomongoconn.mongo.Documento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoRepository extends MongoRepository<Documento, String> {
}