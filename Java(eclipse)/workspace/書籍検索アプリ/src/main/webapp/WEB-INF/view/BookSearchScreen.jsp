<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍検索画面</title>
</head>
<body>
	<%
		String bookName = (String)request.getAttribute("bookName");	
	%>
	<h2>書籍検索画面
	</h2>
	<form method="post" action="./BookSearchServlet">
		本を検索する
		<input type="text" name="bookName" placeholder="キーワードを入力" 
		<% if(bookName != null){
		%> 
			value = <%= bookName %>
		<% }
		%>
		autofocus>
		<input type="submit" value="検索" id="button">
		
		<div id="jsChangeContents">
			<%
			if(bookName != null){
			%>
				<h2>検索結果<br>
				</h2>
				<%=
					bookName
				%>
				
			<%}
			%>
		</div>
	</form>
</body>
</html>