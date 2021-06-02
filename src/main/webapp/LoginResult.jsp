<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>    
<% User loginUser = (User)session.getAttribute("loginUser"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン成功</title>
</head>
<body>
	<h1>エア投げ銭</h1>
	<% if(loginUser != null){ %>
		<p>ログインに成功しました！ようこそ、<%= loginUser.getName() %>さん</p>
		
		<a href="/AirNagesen/Main.jsp">推し一覧画面へ</a>
	<% }else{ %>
		<p>ログインに失敗しました</p>
		<a href="/AirNagesen">トップへ</a>
	<% } %>
</body>
</html>