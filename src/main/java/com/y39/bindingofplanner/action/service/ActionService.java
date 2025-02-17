package com.y39.bindingofplanner.action.service;

import com.y39.bindingofplanner.action.dto.ActionCacheDto;
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

    @Transactional
    public int saveActionCache(ActionCacheDto actionCacheDto) {
        int result = 0;

        try {
            result+= saveAllActionByCache(actionCacheDto);
            result+= deleteAllActionByCache(actionCacheDto);
            result+= updateAllActionByCache(actionCacheDto);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }

        return result;
    }

    @Transactional
    public int saveAllActionByCache(ActionCacheDto actionCache){
        List<Action> insertActions = actionCache.getInsert().stream().map(ActionReqDto::toEntity).toList();
        actionRepository.saveAll(insertActions);
        return insertActions.size();
    }
    @Transactional
    public int deleteAllActionByCache(ActionCacheDto actionCache) {
        List<Long> deleteIds = actionCache.getDelete().stream().map(ActionReqDto::getId).toList();
        actionRepository.deleteAllById(deleteIds);
        return deleteIds.size();
    }
    @Transactional
    public int updateAllActionByCache(ActionCacheDto actionCacheDto){
        List<ActionReqDto> updateDtos = actionCacheDto.getUpdate();
        List<Long> updateIds = updateDtos.stream().map(ActionReqDto::getId).toList();
        List<Action> updateActions = actionRepository.findAllById(updateIds);

        for(int i=0; i<updateActions.size(); i++){
            Action action = updateActions.get(i);
            action.setTitle(updateDtos.get(i).getTitle());
            action.setContent(updateDtos.get(i).getContent());
            action.setDoneDate(updateDtos.get(i).getDoneDate());
        }

        actionRepository.saveAll(updateActions);
        return updateActions.size();
    }
}
