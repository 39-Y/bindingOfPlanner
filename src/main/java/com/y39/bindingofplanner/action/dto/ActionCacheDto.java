package com.y39.bindingofplanner.action.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class ActionCacheDto {

    private List<ActionReqDto> update;
    private List<ActionReqDto> delete;
    private List<ActionReqDto> insert;
}
