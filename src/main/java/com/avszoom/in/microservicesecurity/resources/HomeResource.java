package com.avszoom.in.microservicesecurity.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @GetMapping("/")
    public String getHomePage(){
        return "<h1>Spring security taking over.....</h1>";
    }
}
