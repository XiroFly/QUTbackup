package bean.vo;

import org.springframework.stereotype.Component;

@Component
public class Item {
    private Integer id;
    private GoodsVo goodsVo;
    private Integer quantity;

    public Item() {
    }

    public Item(Integer id, GoodsVo goodsVo, Integer quantity) {
        this.id = id;
        this.goodsVo = goodsVo;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GoodsVo getGoodsVo() {
        return goodsVo;
    }

    public void setGoodsVo(GoodsVo goodsVo) {
        this.goodsVo = goodsVo;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", goodsVo=" + goodsVo +
                ", quantity=" + quantity +
                '}';
    }
}
