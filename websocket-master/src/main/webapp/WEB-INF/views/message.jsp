<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String wsPath = "ws://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>message</title>
<script type="text/javascript" src="js/jquery-1.12.2.min.js"></script>
<script type="text/javascript">
	function placeOrder(){
		$.ajax({url:"<%=basePath%>sendMsg"});
		return false;
	}
</script>
</head>
<body>
	<h1>已经发送消息了</h1>
	<button onclick="placeOrder()">下订单</button>
</body>
</html>