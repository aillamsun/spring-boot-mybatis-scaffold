package com.scaffold.core.response;

import com.scaffold.core.enums.ErrorInfo;
import com.scaffold.core.enums.GlobalErrorInfoEnum;

/**
 * Created by sungang on 2017/8/19.
 */
public class ResultGenerator {


    private static final String DEFAULT_SUCCESS_MESSAGE = "success";

    public static ResultBody genSuccessResult() {
        return new ResultBody()
                .setCode(GlobalErrorInfoEnum.SUCCESS.getCode())
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static ResultBody genSuccessResult(Object data) {
        return new ResultBody()
                .setCode(GlobalErrorInfoEnum.SUCCESS.getCode())
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setResult(data);
    }

    public static ResultBody genFailResult(ErrorInfo errorInfo) {
        return new ResultBody(errorInfo);
    }
}
