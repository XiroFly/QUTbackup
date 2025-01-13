package mapper;

import bean.vo.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ItemMapper {
  List<Item> selectAll();
  Integer selectQuantityById(int id);
  public int selectIdExistence(int id) ;
  void update(@Param("goodsid")int goodsid,@Param("quantity")int quantity);
  void delete(int id);

  Item selectById(Integer goodsId);

  void insertItem(Item newitem);
  void insertByParam(@Param("goodsid")int goodsid,@Param("quantity")int quantity);

  void deleteAll();
}
