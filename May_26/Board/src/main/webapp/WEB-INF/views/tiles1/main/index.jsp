<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String ctxPath = request.getContextPath();
    //     /board
%>


<div class="container-fluid">
	<div class="row">
 	  <div class="col-md-10 offset-md-1">
 	  
		<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">  <!-- carousel slide 는 기본이다. -->
		  <ol class="carousel-indicators">
<%-- 
		    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
		    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
		    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		    <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
--%>

			<c:forEach items="${requestScope.imgfilenameList}" varStatus="status">   			<%-- 4번이 돌아간다. --%>
				<c:if test="${status.index == 0}"> 										<%-- status.count 는 1부터 나가고 status.index 는 0부터 나간다. --%>
				
					<li data-target="#carouselExampleIndicators" data-slide-to="${status.index}" class="active"></li>
					
				</c:if>    								
				
				<c:if test="${status.index > 0}">
				
		    		<li data-target="#carouselExampleIndicators" data-slide-to="${status.index}"></li>
		    	
		    	</c:if> 
			</c:forEach>
			
		  </ol>
		  <div class="carousel-inner">
	<%--
		    <div class="carousel-item active">
		      <img src="<%= ctxPath %>/images/동원.png" class="d-block w-100" alt="..."> <!-- d-block 은 display: block; 이고  w-100 은 width 의 크기는 <div class="carousel-item active">의 width 100% 로 잡으라는 것이다. -->
		      <div class="carousel-caption d-none d-md-block"> <!-- d-none 은 display : none; 이므로 화면에 보이지 않다가, d-md-block 이므로 d-md-block 은 width 가 768px이상인 것에서만 display: block; 으로 보여라는 말이다.  --> 
			    <h5>Koala</h5>
			    <p>Koala Content</p>
			  </div>
		    </div>
		    <div class="carousel-item">
		      <img src="<%= ctxPath %>/images/레노보.png" class="d-block w-100" alt="...">
		      <div class="carousel-caption d-none d-md-block">
			    <h5>Lighthouse</h5>
			    <p>Lighthouse Content</p>
			  </div>		      
		    </div>
		    <div class="carousel-item">
		      <img src="<%= ctxPath %>/images/미샤.png" class="d-block w-100" alt="...">
		      <div class="carousel-caption d-none d-md-block">
			    <h5>Penguins</h5>
			    <p>Penguins Content</p>
			  </div>		      
		    </div>
		    <div class="carousel-item">
		      <img src="<%= ctxPath %>/images/원더플레이스.png" class="d-block w-100" alt="...">
		      <div class="carousel-caption d-none d-md-block">
			    <h5>Penguins</h5>
			    <p>Penguins Content</p>
			  </div>		      
		    </div>
	--%>	    
		    
		   <c:forEach var="filename" items="${requestScope.imgfilenameList}" varStatus="status">     <%-- imgList 에 오라클에 저장되어있는 것들이 존재한다. var 는 파일 한개를 잡기 위해 --%>
		   
		   		<c:if test="${status.index == 0}"> 
				   	<div class="carousel-item active">		<%-- ${imgvo.imgfilename} 는 하나의 파일을 잡을 수 았더. get, set 에서 받아온 것을 사용한것  --%>
				         <img src="<%= ctxPath %>/resources/images/${filename}" class="d-block w-100" alt="..."> <!-- d-block 은 display: block; 이고  w-100 은 width 의 크기는 <div class="carousel-item active">의 width 100% 로 잡으라는 것이다. -->     
				    </div>
			    </c:if>
			    
			    <c:if test="${status.index > 0}">
				    <div class="carousel-item">
				         <img src="<%= ctxPath %>/resources/images/${filename}" class="d-block w-100" alt="...">	      
				    </div>
			    </c:if>
		   
		   </c:forEach>
		    
		    
		  </div>	  
		  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
		    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
		    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		    <span class="sr-only">Next</span>
		  </a>
		  </div>
	   </div>
	</div>
</div>