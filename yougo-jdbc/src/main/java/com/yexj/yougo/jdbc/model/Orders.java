package com.yexj.yougo.jdbc.model;

import java.io.Serializable;
import java.util.Date;

public class Orders implements Serializable {
    private String orderId;

    private String shopId;

    private String userId;

    private String goodsName;

    private String kind;

    private Float price;

    private Float goodsAmount;

    private String measureUnit;

    private Float totalPrice;

    private String orderStatus;

    private Float orderDiscountRate;

    private Date orderDate;

    private Float reduction;

    private Float goodsPriceScore;

    private Float goodsQualityScore;

    private Float goodsTransScore;

    private static final long serialVersionUID = 1L;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind == null ? null : kind.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(Float goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit == null ? null : measureUnit.trim();
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public Float getOrderDiscountRate() {
        return orderDiscountRate;
    }

    public void setOrderDiscountRate(Float orderDiscountRate) {
        this.orderDiscountRate = orderDiscountRate;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Float getReduction() {
        return reduction;
    }

    public void setReduction(Float reduction) {
        this.reduction = reduction;
    }

    public Float getGoodsPriceScore() {
        return goodsPriceScore;
    }

    public void setGoodsPriceScore(Float goodsPriceScore) {
        this.goodsPriceScore = goodsPriceScore;
    }

    public Float getGoodsQualityScore() {
        return goodsQualityScore;
    }

    public void setGoodsQualityScore(Float goodsQualityScore) {
        this.goodsQualityScore = goodsQualityScore;
    }

    public Float getGoodsTransScore() {
        return goodsTransScore;
    }

    public void setGoodsTransScore(Float goodsTransScore) {
        this.goodsTransScore = goodsTransScore;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", shopId=").append(shopId);
        sb.append(", userId=").append(userId);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", kind=").append(kind);
        sb.append(", price=").append(price);
        sb.append(", goodsAmount=").append(goodsAmount);
        sb.append(", measureUnit=").append(measureUnit);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", orderDiscountRate=").append(orderDiscountRate);
        sb.append(", orderDate=").append(orderDate);
        sb.append(", reduction=").append(reduction);
        sb.append(", goodsPriceScore=").append(goodsPriceScore);
        sb.append(", goodsQualityScore=").append(goodsQualityScore);
        sb.append(", goodsTransScore=").append(goodsTransScore);
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
        Orders other = (Orders) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getShopId() == null ? other.getShopId() == null : this.getShopId().equals(other.getShopId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getGoodsName() == null ? other.getGoodsName() == null : this.getGoodsName().equals(other.getGoodsName()))
            && (this.getKind() == null ? other.getKind() == null : this.getKind().equals(other.getKind()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getGoodsAmount() == null ? other.getGoodsAmount() == null : this.getGoodsAmount().equals(other.getGoodsAmount()))
            && (this.getMeasureUnit() == null ? other.getMeasureUnit() == null : this.getMeasureUnit().equals(other.getMeasureUnit()))
            && (this.getTotalPrice() == null ? other.getTotalPrice() == null : this.getTotalPrice().equals(other.getTotalPrice()))
            && (this.getOrderStatus() == null ? other.getOrderStatus() == null : this.getOrderStatus().equals(other.getOrderStatus()))
            && (this.getOrderDiscountRate() == null ? other.getOrderDiscountRate() == null : this.getOrderDiscountRate().equals(other.getOrderDiscountRate()))
            && (this.getOrderDate() == null ? other.getOrderDate() == null : this.getOrderDate().equals(other.getOrderDate()))
            && (this.getReduction() == null ? other.getReduction() == null : this.getReduction().equals(other.getReduction()))
            && (this.getGoodsPriceScore() == null ? other.getGoodsPriceScore() == null : this.getGoodsPriceScore().equals(other.getGoodsPriceScore()))
            && (this.getGoodsQualityScore() == null ? other.getGoodsQualityScore() == null : this.getGoodsQualityScore().equals(other.getGoodsQualityScore()))
            && (this.getGoodsTransScore() == null ? other.getGoodsTransScore() == null : this.getGoodsTransScore().equals(other.getGoodsTransScore()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getShopId() == null) ? 0 : getShopId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getGoodsName() == null) ? 0 : getGoodsName().hashCode());
        result = prime * result + ((getKind() == null) ? 0 : getKind().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getGoodsAmount() == null) ? 0 : getGoodsAmount().hashCode());
        result = prime * result + ((getMeasureUnit() == null) ? 0 : getMeasureUnit().hashCode());
        result = prime * result + ((getTotalPrice() == null) ? 0 : getTotalPrice().hashCode());
        result = prime * result + ((getOrderStatus() == null) ? 0 : getOrderStatus().hashCode());
        result = prime * result + ((getOrderDiscountRate() == null) ? 0 : getOrderDiscountRate().hashCode());
        result = prime * result + ((getOrderDate() == null) ? 0 : getOrderDate().hashCode());
        result = prime * result + ((getReduction() == null) ? 0 : getReduction().hashCode());
        result = prime * result + ((getGoodsPriceScore() == null) ? 0 : getGoodsPriceScore().hashCode());
        result = prime * result + ((getGoodsQualityScore() == null) ? 0 : getGoodsQualityScore().hashCode());
        result = prime * result + ((getGoodsTransScore() == null) ? 0 : getGoodsTransScore().hashCode());
        return result;
    }
}