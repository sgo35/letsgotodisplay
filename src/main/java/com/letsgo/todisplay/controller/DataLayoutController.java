package com.letsgo.todisplay.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letsgo.todisplay.model.DataLayout;
import com.letsgo.todisplay.repository.DataLayoutRepository;


//@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/api")
@RestController
public class DataLayoutController {
    
    private DataLayoutRepository repository;

    public DataLayoutController(DataLayoutRepository repository) {
        this.repository = repository;
    }
    
	@GetMapping("/data-layouts")
	public Iterable<DataLayout> getDataLayouts() {
		System.out.println("DataLayouts");
		return repository.findAll();
	}
	
//	   public HttpEntity<String> getDataLayouts() {
//	        // HttpHeaders
//	        HttpHeaders headers = new HttpHeaders();
//
//	        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
//	        // Request to return JSON format 
//	        headers.setContentType(MediaType.APPLICATION_JSON);
//
//	        HttpEntity<?> entity = new HttpEntity<>(headers);
//
//	        RestTemplate restTemplate = new RestTemplate();
//	        HttpEntity<String> result = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);
//
//	        System.out.println(result);
//	        return result;
//	}
}
