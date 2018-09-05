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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String  userName  = request.getParameter("userName");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		UserBean bean = new UserBean();
		bean.setUserName(userName);
		bean.setPassword(password);
		UserService service = new UserServiceImpl();
		UserBean bean2 = service.queryByName(bean);
		if(bean2==null){
			out.print("<script>alert('用户不存在');window.location='login.jsp'</script>");
			out.flush();
			out.close();
		}else{
			
			if (bean2.getPassword().equals(password)) {
				HttpSession session = request.getSession();
				session.setAttribute("userinfor", bean2);
				if (bean2.getIsadmin()==1) {
					response.sendRedirect("admin/adminindex.jsp");
				}else {
					response.sendRedirect("index.jsp");
				}
			}else {
				out.print("<script>alert('密码错误');window.location='login.jsp'</script>");
				out.flush();
				out.close();
			}
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
