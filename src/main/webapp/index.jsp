<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String userName = (session.getAttribute("userName") == null) ? "" : session.getAttribute("userName").toString();
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>中大眼科</title>
</head>
<body>
<h2>Hello World!</h2>
<br/>
<% if("zhao".equals(userName)){ %>

<h4>欢迎回来！  <%=userName %></h4>
<button onclick="logout()">退出</button>

<%}else{ %>
您未登录， 请
<a href="<%=basePath%>login.jsp">登录</a>

<%} %>




</body>
<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script>
	function logout(){
		$.get("<%=basePath%>user/logout", function(data){
			location.href = '<%=basePath%>';
		});
	}
</script>
</html>
