package com.y39.bindingofplanner.action.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.y39.bindingofplanner.action.entity.Action;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActionReqDto {
    private String title;
    private long id;
    private String content;
    @JsonProperty("isDone")
    private boolean isDone;
    private LocalDateTime planDate;
    private LocalDateTime doneDate;

    public Action toEntity() {
        doneDate = isDone? LocalDateTime.now() : null;

        return Action.builder()
                .title(getTitle())
                .content(getContent())
                .planDate(getPlanDate())
                .doneDate(doneDate)
                .build();
    }
}
