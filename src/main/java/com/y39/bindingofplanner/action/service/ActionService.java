package com.y39.bindingofplanner.action.service;

import com.y39.bindingofplanner.action.dto.ActionSaveDto;
import com.y39.bindingofplanner.action.entity.Action;
import com.y39.bindingofplanner.action.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActionService {
    private final ActionRepository actionRepository;
    private final ActionRelationRepository actionRelationRepository;
    private final ActionStackHistoryRepository actionStackHistoryRepository;
    private final ActionTagRepository actionTagRepository;
    private final TagRepository tagRepository;

    public Action saveAction(ActionSaveDto actionSaveDto){
        Action action = Action.toEntity(actionSaveDto);
        return actionRepository.save(action);
    }

    public Action findActionById(Long id){
        return actionRepository.findById(id).orElse(null);
    }
}
