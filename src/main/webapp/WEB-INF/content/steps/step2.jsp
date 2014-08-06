<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
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
<script src="<%=basePath%>js/tab.js"></script>
</head>
<body>
	<%@include file="/common/fixed-nav.jsp"%>
	<div class="container">
		<div class="jumbotron">
			<form role="form" action="<%=basePath%>steps/step3.action"
				method="post">
				<ul id="myTab" class="nav nav-tabs" role="tablist">
					<li class="active"><a
						href="<%=basePath%>steps/step3.action#graphics">图形操作</a>
					</li>
					<li><a href="<%=basePath%>steps/step3.action#simple">精简操作</a>
					</li>
				</ul>
				<div id="myTabContent" class="tab-content">
					<div class="tab-pane fade active in" id="graphics">
						<form role="form" action="<%=basePath%>steps/step3.action"
							method="post" enctype="multipart/form-data">
							<label for="url">选择表格:</label>
								<div> excel1 </div>
								<div class="checkbox">
									<label> <input type="checkbox" value="">sheet01</label>
								</div>
								<div class="checkbox">
									<label> <input type="checkbox" value="">sheet02</label>
								</div>
								
								 <br />
								<div> excel2 </div>
								<div class="checkbox">
									<label> <input type="checkbox" value="">sheet01</label>
								</div> <br />
								
								
								 <input class="btn btn-lg btn-primary "
								value="下一步" type="submit" />
						</form>
					</div>
					<div class="tab-pane fade" id="simple">
						<p>Food truck fixie locavore, accusamus mcsweeney's marfa
							nulla single-origin coffee squid. Exercitation +1 labore velit,
							blog sartorial PBR leggings next level wes anderson artisan four
							loko farm-to-table craft beer twee. Qui photo booth letterpress,
							commodo enim craft beer mlkshk aliquip jean shorts ullamco ad
							vinyl cillum PBR. Homo nostrud organic, assumenda labore
							aesthetic magna delectus mollit. Keytar helvetica VHS salvia yr,
							vero magna velit sapiente labore stumptown. Vegan fanny pack odio
							cillum wes anderson 8-bit, sustainable jean shorts beard ut DIY
							ethical culpa terry richardson biodiesel. Art party scenester
							stumptown, tumblr butcher vero sint qui sapiente accusamus
							tattooed echo park.</p>
					</div>
				</div>
				<br /> <br /> <input class="btn btn-lg btn-primary " value="下一步"
					type="submit" />
			</form>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
	$(function() {
		$('#myTab a').click(function(e) {
			e.preventDefault();
			$(this).tab('show');
		});
	});
</script>
