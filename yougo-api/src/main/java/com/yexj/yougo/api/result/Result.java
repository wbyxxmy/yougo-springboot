package com.yexj.yougo.api.result;




import com.yexj.yougo.api.enums.ResultCode;

import java.io.Serializable;

/**
 * Description:
 * 返回对象
 * @author sheng.wang
 * @version 1.0.0
 * @email sheng.wang@chinaredstar.com
 * @date: 2016-12-16 16:20
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 6597451918486087550L;

    private String code;
    private String message;
    private boolean success;
    private T data;

    public Result(){}

    public Result(String code, String message, boolean success, T data){
        this.code = code;
        this.message = message;
        this.success = success;
        this.data = data;
    }

    public static <T> Result<T> newSuccess(){
        return newSuccess(ResultCode.SUCCESS,null);
    }

    public static <T> Result<T> newSuccess(T data){
        return newSuccess(ResultCode.SUCCESS,data);
    }

    public static <T> Result<T> newSuccess(ResultCode resultCode, T data){
        return new Result<T>(resultCode.getCode(),resultCode.getMessage(),true,data);
    }

    public static <T> Result<T> newError(ResultCode resultCode){
        return new Result<T>(resultCode.getCode(),resultCode.getMessage(),false,null);
    }
    public static <T> Result<T> newError(String code,String msg){
        return new Result<T>(code,msg,false,null);
    }

    public Result<T> setErrorCode(ResultCode resultCode){
        this.success = false;
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        return this;
    }

    public Result<T> setError(String code,String msg){
        this.success = false;
        this.code = code;
        this.message = msg;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Result{");
        sb.append("code='").append(code).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append(", success=").append(success);
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}
