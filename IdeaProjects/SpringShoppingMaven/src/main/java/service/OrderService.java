package service;

import bean.vo.Item;
import bean.vo.Order;
import bean.vo.OrderView;

import java.util.List;

public interface OrderService {

    int deleteOrder(Integer orderId);

    List<OrderView> getAllOrders();

    int insertOrder(List<Item> cart);
}
