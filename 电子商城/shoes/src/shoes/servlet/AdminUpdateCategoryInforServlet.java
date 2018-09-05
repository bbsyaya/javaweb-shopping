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
 * Servlet implementation class AdminUpdateCategoryInforServlet
 */
@WebServlet("/admin/AdminUpdateCategoryInforServlet")
public class AdminUpdateCategoryInforServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpdateCategoryInforServlet() {
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
		int id = Integer.parseInt(request.getParameter("categoryId"));
		int sort = Integer.parseInt(request.getParameter("sort"));
		String categoryName = request.getParameter("categoryName");
		String description = request.getParameter("description");
		CategoryBean category = new CategoryBean(id, categoryName, description, sort);
		CategoryService service = new CategoryServiceImpl();
		PrintWriter out = response.getWriter();
		
		if (service.queryByName(category)==null||service.queryByName(category).getId()==id) {
			service.update(category);
			out.print("<script>alert('修改成功');window.location='categoryInformation.jsp?#'</script>");
			out.flush();
			out.close();
		}else {
			out.print("<script>alert('categoryName已存在');window.location='categoryInformation.jsp?#'</script>");
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
