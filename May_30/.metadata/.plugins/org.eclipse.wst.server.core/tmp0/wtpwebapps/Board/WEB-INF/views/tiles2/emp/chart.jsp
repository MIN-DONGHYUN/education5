<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
	
	input[type="number"] {
	    min-width: 50px;
	}
	
	
   div#table_container table {width: 100%}
   div#table_container th, div#table_container td {border: solid 1px gray; text-align: center;} 
   div#table_container th {background-color: #595959; color: white;} 


</style>

<%-- 원형 차트 필요 --%>
<script src="<%= ctxPath%>/resources/Highcharts-10.3.1/code/highcharts.js"></script>
<script src="<%= ctxPath%>/resources/Highcharts-10.3.1/code/modules/exporting.js"></script>
<script src="<%= ctxPath%>/resources/Highcharts-10.3.1/code/modules/export-data.js"></script>
<script src="<%= ctxPath%>/resources/Highcharts-10.3.1/code/modules/accessibility.js"></script>

<%-- 라인 차트 필요 --%>
<script src="<%= ctxPath%>/resources/Highcharts-10.3.1/code/modules/series-label.js"></script>

<%-- drilldown 차트 필요 --%>
<script src="<%= ctxPath%>/resources/Highcharts-10.3.1/code/modules/data.js"></script>
<script src="<%= ctxPath%>/resources/Highcharts-10.3.1/code/modules/drilldown.js"></script>


<div style="display: flex;">   
<div style="width: 80%; min-height: 1100px; margin:auto; ">

   <h2 style="margin: 50px 0;">HR 사원 통계정보(차트)</h2>
   
   <form name="searchFrm" style="margin: 20px 0 50px 0; ">
      <select name="searchType" id="searchType" style="height: 30px;">
         <option value="">통계선택하세요</option>
         <option value="deptname">부서별 인원통계</option>
         <option value="gender">성별 인원통계</option>
         <option value="genderHireYear">성별 입사년도별 통계</option>
         <option value="deptnameGender">부서별 성별 인원통계</option>
      </select>
   </form>
   
   <div id="chart_container"></div>
   <div id="table_container" style="margin: 40px 0 0 0;"></div>

</div>
</div>



<script type="text/javascript">

	$(document).ready(function(){
		
		// select 의 값이 변경되면 실행해라 
		$("select#searchType").change(function(){
			func_choice($(this).val());   // 고른 select 의 val을 넣음
			// $(this).val() 은 "" 또는 "deptname" 또는 "gender" 또는 "genderHireYear" 또는 "deptnameGender" 이다.
		})
		
	});
	
	// Function Declaration
	function func_choice(searchTypeVal) {
		
		switch (searchTypeVal) {
		case "":    // 통계선택하세요 를 선택한 경우 
			$("div#chart_container").empty();    // 초기화 하기 
			$("div#table_container").empty();    // 초기화 하기 
			$("div.highcharts-data-table").empty();    // 초기화 하기 (view data table 누른것을 안보이게)
			
			break;
			
		case "deptname":     // 부서별 인원통계 를 선택한 경우   
			
			$.ajax({
				url:"<%= ctxPath%>/chart/employeeCntByDeptname.action",
				dataType: "json",
				success:function(json){
					//console.log(JSON.stringify(json));
					/*
						[{"department_name":"Shipping","cnt":"45","percentage":"40.54"}
						,{"department_name":"Sales","cnt":"34","percentage":"30.63"}
						,{"department_name":"IT","cnt":"9","percentage":"8.11"}
						,{"department_name":"Finance","cnt":"6","percentage":"5.41"}
						,{"department_name":"Purchasing","cnt":"6","percentage":"5.41"}
						,{"department_name":"Executive","cnt":"3","percentage":"2.7"}
						,{"department_name":"Accounting","cnt":"2","percentage":"1.8"}
						,{"department_name":"Marketing","cnt":"2","percentage":"1.8"}
						,{"department_name":"Administration","cnt":"1","percentage":"0.9"}
						,{"department_name":"Human Resources","cnt":"1","percentage":"0.9"}
						,{"department_name":"Public Relations","cnt":"1","percentage":"0.9"}
						,{"department_name":"부서없음","cnt":"1","percentage":"0.9"}]
					*/
					
					$("div#chart_container").empty();    // 초기화 하기 
					$("div#table_container").empty();    // 초기화 하기 
					$("div.highcharts-data-table").empty();    // 초기화 하기 (view data table 누른것을 안보이게)
					
					let resultArr = [];  // 배열로 만들기 위해 
					
					for(let i=0; i< json.length; i++){
						let obj;
						
						if(i==0){
							obj = {name : json[i].department_name
									     ,y : Number(json[i].percentage)
									     ,sliced: true
									     ,selected: true};    // 자바스크립트의 객체
						}
						else{
							obj = {name : json[i].department_name
								  ,y : Number(json[i].percentage)};    // 자바스크립트의 객체
						}
						
						resultArr.push(obj);   //obj 를 push 한다. 값이 쌓인다
						
					}// end of for 
					
					///////////////////////차트그리기 부분 //////////////////////////// 
					Highcharts.chart('chart_container', {
					    chart: {
					        plotBackgroundColor: null,
					        plotBorderWidth: null,
					        plotShadow: false,
					        type: 'pie'
					    },
					    title: {
					        text: '우리회사 부서별 인원통계',
					        align: 'center'
					    },
					    tooltip: {
					        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
					    },
					    accessibility: {
					        point: {
					            valueSuffix: '%'
					        }
					    },
					    plotOptions: {
					        pie: {
					            allowPointSelect: true,
					            cursor: 'pointer',
					            dataLabels: {
					                enabled: true,
					                format: '<b>{point.name}</b>: {point.percentage:.2f} %'  /* 1f는 소수부 첫쩨자리, 2f는 소수부 줄째자리  */
					            }
					        }
					    }, 
					    series: [{
					        name: '인원비율',
					        colorByPoint: true,
					        data: resultArr
					    }]
					}); 
					///////////////////////////////////////////////////
					
					let html =  "<table>";
					    html += "<tr>" +
					    		   "<th>부서명</th>"  +
					    		   "<th>인원수</th>"  +
					    		   "<th>퍼센티지</th>"  +
					    		"</tr>";
					   
					 $.each(json, function(index, item){
						 html += "<tr>" +
						              "<td>" + item.department_name + "</td>" +
						              "<td>" + item.cnt + "</td>" +
						              "<td>" + Number(item.percentage) + "</td>" +
						         "</tr>";     

					 });
					 
					 html += "</table>";
					 
					 $("div#table_container").html(html);   // html 출력
					
				},
				error: function(request, status, error){
	                alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
	             }
			});
				
			break;


		case "gender":    // 성별 인원통계 를 선택한 경우 
			
			$.ajax({
				url:"<%= ctxPath%>/chart/employeeCntByGender.action",
				dataType: "json",
				success:function(json){
					//console.log(JSON.stringify(json));
					/*
						[{"gender":"남","cnt":"58","percentage":"52.25"}
						,{"gender":"여","cnt":"53","percentage":"47.75"}]
					*/
					
					$("div#chart_container").empty();    // 초기화 하기 
					$("div#table_container").empty();    // 초기화 하기 
					$("div.highcharts-data-table").empty();    // 초기화 하기 (view data table 누른것을 안보이게)
					
					let resultArr = [];  // 배열로 만들기 위해 
					
					for(let i=0; i< json.length; i++){
						let obj;
						
						if(i==0){
							obj = {name : json[i].gender
									     ,y : Number(json[i].percentage)
									     ,sliced: true
									     ,selected: true};    // 자바스크립트의 객체
						}
						else{
							obj = {name : json[i].gender
								  ,y : Number(json[i].percentage)};    // 자바스크립트의 객체
						}
						
						resultArr.push(obj);   //obj 를 push 한다. 값이 쌓인다
						
					}// end of for 
					
					///////////////////////차트그리기 부분 //////////////////////////// 
					Highcharts.chart('chart_container', {
					    chart: {
					        plotBackgroundColor: null,
					        plotBorderWidth: null,
					        plotShadow: false,
					        type: 'pie'
					    },
					    title: {
					        text: '우리회사 성별 인원통계',
					        align: 'center'
					    },
					    tooltip: {
					        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
					    },
					    accessibility: {
					        point: {
					            valueSuffix: '%'
					        }
					    },
					    plotOptions: {
					        pie: {
					            allowPointSelect: true,
					            cursor: 'pointer',
					            dataLabels: {
					                enabled: true,
					                format: '<b>{point.name}</b>: {point.percentage:.2f} %'  /* 1f는 소수부 첫쩨자리, 2f는 소수부 줄째자리  */
					            }
					        }
					    }, 
					    series: [{
					        name: '인원비율',
					        colorByPoint: true,
					        data: resultArr
					    }]
					}); 
					///////////////////////////////////////////////////
					
					let html =  "<table>";
					    html += "<tr>" +
					    		   "<th>성별</th>"  +
					    		   "<th>인원수</th>"  +
					    		   "<th>퍼센티지</th>"  +
					    		"</tr>";
					   
					 $.each(json, function(index, item){
						 html += "<tr>" +
						              "<td>" + item.gender + "</td>" +
						              "<td>" + item.cnt + "</td>" +
						              "<td>" + Number(item.percentage) + "</td>" +
						         "</tr>";     

					 });
					 
					 html += "</table>";
					 
					 $("div#table_container").html(html);   // html 출력
					
				},
				error: function(request, status, error){
	                alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
	             }
			});
		
		
		
			break;
		
					
		case "genderHireYear":    // 성별 입사년도별 통계 를 선택한 경우 
			
			$.ajax({
				url:"<%= ctxPath%>/chart/employeeCntByGenderHireYear.action",
				dataType: "json",
				success:function(json){
					//console.log(JSON.stringify(json));
					/*
						[{"gender":"남","Y2001":"0","Y2002":"2","Y2003":"4","Y2004":"4","Y2005":"15","Y2006":"17","Y2007":"8","Y2008":"6"}
						,{"gender":"여","Y2001":"1","Y2002":"5","Y2003":"2","Y2004":"6","Y2005":"14","Y2006":"7","Y2007":"11","Y2008":"5"}]
					*/
					
					$("div#chart_container").empty();    // 초기화 하기 
					$("div#table_container").empty();    // 초기화 하기 
					$("div.highcharts-data-table").empty();    // 초기화 하기 (view data table 누른것을 안보이게)
					
					let resultArr = [];  // 배열로 시작 
					
					for(let i = 0; i < json.length; i++) {   //남, 여 두번 만 반복
						let hireYear_arr = [];
						hireYear_arr.push(Number(json[i].Y2001));
						hireYear_arr.push(Number(json[i].Y2002));
						hireYear_arr.push(Number(json[i].Y2003));
						hireYear_arr.push(Number(json[i].Y2004));
						hireYear_arr.push(Number(json[i].Y2005));
						hireYear_arr.push(Number(json[i].Y2006));
						hireYear_arr.push(Number(json[i].Y2007));
						hireYear_arr.push(Number(json[i].Y2008));
						
						let obj = {name: json[i].gender ,
					               data: hireYear_arr};
						
						resultArr.push(obj);    // 배열속에 객체를 넣기 
					
					}// end of for 
					
					Highcharts.chart('chart_container', {

					    title: {
					        text: '2001년 ~ 2008년 우리회사 성별 입사년도별 입사 인원수'
					    },

					    subtitle: {
					        text: 'Source: <a href="http://localhost:9090/board/emp/empList.action" target="_blank">HR.employees</a>'
					    },

					    yAxis: {
					        title: {
					            text: '입사 인원수'
					        }
					    },

					    xAxis: {
					        accessibility: {
					            rangeDescription: '범위: 2001 to 2008'
					        }
					    },

					    legend: {
					        layout: 'vertical',
					        align: 'right',
					        verticalAlign: 'middle'
					    },

					    plotOptions: {
					        series: {
					            label: {
					                connectorAllowed: false
					            },
					            pointStart: 2001
					        }
					    },

					    series: resultArr,

					    responsive: {
					        rules: [{
					            condition: {
					                maxWidth: 500
					            },
					            chartOptions: {
					                legend: {
					                    layout: 'horizontal',
					                    align: 'center',
					                    verticalAlign: 'bottom'
					                }
					            }
					        }]
					    }

					});
					
					//////////////////////////////////////////////////////////
					
					let html =  "<table>";
                    html += "<tr>" +
                              "<th>성별</th>" +
                              "<th>2001년</th>" +
                              "<th>2002년</th>" +
                              "<th>2003년</th>" +
                              "<th>2004년</th>" +
                              "<th>2005년</th>" +
                              "<th>2006년</th>" +
                              "<th>2007년</th>" +
                              "<th>2008년</th>" +
                            "</tr>";
           
	                $.each(json, function(index, item){
	                   html += "<tr>" +
	                               "<td>"+ item.gender +"</td>" +
	                               "<td>"+ item.Y2001 +"</td>" +
	                               "<td>"+ item.Y2002 +"</td>" +
	                               "<td>"+ item.Y2003 +"</td>" +
	                               "<td>"+ item.Y2004 +"</td>" +
	                               "<td>"+ item.Y2005 +"</td>" +
	                               "<td>"+ item.Y2006 +"</td>" +
	                               "<td>"+ item.Y2007 +"</td>" +
	                               "<td>"+ item.Y2008 +"</td>" +
	                           "</tr>";
	                });        
	                        
	                html += "</table>";
	                
	                $("div#table_container").html(html);
					
				},
				error: function(request, status, error){
	                alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
	             }
			});
		
		
		
			break;
		
			
		case "deptnameGender":    // 부서별 성별 인원통계를 선택한 경우 
			
			$.ajax({
				url:"<%= ctxPath%>/chart/employeeCntByDeptname.action",
				dataType:"json",
				success:function(json1){
					
					//console.log(JSON.stringify(json1));
					/*
						[{"department_name":"Shipping","cnt":"45","percentage":"40.54"}
						,{"department_name":"Sales","cnt":"34","percentage":"30.63"}
						,{"department_name":"IT","cnt":"9","percentage":"8.11"}
						,{"department_name":"Finance","cnt":"6","percentage":"5.41"}
						,{"department_name":"Purchasing","cnt":"6","percentage":"5.41"}
						,{"department_name":"Executive","cnt":"3","percentage":"2.7"}
						,{"department_name":"Accounting","cnt":"2","percentage":"1.8"}
						,{"department_name":"Marketing","cnt":"2","percentage":"1.8"}
						,{"department_name":"Administration","cnt":"1","percentage":"0.9"}
						,{"department_name":"Human Resources","cnt":"1","percentage":"0.9"}
						,{"department_name":"Public Relations","cnt":"1","percentage":"0.9"}
						,{"department_name":"부서없음","cnt":"1","percentage":"0.9"}]
					*/
					
					$("div#chart_container").empty();    // 초기화 하기 
					$("div#table_container").empty();    // 초기화 하기 
					$("div.highcharts-data-table").empty();    // 초기화 하기 (view data table 누른것을 안보이게)
					
					let deptnameArr = [];  // 부서명별 인원수 퍼센티지 객체 배열
					
					// 반복문 
					$.each(json1, function(index, item){
						deptnameArr.push({name: item.department_name,
					                      y: Number(item.percentage),
					                      drilldown: item.department_name});
					}); // end of $.each(json, function(index, item)
						
							
					let genderArr = [];	// 특정 부서명에 근무하는 직원들의 성별 인원수 퍼센티지 객체 배열 	 
							
					// 반복문 
					$.each(json1, function(index1, item1){
						
						$.ajax({
							url:"<%= ctxPath%>/chart/genderCntSpecialDeptname.action",
							type:"get",
							data:{"deptname":item1.department_name},
							dataType:"json",
							success:function(json2){
								
							  //console.log(JSON.stringify(json2));
							  /*
		    				     [{"gender":"남","cnt":"4","percentage":"3.6"}
		    				     ,{"gender":"여","cnt":"2","percentage":"1.8"}]
		    				  */
								
								let subArr = [];  // 배열로 사용하기 위해 
								
								$.each(json2, function(index2, item2){
									subArr.push([
										item2.gender,
										Number(item2.percentage)
									]);
								}); // end of $.each(json2, function(index2, item2)
								
								genderArr.push({
					                
									name: item1.department_name,
					                id: item1.department_name,
					                data: subArr
								});
							
							},
							error: function(request, status, error){
				                alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
				            }
							
						});
						
						
					}); // end of $.each(json, function(index1, item1)
						
				
					
					
					/////////////////////////////차트에 관련 시작///////////////////////////////////////////
					
					Highcharts.chart('chart_container', {
					    chart: {
					        type: 'column'
					    },
					    title: {
					        align: 'center',
					        text: '부서별 남녀 비율'
					    },
					    subtitle: {
					        align: 'left',
					        text: 'Click the columns to view versions. Source: <a href="http://localhost:9090/board/emp/empList.action" target="_blank">HR.employees</a>'
					    },
					    accessibility: {
					        announceNewData: {
					            enabled: true
					        }
					    },
					    xAxis: {
					        type: 'category'
					    },
					    yAxis: {
					        title: {
					            text: '구성비율(%)'
					        }

					    },
					    legend: {
					        enabled: false
					    },
					    plotOptions: {
					        series: {
					            borderWidth: 0,
					            dataLabels: {
					                enabled: true,
					                format: '{point.y:.1f}%'
					            }
					        }
					    },

					    tooltip: {
					        headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
					        pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>'
					    },

					    series: [
					        {
					            name: '부서명',
					            colorByPoint: true,
					            data: deptnameArr   // **** 위에서 구한 값을 대입시킴. 부서명별 인원수 퍼센티지 객체 배열  ****
					        }
					    ],
					    drilldown: {
					        breadcrumbs: {
					            position: {
					                align: 'right'
					            }
					        },
					        series: genderArr // **** 위에서 구한 값을 대입시킴. 특정 부서명에 근무하는 직원들의 성별 인원수 퍼센티지 객체 배열  ****
					            
					            
					        
					    }
					});
					//////////////////////////////차트에 관련 끝///////////////////////////////////////
				},
				error: function(request, status, error){
	                alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
	            }
				
			}); // end of AJAX
			
		
		
			break;

		}
		
	}// end of function func_choice(searchTypeVal)....
	

</script>
