package com.example.dio.util;

import com.example.dio.module.User;
import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ResponseStructure<T> {
    private int status;
    private String message;
    private T data;

    public static<T> ResponseStructure<T> create(HttpStatus status,String message,T data){
        ResponseStructure<T> responseStructure = new ResponseStructure<>();
        responseStructure.status=status.value();
        responseStructure.message=message;
        responseStructure.data=data;
        return responseStructure;
    }
}
