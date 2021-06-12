<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.User,model.Oshi, java.util.*" %>
<%
User loginUser = (User) session.getAttribute("loginUser");
@SuppressWarnings("unchecked")
List<Oshi> oshiList = (List<Oshi>) application.getAttribute("oshiList");
List<Oshi> oshiMen = loginUser.getOshiMen();
%>    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/main2.css">
<meta charset="UTF-8">
<title>一覧画面</title>
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
					<table border="0" cellpadding=5px>
					<tr><td>
					<h3>推しの名前: <%=oshiList.get(i).getName() %>様</h3></td>
					<% if(!oshiMen.contains(oshiList.get(i))){ %>
 						<td><form action="/AirNagesen/AddToOshiMen" method="post">
 							<input type="hidden" name="oshiName" value=<%= oshiList.get(i).getName() %> />
 							<input id="osu" type="submit" value="推す！" />
 						</form></td></table>
 					<% }else{ %>
 						<td><input id="oshizumi" type="button" value="推し活中！" disabled /></td></tr></table>
 					<% } %>
					<h4>貢がれた金額: <%=oshiList.get(i).getTotalMoney()%>円</h4>
					<h4>ファンの人数: <%=oshiList.get(i).getTotalFans()%>人</h4>
					<h4>作成したユーザー: <%=oshiList.get(i).getUserName()%>さん</h4>
					<form action="/AirNagesen/GiveMoney" method="post">
						<label>
 							<input type="text" name="money" /> 円
 						</label>
 				  		<input type="hidden" name="oshiName" value=<%= oshiList.get(i).getName() %> />
 				  		<input id="mitsugu" type="submit" value="貢ぐ！">						
 					</form>
				</div>
		<% } %>
	</div>
</body>
</html>