package com.y39.bindingofplanner.base.initData;

import com.y39.bindingofplanner.action.dto.ActionReqDto;
import com.y39.bindingofplanner.action.service.ActionService;
import com.y39.bindingofplanner.base.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@Profile({"dev", "test"})
public class InsertActions {
    @Autowired
    private AppConfig appConfig;
    @Bean
    CommandLineRunner initData(
            ActionService actionService){
        return new CommandLineRunner() {
            @Override
            @Transactional
            public void run(String... args) throws Exception {
                for (int i=1; i<10; i++){
                    actionService.create(
                            ActionReqDto.builder()
                                    .title(String.format("test%d ", i))
                                    .content(String.format("test%d content", i)).build()
                    );
                }
            }
        };
    }
}
