<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- === #24. tiles 를 사용하는 레이아웃1 페이지 만들기 === --%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% String ctxPath = request.getContextPath(); %>    
    
  <!-- Optional JavaScript -->
  <script type="text/javascript" src="<%= ctxPath%>/resources/smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script> 
  
  <%--  ===== 스피너 및 datepicker 를 사용하기 위해  jquery-ui 사용하기 ===== --%>
  <link rel="stylesheet" type="text/css" href="<%= ctxPath%>/resources/jquery-ui-1.13.1.custom/jquery-ui.css" />
  <script type="text/javascript" src="<%= ctxPath%>/resources/jquery-ui-1.13.1.custom/jquery-ui.js"></script>

  <%-- *** ajax로 파일을 업로드할때 가장 널리 사용하는 방법 ==> ajaxForm *** --%>
  <script type="text/javascript" src="<%= ctxPath%>/resources/js/jquery.form.min.js"></script>

<style>
  @import url('https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@300;400;500;600;700&display=swap');
  @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&display=swap');
</style>

<style type="text/css">
div#div_container {width: 100%; display: flex; background-color: #ffffff; cursor: default;
				 /*font-family: 'IBM Plex Sans KR', sans-serif;*/
				  font-family: 'Noto Sans KR', sans-serif;}
div#div_content {width: 80%; margin: 0px 30px auto; padding-bottom: 30px;}
span#movieRateCount {padding-left: 10px; font-weight: 400; color: #666666; font-size: 14px;}
img#img_movie {border: solid 1px #f8f8f8; border-radius: 2%; box-shadow: 1px 1px 1px #cccccc; width: 100%;}
</style>

<script>

	$(document).ready(function(){

 		
 		
	}); // end of $(document).ready(function(){})

</script>
</head>
<body>
  <div class="container-fluid" style="padding: 0px;">
	<div id="div_container" class="container-fluid">
	  <div id="div_content" class="mx-auto">
	  
  		<h2 style="text-align: left; padding: 10px; font-weight: 800; margin: 15px;">평가한 영화<span id="movieRateCount">200</span></h2>
	  	<div id="div_nav_content" class="container py-3" style="margin-bottom: 30px;"> 

	      <div class="row p-1 mx-auto text-center">
		    <div style="width: 19%; margin: 3px;">
              <img class="img-thumnail w-100" src="<%= ctxPath%>/resources/images/포스터.jpg" style="border: solid 1px #e6e6e6; border-radius: 2%;">
        	  <h5 class="card-title m-2">영화제목</h5>
			  <div class="card-text text-center">
                <i class="fa-solid fa-star" style="color: #FDD346;"></i>
             	<i class="fa-solid fa-star" style="color: #FDD346;"></i>
             	<i class="fa-solid fa-star" style="color: #FDD346;"></i>
             	<i class="fa-solid fa-star" style="color: #FDD346;"></i>
             	<i class="fa-solid fa-star" style="color: #FDD346;"></i>
        	  </div>
	  		</div>
		    <div style="width: 19%; margin: 3px;">
              <img class="img-thumnail w-100" src="<%= ctxPath%>/resources/images/포스터.jpg" style="border: solid 1px #e6e6e6; border-radius: 2%;">
        	  <h5 class="card-title m-2">영화제목</h5>
			  <div class="card-text text-center">
                <i class="fa-solid fa-star" style="color: #FDD346;"></i>
             	<i class="fa-solid fa-star" style="color: #FDD346;"></i>
             	<i class="fa-solid fa-star" style="color: #FDD346;"></i>
             	<i class="fa-solid fa-star" style="color: #FDD346;"></i>
             	<i class="fa-solid fa-star" style="color: #FDD346;"></i>
        	  </div>
	  		</div>
		    <div style="width: 19%; margin: 3px;">
              <img class="img-thumnail w-100" src="<%= ctxPath%>/resources/images/포스터.jpg" style="border: solid 1px #e6e6e6; border-radius: 2%;">
        	  <h5 class="card-title m-2">영화제목</h5>
			  <div class="card-text text-center">
                <i class="fa-solid fa-star" style="color: #FDD346;"></i>
             	<i class="fa-solid fa-star" style="color: #FDD346;"></i>
             	<i class="fa-solid fa-star" style="color: #FDD346;"></i>
             	<i class="fa-solid fa-star" style="color: #FDD346;"></i>
             	<i class="fa-solid fa-star" style="color: #FDD346;"></i>
        	  </div>
	  		</div>
		    <div style="width: 19%; margin: 3px;">
              <img class="img-thumnail w-100" src="<%= ctxPath%>/resources/images/포스터.jpg" style="border: solid 1px #e6e6e6; border-radius: 2%;">
        	  <h5 class="card-title m-2">영화제목</h5>
			  <div class="card-text text-center">
                <i class="fa-solid fa-star" style="color: #FDD346;"></i>
             	<i class="fa-solid fa-star" style="color: #FDD346;"></i>
             	<i class="fa-solid fa-star" style="color: #FDD346;"></i>
             	<i class="fa-solid fa-star" style="color: #FDD346;"></i>
             	<i class="fa-solid fa-star" style="color: #FDD346;"></i>
        	  </div>
	  		</div>
		    <div style="width: 19%; margin: 3px;">
              <img class="img-thumnail w-100" src="<%= ctxPath%>/resources/images/포스터.jpg" style="border: solid 1px #e6e6e6; border-radius: 2%;">
        	  <h5 class="card-title m-2">영화제목</h5>
			  <div class="card-text text-center">
                <i class="fa-solid fa-star" style="color: #FDD346;"></i>
             	<i class="fa-solid fa-star" style="color: #FDD346;"></i>
             	<i class="fa-solid fa-star" style="color: #FDD346;"></i>
             	<i class="fa-solid fa-star" style="color: #FDD346;"></i>
             	<i class="fa-solid fa-star" style="color: #FDD346;"></i>
        	  </div>
	  		</div>
    	  </div>
    	  
        </div>
      </div>
    </div>
  </div>  
  
  
  
  
  
</body>
</html>    