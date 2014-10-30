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
   <table id="items" class="table table-striped table-bordered">
     <tr ><td> 编号 </td><td>描述</td><td>sheet跳过行数</td></tr>
   	 <s:iterator value="qstatements" var="q">
			<tr class="item"><td> <a href="<%=basePath%>qstatement!forImport.action?qstatement.id=<s:property value="#q.id" />"><s:property value="#q.id" /></a> </td><td><s:property value="#q.description" /></td><td><s:property value="#q.skipRowStr" /></td></tr>
	 </s:iterator>
   </table>
  </body>
</html>
