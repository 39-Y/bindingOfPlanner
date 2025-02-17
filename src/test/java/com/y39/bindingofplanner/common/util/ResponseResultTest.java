package com.y39.bindingofplanner.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
class ResponseResultTest {
    ObjectMapper objectMapper = new ObjectMapper();

    @Before(value = "setup objectMapper")
    void setup(){
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    @DisplayName("ResponseResulTest() 생성 테스트")
    void constructorTest(){
        String msg = "This is Test";
        String errMsg = "This is errMsg";
        String statusCode = "T1";
        String attribute = "hoho";
        List<String> list = List.of("hi");

        ResponseResult rr = ResponseResult.builder(objectMapper)
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

    @Test
    @DisplayName("mapper() 테스트")
    void mapperTest(){
        String msg = "This is Test";
        String errMsg = "This is errMsg";
        String statusCode = "T1";
        String attribute = "hoho";
        List<String> list = List.of("hi");

        ResponseResult rr = ResponseResult.builder(objectMapper)
                                        .message(msg)
                                        .errorMessage(errMsg)
                                        .isSuccess(true)
                                        .data(list)
                                        .statusCode(statusCode)
                                        .addAttribute("test", attribute)
                                        .build();
        System.out.println(rr.mapper());
        String result = rr.mapper();
        assertThat(result).contains(msg);
    }
    @Test
    @DisplayName("비어있는 ResponseResult mapper 테스트")
    void emptyResponseResultTest(){
        String mappered = ResponseResult.builder(objectMapper).build().mapper();
        System.out.println(mappered);
        assertThat(mappered).contains("null");
    }

    @Test
    void testBuildResponseResult() {
        ResponseResult response = ResponseResult.builder(objectMapper)
                .isSuccess(true)
                .message("Success")
                .errorMessage(null)
                .statusCode("200")
                .data("TestData")
                .addAttribute("key", "value")
                .build();

        assertThat(response).isNotNull();
        assertThat("Success").isEqualTo(response.getMessage());
        assertThat("200").isEqualTo(response.getStatusCode());
        assertThat("TestData").isEqualTo(response.getData());
        assertThat("value").isEqualTo(response.getAttribute().get("key"));
        assertThat(response.getTimestamp()).isNotNull();
    }

    @Test
    void testResultMethod() {
        ResponseResult response = ResponseResult.builder(objectMapper).result(1).build();
        assertThat(response.isSuccess()).isTrue();

        response = ResponseResult.builder(objectMapper).result(0).build();
        assertThat(response.isSuccess()).isFalse();
    }

    @Test
    void testJsonMapping() throws Exception {
        ResponseResult response = ResponseResult.builder(objectMapper).isSuccess(true).message("Test").statusCode("200").build();
        String json = response.mapper();

        assertThat(json).contains("\"statusCode\":\"200\"");

    }

}