package com.po;

public class Goods {
    private Integer id;
    private String gname;
    private Double goprice;
    private Double grprice;
    private Integer gstore;
    private String gpicture;

    private GoodsType goodsType;

    public Integer getId() {
        return id;
    }

    public String getGname() {
        return gname;
    }

    public Double getGoprice() {
        return goprice;
    }

    public Double getGrprice() {
        return grprice;
    }

    public Integer getGstore() {
        return gstore;
    }

    public String getGpicture() {
        return gpicture;
    }

    public GoodsType getGoodsType() {
        return goodsType;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public void setGoprice(Double goprice) {
        this.goprice = goprice;
    }

    public void setGrprice(Double grprice) {
        this.grprice = grprice;
    }

    public void setGstore(Integer gstore) {
        this.gstore = gstore;
    }

    public void setGpicture(String gpicture) {
        this.gpicture = gpicture;
    }

    public void setGoodsType(GoodsType goodsType) {
        this.goodsType = goodsType;
    }
}
