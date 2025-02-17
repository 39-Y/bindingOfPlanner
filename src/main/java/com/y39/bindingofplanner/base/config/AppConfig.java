package com.y39.bindingofplanner.base.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Getter
    private static String profile;

    @Value("${spring.profiles.active}")
    public void setProfile(String profile) {
        AppConfig.profile = profile;
    }

    @Getter
    private static String hi;

    @Value("${custom.hi}")
    public void setHi(String hi) {
        AppConfig.hi = hi;
    }
}
