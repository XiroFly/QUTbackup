package bean.dao.impl;

import bean.Item;
import bean.dao.CartManager;
import bean.dao.GoodsDAO;
import bean.service.GoodsService;
import bean.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
@Repository("cartManager")
public class CartManagerImpl implements CartManager {

	ArrayList<Item> cart = new ArrayList<Item>();
	
	public void addToCart(Item newItem){
				cart.add(newItem);
	}

	public void update(int goodsId, int quantity){
		Iterator<Item> it = cart.iterator();
		while(it.hasNext()){
			Item oneItem = it.next();
			if(oneItem.getGoods().getGoodsId() == goodsId){
				oneItem.setQuantity(quantity);
				break;
			}
		}
		
	}
	public void delete(Item item){
					cart.remove(item);
	}
	
	
	public ArrayList<Item> getCart() {
		return cart;
	}

	public void setCart(ArrayList<Item> cart) {
		this.cart = cart;
	}
}
