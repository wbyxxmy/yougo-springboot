package com.yexj.yougo.api.enums;

import java.util.Objects;

/**
 * Description:
 *
 * @author sheng.wang
 * @version 1.0.0
 * @email sheng.wang@chinaredstar.com
 * @date: 2016-12-16 16:42
 */
public enum ResultCode {
    //用户信息返回代码
    ACCOUNT_LOGIN_FAIL("1001", "用户名或密码错误"),

    SUCCESS("200","操作成功"),
    FAIL("500","系统异常"),
	USER_NO_LOGGED_IN("510","用户未登录"),
	FOR_UNAUTHORIZED("511","用户未授权");

    String code;
    String message;

    ResultCode(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
    
    public static final ResultCode matching(String code){
    	for(ResultCode resultCode : ResultCode.values()){
    		if(Objects.equals(resultCode.getCode(), code)) return resultCode;
    	}
    	return null;
    }
}
