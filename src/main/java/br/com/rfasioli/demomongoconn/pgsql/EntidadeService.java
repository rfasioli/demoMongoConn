package br.com.rfasioli.demomongoconn.pgsql;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import br.com.rfasioli.demomongoconn.BasicTestUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EntidadeService implements BasicTestUseCase<Entidade> {
    private static final Logger LOGGER = LoggerFactory.getLogger(EntidadeService.class);

    private final EntidadeRepository repo;

    public EntidadeService(final EntidadeRepository repo) {
        this.repo = repo;
    }

    @Override
    public Entidade save(final Entidade source) {
        LOGGER.debug(String.format("save(source={%s})", source));
        Entidade obj = this.repo.save(source);
        return obj;
    }

    @Override
    public List<Entidade> find() {
        LOGGER.debug("find()");
        Iterable<Entidade> result = this.repo.findAll();
        return StreamSupport.stream(result.spliterator(), false).collect(Collectors.toList());
    }
}