package com.y39.bindingofplanner.action.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.y39.bindingofplanner.action.service.ActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/action")
@RequiredArgsConstructor
public class ActionController {
    private final ObjectMapper objectMapper;
    private final ActionService actionService;
    @CrossOrigin(origins = "*")
    @GetMapping("/hi")
    public String getHi(){
        return "hi";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/list")
    public String getActionList() throws JsonProcessingException {
        return objectMapper.writeValueAsString(actionService.findActions());
    }




}
