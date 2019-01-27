package com.letsgo.todisplay;

import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import com.letsgo.todisplay.model.DataLayout;
import com.letsgo.todisplay.model.LayoutTpl;

@Configuration
public class GlobalRepositoryRestConfigurer extends RepositoryRestConfigurerAdapter {
	private static final Logger logger = Logger.getLogger(GlobalRepositoryRestConfigurer.class);

	@Autowired
	private EntityManager entityManager;

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration repositoryRestConfiguration) {
		logger.debug(String.format("configureRepositoryRestConfiguration init %s", repositoryRestConfiguration));
		repositoryRestConfiguration.exposeIdsFor(LayoutTpl.class, DataLayout.class);
		repositoryRestConfiguration.getCorsRegistry().addMapping("/**").allowedOrigins("http://localhost:4200")
				.allowedHeaders("*").allowedMethods("OPTIONS", "HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");

		// Permet d'avoir l'Id de l'entité à chaque réponse
		repositoryRestConfiguration.exposeIdsFor(entityManager.getMetamodel().getEntities().stream()
				.map(e -> e.getJavaType()).collect(Collectors.toList()).toArray(new Class[0]));
	}

}
