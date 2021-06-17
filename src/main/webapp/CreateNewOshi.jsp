<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Boolean isCollect = (Boolean)request.getAttribute("isCollect"); 
if(isCollect == null) isCollect = true;
%>    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/main.css">
<meta charset="UTF-8">
<title>推し作成画面</title>
</head>

<body>
	<jsp:include page="/components/Header.jsp" />
	<div id="title"><h1>推し作成画面</h1></div>
	<div class="d">
	<form action="/AirNagesen/CreateNewOshi" method="post">
		<label>
		推しの名前：
		<input type="text" name="name">
		</label>
		<br/>
	    <label>
		最初の貢ぎ額：
		<input type="text" name="firstMoney">
		</label>
		<br/>
		<% if(!isCollect){ %>
			<p class="alert">正しい値を入力してください</p>
		<% } %>
		<input type="submit" value="登録">
	</form>
	<a class="button2" href="/AirNagesen/Main.jsp">推し一覧画面に戻る</a>
	</div>
</body>
</html>