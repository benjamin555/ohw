<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<title>OFS Helper</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet"
	href="<%=basePath%>css/jQuery-File-Upload/jquery.fileupload-ui.css">
<%@include file="/bootstrap-header.jsp"%>
<script
	src="<%=basePath%>js/jQuery-File-Upload/vendor/jquery.ui.widget.js"></script>
<script
	src="<%=basePath%>js/jQuery-File-Upload/jquery.iframe-transport.js"></script>
<script src="<%=basePath%>js/jQuery-File-Upload/jquery.fileupload.js"></script>
<script src="<%=basePath%>js/jquery.tmpl.min.js"></script>
</head>
<body>
	<%@include file="/common/fixed-nav.jsp"%>
	<input type="hidden" value="<%=basePath%>" id="basePath" />
	<div class="container">
		<div class="jumbotron">
			<form id="eForm" role="form" action="<%=basePath%>ofshelp.action" method="post"
				enctype="multipart/form-data">
				<label for="url">查询语句:</label>
				<textarea class="form-control" rows="8" name="sql" autofocus
					required placeholder="请输入... " readonly="readonly"><s:property value="qstatement.content2String" /></textarea>
				<br /> <span class="btn btn-success fileinput-button"> <i
					class="icon-plus icon-white"></i> <span>请选择excel,可直接多选</span> <input
					id="fileupload" type="file" name="dataExcels" multiple required>
				</span> <br /> <label for="url">sheet跳过行数:</label> <input
					class="form-control" name="skipRowStr" placeholder="用逗号分隔" required
					value="<s:property value="qstatement.skipRowStr" />" readonly="readonly"  /> <br />
				<input class="btn btn-lg btn-primary " value="提交" type="submit" id="submitBtn"  />
			</form>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
$(function(){
	var basePath = $("#basePath").val();
	
	
});

</script>
