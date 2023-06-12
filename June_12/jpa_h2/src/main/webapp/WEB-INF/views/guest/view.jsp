<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     

<%
	String ctxPath = request.getContextPath();
	System.out.println("ctxPath => " + ctxPath);
	// ctxPath => 
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 보기</title>

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css" href="<%= ctxPath%>/bootstrap-4.6.0-dist/css/bootstrap.min.css">

<script type="text/javascript" src="<%= ctxPath%>/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="<%= ctxPath%>/bootstrap-4.6.0-dist/js/bootstrap.bundle.min.js" ></script>

<script type="text/javascript">

   function goDelete(num) {
	   const bool = confirm("정말로 삭제 하시겠습니까 ?");
	   if(bool) {
		   location.href="<%= request.getContextPath()%>/guest/delete?num="+num;
	   }
   }

</script>

</head>
<body>

<div style="display: flex;" class="container" >
  <div style="margin:auto; padding-left: 3%;">	
	<h3 class="my-5">방명록 내용보기</h3>
	
    <c:if test="${not empty dto}"> 
		<table style="width: 1024px" class="table table-bordered">
			<tr>
				<th style="width: 15%">방명록 번호</th>
				<td>${dto.num}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${dto.writer}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${dto.title}</td>
			</tr>
			<tr>
				<th style="vertical-align: middle;">내용</th>
				<td valign="top" height="200">
				  <p style="word-break: break-all;">${dto.content}</p>
				   <%-- 
				       style="word-break: break-all; 은 공백없는 긴영문일 경우 width 크기를 뚫고 나오는 것을 막는 것임. 
				           그런데 style="word-break: break-all; 나 style="word-wrap: break-word; 은
				           테이블태그의 <td>태그에는 안되고 <p> 나 <div> 태그안에서 적용되어지므로 <td>태그에서 적용하려면
				       <table>태그속에 style="word-wrap: break-word; table-layout: fixed;" 을 주면 된다.
				   --%>
				</td>
			</tr>
		</table>
		<br/>
				
		<button type="button" class="btn btn-secondary btn-sm mr-3" onclick="javascript:location.href='<%= request.getContextPath()%>/guest/list'">전체목록보기</button>
		<button type="button" class="btn btn-secondary btn-sm mr-3" onclick="javascript:location.href='<%= request.getContextPath()%>/guest/update?num=${dto.num}'">수정하기</button>
		<button type="button" class="btn btn-secondary btn-sm mr-3" onclick="goDelete('${dto.num}')">삭제하기</button>
	
	</c:if> 
	
	<c:if test="${empty dto}">
		<div style="padding: 50px 0; font-size: 16pt; color: red;">존재하지 않습니다</div>
	</c:if>
	
 </div>    
</div>

</body>
</html>
