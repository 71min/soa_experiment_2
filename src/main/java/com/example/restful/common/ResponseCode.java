package com.example.restful.common;
import lombok.Getter;

@Getter
public enum ResponseCode {
    SUCCESS(1,"SUCCESS"),
    ERROR(0,"ERROR");


    private final int code;
    private final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
