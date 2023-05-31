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
<%-- 유저한줄평 --%>
div#userComment {font-family: 'Noto Sans KR', sans-serif; cursor: default;}
img#img_profile {width: 40px; height: 40px; box-sizing: inherit; border:solid 1px #e6e6e6; border-radius: 50%; box-shadow: 1px 1px 1px #cccccc; margin: 0 6px;}
p.movieRate{height: 30px; border: solid 1px #e6e6e6; border-radius: 20%/40%; padding: 0 10px; margin: 5px 15px; background-color: #ffffff;}
</style>

<script>

	$(document).ready(function(){
 		
	}); // end of $(document).ready(function(){})

</script>
</head>
<body>
  <div class="container" style="padding: 0px;">
	
	<%-- 유저들의 한줄평 보여주기 시작 --%>
    <div id="userComment" class="mx-auto mt-2 mb-3 p-1 carousel slide w-100" data-ride="carousel">
	  <div class="p-0 carousel-inner w-90 mx-auto">
	    <div class="carousel-item active">
		  <div class="row mx-auto my-1">
       	    <div class="col-md-3 p-1">
       		  <div class="mx-auto my-auto p-1" style="background-color: #f8f8f8; border: solid 1px #e6e6e6; border-radius: 2%;">
      		    <div class="flex-container mx-auto my-auto p-2 text-center" style="padding-left: 10px; border-bottom: solid 1px #e6e6e6; display: flex;">
  			      <img id="img_profile" src="<%= ctxPath%>/resources/images/프로필없음.jpg"/>
  			      <h5 style="text-align: left; padding: 0 5px; font-weight: 600; margin: 8px 10px;">서수경</h5>
      		    </div>
       		    <div class="mx-auto my-auto p-2">
     		  	  <p style="padding: 10px; margin: 0px;">픽사의 뛰어난 작품들에서나 발견할 수 있을 것 같은 애절한 순정을 마블에서 만나게 되다니.</p>
     		  	  <div style="display: flex;">
    		  	    <p style="padding-left: 10px; margin: 10px 0px; font-size: 11pt; color: gray;">작성일자&nbsp;<span class="pl-2">2023.05.13</span></p>
  			        <p class="movieRate">★&nbsp;<span>3.5</span></p>
     		  	  </div>
    		  	  <div class="pl-2" style="border-top: solid 1px #e6e6e6; display:flex; padding: 5px; font-size: 11pt; color: gray;">
    		  	    <p class="m-2">좋아요&nbsp;<i class="fa-solid fa-heart" style="color: #ff0558;"></i><span class="pl-2">345</span></p>
    		  	    <p class="m-2">댓글&nbsp;<i class="fa-solid fa-comments" style="color: #e6e6e6;"></i><span class="pl-2">27</span></p>
   		  	      </div>
       		    </div>
      		  </div>
       	    </div>
       	    <div class="col-md-3 p-1">
       		  <div class="mx-auto my-auto p-1" style="background-color: #f8f8f8; border: solid 1px #e6e6e6; border-radius: 2%;">
      		    <div class="flex-container mx-auto my-auto p-2 text-center" style="padding-left: 10px; border-bottom: solid 1px #e6e6e6; display: flex;">
  			      <img id="img_profile" src="<%= ctxPath%>/resources/images/프로필없음.jpg"/>
  			      <h5 style="text-align: left; padding: 0 5px; font-weight: 600; margin: 8px 10px;">서수경</h5>
      		    </div>
       		    <div class="mx-auto my-auto p-2">
     		  	  <p style="padding: 10px; margin: 0px;">픽사의 뛰어난 작품들에서나 발견할 수 있을 것 같은 애절한 순정을 마블에서 만나게 되다니.</p>
     		  	  <div style="display: flex;">
    		  	    <p style="padding-left: 10px; margin: 10px 0px; font-size: 11pt; color: gray;">작성일자&nbsp;<span class="pl-2">2023.05.13</span></p>
  			        <p class="movieRate">★&nbsp;<span>3.5</span></p>
     		  	  </div>
    		  	  <div class="pl-2" style="border-top: solid 1px #e6e6e6; display:flex; padding: 5px; font-size: 11pt; color: gray;">
    		  	    <p class="m-2">좋아요&nbsp;<i class="fa-solid fa-heart" style="color: #ff0558;"></i><span class="pl-2">345</span></p>
    		  	    <p class="m-2">댓글&nbsp;<i class="fa-solid fa-comments" style="color: #e6e6e6;"></i><span class="pl-2">27</span></p>
   		  	      </div>
       		    </div>
      		  </div>
       	    </div>
       	    <div class="col-md-3 p-1">
       		  <div class="mx-auto my-auto p-1" style="background-color: #f8f8f8; border: solid 1px #e6e6e6; border-radius: 2%;">
      		    <div class="flex-container mx-auto my-auto p-2 text-center" style="padding-left: 10px; border-bottom: solid 1px #e6e6e6; display: flex;">
  			      <img id="img_profile" src="<%= ctxPath%>/resources/images/프로필없음.jpg"/>
  			      <h5 style="text-align: left; padding: 0 5px; font-weight: 600; margin: 8px 10px;">서수경</h5>
      		    </div>
       		    <div class="mx-auto my-auto p-2">
     		  	  <p style="padding: 10px; margin: 0px;">픽사의 뛰어난 작품들에서나 발견할 수 있을 것 같은 애절한 순정을 마블에서 만나게 되다니.</p>
     		  	  <div style="display: flex;">
    		  	    <p style="padding-left: 10px; margin: 10px 0px; font-size: 11pt; color: gray;">작성일자&nbsp;<span class="pl-2">2023.05.13</span></p>
  			        <p class="movieRate">★&nbsp;<span>3.5</span></p>
     		  	  </div>
    		  	  <div class="pl-2" style="border-top: solid 1px #e6e6e6; display:flex; padding: 5px; font-size: 11pt; color: gray;">
    		  	    <p class="m-2">좋아요&nbsp;<i class="fa-solid fa-heart" style="color: #ff0558;"></i><span class="pl-2">345</span></p>
    		  	    <p class="m-2">댓글&nbsp;<i class="fa-solid fa-comments" style="color: #e6e6e6;"></i><span class="pl-2">27</span></p>
   		  	      </div>
       		    </div>
      		  </div>
       	    </div>
       	    <div class="col-md-3 p-1">
       		  <div class="mx-auto my-auto p-1" style="background-color: #f8f8f8; border: solid 1px #e6e6e6; border-radius: 2%;">
      		    <div class="flex-container mx-auto my-auto p-2 text-center" style="padding-left: 10px; border-bottom: solid 1px #e6e6e6; display: flex;">
  			      <img id="img_profile" src="<%= ctxPath%>/resources/images/프로필없음.jpg"/>
  			      <h5 style="text-align: left; padding: 0 5px; font-weight: 600; margin: 8px 10px;">서수경</h5>
      		    </div>
       		    <div class="mx-auto my-auto p-2">
     		  	  <p style="padding: 10px; margin: 0px;">픽사의 뛰어난 작품들에서나 발견할 수 있을 것 같은 애절한 순정을 마블에서 만나게 되다니.</p>
     		  	  <div style="display: flex;">
    		  	    <p style="padding-left: 10px; margin: 10px 0px; font-size: 11pt; color: gray;">작성일자&nbsp;<span class="pl-2">2023.05.13</span></p>
  			        <p class="movieRate">★&nbsp;<span>3.5</span></p>
     		  	  </div>
    		  	  <div class="pl-2" style="border-top: solid 1px #e6e6e6; display:flex; padding: 5px; font-size: 11pt; color: gray;">
    		  	    <p class="m-2">좋아요&nbsp;<i class="fa-solid fa-heart" style="color: #ff0558;"></i><span class="pl-2">345</span></p>
    		  	    <p class="m-2">댓글&nbsp;<i class="fa-solid fa-comments" style="color: #e6e6e6;"></i><span class="pl-2">27</span></p>
   		  	      </div>
       		    </div>
      		  </div>
       	    </div>
       	  </div>
        </div>
        <div class="carousel-item">
		  <div class="row mx-auto my-1">
       	    <div class="col-md-3 p-1">
       		  <div class="mx-auto my-auto p-1" style="background-color: #f8f8f8; border: solid 1px #e6e6e6; border-radius: 2%;">
      		    <div class="flex-container mx-auto my-auto p-2 text-center" style="padding-left: 10px; border-bottom: solid 1px #e6e6e6; display: flex;">
  			      <img id="img_profile" src="<%= ctxPath%>/resources/images/프로필없음.jpg"/>
  			      <h5 style="text-align: left; padding: 0 5px; font-weight: 600; margin: 8px 10px;">서수경</h5>
      		    </div>
       		    <div class="mx-auto my-auto p-2">
     		  	  <p style="padding: 10px; margin: 0px;">픽사의 뛰어난 작품들에서나 발견할 수 있을 것 같은 애절한 순정을 마블에서 만나게 되다니.</p>
     		  	  <div style="display: flex;">
    		  	    <p style="padding-left: 10px; margin: 10px 0px; font-size: 11pt; color: gray;">작성일자&nbsp;<span class="pl-2">2023.05.13</span></p>
  			        <p class="movieRate">★&nbsp;<span>3.5</span></p>
     		  	  </div>
    		  	  <div class="pl-2" style="border-top: solid 1px #e6e6e6; display:flex; padding: 5px; font-size: 11pt; color: gray;">
    		  	    <p class="m-2">좋아요&nbsp;<i class="fa-solid fa-heart" style="color: #ff0558;"></i><span class="pl-2">345</span></p>
    		  	    <p class="m-2">댓글&nbsp;<i class="fa-solid fa-comments" style="color: #e6e6e6;"></i><span class="pl-2">27</span></p>
   		  	      </div>
       		    </div>
      		  </div>
       	    </div>
       	    <div class="col-md-3 p-1">
       		  <div class="mx-auto my-auto p-1" style="background-color: #f8f8f8; border: solid 1px #e6e6e6; border-radius: 2%;">
      		    <div class="flex-container mx-auto my-auto p-2 text-center" style="padding-left: 10px; border-bottom: solid 1px #e6e6e6; display: flex;">
  			      <img id="img_profile" src="<%= ctxPath%>/resources/images/프로필없음.jpg"/>
  			      <h5 style="text-align: left; padding: 0 5px; font-weight: 600; margin: 8px 10px;">서수경</h5>
      		    </div>
       		    <div class="mx-auto my-auto p-2">
     		  	  <p style="padding: 10px; margin: 0px;">픽사의 뛰어난 작품들에서나 발견할 수 있을 것 같은 애절한 순정을 마블에서 만나게 되다니.</p>
     		  	  <div style="display: flex;">
    		  	    <p style="padding-left: 10px; margin: 10px 0px; font-size: 11pt; color: gray;">작성일자&nbsp;<span class="pl-2">2023.05.13</span></p>
  			        <p class="movieRate">★&nbsp;<span>3.5</span></p>
     		  	  </div>
    		  	  <div class="pl-2" style="border-top: solid 1px #e6e6e6; display:flex; padding: 5px; font-size: 11pt; color: gray;">
    		  	    <p class="m-2">좋아요&nbsp;<i class="fa-solid fa-heart" style="color: #ff0558;"></i><span class="pl-2">345</span></p>
    		  	    <p class="m-2">댓글&nbsp;<i class="fa-solid fa-comments" style="color: #e6e6e6;"></i><span class="pl-2">27</span></p>
   		  	      </div>
       		    </div>
      		  </div>
       	    </div>
       	    <div class="col-md-3 p-1">
       		  <div class="mx-auto my-auto p-1" style="background-color: #f8f8f8; border: solid 1px #e6e6e6; border-radius: 2%;">
      		    <div class="flex-container mx-auto my-auto p-2 text-center" style="padding-left: 10px; border-bottom: solid 1px #e6e6e6; display: flex;">
  			      <img id="img_profile" src="<%= ctxPath%>/resources/images/프로필없음.jpg"/>
  			      <h5 style="text-align: left; padding: 0 5px; font-weight: 600; margin: 8px 10px;">서수경</h5>
      		    </div>
       		    <div class="mx-auto my-auto p-2">
     		  	  <p style="padding: 10px; margin: 0px;">픽사의 뛰어난 작품들에서나 발견할 수 있을 것 같은 애절한 순정을 마블에서 만나게 되다니.</p>
     		  	  <div style="display: flex;">
    		  	    <p style="padding-left: 10px; margin: 10px 0px; font-size: 11pt; color: gray;">작성일자&nbsp;<span class="pl-2">2023.05.13</span></p>
  			        <p class="movieRate">★&nbsp;<span>3.5</span></p>
     		  	  </div>
    		  	  <div class="pl-2" style="border-top: solid 1px #e6e6e6; display:flex; padding: 5px; font-size: 11pt; color: gray;">
    		  	    <p class="m-2">좋아요&nbsp;<i class="fa-solid fa-heart" style="color: #ff0558;"></i><span class="pl-2">345</span></p>
    		  	    <p class="m-2">댓글&nbsp;<i class="fa-solid fa-comments" style="color: #e6e6e6;"></i><span class="pl-2">27</span></p>
   		  	      </div>
       		    </div>
      		  </div>
       	    </div>
       	    <div class="col-md-3 p-1">
       		  <div class="mx-auto my-auto p-1" style="background-color: #f8f8f8; border: solid 1px #e6e6e6; border-radius: 2%;">
      		    <div class="flex-container mx-auto my-auto p-2 text-center" style="padding-left: 10px; border-bottom: solid 1px #e6e6e6; display: flex;">
  			      <img id="img_profile" src="<%= ctxPath%>/resources/images/프로필없음.jpg"/>
  			      <h5 style="text-align: left; padding: 0 5px; font-weight: 600; margin: 8px 10px;">서수경</h5>
      		    </div>
       		    <div class="mx-auto my-auto p-2">
     		  	  <p style="padding: 10px; margin: 0px;">픽사의 뛰어난 작품들에서나 발견할 수 있을 것 같은 애절한 순정을 마블에서 만나게 되다니.</p>
     		  	  <div style="display: flex;">
    		  	    <p style="padding-left: 10px; margin: 10px 0px; font-size: 11pt; color: gray;">작성일자&nbsp;<span class="pl-2">2023.05.13</span></p>
  			        <p class="movieRate">★&nbsp;<span>3.5</span></p>
     		  	  </div>
    		  	  <div class="pl-2" style="border-top: solid 1px #e6e6e6; display:flex; padding: 5px; font-size: 11pt; color: gray;">
    		  	    <p class="m-2">좋아요&nbsp;<i class="fa-solid fa-heart" style="color: #ff0558;"></i><span class="pl-2">345</span></p>
    		  	    <p class="m-2">댓글&nbsp;<i class="fa-solid fa-comments" style="color: #e6e6e6;"></i><span class="pl-2">27</span></p>
   		  	      </div>
       		    </div>
      		  </div>
       	    </div>
       	  </div>
        </div>
        <div class="carousel-item">
		  <div class="row mx-auto my-1">
       	    <div class="col-md-3 p-1">
       		  <div class="mx-auto my-auto p-1" style="background-color: #f8f8f8; border: solid 1px #e6e6e6; border-radius: 2%;">
      		    <div class="flex-container mx-auto my-auto p-2 text-center" style="padding-left: 10px; border-bottom: solid 1px #e6e6e6; display: flex;">
  			      <img id="img_profile" src="<%= ctxPath%>/resources/images/프로필없음.jpg"/>
  			      <h5 style="text-align: left; padding: 0 5px; font-weight: 600; margin: 8px 10px;">서수경</h5>
      		    </div>
       		    <div class="mx-auto my-auto p-2">
     		  	  <p style="padding: 10px; margin: 0px;">픽사의 뛰어난 작품들에서나 발견할 수 있을 것 같은 애절한 순정을 마블에서 만나게 되다니.</p>
     		  	  <div style="display: flex;">
    		  	    <p style="padding-left: 10px; margin: 10px 0px; font-size: 11pt; color: gray;">작성일자&nbsp;<span class="pl-2">2023.05.13</span></p>
  			        <p class="movieRate">★&nbsp;<span>3.5</span></p>
     		  	  </div>
    		  	  <div class="pl-2" style="border-top: solid 1px #e6e6e6; display:flex; padding: 5px; font-size: 11pt; color: gray;">
    		  	    <p class="m-2">좋아요&nbsp;<i class="fa-solid fa-heart" style="color: #ff0558;"></i><span class="pl-2">345</span></p>
    		  	    <p class="m-2">댓글&nbsp;<i class="fa-solid fa-comments" style="color: #e6e6e6;"></i><span class="pl-2">27</span></p>
   		  	      </div>
       		    </div>
      		  </div>
       	    </div>
       	    <div class="col-md-3 p-1">
       		  <div class="mx-auto my-auto p-1" style="background-color: #f8f8f8; border: solid 1px #e6e6e6; border-radius: 2%;">
      		    <div class="flex-container mx-auto my-auto p-2 text-center" style="padding-left: 10px; border-bottom: solid 1px #e6e6e6; display: flex;">
  			      <img id="img_profile" src="<%= ctxPath%>/resources/images/프로필없음.jpg"/>
  			      <h5 style="text-align: left; padding: 0 5px; font-weight: 600; margin: 8px 10px;">서수경</h5>
      		    </div>
       		    <div class="mx-auto my-auto p-2">
     		  	  <p style="padding: 10px; margin: 0px;">픽사의 뛰어난 작품들에서나 발견할 수 있을 것 같은 애절한 순정을 마블에서 만나게 되다니.</p>
     		  	  <div style="display: flex;">
    		  	    <p style="padding-left: 10px; margin: 10px 0px; font-size: 11pt; color: gray;">작성일자&nbsp;<span class="pl-2">2023.05.13</span></p>
  			        <p class="movieRate">★&nbsp;<span>3.5</span></p>
     		  	  </div>
    		  	  <div class="pl-2" style="border-top: solid 1px #e6e6e6; display:flex; padding: 5px; font-size: 11pt; color: gray;">
    		  	    <p class="m-2">좋아요&nbsp;<i class="fa-solid fa-heart" style="color: #ff0558;"></i><span class="pl-2">345</span></p>
    		  	    <p class="m-2">댓글&nbsp;<i class="fa-solid fa-comments" style="color: #e6e6e6;"></i><span class="pl-2">27</span></p>
   		  	      </div>
       		    </div>
      		  </div>
       	    </div>
       	    <div class="col-md-3 p-1">
       		  <div class="mx-auto my-auto p-1" style="background-color: #f8f8f8; border: solid 1px #e6e6e6; border-radius: 2%;">
      		    <div class="flex-container mx-auto my-auto p-2 text-center" style="padding-left: 10px; border-bottom: solid 1px #e6e6e6; display: flex;">
  			      <img id="img_profile" src="<%= ctxPath%>/resources/images/프로필없음.jpg"/>
  			      <h5 style="text-align: left; padding: 0 5px; font-weight: 600; margin: 8px 10px;">서수경</h5>
      		    </div>
       		    <div class="mx-auto my-auto p-2">
     		  	  <p style="padding: 10px; margin: 0px;">픽사의 뛰어난 작품들에서나 발견할 수 있을 것 같은 애절한 순정을 마블에서 만나게 되다니.</p>
     		  	  <div style="display: flex;">
    		  	    <p style="padding-left: 10px; margin: 10px 0px; font-size: 11pt; color: gray;">작성일자&nbsp;<span class="pl-2">2023.05.13</span></p>
  			        <p class="movieRate">★&nbsp;<span>3.5</span></p>
     		  	  </div>
    		  	  <div class="pl-2" style="border-top: solid 1px #e6e6e6; display:flex; padding: 5px; font-size: 11pt; color: gray;">
    		  	    <p class="m-2">좋아요&nbsp;<i class="fa-solid fa-heart" style="color: #ff0558;"></i><span class="pl-2">345</span></p>
    		  	    <p class="m-2">댓글&nbsp;<i class="fa-solid fa-comments" style="color: #e6e6e6;"></i><span class="pl-2">27</span></p>
   		  	      </div>
       		    </div>
      		  </div>
       	    </div>
       	    <div class="col-md-3 p-1">
       		  <div class="mx-auto my-auto p-1" style="background-color: #f8f8f8; border: solid 1px #e6e6e6; border-radius: 2%;">
      		    <div class="flex-container mx-auto my-auto p-2 text-center" style="padding-left: 10px; border-bottom: solid 1px #e6e6e6; display: flex;">
  			      <img id="img_profile" src="<%= ctxPath%>/resources/images/프로필없음.jpg"/>
  			      <h5 style="text-align: left; padding: 0 5px; font-weight: 600; margin: 8px 10px;">서수경</h5>
      		    </div>
       		    <div class="mx-auto my-auto p-2">
     		  	  <p style="padding: 10px; margin: 0px;">픽사의 뛰어난 작품들에서나 발견할 수 있을 것 같은 애절한 순정을 마블에서 만나게 되다니.</p>
     		  	  <div style="display: flex;">
    		  	    <p style="padding-left: 10px; margin: 10px 0px; font-size: 11pt; color: gray;">작성일자&nbsp;<span class="pl-2">2023.05.13</span></p>
  			        <p class="movieRate">★&nbsp;<span>3.5</span></p>
     		  	  </div>
    		  	  <div class="pl-2" style="border-top: solid 1px #e6e6e6; display:flex; padding: 5px; font-size: 11pt; color: gray;">
    		  	    <p class="m-2">좋아요&nbsp;<i class="fa-solid fa-heart" style="color: #ff0558;"></i><span class="pl-2">345</span></p>
    		  	    <p class="m-2">댓글&nbsp;<i class="fa-solid fa-comments" style="color: #e6e6e6;"></i><span class="pl-2">27</span></p>
   		  	      </div>
       		    </div>
      		  </div>
       	    </div>
       	  </div>
        </div>
      </div>
      <a class="carousel-control-prev" href="#userComment" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="carousel-control-next" href="#userComment" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
	</div>
	<%-- 유저들의 한줄평 보여주기 끝 --%>
  
  </div>
  
  
  
  
  
</body>
</html>    