package shoes.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoes.bean.UserBean;
import shoes.service.UserService;
import shoes.serviceImpl.UserServiceImpl;

/**
 * Servlet implementation class AdminDeleteUserServlet
 */
@WebServlet("/admin/AdminDeleteUserServlet")
public class AdminDeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeleteUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("content-type", "text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		UserService service = new UserServiceImpl();
		int id = Integer.parseInt(request.getParameter("id"));
		UserBean bean = new UserBean();
		bean.setId(id);
		PrintWriter out = response.getWriter();
		if(service.queryById(bean)==null){
			out.print("<script>alert('用户不存在');window.location='userInformation.jsp?#'</script>");
			out.flush();
			out.close();
		}else {
			service.deleteById(bean);
			out.print("<script>alert('删除成功');window.location='userInformation.jsp?#'</script>");
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
