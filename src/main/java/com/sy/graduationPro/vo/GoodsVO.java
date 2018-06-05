package com.sy.graduationPro.vo;

import com.sy.graduationPro.bean.Goods;

/**
 * Created by Amos on 2018/6/4.
 */
public class GoodsVO {
    private String goodsName;
    private Integer goodsId;
    private String goodsPic;

    public GoodsVO(Goods goods){
        this.goodsName = goods.getName();
        this.goodsPic = goods.getGoodsPic();
        this.goodsId = goods.getId();
    }

    public String getGoodsPic() {
        return goodsPic;
    }

    public void setGoodsPic(String goodsPic) {
        this.goodsPic = goodsPic;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
}
