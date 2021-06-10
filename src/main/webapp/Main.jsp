<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.User,model.Oshi, java.util.*" %>
<%
User loginUser = (User) session.getAttribute("loginUser");
List<Oshi> oshiList = (List<Oshi>) application.getAttribute("oshiList");
Oshi newOshi = oshiList.get(oshiList.size() - 1);
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
		<!-- <p>TODO: ここに今まで貢いだ総額、推しメンを表示する</p> -->
		<p>あなたが今までに貢いだ金額:<%= loginUser.getTotalMoney() %>円</p>
		<p>あなたの推しメン:</p>
		<%
			for(int i=0;i<loginUser.getNewOshi().size();i++){
				out.println(loginUser.getNewOshi().get(i));
			}
		%>
	</div>
	<br>
	<div style="border: solid 2px">
		<h1>みんなが作成した推し一覧</h1>
		<!-- <p>TODO: ここに作成された推しを一覧で表示する</p> -->
		<%
			for(int i=0;i<oshiList.size();i++){
				out.println("推しの名前: "+oshiList.get(i).getName()+"様");
				out.println("貢がれた金額: "+oshiList.get(i).getTotalMoney()+"円");
				out.println("ファンの人数: "+oshiList.get(i).getTotalFans()+"人");
				out.println("作成したユーザー: "+oshiList.get(i).getUserName()+"さん");
			}
		%>
	</div>
</body>
</html>