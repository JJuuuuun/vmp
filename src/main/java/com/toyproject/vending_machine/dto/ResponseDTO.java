package com.toyproject.vending_machine.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class ResponseDTO {

    private final String msg;
    private final String statusCode;
    @Setter // final 선언하면 @Setter annotation 이 적용되지 않음.. 당연한건가
    private Object data;

    private ResponseDTO(String msg, String statusCode, Object data) {
        this.msg = msg;
        this.statusCode = statusCode;
        this.data = data;
    }

    public static ResponseDTO responseForm(String msg, String statusCode, Object data) {
        return new ResponseDTO(msg, statusCode, data);
    }
}
