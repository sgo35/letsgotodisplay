package com.letsgo.todisplay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

import com.letsgo.todisplay.model.DataLayout;
import com.letsgo.todisplay.model.LayoutTpl;
import com.letsgo.todisplay.repository.DataLayoutRepository;
import com.letsgo.todisplay.repository.LayoutTplRepository;

@SpringBootApplication
@EnableConfigurationProperties(WeatherAppProperties.class)
@EnableCaching(proxyTargetClass = true)
public class LetsgoDisplayApplication implements CommandLineRunner {
    
    @Autowired
    private LayoutTplRepository layoutTplRepository;
    
    @Autowired
    private DataLayoutRepository dataLayoutRepository;
    
    public static void main(String[] args) {
        SpringApplication.run(LetsgoDisplayApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LayoutTpl ltpl = new LayoutTpl(null, "weather", 100, 100);
        try {
            if (layoutTplRepository.save(ltpl) == null) {
                System.out.println("Instance LayoutTpl null ou déjà existante");
            } else {
                dataLayoutRepository.save(new DataLayout(null, ltpl, 1, 1));
            };
           
        } catch (Exception e) {
            System.err.println("ERROR Instance LayoutTpl : " + e);
        }
    }

}
