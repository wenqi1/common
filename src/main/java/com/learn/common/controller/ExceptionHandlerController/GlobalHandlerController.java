package com.learn.common.controller.ExceptionHandlerController;

import com.learn.common.entity.Result;
import com.learn.common.exception.CommonException;
import com.learn.common.exception.ErrorMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全球异常处理类
 */
@ControllerAdvice
@ResponseBody
public class GlobalHandlerController {

    @ExceptionHandler(CommonException.class)
    public Result HandlerException(CommonException e){
        String code = e.getMessage();
        return Result.error(code,ErrorMap.getMessage(code));
    }
}
