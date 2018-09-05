package shoes.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoes.bean.CategoryBean;
import shoes.service.CategoryService;
import shoes.serviceImpl.CategoryServiceImpl;

/**
 * Servlet implementation class AdminDeleteCategoryServlet
 */
@WebServlet("/admin/AdminDeleteCategoryServlet")
public class AdminDeleteCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeleteCategoryServlet() {
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
		CategoryService service = new CategoryServiceImpl();
		CategoryBean category = new CategoryBean();
		category.setId(id);
		
		PrintWriter out = response.getWriter();
		if (service.queryById(category)==null) {
			out.print("<script>alert('category不存在');window.location='categoryInformation.jsp'</script>");
			out.flush();
			out.close();
		}else {
			service.deleteById(category);
			out.print("<script>alert('删除成功');window.location='categoryInformation.jsp'</script>");
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
