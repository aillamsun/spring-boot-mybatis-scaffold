package com.scaffold.core.handler;

import com.scaffold.core.enums.ErrorInfo;
import com.scaffold.core.enums.GlobalErrorInfoEnum;
import com.scaffold.core.exception.GlobalErrorInfoException;
import com.scaffold.core.response.ResultBody;
import com.scaffold.core.utils.MessageUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
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

    private static Logger logger = LoggerFactory.getLogger(GlobalErrorInfoHandler.class);


    /**
     * 全局系统异常
     * @param request
     * @param exception
     * @return
     */
    @ExceptionHandler(value = RuntimeException.class)
    public ResultBody errorHandlerOverJson(HttpServletRequest request, RuntimeException exception) {
        logger.error("全局异常:", exception.getMessage());
        ResultBody result = new ResultBody(GlobalErrorInfoEnum.NOT_FOUND);
        return result;
    }


    /**
     * GlobalErrorInfoException 系统异常
     * @param request
     * @param exception
     * @return
     */
    @ExceptionHandler(value = GlobalErrorInfoException.class)
    public ResultBody handleGlobalErrorInfoException(HttpServletRequest request, GlobalErrorInfoException exception) {
        ErrorInfo errorInfo = exception.getErrorInfo();
        getMessage(errorInfo, exception.getArgs());
        logger.error("错误消息:", errorInfo.toString());
        ResultBody result = new ResultBody(errorInfo);
        return result;
    }

    private void getMessage(ErrorInfo errorInfo, Object... agrs) {
        String message = null;
        if (!StringUtils.isEmpty(errorInfo.getCode())) {
            message = MessageUtils.message(errorInfo.getCode(), agrs);
        }
        if (message == null) {
            message = errorInfo.getMessage();
        }
        errorInfo.setMessage(message);
    }
}