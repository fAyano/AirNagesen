<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>    
<% User loginUser = (User)session.getAttribute("loginUser"); %>    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/main.css">
<meta charset="UTF-8">
<title>ログイン成功</title>
</head>

<body>
	<div id="title"><h1>エア投げ銭</h1></div>
	<div class="d">
	<% if(loginUser != null){ %>
			<h3>ログインに成功しました！ようこそ、<%= loginUser.getName() %>さん</h3>		
			<a class="button2" href="/AirNagesen/Main">推し一覧画面へ</a>	
	<% }else{ %>
			<h3>ログインに失敗しました</h3>
			<a class="button2" href="/AirNagesen">トップへ</a>
	<% } %>
	</div>
</body>
</html>