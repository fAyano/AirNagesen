<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.User,model.Oshi, java.util.*" %>
<%
User loginUser = (User) session.getAttribute("loginUser");
List<Oshi> oshiList = (List<Oshi>) application.getAttribute("oshiList");
%>    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/main.css">
<meta charset="UTF-8">
<title>一覧画面</title>
</head>
<body>
	<table class="table1" border="0" cellpadding=20">
	<tr>
		<td align="center">
		<a class="button1" href="/AirNagesen/CreateNewOshi.jsp">推し作成画面へ</a><br>
		</td>
		<td align="center">
		<a class="button1" href="/AirNagesen/LogoutResult.jsp">ログアウト</a><br>
		</td>
		<td align="center">
		<a class="button1" href="/AirNagesen/Main">更新する</a><br>
		</td>
	</tr>
	</table>
	
	<div id="title"><h1>一覧画面</h1></div>
	<table class="table2" border="0" cellpadding=30">
	<tr>
		<td align="center">
		<a class="button2" href="/AirNagesen/CreateNewOshi.jsp">推し作成画面へ</a><br>
		</td>
		<td align="center">
		<a class="button2" href="/AirNagesen/Main">更新する</a><br>
		</td>
	</tr>
	</table>
	<div class="box1">
		<span class="boxTitle"><%= loginUser.getName() %>さんの情報</span>
		<h4>今まで推したちに貢いだ総額：<%= loginUser.getTotalMoney() %>円</h4>
		<h4>推しメン</h4>
		<ul>
			<% for(Oshi oshi : loginUser.getOshiMen()){ %>
				<li><span><%= oshi.getName() %> 様</span></li>
			<% } %>
		</ul>
	</div>
	<br>
	<br>
	<div class="box3">
		<span class="boxTitle">みんなが作成した推し一覧</span>
		<% for(int i=0;i<oshiList.size();i++){ %>
				<div class="box2">
					<h3>推しの名前: <%=oshiList.get(i).getName() %>様</h3>
					<h4>貢がれた金額: <%=oshiList.get(i).getTotalMoney()%>円</h4>
					<h4>ファンの人数: <%=oshiList.get(i).getTotalFans()%>人</h4>
					<h4>作成したユーザー: <%=oshiList.get(i).getUserName()%>さん</h4>
				</div>
		<% } %>
	</div>
</body>
</html>