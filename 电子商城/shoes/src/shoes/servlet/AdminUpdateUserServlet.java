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
 * Servlet implementation class AdminUpdateUserServlet
 */
@WebServlet("/admin/AdminUpdateUserServlet")
public class AdminUpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpdateUserServlet() {
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
		int id = Integer.parseInt(request.getParameter("userId"));
		String userName =  request.getParameter("userName");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		UserService service = new UserServiceImpl();
		PrintWriter out = response.getWriter();
		UserBean bean = new UserBean(id, userName, password, email, phone, null, 0);
		if (service.queryByName(bean)!=null && service.queryByName(bean).getId()!=bean.getId()) {
			out.print("<script>alert('userName已存在');window.location='userInformation.jsp?#'</script>");
			out.flush();
			out.close();
		}else {
			service.update(bean);
			out.print("<script>alert('修改成功');window.location='userInformation.jsp?#'</script>");
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
