package com.claro.miclaro.cuenta.prepago.config;

import java.io.IOException;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

public class YamlFileApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
	
	@Override
	    public void initialize(ConfigurableApplicationContext applicationContext){
	        try {
//	            Resource resource = applicationContext.getResource("file:C:/SOA/properties/microservices-cuenta-prepago/application.yml");
	        	Resource resource = applicationContext.getResource("application.yml");
	            YamlPropertySourceLoader sourceLoader = new YamlPropertySourceLoader();
	            PropertySource<?> localizationProperties = sourceLoader.load("application", resource, null);	            
	            applicationContext.getEnvironment().getPropertySources().addLast(localizationProperties);
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
	    }
}
