<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style type="text/css">

   table#emptbl {
      width: 100%;
   }
   
   table#emptbl th, table#emptbl td {
      border: solid 1px gray;
      border-collapse: collapse;
   }
   
   table#emptbl th {
      text-align: center;
      background-color: #ccc;
   }
   
   form {
      margin: 0 0 30px 0;
   }
   
</style> 

<script type="text/javascript">

   $(document).ready(function(){
      
      // 검색하기 버튼 클릭시
      $("button#btnSearch").click(function(){
    	 
    	  const arrDeptId = new Array();
    	  
    	  $("input:checkbox[name='deptId']").each(function(index, item){
    		  const bool = $(item).prop("checked");   // 체크박스에 체크 유무 검사
    	  	  
    		  if(bool == true) {
    			  // 체크박스에 체크가 되었으면 
    			  arrDeptId.push($(item).val());
    		  }
    	  
    	  });
    	  
    	  const str_DeptId = arrDeptId.join();
    	  
    	  //console.log("~~~확인용 str_DeptId : " + str_DeptId);
    	  // 확인용 str_DeptId : -9999, 30, 40
    	  
    	  const frm = document.searchFrm;
    	  frm.str_DeptId.value = str_DeptId;
    	  
    	  frm.method = "get";
    	  frm.action = "empList.action";  // 상대경로
    	  frm.submit();
    	  
      });
      
      
      // ======== 체크박스 유지시키기 시작 ======== //
      const str_DeptId = "${requestScope.str_DeptId}";   // "" 쓰는 이유 자바스크립트이기 때문 
      // console.log(str_DeptId);  "-9999,20,40,50"
      
      if(str_DeptId != ""){
    	  const arr_DeptId = str_DeptId.split(",");   // , 분리 ==> 배열로 됨
    	  // ["-9999","20","40","50"]
    	  
    	  // 모든 체크박스 반복 
    	  $("input:checkbox[name='deptId']").each(function(index, item){
    		  for(let i=0; i<arr_DeptId.length; i++){
    		  	if($(item).val() == arr_DeptId[i]) {   //체크박스 값과 배열의 값이 같으면 실행 
    		  		$(item).prop("checked", true);
    		  		break;
    		  	}
    	  	  }
    	  });
      }
      // ======== 체크박스 유지시키기 끝 ======== //
      
      
      // ======== 성별 유지시키기 시작 ======== //
      const gender = "${requestScope.gender}";
      // gender 가 검색하기 클릭할때 성별을 선택 안한다면 
      if(gender != "") {
    	  $("select#gender").val(gender);
      }
      // ======== 성별 유지시키기 끝 ======== //
      
      
      
      // ====== Excel 파일로 다운받기 시작 ====== //
      $("button#btnExcel").click(function(){
	
    	  const arrDeptId = new Array();
    	  
    	  $("input:checkbox[name='deptId']").each(function(index, item){
    		  const bool = $(item).prop("checked");   // 체크박스에 체크 유무 검사
    	  	  
    		  if(bool == true) {
    			  // 체크박스에 체크가 되었으면 
    			  arrDeptId.push($(item).val());
    		  }
    	  
    	  });
    	  
    	  const str_DeptId = arrDeptId.join();
    	  
    	  //console.log("~~~확인용 str_DeptId : " + str_DeptId);
    	  // 확인용 str_DeptId : -9999, 30, 40
    	  
    	  const frm = document.searchFrm;
    	  frm.str_DeptId.value = str_DeptId;
    	  
    	  frm.method = "post";   // file로 하기 때문에 post 방식 
    	  frm.action = "<%= request.getContextPath()%>/excel/downloadExcelFile.action";  
    	  frm.submit();
      });
      // ====== Excel 파일로 다운받기 끝 ====== //
      
      
      // ====== Excel 파일로 업로드하기 시작 ====== //
      $("button#btn_upload_excel").click(function(){
    	  if($("input#upload_excel_file").val() == "") {   // 파일을 선택하지 않으면 
              alert("업로드할 엑셀파일을 선택하세요!!");
              return;
           }
    	  else {
    		  // ajax 를 사용하여 파일 전송하는 2가지 방법 
    		  // ==> 1. ajaxForm 을 사용하는 것 (tiles1.view.jsp 참조)
    		  // ==> 2. FormDate 를 사용하는 것 (tiles2.empList.jsp 참조)
    		  
    		  // 지금은 FormDate 를 사용해보자 
    		  
    		  let formData =  new FormData($("form[name='excel_upload_frm']").get(0)); // form 태그의 이름이 excel_upload_frm일때 
    		  								// 폼태그에 작성된 모든 데이터 보내기
    		  // jQuery선택자.get(0) 은 jQuery 선택자인 jQuery Object 를 DOM(Document Object Model) element 로 바꿔주는 것이다. 
	          // DOM element 로 바꿔주어야 순수한 javascript 문법과 명령어를 사용할 수 있게 된다.								
	    		  								
    		  // 또는 
    		  //let formDate =  new FormDate(document.getElementById("excel_upload_frm")); 
    		  // 위처럼 원래 jquery 는 안되고 이렇게 자바스크립트를 사용해야한다. 하지만 마지막에 get(0)이 붙으면 같다.
    		  // 폼태그에 작성된 모든 데이터 보내기
    		  
    		  $.ajax({
    			  
    			  url : "<%= request.getContextPath()%>/excel/uploadExcelFile.action",
                  type : "post",
                  data : formData,    // data 에 formData를 넣는다, formData는 파일도 포함된다. 
                  processData:false,  // 파일 전송시 설정  (processData:false, contentType:false 를 꼭 설정해야한다. )
                  contentType:false,  // 파일 전송시 설정 
                  dataType:"json",
                  success:function(json){
                     // console.log("~~~ 확인용 : " + JSON.stringify(json));
                      // ~~~ 확인용 : {"result":1}
                      if(json.result == 1) {
                         alert("엑셀파일 업로드 성공했습니다.^^");
                      }
                      else {
                         alert("엑셀파일 업로드 실패했습니다.ㅜㅜ");
                      }
                  },
                  error: function(request, status, error){
                  alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
                  }
    		  });
    		  /*
    		  	==== processData 와 contentType 의 설명문 ===
    		  
	               processData 관련하여, 일반적으로 서버에 전달되는 데이터는 query string(쿼리 스트링)이라는 형태로 전달된다. 
	               ex) http://localhost:9090/board/list.action?searchType=subject&searchWord=안녕
	               ? 다음에 나오는 searchType=subject&searchWord=안녕 이라는 것이 query string(쿼리 스트링) 이다. 
    
		           data 파라미터로 전달된 데이터를 jQuery에서는 내부적으로 query string 으로 만든다. 
		                      하지만 파일 전송의 경우 내부적으로 query string 으로 만드는 작업을 하지 않아야 한다.
		                      이와 같이 내부적으로 query string 으로 만드는 작업을 하지 않도록 설정하는 것이 processData: false 이다.
	          */
	           
	          /*
	              contentType 은 default 값이 "application/x-www-form-urlencoded; charset=UTF-8" 인데, 
	              "multipart/form-data" 로 전송이 되도록 하기 위해서는 false 로 해야 한다. 
	                            만약에 false 대신에 "multipart/form-data" 를 넣어보면 제대로 작동하지 않는다.
	          */
    		  
    		  
    		  
    		  
    	  }
      });
      
      // ====== Excel 파일로 업로드하기 끝 ====== //
      
   });// end of $(document).ready(function(){})-----------------------

</script>   


<div style="display: flex; margin-bottom: 50px;">   
<div style="width: 80%; min-height: 1100px; margin:auto; ">

   <h2 style="margin: 50px 0;">HR 사원정보 조회하기</h2>

   <form name="searchFrm">
       <c:if test="${not empty requestScope.deptIdList}">
       		<span style="display: inline-block; width: 150px; font-weight: bold;">부서번호선택</span> 
       		<c:forEach var="deptId" items="${requestScope.deptIdList}" varStatus="status">
       			 <label for="${status.index}">
       			 	<c:if test="${deptId == -9999}">부서없음</c:if>
       			 	<c:if test="${deptId != -9999}">${deptId}</c:if>
       			 </label>
       			 <input type="checkbox" name="deptId" id="${status.index}" value="${deptId}"/>&nbsp;&nbsp;
       		</c:forEach>
       </c:if>
       
       <input type="hidden" name="str_DeptId" />
       
       <select name="gender" id="gender" style="height: 30px; width: 120px; margin: 10px 30px 0 0;">
         <option value="">성별선택</option>
         <option>남</option>
         <option>여</option>
       </select>
       <button type="button" class="btn btn-secondary btn-sm" id="btnSearch">검색하기</button>
       &nbsp;&nbsp;
       <button type="button" class="btn btn-success btn-sm" id="btnExcel">Excel파일로저장</button>
   
   </form>
   
   <br/>
   
   <!-- ==== 엑셀관련파일 업로드 하기 시작 ==== -->

   <form style="margin-bottom: 10px;" id="excel_upload_frm" name="excel_upload_frm" method="post" enctype="multipart/form-data" >
      <input type="file" id="upload_excel_file" name="excel_file" accept=".csv, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel" />  <!-- accept 는 파일 지정 가능   -->
      <br>
      <button type="button" class="btn btn-info btn-sm" id="btn_upload_excel" style="margin-top: 1%;">Excel 파일 업로드 하기</button>
   </form>

   <!-- ==== 엑셀관련파일 업로드 하기 끝 ==== -->
   
   <table id="emptbl">
      <thead>
         <tr>
            <th>부서번호</th>
            <th>부서명</th>
            <th>사원번호</th>
            <th>사원명</th>
            <th>입사일자</th>
            <th>월급</th>
            <th>성별</th>
            <th>나이</th>
         </tr>
      </thead>
      <tbody> 
      	 <c:if test="${not empty requestScope.empList}">
      	 	<c:forEach var="map" items="${requestScope.empList}">
      	 		<tr>
      	 			<td style="text-align: center;">${map.department_id}</td>
      	 			<td>${map.department_name}</td>
      	 			<td style="text-align: center;">${map.employee_id}</td>
      	 			<td>${map.fullname}</td>
      	 			<td style="text-align: center;">${map.hire_date}</td>
      	 			<td style="text-align: right;"><fmt:formatNumber value="${map.monthsal}" pattern="#,###" /></td>
      	 			<td style="text-align: center;">${map.gender}</td>
      	 			<td style="text-align: center;">${map.age}</td>
      	 		</tr>
      	 	</c:forEach>
      	 </c:if>
      </tbody>
   </table>     
</div>
</div>