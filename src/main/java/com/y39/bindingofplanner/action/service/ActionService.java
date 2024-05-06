package com.y39.bindingofplanner.action.service;

import com.y39.bindingofplanner.action.entity.Action;
import com.y39.bindingofplanner.action.repository.*;
import org.springframework.stereotype.Service;

@Service
public class ActionService {
    private ActionRepository actionRepository;
    private ActionRelationRepository actionRelationRepository;
    private ActionStackHistoryRepository actionStackHistoryRepository;
    private ActionTagRepository actionTagRepository;
    private TagRepository tagRepository;

    public Action saveAction(Action action){
        return actionRepository.save(action);
    }
}
