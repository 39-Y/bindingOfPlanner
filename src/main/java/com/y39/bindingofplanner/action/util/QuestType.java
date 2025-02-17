package com.y39.bindingofplanner.action.util;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum QuestType {
    DREAM("Dream", 0),
    PURPOSE( "Purpose", 1),
    GOAL( "Goal", 2),
    PROJECT( "Project", 3),
    SUB_PROJECT("Sub Project", 4),
    ACTION( "Action", 5);

    private String name;
    private Integer code;

    QuestType (String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    static QuestType fromName(String name) {
        return Arrays.stream(QuestType.values())
                .filter(n -> n.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
