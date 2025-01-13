package bean.service.impl;

import bean.Item;
import bean.dao.CartManager;
import bean.dao.GoodsDAO;
import bean.service.CartService;
import bean.service.GoodsService;
import bean.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
@Service("cartService")
public class CartServiceImpl implements CartService {
    @Autowired
    GoodsDAO goodsDAO;
    @Autowired
    CartManager cartManager;

    public void addToCart(int goodsId, int quantity){
        ArrayList<Item> cart= cartManager.getCart();
        GoodsVo g = goodsDAO.getGoodsById(goodsId);
        Iterator<Item> it = cart.iterator();
        boolean find = false;
        while(it.hasNext()){//查看购物车里是否已经有此物品
            Item oneItem = it.next();
            if(oneItem.getGoods().getGoodsId()==goodsId){
                oneItem.setQuantity(oneItem.getQuantity() + quantity);
                find = true;
            }
        }
        if(!find){
            Item newItem = new Item(g,quantity);
             cartManager.addToCart(newItem);
        }
    }

    public void update(int goodsId, int quantity) {
        cartManager.update(goodsId, quantity);
    }

    public void delete(int goodsId){
        ArrayList<Item> cart= cartManager.getCart();
        if(cart != null){
            Iterator it = cart.iterator();
            while(it.hasNext()){
                Item temp = (Item)it.next();
                int tGoodsId = temp.getGoods().getGoodsId();

                if(tGoodsId==goodsId){
                    cartManager.delete(temp);
                    break;
                }

            }//while

        }//if
    }


    public ArrayList<Item> getCart() {
       return cartManager.getCart();
    }

    public void setCart(ArrayList<Item> cart) {
        cartManager.setCart(cart);
    }
}
