package com.letsgo.todisplay;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.letsgo.todisplay.city.City;
import com.letsgo.todisplay.city.CityService;
import com.letsgo.todisplay.country.Country;
import com.letsgo.todisplay.country.CountryService;
import com.letsgo.todisplay.model.DataLayout;
import com.letsgo.todisplay.model.LayoutTpl;
import com.letsgo.todisplay.repository.DataLayoutRepository;
import com.letsgo.todisplay.repository.LayoutTplRepository;

@SpringBootApplication
@EnableConfigurationProperties(WeatherAppProperties.class)
@EnableCaching(proxyTargetClass = true)
public class LetsgoDisplayApplication implements CommandLineRunner {
    
	@Bean
	public RestTemplate restTemplate() {
		RestTemplate rt = new RestTemplate();
//		rt.getMessageConverters()
//        .add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		return rt;
	}

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
    
//	@Bean
	CommandLineRunner runner(
			CityService cityService
			, CountryService  countryService) {
		return args -> {
			createCountryData(countryService);
			createCityData(cityService);
		};
	}

	private void createCityData(CityService cityService) {
		// read json and write to db
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<City>> typeReference = new TypeReference<List<City>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/data/city.list.json");
		try {
			List<City> cities = mapper.readValue(inputStream,typeReference);
			cityService.save(cities);
			System.out.println("Cities Saved!");
		} catch (IOException e){
			System.out.println("Unable to save cities: " + e.getMessage());
		}
	}

	private void createCountryData(CountryService countryService) {
		// read json and write to db
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Country>> typeReference = new TypeReference<List<Country>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/data/countries_fr.json");
		try {
			List<Country> countries = mapper.readValue(inputStream,typeReference);
			countryService.save(countries);
			System.out.println("Countries Saved!");
		} catch (IOException e){
			System.out.println("Unable to save countries: " + e.getMessage());
		}
	}
	
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                .allowedOrigins("http://localhost:4200")
//                .allowedHeaders("*")
//                .allowedMethods("OPTIONS", "HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
//            }
//        };
//    }

}
