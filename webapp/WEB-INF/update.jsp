<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.javaex.vo.PersonVo"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>전화번호부</h1>

	<h2>등록폼</h2>
	
	<%
    // 전달받은 personId 파라미터 가져오기
    String personId = request.getParameter("no");
   String name = request.getParameter("name");
   String ph = request.getParameter("ph");
   String company = request.getParameter("company");

    // 가져온 personId를 확인하기 위해 출력해보기
    //out.println("전달받은 personId: " + personId);
    //out.println(name);
    //out.println(ph);
    //out.println(company);
    int id = Integer.parseInt(personId);
    
   %>
	

	<p>
		전화번호를 수정하려면<br> 아래 항목을 기입하고 "수정" 버튼을 클릭하세요
	</p>

	<form action="http://localhost:8080/phonebook3/pbc" method="">
		<div>
			<input type="hidden" name="no" value="<%=id %>">
		</div>
		<div>
			<label>이름(name)</label> <input type="text" name="name" value="<%=name %>">
		</div>

		<div>
			<label>핸드폰(hp)</label> <input type="text" name="ph" value="<%=ph %>">
		</div>

		<div>
			<label>회사(company)</label> <input type="text" name="company" value="<%=company %>">
		</div>


		<button type="submit">수정</button>
		<input type="text" name="action" value="update">
	</form>

	<br>
	<br>
	<a href="/phonebook3/pbc?action=list">리스트페이지로 이동</a>

</body>
</html>