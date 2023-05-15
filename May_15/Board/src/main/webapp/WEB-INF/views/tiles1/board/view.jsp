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
				 goReadComment();// 페이징 처리 안한 댓글 읽어오기
				 // 페이징 처리 한 댓글 읽어오기 
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
			 
		 },
		 error: function(request, status, error){
	         alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
	     }
	  });
  }
  
  // === #127. Ajax로 불러온 댓글내용을  페이징 처리 하기  === //
  
  
  // ==== 댓글내용 페이지바 Ajax로 만들기 ==== //
  
  
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
       
       <c:set var="v_gobackURL" value='' />
       
       <%-- 글조회수 1증가를 위해서  view.action 대신에 view_2.action 으로 바꾼다. --%>
       <div style="margin-bottom: 1%;">이전글제목&nbsp;&nbsp;<span class="move" onclick="javascript:location.href='<%=ctxPath%>/view_2.action?seq=${requestScope.boardvo.previousseq}'">${requestScope.boardvo.previoussubject}</span></div>
       <div style="margin-bottom: 1%;">다음글제목&nbsp;&nbsp;<span class="move" onclick="javascript:location.href='<%=ctxPath%>/view_2.action?seq=${requestScope.boardvo.nextseq}'">${requestScope.boardvo.nextsubject}</span></div>
       <br/> 
              
       <button type="button" class="btn btn-secondary btn-sm mr-3" onclick="javascript:location.href='<%= request.getContextPath()%>/list.action'">전체목록보기</button>
       
       <%-- === #126. 페이징 처리되어진 후 특정 글제목을 클릭하여 상세내용을 본 이후
                                      사용자가 목록보기 버튼을 클릭했을 때 돌아갈 페이지를 알려주기 위해
                                      현재 페이지 주소를 뷰단으로 넘겨준다. === --%>
       <button type="button" class="btn btn-secondary btn-sm mr-3" onclick="">검색된결과목록보기</button>
       
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
       
      
      <%-- ==== #136. 댓글 페이지바 ==== --%>
       
       
    </c:if>

   <c:if test="${empty requestScope.boardvo}">
       <div style="padding: 50px 0; font-size: 16pt; color: red;" >존재하지 않습니다</div>
    </c:if>
    
</div>
</div>            