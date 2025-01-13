package servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Goods;
public class AddGoodsServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//设置编码，防止乱码
		request.setCharacterEncoding("utf-8");
		//获取参数值
		String goodsname = request.getParameter("goodsname");
		String goodsprice = request.getParameter("goodsprice");
		String goodsnumber = request.getParameter("goodsnumber");
		//下面进行类型转换
		double newgoodsprice = Double.parseDouble(goodsprice);
		int newgoodsnumber = Integer.parseInt(goodsnumber);
		//将转换后的数据封装成goods值对象
		Goods goods = new Goods(goodsname, newgoodsprice, newgoodsnumber);
		//将goods值对象传递给数据访问层，进行添加操作，代码省略
		
	}
}
