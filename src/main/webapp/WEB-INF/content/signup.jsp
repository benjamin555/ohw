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
<title>注册</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<%@include file="/bootstrap-header.jsp"%>

</head>
<body>
	<%@include file="/common/fixed-nav.jsp"%>

	<div class="container">
		<form id="modelForm" role="form" action="<%=basePath%>signup!save.action" method="post">
			<input type="hidden" name="id" value="<s:property value="model.id" />"> 
			<label class="form-label">用户名:</label><input class="form-control" type="text" name="userName" value="<s:property value="model.userName" />" required /> 
			<label class="form-label">密码:</label><input class="form-control" id="password" type="password" name="password" value="" required />
			<div id="rPasswordDiv" class="form-group">
			<label class="form-label" for="rPassword">再输一次密码:</label><input class="form-control" id="rPassword" type="password" value="" required />
			</div>
			<s:hidden name="model.roles[0].id" value="2"></s:hidden>
	</br>
	<input class="btn btn-lg btn-primary " value="提交" type="submit"
		id="submitBtn" />
	<input class="btn btn-lg btn-primary " value="返回"
		url="<%=basePath%>" type="button" id="backBtn" />
	</form>
	</div>
	
	
	
</body>
</html>
<script type="text/javascript">
	$(function() {

		$("#backBtn").click(function() {
			window.location.href = $(this).attr("url");
		});
		
		$("#modelForm").submit(function(){
			var p1 = $("#password").val();
			var p2 = $("#rPassword").val();
			if(p1!=p2){
				alert("前后两次输入的密码不一致！");
				$("#rPasswordDiv").addClass("has-error");
				$("#rPassword").focus();
				return false;
			}
			return true;
		});
		
	});
</script>