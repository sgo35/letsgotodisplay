package com.letsgo.todisplay;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
@ComponentScan("com.letsgo.todisplay")
public class GlobalRepositoryRestConfiguration  implements WebMvcConfigurer {

    //@Override
//public void configureRepositoryRestConfiguration(RepositoryRestConfiguration repositoryRestConfiguration) {
//    repositoryRestConfiguration.exposeIdsFor(LayoutTpl.class, DataLayout.class);
//    repositoryRestConfiguration.setReturnBodyOnCreate(true);
//    repositoryRestConfiguration.setReturnBodyOnUpdate(true);
//    repositoryRestConfiguration.getCorsRegistry()
//        .addMapping("/**")
//        .allowedOrigins("*")
//        .allowedHeaders("*")
//        .allowedMethods("OPTIONS", "HEAD", "GET", "PUT", "POST", "DELETE", "PATCH")
//        ;
//}

}
