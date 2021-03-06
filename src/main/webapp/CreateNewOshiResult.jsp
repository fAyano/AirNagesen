<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.Oshi, java.util.*" %>    
<% 
@SuppressWarnings("unchecked")
List<Oshi> oshiList = (List<Oshi>) application.getAttribute("oshiList");
Oshi newOshi = oshiList.get(oshiList.size() - 1);
%> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/main.css">
<meta charset="UTF-8">
<title>推し作成完了画面</title>
</head>
<body>
	<jsp:include page="/components/Header.jsp" />
	<h1 id="title2">新しい推しの作成が完了しました</h1>
	<div class="d">
	<h2>名前：<%= newOshi.getName() %> 様</h2>
	<h2>現在の合計貢がれ金額：<%= newOshi.getTotalMoney() %>円</h2>
	<h2>現在の合計ファン数：<%= newOshi.getTotalFans() %>人</h2>
	<h2>作成者：<%= newOshi.getUserName() %></h2>
	<a class="button2" href="/AirNagesen/Main.jsp">推し一覧画面に戻る</a>
	</div>
</body>
</html>