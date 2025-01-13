package service.impl;

import bean.vo.Item;
import mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service("itemService")
@Transactional
public class ItemService implements service.ItemService {
    @Autowired
    ItemMapper itemMapper;
    public void insert(Item item){
       insertByParam(item.getGoods().getGoodsId(),item.getQuantity());
    }
    public void insertByParam(int goodsid,int quantity){
        Item newitem = itemMapper.selectById(goodsid);
        if(newitem==null)
            itemMapper.insertByParam(goodsid,quantity);
        else itemMapper.update(goodsid, quantity);
    }

    public void delete(Integer goodsId){
    itemMapper.delete(goodsId);
    }

    @Override
    public void deleteAll() {
        itemMapper.deleteAll();
    }

    public void update(Integer goodsId, int quantity){
    itemMapper.update( goodsId, quantity);
    }
    public ArrayList<Item> selectAll(){
        return(ArrayList<Item>) itemMapper.selectAll();
    }
    public ArrayList<Item> getCart() {
        return selectAll();
    }



}
