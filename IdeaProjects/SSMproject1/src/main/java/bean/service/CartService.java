package bean.service;

import bean.Item;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
public interface CartService {
//    ArrayList<Item> cart = new ArrayList<Item>();
    public void addToCart(int goodsId, int quantity);

    public void update(int goodsId, int quantity);
    public void delete(int goodsId);

    public ArrayList<Item> getCart() ;
    public void setCart(ArrayList<Item> cart) ;
}
