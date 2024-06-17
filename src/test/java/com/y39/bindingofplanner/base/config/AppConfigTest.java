package com.y39.bindingofplanner.base.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@ActiveProfiles("dev")
@SpringBootTest
class AppConfigTest {
    @Autowired
    private AppConfig appConfig;

    @Test
    @DisplayName("프로파일 테스트")
    void getProfile(){
        assertThat(appConfig.getProfile()).isEqualTo("dev");
    }
}