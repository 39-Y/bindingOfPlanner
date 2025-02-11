package com.y39.bindingofplanner.common.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResponseResultTest {
    @Test
    @DisplayName("ResponseResulTest() 생성 테스트")
    void constructorTest(){
        String msg = "This is Test";
        String errMsg = "This is errMsg";
        String statusCode = "T1";
        String attribute = "hoho";
        List<String> list = List.of("hi");

        ResponseResult rr = ResponseResult.builder()
                                        .message(msg)
                                        .errorMessage(errMsg)
                                        .isSuccess(true)
                                        .data(list)
                                        .statusCode(statusCode)
                                        .addAttribute("test", attribute)
                                        .build();

        List<String> data = (List<String>) rr.getData();
        assertThat(data.get(0)).isEqualTo(list.get(0));
    }
}