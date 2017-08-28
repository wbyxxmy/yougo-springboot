package com.yexj.yougo.api.dto.account;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xinjian.ye on 2017/8/23.
 */
public class UserParamDTO implements Serializable {
    private String userId;

    private String userName;

    private String password;

    private Date lastLoginTime;

    private Integer rank;

    private String role;

    private String telephone;

    private Date signupTime;

    private String email;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getSignupTime() {
        return signupTime;
    }

    public void setSignupTime(Date signupTime) {
        this.signupTime = signupTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserParamDTO{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", rank=" + rank +
                ", role='" + role + '\'' +
                ", telephone='" + telephone + '\'' +
                ", signupTime=" + signupTime +
                ", email='" + email + '\'' +
                '}';
    }
}
