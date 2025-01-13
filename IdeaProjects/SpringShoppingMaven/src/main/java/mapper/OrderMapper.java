package mapper;

import bean.vo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
@Mapper
public interface OrderMapper {
 Integer selectQuantityByGoodsId(int goodsId);
 List<Order> selectAll();
 int deleteById(int id);
void insertByOrders(@Param("orders") List<Order> orders);

 Integer getMaxId();
}
