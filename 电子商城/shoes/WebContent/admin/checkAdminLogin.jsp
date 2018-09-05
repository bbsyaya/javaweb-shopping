
<%@page import="shoes.bean.UserBean"%>
<%
UserBean adminBean = (UserBean)session.getAttribute("userinfor");
if(adminBean==null||adminBean.getIsadmin()==0){
	response.sendRedirect("../login.jsp");
	return;
}

%>