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
	<div class="container">
		<div class="jumbotron">
			<form role="form" action="<%=basePath%>steps/step2.action" method="post"
				enctype="multipart/form-data">
				<span class="btn btn-success fileinput-button"> <i
					class="icon-plus icon-white"></i> <span>请选择excel,可直接多选</span> <input
					id="fileupload" type="file" name="dataExcels" multiple required>
				</span> <br />  <br />
				<input class="btn btn-lg btn-primary " value="下一步" type="submit" />
			</form>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">

</script>
