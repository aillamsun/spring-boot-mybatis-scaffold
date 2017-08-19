package com.scaffold.core.exception;

import com.scaffold.core.enums.ErrorInfo;

/**
 * Created by sungang on 2017/5/19.
 */
public class GlobalErrorInfoException extends Exception {

    private ErrorInfo errorInfo;

    public GlobalErrorInfoException(ErrorInfo errorInfo) {
        this.errorInfo = errorInfo;
    }

    public ErrorInfo getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(ErrorInfo errorInfo) {
        this.errorInfo = errorInfo;
    }

}
