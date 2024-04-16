<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>書籍編集</title>
<style>
ul {
	list-style: none;
	margin: 0;
	padding: 0;
}

li {
	float: left;
	margin-right: 20px;
}
</style>
</head>
<body>
	<h1>書籍編集</h1>
	
	<h2>ISBNコード:<%= request.getAttribute("isbnCode") %></h2>
	
	<form action="EditedServlet" method="post">
		<input type="hidden" name="janCode" value='<%= request.getAttribute("janCode") %>'>
		<input type="hidden" name="isbnCode" value='<%= request.getAttribute("isbnCode") %>'>
		<input type="hidden" name="issueDate" value='<%= request.getAttribute("issueDate") %>'>
		<input type="hidden" name="createDate" value='<%= request.getAttribute("createDate") %>'>
		<input type="hidden" name="updateDate" value='<%= request.getAttribute("updateDate") %>'>
		
		<label for="bookName">書籍名称</label><br>
		<input type="text" name="bookName" value='<%= request.getAttribute("bookName") %>'><br> <br>
	    
	    <label for="bookKana">書籍カナ</label><br>
		<input type="text" name="bookKana" value='<%= request.getAttribute("bookKana") %>'><br> <br>
		
		<label for="price">価格</label><br>
		<input type="text" name="price" value='<%= request.getAttribute("price") %>'><br> <br>

		<button type="submit">変更を保存する</button>
	</form><br>
	
	
	<a href='ListedServlet'>戻る</a>
</body>
</html>