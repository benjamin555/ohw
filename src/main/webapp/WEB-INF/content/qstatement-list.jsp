<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'qstatement-list.jsp' starting page</title>
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
		<div class="jumbotron">
			<!-- Nav tabs -->
			<ul class="nav nav-tabs" role="tablist" id="myTab">
				<li role="presentation" class="active"><a href="#self"
					role="tab" data-toggle="tab">自建</a>
				</li>
				<li role="presentation"><a href="#shared" role="tab"
					data-toggle="tab">分享</a>
				</li>
			</ul>
			<!-- Tab panes -->
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="self">
					<%@include file="_item-list.jsp"%>
				</div>
				<div role="tabpanel" class="tab-pane" id="shared"><%@include file="_item-list.jsp"%></div>
			</div>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
$(function () {
    //$('#myTab a:last').tab('show')
  })

</script>