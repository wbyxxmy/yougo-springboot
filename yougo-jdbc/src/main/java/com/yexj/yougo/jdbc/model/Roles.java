package com.yexj.yougo.jdbc.model;

import java.io.Serializable;

public class Roles implements Serializable {
    private Integer id;

    private Integer roleCode;

    private String roleDiscribe;

    private Integer roleLevel;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(Integer roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleDiscribe() {
        return roleDiscribe;
    }

    public void setRoleDiscribe(String roleDiscribe) {
        this.roleDiscribe = roleDiscribe == null ? null : roleDiscribe.trim();
    }

    public Integer getRoleLevel() {
        return roleLevel;
    }

    public void setRoleLevel(Integer roleLevel) {
        this.roleLevel = roleLevel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleCode=").append(roleCode);
        sb.append(", roleDiscribe=").append(roleDiscribe);
        sb.append(", roleLevel=").append(roleLevel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Roles other = (Roles) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRoleCode() == null ? other.getRoleCode() == null : this.getRoleCode().equals(other.getRoleCode()))
            && (this.getRoleDiscribe() == null ? other.getRoleDiscribe() == null : this.getRoleDiscribe().equals(other.getRoleDiscribe()))
            && (this.getRoleLevel() == null ? other.getRoleLevel() == null : this.getRoleLevel().equals(other.getRoleLevel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRoleCode() == null) ? 0 : getRoleCode().hashCode());
        result = prime * result + ((getRoleDiscribe() == null) ? 0 : getRoleDiscribe().hashCode());
        result = prime * result + ((getRoleLevel() == null) ? 0 : getRoleLevel().hashCode());
        return result;
    }
}