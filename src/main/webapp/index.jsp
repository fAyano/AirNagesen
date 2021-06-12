<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/main.css">
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
	<div id="title"><h1>エア投げ銭</h1></div>
	<form action="/AirNagesen/Login" method="post">
		ユーザー名：<input type="text" name="name"><br>
		パスワード：<input type="password" name="pass"><br>
		<input type="submit" value="ログイン">
	</form>	
</body>
</html>