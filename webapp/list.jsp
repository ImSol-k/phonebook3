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

	<h1>��ȭ��ȣ��</h1>

	<h2>����Ʈ</h2>

	<p>��ϵ� ��ȭ��ȣ ����Ʈ�Դϴ�</p>
	<%
	for (int i = 0; i < personList.size(); i++) {
	%>

	<table border = 1px>
		<tr>
			<td>�̸�</td>
			<td><%= personList.get(i).getName() %></td>
		</tr>
		<tr>
			<td>��ȭ��ȣ</td>
			<td><%= personList.get(i).getPh() %></td>
		</tr>
		<tr>
			<td>ȸ��</td>
			<td><%= personList.get(i).getCompany() %></td>
		</tr>
	</table>

	<%
	}
	%>

</body>
</html>