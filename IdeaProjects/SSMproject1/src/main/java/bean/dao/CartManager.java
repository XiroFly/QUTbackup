package bean.dao;

import java.util.ArrayList;
import java.util.Iterator;

import bean.Item;
import bean.vo.GoodsVo;

public interface CartManager {
	ArrayList<Item> cart = new ArrayList<Item>();
	public void addToCart(Item newItem);

	public void update(int goodsId, int quantity);
	public void delete(Item item);
	
	public ArrayList<Item> getCart() ;
	public void setCart(ArrayList<Item> cart) ;
}
