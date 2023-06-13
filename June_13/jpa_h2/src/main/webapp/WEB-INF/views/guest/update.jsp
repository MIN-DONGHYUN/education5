<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String ctxPath = request.getContextPath();
	System.out.println("ctxPath => " + ctxPath);
	// ctxPath => 
%>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 수정하기</title>

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css" href="<%= ctxPath%>/bootstrap-4.6.0-dist/css/bootstrap.min.css">

<script type="text/javascript" src="<%= ctxPath%>/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="<%= ctxPath%>/bootstrap-4.6.0-dist/js/bootstrap.bundle.min.js" ></script>

<script type="text/javascript">

	$(document).ready(function(){
		
		// 수정버튼
		$("button#btnUpdate").click(function(){
			  
			// 제목 유효성 검사
			const title = $("input#title").val().trim();
			if(title == "") {
				alert("글제목을 입력하세요!!");
				return;
			}
			
			// 작성자 유효성 검사
			const writer = $("input#writer").val().trim();
			if(writer == "") {
				alert("작성자명을 입력하세요!!");
				return;
			}
			
			// 내용 유효성 검사
			const content = $("textarea#content").val().trim();
			if(content == "") {
				alert("내용을 입력하세요!!");
				return;
			}
				
			// 폼(form) 을 전송(submit)
			const frm = document.updateFrm;
			frm.method = "POST";
			frm.action = "<%= ctxPath%>/guest/update";
			frm.submit();   
		 });	
				
	});

</script>

</head>
<body>

<div style="display: flex;" class="container" >
  <div style="margin:auto; padding-left: 3%;">
    <h3 class="my-5">방명록 수정하기</h3> 
    
    <form name="updateFrm"> 
      <table style="width: 1024px" class="table table-bordered">
         <tr>
            <th style="width: 15%; background-color: #DDDDDD;">제목</th>
            <td>
                <input type="hidden" name="num" value="${dto.num}" />
                <input type="text" name="title" id="title" size="100" value="${dto.title}" />
            </td>
         </tr>
         <tr>
            <th style="width: 15%; background-color: #DDDDDD;">작성자</th>
            <td>
                <input type="text" name="writer" id="writer" value="${dto.writer}" />       
            </td>
         </tr>
         <tr>
            <th style="width: 15%; background-color: #DDDDDD; vertical-align: middle;">내용</th>
            <td>
               <textarea style="width: 100%; height: 400px;" name="content" id="content">${dto.content}</textarea>       
            </td>
         </tr>
      </table>
      
      <div style="margin: 20px;">
         <button type="button" class="btn btn-secondary btn-sm mr-3" id="btnUpdate">수정하기</button>
         <button type="reset"  class="btn btn-secondary btn-sm mr-3">다시입력</button>
         <button type="button" class="btn btn-secondary btn-sm" onclick="javascript:location.href='list'">취소</button>
      </div>
         
    </form>
  </div> 
</div> 

</body>
</html>