package com.toyproject.vending_machine.dto;

import lombok.Getter;

@Getter
public class ResponseDTO {

    private final String msg;
    private final String code;
    private final Object data;

    private ResponseDTO(String msg, String code, Object data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public static ResponseDTO responseForm(String msg, String code, Object data) {
        return new ResponseDTO(msg, code, data);
    }
}
