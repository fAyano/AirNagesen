<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.User" %>
<%
User loginUser = (User) session.getAttribute("loginUser");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>一覧画面</title>
</head>
<body>
	<h1>一覧画面</h1>
	<a href="/AirNagesen/CreateNewOshi.jsp">推し作成画面へ</a><br>
	<a href="">ログアウト</a>
	<div style="border: solid 2px">
		<h1><%= loginUser.getName() %>さんの情報</h1>
		<p>TODO: ここに今まで貢いだ総額、推しメンを表示する</p>
	</div>
	<br>
	<div style="border: solid 2px">
		<h1>みんなが作成した推し一覧</h1>
		<p>TODO: ここに作成された推しを一覧で表示する</p>
	</div>
</body>
</html>