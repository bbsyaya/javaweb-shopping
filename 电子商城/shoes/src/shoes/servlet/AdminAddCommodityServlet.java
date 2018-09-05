package shoes.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoes.bean.CommodityBean;
import shoes.service.CommodityService;
import shoes.serviceImpl.CommodityServiceImpl;

/**
 * Servlet implementation class AdminAddCommodityServlet
 */
@WebServlet("/admin/AdminAddCommodityServlet")
public class AdminAddCommodityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddCommodityServlet() {
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
		CommodityBean commodity = new CommodityBean();
		CommodityService service = new CommodityServiceImpl();
		service.upload(request, response, commodity);
		PrintWriter out = response.getWriter();
		Timestamp createDate = new Timestamp(new java.util.Date(System.currentTimeMillis()).getTime());
		commodity.setCreateDate(createDate);
		service.add(commodity);
		out.print("<script>alert('添加成功');window.location='commodityInformation.jsp'</script>");
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
