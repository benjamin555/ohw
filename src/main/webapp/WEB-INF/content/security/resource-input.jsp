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
    
    <title>My JSP 'resource-input.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@include file="/bootstrap-header.jsp"%>

  </head>
  
  <body>
  <div class="container">
  	<form id="modelForm" role="form" action="<%=basePath%>security/resource!save.action" method="post">
  		<input type="hidden" name="id" value="<s:property value="model.id" />" >
  		  		 			 <label for="name">名称:</label><input  class="form-control" type="text" name="name" value="<s:property value="model.name" />" />
 			 
 			 
  		 			 <label for="name">url:</label><input  class="form-control" type="text" name="url" value="<s:property value="model.url" />" />
		 			
		 			<label for="name">角色列表:</label>
					<textarea class="form-control" rows="3" id="roles"><s:iterator value="model.roles" var="m"><s:property value="#m.name" />,</s:iterator>
					</textarea>
		 			 <div id="hiddenRoleId">
						<s:iterator value="roles" var="r" status="s">
								<s:hidden  name="roles[%{#s.index}].id" value="%{#r.id}"  ></s:hidden>
						</s:iterator>
					</div>
 			 </br>
				<input id="selectBtn" type="button" url="<%=basePath%>security/role!list.action?help" class="btn btn-primary" value="选择角色"></input>
			</br>
  		  		  		</br>
  		<input class="btn btn-lg btn-primary " value="提交" type="submit" id="submitBtn"  />
  		<input class="btn btn-lg btn-primary " value="返回" url="<%=basePath%>security/resource.action" type="button" id="backBtn"  />
  	</form>
  </div>
  </body>
</html>
<script type="text/javascript">
 $(function(){
	 
	 $("#backBtn").click(function(){
		 window.location.href =$(this).attr("url");
	 });
	 $("#selectBtn").click(function() {
			var url = $(this).attr("url");
			var ret = showModalDialog(url,window,"scroll:yes;status:no;dialogWidth:500px;dialogHeight:550px");
			if(ret!=null){
				$("#roles").val(ret.desc);
				//清理hidden
				$("#hiddenRoleId").empty();
				//添加hideen
				var keys = ret.key;
				for(var i =0;i<keys.length;i++){
					var name ="roles["+i+"].id";
					var hid = $("<input type='hidden' />").attr("name",name).val(keys[i]);
					$("#hiddenRoleId").append(hid);
				}
				
				
			}
			
		});
	 
 });


</script>