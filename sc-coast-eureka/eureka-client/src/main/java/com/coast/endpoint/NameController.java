package com.coast.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {

    @GetMapping("/name/show")
    public String show(){
        return "dengmeijing";
    }
}
