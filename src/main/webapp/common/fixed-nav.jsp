<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="sp-bsp" prefix="bsp" %>
<div class="navbar navbar-default navbar-fixed-top "  role="navigation">
	<div class="container">
		<ul class="nav navbar-nav " >
            <li ><a href="<%=basePath%>">主页</a></li>
            <li ><a href="<%=basePath%>ofshelp!demo.action">例子</a></li>
            <bsp:nav url="/qstatement!list.action" value="查询列表"/>
          </ul>
		 
		<ul class="nav navbar-nav navbar-right">
                        <sec:authorize access="authenticated" var="authenticated"/>
                        <sec:authentication property="name" var="currentUserName" />
                        <c:choose>
                            <c:when test="${authenticated && !empty currentUserName}">
                                <li >欢迎：${currentUserName}</li>
                                <li ><a href="<%=basePath%>logout.action">登出</a>
								</li>
                            </c:when>
                            <c:otherwise>
                                <c:url var="signupUrl" value="/signup/form"/>
                                <li><a id="navSignupLink" href="${signupUrl}">注册</a></li>
                                <c:url var="loginUrl" value="/login.jsp"/>
                                <li><a id="navLoginLink" href="${loginUrl}">登录</a></li>
                            </c:otherwise>
                        </c:choose>
		</ul>
		
		
	</div>
</div>
<hr>
<hr>
<script type="text/javascript">
	

</script>