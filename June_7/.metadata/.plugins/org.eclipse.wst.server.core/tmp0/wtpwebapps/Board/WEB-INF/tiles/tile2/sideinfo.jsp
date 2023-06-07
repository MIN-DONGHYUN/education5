<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<%-- ======= #28. tile2 중 sideinfo 페이지 만들기  ======= --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% String ctxPath = request.getContextPath(); %>

<style type="text/css">
	
   .highcharts-figure,
   .highcharts-data-table table {
       min-width: 320px;
       max-width: 800px;
       margin: 1em auto;
   }
   
   .highcharts-data-table table {
       font-family: Verdana, sans-serif;
       border-collapse: collapse;
       border: 1px solid #ebebeb;
       margin: 10px auto;
       text-align: center;
       width: 100%;
       max-width: 500px;
   }
   
   .highcharts-data-table caption {
       padding: 1em 0;
       font-size: 1.2em;
       color: #555;
   }
   
   .highcharts-data-table th {
       font-weight: 600;
       padding: 0.5em;
   }
   
   .highcharts-data-table td,
   .highcharts-data-table th,
   .highcharts-data-table caption {
       padding: 0.5em;
   }
   
   .highcharts-data-table thead tr,
   .highcharts-data-table tr:nth-child(even) {
       background: #f8f8f8;
   }
   
   .highcharts-data-table tr:hover {
       background: #f1f7ff;
   }
   
</style>

<script src="<%= ctxPath%>/resources/Highcharts-10.3.1/code/highcharts.js"></script>
<script src="<%= ctxPath%>/resources/Highcharts-10.3.1/code/modules/exporting.js"></script>
<script src="<%= ctxPath%>/resources/Highcharts-10.3.1/code/modules/export-data.js"></script>
<script src="<%= ctxPath%>/resources/Highcharts-10.3.1/code/modules/accessibility.js"></script>

<script type="text/javascript">

var weatherTimejugi = 0;  // 단위는 밀리초

   $(document).ready(function() {
      
	   loopshowNowTime();
	   
	   
	  // 시간이 대략 매 30분 0초가 되면 기상청 날씨정보를 자동 갱신해서 가져오려고 함.
      // (매 정시마다 변경되어지는 날씨정보를 정시에 보내주지 않고 대략 30분이 지난다음에 보내주므로)
      var now = new Date();
      var minute = now.getMinutes();  // 현재시각중 분을 읽어온다.
      
      if(minute < 30) { // 현재시각중 분이 0~29분 이라면
         weatherTimejugi = (30-minute)*60*1000;  // 현재시각의 분이 0분이라면 weatherTimejugi에 30분을 넣어준다.
                                                 // 현재시각의 분이 5분이라면 weatherTimejugi에 25분을 넣어준다.
                                                 // 현재시각의 분이 29분이라면 weatherTimejugi에 1분을 넣어준다.
      }
      else if(minute == 30) {
         weatherTimejugi = 1000;                 // 현재시각의 분이 30분이라면 weatherTimejugi에 1초 넣어준다.
      }
      else {                                      // 현재시각의 분이 31~59분이라면
         weatherTimejugi = ( (60-minute)+30 )*60*1000;  // 현재시각의 분이 31분이라면 weatherTimejugi에 (29+30)분을 넣어준다.
                                                        // 현재시각의 분이 40분이라면 weatherTimejugi에 (20+30)분을 넣어준다.
                                                        // 현재시각의 분이 59분이라면 weatherTimejugi에 (1+30)분을 넣어준다.
      }
   
	   
	   
	   startshowWeather(); // 기상청 날씨정보 공공API XML데이터 호출 및 매 1시간 마다 주기적으로 기상청 날씨정보 공공API XML데이터 호출하기
	   
	   //showWeather();	// 날씨 하는것 테스트 하기 
	   
	   
   }); // end of $(document).ready(); ---------------------------------

   function showNowTime() {
      
      var now = new Date();
   
      var month = now.getMonth() + 1;
      if(month < 10) {
         month = "0"+month;
      }
      
      var date = now.getDate();
      if(date < 10) {
         date = "0"+date;
      }
      
      var strNow = now.getFullYear() + "-" + month + "-" + date;
      
      var hour = "";
       if(now.getHours() < 10) {
           hour = "0"+now.getHours();
       } 
       else {
          hour = now.getHours();
       }
      
       
      var minute = "";
      if(now.getMinutes() < 10) {
         minute = "0"+now.getMinutes();
      } else {
         minute = now.getMinutes();
      }
      
      var second = "";
      if(now.getSeconds() < 10) {
         second = "0"+now.getSeconds();
      } else {
         second = now.getSeconds();
      }
      
      strNow += " "+hour + ":" + minute + ":" + second;
      
      $("span#clock").html(strNow);
   
   }// end of function showNowTime() -----------------------------


   function loopshowNowTime() {
      showNowTime();
      
      var timejugi = 1000;   // 시간을 1초 마다 자동 갱신하려고.
      
      setTimeout(function() {
                  loopshowNowTime();   
               }, timejugi);
      
   }// end of loopshowNowTime() --------------------------

   
   // ------ 기상청 날씨정보 공공API XML데이터 호출하기 -------- //
   
   function showWeather(){
	   
	   $.ajax({
		   url:"<%= request.getContextPath()%>/opendata/weatherXML.action",
	       type:"get",
		   dataType:"xml",   /* 데이터 타입 xml을 가져와야 하므로  xml을 사용 */
		   success:function(xml){
			   /* 맨 꼭대기의 태그를 읽어오자  */
			   var rootElement = $(xml).find(":root");
			   //console.log("확인용 최상위 태그 : " + $(rootElement).prop("tagName"));
			   // 확인용 최상위 태그 : current
			   
			   var weather = $(rootElement).find("weather");
			   var updateTime = $(weather).attr("year")+"년 "+ $(weather).attr("month")+"월 " + $(weather).attr("day")+"일 " + $(weather).attr("hour")+"시";
		  	   // console.log(updateTime);
		  	   // 2023년 06월 07일 11시
		  	   
		  	   var localArr = $(rootElement).find("local");
		  	   //console.log("지역개수 : " + localArr.length);
		  	   // 지역개수 : 97
		  	   
		  	   
			  	var html = "날씨정보 발표시각 : <span style='font-weight:bold;'>"+updateTime+"</span>&nbsp;";
	            html += "<span style='color:blue; cursor:pointer; font-size:9pt;' onclick='javascript:showWeather();'>업데이트</span><br/><br/>";
	            html += "<table class='table table-hover' align='center'>";
	            html += "<tr>";
	            html += "<th>지역</th>";
	            html += "<th>날씨</th>";
	            html += "<th>기온</th>";
	            html += "</tr>";
	            
	            // ====== XML 을 JSON 으로 변경하기  ====== //
	               var jsonObjArr = [];
	            // ====== XML 을 JSON 으로 변경하기 끝  ====== //
	            
	            
	            for(var i = 0; i < localArr.length; i++) {
	            	 var local = $(localArr).eq(i);
	            	/* 
	            	   .eq(index) 는 선택된 요소들을 인덱스 번호로 찾을 수 있는 선택자이다. 
					       마치 배열의 인덱스(index)로 값(value)를 찾는 것과 같은 효과를 낸다.
					*/
					
					// console.log($(local).text() + "stn_id : " + $(local).attr("stn_id")  + " icon:" + $(local).attr("icon") + " desc:" + $(local).attr("desc") + " ta:" + $(local).attr("ta"));  // 지역명을 나타낸다. .text는 글자를 가져옴 
					/*
						속초 stn_id : 90 icon:01 desc:맑음 ta:25.4
						북춘천 stn_id : 93 icon:03 desc:구름많음 ta:23.4
						철원 stn_id : 95 icon:03 desc:구름많음 ta:22.4
						...... 
						북부산 stn_id : 296 icon:03 desc:구름많음 ta:26.1
					*/
								
	            	 var icon = $(local).attr("icon");
	                 if(icon == "") {
	                    icon = "없음";
	                 }
	                 
	                 html += "<tr>";
	                 html += "<td>"+$(local).text()+"</td><td><img src='/board/resources/images/weather/"+icon+".png' />"+$(local).attr("desc")+"</td><td>"+$(local).attr("ta")+"</td>";
	                 html += "</tr>";
					
	                 
	              	// ====== XML 을 JSON 으로 변경하기  ====== //
	                  var jsonObj = {"locationName":$(local).text(), "ta":$(local).attr("ta")};
	                  
	                  jsonObjArr.push(jsonObj);
	               	// ====== XML 을 JSON 으로 변경하기  ====== // 
	                 
	            }// end of for 
	            
				html += "</table>";
				
				// 테이블 모양으로 출력하기 
				$("div#displayWeather").html(html);
				
				// 차트 그리기 
				// ====== XML 을 JSON 으로 변경하기  ====== //
	            var str_jsonObjArr = JSON.stringify(jsonObjArr); 
	                              // JSON객체인 jsonObjArr를 String(문자열) 타입으로 변경해주는 것 
	                              
	            $.ajax({
	               url:"<%= request.getContextPath()%>/opendata/weatherXMLtoJSON.action",
	               type:"POST",
	               data:{"str_jsonObjArr":str_jsonObjArr},
	               dataType:"JSON",
	               success:function(json){
	                  
	               	  //console.log(JSON.stringify(json));
	                  //[{"locationName":"춘천","ta":"25.0"},{"locationName":"백령도","ta":"18.2"},{"locationName":"강릉","ta":"28.1"},{"locationName":"서울","ta":"21.4"},{"locationName":"인천","ta":"21.1"},{"locationName":"울릉도","ta":"24.7"},{"locationName":"수원","ta":"21.5"},{"locationName":"청주","ta":"23.8"},{"locationName":"대전","ta":"23.3"},{"locationName":"안동","ta":"23.9"},{"locationName":"포항","ta":"26.8"},{"locationName":"대구","ta":"26.1"},{"locationName":"전주","ta":"25.2"},{"locationName":"울산","ta":"26.7"},{"locationName":"창원","ta":"26.2"},{"locationName":"광주","ta":"25.1"},{"locationName":"부산","ta":"24.1"},{"locationName":"목포","ta":"22.5"},{"locationName":"여수","ta":"22.5"},{"locationName":"홍성","ta":"23.7"},{"locationName":"제주","ta":"22.2"}]
	                  
	                  // ======== chart 그리기 ========= // 
	                  var dataArr = [];
	                  $.each(json, function(index, item){
	                     dataArr.push([item.locationName, 
	                                  Number(item.ta)]);
	                  });// end of $.each(json, function(index, item){})------------
	                  
	                  
	                  Highcharts.chart('weather_chart_container', {
	                      chart: {
	                          type: 'column'
	                      },
	                      title: {
	                          text: '오늘의 전국 기온(℃)'   // 'ㄹ' 을 누르면 ℃ 가 나옴.
	                      },
	                      subtitle: {
	                      //    text: 'Source: <a href="http://en.wikipedia.org/wiki/List_of_cities_proper_by_population">Wikipedia</a>'
	                      },
	                      xAxis: {
	                          type: 'category',
	                          labels: {
	                              rotation: -45,
	                              style: {
	                                  fontSize: '10px',
	                                  fontFamily: 'Verdana, sans-serif'
	                              }
	                          }
	                      },
	                      yAxis: {
	                          min: -10,
	                          title: {
	                              text: '온도 (℃)'
	                          }
	                      },
	                      legend: {
	                          enabled: false
	                      },
	                      tooltip: {
	                          pointFormat: '현재기온: <b>{point.y:.1f} ℃</b>'
	                      },
	                      series: [{
	                          name: '지역',
	                          data: dataArr, // **** 위에서 만든것을 대입시킨다. **** 
	                          dataLabels: {
	                              enabled: true,
	                              rotation: -90,
	                              color: '#FFFFFF',
	                              align: 'right',
	                              format: '{point.y:.1f}', // one decimal
	                              y: 10, // 10 pixels down from the top
	                              style: {
	                                  fontSize: '10px',
	                                  fontFamily: 'Verdana, sans-serif'
	                              }
	                          }
	                      }]
	                      
	                  });
	               },
				   error: function(request, status, error){
			           alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
			       }
				   
			   });
	              
	           // ====== XML 을 JSON 으로 변경하기  ====== //

		            
		   },
		   error: function(request, status, error){
	           alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
	       }
		   
	   });
	   
   }// end of function showWeather()
   
   
   function startshowWeather() {
      loopshowWeather();   // 날씨를 보인다.
      
      setTimeout(function() {
         showWeather();   
      }, weatherTimejugi); // 현재시각의 분이 5분이라면 weatherTimejugi가 25분이므로 25분후인 30분에 showWeather();를 실행한다.
   }// end of function startshowWeather() --------------------------   
   
   
   function loopshowWeather() {
      showWeather();
      
      setTimeout(function() {
           loopshowWeather();   
      }, weatherTimejugi + (60*60*1000));  // 현재시각의 분이 5분이라면 weatherTimejugi가 25분이므로 25분후인 30분에 1시간을 더한후에 showWeather();를 실행한다.
   }// end of function loopshowWeather() --------------------------   
  
   
   
</script>

<div style="min-height: 1100px; margin-bottom: 50px;">
   <div style="text-align: center; font-size: 16pt;">
      현재시각 :&nbsp; <span id="clock" style="color:green; font-weight:bold;"></span>
   </div>
   
   <div id="displayWeather" style="min-width: 90%; max-height: 500px; overflow-y: scroll; margin-top: 40px; margin-bottom: 70px; padding-left: 10px; padding-right: 10px;"></div> 

   <div style="margin: 20px;">
      <%-- 차트그리기 --%>
      <figure class="highcharts-figure">
          <div id="weather_chart_container"></div>
      </figure> 
   </div>
</div>