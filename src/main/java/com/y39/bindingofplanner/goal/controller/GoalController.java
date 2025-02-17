package com.y39.bindingofplanner.goal.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.y39.bindingofplanner.action.dto.ActionCacheDto;
import com.y39.bindingofplanner.common.util.ResponseResult;
import com.y39.bindingofplanner.goal.service.GoalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/action")
@RequiredArgsConstructor
@Log4j2
public class GoalController {
    private final GoalService goalService;
    private final ObjectMapper objectMapper;

    @CrossOrigin(origins = "*")
    @GetMapping("/list")
    public String getActionList(){
        return ResponseResult.builder(objectMapper).data(goalService.findActions()).build().mapper();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public String getAction(@PathVariable Long id){
        return ResponseResult.builder(objectMapper).data(goalService.findActionById(id)).build().mapper();

    }

    @CrossOrigin(origins = "*")
    @PostMapping("/list")
    public String saveActionList(@RequestBody ActionCacheDto actionCacheDto) throws JsonProcessingException {
        return ResponseResult.builder(objectMapper).result(goalService.saveActionCache(actionCacheDto)).build().mapper();

    }


}
