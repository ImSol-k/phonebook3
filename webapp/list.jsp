<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.List"%>
<%@ page import="com.javaex.vo.PersonVo"%>

<%
List<PersonVo> personList = (List<PersonVo>) request.getAttribute("personList");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<body>

	<h1>전화번호부</h1>

	<h2>리스트</h2>

	<p>등록된 전화번호 리스트입니다</p>
	<%
	for (int i = 0; i < personList.size(); i++) {
	%>

	<table border = 1px>
		<tr>
			<td>이름</td>
			<td><%= personList.get(i).getName() %></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><%= personList.get(i).getPh() %></td>
		</tr>
		<tr>
			<td>회사</td>
			<td><%= personList.get(i).getCompany() %></td>
		</tr>
	</table>

	<%
	}
	%>

</body>
</html>