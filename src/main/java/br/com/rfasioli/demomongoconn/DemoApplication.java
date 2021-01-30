package br.com.rfasioli.demomongoconn;

import java.util.List;
import java.util.UUID;

import br.com.rfasioli.demomongoconn.mongo.Documento;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import br.com.rfasioli.demomongoconn.mongo.nosql.DocumentoService;
import br.com.rfasioli.demomongoconn.pgsql.Entidade;
import br.com.rfasioli.demomongoconn.pgsql.EntidadeService;

@SpringBootApplication
public class DemoApplication {
	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		logger.info("main - processando entidade");
		runUseCase(context.getBean(EntidadeService.class), new Entidade(UUID.randomUUID(), "Teste Aplicação"));
		
		logger.info("main - processando documento");
		runUseCase(context.getBean(DocumentoService.class), new Documento("Teste Aplicação", Documento.STATUS.PENDING));

		// Reativo é incompatível com data mongo
		// logger.info("main - processando documento reativo");
		// runUseCase(context.getBean(ReativoService.class), null);

	}

	private static <T> void runUseCase(BasicTestUseCase<T> useCase, T source) {
		logger.debug(String.format("runUseCase - salvando %s", source));

		T result = useCase.save(source);

		logger.debug(String.format("runUseCase - salvo %s", result));


		final List<T> objs = useCase.find();

		objs.forEach(o ->
			logger.info(String.format("runUseCase - objecto recuperado %s", o)));
	}

}
