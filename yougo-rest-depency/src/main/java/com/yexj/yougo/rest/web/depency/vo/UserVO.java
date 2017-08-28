package com.yexj.yougo.rest.web.depency.vo;

import java.io.Serializable;

/**
 * Created by xinjian.ye on 2017/8/18.
 */
public class UserVO implements Serializable {

    private String userName;

    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
