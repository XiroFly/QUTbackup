package dao;

import bean.vo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


public interface OrderDao {
    List<Order> getAllOrders();
    Integer insertMyOrder(Order order);
    int insertOI(@Param("orderId")Integer orderId, @Param("itemId")Integer itemId);
    List<Integer> selectDeletedItemsId(Integer orderId);
    int deleteOI(Integer orderId);
    int deleteItems(@Param("deletedItemsId")List<Integer> deletedItemsId);
    int deleteMyOrder(Integer id);
}
