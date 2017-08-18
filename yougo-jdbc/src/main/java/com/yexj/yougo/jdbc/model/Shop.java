package com.yexj.yougo.jdbc.model;

import java.io.Serializable;
import java.util.Date;

public class Shop implements Serializable {
    private String shopId;

    private Integer shopPopular;

    private Float avgGoodsPriceScore;

    private Float avgGoodsQualityScore;

    private Float avgGoodsTransScore;

    private String shopName;

    private Date createTime;

    private String shopStatus;

    private String auditorId;

    private String userId;

    private static final long serialVersionUID = 1L;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public Integer getShopPopular() {
        return shopPopular;
    }

    public void setShopPopular(Integer shopPopular) {
        this.shopPopular = shopPopular;
    }

    public Float getAvgGoodsPriceScore() {
        return avgGoodsPriceScore;
    }

    public void setAvgGoodsPriceScore(Float avgGoodsPriceScore) {
        this.avgGoodsPriceScore = avgGoodsPriceScore;
    }

    public Float getAvgGoodsQualityScore() {
        return avgGoodsQualityScore;
    }

    public void setAvgGoodsQualityScore(Float avgGoodsQualityScore) {
        this.avgGoodsQualityScore = avgGoodsQualityScore;
    }

    public Float getAvgGoodsTransScore() {
        return avgGoodsTransScore;
    }

    public void setAvgGoodsTransScore(Float avgGoodsTransScore) {
        this.avgGoodsTransScore = avgGoodsTransScore;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(String shopStatus) {
        this.shopStatus = shopStatus == null ? null : shopStatus.trim();
    }

    public String getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(String auditorId) {
        this.auditorId = auditorId == null ? null : auditorId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", shopId=").append(shopId);
        sb.append(", shopPopular=").append(shopPopular);
        sb.append(", avgGoodsPriceScore=").append(avgGoodsPriceScore);
        sb.append(", avgGoodsQualityScore=").append(avgGoodsQualityScore);
        sb.append(", avgGoodsTransScore=").append(avgGoodsTransScore);
        sb.append(", shopName=").append(shopName);
        sb.append(", createTime=").append(createTime);
        sb.append(", shopStatus=").append(shopStatus);
        sb.append(", auditorId=").append(auditorId);
        sb.append(", userId=").append(userId);
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
        Shop other = (Shop) that;
        return (this.getShopId() == null ? other.getShopId() == null : this.getShopId().equals(other.getShopId()))
            && (this.getShopPopular() == null ? other.getShopPopular() == null : this.getShopPopular().equals(other.getShopPopular()))
            && (this.getAvgGoodsPriceScore() == null ? other.getAvgGoodsPriceScore() == null : this.getAvgGoodsPriceScore().equals(other.getAvgGoodsPriceScore()))
            && (this.getAvgGoodsQualityScore() == null ? other.getAvgGoodsQualityScore() == null : this.getAvgGoodsQualityScore().equals(other.getAvgGoodsQualityScore()))
            && (this.getAvgGoodsTransScore() == null ? other.getAvgGoodsTransScore() == null : this.getAvgGoodsTransScore().equals(other.getAvgGoodsTransScore()))
            && (this.getShopName() == null ? other.getShopName() == null : this.getShopName().equals(other.getShopName()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getShopStatus() == null ? other.getShopStatus() == null : this.getShopStatus().equals(other.getShopStatus()))
            && (this.getAuditorId() == null ? other.getAuditorId() == null : this.getAuditorId().equals(other.getAuditorId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getShopId() == null) ? 0 : getShopId().hashCode());
        result = prime * result + ((getShopPopular() == null) ? 0 : getShopPopular().hashCode());
        result = prime * result + ((getAvgGoodsPriceScore() == null) ? 0 : getAvgGoodsPriceScore().hashCode());
        result = prime * result + ((getAvgGoodsQualityScore() == null) ? 0 : getAvgGoodsQualityScore().hashCode());
        result = prime * result + ((getAvgGoodsTransScore() == null) ? 0 : getAvgGoodsTransScore().hashCode());
        result = prime * result + ((getShopName() == null) ? 0 : getShopName().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getShopStatus() == null) ? 0 : getShopStatus().hashCode());
        result = prime * result + ((getAuditorId() == null) ? 0 : getAuditorId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }
}