package com.sy.graduationPro.vo;

import com.sy.graduationPro.bean.GoodsOrder;

/**
 * Created by Amos on 2018/6/7.
 */
public class GoodsOrderVO {
    private String orderNum;
    private String price;
    private String quantity;
    private String addTime;
    private String sellName;
    private String pic;

    public GoodsOrderVO (GoodsOrder goodsOrder){
        this.orderNum = goodsOrder.getOrderNum();
        this.price = goodsOrder.getPrice().toString();
        this.quantity = goodsOrder.getQuantity().toString();
        String time = goodsOrder.getAddTime().toString().split(" ")[0];
        this.addTime = time;
    }
    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
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

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getSellName() {
        return sellName;
    }

    public void setSellName(String sellName) {
        this.sellName = sellName;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
