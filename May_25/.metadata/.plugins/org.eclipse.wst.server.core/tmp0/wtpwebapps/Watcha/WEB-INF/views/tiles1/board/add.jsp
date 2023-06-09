<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%
   String ctxPath = request.getContextPath();
%>   

<style type="text/css">

</style>

<script type="text/javascript">

  $(document).ready(function(){
     	$("button#btnWrite").click(function(){
	     	// 글제목 유효성 검사
	            const subject = $("input#subject").val().trim();
	            if(subject == "") {
	               alert("글제목을 입력하세요!!");
	               return;
	            }
	            
	         // 글내용 유효성 검사(스마트 에디터 사용 안 할 경우)
	            const content = $("textarea#content").val().trim();
	            if(content == "") {
	               alert("글내용을 입력하세요!!");
	               return;
	            }
	            
	         // 글암호 유효성 검사
	            const pw = $("input#pw").val();
	            if(pw == "") {
	               alert("글암호를 입력하세요!!");
	               return;
	            }
	            
	            // 폼(form)을 전송(submit)
	            const frm = document.addFrm;
	            frm.method = "POST";
	            frm.action = "<%= ctxPath%>/addEnd.action";
	            frm.submit();
     	});
     
  });// end of $(document).ready(function(){})-------------------------------

</script>

<div style="display: flex;">
<div style="margin: auto; padding-left: 3%;">

<%-- 원글쓰기인 경우 --%>
<c:if test='${fk_seq eq ""}'>
	<h2 style="margin-bottom: 30px;">글쓰기</h2>
</c:if>

<%-- 답변글쓰기인 경우 --%>
<c:if test='${fk_seq ne ""}'>
	<h2 style="margin-bottom: 30px; color: navy;">답변글쓰기</h2>
</c:if>

<form name="addFrm">
   <table style="width: 1024px" class="table table-bordered">
      <tr>
         <th style="width: 15%; background-color: #DDDDDD;">성명</th>
         <td>
            	<input type="text" name="name"  value="${sessionScope.loginuser.name}" readonly />
            	<input type="hidden" name="fk_userid"  value="${sessionScope.loginuser.userid}" readonly />            	
         </td>
      </tr>
      
      <tr>
         <th style="width: 15%; background-color: #DDDDDD;">제목</th>
         <td>
         	<%-- 원글쓰기인 경우 --%>
			<c:if test='${fk_seq eq ""}'>
				<input type="text" name="subject" id="subject"  size=100pt  />
			</c:if>
         
         	<%-- 답변글쓰기인 경우 --%>
			<c:if test='${fk_seq ne ""}'>
				<input type="text" name="subject" id="subject"  size=100pt value="${subject}" readonly />
			</c:if>
         </td>
      </tr>
      
      <tr>
         <th style="width: 15%; background-color: #DDDDDD;">내용</th>
         <td>
            	<textarea style="width:100%; height: 612px;" name="content" id="content"></textarea>
         </td>
      </tr>
      
      <tr>
         <th style="width: 15%; background-color: #DDDDDD;">글암호</th>
         <td>
             <input type="password" name="pw" id="pw" size=100pt />
         </td>
      </tr>
   </table>
   
   <%-- == #143. 답변글쓰기가 추가된 경우 시작 == --%>
   <input type="text" name="fk_seq" value="${fk_seq}"/>
   <input type="text" name="groupno" value="${groupno}"/>
   <input type="text" name="depthno" value="${depthno}"/>
   <%-- == 답변글쓰기가 추가된 경우 끝 == --%>
   
   <div style="margin: 20px;">
      <button type="button" class="btn btn-secondary btn-sm mr-3" id="btnWrite">글쓰기</button>
      <button type="button" class="btn btn-secondary btn-sm" onclick="javascript:history.back()">취소</button>
   </div>
   
</form>   
</div>
</div>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    