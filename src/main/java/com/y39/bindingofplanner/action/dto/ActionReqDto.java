package com.y39.bindingofplanner.action.dto;

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
public class ActionReqDto {
    private String title;
    private String content;
    private boolean isDone;
    private LocalDateTime doStartDate;
    private LocalDateTime doEndDate;
    private LocalDateTime doneDate;

//    static ActionSaveDto of(String json){
//        String title;
//        String content;
//        String doStartDate;
//        String doEndDate;
//
//        return ActionSaveDto.builder()
//                .title(title)
//                .content(content)
//                .doStartDate(doStartDate)
//                .doEndDate(doEndDate)
//                .build();
//    }
    public Action toEntity() {
        doneDate = isDone? LocalDateTime.now() : null;

        return Action.builder()
                .title(getTitle())
                .content(getContent())
                .doStartDate(getDoStartDate())
                .doEndDate(getDoEndDate())
                .doneDate(getDoneDate())
                .build();
    }
}
