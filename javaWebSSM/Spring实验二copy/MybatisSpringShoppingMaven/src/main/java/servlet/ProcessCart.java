package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.vo.Item;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import service.ItemService;

@Controller
@WebServlet("/processCart")
public class ProcessCart extends HttpServlet {

	@Autowired
	private ItemService itemService;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		AutowireCapableBeanFactory factory = wac.getAutowireCapableBeanFactory();
		factory.autowireBean(this);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String type = request.getParameter("action");
		Integer id = Integer.parseInt(request.getParameter("id"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		if(type.equalsIgnoreCase("修改")){
			int rst = itemService.modifyItem(id, quantity);
			if (rst != 1) {
				String errorMessage = "修改购物车商品出错!";
				request.setAttribute("resultMessage", errorMessage);
			} else {
				String infoMessage = "修改购物车商品成功!";
				request.setAttribute("resultMessage", infoMessage);
			}

		}
		if(type.equalsIgnoreCase("删除")){
			int rst = itemService.deleteItem(id);
			if (rst != 1) {
				String errorMessage = "删除购物车商品出错!";
				request.setAttribute("resultMessage", errorMessage);
			} else {
				String infoMessage = "删除购物车商品成功!";
				request.setAttribute("resultMessage", infoMessage);
			}
		}

		List<Item> cart = itemService.getCart();
		request.setAttribute("cart", cart);

		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doGet(request,response);
	}


}
