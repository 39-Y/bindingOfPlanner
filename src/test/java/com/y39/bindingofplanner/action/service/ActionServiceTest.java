package com.y39.bindingofplanner.action.service;

import com.y39.bindingofplanner.action.dto.ActionCacheDto;
import com.y39.bindingofplanner.action.dto.ActionReqDto;
import com.y39.bindingofplanner.action.dto.ActionResDto;
import com.y39.bindingofplanner.action.entity.Action;
import com.y39.bindingofplanner.action.repository.ActionRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
class ActionServiceTest {
    @Mock
    private ActionRepository actionRepository;
    @InjectMocks
    private ActionService actionService;

    Action action1 = Action.builder()
            .id(1L)
            .title("Title 1")
            .content("Content 1")
            .planDate(LocalDateTime.of(2025, 1, 1, 0, 0))
            .build();
    Action action2 = Action.builder()
            .id(2L)
            .title("Title 2")
            .content("Content 2")
            .planDate(LocalDateTime.of(2025, 1, 1, 0, 0))
            .build();
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        List<Action> actions = Arrays.asList(
                action1, action2
        );
        when(actionRepository.findAll()).thenReturn(actions);
        when(actionRepository.saveAll(actions)).thenReturn(actions);
    }

    @DisplayName("Action 생성 테스트")
    @Test
    @Transactional
    void saveAction(){
        when(actionRepository
                .save(any()))
                .thenReturn(action1);
        ActionReqDto actionReqDto = ActionReqDto.builder()
                .title("Title 1")
                .content("Content 1")
                .build();
        Action action = actionService.create(actionReqDto);

        assertThat(action.getTitle()).isEqualTo("Title 1");
        assertThat(action.getContent()).isEqualTo("Content 1");
    }

    @Test
    void findActions() {
        // when
        List<ActionResDto> result = actionService.findActions();

        // then
        assertThat(result).isNotEmpty();
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getTitle()).isEqualTo("Title 1");

    }

    @Test
    void findActionById() {
        // when
        when(actionRepository.findById(any())).thenReturn(Optional.ofNullable(action1));
        Action result = actionService.findActionById(1L);

        // then
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getTitle()).isEqualTo("Title 1");
    }

    @Test
    void saveActionCache() {
        List<Action> actions = Arrays.asList(action1);
        // given
        ActionCacheDto actionCacheDto = ActionCacheDto.builder()
                .insert(Arrays.asList(ActionReqDto.builder().build()))
                .update(Arrays.asList(ActionReqDto.builder().build()))
                .delete(Arrays.asList(ActionReqDto.builder().build()))
                .build();



        doNothing().when(actionRepository).deleteAllById(actions.stream().map(Action::getId).toList());
        when(actionRepository.findAllById(anyList())).thenReturn(Arrays.asList(action1));

        // when
        int result = actionService.saveActionCache(actionCacheDto);

        // then
        assertThat(result).isEqualTo(3);
        verify(actionRepository, times(2)).saveAll(anyList());
        verify(actionRepository, times(1)).deleteAllById(anyList());
        verify(actionRepository, times(1)).findAllById(anyList());
    }

    @Test
    void saveAllActionByCache() {
        // given
        ActionReqDto actionReqDto3 = ActionReqDto.builder()
                .title("Title 3")
                .content("Content 3")
                .planDate(LocalDateTime.of(2025, 1, 1, 0, 0))
                .build();
        ActionCacheDto actionCacheDto = ActionCacheDto.builder().insert(Arrays.asList(actionReqDto3)).build();

        // when
        int result = actionService.saveAllActionByCache(actionCacheDto);

        // then
        assertThat(result).isEqualTo(1);
        verify(actionRepository, times(1)).saveAll(anyList());
    }

    @Test
    void deleteAllActionByCache() {
        // given
        ActionCacheDto actionCacheDto = ActionCacheDto.builder().delete(Arrays.asList(ActionReqDto.builder().id(2L).build())).build();

        // when
        int result = actionService.deleteAllActionByCache(actionCacheDto);

        // then
        assertThat(result).isEqualTo(1);
        verify(actionRepository, times(1)).deleteAllById(anyList());
    }

    @Test
    void updateAllActionByCache() {
        // given
        ActionReqDto updateActionReqDto1 = ActionReqDto.builder()
                .title("Update")
                .id(2L)
                .content("Updated Content")
                .planDate(LocalDateTime.now())
                .build();

        ActionCacheDto actionCacheDto = ActionCacheDto.builder().update(Arrays.asList(updateActionReqDto1)).build();

        when(actionRepository.findById(2L)).thenReturn(Optional.ofNullable(updateActionReqDto1.toEntity()));
        when(actionRepository.findAllById(Arrays.asList(2L))).thenReturn(Arrays.asList(action1));

        // when
        int result = actionService.updateAllActionByCache(actionCacheDto);
        Action resultAction = actionRepository.findById(2L).orElse(Action.builder().build());

        // then
        assertThat(result).isEqualTo(1);
        assertThat(resultAction.getTitle()).isEqualTo("Update");
        assertThat(resultAction.getContent()).isEqualTo("Updated Content");
        verify(actionRepository, times(1)).findAllById(anyList());
        verify(actionRepository, times(1)).saveAll(anyList());
    }

}