package com.y39.bindingofplanner.action.service;

import com.y39.bindingofplanner.action.dto.ActionReqDto;
import com.y39.bindingofplanner.action.dto.ActionResDto;
import com.y39.bindingofplanner.action.entity.Action;
import com.y39.bindingofplanner.action.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActionService {
    private final ActionRepository actionRepository;
    private final ActionStackHistoryRepository actionStackHistoryRepository;
    private final ActionTagRepository actionTagRepository;

    public Action create(ActionReqDto actionReqDto){
        Action action = actionReqDto.toEntity();
        return actionRepository.save(action);
    }


    @Transactional
    public List<ActionResDto> findActions(){
        return actionRepository.findAll()
                .stream()
                .map(Action::toResDto)
                .collect(Collectors.toList());
    }
    public Action findActionById(Long id){
        return actionRepository.findById(id).orElse(null);
    }
}
