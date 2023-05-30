<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    String ctxPath = request.getContextPath();
%>     
    
<!DOCTYPE html>
<html>

<head>

<style type="text/css">

	body {
		border: solid 0px gray;
		word-break: break-all; /* 공백없이 영어로만 되어질 경우 해당구역을 뚫고 빠져나감으로 이것을 막기 위해서 사용한다 */
		padding: 0;            /* 상 우 하 좌 모두 안쪽여백을 0px을 준 것이다. 즉, 바깥여백을 없는 것으로 한 것이다.*/
	}	

	div#container{
		border: solid 0px purple;
		width: 70%;
		margin: 20px auto; /* 상 하는 20px 우 좌는 남은 20%에서 좌우로 균등하게 주겠다. 즉, 화면의 가운데로 위치하겠다는 말이다.*/
	}
	
	div#left{
		 float: left;
		 width: 15%;
		 height: 450px; 
		 background-color: black; 
	} 
	
	div#middle {
		 float: left;
		 background-repeat: no-repeat;
		 background-size:cover;  
		 background-position: 70% 20%;  
		 height: 450px;
  	     width: 70%; 
  	     background-blend-mode: multiply;
	} 
	
	
	div#right{
		 float: left;
		 width: 15%;
		 height: 450px; 
		 background-color: black;
		 
	}  

	div#poster{
	    float: left;
		border: solid 1px #b3b3b3;
		width: 23%;
		height: 400px;
		margin: 20px 0px 20px 0px; 
		border-radius: 10px 10px;
		
		
		background-repeat: no-repeat;
		background-size:cover;  
	}	
	  
	div#posterInfo{
	    float: left;
		border: solid 1px #b3b3b3;
		width: 75%;
		height: 400px; 
		margin: 20px 0px 20px 20px; 
		border-radius: 10px 10px;
	}	
	
	
	div#BasicInfo{
		border: solid 1.5px #b3b3b3;
		width: 100%;
		display: inline-block;
		height: 600px;
		
		border-radius: 10px 10px;
	}	
	
	div#cast{
		border: solid 1.5px #b3b3b3;
		width: 100%;
		display: inline-block;
		height: 470px;
		margin-top: 20px;
		border-radius: 10px 10px;	
	}	 
	
	div#Comment{
		border: solid 1.5px #b3b3b3;
		width: 100%;
		display: inline-block;
		height: 600px;
		margin-top: 20px;
		border-radius: 10px 10px;
	}
	
	div#Video{
		border: solid 1.5px #b3b3b3;
		width: 100%;
		display: inline-block;
		height: 600px;
		margin-top: 20px;
		border-radius: 10px 10px;
	}
	
	div#img_8{
		border: solid 1.5px #b3b3b3;
		width: 100%;
		display: inline-block;
		height: 800px;
		margin-top: 20px;
		border-radius: 10px 10px;
	}
	
	/*평가하기 시작*/
	.rate { display: inline-block;border: 0; margin-right: 15px;}
	.rate > input {display: none;}
	.rate > label {float: right;color: #ddd}
	.rate > label:before {display: inline-block;font-size: 2rem;padding: .3rem .2rem;margin: 0;cursor: pointer;font-family: FontAwesome;content: "\f005 ";}
	.rate .half:before {content: "\f089 "; position: absolute;padding-right: 0;}
	.rate input:checked ~ label, 
	.rate label:hover,.rate label:hover ~ label { color: #FDD346} 
	.rate input:checked + .rate label:hover,
	.rate input input:checked ~ label:hover,
	.rate input:checked ~ .rate label:hover ~ label,  
	.rate label:hover ~ input:checked ~ label { color: #FDD346} 
	/*평가하기 끝*/
	
	/* 출연,제작 시작 */ 
	@media (max-width: 768px) {
	    .carousel-inner .carousel-item > div {
	        display: none;
	    }
	    .carousel-inner .carousel-item > div:first-child {
	        display: block;
	    }
	}
	
	.carousel-inner .carousel-item.active,
	.carousel-inner .carousel-item-next,
	.carousel-inner .carousel-item-prev {
	    display: flex;
	}
	
	/* display 3 */
	@media (min-width: 768px) {
	    
	    .carousel-inner .carousel-item-right.active,
	    .carousel-inner .carousel-item-next {
	      transform: translateX(33.333%);
	    }
	    
	    .carousel-inner .carousel-item-left.active, 
	    .carousel-inner .carousel-item-prev {
	      transform: translateX(-33.333%);
	    }
	}
	
	.carousel-inner .carousel-item-right,
	.carousel-inner .carousel-item-left{ 
	  transform: translateX(0);
	}
	/* 출연,제작 끝 */
	
     /* 사진 시작 */	 
 	div#carousel3D { 
	  perspective: 1200px;  
	  background: white; 
	  padding-top: 4%;  
	  font-size:0; 
	  margin-bottom: 3rem; 
	  overflow: hidden; 
	}
	figure#spinner3D { 
	  transform-style: preserve-3d; 
	  height: 600px; 
	  transform-origin: 50% 50% -500px; 
	  transition: 1s; 
	} 
	figure#spinner3D img { 
	  width: 40%; max-width: 400px;  
	  position: absolute; left: 30%;
	  transform-origin: 50% 50% -500px;
	  outline:1px solid transparent; 
	}
	figure#spinner3D img:nth-child(1) { transform:rotateY(0deg); 
	}
	figure#spinner3D img:nth-child(2) { transform: rotateY(-45deg); }
	figure#spinner3D img:nth-child(3) { transform: rotateY(-90deg); }
	figure#spinner3D img:nth-child(4) { transform: rotateY(-135deg); }
	figure#spinner3D img:nth-child(5){ transform: rotateY(-180deg); }
	figure#spinner3D img:nth-child(6){ transform: rotateY(-225deg); }
	figure#spinner3D img:nth-child(7){ transform: rotateY(-270deg); }
	figure#spinner3D img:nth-child(8){ transform: rotateY(-315deg); }
	div#carousel3D ~ span { 
	  color: black; 
	  margin: 5%; 
	  display: inline-block; 
	  text-decoration: none; 
	  font-size: 3rem; 
	  transition: 0.6s color; 
	  position: relative; 
	  margin-top: -6rem;  
	  border-bottom: none; 
	  line-height: 0; 
	  bottom: 350px;
	  }
	div#carousel3D ~ span:hover { color: #888; cursor: pointer; } 
	/* 사진 끝 */	
	
	/*보고싶어요 시작*/
	input[type="checkbox"] { 
	   opacity: 0;
	}
    /*보고싶어요 끝*/
	
	/*코멘트 시작*/
	div#registerComment{font-family: 'Noto Sans KR', sans-serif;}
	.modal-body textarea:focus,
	.modal-body input:focus {outline: none;}
	.fa-face-meh:hover{color: #ff0558; cursor: pointer;}
	/*코멘트 끝*/
</style>

<script type="text/javascript">

	/* 출연, 제작 시작*/
	$(document).ready(function(){
		
		$('#recipeCarousel').carousel({ 
			  interval: 10000
		});
	
	$('.carousel .carousel-item').each(function(){
	    var minPerSlide = 7;
	    var next = $(this).next();
	    if (!next.length) {
	        next = $(this).siblings(':first');
	    }
	    next.children(':first-child').clone().appendTo($(this));
	    
	    for (var i=0;i<minPerSlide;i++) {
	        next=next.next();
	        if (!next.length) {
	        	next = $(this).siblings(':first');
	      	}
	        
	        next.children(':first-child').clone().appendTo($(this));
	   }
	});
	/* 출연, 제작 끝*/
	
	/*보고싶어요 시작*/	
	$(".seechange2").hide(); 
	
	$("input:checkbox[name='check_wantsee']").click(function(){
		 
		if($('input:checkbox[name="check_wantsee"]').is(":checked")) {
				$(".seechange1").hide(); 
				$(".seechange2").show(); 
				$(".seechange2").css({"color":"#f3578d"}); 
			 	$(".wantseei").css({"color":"#f3578d"}); 
			}
			else if(!$('input:checkbox[name="check_wantsee"]').is(":checked")) {
				$(".seechange1").show(); 
				$(".seechange2").hide(); 
				$(".wantseei").css({"color":""}); 
			}
			
			$("input:checkbox[name='check_wantsee']").toggle();
		
	  });
	/*보고싶어요 끝*/		

	/*코멘트 시작*/		
	$("input:checkbox[name='check_comment']").click(function(){
		
		if($('input:checkbox[name="check_comment"]').is(":checked")) {
			 
		 	$(".commenti").css({"color":"#f3578d"}); 
		}
		else if(!$('input:checkbox[name="check_comment"]').is(":checked")) {

			$(".commenti").css({"background-color":"","color":""}); 
		}
		
		$("input:checkbox[name='check_comment']").toggle();
		
	  });
	/*코멘트 끝*/
	
	/*보는중 시작*/		
	$("input:checkbox[name='check_seeing']").click(function(){
		  
		if($('input:checkbox[name="check_seeing"]').is(":checked")) {
			 
		 	$(".seeingi").css({"color":"#f3578d"}); 
		}
		else if(!$('input:checkbox[name="check_seeing"]').is(":checked")) {

			$(".seeingi").css({"background-color":"","color":""}); 
		}
		
		$("input:checkbox[name='check_seeing']").toggle();
		
	  });
	/*보는중 끝*/
	
	/* 영화 등 정보 불러오기 시작 */
	$.ajax({
		url:"<%= ctxPath%>/movieInfo.action",
		dataType:"json",
		success:function(json){
			
			//console.log(JSON.stringify(json));
			console.log(json);
		},
		error: function(request, status, error){
                 alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
           }
	});
	/* 영화 등 정보 불러오기 끝 */
	
	});
	
	/* 사진 시작*/
	var angle = 0;
	
	function galleryspin(sign) { 
	spinner3D = document.querySelector("#spinner3D");
	if (!sign) { angle = angle + 45; } else { angle = angle - 45; }
	spinner3D.setAttribute("style","-webkit-transform: rotateY("+ angle +"deg); -moz-transform: rotateY("+ angle +"deg); transform: rotateY("+ angle +"deg);");
	}
	/*사진  끝*/
	
	
	
</script>

<meta charset="UTF-8">
<title>제품상세</title>
</head>
<body>

	<div>
		<div id="left"></div>
		 
		<div id="middle" style="background: url('https://image.tmdb.org/t/p/w1280/5DKVH8KeqFwPacWFMyYqTaECxJP.jpg')"></div> 
		  
		<div id="right"></div>
	</div>
	
	<div id="container">
		 
		<div id="poster" style="background-image: url('https://image.tmdb.org/t/p/w780/jbremGnsRR4XZMDj97YHt20isRP.jpg');"></div>
	
		<div id="posterInfo"> 
			<div style="margin: 30px 0 0 30px;">
				<div style="margin: 0 0 20px 0; font-size: 40px; font-weight: bolder;">범죄도시3</div>
				
				<div style="font-weight: bold;">2023&nbsp;&nbsp;<span style="color: #eee;">|</span>&nbsp;&nbsp;범죄&nbsp;&nbsp;<span style="color: #eee;">|</span>&nbsp;&nbsp;한국</div>
	
				<hr style="margin-right: 40px;">	
	
				<div style="font-weight: bold;">예매:&nbsp;순위3위(12%)&nbsp;&nbsp;<span style="color: #eee;">|</span>&nbsp;&nbsp;개봉:&nbsp;15일전&nbsp;&nbsp;<span style="color: #eee;">|</span>&nbsp;&nbsp;누적:&nbsp;관객0명</div>
				
				<hr style="margin-right: 40px;"> 
				 
				<div style="margin: 50px 0 10px 77px; font-weight: bold;">평가하기</div> 
				<fieldset class="rate">
		          <input type="radio" id="rating10" name="rating" value="10"><label for="rating10" title="5점"></label>
		          <input type="radio" id="rating9" name="rating" value="9"><label class="half" for="rating9" title="4.5점"></label>
		          <input type="radio" id="rating8" name="rating" value="8"><label for="rating8" title="4점"></label>
		          <input type="radio" id="rating7" name="rating" value="7"><label class="half" for="rating7" title="3.5점"></label>
		          <input type="radio" id="rating6" name="rating" value="6"><label for="rating6" title="3점"></label>
		          <input type="radio" id="rating5" name="rating" value="5"><label class="half" for="rating5" title="2.5점"></label>
		          <input type="radio" id="rating4" name="rating" value="4"><label for="rating4" title="2점"></label>
		          <input type="radio" id="rating3" name="rating" value="3"><label class="half" for="rating3" title="1.5점"></label>
		          <input type="radio" id="rating2" name="rating" value="2"><label for="rating2" title="1점"></label>
		          <input type="radio" id="rating1" name="rating" value="1"><label class="half" for="rating1" title="0.5점"></label>
		        </fieldset>
				
				<div style="margin: 0 0 0 270px; position: relative; bottom: 60px;">  
					<div>
						<label for="check_wantsee" style="cursor: pointer;">
						   <i style="font-size: 23px;" class="seechange1 fas fa-plus wantseei"></i><i style="font-size: 23px; margin-right: 3.3px;" class="seechange2 fas fa-bookmark"></i><span class="wantseei" style="font-weight: bolder">&nbsp;&nbsp;보고싶어요</span>
						   <input type="checkbox" id="check_wantsee" name="check_wantsee"/>
						</label>
					</div>
					
					<%-- 코멘트 등록하기 --%>
			        <div style="position: relative; left: 125px; bottom: 33px;">
			          <label for="check_comment" style="cursor: pointer;">
			             <span class="commenti">
			               <button type="button" data-toggle="modal" data-target="#registerComment" style="font-weight: bold; border: none; background-color: transparent;">
			                 <i style="font-size: 23px;" class="fas fa-pen-nib commenti"></i>&nbsp;&nbsp;코멘트 등록
			               </button>
			             </span>
			          </label>
			        </div> 
					
					<div style="position: relative; left: 275px; bottom: 66px; width: 100px;"> 
					  <label for="check_seeing" style="cursor: pointer;">
					    <i style="font-size: 23px;" class="far fa-eye seeingi"></i><span class="seeingi" style="font-weight: bolder">&nbsp;&nbsp;보는중</span></label>
						<input type="checkbox" id="check_seeing" name="check_seeing"/>
					</div>
				</div>
				
			</div>
		</div>
		
		<div id="BasicInfo">
		
			<h4 style="margin: 30px 0 20px 30px; font-weight: bolder; ">기본 정보</h4>
		
			<ol style="margin: 0 0 0 15px; list-style: none;">   
		       <li ><span>원제 </span><span style="margin-left: 60px;">범죄도시3</span></li>
		       <hr style="margin-right: 40px;"> 
		       <li><span>제작 연도 </span><span style="margin-left: 27px;">2023</span></li>
		       <hr style="margin-right: 40px;"> 
		       <li><span>국가 </span><span style="margin-left: 64px;">한국</span></li>
		       <hr style="margin-right: 40px;"> 
		       <li><span>장르 </span><span style="margin-left: 64px;">범죄</span></li>
		       <hr style="margin-right: 40px;"> 
		       <li><span>상영시간 </span><span style="margin-left: 35px;">1시간 45분</span></li>
		       <hr style="margin-right: 40px;"> 
		       <li><span>연령 등급 </span><span style="margin-left: 31px;">15세 관람가</span></li>
		       <hr style="margin-right: 40px;">  
		       <li><div style="width: 10%; vertical-align: top; display: inline-block;">내용 </div>
			       <div style="width: 80%; display: inline-block;"> 
			                대체불가 괴물형사 마석도, 서울 광수대로 발탁!
					베트남 납치 살해범 검거 후 7년 뒤, ‘마석도’(마동석)는 새로운 팀원들과 함께 살인사건을 조사한다. 사건 조사 중, ‘마석도’는 신종 마약 사건이 연루되었음을 알게 되고 수사를 확대한다. 한편, 마약 사건의 배후인 '주성철'(이준혁)은 계속해서 판을 키워가고 약을 유통하던 일본 조직과 '리키'(아오키 무네타카)까지 한국에 들어오며 사건의 규모는 점점 더 커져가는데...
					나쁜 놈들 잡는 데 이유 없고 제한 없다
					커진 판도 시원하게 싹 쓸어버린다!
				  </div>
			  </li>
		    </ol>
		</div>
		
		<div id="cast">
		
			<h4 style="margin: 30px 0 0 30px; font-weight: bolder; ">출연/제작</h4>

			<div class="container text-center my-3">
			    <div class="row mx-auto my-auto">
			        <div id="recipeCarousel" class="carousel slide w-100" data-ride="carousel">
			            <div class="carousel-inner w-100" role="listbox">
			                <div class="carousel-item active">
			                    <div class="col-md-2">
			                        <div class="card">
									  <img src="https://image.tmdb.org/t/p/w780/jbremGnsRR4XZMDj97YHt20isRP.jpg" class="card-img-top" style="width: 100%" />
									  <div class="card-body">
									    <h5 class="card-title">감독</h5>
									    <p class="card-text">ㅇㅇ</p>
									    <a href="#" class="stretched-link"></a>
									  </div>
									</div>
			                    </div>
			                </div>
			                <div class="carousel-item">
			                    <div class="col-md-2">
			                        <div class="card">
									  <img src="https://image.tmdb.org/t/p/w780/jbremGnsRR4XZMDj97YHt20isRP.jpg" class="card-img-top" style="width: 100%" />
									  <div class="card-body">
									    <h5 class="card-title">주연</h5>
									    <p class="card-text">ㅇㅇ</p>
									    <a href="#" class="stretched-link"></a>
									  </div>
									</div>
			                    </div>
			                </div>
			                <div class="carousel-item">
			                    <div class="col-md-2">
			                        <div class="card">
									  <img src="https://image.tmdb.org/t/p/w780/jbremGnsRR4XZMDj97YHt20isRP.jpg" class="card-img-top" style="width: 100%" />
									  <div class="card-body">
									    <h5 class="card-title">주연</h5>
									    <p class="card-text">ㅇㅇ</p>
									    <a href="#" class="stretched-link"></a>
									  </div>
									</div>
			                    </div>
			                </div>
			            </div>
			            <a class="carousel-control-prev w-auto" href="#recipeCarousel" role="button" data-slide="prev">
			                <span class="carousel-control-prev-icon bg-dark border border-dark rounded-circle" aria-hidden="true"></span>
			                <span class="sr-only">Previous</span>
			            </a>
			            <a class="carousel-control-next w-auto" href="#recipeCarousel" role="button" data-slide="next">
			                <span class="carousel-control-next-icon bg-dark border border-dark rounded-circle" aria-hidden="true"></span>
			                <span class="sr-only">Next</span>
			            </a>
			        </div>
			    </div>
			</div>
		
		</div>
		
		<div id="Comment">
		
			<h4 style="margin: 30px 0 0 30px; font-weight: bolder; ">코멘트</h4>
			  	
				
		      <%-- 코멘트 등록 모달창 --%>
		      <div class="modal fade" id="registerComment">
		        <div class="modal-dialog modal-dialog-centered">
		          <div class="modal-content">
		            <div class="modal-body">
		              <h5 class="modal-title" style="font-weight: bold;">영화제목<button type="button" class="close" data-dismiss="modal">&times;</button></h5>
		               <div class="my-2">
		                 <textarea style="width: 100%; height: 450px; resize: none; border: none;" placeholder="이 작품에 대한 생각을 자유롭게 표현해주세요."></textarea>
		               </div>
		               <div style="display: inline-block; width: 100%;">
		                 <div style="display: inline-block; width: 83%;">
		                   <label for="checkSpoiler">
		                    <i class="fa-solid fa-face-meh fa-2xl" style="color: #cccccc;"></i>
		                    <input type="checkbox" id="checkSpoiler" style="display: none;" />
		                   </label>
		                  <span style="color: #666666;">스포일러가 포함된 코멘트를 가려보세요.</span>
		                 </div>
		                 <div style="display: inline-block; width: 16%; text-align: right;">
		                  <button type="button" class="btn" style="color: #ffffff; background-color: #ff0558;">등록</button>
		                 </div>
		               </div>
		            </div>
		          </div>
		        </div>
		      </div>
		
		</div>
		
		
		<div id="Video">
		
			<h4 style="margin: 30px 0 0 30px; font-weight: bolder; ">동영상</h4>
		
		</div>
		
		
		<div id="img_8">
		
			<h4 style="margin: 30px 0 0 30px; font-weight: bolder; ">사진</h4>
			
			<div id="carousel3D">
				<figure id="spinner3D">
				    <img src="https://image.tmdb.org/t/p/w780/jbremGnsRR4XZMDj97YHt20isRP.jpg">
				    <img src="https://image.tmdb.org/t/p/w780/jbremGnsRR4XZMDj97YHt20isRP.jpg">
				    <img src="https://image.tmdb.org/t/p/w780/jbremGnsRR4XZMDj97YHt20isRP.jpg">
				    <img src="https://image.tmdb.org/t/p/w780/jbremGnsRR4XZMDj97YHt20isRP.jpg">
				    <img src="https://image.tmdb.org/t/p/w780/jbremGnsRR4XZMDj97YHt20isRP.jpg">
				    <img src="https://image.tmdb.org/t/p/w780/jbremGnsRR4XZMDj97YHt20isRP.jpg">
				    <img src="https://image.tmdb.org/t/p/w780/jbremGnsRR4XZMDj97YHt20isRP.jpg">
				    <img src="https://image.tmdb.org/t/p/w780/jbremGnsRR4XZMDj97YHt20isRP.jpg">
				</figure>
			</div>
			<span style="float:left" class="ss-icon" onclick="galleryspin('-')">&lt;</span>
			<span style="float:right" class="ss-icon" onclick="galleryspin('')">&gt;</span>
			
		</div>
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	</div>
	
	
	
	
	
	
	
	
</body>
</html>