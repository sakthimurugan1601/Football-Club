<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="com.use.MatchDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='StyleSheet' href='k.css'>
</head>
<body>
<div class='ps'>
<h2>All the match details are-- &#x1F9E9;</h2>
<table border='3'>
<tr><th>Title</th><th>Place</th><th>Date</th></tr>
<%
ResultSet rs=new MatchDao().RetrieveMatch();
while(rs.next()){
%>
<tr><th><%=rs.getString(1)%></th><th><%=rs.getString(2)%></th><th><%=rs.getString(3)%></th></tr>
<%}%>

</table>
</div>
</body>
</html>