package br.com.rfasioli.demomongoconn.pgsql;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntidadeRepository extends CrudRepository<Entidade, UUID> {
}