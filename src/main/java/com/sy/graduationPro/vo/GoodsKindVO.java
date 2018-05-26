package com.sy.graduationPro.vo;

import java.util.List;

/**
 * Created by sunguiyong on 2018/5/24.
 */
public class GoodsKindVO {

    private String kindName;
    private List<String> goodsList;

    public GoodsKindVO() {
    }

    public GoodsKindVO(String kindName, List<String> goodsList) {
        this.kindName = kindName;
        this.goodsList = goodsList;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public List<String> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<String> goodsList) {
        this.goodsList = goodsList;
    }
}
