package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.vo.Item;
import org.springframework.stereotype.Controller;
import service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import service.ItemService;

@Controller
@WebServlet("/processCart")
public class ProcessCart extends HttpServlet {

	@Autowired
	ItemService itemService;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		AutowireCapableBeanFactory factory = wac.getAutowireCapableBeanFactory();
		factory.autowireBean(this);
	}


	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	  	
		String type = request.getParameter("action");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		Integer id = Integer.parseInt(request.getParameter("id"));

//		System.out.println(goodsId);
		if(type.equalsIgnoreCase("修改")){
			itemService.update(id,quantity);
			String infoMessage = "修改购物车商品成功!";
			request.setAttribute("resultMessage", infoMessage);
		}
		if(type.equalsIgnoreCase("删除")){
			itemService.delete(id);
			String infoMessage = "删除购物车商品成功!";
			request.setAttribute("resultMessage", infoMessage);
		}
		List<Item> cart = itemService.getCart();
		request.setAttribute("cart", cart);

		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
