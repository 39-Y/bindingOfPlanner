package com.y39.bindingofplanner.action.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.y39.bindingofplanner.action.dto.ActionCacheDto;
import com.y39.bindingofplanner.action.service.ActionService;
import com.y39.bindingofplanner.common.util.ResponseResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/action")
@RequiredArgsConstructor
@Log4j2
public class ActionController {
    private final ActionService actionService;

    @CrossOrigin(origins = "*")
    @GetMapping("/list")
    public String getActionList(){
        return ResponseResult.builder().data(actionService.findActions()).build().mapper();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public String getAction(@PathVariable Long id){
        return ResponseResult.builder().data(actionService.findActionById(id)).build().mapper();

    }

    @CrossOrigin(origins = "*")
    @PostMapping("/list")
    public String saveActionList(@RequestBody ActionCacheDto actionCacheDto) throws JsonProcessingException {
        return ResponseResult.builder().result(actionService.saveActionCache(actionCacheDto)).build().mapper();

    }


}
