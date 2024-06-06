package com.y39.bindingofplanner.action.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/action")
public class ActionController {
    @GetMapping("/hi")
    public String getHi(){
        return "hi";
    }

}
