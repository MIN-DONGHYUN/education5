<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      

<%
	String ctxPath = request.getContextPath();
//	System.out.println("ctxPath => " + ctxPath);
	// ctxPath => 
%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 보기</title>

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css" href="<%= ctxPath%>/bootstrap-4.6.0-dist/css/bootstrap.min.css">

<style type="text/css">
	
	tbody > tr > td:nth-child(1) > span  { 
	  /* color: blue;  */
	     display: none; 	
	}
	
	div.container > table > tbody > tr:hover {
		cursor: pointer;
	}

</style>

<script type="text/javascript" src="<%= ctxPath%>/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="<%= ctxPath%>/bootstrap-4.6.0-dist/js/bootstrap.bundle.min.js" ></script>

<script type="text/javascript">

	$(document).ready(function(){
		
		$("tbody > tr.exists").click(function(){
		 // alert("호호");
		    
		    var $target = $(event.target); // <td>태그이다.
		 // console.log("확인용 $target.html() => " + $target.html() );
		   
		    var num = $target.parent().find("span").text();
		 // console.log("확인용 num => " + num);
		    
		    location.href="view?num="+num;
		});
		
	});

</script>

</head>
<body>
	<div class="container my-5">
		<h3>방명록(Oracle 데이터베이스)</h3>
		
		<table class="table table-hover">
		    <thead>
		    	<tr>
		    		<th colspan="4" class="text-right">
		    		  <button type="button" class="btn btn-info" onclick="javascript:location.href='write'">방명록 작성하기</button>
		    		</th> 
		    	</tr>
		    	<tr>
		    		<th width="10%">번호</th>
		    		<th>제목</th>
		    		<th width="15%">작성자</th>
		    		<th width="20%">작성일자</th>
		    	</tr>
		    </thead>
		    
		    <tbody>
		    	<c:if test="${not empty requestScope.list}">
		    		<c:forEach var="vo" items="${requestScope.list}" varStatus="status"> 
		    			<tr class="exists">
		    				<td><span>${vo.num}</span>${status.count}</td>
		    				<td>${vo.title}</td>
		    				<td>${vo.writer}</td>
		    				<td>${vo.reg_date}</td>
		    			</tr>
		    		</c:forEach>
		    	</c:if>
		    	
		    	<c:if test="${empty requestScope.list}">
		    		<tr>
		    		  <td colspan="3" class="text-center" style="color: red;">방명록 데이터가 존재하지 않습니다</td>
		    		</tr>
		    	</c:if>
		    </tbody>
		</table>   
	</div>
	
</body>
</html>