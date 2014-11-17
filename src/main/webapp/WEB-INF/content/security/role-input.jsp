<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'role-input.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@include file="/bootstrap-header.jsp"%>

  </head>
  
  <body>
  <div class="container">
  	<form id="modelForm" role="form" action="<%=basePath%>security/role!save.action" method="post">
  		<input type="hidden" name="id" value="<s:property value="model.id" />" >
  		<label for="name">名称:</label><input  class="form-control" type="text" name="name" value="<s:property value="model.name" />" />
  		</br>
  		<input class="btn btn-lg btn-primary " value="提交" type="submit" id="submitBtn"  />
  		<input class="btn btn-lg btn-primary " value="返回" url="<%=basePath%>security/role.action" type="button" id="backBtn"  />
  	</form>
  </div>
  </body>
</html>
<script type="text/javascript">
 $(function(){
	 
	 $("#backBtn").click(function(){
		 window.location.href =$(this).attr("url");
	 });
	 
	 
 });


</script>