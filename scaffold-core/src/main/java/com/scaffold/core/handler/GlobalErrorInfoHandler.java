package com.scaffold.core.handler;

import com.scaffold.core.enums.ErrorInfo;
import com.scaffold.core.exception.GlobalErrorInfoException;
import com.scaffold.core.response.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;

/**
 * 统一错误码异常处理
 * <p>
 * Created by sungang on 2017/5/19.
 */
@Slf4j
@RestControllerAdvice
public class GlobalErrorInfoHandler {


    @Value("${scaffold.config.show-exception}")
    private Boolean showException = false;

    /**
     * 系统异常处理
     *
     * @param request
     * @param exception
     * @return
     */
    @ExceptionHandler(value = GlobalErrorInfoException.class)
    public ResultBody errorHandlerOverJson(HttpServletRequest request, GlobalErrorInfoException exception) {
        if (showException) {
            exception.printStackTrace();
        }
        ErrorInfo errorInfo = exception.getErrorInfo();
        ResultBody result = new ResultBody(errorInfo);
        return result;
    }

    /**
     * 参数验证失败
     *
     * @param exception
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultBody handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        if (showException) {
            exception.printStackTrace();
        }
        log.error("参数验证失败", exception);
        BindingResult result = exception.getBindingResult();
        FieldError error = result.getFieldError();
        String field = error.getField();
        String code = error.getDefaultMessage();
        String message = String.format("%s:%s", field, code);
        ResultBody resultBody = new ResultBody();
        resultBody.setCode(HttpStatus.BAD_REQUEST.toString());
        resultBody.setMessage("参数验证失败:" + message);
        return resultBody;
    }


//    /**
//     * 500 - Internal Server Error
//     */
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(Exception.class)
//    public ResultBody handleException(Exception exception) {
//        log.error("服务器异常", exception);
//        if (showException) {
//            exception.printStackTrace();
//        }
//        ResultBody resultBody = new ResultBody();
//        resultBody.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
//        resultBody.setMessage("服务器异常");
//        return resultBody;
//    }
//
//
//
//    /**
//     * 401 - Unauthorized
//     */
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    @ExceptionHandler(AccessDeniedException.class)
//    public ResultBody handleException(AccessDeniedException exception) {
//        log.error("没有访问权限", exception);
//        if (showException) {
//            exception.printStackTrace();
//        }
//        ResultBody resultBody = new ResultBody();
//        resultBody.setCode(HttpStatus.UNAUTHORIZED.toString());
//        resultBody.setMessage("该接口您没有访问权限!");
//        return resultBody;
//    }
}