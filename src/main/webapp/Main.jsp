<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.User,model.Oshi, java.util.*" %>
<%
User loginUser = (User) session.getAttribute("loginUser");
@SuppressWarnings("unchecked")
List<Oshi> oshiList = (List<Oshi>) application.getAttribute("oshiList");
List<Oshi> oshiMen = loginUser.getOshiMen();
Boolean isCollect = (Boolean)request.getAttribute("isCollect");
Boolean isSuccessfulAddOshi = (Boolean)request.getAttribute("isSuccessfulAddOshi");
if(isSuccessfulAddOshi == null){
	isSuccessfulAddOshi = false;
}
Boolean isSuccessfulDeleteOshi = (Boolean)request.getAttribute("isSuccessfulDeleteOshi");
if(isSuccessfulDeleteOshi == null){
	isSuccessfulDeleteOshi  = false;
}
%>    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/main.css">
<meta charset="UTF-8">
<title>一覧画面</title>
</head>
<body>
	<jsp:include page="/components/Header.jsp" />
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
	<% if(isCollect == null){ %>		
	<% }else if(isCollect){ %>
		<p class="collect">推しに貢ぎました！</p>
	<% }else{ %>
		<p class="alert">正しい値を入力してください</p>
	<% } %>
	<% if(isSuccessfulAddOshi){ %>
		<p class="collect">推しメンを追加しました！</p>
	<% } %>	
	<% if(isSuccessfulDeleteOshi){ %>
		<p class="collect">担降りしました....</p>
	<% } %>	
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
					<% if(oshiList.get(i).getName().length()<9){%>
						<h3 class="oshi-name"><%=oshiList.get(i).getName() %>様</h3></td>
					<% }else if(oshiList.get(i).getName().length()<12){%>
						<h4><%=oshiList.get(i).getName() %>様</h4></td>
					<%}else{%>
						<h5><%=oshiList.get(i).getName() %>様</h5></td>
					<% }%>
					<% if(!oshiMen.contains(oshiList.get(i))){ %>
 						<td><form action="/AirNagesen/AddToOshiMen" method="post">
 							<input type="hidden" name="oshiName" value=<%= oshiList.get(i).getName() %> />
 							<input id="osu" type="submit" value="推す！" />
 							<input class="tan-ori" type="button" value="担降りする" disabled /> 
 						</form></td></table>
 					<% }else{ %>
 						<td><input id="osu" type="button" value="推し活中！" disabled />
 						<form action="/AirNagesen/DeleteOshiMen" method="post">
 							<input type="hidden" name="oshiName" value=<%= oshiList.get(i).getName() %> />
 							<input class="tan-ori" type="submit" value="担降りする" /> 
 						</form>
 						</td></tr></table>
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