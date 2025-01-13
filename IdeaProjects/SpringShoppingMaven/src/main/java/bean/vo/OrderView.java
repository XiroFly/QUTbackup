package bean.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderView {
    public OrderView(){
        itemView=new ArrayList<Link>();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
    private int id;
    private Date createdTime;
    public class Link{
        int quantity;
    GoodsVo goodsVo;

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public GoodsVo getGoodsVo() {
            return goodsVo;
        }

        public void setGoodsVo(GoodsVo goodsVo) {
            this.goodsVo = goodsVo;
        }
    }

    private List<Link> itemView;

    public List<Link> getItemView() {
        return itemView;
    }

    public void setItemView(List<Link> itemView) {
        this.itemView = itemView;
    }

    public void addToList(GoodsVo goodsVo, int quantity ){
        Link link=new Link();
        link.goodsVo=goodsVo;
        link.quantity=quantity;
        itemView.add(link);
    }
}

