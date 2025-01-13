package service.impl;

import java.util.ArrayList;
import java.util.Iterator;

import bean.vo.Item;
import bean.vo.GoodsVo;
import org.springframework.stereotype.Service;
import service.CartService;
import service.GoodsService;

import javax.annotation.Resource;

@Service("cartService")
public class CartServiceImpl implements CartService {
	@Resource(name="goodsService")
    GoodsService goodsService;

	ArrayList<Item> cart = new ArrayList<Item>();
	
	public void addToCart(Integer goodsId, int quantity){
		GoodsVo g = goodsService.getGoodsById(goodsId);
		
		Iterator<Item> it = cart.iterator();
		boolean find = false;
		while(it.hasNext()){
			Item oneItem = it.next();
			if(oneItem.getGoods().getGoodsId() == goodsId){
				oneItem.setQuantity(oneItem.getQuantity() + quantity);
				find = true;
			}
		}
		if(!find){
				Item newItem = new Item();
				newItem.setQuantity(quantity);
				newItem.getGoods().setGoodsName(g.getGoodsName());
				newItem.getGoods().setPrice(g.getPrice());
				newItem.getGoods().setGoodsId(goodsId);
				cart.add(newItem);
		}
	}

	public void update(Integer goodsId, int quantity){
//		System.out.println(goodsId);
		Iterator<Item> it = cart.iterator();
		while(it.hasNext()){
			Item oneItem = it.next();
			if(oneItem.getGoods().getGoodsId() == goodsId){
				oneItem.setQuantity(quantity);
				break;
			}
		}
		
	}
	
	public void delete(Integer goodsId){
		if(cart != null){
			Iterator it = cart.iterator();
			while(it.hasNext()){
				Item temp = (Item)it.next();
				Integer tGoodsId = temp.getGoods().getGoodsId();
				
				if(tGoodsId.equals(goodsId)){
					cart.remove(temp);
					break;
				}
				
			}//while
			
		}//if
	}
	
	
	public ArrayList<Item> getCart() {
		return cart;
	}

	public void setCart(ArrayList<Item> cart) {
		this.cart = cart;
	}
}
