package com.quickhome.exception;

import com.quickhome.request.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.boot.context.properties.bind.validation.BindValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@Slf4j
public final class GlobalExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<?> exceptionHandler(Exception e) {
        e.printStackTrace();
        log.error(e.getMessage());
        return ResponseEntity.ok(ResponseResult.error(e.getMessage()));
    }

    @ExceptionHandler(value = {BindValidationException.class})
    public ResponseEntity<?> exceptionHandler(BindValidationException e) {
        log.error(e.getMessage());
        return ResponseEntity.ok(ResponseResult.error(e.getValidationErrors().getAllErrors().toString()));
    }

    /**
     * 忽略参数异常处理器
     *
     * @param e 忽略参数异常
     * @return ResponseEntity
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<?> parameterMissingExceptionHandler(MissingServletRequestParameterException e) {
        log.error(e.getMessage());
        return ResponseEntity.ok(ResponseResult.of(400, e.getMessage()));
    }

    /**
     * 缺少请求体异常处理器
     *
     * @param e 缺少请求体异常
     * @return ResponseEntity
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> parameterBodyMissingExceptionHandler(HttpMessageNotReadableException e) {
        log.error(e.getMessage());
        return ResponseEntity.ok(ResponseResult.of(400, e.getMessage()));
    }

    /**
     * 参数效验异常处理器
     *
     * @param e 参数验证异常
     * @return ResponseEntity
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> parameterExceptionHandler(MethodArgumentNotValidException e) {
        log.error(e.getMessage());
        // 获取异常信息
        BindingResult exceptions = e.getBindingResult();
        // 判断异常中是否有错误信息，如果存在就使用异常中的消息，否则使用默认消息
        if (exceptions.hasErrors()) {
            List<ObjectError> errors = exceptions.getAllErrors();
            if (!errors.isEmpty()) {
                List<String> errorsMessage = new ArrayList<>();
                errors.forEach(err -> errorsMessage.add(err.getDefaultMessage()));
                return ResponseEntity.ok(ResponseResult.of(400, (StringUtils.join(errorsMessage, ','))));
            }
        }
        return ResponseEntity.ok(ResponseResult.of(400, e.getMessage()));
    }
}
