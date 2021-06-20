package com.avszoom.in.microservicesecurity.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @GetMapping("/")
    public String getHomePage(){
        return "<h1>Welcome everyone.....</h1>";
    }

    @GetMapping("/admin")
    public String getAdminPage(){
        return "<h1>Welcome Admin.....</h1>";
    }

    @GetMapping("/user")
    public String getUserPage(){
        return "<h1>Welcome User.....</h1>";
    }
}
