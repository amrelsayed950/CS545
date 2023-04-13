package edu.miu.waa.lab5.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @GetMapping
    public String getAdmin(){
        return "Welcome to Admin";
    }
}
