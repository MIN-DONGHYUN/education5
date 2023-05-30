<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    String ctxPath = request.getContextPath();
%>     

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>

<!-- slick 이용하기 위한 링크 -->
<script src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script> 
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css" />


<style type="text/css">
  .main-h5 {
    font-weight: bold;
    text-align: left;
    left: 13px;
    position: relative;
  }
  
  .main-h5-2 {
  	margin-top: 40px;
  }
  
  .main-ad-span {
  	font-size: 10pt;
  	padding-left: 10px;
  	display: block;
  }
  
  .centered-container {
	display: flex;
	justify-content: center;
	align-items: center;
  }
  
  .Main-card {
  	border: none;
  	height: 400px;
  }
  
  .Main-card-header {
  	height: 300px;
  	padding: 0 10px;
  }
  
  .Main-card-header-fin {
  	height: 50%;
  	padding: 0;
  	display: flex;
  	background-color: gray;
  }
  
  .Main-card-header > img {  	
  	height: 300px;
  }
  
  .Main-card-body {
  	padding: 10px 10px 0 10px;
  	height: 100px;
  	font-size: 11pt;
  	color: black;
  }
  
  .Main-card-body > h5{
  	overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    font-size: 13pt;
  }
  
  .Main-card2 {
  	border: none;
  	height: 300px;
  }
  
  .Main-card-header2 {
  	height: 200px;
  	padding: 0 10px;
  }
  
  .Main-card-header2 > img {  	
  	height: 200px;
  }
  
  .Main-card-body2 {
  	padding: 10px 10px 0 10px;
  	height: 100px;
  	font-size: 11pt;
  	color: black;
  }
  
  .Main-card-body2 > h5{
  	overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    font-size: 13pt;
  }
  
  .Main-card-body3 > h5 {
  	font-size: 13pt;
  	padding: 0 10px;
  	color: black;
  }
  
  .card-img-top {
  	border: solid 1px #e6e6e6;
  }
  
  .card-img-top-fin {
  	width: 50%;
  	padding: 1px;
  }

  
  .Main-a:hover {
  	text-decoration-line: none;
  }
  
  .slick-prev:before {
		color: gray;
    	font-size: xx-large;
  }
	
  .slick-next:before {
		color: gray;
    	font-size: xx-large;
    	right: 13px;
   		position: relative;
  }

  .centered-container > a{
  	color: black;
  }
  
  .centered-container > a:hover{
  	text-decoration-line: none;
  }
  
  .Main-card-in-no {
  	position: relative;
    bottom: 24px;
  }
  
  .main-number {
  	bottom: 290px;
    position: relative;
    left: 15px;
    background-color: rgba(0, 0, 0, 0.77);
    color: rgb(255, 255, 255);
    font-weight: 700;
    letter-spacing: normal;
    font-size: 14px;
    line-height: 22px;
    text-align: center;
    width: 24px;
    height: 24px;
    border-radius: 4px;
    opacity: 1;
    transition: opacity 300ms ease 0s;
  }


   
  
  
  @media (max-width: 768px) {
	    .carousel-inner .carousel-item > div {
		    display: none;
		  }
		  .carousel-inner .carousel-item > div:nth-child(-n+2) {
		    display: block;
		  }
		  .main-ad-btn{
			position: relative; 
			bottom: 35px;
			margin-left: 10px;
		}
		  
	}
	
	.carousel-inner .carousel-item.active,
	.carousel-inner .carousel-item-next,
	.carousel-inner .carousel-item-prev {
	    display: flex;
	}
	
	/* display 3 */
	@media (min-width: 768px) {
		.main-ad-div {
		  	display: flex;
		}
		.main-ad-btn{
			margin: 10% 5% 5% 5%; 
			width: 92%;
		}
	}
	
	
	
	
	/* ////////////////////////////////////////////////////// */


	
/* 	img.card-size {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    width: 100%;
    height: 100%;
    }  */
	

</style>




<script type="text/javascript">

$(document).ready(function() {
/* 	let resizeTimer;						// 창 크기가 빠르게 변경되면 안되는 현상을 고치기 위해 타임아웃 사용
	$(window).on('resize', function() {    // 창 크기가 변경될 때마다 다시 실행 
	    clearTimeout(resizeTimer);			// 타임아웃 사용 (일정시간 지난후에 실행한다.)
	    resizeTimer = setTimeout(function() {
	        CarouselGO();
	    }, 150); // 150ms의 딜레이를 사용하여 타임아웃 설정
	}); */
	Carousel();
	StarRank();
	
	
});
		
function Carousel(){
	
    $('.main-carousel-card').slick({
    	  dots: false,     /* 밑에 점으로 표시되는것  */
    	  infinite: false,  /* 반복할것인지 파악하기 */
    	  speed: 300,		/* 슬라이드 스피드 */
    	  slidesToShow: 5,	/* 몇개씩 보여줄것인지 파악 */
    	  slidesToScroll: 5,	/* 몇개씩 넘길것인지 파악 */
    	  responsive: [
    	    {
    	      breakpoint: 1024,		/* 사이즈가 1024 보다 작으면 시작 */
    	      settings: {  
      	        dots: false,
      	        infinite: false,  
    	    	slidesToShow: 4,
    	        slidesToScroll: 4
    	      }
    	    },
    	    {
    	      breakpoint: 768,
    	      settings: {
    	    	dots: false,
        	    infinite: false,   
    	        slidesToShow: 2,
    	        slidesToScroll: 2
    	      }
    	    }

    	  ]
    	});	
    
    
    $('.main-carousel-card2').slick({
  	  dots: false,     /* 밑에 점으로 표시되는것  */
  	  infinite: false,  /* 반복할것인지 파악하기 */
  	  speed: 300,		/* 슬라이드 스피드 */
  	  slidesToShow: 6,	/* 몇개씩 보여줄것인지 파악 */
  	  slidesToScroll: 6,	/* 몇개씩 넘길것인지 파악 */
  	  responsive: [
  	    {
  	      breakpoint: 1024,		/* 사이즈가 1024 보다 작으면 시작 */
  	      settings: {  
    	        dots: false,
    	        infinite: false,  
  	    	slidesToShow: 5,
  	        slidesToScroll: 5
  	      }
  	    },
  	    {
  	      breakpoint: 768,
  	      settings: {
  	    	dots: false,
      	    infinite: false,   
  	        slidesToShow: 3,
  	        slidesToScroll: 3
  	      }
  	    }

  	  ]
  	});	
}

<%-- // 평점 순위 일때 
function StarRank() {
	$.ajax({
		url:"<%= ctxPath%>/view/main.action",
		method:"GET",
		success:function(){
			console.log("안녕");
		},
		error: function(request, status, error){
            alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
        }
		
		
		
	});
}
 --%>


</script>

</head>
<body>

<div class="container" style="padding: 0;">
   <h5 class="h5 main-h5">평점순위</h5>
   
	<div class="container my-3">
		
		<div class="card-deck main-carousel-card mb-5">
		  
		  <c:forEach var="starRankvo" items="${requestScope.starRankvo}" varStatus="status">
		  
			  <a href = "/project_detail?movie_id=${starRankvo.movie_id}" title="${starRankvo.movie_title}" class="Main-a">
				  <div class="Main-card">
				  	<div class="Main-card-header">
				    	<img src="https://image.tmdb.org/t/p/w500/${starRankvo.poster_path}" class="card-img-top" alt="...">
				    </div>
				    <div class="main-number">${status.index + 1}</div>
				    <div class="Main-card-body Main-card-in-no">
				      <h5 class="card-title card-font" >${starRankvo.movie_title}</h5>
				      <p style="margin: 0;"><span class="text-muted">개봉일자 : ${starRankvo.release_date} ・ ${starRankvo.original_language}</span></p>
				      <p><span class="text-muted">평균★<span id="">${starRankvo.rating_avg}</span></span></p>
				    </div>
				  </div>
			  </a> 
		  </c:forEach>
		</div>
	</div>	
	    
	
	
	<h5 class="h5 main-h5 main-h5-2">보고싶어요 순위</h5>
   	 <div class="container my-3">

		<div class="card-deck main-carousel-card mb-5">
		  
		 <c:forEach var="seeRankvo" items="${requestScope.seeRankvo}" varStatus="status">
		  
			  <a href = "/project_detail?movie_id=${seeRankvo.movie_id}" title="${seeRankvo.movie_title}" class="Main-a">
				  <div class="Main-card">
				  	<div class="Main-card-header">
				    	<img src="https://image.tmdb.org/t/p/w500/${seeRankvo.poster_path}" class="card-img-top" alt="...">
				    </div>
				    <div class="main-number">${status.index + 1}</div>
				    <div class="Main-card-body Main-card-in-no">
				      <h5 class="card-title card-font" >${seeRankvo.movie_title}</h5>
				      <p style="margin: 0;"><span class="text-muted">개봉일자 : ${seeRankvo.release_date} ・ ${seeRankvo.original_language}</span></p>
				      <p><span class="text-muted">평균★<span id="">${seeRankvo.rating_avg}</span></span></p>
				    </div>
				  </div>
			  </a> 
		  </c:forEach>
		  
		</div>
	</div>	  
	
	<%-- 광고 부분 --%>	   
	<div style="margin: 30px 0 ;">
		<div style="max-width: 60%; margin: 0px auto; text-align: left; border: solid 1px black;">
			<section>
				<div class="main-ad-div">
					<a href="https://www.frombio.co.kr/product/detail.html?product_no=797&cate_no=101&display_group=1&utm_source=watcha&utm_medium=da&utm_campaign=100deal&browser_open_type=external">
						<img src="<%= ctxPath%>/resources/images/광고.png" style="width: 100%; height: 100%;">	
					</a>
					<div class="centered-container">
					  <a href="https://www.frombio.co.kr/product/detail.html?product_no=797&cate_no=101&display_group=1&utm_source=watcha&utm_medium=da&utm_campaign=100deal&browser_open_type=external" style="padding: 5%">
					    <span class="main-ad-span">프롬바이오 100원 딜!</span>
					    <span class="main-ad-span">오직 여디서만,</span>
					    <span class="main-ad-span">건강즙이 100원</span>
					    <img src="<%= ctxPath%>/resources/images/광고1.png">
					    <button type="button" class="btn btn-danger main-ad-btn">구매하기</button>
					  </a>
					</div>

				</div>
			</section>
		</div>
	</div>
	
	<%-- 다시 캐러셀 --%>
	
	<h5 class="h5 main-h5 main-h5-3">컬렉션 좋아요 순위</h5>
   	 <div class="container my-3">

		<div class="card-deck main-carousel-card mb-5">
		  
		  <a href = "" title="범죄도시" class="Main-a">
			  <div class="Main-card">
			  	<div class="Main-card-header">
			    	<img src="<%= ctxPath%>/resources/images/범죄도시.jpg" class="card-img-top" alt="...">
			    </div>
			    <div class="Main-card-body">
			      <h5 class="card-title card-font" >범죄도시3</h5>
			      <p style="margin: 0;"><span class="text-muted">2023 ・ 한국</span></p>
			      <p><span class="text-muted">평균★<span id="">4.0</span></span></p>
			    </div>
			  </div>
		  </a>
		  
		  <a href = "" title="인어공주" class="Main-a">
		  <div class="Main-card">
		    <div class="Main-card-header">
		    	<img src="<%= ctxPath%>/resources/images/인어공주.jpg" class="card-img-top" alt="...">
		    </div>
		    <div class="Main-card-body">
			      <h5 class="card-title card-font" >인어공주</h5>
			      <p style="margin: 0;"><span class="text-muted">2023 ・ 미국</span></p>
			      <p><span class="text-muted">평균★<span id="">2.0</span></span></p>
			</div>
		  </div>
		  </a>
		  
		  <a href = "" title="분노의질주: 라이드 오어 다이" class="Main-a">
		  <div class="Main-card">
		    <div class="Main-card-header">
		    	<img src="<%= ctxPath%>/resources/images/분노의질주.jpg" class="card-img-top  card-size" alt="...">
		    </div>
		    <div class="Main-card-body">
			      <h5 class="card-title card-font" >분노의 질주: 라이드 오어 다이</h5>
			      <p style="margin: 0;"><span class="text-muted">2023 ・ 미국</span></p>
			      <p><span class="text-muted">평균★<span id="">3.2</span></span></p>
			</div>
		  </div>
		  </a>
		  
		  <a href = "" title="가디언즈오브갤럭시: volume 3" class="Main-a">
		  <div class="Main-card">
		    <div class="Main-card-header">
		    	<img src="<%= ctxPath%>/resources/images/가디언즈오브갤럭시.jpg" class="card-img-top card-size" alt="...">
		    </div>
		    <div class="Main-card-body">
			      <h5 class="card-title card-font" >가디언즈 오브 갤럭시: Volume 3</h5>
			      <p style="margin: 0;"><span class="text-muted">2023 ・ 미국</span></p>
			      <p><span class="text-muted">평균★<span id="">4.1</span></span></p>
			</div>
		  </div>
		  </a>
		  
		  <a href = "" title="남은 인생 10년" class="Main-a">
		  <div class="Main-card">
		    <div class="Main-card-header">
		    	<img src="<%= ctxPath%>/resources/images/남은인생10년.jpg" class="card-img-top card-size" alt="...">
		    </div>
		    <div class="Main-card-body">
			      <h5 class="card-title card-font" >남은 인생 10년</h5>
			      <p style="margin: 0;"><span class="text-muted">2022 ・ 일본</span></p>
			      <p><span class="text-muted">평균★<span id="">3.3</span></span></p>
			</div>
		  </div>
		  </a>
		  
		  <a href = "" class="Main-a">
		  <div class="Main-card">
		    <div class="Main-card-header">
		    	<img src="<%= ctxPath%>/resources/images/동원.png" class="card-img-top card-size" alt="...">
		    </div>
		    <div class="Main-card-body">
			      <h5 class="card-title card-font" >범죄도시3</h5>
			      <p style="margin: 0;"><span class="text-muted">2023 ・ 한국</span></p>
			      <p><span class="text-muted">평균★<span id="">2.0</span></span></p>
			</div>
		  </div>
		  </a>
		  
		  <a href = "" class="Main-a">
		  <div class="Main-card">
		    <div class="Main-card-header">
		    	<img src="<%= ctxPath%>/resources/images/동원.png" class="card-img-top card-size" alt="...">
		    </div>
		    <div class="Main-card-body">
			      <h5 class="card-title card-font" >범죄도시3</h5>
			      <p style="margin: 0;"><span class="text-muted">2023 ・ 한국</span></p>
			      <p><span class="text-muted">평균★<span id="">2.0</span></span></p>
			</div>
		  </div>
		  </a>
		  
		  <a href = "" class="Main-a">
		  <div class="Main-card">
		    <div class="Main-card-header">
		    	<img src="<%= ctxPath%>/resources/images/동원.png" class="card-img-top card-size" alt="...">
		    </div>
		    <div class="Main-card-body">
			      <h5 class="card-title card-font" >범죄도시3</h5>
			      <p style="margin: 0;"><span class="text-muted">2023 ・ 한국</span></p>
			      <p><span class="text-muted">평균★<span id="">2.0</span></span></p>
			</div>
		  </div>
		  </a>
		  
		  <a href = "" class="Main-a">
		  <div class="Main-card">
		    <div class="Main-card-header">
		    	<img src="<%= ctxPath%>/resources/images/동원.png" class="card-img-top card-size" alt="...">
		    </div>
		    <div class="Main-card-body">
			      <h5 class="card-title card-font" >범죄도시3</h5>
			      <p style="margin: 0;"><span class="text-muted">2023 ・ 한국</span></p>
			      <p><span class="text-muted">평균★<span id="">2.0</span></span></p>
			</div>
		  </div>
		  </a>
		  
		  <a href = "" class="Main-a">
		  <div class="Main-card">
		    <div class="Main-card-header">
		    	<img src="<%= ctxPath%>/resources/images/동원.png" class="card-img-top card-size" alt="...">
		    </div>
		    <div class="Main-card-body">
			      <h5 class="card-title card-font" >범죄도시3</h5>
			      <p style="margin: 0;"><span class="text-muted">2023 ・ 한국</span></p>
			      <p><span class="text-muted">평균★<span id="">2.0</span></span></p>
			</div>
		  </div>
		  </a>
		  
		   <a href = "" title="범죄도시" class="Main-a">
			  <div class="Main-card">
			  	<div class="Main-card-header">
			    	<img src="<%= ctxPath%>/resources/images/범죄도시.jpg" class="card-img-top" alt="...">
			    </div>
			    <div class="Main-card-body">
			      <h5 class="card-title card-font" >범죄도시3</h5>
			      <p style="margin: 0;"><span class="text-muted">2023 ・ 한국</span></p>
			      <p><span class="text-muted">평균★<span id="">4.0</span></span></p>
			    </div>
			  </div>
		  </a>
		  
		  
		   <a href = "" title="범죄도시" class="Main-a">
			  <div class="Main-card">
			  	<div class="Main-card-header">
			    	<img src="<%= ctxPath%>/resources/images/범죄도시.jpg" class="card-img-top" alt="...">
			    </div>
			    <div class="Main-card-body">
			      <h5 class="card-title card-font" >범죄도시3</h5>
			      <p style="margin: 0;"><span class="text-muted">2023 ・ 한국</span></p>
			      <p><span class="text-muted">평균★<span id="">4.0</span></span></p>
			    </div>
			  </div>
		  </a> 
		  
		</div>
	</div>	
	
	
	<h5 class="h5 main-h5 main-h5-3">배우별</h5>
   	 <div class="container my-3">

		<div class="card-deck main-carousel-card2 mb-5">
		  
		  <a href = "" title="범죄도시" class="Main-a">
			  <div class="Main-card2">
			  	<div class="Main-card-header2">
			    	<img src="<%= ctxPath%>/resources/images/범죄도시.jpg" class="card-img-top" alt="...">
			    </div>
			    <div class="Main-card-body2">
			      <h5 class="card-title card-font" >범죄도시3</h5>
			      <p style="margin: 0;"><span class="text-muted">2023 ・ 한국</span></p>
			      <p><span class="text-muted">평균★<span id="">4.0</span></span></p>
			    </div>
			  </div>
		  </a>
		  
		  <a href = "" title="인어공주" class="Main-a">
		  <div class="Main-card2">
		    <div class="Main-card-header2">
		    	<img src="<%= ctxPath%>/resources/images/인어공주.jpg" class="card-img-top" alt="...">
		    </div>
		    <div class="Main-card-body2">
			      <h5 class="card-title card-font" >인어공주</h5>
			      <p style="margin: 0;"><span class="text-muted">2023 ・ 미국</span></p>
			      <p><span class="text-muted">평균★<span id="">2.0</span></span></p>
			</div>
		  </div>
		  </a>
		  
		  <a href = "" title="분노의질주: 라이드 오어 다이" class="Main-a">
		  <div class="Main-card2">
		    <div class="Main-card-header2">
		    	<img src="<%= ctxPath%>/resources/images/분노의질주.jpg" class="card-img-top  card-size" alt="...">
		    </div>
		    <div class="Main-card-body2">
			      <h5 class="card-title card-font" >분노의 질주: 라이드 오어 다이</h5>
			      <p style="margin: 0;"><span class="text-muted">2023 ・ 미국</span></p>
			      <p><span class="text-muted">평균★<span id="">3.2</span></span></p>
			</div>
		  </div>
		  </a>
		  
		  <a href = "" title="가디언즈오브갤럭시: volume 3" class="Main-a">
		  <div class="Main-card2">
		    <div class="Main-card-header2">
		    	<img src="<%= ctxPath%>/resources/images/가디언즈오브갤럭시.jpg" class="card-img-top card-size" alt="...">
		    </div>
		    <div class="Main-card-body2">
			      <h5 class="card-title card-font" >가디언즈 오브 갤럭시: Volume 3</h5>
			      <p style="margin: 0;"><span class="text-muted">2023 ・ 미국</span></p>
			      <p><span class="text-muted">평균★<span id="">4.1</span></span></p>
			</div>
		  </div>
		  </a>
		  
		  <a href = "" title="남은 인생 10년" class="Main-a">
		  <div class="Main-card2">
		    <div class="Main-card-header2">
		    	<img src="<%= ctxPath%>/resources/images/남은인생10년.jpg" class="card-img-top card-size" alt="...">
		    </div>
		    <div class="Main-card-body2">
			      <h5 class="card-title card-font" >남은 인생 10년</h5>
			      <p style="margin: 0;"><span class="text-muted">2022 ・ 일본</span></p>
			      <p><span class="text-muted">평균★<span id="">3.3</span></span></p>
			</div>
		  </div>
		  </a>
		  
		  <a href = "" class="Main-a">
		  <div class="Main-card2">
		    <div class="Main-card-header2">
		    	<img src="<%= ctxPath%>/resources/images/동원.png" class="card-img-top card-size" alt="...">
		    </div>
		    <div class="Main-card-body2">
			      <h5 class="card-title card-font" >범죄도시3</h5>
			      <p style="margin: 0;"><span class="text-muted">2023 ・ 한국</span></p>
			      <p><span class="text-muted">평균★<span id="">2.0</span></span></p>
			</div>
		  </div>
		  </a>
		  
		  <a href = "" class="Main-a">
		  <div class="Main-card2">
		    <div class="Main-card-header2">
		    	<img src="<%= ctxPath%>/resources/images/동원.png" class="card-img-top card-size" alt="...">
		    </div>
		    <div class="Main-card-body2">
			      <h5 class="card-title card-font" >범죄도시3</h5>
			      <p style="margin: 0;"><span class="text-muted">2023 ・ 한국</span></p>
			      <p><span class="text-muted">평균★<span id="">2.0</span></span></p>
			</div>
		  </div>
		  </a>
		  
		  <a href = "" class="Main-a">
		  <div class="Main-card2">
		    <div class="Main-card-header2">
		    	<img src="<%= ctxPath%>/resources/images/동원.png" class="card-img-top card-size" alt="...">
		    </div>
		    <div class="Main-card-body2">
			      <h5 class="card-title card-font" >범죄도시3</h5>
			      <p style="margin: 0;"><span class="text-muted">2023 ・ 한국</span></p>
			      <p><span class="text-muted">평균★<span id="">2.0</span></span></p>
			</div>
		  </div>
		  </a>
		  
		  <a href = "" class="Main-a">
		  <div class="Main-card2">
		    <div class="Main-card-header2">
		    	<img src="<%= ctxPath%>/resources/images/동원.png" class="card-img-top card-size" alt="...">
		    </div>
		    <div class="Main-card-body2">
			      <h5 class="card-title card-font" >범죄도시3</h5>
			      <p style="margin: 0;"><span class="text-muted">2023 ・ 한국</span></p>
			      <p><span class="text-muted">평균★<span id="">2.0</span></span></p>
			</div>
		  </div>
		  </a>
		  
		  <a href = "" class="Main-a">
		  <div class="Main-card2">
		    <div class="Main-card-header2">
		    	<img src="<%= ctxPath%>/resources/images/동원.png" class="card-img-top card-size" alt="...">
		    </div>
		    <div class="Main-card-body2">
			      <h5 class="card-title card-font" >범죄도시3</h5>
			      <p style="margin: 0;"><span class="text-muted">2023 ・ 한국</span></p>
			      <p><span class="text-muted">평균★<span id="">2.0</span></span></p>
			</div>
		  </div>
		  </a>
		  
		   <a href = "" title="범죄도시" class="Main-a">
			  <div class="Main-card2">
			  	<div class="Main-card-header2">
			    	<img src="<%= ctxPath%>/resources/images/범죄도시.jpg" class="card-img-top" alt="...">
			    </div>
			    <div class="Main-card-body2">
			      <h5 class="card-title card-font" >범죄도시3</h5>
			      <p style="margin: 0;"><span class="text-muted">2023 ・ 한국</span></p>
			      <p><span class="text-muted">평균★<span id="">4.0</span></span></p>
			    </div>
			  </div>
		  </a>
		  
		  
		   <a href = "" title="범죄도시" class="Main-a">
			  <div class="Main-card2">
			  	<div class="Main-card-header2">
			    	<img src="<%= ctxPath%>/resources/images/범죄도시.jpg" class="card-img-top" alt="...">
			    </div>
			    <div class="Main-card-body2">
			      <h5 class="card-title card-font" >범죄도시3</h5>
			      <p style="margin: 0;"><span class="text-muted">2023 ・ 한국</span></p>
			      <p><span class="text-muted">평균★<span id="">4.0</span></span></p>
			    </div>
			  </div>
		  </a> 
		  
		</div>
	</div>	
	
	
	<h5 class="h5 main-h5 main-h5-3">장르별</h5>
   	 <div class="container my-3">

		<div class="card-deck main-carousel-card2 mb-5">
		  
		  <a href = "" title="범죄도시" class="Main-a">
			  <div class="Main-card2">
			  	<div class="Main-card-header2">
			    	<img src="<%= ctxPath%>/resources/images/범죄도시.jpg" class="card-img-top" alt="...">
			    </div>
			    <div class="Main-card-body2">
			      <h5 class="card-title card-font" >범죄도시3</h5>
			      <p style="margin: 0;"><span class="text-muted">2023 ・ 한국</span></p>
			      <p><span class="text-muted">평균★<span id="">4.0</span></span></p>
			    </div>
			  </div>
		  </a>
		  
		  <a href = "" title="인어공주" class="Main-a">
		  <div class="Main-card2">
		    <div class="Main-card-header2">
		    	<img src="<%= ctxPath%>/resources/images/인어공주.jpg" class="card-img-top" alt="...">
		    </div>
		    <div class="Main-card-body2">
			      <h5 class="card-title card-font" >인어공주</h5>
			      <p style="margin: 0;"><span class="text-muted">2023 ・ 미국</span></p>
			      <p><span class="text-muted">평균★<span id="">2.0</span></span></p>
			</div>
		  </div>
		  </a>
		  
		  <a href = "" title="분노의질주: 라이드 오어 다이" class="Main-a">
		  <div class="Main-card2">
		    <div class="Main-card-header2">
		    	<img src="<%= ctxPath%>/resources/images/분노의질주.jpg" class="card-img-top  card-size" alt="...">
		    </div>
		    <div class="Main-card-body2">
			      <h5 class="card-title card-font" >분노의 질주: 라이드 오어 다이</h5>
			      <p style="margin: 0;"><span class="text-muted">2023 ・ 미국</span></p>
			      <p><span class="text-muted">평균★<span id="">3.2</span></span></p>
			</div>
		  </div>
		  </a>
		  
		  <a href = "" title="가디언즈오브갤럭시: volume 3" class="Main-a">
		  <div class="Main-card2">
		    <div class="Main-card-header2">
		    	<img src="<%= ctxPath%>/resources/images/가디언즈오브갤럭시.jpg" class="card-img-top card-size" alt="...">
		    </div>
		    <div class="Main-card-body2">
			      <h5 class="card-title card-font" >가디언즈 오브 갤럭시: Volume 3</h5>
			      <p style="margin: 0;"><span class="text-muted">2023 ・ 미국</span></p>
			      <p><span class="text-muted">평균★<span id="">4.1</span></span></p>
			</div>
		  </div>
		  </a>
		  
		  <a href = "" title="남은 인생 10년" class="Main-a">
		  <div class="Main-card2">
		    <div class="Main-card-header2">
		    	<img src="<%= ctxPath%>/resources/images/남은인생10년.jpg" class="card-img-top card-size" alt="...">
		    </div>
		    <div class="Main-card-body2">
			      <h5 class="card-title card-font" >남은 인생 10년</h5>
			      <p style="margin: 0;"><span class="text-muted">2022 ・ 일본</span></p>
			      <p><span class="text-muted">평균★<span id="">3.3</span></span></p>
			</div>
		  </div>
		  </a>
		  
		  <a href = "" class="Main-a">
		  <div class="Main-card2">
		    <div class="Main-card-header2">
		    	<img src="<%= ctxPath%>/resources/images/동원.png" class="card-img-top card-size" alt="...">
		    </div>
		    <div class="Main-card-body2">
			      <h5 class="card-title card-font" >범죄도시3</h5>
			      <p style="margin: 0;"><span class="text-muted">2023 ・ 한국</span></p>
			      <p><span class="text-muted">평균★<span id="">2.0</span></span></p>
			</div>
		  </div>
		  </a>
		  
		  <a href = "" class="Main-a">
		  <div class="Main-card2">
		    <div class="Main-card-header2">
		    	<img src="<%= ctxPath%>/resources/images/동원.png" class="card-img-top card-size" alt="...">
		    </div>
		    <div class="Main-card-body2">
			      <h5 class="card-title card-font" >범죄도시3</h5>
			      <p style="margin: 0;"><span class="text-muted">2023 ・ 한국</span></p>
			      <p><span class="text-muted">평균★<span id="">2.0</span></span></p>
			</div>
		  </div>
		  </a>
		  
		  <a href = "" class="Main-a">
		  <div class="Main-card2">
		    <div class="Main-card-header2">
		    	<img src="<%= ctxPath%>/resources/images/동원.png" class="card-img-top card-size" alt="...">
		    </div>
		    <div class="Main-card-body2">
			      <h5 class="card-title card-font" >범죄도시3</h5>
			      <p style="margin: 0;"><span class="text-muted">2023 ・ 한국</span></p>
			      <p><span class="text-muted">평균★<span id="">2.0</span></span></p>
			</div>
		  </div>
		  </a>
		  
		  <a href = "" class="Main-a">
		  <div class="Main-card2">
		    <div class="Main-card-header2">
		    	<img src="<%= ctxPath%>/resources/images/동원.png" class="card-img-top card-size" alt="...">
		    </div>
		    <div class="Main-card-body">
			      <h5 class="card-title card-font" >범죄도시3</h5>
			      <p style="margin: 0;"><span class="text-muted">2023 ・ 한국</span></p>
			      <p><span class="text-muted">평균★<span id="">2.0</span></span></p>
			</div>
		  </div>
		  </a>
		  
		  <a href = "" class="Main-a2">
		  <div class="Main-card2">
		    <div class="Main-card-header2">
		    	<img src="<%= ctxPath%>/resources/images/동원.png" class="card-img-top card-size" alt="...">
		    </div>
		    <div class="Main-card-body2">
			      <h5 class="card-title card-font" >범죄도시3</h5>
			      <p style="margin: 0;"><span class="text-muted">2023 ・ 한국</span></p>
			      <p><span class="text-muted">평균★<span id="">2.0</span></span></p>
			</div>
		  </div>
		  </a>
		  
		   <a href = "" title="범죄도시" class="Main-a">
			  <div class="Main-card2">
			  	<div class="Main-card-header2">
			    	<img src="<%= ctxPath%>/resources/images/범죄도시.jpg" class="card-img-top" alt="...">
			    </div>
			    <div class="Main-card-body2">
			      <h5 class="card-title card-font" >범죄도시3</h5>
			      <p style="margin: 0;"><span class="text-muted">2023 ・ 한국</span></p>
			      <p><span class="text-muted">평균★<span id="">4.0</span></span></p>
			    </div>
			  </div>
		  </a>
		  
		  
		   <a href = "" title="범죄도시" class="Main-a">
			  <div class="Main-card2">
			  	<div class="Main-card-header2">
			    	<img src="<%= ctxPath%>/resources/images/범죄도시.jpg" class="card-img-top" alt="...">
			    </div>
			    <div class="Main-card-body2">
			      <h5 class="card-title card-font" >범죄도시3</h5>
			      <p style="margin: 0;"><span class="text-muted">2023 ・ 한국</span></p>
			      <p><span class="text-muted">평균★<span id="">4.0</span></span></p>
			    </div>
			  </div>
		  </a> 
		  
		</div>
	</div>	
		    
	
	<h5 class="h5 main-h5 main-h5-3">왓챠피디아 컬렉션</h5>
   	 <div class="container my-3">

		<div class="card-deck main-carousel-card mb-5">
		  
		  <a href = "" title="선댄스영화제 미국 극영화 심사위원대상 수상작" class="Main-a">
			  <div class="Main-card">
				  <div class="Main-card-header">
				  	<div class="Main-card-header-fin">
				    	<img src="<%= ctxPath%>/resources/images/범죄도시.jpg" class="card-img-top card-img-top-fin" alt="...">
				    	<img src="<%= ctxPath%>/resources/images/인어공주.jpg" class="card-img-top card-img-top-fin" alt="...">
				    </div>	
				    <div class="Main-card-header-fin">	
				    	<img src="<%= ctxPath%>/resources/images/분노의질주.jpg" class="card-img-top card-img-top-fin" alt="...">
				    	<img src="<%= ctxPath%>/resources/images/가디언즈오브갤럭시.jpg" class="card-img-top card-img-top-fin" alt="...">
				    </div>
			    </div>			 
			    <div class="Main-card-body3">
			      <h5 class="card-title card-font" >선댄스영화제 미국 극영화 심사위원대상 수상작</h5>
			    </div>
			  </div>
		  </a>
		  
		  <a href = "" title="선댄스영화제 미국 다큐멘터리 심사위원대상 수상작" class="Main-a">
			  <div class="Main-card">
				  <div class="Main-card-header">
				  	<div class="Main-card-header-fin">
				    	<img src="<%= ctxPath%>/resources/images/범죄도시.jpg" class="card-img-top card-img-top-fin" alt="...">
				    	<img src="<%= ctxPath%>/resources/images/인어공주.jpg" class="card-img-top card-img-top-fin" alt="...">
				    </div>	
				    <div class="Main-card-header-fin">	
				    	<img src="<%= ctxPath%>/resources/images/분노의질주.jpg" class="card-img-top card-img-top-fin" alt="...">
				    	<img src="<%= ctxPath%>/resources/images/가디언즈오브갤럭시.jpg" class="card-img-top card-img-top-fin" alt="...">
				    </div>
			    </div>			 
			    <div class="Main-card-body3">
			      <h5 class="card-title card-font" >선댄스영화제 미국 다큐멘터리 심사위원대상 수상작</h5>
			    </div>
			  </div>
		  </a>
		  
		  <a href = "" title="선댄스영화제 월드시네마 극영화 심사위원대상 수상작" class="Main-a">
			  <div class="Main-card">
				  <div class="Main-card-header">
				  	<div class="Main-card-header-fin">
				    	<img src="<%= ctxPath%>/resources/images/범죄도시.jpg" class="card-img-top card-img-top-fin" alt="...">
				    	<img src="<%= ctxPath%>/resources/images/인어공주.jpg" class="card-img-top card-img-top-fin" alt="...">
				    </div>	
				    <div class="Main-card-header-fin">	
				    	<img src="<%= ctxPath%>/resources/images/분노의질주.jpg" class="card-img-top card-img-top-fin" alt="...">
				    	<img src="<%= ctxPath%>/resources/images/가디언즈오브갤럭시.jpg" class="card-img-top card-img-top-fin" alt="...">
				    </div>
			    </div>			 
			    <div class="Main-card-body3">
			      <h5 class="card-title card-font" >선댄스영화제 월드시네마 극영화 심사위원대상 수상작</h5>
			    </div>
			  </div>
		  </a>
		  
		  <a href = "" title="선댄스영화제 월드시네마 다큐멘터리 심사위원대상 수상작" class="Main-a">
			  <div class="Main-card">
				  <div class="Main-card-header">
				  	<div class="Main-card-header-fin">
				    	<img src="<%= ctxPath%>/resources/images/범죄도시.jpg" class="card-img-top card-img-top-fin" alt="...">
				    	<img src="<%= ctxPath%>/resources/images/인어공주.jpg" class="card-img-top card-img-top-fin" alt="...">
				    </div>	
				    <div class="Main-card-header-fin">	
				    	<img src="<%= ctxPath%>/resources/images/분노의질주.jpg" class="card-img-top card-img-top-fin" alt="...">
				    	<img src="<%= ctxPath%>/resources/images/가디언즈오브갤럭시.jpg" class="card-img-top card-img-top-fin" alt="...">
				    </div>
			    </div>			 
			    <div class="Main-card-body3">
			      <h5 class="card-title card-font" >선댄스영화제 월드시네마 다큐멘터리 심사위원대상 수상작</h5>
			    </div>
			  </div>
		  </a>
		  
		  <a href = "" title="로카르노영화제 황금표범상 수상작" class="Main-a">
			  <div class="Main-card">
				  <div class="Main-card-header">
				  	<div class="Main-card-header-fin">
				    	<img src="<%= ctxPath%>/resources/images/범죄도시.jpg" class="card-img-top card-img-top-fin" alt="...">
				    	<img src="<%= ctxPath%>/resources/images/인어공주.jpg" class="card-img-top card-img-top-fin" alt="...">
				    </div>	
				    <div class="Main-card-header-fin">	
				    	<img src="<%= ctxPath%>/resources/images/분노의질주.jpg" class="card-img-top card-img-top-fin" alt="...">
				    	<img src="<%= ctxPath%>/resources/images/가디언즈오브갤럭시.jpg" class="card-img-top card-img-top-fin" alt="...">
				    </div>
			    </div>			 
			    <div class="Main-card-body3">
			      <h5 class="card-title card-font" >로카르노영화제 황금표범상 수상작</h5>
			    </div>
			  </div>
		  </a>
		  
		  <a href = "" title="로카르노영화제 황금표범상 수상작" class="Main-a">
			  <div class="Main-card">
				  <div class="Main-card-header">
				  	<div class="Main-card-header-fin">
				    	<img src="<%= ctxPath%>/resources/images/범죄도시.jpg" class="card-img-top card-img-top-fin" alt="...">
				    	<img src="<%= ctxPath%>/resources/images/인어공주.jpg" class="card-img-top card-img-top-fin" alt="...">
				    </div>	
				    <div class="Main-card-header-fin">	
				    	<img src="<%= ctxPath%>/resources/images/분노의질주.jpg" class="card-img-top card-img-top-fin" alt="...">
				    	<img src="<%= ctxPath%>/resources/images/가디언즈오브갤럭시.jpg" class="card-img-top card-img-top-fin" alt="...">
				    </div>
			    </div>			 
			    <div class="Main-card-body3">
			      <h5 class="card-title card-font" >로카르노영화제 황금표범상 수상작</h5>
			    </div>
			  </div>
		  </a>
		  
		  <a href = "" title="로카르노영화제 황금표범상 수상작" class="Main-a">
			  <div class="Main-card">
				  <div class="Main-card-header">
				  	<div class="Main-card-header-fin">
				    	<img src="<%= ctxPath%>/resources/images/범죄도시.jpg" class="card-img-top card-img-top-fin" alt="...">
				    	<img src="<%= ctxPath%>/resources/images/인어공주.jpg" class="card-img-top card-img-top-fin" alt="...">
				    </div>	
				    <div class="Main-card-header-fin">	
				    	<img src="<%= ctxPath%>/resources/images/분노의질주.jpg" class="card-img-top card-img-top-fin" alt="...">
				    	<img src="<%= ctxPath%>/resources/images/가디언즈오브갤럭시.jpg" class="card-img-top card-img-top-fin" alt="...">
				    </div>
			    </div>			 
			    <div class="Main-card-body3">
			      <h5 class="card-title card-font" >로카르노영화제 황금표범상 수상작</h5>
			    </div>
			  </div>
		  </a>
		  
		  <a href = "" title="로카르노영화제 황금표범상 수상작" class="Main-a">
			  <div class="Main-card">
				  <div class="Main-card-header">
				  	<div class="Main-card-header-fin">
				    	<img src="<%= ctxPath%>/resources/images/범죄도시.jpg" class="card-img-top card-img-top-fin" alt="...">
				    	<img src="<%= ctxPath%>/resources/images/인어공주.jpg" class="card-img-top card-img-top-fin" alt="...">
				    </div>	
				    <div class="Main-card-header-fin">	
				    	<img src="<%= ctxPath%>/resources/images/분노의질주.jpg" class="card-img-top card-img-top-fin" alt="...">
				    	<img src="<%= ctxPath%>/resources/images/가디언즈오브갤럭시.jpg" class="card-img-top card-img-top-fin" alt="...">
				    </div>
			    </div>			 
			    <div class="Main-card-body3">
			      <h5 class="card-title card-font" >로카르노영화제 황금표범상 수상작</h5>
			    </div>
			  </div>
		  </a>
		  
		  <a href = "" title="로카르노영화제 황금표범상 수상작" class="Main-a">
			  <div class="Main-card">
				  <div class="Main-card-header">
				  	<div class="Main-card-header-fin">
				    	<img src="<%= ctxPath%>/resources/images/범죄도시.jpg" class="card-img-top card-img-top-fin" alt="...">
				    	<img src="<%= ctxPath%>/resources/images/인어공주.jpg" class="card-img-top card-img-top-fin" alt="...">
				    </div>	
				    <div class="Main-card-header-fin">	
				    	<img src="<%= ctxPath%>/resources/images/분노의질주.jpg" class="card-img-top card-img-top-fin" alt="...">
				    	<img src="<%= ctxPath%>/resources/images/가디언즈오브갤럭시.jpg" class="card-img-top card-img-top-fin" alt="...">
				    </div>
			    </div>			 
			    <div class="Main-card-body3">
			      <h5 class="card-title card-font" >로카르노영화제 황금표범상 수상작</h5>
			    </div>
			  </div>
		  </a>
		  
		  <a href = "" title="로카르노영화제 황금표범상 수상작" class="Main-a">
			  <div class="Main-card">
				  <div class="Main-card-header">
				  	<div class="Main-card-header-fin">
				    	<img src="<%= ctxPath%>/resources/images/범죄도시.jpg" class="card-img-top card-img-top-fin" alt="...">
				    	<img src="<%= ctxPath%>/resources/images/인어공주.jpg" class="card-img-top card-img-top-fin" alt="...">
				    </div>	
				    <div class="Main-card-header-fin">	
				    	<img src="<%= ctxPath%>/resources/images/분노의질주.jpg" class="card-img-top card-img-top-fin" alt="...">
				    	<img src="<%= ctxPath%>/resources/images/가디언즈오브갤럭시.jpg" class="card-img-top card-img-top-fin" alt="...">
				    </div>
			    </div>			 
			    <div class="Main-card-body3">
			      <h5 class="card-title card-font" >로카르노영화제 황금표범상 수상작</h5>
			    </div>
			  </div>
		  </a>
		  
		  <a href = "" title="로카르노영화제 황금표범상 수상작" class="Main-a">
			  <div class="Main-card">
				  <div class="Main-card-header">
				  	<div class="Main-card-header-fin">
				    	<img src="<%= ctxPath%>/resources/images/범죄도시.jpg" class="card-img-top card-img-top-fin" alt="...">
				    	<img src="<%= ctxPath%>/resources/images/인어공주.jpg" class="card-img-top card-img-top-fin" alt="...">
				    </div>	
				    <div class="Main-card-header-fin">	
				    	<img src="<%= ctxPath%>/resources/images/분노의질주.jpg" class="card-img-top card-img-top-fin" alt="...">
				    	<img src="<%= ctxPath%>/resources/images/가디언즈오브갤럭시.jpg" class="card-img-top card-img-top-fin" alt="...">
				    </div>
			    </div>			 
			    <div class="Main-card-body3">
			      <h5 class="card-title card-font" >로카르노영화제 황금표범상 수상작</h5>
			    </div>
			  </div>
		  </a>
		  
		  <a href = "" title="로카르노영화제 황금표범상 수상작" class="Main-a">
			  <div class="Main-card">
				  <div class="Main-card-header">
				  	<div class="Main-card-header-fin">
				    	<img src="<%= ctxPath%>/resources/images/범죄도시.jpg" class="card-img-top card-img-top-fin" alt="...">
				    	<img src="<%= ctxPath%>/resources/images/인어공주.jpg" class="card-img-top card-img-top-fin" alt="...">
				    </div>	
				    <div class="Main-card-header-fin">	
				    	<img src="<%= ctxPath%>/resources/images/분노의질주.jpg" class="card-img-top card-img-top-fin" alt="...">
				    	<img src="<%= ctxPath%>/resources/images/가디언즈오브갤럭시.jpg" class="card-img-top card-img-top-fin" alt="...">
				    </div>
			    </div>			 
			    <div class="Main-card-body3">
			      <h5 class="card-title card-font" >로카르노영화제 황금표범상 수상작</h5>
			    </div>
			  </div>
		  </a>
		  
		  <a href = "" title="로카르노영화제 황금표범상 수상작" class="Main-a">
			  <div class="Main-card">
				  <div class="Main-card-header">
				  	<div class="Main-card-header-fin">
				    	<img src="<%= ctxPath%>/resources/images/범죄도시.jpg" class="card-img-top card-img-top-fin" alt="...">
				    	<img src="<%= ctxPath%>/resources/images/인어공주.jpg" class="card-img-top card-img-top-fin" alt="...">
				    </div>	
				    <div class="Main-card-header-fin">	
				    	<img src="<%= ctxPath%>/resources/images/분노의질주.jpg" class="card-img-top card-img-top-fin" alt="...">
				    	<img src="<%= ctxPath%>/resources/images/가디언즈오브갤럭시.jpg" class="card-img-top card-img-top-fin" alt="...">
				    </div>
			    </div>			 
			    <div class="Main-card-body3">
			      <h5 class="card-title card-font" >로카르노영화제 황금표범상 수상작</h5>
			    </div>
			  </div>
		  </a>
		  
		</div>
	</div>	
	
		    
</div>


</body>
</html>
