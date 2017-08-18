package com.yexj.yougo.jdbc.model;

import java.io.Serializable;

public class OrderControl implements Serializable {
    private String orderControlId;

    private String orderId;

    private String controlStatus;

    private static final long serialVersionUID = 1L;

    public String getOrderControlId() {
        return orderControlId;
    }

    public void setOrderControlId(String orderControlId) {
        this.orderControlId = orderControlId == null ? null : orderControlId.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getControlStatus() {
        return controlStatus;
    }

    public void setControlStatus(String controlStatus) {
        this.controlStatus = controlStatus == null ? null : controlStatus.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderControlId=").append(orderControlId);
        sb.append(", orderId=").append(orderId);
        sb.append(", controlStatus=").append(controlStatus);
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
        OrderControl other = (OrderControl) that;
        return (this.getOrderControlId() == null ? other.getOrderControlId() == null : this.getOrderControlId().equals(other.getOrderControlId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getControlStatus() == null ? other.getControlStatus() == null : this.getControlStatus().equals(other.getControlStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderControlId() == null) ? 0 : getOrderControlId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getControlStatus() == null) ? 0 : getControlStatus().hashCode());
        return result;
    }
}