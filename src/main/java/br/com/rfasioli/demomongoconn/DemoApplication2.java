package br.com.rfasioli.demomongoconn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.rfasioli.demomongoconn.domain.SimpleDomain;


public class DemoApplication2 {
	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SimpleDomain simpleDomain = SimpleDomain.newBuilder().withId(1).build();
		logger.info(simpleDomain.toString());

		simpleDomain = SimpleDomain.newBuilder().withId(1234).withValue(765).build();
		logger.info(simpleDomain.toString());

		simpleDomain = SimpleDomain.newBuilder().withId(123456).build();
		logger.info(simpleDomain.toString());

		

	}

}
