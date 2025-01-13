package service;


import bean.vo.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    int insertOrder(List<Integer> itemsId);
    int deleteOrder(Integer orderId);
}
