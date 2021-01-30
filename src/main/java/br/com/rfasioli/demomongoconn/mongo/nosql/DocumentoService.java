package br.com.rfasioli.demomongoconn.mongo.nosql;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import br.com.rfasioli.demomongoconn.BasicTestUseCase;
import br.com.rfasioli.demomongoconn.mongo.Documento;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DocumentoService implements BasicTestUseCase<Documento> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DocumentoService.class);

    private final DocumentoRepository repo;

    public DocumentoService(final DocumentoRepository repo) {
        this.repo = repo;
    }

    @Override
    public Documento save(Documento source) {
        LOGGER.debug(String.format("save(source={%s})", source));
        Documento obj = this.repo.save(source);
        return obj;
    }

    @Override
    public List<Documento> find() {
        LOGGER.debug("find()");
        Iterable<Documento> result = this.repo.findAll();
        return StreamSupport.stream(result.spliterator(), false).collect(Collectors.toList());
    }



}