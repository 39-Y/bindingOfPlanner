package com.y39.bindingofplanner.action.service;

import com.y39.bindingofplanner.action.dto.ActionReqDto;
import com.y39.bindingofplanner.action.entity.Action;
import com.y39.bindingofplanner.action.repository.ActionRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class ActionServiceTest {
    @Autowired
    ActionService actionService;
    @Autowired
    ActionRepository actionRepository;

    @DisplayName("Action 생성 테스트")
    @Test
    @Transactional
    void saveAction(){
        ActionReqDto actionReqDto = ActionReqDto.builder()
                .title("테스트 액션")
                .content("테스트 액션 내용")
                .build();
        long id = actionService.create(actionReqDto).getId();

        Action action = actionService.findActionById(id);

        assertThat(action.getTitle()).isEqualTo("테스트 액션");
        assertThat(action.getContent()).isEqualTo("테스트 액션 내용");
    }

    @DisplayName("Action List")
    @Test
    @Transactional
    void findActions(){
        assertThat(actionService.findActions().size()).isEqualTo(9);
    }

}