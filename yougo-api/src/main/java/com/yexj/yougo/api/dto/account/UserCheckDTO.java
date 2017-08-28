package com.yexj.yougo.api.dto.account;

import java.io.Serializable;

/**
 * Created by xinjian.ye on 2017/8/24.
 */
public class UserCheckDTO implements Serializable {
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

    @Override
    public String toString() {
        return "UserCheckDTO{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
