package br.com.rfasioli.demomongoconn.mongo.reactive;

import java.util.List;

import br.com.rfasioli.demomongoconn.BasicTestUseCase;
import br.com.rfasioli.demomongoconn.mongo.Documento;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
// import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
// import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

// @Service
// @EnableReactiveMongoRepositories
public class ReativoService implements BasicTestUseCase<Documento> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReativoService.class);

    private final ReativoRepository repo;

    public ReativoService(final ReativoRepository repo) {
        this.repo = repo;
    }
    
    @Override
    public Documento save(final Documento source) {
        LOGGER.debug(String.format("save(source={%s}) - Do nothing with this!", source));
        return null;
    }

    @Override
    public List<Documento> find() {
        final Flux<Documento> result = repo.findAll(Example.of(new Documento(null, Documento.STATUS.PENDING)));
     
        result.subscribe(documento -> {
            LOGGER.info(String.format("find(Flux::subscribe=({%s}))", documento));
        });

        return null;
    }

}