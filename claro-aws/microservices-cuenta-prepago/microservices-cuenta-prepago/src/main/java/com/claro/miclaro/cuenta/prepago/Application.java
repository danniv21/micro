package com.claro.miclaro.cuenta.prepago;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.claro.miclaro.cuenta.prepago.config.YamlFileApplicationContextInitializer;

@SpringBootApplication
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		logger.info("- APPLICATION STARTED -");
		new SpringApplicationBuilder(Application.class)
		.initializers(new YamlFileApplicationContextInitializer())
		.run(args);
	}

	/**
	 * @return the logger
	 */
	public static Logger getLogger() {
		return logger;
	}
}