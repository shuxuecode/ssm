<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>中大眼科</title>
</head>
<body>
	name:<input type="text" id="userName" value="zhao"/>
	<br/>
	pwd:<input type="text" id="passWord" value="shuxue"/>
	<br/>
	<button onclick="login()">登录</button>
	
	
	
	<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script type="text/javascript">
		function login(){
			var name = $("#userName").val();
			var pwd = $("#passWord").val();
			if(name === '' || pwd === ''){
				return;
			}
			$.post("<%=basePath%>/user/login",
					{
						username : name,
						password : pwd
					},
					function(data){
						if(data === 'ok'){
							alert("登录成功");
							location.href = '<%=basePath%>';
						}else{
							alert("登录失败");
						}
					}
			);
			
		}		
	
	</script>
</body>
</html>