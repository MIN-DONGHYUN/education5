<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String ctxPath = request.getContextPath();
    //     /board
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="<%= ctxPath%>/resources/js/jquery-3.6.4.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		
		$("form[name='testFrm']").submit(function() {    // form 이름이 testFrm 인것의 submit 이면
			
			const no_val = $("input[name='no']").val();       // 이름이 no 인 것의 값을 no_val에 저장 
			const name_val = $("input[name='name']").val();
			
			if(no_val.trim() == "" || name_val.trim() == "") {  //두개중 한개라도 없다면
				alert("번호와 성명을 모두 입력하세요!!");
				return false;   								// submit(전송) 을 하지 말라는 뜻이다.
			}
			
		});   
		
		
		
	});


</script>



</head>
<body>

	<form name="testFrm" action="<%= ctxPath%>/test/test_form_vo_modelAndView.action" method="POST">  <!--  POST 방식으로 보낸다. -->
	      번호_vo_modelAndView : <input type="text" name="no" /><br>
	      성명_vo_modelAndView : <input type="text" name="name" /><br>
	       <input type="submit" value="확인" />
	       <input type="reset"  value="취소" /> 
    </form>

</body>
</html>