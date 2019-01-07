package com.letsgo.todisplay;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import com.letsgo.todisplay.model.DataLayout;
import com.letsgo.todisplay.model.LayoutTpl;

@Configuration
public class GlobalRepositoryRestConfigurer extends RepositoryRestConfigurerAdapter {
	 private static final Logger logger = Logger.getLogger(GlobalRepositoryRestConfigurer.class);
	 
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration repositoryRestConfiguration) {
    	logger.debug(String.format("configureRepositoryRestConfiguration init %s", repositoryRestConfiguration));
        repositoryRestConfiguration.exposeIdsFor(LayoutTpl.class, DataLayout.class);
        repositoryRestConfiguration.getCorsRegistry()
                .addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedHeaders("*")
                .allowedMethods("OPTIONS", "HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
    }

}
