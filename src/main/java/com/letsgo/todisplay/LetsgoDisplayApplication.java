package com.letsgo.todisplay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.letsgo.todisplay.model.DataLayout;
import com.letsgo.todisplay.model.LayoutTpl;
import com.letsgo.todisplay.repository.DataLayoutRepository;
import com.letsgo.todisplay.repository.LayoutTplRepository;

@SpringBootApplication
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
        LayoutTpl ltpl = new LayoutTpl("weather", 100, 100);
        layoutTplRepository.save(ltpl);
        dataLayoutRepository.save(new DataLayout(ltpl, 1, 1));
    }

}
