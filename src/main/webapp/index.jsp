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
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "https://hm.baidu.com/hm.js?4fb6ec26b4b57cd585ef74047036eacb";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>

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
					required placeholder="请输入... ">select  t1.*,t2.c2,t2.c3,t3.c2,t3.c2 as 物料组描述 from t1 join t2 on t2.c1 =t1.c1 join t3 on t2.c3 =t3.c1  order by t1.c1</textarea>
				<br /> <span class="btn btn-success fileinput-button"> <i
					class="icon-plus icon-white"></i> <span>请选择excel,可直接多选</span> <input
					id="fileupload" type="file" name="dataExcels" multiple required>
				</span> <br /> <label for="url">跳过标题行数:</label> <input
					class="form-control" name="skipRowStr" placeholder="用逗号分隔" required
					value="1,1,1" /> <br />
					
				<!-- Small modal 查询描述 -->
				
				<div id="descModal" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
				  <div class="modal-dialog modal-sm">
				    <div class="modal-content">
				    	 <div class="modal-body">
					          <label >查询的描述:</label> 
				    			<input class="form-control" name="description" placeholder="请输入描述" required  />
					      </div>
					      <div class="modal-footer">
					      	<button type="button" id="comfirmBtn" class="btn btn-primary">确认</button>
					        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					       
					      </div>
				  
				    </div>
				  </div>
				</div>
				
				<input class="btn btn-lg btn-primary " value="提交" type="button" id="submitBtn"  />
				<bsp:button clazz="btn btn-lg btn-primary "  url="/qstatement!save.action" id="saveBtn" value="保存查询" ></bsp:button>
			</form>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
$(function(){
	var basePath = $("#basePath").val();
	
	$("#saveBtn").click(function(){
		$("#descModal").modal("show");
		
	});
	
	$("#comfirmBtn").click(function(){
		$("#eForm").attr("action",basePath+"qstatement!save.action");
		$("#eForm").submit();
	});
	
	$("#submitBtn").click(function(){
		$("#eForm").attr("action",basePath+"ofshelp.action");
		$("#eForm").submit();
	});
});

</script>
