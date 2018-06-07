package com.sy.graduationPro.vo;

import com.sy.graduationPro.bean.SellGoods;

/**
 * Created by Amos on 2018/6/3.
 */
public class GoodsSellVO {

    private Integer goodsId;
    private Integer storeId;
    private String sellName;
    private String price;
    private String quantity;
    private String pic;
    private String goodsName;
    private String sellNum;

    public GoodsSellVO(SellGoods sellGoods) {
        this.sellName = sellGoods.getName();
        this.price = sellGoods.getPrice();
        this.quantity = sellGoods.getQuantity();
        this.pic = sellGoods.getPic();
        this.sellNum = sellGoods.getSellNum();
        this.goodsId = sellGoods.getGoodsId();
        this.storeId = sellGoods.getStoreId();
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getSellNum() {
        return sellNum;
    }

    public void setSellNum(String sellNum) {
        this.sellNum = sellNum;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getSellName() {
        return sellName;
    }

    public void setSellName(String sellName) {
        this.sellName = sellName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
