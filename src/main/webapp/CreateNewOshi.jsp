<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>推し作成画面</title>
</head>
<body>
	<h1>推し作成フォーム</h1>
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
	<a href="/AirNagesen/Main.jsp">推し一覧画面に戻る</a>
</body>
</html>