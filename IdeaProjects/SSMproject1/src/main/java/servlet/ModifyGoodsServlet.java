package servlet;

import bean.service.GoodsService;
import bean.service.impl.GoodsServiceImpl;
import bean.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modifyGoodsServlet")
//spring 管理 servlet的创建
public class ModifyGoodsServlet extends HttpServlet {
    @Autowired
    GoodsVo single;
    @Autowired
    private GoodsService goodsService;
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        AutowireCapableBeanFactory factory = wac.getAutowireCapableBeanFactory();
        factory.autowireBean(this);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        if(type!=null){
            req.setAttribute("type",type);

        if(type.equals("增加")){
           single.setGoodsId(Integer.parseInt(req.getParameter("goodsId")));
           single.setGoodsName(req.getParameter("goodsName"));
           single.setPrice(Float.valueOf(req.getParameter("price")));
           goodsService.add(single);
        }
        if(type.equals("修改")){
            single.setGoodsId(Integer.parseInt(req.getParameter("goodsId")));
            single.setGoodsName(req.getParameter("goodsName"));
            single.setPrice(Float.valueOf(req.getParameter("price")));
            goodsService.modify(single);
        }
        if(type.equals("删除")){
            goodsService.delete(Integer.parseInt(req.getParameter("goodsId")));
        }
        if(type.equals("查找")){
           single= goodsService.getGoodsById(Integer.parseInt(req.getParameter("goodsId")));
        }
        req.setAttribute("single" ,single);
        }
        req.getRequestDispatcher("modifyGoods.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
