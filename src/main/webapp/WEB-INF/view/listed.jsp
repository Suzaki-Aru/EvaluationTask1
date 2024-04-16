<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>書籍テーブル</title>
</head>
<body>

	<%
	ArrayList<HashMap<String, String>> rows = (ArrayList<HashMap<String, String>>) request.getAttribute("rows");
	%>

	<table border="2">

		<tr>
			<th>JANコード</th>
			<th>ISBNコード</th>
			<th>書籍名称</th>
			<th>書籍名称カナ</th>
			<th>価格</th>
			<th>発行日</th>
			<th>登録日時</th>
			<th>更新日時</th>
		</tr>
		<%
		for (HashMap<String, String> columns : rows) {
		%>
		<tr>
			<form action="ShowedServlet" method="post">
			<td><%=columns.get("janCode")%></td><input type = "hidden" name = "janCode" value = '<%=columns.get("janCode")%>'>
			<td><%=columns.get("isbnCode")%></td><input type = "hidden" name = "isbnCode" value = '<%=columns.get("isbnCode")%>'>
			<td><%=columns.get("bookName")%></td><input type = "hidden" name = "bookName" value = '<%=columns.get("bookName")%>'>
			<td><%=columns.get("bookKana")%></td><input type = "hidden" name = "bookKana" value = '<%=columns.get("bookKana")%>'>
			<td><%=columns.get("price")%></td><input type = "hidden" name = "price" value = '<%=columns.get("price")%>'>
			<td><%=columns.get("issueDate")%></td><input type = "hidden" name = "issueDate" value = '<%=columns.get("issueDate")%>'>
			<td><%=columns.get("createDate")%></td><input type = "hidden" name = "createDate" value = '<%=columns.get("createDate")%>'>
			<td><%=columns.get("updateDate")%></td><input type = "hidden" name = "updateDate" value = '<%=columns.get("updateDate")%>'>
			<td><input type="submit" value="編集"></td>
			</form>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>
