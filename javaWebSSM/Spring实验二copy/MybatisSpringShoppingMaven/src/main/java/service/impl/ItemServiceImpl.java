package service.impl;

import bean.vo.GoodsVo;
import bean.vo.Item;
import dao.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.ItemService;

import java.util.*;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;
    @Override
    public int modifyItem(Integer id, Integer quantity) {
        int rst = -1;
        rst = itemDao.modifyItem(id, quantity);
        return rst;
    }

    @Override
    public int deleteItem(Integer id) {
        int rst = -1;
        rst = itemDao.deleteItem(id);
        return rst;
    }
    public List<Item> getCart() {
        return itemDao.getCartItems();
    }
    @Override
    public Map<Integer, Integer> getSalesByPage(List<GoodsVo> goodsList) {
        Map<Integer, Integer> sales = new HashMap<Integer, Integer>();

        Iterator<GoodsVo> iteratorGoods = goodsList.iterator();
        while (iteratorGoods.hasNext()) {
            GoodsVo goods = iteratorGoods.next();
            Integer goodsId = goods.getGoodsId();
            sales.put(goodsId, 0);

            List<Item> items = itemDao.getItemById(goodsId);
            Iterator<Item> iteratorItem = items.iterator();
            while (iteratorItem.hasNext()) {
                Item item = iteratorItem.next();
                sales.put(goodsId, sales.get(goodsId) + item.getQuantity());
            }
        }
        return sales;
    }
    @Override
    public int addToCart(Integer goodsId) {
        int rst = -1;
        List<Item> cart = this.getCart();
        if (cart == null) {
            cart = new ArrayList<Item>();
        }
        Iterator<Item> iterator = cart.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            System.out.println(item.getGoodsVo());
            System.out.println(item.getQuantity());
            if (item.getGoodsVo().getGoodsId() == goodsId) {
                rst = itemDao.modifyItem(item.getId(), item.getQuantity() + 1);
                return rst;
            }
        }
        rst = itemDao.insertItem(goodsId);
        return rst;
    }
}
