package service.impl;

import bean.vo.Order;
import dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.OrderService;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

    @Override
    public int insertOrder(List<Integer> itemsId) {
        int count = 0;
        Order order = new Order();
        Date nowTime = new Date();
        order.setCreatedTime(nowTime);
        count += orderDao.insertMyOrder(order);
        Iterator<Integer> iterator = itemsId.iterator();
        while (iterator.hasNext()) {
            Integer itemId = iterator.next();
            count += orderDao.insertOI(order.getId(), itemId);
        }
        return count;
    }

    @Override
    public int deleteOrder(Integer orderId) {
        int count = 0;
        List<Integer> deletedItemsId = orderDao.selectDeletedItemsId(orderId);
        count += orderDao.deleteOI(orderId);
        count += orderDao.deleteItems(deletedItemsId);
        count += orderDao.deleteMyOrder(orderId);
        return count;
    }

}
