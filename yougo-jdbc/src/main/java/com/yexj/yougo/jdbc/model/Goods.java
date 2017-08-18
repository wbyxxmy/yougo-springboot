package com.yexj.yougo.jdbc.model;

import java.io.Serializable;
import java.util.Date;

public class Goods implements Serializable {
    private String goodsId;

    private String shopId;

    private String name;

    private String kind;

    private Float price;

    private Float originCost;

    private Float discount;

    private Date discountBeginDate;

    private Date discountEndDate;

    private Float remainAmount;

    private Date productDate;

    private static final long serialVersionUID = 1L;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public Float getOriginCost() {
        return originCost;
    }

    public void setOriginCost(Float originCost) {
        this.originCost = originCost;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Date getDiscountBeginDate() {
        return discountBeginDate;
    }

    public void setDiscountBeginDate(Date discountBeginDate) {
        this.discountBeginDate = discountBeginDate;
    }

    public Date getDiscountEndDate() {
        return discountEndDate;
    }

    public void setDiscountEndDate(Date discountEndDate) {
        this.discountEndDate = discountEndDate;
    }

    public Float getRemainAmount() {
        return remainAmount;
    }

    public void setRemainAmount(Float remainAmount) {
        this.remainAmount = remainAmount;
    }

    public Date getProductDate() {
        return productDate;
    }

    public void setProductDate(Date productDate) {
        this.productDate = productDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", goodsId=").append(goodsId);
        sb.append(", shopId=").append(shopId);
        sb.append(", name=").append(name);
        sb.append(", kind=").append(kind);
        sb.append(", price=").append(price);
        sb.append(", originCost=").append(originCost);
        sb.append(", discount=").append(discount);
        sb.append(", discountBeginDate=").append(discountBeginDate);
        sb.append(", discountEndDate=").append(discountEndDate);
        sb.append(", remainAmount=").append(remainAmount);
        sb.append(", productDate=").append(productDate);
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
        Goods other = (Goods) that;
        return (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getShopId() == null ? other.getShopId() == null : this.getShopId().equals(other.getShopId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getKind() == null ? other.getKind() == null : this.getKind().equals(other.getKind()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getOriginCost() == null ? other.getOriginCost() == null : this.getOriginCost().equals(other.getOriginCost()))
            && (this.getDiscount() == null ? other.getDiscount() == null : this.getDiscount().equals(other.getDiscount()))
            && (this.getDiscountBeginDate() == null ? other.getDiscountBeginDate() == null : this.getDiscountBeginDate().equals(other.getDiscountBeginDate()))
            && (this.getDiscountEndDate() == null ? other.getDiscountEndDate() == null : this.getDiscountEndDate().equals(other.getDiscountEndDate()))
            && (this.getRemainAmount() == null ? other.getRemainAmount() == null : this.getRemainAmount().equals(other.getRemainAmount()))
            && (this.getProductDate() == null ? other.getProductDate() == null : this.getProductDate().equals(other.getProductDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getShopId() == null) ? 0 : getShopId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getKind() == null) ? 0 : getKind().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getOriginCost() == null) ? 0 : getOriginCost().hashCode());
        result = prime * result + ((getDiscount() == null) ? 0 : getDiscount().hashCode());
        result = prime * result + ((getDiscountBeginDate() == null) ? 0 : getDiscountBeginDate().hashCode());
        result = prime * result + ((getDiscountEndDate() == null) ? 0 : getDiscountEndDate().hashCode());
        result = prime * result + ((getRemainAmount() == null) ? 0 : getRemainAmount().hashCode());
        result = prime * result + ((getProductDate() == null) ? 0 : getProductDate().hashCode());
        return result;
    }
}