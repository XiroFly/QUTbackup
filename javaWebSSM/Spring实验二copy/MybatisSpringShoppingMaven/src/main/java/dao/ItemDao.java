package dao;

import bean.vo.Item;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ItemDao {
    List<Item> getCartItems();
    List<Item> getItemById(Integer goodsId);

    int insertItem(Integer goodsId);
    int modifyItem(@Param("id")Integer id, @Param("quantity")Integer quantity);
    int deleteItem(Integer id);
}
