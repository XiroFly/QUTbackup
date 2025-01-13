package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import service.GoodsService;
import service.ItemService;

@Controller
@WebServlet("/getAllGoods")
public class GetAllGoods extends HttpServlet {

	@Autowired
	private GoodsService goodsService;
	@Autowired
	private ItemService itemService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		AutowireCapableBeanFactory factory = wac.getAutowireCapableBeanFactory();
		factory.autowireBean(this);
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String pageNo = request.getParameter("pageNo");
		int page = 1;
		if(pageNo != null){
			page = Integer.parseInt(pageNo);
		}

		List<GoodsVo> goodsList = this.goodsService.getGoodsByPage(page);

		Map<Integer, Integer> sales = itemService.getSalesByPage(goodsList);

		int pageCount = this.goodsService.getPageCount();
		System.out.println(sales);
		request.setAttribute("goodsList", goodsList);
		request.setAttribute("sales", sales);
		request.setAttribute("pageNo", page);
		request.setAttribute("pageCount", pageCount);

		String forward = "goodsList.jsp";

		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
