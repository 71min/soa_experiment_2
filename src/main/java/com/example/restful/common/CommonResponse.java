package com.example.restful.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse<T> {
    private final int status;
    private final String message;
    private T data;

    @JsonIgnore
    public boolean isSuccess() {
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    protected CommonResponse() {
        this.status = 0;
        this.message = null;
    }

    private CommonResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    private CommonResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> CommonResponse<T> createForSuccess() {
        return (CommonResponse<T>) createForSuccess(ResponseCode.SUCCESS.getDesc());
    }

    public static <T> CommonResponse<T> createForSuccessMessage(String message) {
        return new SuccessResponse<>(message);
    }

    public static <T> CommonResponse<T> createForSuccess(T data) {
        return new SuccessResponse<>(data);
    }

    public static <T> CommonResponse<T> createForSuccess(String message, T data) {
        return new SuccessResponse<>(message, data);
    }

    public static <T> CommonResponse<T> createForError() {
        return createForError(ResponseCode.ERROR.getDesc());
    }

    public static <T> CommonResponse<T> createForError(String message) {
        return new ErrorResponse<>(message);
    }

    public static <T> CommonResponse<T> createForError(int code, String message) {
        return new ErrorResponse<>(code, message);
    }

    private static class SuccessResponse<T> extends CommonResponse<T> {
        private SuccessResponse(String message) {
            super(ResponseCode.SUCCESS.getCode(), message);
        }

        private SuccessResponse(T data) {
            super(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getDesc(), data);
        }

        private SuccessResponse(String message, T data) {
            super(ResponseCode.SUCCESS.getCode(), message, data);
        }
    }

    private static class ErrorResponse<T> extends CommonResponse<T> {
        private ErrorResponse(String message) {
            super(ResponseCode.ERROR.getCode(), message);
        }

        private ErrorResponse(int code, String message) {
            super(code, message);
        }
    }
}
