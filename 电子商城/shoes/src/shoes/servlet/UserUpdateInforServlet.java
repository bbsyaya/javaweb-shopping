package shoes.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shoes.bean.UserBean;
import shoes.service.UserService;
import shoes.serviceImpl.UserServiceImpl;

/**
 * Servlet implementation class UserUpdateInforServlet
 */
@WebServlet("/UserUpdateInforServlet")
public class UserUpdateInforServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateInforServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("content-type", "text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		HttpSession session = request.getSession();
		UserBean user1 = (UserBean)session.getAttribute("userinfor");
		UserBean user2 = new UserBean(user1.getId(), userName, password, email, phone, user1.getCreateDate(), user1.getIsadmin());
		UserService service = new UserServiceImpl();
		PrintWriter out = response.getWriter();
		if (service.queryByName(user2)==null||service.queryByName(user2).getId()==user2.getId()) {
			service.update(user2);
			session.removeAttribute("userinfor");
			session.setAttribute("userinfor", user2);
			out.print("<script>alert('信息修改成功');window.location='userUpdateInformation.jsp'</script>");
			out.flush();
			out.close();
		}else {
			out.print("<script>alert('userName已存在');window.location='userUpdateInformation.jsp'</script>");
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
