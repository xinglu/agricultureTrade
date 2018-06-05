package com.sy.graduationPro.vo;

import com.sy.graduationPro.bean.SellGoods;

/**
 * Created by Amos on 2018/6/3.
 */
public class GoodsSellVO {

    private String sellName;
    private String price;
    private Integer quantity;
    private String pic;
    private String goodsName;

    public GoodsSellVO(SellGoods sellGoods) {
        this.sellName = sellGoods.getName();
        this.price = sellGoods.getPrice().toString();
        this.quantity = sellGoods.getQuantity();
        this.pic = sellGoods.getPic();
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
