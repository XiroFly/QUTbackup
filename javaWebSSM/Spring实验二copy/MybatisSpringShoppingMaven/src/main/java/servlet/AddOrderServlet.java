package servlet;

import bean.vo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import service.ItemService;
import service.OrderService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@WebServlet("/addOrder")
@Controller
public class AddOrderServlet extends HttpServlet {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ItemService itemService;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        AutowireCapableBeanFactory factory = wac.getAutowireCapableBeanFactory();
        factory.autowireBean(this);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Item> cart = itemService.getCart();
        Iterator<Item> iterator = cart.iterator();
        List<Integer> itemsId = new ArrayList<>();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            itemsId.add(item.getId());
        }
        int rst = orderService.insertOrder(itemsId);
        if (rst == 0) {
            String errorMessage = "添加订单出错！";
            request.setAttribute("resultMessage", errorMessage);
        } else {
            String infoMessage = "添加订单成功！";
            request.setAttribute("resultMessage", infoMessage);
        }

        request.getRequestDispatcher("showCart").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
