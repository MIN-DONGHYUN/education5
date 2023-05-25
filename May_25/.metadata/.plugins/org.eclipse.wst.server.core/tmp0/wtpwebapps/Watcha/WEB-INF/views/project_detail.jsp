<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    String ctxPath = request.getContextPath();
%>     
    
<!DOCTYPE html>
<html>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
<head>

<style type="text/css">

	body {
		border: solid 1px gray;
		word-break: break-all; /* 공백없이 영어로만 되어질 경우 해당구역을 뚫고 빠져나감으로 이것을 막기 위해서 사용한다 */
		padding: 0;            /* 상 우 하 좌 모두 안쪽여백을 0px을 준 것이다. 즉, 바깥여백을 없는 것으로 한 것이다.*/
	}	

	div#container{
		border: solid 1px purple;
		width: 80%;
		margin: 20px auto; /* 상 하는 20px 우 좌는 남은 20%에서 좌우로 균등하게 주겠다. 즉, 화면의 가운데로 위치하겠다는 말이다.*/
	}

	div#header{
		border: solid 1.5px #b3b3b3; 
		height: 100px;
		
		border-radius: 10px 10px;
	}
	
	
	div#contents{
		border: solid 1.5px #b3b3b3;
		width: 100%;
		display: inline-block;
		height: 400px;
		
		border-radius: 10px 10px;
	}	
	
	
</style>

<meta charset="UTF-8">
<title>제품상세</title>
</head>
<body>
	<div id="container">
		<div id="header">
		
		<div id="post_img" class="divshadow">
			<img src="<%=ctxPath%>/final_image/포스터w185.jpg">
		</div>
		
		</div>
		<div id="contents">
		
		</div>
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>