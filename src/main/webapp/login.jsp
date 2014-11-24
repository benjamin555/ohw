<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java"
	import="org.springframework.security.web.WebAttributes"%>
<%@ page language="java"
	import="org.springframework.security.core.AuthenticationException"%>
	
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Object obj = session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
String msg="";
if(obj!=null){
	AuthenticationException authException = (AuthenticationException)obj;
	msg = authException.getMessage();
}
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
	<div>
		<span style="color:red"><%=msg %></span>
	</div>
	<div class="container">
		<form class="form-signin" action="login.action"
			method="post">
			<label for="userName">帐号：</label><input class="form-control"
				name="userName" placeholder="帐号" required autofocus /><label
				for="password">密码:</label> <input class="form-control"
				name="password" type="password" placeholder=" 密码" required />
				<label for="remember">记住我?</label>
				<input type="checkbox" id="remember"
				name="_spring_security_remember_me"
				value="true"/>
				
				<br />
			<input class="btn btn-lg btn-primary btn-block" value="提交"
				type="submit" />
		</form>
	</div>
</body>
</html>
