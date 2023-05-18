<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
   String ctxPath = request.getContextPath();
%>   
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 


<style type="text/css">

    span.move {cursor: pointer; color: navy;}
    .moveColor {color: #660029; font-weight: bold; background-color: #ffffe6;}
    
    td.comment {text-align: center;}
    
    a {text-decoration: none !important;}

</style>   
    
<script type="text/javascript">
  $(document).ready(function(){
     
	  // 페이징 처리 안한 댓글 읽어오기
	  //goReadComment();  // 문서가 로딩 되자 마자 댓글을 보여주기 위해 쓴다.

	  goViewComment(1); // 페이징 처리 한 댓글 읽어오기
         
  });// end of $(document).ready(function(){})------------------------
  
  
  // Function Declaration
  
  // == 댓글쓰기 == 
  function goAddWrite() {
	  
	  // 유효성 검사 할 것임 
	  const commentContent = $("input#commentContent").val().trim();
	  // 내용 가져옴 
	  
	  // 가져온 글이 아무것도 없다면 
	  if(commentContent == "") {
		  alert("댓글 내용을 입력하세요!!");
		  return ; // 종료 
	  }
	  
	  if($("input#attach").val() == "") {
		  // 첨부 파일이 없는 댓글쓰기인 경우 !!!!
		  goAddWrite_noAttach();
  
	  }
	  else {
		  // 첨부 파일이 있는 댓글쓰기인 경우 !!!!
		  goAddWrite_withAttach();
	  }

  } // end of  function goAddWrite()
  
  // 파일첨부가 없는 댓글쓰기 
  function goAddWrite_noAttach() {
	  
	  <%--
		  http://localhost:9090/board/list.action?currentShowPageNo=5&searchType=name&searchWord=이순신   에서 
		  ? 다음에 나오는 currentShowPageNo=5&searchType=name&searchWord=이순신 을 "query string" 이라고 부른다.
	      
	      // 보내야할 데이터를 선정하는 또 다른 방법
	     // jQuery에서 사용하는 것으로써,
	     // form태그의 선택자.serialize(); 을 해주면 form 태그내의 모든 값들을 name값을 키값으로 만들어서 보내준다. 
	     const queryString = $("form[name='addWriteFrm']").serialize();
	  --%> 
	  
	  const queryString = $("form[name='addWriteFrm']").serialize();  <%-- form 태그에 있는 name 값들을 자동적으로 넣어준다. --%>
	  
	  $.ajax({
		 url:"<%= request.getContextPath()%>/addComment.action",
	/*	 
		 data:{"fk_userid":$("input#fk_userid").val()        userid 넘겨줌 
			  ,"name":$("input#name").val()                 성명 넘겨줌 
			  ,"content":$("input#commentContent").val()     댓글 내용 넘겨줌 
			  ,"parentSeq":$("input#parentSeq").val()},     부모 글 번호 까지 넘겨줌 
		또는 
	*/
		 data:queryString,   /* form 태그에 있는 name 값들을 자동적으로 넣어준다. */
			  
		 type:"post",
		 dataType:"json",
		 success:function(json){
			 console.log("확인용 ~~ : " + JSON.stringify(json));
			 // 확인용 ~~ : {"name":"민동현","n":0}
			 // 또는 
			 // 확인용 ~~ : {"name":"민동현","n":1}
			 
			 if(json.n == 0) {
				alert(json.name + "님의 포인트는 300점을 초과할 수 없으므로 댓글쓰기가 불가합니다."); 
			 }
			 else {
				 //goReadComment();// 페이징 처리 안한 댓글 읽어오기   
				 goViewComment(1);// 페이징 처리 한 댓글 읽어오기 (내림차순)
			 }
			 
			 $("input#commentContent").val("");  // 댓글 썻던 것을 초기화 하기 
			 
			 
		 },
		 error: function(request, status, error){
            alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
        }
	  });
	  
	  
  }// end of function goAddWrite_noAttach()
  
  
  // ==== #169. 파일첨부가 있는 댓글쓰기 ==== // 
  
  
  
  // === 페이징 처리 안한 댓글 읽어오기  === //
  function goReadComment() {
	  $.ajax({
		 url:"<%= request.getContextPath()%>/readComment.action",
		 data:{"parentSeq":"${requestScope.boardvo.seq}"},
		 dataType:"json",
		 success:function(json){
			 //console.log("확인용이다 : " + JSON.stringify(json));
			 // 확인용이다 : [{"name":"민동현","regdate":"2023-05-15 15:24:50","content":"넘나 신기하네요 소통을 할 수 있어 좋아요"},{"name":"민동현","regdate":"2023-05-15 15:09:17","content":"저도 신기해여"}]
			 // 또는 
			 // 확인용이다 : []
			 
			 let html = "";
			 // json 에 하나라도 들어있으면 실행  (item 은 배열의 객체임)
			 if(json.length > 0) {
				 // 반복문 
				 $.each(json, function(index, item) {
					 html += "<tr>" + 
					            "<td class='comment'>"+(index+1)+"</td>" +
					            "<td>"+item.content+"</td>"  +
					            "<td></td>"  +
					            "<td></td>"  +
					            "<td class='comment'>"+item.name+"</td>"  +
					            "<td class='comment'>"+item.regdate+"</td>"  +
					         "</tr>";
				 });
			 }
			 else{
				 html += "<tr>" + 
				            "<td colspan='6' class='comment'>댓글이 없습니다</td>"  +				    
				         "</tr>"
			 }
			 
			 $("tbody#commentDisplay").html(html);   //이 속에 html을 추가하자 
			 
		 },
		 error: function(request, status, error){
	         alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
	     }
	  });
  }// end of function goReadComment() 
  
  
  // === #127. Ajax로 불러온 댓글내용을  페이징 처리 하기  === //
  function goViewComment(currentShowPageNo) {
	  $.ajax({
		 url:"<%= request.getContextPath()%>/commentList.action",
		 data:{"parentSeq":"${requestScope.boardvo.seq}",
			   "currentShowPageNo":currentShowPageNo},
		 dataType:"json",
		 success:function(json){
			//console.log("!!! 확인용 : " + JSON.stringify(json));
			// !!! 확인용 : [{"name":"홍길동 ","regDate":"2023-05-18 09:40:06","content":"엄정화 글 잘 봤습니다"},{"name":"민동현","regDate":"2023-05-18 09:38:33","content":"댓글 13"},{"name":"민동현","regDate":"2023-05-18 09:38:28","content":"댓글 12"},{"name":"민동현","regDate":"2023-05-18 09:38:25","content":"댓글 11"},{"name":"민동현","regDate":"2023-05-18 09:38:20","content":"댓글 10"}]
			
			let html = "";
			 // json 에 하나라도 들어있으면 실행  (item 은 배열의 객체임)
			 if(json.length > 0) {
				 // 반복문 
				 $.each(json, function(index, item) {
					 html += "<tr>" + 
					            "<td class='comment'>"+(index+1)+"</td>" +
					            "<td>"+item.content+"</td>"  +
					            "<td></td>"  +
					            "<td></td>"  +
					            "<td class='comment'>"+item.name+"</td>"  +
					            "<td class='comment'>"+item.regdate+"</td>"  +
					         "</tr>";
				 });
			 }
			 else{
				 html += "<tr>" + 
				            "<td colspan='6' class='comment'>댓글이 없습니다</td>"  +				    
				         "</tr>"
			 }
			 
			 $("tbody#commentDisplay").html(html);   //이 속에 html을 추가하자 
			 
			 // === 페이지바 함수 호출 === // 
			 makeCommentPageBar(currentShowPageNo);
			
			
		 },
		 error: function(request, status, error){
	         alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
	     }
	  });
  }// end of function ViewComment()
  
  
  
  // ==== 댓글내용 페이지바 Ajax로 만들기 ==== //
  function makeCommentPageBar(currentShowPageNo) {
	  
	  <%-- === 원글에 대한 totalPage 수를 알아오려고 한다. === --%>
	  $.ajax ({
		 url:"<%= request.getContextPath()%>/getCommentTotalPage.action",
		 data:{"parentSeq":"${requestScope.boardvo.seq}",
			   "sizePerPage":"3"},
		 type:"get",
		 dataType:"json",
		 success:function(json){
			 console.log(JSON.stringify(json));
			 // JSON.stringify(json) 확인 : "{"totalPage":3}"
			 // 또는
			 // JSON.stringify(json) 확인 : "{"totalPage":0}"
			 
			 if(json.totalPage > 0) {
				 
				 // 댓글이 있는 경우 
				 const totalPage = json.totalPage;
				 
				 const blockSize = 2;
				 //const blockSize = 10;   // 페이지 바를 10개씩 보여주겠다.
				// blockSize 는 1개 블럭(토막)당 보여지는 페이지번호의 개수 이다.
	            /*
	                             1 2 3 4 5 6 7 8 9 10  [다음][마지막]           -- 1개블럭
	               [맨처음][이전]  11 12 13 14 15 16 17 18 19 20  [다음][마지막]   -- 1개블럭
	               [맨처음][이전]  21 22 23
	            */
				 
				 let loop = 1;
	             /*
	                loop는 1부터 증가하여 1개 블럭을 이루는 페이지번호의 개수[ 지금은 10개(== blockSize) ] 까지만 증가하는 용도이다.
	             */
	            
	             if(typeof currentShowPageNo == "string") { // currentShowPageNo가 stirng 타입이냐고 물어보는 조건문이다.
	            	 currentShowPageNo = Number(currentShowPageNo);   //number 타입으로 변경 
	             } 
	             
	             // *** !! 다음은 currentShowPageNo 를 얻어와서 pageNo 를 구하는 공식이다. !! *** //
	             
	             // *** !! 자바일때 공식이다. !! *** //
	             // int pageNo = ((currentShowPageNo - 1)/blockSize) * blockSize + 1;
 	      		 
	             
	             // *** !! 자바 스크립트 일때 공식  !! ***//
	             let pageNo = Math.floor( (currentShowPageNo - 1)/blockSize ) * blockSize + 1;
	              /*
	                currentShowPageNo 가 3페이지 이라면 pageNo 는 1 이 되어야 한다.
	                ((3 - 1)/10) * 10 + 1;
	                ( 2/10 ) * 10 + 1;
	                ( 0.2 ) * 10 + 1;
	                Math.floor( 0.2 ) * 10 + 1;  // 소수부가 있을시 Math.floor(0.2) 은 0.2 보다 작은 최대의 정수인 0을 나타낸다.
	                0 * 10 + 1 
	                1
	                
	                currentShowPageNo 가 11페이지 이라면 pageNo 는 11 이 되어야 한다.
	                ((11 - 1)/10) * 10 + 1;
	                ( 10/10 ) * 10 + 1;
	                ( 1 ) * 10 + 1;
	                Math.floor( 1 ) * 10 + 1;  // 소수부가 없을시 Math.floor(1) 은 그대로 1 이다.
	                1 * 10 + 1
	                11
	                
	                currentShowPageNo 가 20페이지 이라면 pageNo 는 11 이 되어야 한다.
	                ((20 - 1)/10) * 10 + 1;
	                ( 19/10 ) * 10 + 1;
	                ( 1.9 ) * 10 + 1;
	                Math.floor( 1.9 ) * 10 + 1;  // 소수부가 있을시 Math.floor(1.9) 은 1.9 보다 작은 최대의 정수인 1을 나타낸다.
	                1 * 10 + 1
	                11
	             
	                
	                1  2  3  4  5  6  7  8  9  10  -- 첫번째 블럭의 페이지번호 시작값(pageNo)은 1 이다.
	                11 12 13 14 15 16 17 18 19 20  -- 두번째 블럭의 페이지번호 시작값(pageNo)은 11 이다.
	                21 22 23 24 25 26 27 28 29 30  -- 세번째 블럭의 페이지번호 시작값(pageNo)은 21 이다.
	                
	                currentShowPageNo         pageNo
	               ----------------------------------
	                     1                      1 = Math.floor((1 - 1)/10) * 10 + 1
	                     2                      1 = Math.floor((2 - 1)/10) * 10 + 1
	                     3                      1 = Math.floor((3 - 1)/10) * 10 + 1
	                     4                      1
	                     5                      1
	                     6                      1
	                     7                      1 
	                     8                      1
	                     9                      1
	                     10                     1 = Math.floor((10 - 1)/10) * 10 + 1
	                    
	                     11                    11 = Math.floor((11 - 1)/10) * 10 + 1
	                     12                    11 = Math.floor((12 - 1)/10) * 10 + 1
	                     13                    11 = Math.floor((13 - 1)/10) * 10 + 1
	                     14                    11
	                     15                    11
	                     16                    11
	                     17                    11
	                     18                    11 
	                     19                    11 
	                     20                    11 = Math.floor((20 - 1)/10) * 10 + 1
	                     
	                     21                    21 = Math.floor((21 - 1)/10) * 10 + 1
	                     22                    21 = Math.floor((22 - 1)/10) * 10 + 1
	                     23                    21 = Math.floor((23 - 1)/10) * 10 + 1
	                     ..                    ..
	                     29                    21
	                     30                    21 = Math.floor((30 - 1)/10) * 10 + 1
	                     
	            */
	            
	             let pageBarHTML = "<ul style='list-style: none;'>";
	             
	             // === [맨처음][이전] 만들기 === //
	             if(pageNo != 1) {
	                pageBarHTML += "<li style='display:inline-block; width:70px; font-size:12pt;'><a href='javascript:goViewComment(\"1\")'>[맨처음]</a></li>";
	                pageBarHTML += "<li style='display:inline-block; width:50px; font-size:12pt;'><a href='javascript:goViewComment(\""+(pageNo-1)+"\")'>[이전]</a></li>";
	             }
	             
	             while( !(loop > blockSize || pageNo > totalPage) ) {
	                
	                if(pageNo == currentShowPageNo) {
	                   pageBarHTML += "<li style='display:inline-block; width:30px; font-size:12pt; border:solid 1px gray; color:red; padding:2px 4px;'>"+pageNo+"</li>";  
	                }
	                else {
	                   pageBarHTML += "<li style='display:inline-block; width:30px; font-size:12pt;'><a href='javascript:goViewComment(\""+pageNo+"\")'>"+pageNo+"</a></li>"; 
	                }
	                
	                loop++;
	                pageNo++;
	                
	             }// end of while-----------------------
	             
	             
	             // === [다음][마지막] 만들기 === //
	             if( pageNo <= totalPage ) {
	                pageBarHTML += "<li style='display:inline-block; width:50px; font-size:12pt;'><a href='javascript:goViewComment(\""+pageNo+"\")'>[다음]</a></li>";
	                pageBarHTML += "<li style='display:inline-block; width:70px; font-size:12pt;'><a href='javascript:goViewComment(\""+totalPage+"\")'>[마지막]</a></li>"; 
	             }
	              
	             pageBarHTML += "</ul>";
	              
	             $("div#pageBar").html(pageBarHTML);
	            
	            
			 } // end of if(json.totalPage > 0)
			 
		 },
		 error: function(request, status, error){
	         alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
	     }
	  });
	  
	  
  }// end of  function makeCommentPageBar(currentShowPageNo)
  
</script>

<div style="display: flex;">
<div style="margin: auto; padding-left: 3%;">

   <h2 style="margin-bottom: 30px;">글내용보기</h2>

    <c:if test="${not empty requestScope.boardvo}">
       <table style="width: 1024px" class="table table-bordered table-dark">
          <tr>
              <th style="width: 15%">글번호</th>
              <td>${requestScope.boardvo.seq}</td>
          </tr>
          <tr>
              <th>성명</th>
              <td>${requestScope.boardvo.name}</td>
          </tr>
          <tr>
              <th>제목</th>
              <td>${requestScope.boardvo.subject}</td>
          </tr>
          <tr>
              <th>내용</th>
              <td> 
                <p style="word-break: break-all;">${requestScope.boardvo.content}</p>
                <%-- 
                  style="word-break: break-all; 은 공백없는 긴영문일 경우 width 크기를 뚫고 나오는 것을 막는 것임. 
                       그런데 style="word-break: break-all; 나 style="word-wrap: break-word; 은
                       테이블태그의 <td>태그에는 안되고 <p> 나 <div> 태그안에서 적용되어지므로 <td>태그에서 적용하려면
                  <table>태그속에 style="word-wrap: break-word; table-layout: fixed;" 을 주면 된다.
             --%>
              </td>
          </tr>
          <tr>
              <th>조회수</th>
              <td>${requestScope.boardvo.readCount}</td>
          </tr>
          <tr>
              <th>날짜</th>
              <td>${requestScope.boardvo.regDate}</td>
          </tr>
          
          <%-- === #162. 첨부파일 이름 및 파일크기를 보여주고 첨부파일을 다운로드 되도록 만들기 === --%>
         <tr>
            <th>첨부파일</th>
            <td>
               
            </td>
         </tr>
         <tr>
            <th>파일크기(bytes)</th>
            <td></td>
         </tr>
          
       </table>
       <br/>
       
       <c:set var="v_gobackURL" value='${fn:replace(requestScope.gobackURL, "&", " ") }' />
       
       <%-- 글조회수 1증가를 위해서  view.action 대신에 view_2.action 으로 바꾼다. --%>
       <div style="margin-bottom: 1%;">이전글제목&nbsp;&nbsp;<span class="move" onclick="javascript:location.href='<%=ctxPath%>/view_2.action?seq=${requestScope.boardvo.previousseq}&searchType=${requestScope.paraMap.searchType}&searchWord=${requestScope.paraMap.searchWord}&gobackURL=${v_gobackURL}'">${requestScope.boardvo.previoussubject}</span></div>
       <div style="margin-bottom: 1%;">다음글제목&nbsp;&nbsp;<span class="move" onclick="javascript:location.href='<%=ctxPath%>/view_2.action?seq=${requestScope.boardvo.nextseq}&searchType=${requestScope.paraMap.searchType}&searchWord=${requestScope.paraMap.searchWord}&gobackURL=${v_gobackURL}'">${requestScope.boardvo.nextsubject}</span></div>
       <br/> 
              
       <button type="button" class="btn btn-secondary btn-sm mr-3" onclick="javascript:location.href='<%= request.getContextPath()%>/list.action'">전체목록보기</button>
       
       <%-- === #126. 페이징 처리되어진 후 특정 글제목을 클릭하여 상세내용을 본 이후
                                      사용자가 목록보기 버튼을 클릭했을 때 돌아갈 페이지를 알려주기 위해
                                      현재 페이지 주소를 뷰단으로 넘겨준다. === --%>
       <button type="button" class="btn btn-secondary btn-sm mr-3" onclick="javascript:location.href='<%= request.getContextPath()%>${requestScope.gobackURL}'">검색된결과목록보기</button>
       
       <button type="button" class="btn btn-secondary btn-sm mr-3" onclick="javascript:location.href='<%= request.getContextPath()%>/edit.action?seq=${requestScope.boardvo.seq}'">글수정하기</button>
       <button type="button" class="btn btn-secondary btn-sm mr-3" onclick="javascript:location.href='<%= request.getContextPath()%>/del.action?seq=${requestScope.boardvo.seq}'">글삭제하기</button>
       
       <%-- === #141. 어떤글에 대한 답변글쓰기는 로그인 되어진 회원의 gradelevel 컬럼의 값이 10인 직원들만 답변글쓰기가 가능하다.  === --%>
       
       
       <%-- === #83. 댓글쓰기 폼 추가 === --%>
       <c:if test="${not empty sessionScope.loginuser}">    <!-- 로그인을 하지 않는다면 보이지 않고 로그인을 했으면 댓글쓰기 폼을 보여준다. -->
       
	       <h3 style="margin-top: 50px;">댓글쓰기</h3>
	       
	       <form name="addWriteFrm" id="addWriteFrm" style="margin-top: 20px;">
	            <table class="table" style="width: 1024px">
	              <tr style="height: 30px;">
	                 <th width="10%">성명</th>
	                 <td>
	                   	<input type="hidden" name ="fk_userid" id="fk_userid" value="${sessionScope.loginuser.userid}" />   <!--  name 이 VO와 같은것이다. -->
	                   	<input type="text" name ="name" id="name" value="${sessionScope.loginuser.name}" readonly="readonly"/>   <!--  name 이 VO와 같은것이다. -->
	                 </td>
	              </tr>
	              <tr style="height: 30px;">
	                 <th>댓글내용</th>
	                 <td>
	                    <input type="text" name = "content" id = "commentContent" size = "100" />    <%-- 기존 글쓰기content 와 헷갈릴수 있기 때문에 id를 바꿈 --%>
	                 	
	                 	<%-- 댓글에 달리는 원 게시물 글 번호 (즉, 댓글의 부모글 글번호) --%>
	                 	<input type="hidden" name="parentSeq"  id="parentSeq" value="${requestScope.boardvo.seq}" />
	                 	
	                 </td>
	              </tr>
	              
	              <tr style="height: 30px;">
	                 <th>파일첨부</th>
	                 <td>
	                     <input type="file" name="attach" id="attach" />
	                 </td>
	              </tr>
	              
	              <tr>
	                 <th colspan="2">
	                    <button type="button" class="btn btn-success btn-sm mr-3" onclick="goAddWrite()">댓글쓰기 확인</button>
	                    <button type="reset" class="btn btn-success btn-sm">댓글쓰기 취소</button>
	                 </th>
	              </tr>
	          </table>         
	       </form>
       
       </c:if>
       
       <%-- === #94. 댓글 내용 보여주기 === --%>
       <h3 style="margin-top: 50px;">댓글내용</h3>
      <table class="table" style="width: 1024px; margin-top: 2%; margin-bottom: 3%;">
         <thead>
         <tr>
             <th style="width: 6%;  text-align: center;">번호</th>
            <th style="text-align: center;">내용</th>
            
            <%-- 첨부파일 있는 경우 시작 --%>
            <th style="width: 15%;">첨부파일</th>
            <th style="width: 8%;">bytes</th>
            <%-- 첨부파일 있는 경우 끝 --%>
            
            <th style="width: 8%; text-align: center;">작성자</th>
            <th style="width: 12%; text-align: center;">작성일자</th>
         </tr>
         </thead>
         <tbody id="commentDisplay"></tbody>
      </table>
      
      <%-- ==== #136. 댓글 페이지바 ==== --%>
       
      <div style="display: flex; margin-bottom: 50px;">
         <div id="pageBar" style="margin: auto; text-align: center;"></div>
      </div>
       
       
       
    </c:if>

   <c:if test="${empty requestScope.boardvo}">
       <div style="padding: 50px 0; font-size: 16pt; color: red;" >존재하지 않습니다</div>
    </c:if>
    
</div>
</div>            