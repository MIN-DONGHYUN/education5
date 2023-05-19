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

<style type="text/css">

	table, th, td {
		border: solid 1px gray;
		border-collapse: collapse;;
	}

</style>


<script type="text/javascript" src="<%= ctxPath%>/resources/js/jquery-3.6.4.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		
		func_ajax_select();
		
		
		// 확인 버튼 클릭시 
		$("button#btnOK").click(function() {
			
			const no_val = $("input#no").val();       // 이름이 no 인 것의 값을 no_val에 저장 
			const name_val = $("input#name").val();
			
			if(no_val.trim() == "" || name_val.trim() == "") {  //두개중 한개라도 없다면
				alert("번호와 성명을 모두 입력하세요!!");
				return;   							// 종료 
			}
			
			$.ajax({
				url:"<%= ctxPath%>/test/ajax_insert.action",
				type:"post",
				data:{"no":no_val,
					  "name":name_val},
				dataType:"json",
				success:function(json) {
					
					console.log("====확인용 :  " + JSON.stringify(json));   // JSON.stringify(json) 요고 잘 기억하자 제발~~~~
					// ==== 확인용 : {"n":1}
					
					if(json.n == 1) { //json의 n 값이 1이라면 
						func_ajax_select();    // 함수 호출 
						$("input#no").val("");    // 값 초기화 
						$("input#name").val("");
					}
				},
				error: function(request, status, error){
		            alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
		        }
			});
			
			
		}); // end of $("button#btnOK").click() -----------------------------------------

	}); // end of $(document).ready(function()

			
	//function Declaration
	function func_ajax_select() {
		
		$.ajax({
			url:"<%= ctxPath%>/test/ajax_select.action",   
			dataType:"json",
		    success:function(json){
		    	console.log(JSON.stringify(json) + " 확인용입니다.")
		    	/* [{"no":"601","name":"이혜리","writeday":"2023-05-10 11:50:49"},
		    		{"no":"204","name":"민효린","writeday":"2023-05-10 11:15:13"},
		    		{"no":"203","name":"이지은","writeday":"2023-05-10 10:51:06"},
		    		{"no":"202","name":"이나영","writeday":"2023-05-10 10:49:56"},
		    		{"no":"201","name":"홍길동","writeday":"2023-05-10 10:09:40"}]
		    	*/
		    	
		    	let html = `<table>
		    	              <tr>
		    	                   <th>번호</th>
		    	                   <th>입력번호</th>
		    	                   <th>성명</th>
		    	                   <th>작성일자</th>
		    	              </tr>`;
		    	
		    	$.each(json, function(index, item){    // 결과물을 뿌리기 위해  반복문 
		    		html += `<tr>
 	                              <td>\${index+1}</td>
 	                              <td>\${item.no}</td>
			 	                  <td>\${item.name}</td>
			 	                  <td>\${item.writeday}</td>
			 	             </tr>`;
		    	})  
		    	
		    	html += `</table>`;
		    	
		    	$("div#view").html(html);   // html 추가하기 
		    	
		    	// 백틱 사용
		    	
		    	
		    },
		    error: function(request, status, error){
	            alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
	        }

		});
		
		
	} // end of function func_ajax_select()
			

</script>



</head>
<body>

	<h2>Ajax 연습</h2>
	<p> 안녕하세요? <br> 
		여기는 /board/test/test_form_3.action 페이지 입니다.
	</p>
	
	      번호 : <input type="text" id="no" /><br>
	      성명 : <input type="text" id="name" /><br>
	       <button type="button" id="btnOK">확인</button>
	       <button type="reset" id="btnCancel">취소</button>
    <br><br>
    
    <div id="view"></div>
    

</body>
</html>