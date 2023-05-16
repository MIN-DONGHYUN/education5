<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%
   String ctxPath = request.getContextPath();
%>   

<style type="text/css">

</style>

<script type="text/javascript">

  $(document).ready(function(){
     
	// 삭제하기를 클릭하면 삭제하기 
	$("button#btnDelete").click(function(){
    	
    	// 넘어온 pw 하고 입력한 pw 하고 같지 않으면 
    	if( "${requestScope.pw}" != $("input#pw").val() ) {
    		alert("글암호가 일치하지 않습니다.");
    		return;
    	}
    	else {
    		
    		// 정말 삭제할 것인지 cnfirm 창을 띄운다. 취소한다면 이 코드는 실행되지 않는다. 
    		if(confirm("정말로 글 삭제를 하시겠습니까?")) {
    			//폼(form)을 전송 (ubmit)
        		const frm = document.delFrm;
        		frm.method = "post";
        		frm.action = "<%= ctxPath %>/delEnd.action";
        		frm.submit();
    		}
    	}
    	
    	
    });
     
  });// end of $(document).ready(function(){})-------------------------------

</script>

<div style="display: flex;">
<div style="margin: auto; padding-left: 3%;">

<h2 style="margin-bottom: 30px;">글삭제</h2>

<form name="delFrm">
   <table style="width: 1024px" class="table table-bordered">
      <tr>
         <th style="width: 15%; background-color: #DDDDDD;">글암호</th>
         <td>
            <input type="password" id="pw" />
            <input type="hidden" name = "seq" value="${requestScope.seq}" />   <!-- 해당 글 번호를 넘긴다. -->
         </td>
      </tr>
   </table>
   
   <div style="margin: 20px;">
      <button type="button" class="btn btn-secondary btn-sm mr-3" id="btnDelete">글삭제완료</button>
      <button type="button" class="btn btn-secondary btn-sm" onclick="javascript:history.back()">글삭제취소</button>
   </div>
   
</form>   
</div>
</div>    