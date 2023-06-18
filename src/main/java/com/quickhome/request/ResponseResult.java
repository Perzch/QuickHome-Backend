package com.quickhome.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * @param <T> T 返回的数据类型泛型
 * @JsonInclude(JsonInclude.Include.NON_NULL) 对象返回的字段中为null(空)的字段不进行序列化，也就是不会显示到响应体中
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
public class ResponseResult<T> {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 提示信息，如果有错误时，前端可以获取该字段进行提示
     */
    private String msg;

    /**
     * 返回的结果数据
     */
    private T data;

    public static ResponseResult<?> ok() {
        return new ResponseResult<>(200, "操作成功");
    }

    public static <T> ResponseResult<T> ok(T data) {
        return new ResponseResult<>(200, "操作成功", data);
    }

    public static ResponseResult<?> error() {
        return new ResponseResult<>(500, "服务器无响应!");
    }

    public static ResponseResult<?> error(String msg) {
        return new ResponseResult<>(500, msg);
    }

    public static <T> ResponseResult<T> of(Integer code,String msg,T data) {
        return new ResponseResult<>(code, msg, data);
    }

    public static <T> ResponseResult<T> of(Integer code,String msg) {
        return new ResponseResult<>(code, msg);
    }

    public static <T> ResponseResult<T> of(ResultCode resultCode) {
        return new ResponseResult<>(resultCode);
    }

    public static <T> ResponseResult<T> of(ResultCode resultCode,T data) {
        return new ResponseResult<>(resultCode, data);
    }

    public ResponseResult() {
    }

    public ResponseResult(T data) {
        this.code = 200;
        this.msg = "操作成功";
        this.data = data;
    }

    public ResponseResult(ResultCode code, T data) {
        this.code = code.getCode();
        this.msg = code.getMsg();
        this.data = data;
    }

    public ResponseResult(ResultCode code) {
        this.code = code.getCode();
        this.msg = code.getMsg();
    }

    public ResponseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
