<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.javaex.vo.PersonVo"%>

<%
List<PersonVo> personList = (List<PersonVo>) request.getAttribute("personList");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

	<h1>전화번호부</h1>

	<h2>리스트</h2>

	<p>등록된 전화번호 리스트입니다</p>
	<%
	for (int i = 0; i < personList.size(); i++) {
	%>

	<table border="1px">
		<tr>
			<td colspan="2"><b>[<%=personList.get(i).getPersonId() %>]</b></td>
		</tr>
		<tr>
			<td><b>이름</b></td>
			<td><%=personList.get(i).getName()%></td>
		</tr>
		<tr>
			<td><b>전화번호</b></td>
			<td><%=personList.get(i).getPh()%></td>
		</tr>
		<tr>
			<td><b>회사</b></td>
			<td><%=personList.get(i).getCompany()%></td>
		</tr>
		<tr>
			<td><a
				href="/phonebook3/pbc?action=delete&no=<%=personList.get(i).getPersonId()%>">[삭제]</a></td>
			<td><a
				href="/phonebook3/pbc?action=pupdate&no=<%=personList.get(i).getPersonId()%>&name=<%=personList.get(i).getName()%> &ph=<%=personList.get(i).getPh()%>&company=<%=personList.get(i).getCompany()%>">[수정]</a></td>
		</tr>
	</table>


	<%
	}
	%>

</body>
</html>