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
    private LocalDateTime createDate;
    private LocalDateTime doStartDate;
    private LocalDateTime doEndDate;
    private LocalDateTime doneDate;
    private LocalDateTime lastModifiedDate;
    private QuestType questType;

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
