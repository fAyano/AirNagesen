<%@page import="model.Oshi"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Oshi oshi = (Oshi)request.getAttribute("oshi"); %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>推し作成完了画面</title>
</head>
<body>
	<h1>新しい推しの作成が完了しました</h1>
	<h2>名前：<%= oshi.getName() %> 様</h2>
	<h2>現在の合計貢がれ金額：<%= oshi.getTotalMoney() %>円</h2>
	<h2>現在の合計ファン数：<%= oshi.getTotalFans() %>人</h2>
	<a href="/AirNagesen/Main.jsp">推し一覧画面に戻る</a>
</body>
</html>