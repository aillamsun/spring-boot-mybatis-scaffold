package com.scaffold.core.enums;

/**
 * Created by sungang on 2017/5/19.
 */
public enum ErrorInfoEnum implements ErrorInfo{

    PARAMS_NOT_NULL("000001","params not null"),
    USER_EXISTS("000002","user already exists");

    private String code;

    private String message;

    ErrorInfoEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode(){
        return this.code;
    }

    public String getMessage(){
        return this.message;
    }
}
