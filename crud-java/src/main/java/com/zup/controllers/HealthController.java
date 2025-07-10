package com.zup.controllers;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    
    public Map<String, String> getHealth(){
        return Map.of(
            "status", "OK",
            "menssage", "Aplicação Saudável!"
        );
    }
}
