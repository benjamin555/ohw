<%@ page language="java" pageEncoding="UTF-8"%>
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
<style type="text/css">
.demoImg {
	margin-bottom: 20px;
}

.demoImg img {
	width: 600px;
}
</style>
<link rel="stylesheet" href="<%=basePath%>css/docs.min.css">
<%@include file="/bootstrap-header.jsp"%>
</head>
<body>
	<%@include file="/common/fixed-nav.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-9">
				<div>
					<div class="page-header">
						<h1>简介</h1>
						<p class="lead">通过下述的例子，用户可以了解如何简单使用该工具。</p>
					</div>
					<p id="data" style="height: 40px;"></p>
					<h1 >数据准备</h1>
					<p>
						准备两个excel，他们分别为<a href="<%=basePath%>xls/d1.xlsx">d1.xlsx</a>和<a
							href="<%=basePath%>xls/d2.xlsx">d2.xlsx</a>。其中d1中有两个sheet，d2中只有一个sheet。
							<strong>建议使用的excel的标题行为1</strong>。如果某个sheet的标题行不为1，可以使用“<a href="<%=basePath%>ofshelp!demo.action#skip">跳过标题行</a>”进行设置。它们的数据分别如下所示：
					</p>
					<div class="demoImg">
						<img src="<%=basePath%>image/demo01.png" class="img-rounded">
					</div>
					<div class="demoImg">
						<img src="<%=basePath%>image/demo02.png" class="img-rounded">
					</div>
					<div class="demoImg">
						<img src="<%=basePath%>image/demo03.png" class="img-rounded">
					</div>
					<p id="sql" style="height: 40px;"></p>
					<h1 >查询语句编写</h1>
					<p>
						将下述语句输入,对应的文本框。查询语句，完全遵守sql规则。<a
							href="http://www.w3school.com.cn/sql/sql_select.asp">详细见此</a>
					<p>
					<p>select t1.*,t2.c2,t2.c3,t3.c2,t3.c2 as 物料组描述 from t1 join t2
						on t2.c1 =t1.c1 join t3 on t2.c3 =t3.c1 order by t1.c1</p>
					<div class="demoImg">
						<img src="<%=basePath%>image/demo04.png" class="img-rounded">
					</div>
					<ul>
						解释:
						<li>select
							t1.*:选择表1(d1.xsl的sheet01)的全部列，如果你想选择表2的全部列，可以写成t2.*;</li>
						<li>t2.c2:表示表二的第二列；</li>
						<li>t3.c2:表示表三的第三列，并改列名为“物料组描述”；</li>
						<li>select
							t1.*:选择表1(d1.xsl的sheet01)的全部列，如果你想选择表2的全部列，可以写成t2.*;</li>
						<li>from t1：表示从表1进行查询；</li>
						<li>join t2 on t2.c1 =t1.c1：表示通过表1的第一列和表2的第二列，连接表2；</li>
					</ul>
					
					<p id="upload" style="height: 40px;"></p>
					<h1  >选择上传文件</h1>
					<p>点击“选择文件”按钮，选择要上传的excel。注意文件的命名规则，建议在原有文件名前加入数字，即“1d1”和“2d2”，系统会根据文件名前的数字进行排序，以匹配查询语句中的表。</p>
					<div class="demoImg">
						<img src="<%=basePath%>image/demo05.png" class="img-rounded">
					</div>
					
					<p  id="skip" style="height: 40px;"></p>
					<h1>跳过的标题行</h1>
					<p>在"sheet跳过行数"，输入各个sheet的标题行数，即为列名的部分的行数，用逗号进行分隔。本例子为均为1，总共有三个sheet，则输入"1,1,1"</p>
					<div class="demoImg">
						<img src="<%=basePath%>image/demo06.png" class="img-rounded">
					</div>
					
					<p  id="result" style="height: 40px;"></p>
					<h1 >结果</h1>
					<p>点击“提交”按钮，导出新的excel。格式如下所示：</p>
					<div class="demoImg">
						<img src="<%=basePath%>image/demo07.png" class="img-rounded">
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="bs-docs-sidebar hidden-print hidden-xs hidden-sm affix" style="top: auto;"
					role="complementary">
					<ul class="nav bs-docs-sidenav" style="">
						<li ><a href="<%=basePath%>ofshelp!demo.action#data">数据准备</a></li>
						<li ><a href="<%=basePath%>ofshelp!demo.action#sql">查询语句编写</a></li>
						<li ><a href="<%=basePath%>ofshelp!demo.action#upload">选择上传文件</a></li>
						<li ><a href="<%=basePath%>ofshelp!demo.action#skip">跳过的标题行</a></li>
						<li ><a href="<%=basePath%>ofshelp!demo.action#result">结果</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>