package shoes.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoes.bean.CommodityBean;
import shoes.service.CommodityService;
import shoes.serviceImpl.CommodityServiceImpl;

/**
 * Servlet implementation class AdminDeleteCommodityServlet
 */
@WebServlet("/admin/AdminDeleteCommodityServlet")
public class AdminDeleteCommodityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeleteCommodityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("content-type", "text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		CommodityBean commodity = new CommodityBean();
		commodity.setId(id);
		CommodityService service = new CommodityServiceImpl();
		PrintWriter out = response.getWriter();
		if (service.queryById(commodity)==null) {
			out.print("<script>alert('商品在数据库中不存在');window.location='commodityInformation.jsp'</script>");
			out.flush();
			out.close();
		}else {
			service.deleteById(commodity);
			out.print("<script>alert('成功从数据库中删除');window.location='commodityInformation.jsp'</script>");
			out.flush();
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
