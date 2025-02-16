package com.y39.bindingofplanner.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@Getter
public class ResponseResult {
    private ObjectMapper objectMapper;
    private boolean isSuccess;
    private String message;
    private String errorMessage;
    private String statusCode;
    private LocalDateTime timestamp;
    private Object data;
    private Map<String, Object> attribute;


    private ResponseResult(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
        this.timestamp = LocalDateTime.now();
        this.attribute = new HashMap<>();
    }

    @SneakyThrows
    public String mapper(){
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.writeValueAsString(this);
    }
    static public ResponseResultBuilder builder(ObjectMapper objectMapper){
        return new ResponseResultBuilder(objectMapper);
    }

    public static class ResponseResultBuilder{
        private final ResponseResult rr;
        public ResponseResultBuilder(ObjectMapper objectMapper){
            this.rr = new ResponseResult(objectMapper);
        }
        public ResponseResultBuilder data(Object data){
            rr.data = data;
            return this;
        }

        public ResponseResultBuilder isSuccess(boolean success){
            rr.isSuccess = success;
            return this;
        }

        public ResponseResultBuilder message(String message){
            rr.message = message;
            return this;
        }

        public ResponseResultBuilder errorMessage(String errorMessage){
            rr.errorMessage = errorMessage;
            return this;
        }

        public ResponseResultBuilder statusCode(String statusCode){
            rr.statusCode = statusCode;
            return this;
        }

        public ResponseResultBuilder addAttribute(String key, String val){
            rr.attribute.put(key,val);
            return this;
        }

        public ResponseResultBuilder result(int result){
            rr.isSuccess = result > 0;
            return this;
        }

        public ResponseResult build(){
            return rr;
        }
    }
}
