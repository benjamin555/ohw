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
					<div id="btnDiv" align="right">
							<button type="button" id="shareBtn" class="btn btn-info">分享</button>
					</div>
					<form id="shareForm" method="post" action="<%=basePath%>qstatement!share.action">
						<%@include file="_qstatement_item_list.jsp"%>
						
						
						<div id="userModal" class="modal fade">
					  <div class="modal-dialog">
					    <div class="modal-content">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
					        <h4 class="modal-title">系统提示</h4>
					      </div>
					      <div class="modal-body">
					        <p>
								<label for="name">分享给:</label><input placeholder="帐号名" name="sharedUserName" class="form-control" type="text" id="userName" required  />
							</p>
					      </div>
					      <div class="modal-footer">
					      	<button type="button" id="shareToBtn" class="btn btn-primary">确认</button>
					        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					       
					      </div>
					    </div><!-- /.modal-content -->
					  </div><!-- /.modal-dialog -->
					</div><!-- /.modal -->
					</form>
					
					
					
					
					
					
				</div>
				<div role="tabpanel" class="tab-pane" id="shared"><%@include file="_qstatement_shared_list.jsp"%></div>
			</div>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
$(function () {
	$("#shareBtn").click(function(){
		 var ids = $(":checkbox[name='ids']:checked").val();
		 if(ids==null||ids.length<1){
			 alert("请选择一条记录");
			 return;
		 }
		$("#userModal").modal("show");

		
	});
	
	$("#shareToBtn").click(function(){
		share();
	});
	
	function share(){
		var form = $("#shareForm");
		var url = form.attr("action");
		var para= form.serialize();
		$.getJSON(url, para,function(json){
			if(json.result=="success"){
				alert("更新成功！");
				$('#userModal').modal('hide')
			}else{
				alert("系统错误！");
			}
			
		});
		
	}
  });

</script>