<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<h3>오라클 서버에 있는 데이터 조회</h3>
		
	 <c:forEach var="testvoList" items="${testvoList}">
		${testvoList.genre_id}
		${testvoList.genre_name}
	 </c:forEach>		
</body>
</html>