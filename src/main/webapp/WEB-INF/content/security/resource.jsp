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
<title>My JSP 'resource-list.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<%@include file="/bootstrap-header.jsp"%>
</head>
<body>
	<%@include file="/common/fixed-nav.jsp"%>

	<div id="btnDiv" align="right">
		<button type="button" id="queryBtn" class="btn btn-info">查询</button>
		<s:if test="#parameters.help != null">
			<button type="button" id="confirmBtn"
				class="btn btn-success">确认</button>
			<button type="button" id="closeBtn"
				class="btn btn-warning">关闭</button>
			<script type="text/javascript">
				$(function() {

					$("#confirmBtn").click(function() {
						var ids = $(":checkbox[name='ids']:checked").vals();
						if (ids == null || ids.length < 1) {
							alert("请至少选择一条记录");
							return;
						}
						var ret = {};
						ret["key"]=ids;
						//描述
						var desc = $(":checkbox[name='ids']:checked").parent("td").siblings("td.helpDesc").texts();  
						ret["desc"]=desc;
						window.returnValue=ret;
						window.close();
					});

					$("#closeBtn").click(function() {
						window.close();
					});


				});
			</script>
		</s:if>
		<s:else>
		
		<button type="button" id="reloadBtn" url="<%=basePath%>/security/resource!reloadSysResouces.action"  class="btn btn-danger">重新加载系统资源</button>
		
		
		<button type="button" id="insertBtn" url="<%=basePath%>/security/resource!input.action" class="btn btn-success">新增</button>
		<button type="button" id="updateBtn" url="<%=basePath%>/security/resource!input.action" class="btn btn-warning">修改</button>
		<button type="button" id="deleteBtn" url="<%=basePath%>/security/resource!delete.action"  class="btn btn-danger">删除</button>
		<script type="text/javascript">
			 $(function(){
				 
				 $("#reloadBtn").click(function(){
					 window.location.href =$(this).attr("url");
				 });
				 
				 $("#insertBtn").click(function(){
					 window.location.href =$(this).attr("url");
				 });
				 
				 $("#updateBtn").click(function(){
					 var ids = $(":checkbox[name='ids']:checked").val();
					 if(ids==null||ids.length!=1){
						 alert("请选择一条记录");
						 return;
					 }
					 var url = $(this).attr("url")+"?id="+ids[0];
					 window.location.href =url;
				 });
				 
				 
				 $("#deleteBtn").click(function(){
					 var ids = $(":checkbox[name='ids']:checked").val();
					 if(ids==null||ids.length<1){
						 alert("请选择一条记录");
						 return;
					 }
					 var url = $(this).attr("url");
					 $("#listForm").attr("action",url);
					 $("#listForm").submit();
				 });
				 
				 
			 });
			
			
			</script>
		</s:else>
	</div>
	<form id="listForm" action="<%=basePath%>/security/resource!list.action"   method="post">
	<table id="items" class="table table-striped table-bordered">
		<tr>
			<th></th>
			 			 <th>名称</th>
 			 
  			 			 <th>url</th>
 			 
  						
		</tr>
		
		<s:iterator value="models" var="m">
			<tr class="item">
				<td>
				 <input type="checkbox" name="ids" value="<s:property value="#m.id" />"></input>
				</td>
					 				<td><s:property value="#m.name"/></td>
	  				 				<td><s:property value="#m.url"/></td>
	  						</tr>
		</s:iterator>
	</table>
	</form>
</body>
</html>
