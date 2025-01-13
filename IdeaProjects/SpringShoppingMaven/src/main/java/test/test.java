
import bean.vo.GoodsVo;
import bean.vo.Item;
import bean.vo.Order;
import bean.vo.OrderView;
import mapper.GoodsMapper;
import mapper.ItemMapper;
import mapper.OrderMapper;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.impl.OrderService;

import java.util.List;
public class test {

   private GoodsMapper goodsMapper;
   private ItemMapper itemMapper;

   @Test
   public void testSomething() {
      // 手动加载 XML 配置文件
      try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
         // 从上下文中获取 GoodsMapper bean
         itemMapper = context.getBean(ItemMapper.class);

//         OrderMapper orderMapper = context.getBean(OrderMapper.class);
         OrderMapper orderMapper=context.getBean(OrderMapper.class);;
         List<Item> orders = itemMapper.selectAll();
         for(Item i :orders){
            System.out.println(i.getQuantity());
            System.out.println("x");
         }
//         List<GoodsVo> list = goodsMapper.getGoodsByPage(0,1);
//         for(GoodsVo i :list){
//            System.out.println(i.getGoodsId()+i.getGoodsName()+i.getPrice());
//            System.out.println("1");
//         }
         // 在这里可以使用 goodsMapper 进行测试
         // 例如，调用 goodsMapper 的方法并进行断言
      }
   }
}
