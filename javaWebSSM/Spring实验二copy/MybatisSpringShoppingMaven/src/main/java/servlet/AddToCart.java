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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import service.ItemService;

@Controller
@WebServlet("/addToCart")
public class AddToCart extends HttpServlet {

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

		response.setContentType("text/html;charset=utf-8");


		Integer goodsId = Integer.parseInt(request.getParameter("goodsId"));

		int rst = itemService.addToCart(goodsId);
		if(rst != 1){
			String errorMessage = "添加商品出错!";
			request.setAttribute("resultMessage",errorMessage);
		}else{
			String infoMessage = "添加商品成功!";
			request.setAttribute("resultMessage",infoMessage);
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
