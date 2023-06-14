<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>     

<%
	String ctxPath = request.getContextPath();
//	System.out.println("ctxPath => " + ctxPath);
	// ctxPath => 
%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록 보기</title>

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
		
		if(${empty sessionScope.loginuser}) {
			$("#login_logout").text("로그인");	
			$("div#login_username").html("");
		}
		else {
			$("#login_logout").text("로그아웃");
			$("div#login_username").html("${sessionScope.loginuser.userName}님 로그인중");
		}
		
		
		$("#login_logout").click(function(){
			if( $(this).text() == "로그인" ) {
				location.href = "<%= ctxPath%>/member/login";
			}
			else {
				location.href = "<%= ctxPath%>/member/logout";
			}
		});
		
		
		$("tbody > tr.exists").click(function(){
		 // alert("호호");
		    
		    var $target = $(event.target); // <td>태그이다.
		 // console.log("확인용 $target.html() => " + $target.html() );
		   
		    var num = $target.parent().find("span").text();
		 // console.log("확인용 num => " + num);
		    
		    location.href="view?num="+num;
		});
		
		
		$("input#searchWord").keyup(function(e){
			if(e.keyCode == 13) {
				// 검색어에 엔터를 했을 경우
				goSearch();
			}
		});
		
		
		// 검색시 검색조건 및 검색어 값 유지시키기
		if( ${requestScope.searchType != "" && requestScope.searchWord != ""} ) {
			$("select#searchType").val("${requestScope.searchType}");
			$("input#searchWord").val("${requestScope.searchWord}");
		}
		
	});// end of $(document).ready(function(){})------------------

	
	// Function Declaration
	function goSearch() {
		const frm = document.searchFrm;
		frm.method = "GET";
		frm.action = "<%= ctxPath%>/board/list";
		frm.submit();
	}// end of function goSearch()--------------------
	
</script>

</head>
<body>
	<div class="container my-5">
		<h3 style="display: inline-block;">게시글 목록(Oracle 데이터베이스)</h3> 
		<div id="login_username" style="display: inline-block; color: #990000; margin-left: 40%;"></div>
		
		<table class="table table-hover">
		    <thead>
		    	<tr>
		    		<th colspan="4" class="text-right">
		    		  <button type="button" class="btn btn-success" id="login_logout"></button>
		    		  <c:if test="${sessionScope.loginuser != null}">
		    		  	<button type="button" class="btn btn-info" onclick="javascript:location.href='write'">게시글쓰기</button>
		    		  </c:if>
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
		    	<c:if test="${not empty requestScope.board_List}">
		    		<c:forEach var="board" items="${requestScope.board_List}" varStatus="status"> 
		    			<tr class="exists">
		    				<td><span>${board.num}</span>${status.count}</td>
		    				<td>${board.subject}</td>
		    				<td>${board.member.userName}</td>
		    				<td>${fn:substring(board.regdate, 0, 10)}</td>
		    			</tr>
		    		</c:forEach>
		    	</c:if>
		    	
		    	<c:if test="${empty requestScope.board_List}">
		    		<tr>
		    		  <td colspan="4" class="text-center" style="color: red;">게시글 데이터가 존재하지 않습니다</td>
		    		</tr>
		    	</c:if>
		    </tbody>
		</table>
		
		<div style="display: flex; margin-top: 50px;">
		<form name="searchFrm" style="margin: auto;">
	        <select name="searchType" id="searchType" style="height: 30px;">
	           <option value="">검색조건선택</option>
	           <option value="subject">글제목</option>
	           <option value="content">글내용</option>
	           <option value="all">글제목+글내용</option>
	           <option value="userName">글쓴이</option>
	        </select>
	        <input type="text" name="searchWord" id="searchWord" size="40" autocomplete="off" />
	        <input type="text" style="display: none;" /> <%-- form 태그내에 input 태그가 오로지 1개 뿐일경우에는 엔터를 했을 경우 검색이 되어지므로 이것을 방지하고자 만든것이다. --%> 
	        <button type="button" class="btn btn-secondary btn-sm" onclick="goSearch()">검색</button>
    	</form>
    	<a href="<%= ctxPath%>/board/list" class="btn btn-secondary btn-sm">전체보기</a>
    	</div>
       
	</div>
	
</body>
</html>