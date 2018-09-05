package shoes.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoes.bean.UserBean;
import shoes.service.UserService;
import shoes.serviceImpl.UserServiceImpl;

/**
 * Servlet implementation class AdminAddUserServlet
 */
@WebServlet("/admin/AdminAddUserServlet")
public class AdminAddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddUserServlet() {
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
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		Timestamp createDate = new Timestamp(new java.util.Date(System.currentTimeMillis()).getTime());
		UserBean bean = new  UserBean(null, userName, password, email, phone, createDate, 0);
		UserService service = new UserServiceImpl();
		PrintWriter out = response.getWriter();
		if (service.queryByName(bean)==null) {
			service.add(bean);
			out.print("<script>alert('添加成功');window.location='userInformation.jsp?#'</script>");
			out.flush();
			out.close();
		}else {
			out.print("<script>alert('userName已存在');window.location='userInformation.jsp?#'</script>");
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
