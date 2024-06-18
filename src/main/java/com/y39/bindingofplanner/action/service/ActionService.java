package com.y39.bindingofplanner.action.service;

import com.y39.bindingofplanner.action.dto.ActionReqDto;
import com.y39.bindingofplanner.action.dto.ActionResDto;
import com.y39.bindingofplanner.action.entity.Action;
import com.y39.bindingofplanner.action.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActionService {
    private final ActionRepository actionRepository;
    private final ActionRelationRepository actionRelationRepository;
    private final ActionStackHistoryRepository actionStackHistoryRepository;
    private final ActionTagRepository actionTagRepository;
    private final TagRepository tagRepository;

    public Action create(ActionReqDto actionReqDto){
        Action action = actionReqDto.toEntity();
        return actionRepository.save(action);
    }


    public List<ActionResDto> findActions(){
        System.out.println(actionRepository.findAll() == null);
        List<Action> actions = actionRepository.findAll();
        System.out.println(actions);
        return actions
                .stream()
                .map(Action::toResDto)
                .collect(Collectors.toList());
    }
    public Action findActionById(Long id){
        return actionRepository.findById(id).orElse(null);
    }
}
