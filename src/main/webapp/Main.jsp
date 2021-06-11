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
<meta charset="UTF-8">
<title>一覧画面</title>
</head>
<body>
	<h1>一覧画面</h1>
	<a href="/AirNagesen/CreateNewOshi.jsp">推し作成画面へ</a><br>
	<a href="/AirNagesen/LogoutResult.jsp">ログアウト</a><br>
	<a href="/AirNagesen/Main">更新</a>
	<div style="border: solid 2px">
		<div>
			<h1><%= loginUser.getName() %>さんの情報</h1>
			<p>今まで推したちに貢いだ総額：<%= loginUser.getTotalMoney() %>円</p>
			<p>推しメン</p>
			<ul>
				<% for(Oshi oshi : loginUser.getOshiMen()){ %>
					<li><%= oshi.getName() %> 様</li>
				<% } %>
			</ul>
		</div>
		<br/>
	</div>
	<br>
	<div style="border: solid 2px">
		<h1>みんなが作成した推し一覧</h1>
		<% for(int i=0;i<oshiList.size();i++){ %>
				<div style="padding: 10px; margin-bottom: 10px; border: 1px solid #333333; border-radius: 10px;">
					<h2>推しの名前: <%=oshiList.get(i).getName() %>様</h2>
					<h3>貢がれた金額: <%=oshiList.get(i).getTotalMoney()%>円</h3>
					<h3>ファンの人数: <%=oshiList.get(i).getTotalFans()%>人</h3>
					<h3>作成したユーザー: <%=oshiList.get(i).getUserName()%>さん</h3>
					<form action="/AirNagesen/GiveMoney" method="post">
						<label>
							<input type="text" name="money" /> 円
						</label>
				  		<input type="hidden" name="oshiName" value=<%= oshiList.get(i).getName() %> />
				  		<input type="submit" value="貢ぐ！">
						
					</form>
				</div>
		<% } %>
	</div>
</body>
</html>