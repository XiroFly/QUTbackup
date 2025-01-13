package service;

import bean.vo.Item;

import java.util.ArrayList;

public interface ItemService {
    void insert(Item item);
    public void insertByParam(int goodsid,int quantity);
    void delete(Integer goodsId);
    void deleteAll();
    void update(Integer goodsId, int quantity);
    public ArrayList<Item> selectAll();
    public ArrayList<Item> getCart();
}
