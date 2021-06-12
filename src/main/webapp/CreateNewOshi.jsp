<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/main.css">
<meta charset="UTF-8">
<title>推し作成画面</title>
</head>

<body>
	<table class="table1" border="0" cellpadding="20">
	<tr>
		<td align="center">
		<a class="button1" href="/AirNagesen/CreateNewOshi.jsp">推し作成画面へ</a><br>
		</td>
		<td align="center">
		<a class="button1" href="/AirNagesen/LogoutResult.jsp">ログアウト</a><br>
		</td>
	</tr>
	</table>
	<div id="title"><h1>推し作成画面</h1></div>
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
		<input type="submit" value="登録">
	</form>
	<a class="button2" href="/AirNagesen/Main.jsp">推し一覧画面に戻る</a>
</body>
</html>