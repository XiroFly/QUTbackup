package service.impl;

import bean.vo.GoodsVo;
import bean.vo.Item;
import bean.vo.Order;
import bean.vo.OrderView;
import mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("orderService")
@Transactional
public class OrderService implements service.OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Override
    public int deleteOrder(Integer orderId) {
       int i= orderMapper.deleteById(orderId);
        return i;
    }

    @Override
    public List<OrderView> getAllOrders() {
        List<Order> list=orderMapper.selectAll();
        List<OrderView> listView=new ArrayList<>();
        for(Order i: list){
            boolean in =false;
            for(OrderView orderView:listView){
                if(orderView.getId()==i.getId()){
                orderView.addToList(i.getGoodsVo(),i.getQuantity());
                in=true;
                break;
                }
            }
            if(!in){
                OrderView newone = new OrderView();
                newone.setId(i.getId());
                newone.setCreatedTime(i.getCreatedTime());
                newone.addToList(i.getGoodsVo(),i.getQuantity());
                listView.add(newone);
            }
        }
        return listView;
    }

    @Override
    public int insertOrder(List<Item> cart) {
        Date date=new Date();
        Integer id= orderMapper.getMaxId();
        if(id==null)id=0;
        else id=orderMapper.getMaxId()+1;
      List<Order> list=new ArrayList<Order>();
        for (Item i : cart) {
            Order order=new Order();
            order.setId(id);
            order.setQuantity(i.getQuantity());
            order.setCreatedTime(date);
            order.setGoodsVo(i.getGoods());
            list.add(order);
        }
         orderMapper.insertByOrders(list);
      return 1;
    }
}
