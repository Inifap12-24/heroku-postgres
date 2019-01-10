package com.example.resource;

import com.example.domain.ClimData;
import com.example.service.ClimDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/climDataService")
public class ClimDataResource {

    private final ClimDataService service;

    @Autowired
    public ClimDataResource(ClimDataService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<ClimData> getAll() {
        return service.getAll();
    }
    
    @GetMapping("/url")
    public String getUrl() {
        return System.getenv("HEROKU_POSTGRESQL_AMBER_URL");
    }

    @PostMapping
    public void save() {
        for (int i = 0; i < 1000; i++) {
            service.save();
        }
    }

}
