package bean;

import bean.vo.GoodsVo;

public class Item {
	private GoodsVo goods;
	private int quantity;
	
	public Item(GoodsVo g, int quantity){
		this.setGoods(g);
		this.setQuantity(quantity);
	}
	
	
	public GoodsVo getGoods() {
		return goods;
	}
	public void setGoods(GoodsVo goods) {
		this.goods = goods;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
}
