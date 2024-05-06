package com.y39.bindingofplanner.action.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActionSaveDto {
    private String title;
    private String content;
    private LocalDateTime doStartDate;
    private LocalDateTime doEndDate;

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
}
