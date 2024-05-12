package com.y39.bindingofplanner.action.service;

import com.y39.bindingofplanner.action.dto.ActionSaveDto;
import com.y39.bindingofplanner.action.entity.Action;
import com.y39.bindingofplanner.action.repository.ActionRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ActionServiceTest {
    @Autowired
    ActionService actionService;
    @Autowired
    ActionRepository actionRepository;

    @DisplayName("Action 생성 테스트")
    @Test
    @Transactional
    void saveAction(){
        ActionSaveDto actionSaveDto = ActionSaveDto.builder()
                .title("테스트 액션")
                .content("테스트 액션 내용")
                .doStartDate(LocalDateTime.now())
                .build();
        long id = actionService.saveAction(actionSaveDto).getId();

        Action action = actionService.findActionById(id);

        assertThat(action.getTitle()).isEqualTo("테스트 액션");
    }

}