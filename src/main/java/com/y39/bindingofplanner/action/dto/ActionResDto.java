package com.y39.bindingofplanner.action.dto;

import com.y39.bindingofplanner.action.util.QuestType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActionResDto {
    private long id;
    private String title;
    private String content;
    private LocalDateTime planDate;
    private LocalDateTime createDate;
    private LocalDateTime doneDate;
    private LocalDateTime lastModifiedDate;

}
