<%@page import="shoes.bean.UserBean"%>
<%
UserBean userBean = (UserBean)session.getAttribute("userinfor");
if(userBean==null){
	response.sendRedirect("login.jsp");
	return;
}

%>