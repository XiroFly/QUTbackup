package service;

import bean.vo.GoodsVo;
import bean.vo.Item;

import java.util.List;
import java.util.Map;

public interface ItemService {
    int modifyItem(Integer id, Integer quantity);
    int deleteItem(Integer id);
    List<Item> getCart();
    Map<Integer, Integer> getSalesByPage(List<GoodsVo> goodsList);
    int addToCart(Integer goodsId);
}
