<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@include file="/bootstrap-header.jsp"%>

  </head>
  
  <body>
     <h1>用户登录</h1> 
    <div class="container">
		<form class="form-signin" action="j_spring_security_check"  method="post">
			<label for="userName">帐号：</label><input
				class="form-control" name="j_username" placeholder="帐号" required autofocus /><label
				for="password">密码:</label> <input class="form-control"
				name="j_password" type="password" placeholder=" 密码" required /><br />
			<input class="btn btn-lg btn-primary btn-block" value="提交"
				type="submit" />
		</form>
	</div>
  </body>
</html>
