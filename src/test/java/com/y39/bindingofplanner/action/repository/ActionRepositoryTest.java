package com.y39.bindingofplanner.action.repository;

import com.y39.bindingofplanner.action.entity.Action;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@ActiveProfiles("test")
class ActionRepositoryTest {
    @Autowired
    ActionRepository actionRepository;

    @BeforeEach
    void setup(){
        for (int i=1; i<10; i++){
            actionRepository.save(
                    Action.builder()
                            .title(String.format("test%d ", i))
                            .content(String.format("test%d content", i)).build()
            );
        }
    }

    @AfterEach
    void resetData(){

    }
    @Test
    @DisplayName("Action List")
    void findAll(){
        List<Action> actions = actionRepository.findAll();
        assertThat(actions.size()).isEqualTo(9);
    }

}