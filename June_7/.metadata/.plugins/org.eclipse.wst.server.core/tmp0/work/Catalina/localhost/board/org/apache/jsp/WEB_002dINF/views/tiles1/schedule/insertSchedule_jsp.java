/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.72
 * Generated at: 2023-06-01 00:59:51 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.tiles1.schedule;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class insertSchedule_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/C:/NCS/workspace(spring)/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Board/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1683599588119L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fchoose;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fotherwise;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fchoose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fotherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fchoose.release();
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fotherwise.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 
   String ctxPath = request.getContextPath(); 
   //    /board

      out.write("    \r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("	table#schedule{\r\n");
      out.write("		margin-top: 70px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	table#schedule th, td{\r\n");
      out.write("	 	padding: 10px 5px;\r\n");
      out.write("	 	vertical-align: middle;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	select.schedule{\r\n");
      out.write("		height: 30px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	input#joinUserName:focus{\r\n");
      out.write("		outline: none;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	span.plusUser{\r\n");
      out.write("			float:left; \r\n");
      out.write("			background-color:#737373; \r\n");
      out.write("			color:white;\r\n");
      out.write("			border-radius: 10%;\r\n");
      out.write("			padding: 8px;\r\n");
      out.write("			margin: 3px;\r\n");
      out.write("			transition: .8s;\r\n");
      out.write("			margin-top: 6px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	span.plusUser > i {\r\n");
      out.write("		cursor: pointer;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.ui-autocomplete {\r\n");
      out.write("		max-height: 100px;\r\n");
      out.write("		overflow-y: auto;\r\n");
      out.write("	}\r\n");
      out.write("	  \r\n");
      out.write("	button.btn_normal{\r\n");
      out.write("		border: none;\r\n");
      out.write("		color: white;\r\n");
      out.write("		width: 70px;\r\n");
      out.write("		height: 30px;\r\n");
      out.write("		font-size: 12pt;\r\n");
      out.write("		padding: 3px 0px;\r\n");
      out.write("		border-radius: 10%;\r\n");
      out.write("	}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("	$(document).ready(function(){\r\n");
      out.write("		\r\n");
      out.write("		// 캘린더 소분류 카테고리 숨기기\r\n");
      out.write("		$(\"select.small_category\").hide();\r\n");
      out.write("		\r\n");
      out.write("		// === *** 달력(type=\"date\") 관련 시작 *** === //\r\n");
      out.write("		// 시작시간, 종료시간		\r\n");
      out.write("		var html=\"\";\r\n");
      out.write("		for(var i=0; i<24; i++){\r\n");
      out.write("			if(i<10){\r\n");
      out.write("				html+=\"<option value='0\"+i+\"'>0\"+i+\"</option>\";\r\n");
      out.write("			}\r\n");
      out.write("			else{\r\n");
      out.write("				html+=\"<option value=\"+i+\">\"+i+\"</option>\";\r\n");
      out.write("			}\r\n");
      out.write("		}// end of for----------------------\r\n");
      out.write("		\r\n");
      out.write("		$(\"select#startHour\").html(html);\r\n");
      out.write("		$(\"select#endHour\").html(html);\r\n");
      out.write("		\r\n");
      out.write("		// 시작분, 종료분 \r\n");
      out.write("		html=\"\";\r\n");
      out.write("		for(var i=0; i<60; i=i+5){\r\n");
      out.write("			if(i<10){\r\n");
      out.write("				html+=\"<option value='0\"+i+\"'>0\"+i+\"</option>\";\r\n");
      out.write("			}\r\n");
      out.write("			else {\r\n");
      out.write("				html+=\"<option value=\"+i+\">\"+i+\"</option>\";\r\n");
      out.write("			}\r\n");
      out.write("		}// end of for--------------------\r\n");
      out.write("		html+=\"<option value=\"+59+\">\"+59+\"</option>\"\r\n");
      out.write("		\r\n");
      out.write("		$(\"select#startMinute\").html(html);\r\n");
      out.write("		$(\"select#endMinute\").html(html);\r\n");
      out.write("		// === *** 달력(type=\"date\") 관련 끝 *** === //\r\n");
      out.write("		\r\n");
      out.write("		// '종일' 체크박스 클릭시\r\n");
      out.write("		$(\"input#allDay\").click(function() {\r\n");
      out.write("			var bool = $('input#allDay').prop(\"checked\");\r\n");
      out.write("			\r\n");
      out.write("			if(bool == true) {\r\n");
      out.write("				$(\"select#startHour\").val(\"00\");\r\n");
      out.write("				$(\"select#startMinute\").val(\"00\");\r\n");
      out.write("				$(\"select#endHour\").val(\"23\");\r\n");
      out.write("				$(\"select#endMinute\").val(\"59\");\r\n");
      out.write("				$(\"select#startHour\").prop(\"disabled\",true);\r\n");
      out.write("				$(\"select#startMinute\").prop(\"disabled\",true);\r\n");
      out.write("				$(\"select#endHour\").prop(\"disabled\",true);\r\n");
      out.write("				$(\"select#endMinute\").prop(\"disabled\",true);\r\n");
      out.write("			} \r\n");
      out.write("			else {\r\n");
      out.write("				$(\"select#startHour\").prop(\"disabled\",false);\r\n");
      out.write("				$(\"select#startMinute\").prop(\"disabled\",false);\r\n");
      out.write("				$(\"select#endHour\").prop(\"disabled\",false);\r\n");
      out.write("				$(\"select#endMinute\").prop(\"disabled\",false);\r\n");
      out.write("			}\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("				\r\n");
      out.write("		// 내캘린더,사내캘린더 선택에 따른 서브캘린더 종류를 알아와서 select 태그에 넣어주기 \r\n");
      out.write("		$(\"select.calType\").change(function(){\r\n");
      out.write("			var fk_lgcatgono = $(\"select.calType\").val();      // 내캘린더이라면 1, 사내캘린더이라면 2 이다.\r\n");
      out.write("			var fk_userid = $(\"input[name=fk_userid]\").val();  // 로그인 된 사용자아이디\r\n");
      out.write("			\r\n");
      out.write("			if(fk_lgcatgono != \"\") { // 선택하세요 가 아니라면\r\n");
      out.write("				$.ajax({\r\n");
      out.write("						url: \"");
      out.print( ctxPath);
      out.write("/schedule/selectSmallCategory.action\",\r\n");
      out.write("						data: {\"fk_lgcatgono\":fk_lgcatgono, \r\n");
      out.write("							   \"fk_userid\":fk_userid},\r\n");
      out.write("						dataType: \"json\",\r\n");
      out.write("						success:function(json){\r\n");
      out.write("							var html =\"\";\r\n");
      out.write("							if(json.length>0){\r\n");
      out.write("								\r\n");
      out.write("								$.each(json, function(index, item){\r\n");
      out.write("									html+=\"<option value='\"+item.smcatgono+\"'>\"+item.smcatgoname+\"</option>\"\r\n");
      out.write("								});\r\n");
      out.write("								$(\"select.small_category\").html(html);\r\n");
      out.write("								$(\"select.small_category\").show();\r\n");
      out.write("							}\r\n");
      out.write("						},\r\n");
      out.write("						error: function(request, status, error){\r\n");
      out.write("				            alert(\"code: \"+request.status+\"\\n\"+\"message: \"+request.responseText+\"\\n\"+\"error: \"+error);\r\n");
      out.write("						}\r\n");
      out.write("				});\r\n");
      out.write("			}\r\n");
      out.write("			\r\n");
      out.write("			else {\r\n");
      out.write("				// 선택하세요 이라면\r\n");
      out.write("				$(\"select.small_category\").hide();\r\n");
      out.write("			}\r\n");
      out.write("			\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		// 공유자 추가하기\r\n");
      out.write("		$(\"input#joinUserName\").bind(\"keyup\",function(){\r\n");
      out.write("				var joinUserName = $(this).val();\r\n");
      out.write("			//	console.log(\"확인용 joinUserName : \" + joinUserName);\r\n");
      out.write("				$.ajax({\r\n");
      out.write("					url:\"");
      out.print( ctxPath);
      out.write("/schedule/insertSchedule/searchJoinUserList.action\",\r\n");
      out.write("					data:{\"joinUserName\":joinUserName},\r\n");
      out.write("					dataType:\"json\",\r\n");
      out.write("					success : function(json){\r\n");
      out.write("						var joinUserArr = [];\r\n");
      out.write("				    \r\n");
      out.write("					//  input태그 공유자입력란에 \"이\" 를 입력해본 결과를 json.length 값이 얼마 나오는지 알아본다. \r\n");
      out.write("					//	console.log(json.length);\r\n");
      out.write("					\r\n");
      out.write("						if(json.length > 0){\r\n");
      out.write("							\r\n");
      out.write("							$.each(json, function(index,item){\r\n");
      out.write("								var name = item.name;\r\n");
      out.write("								if(name.includes(joinUserName)){ // name 이라는 문자열에 joinUserName 라는 문자열이 포함된 경우라면 true , \r\n");
      out.write("									                             // name 이라는 문자열에 joinUserName 라는 문자열이 포함되지 않은 경우라면 false \r\n");
      out.write("								   joinUserArr.push(name+\"(\"+item.userid+\")\");\r\n");
      out.write("								}\r\n");
      out.write("							});\r\n");
      out.write("							\r\n");
      out.write("							$(\"input#joinUserName\").autocomplete({  // 참조 https://jqueryui.com/autocomplete/#default\r\n");
      out.write("								source:joinUserArr,\r\n");
      out.write("								select: function(event, ui) {       // 자동완성 되어 나온 공유자이름을 마우스로 클릭할 경우 \r\n");
      out.write("									add_joinUser(ui.item.value);    // 아래에서 만들어 두었던 add_joinUser(value) 함수 호출하기 \r\n");
      out.write("									                                // ui.item.value 이  선택한이름 이다.\r\n");
      out.write("									return false;\r\n");
      out.write("						        },\r\n");
      out.write("						        focus: function(event, ui) {\r\n");
      out.write("						            return false;\r\n");
      out.write("						        }\r\n");
      out.write("							}); \r\n");
      out.write("							\r\n");
      out.write("						}// end of if------------------------------------\r\n");
      out.write("					}// end of success-----------------------------------\r\n");
      out.write("				});\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("\r\n");
      out.write("		// x아이콘 클릭시 공유자 제거하기\r\n");
      out.write("		$(document).on('click','div.displayUserList > span.plusUser > i',function(){\r\n");
      out.write("				var text = $(this).parent().text(); // 이순신(leess/leesunsin@naver.com)\r\n");
      out.write("				\r\n");
      out.write("				var bool = confirm(\"공유자 목록에서 \"+ text +\" 회원을 삭제하시겠습니까?\");\r\n");
      out.write("				// 공유자 목록에서 이순신(leess/leesunsin@naver.com) 회원을 삭제하시겠습니까?\r\n");
      out.write("				\r\n");
      out.write("				if(bool) {\r\n");
      out.write("					$(this).parent().remove();\r\n");
      out.write("				}\r\n");
      out.write("		});\r\n");
      out.write("\r\n");
      out.write("		\r\n");
      out.write("		// 등록 버튼 클릭\r\n");
      out.write("		$(\"button#register\").click(function(){\r\n");
      out.write("		\r\n");
      out.write("			// 일자 유효성 검사 (시작일자가 종료일자 보다 크면 안된다!!)\r\n");
      out.write("			var startDate = $(\"input#startDate\").val();	\r\n");
      out.write("	    	var sArr = startDate.split(\"-\");\r\n");
      out.write("	    	startDate= \"\";	\r\n");
      out.write("	    	for(var i=0; i<sArr.length; i++){\r\n");
      out.write("	    		startDate += sArr[i];\r\n");
      out.write("	    	}\r\n");
      out.write("	    	\r\n");
      out.write("	    	var endDate = $(\"input#endDate\").val();	\r\n");
      out.write("	    	var eArr = endDate.split(\"-\");   \r\n");
      out.write("	     	var endDate= \"\";\r\n");
      out.write("	     	for(var i=0; i<eArr.length; i++){\r\n");
      out.write("	     		endDate += eArr[i];\r\n");
      out.write("	     	}\r\n");
      out.write("			\r\n");
      out.write("	     	var startHour= $(\"select#startHour\").val();\r\n");
      out.write("	     	var endHour = $(\"select#endHour\").val();\r\n");
      out.write("	     	var startMinute= $(\"select#startMinute\").val();\r\n");
      out.write("	     	var endMinute= $(\"select#endMinute\").val();\r\n");
      out.write("	        \r\n");
      out.write("	     	// 조회기간 시작일자가 종료일자 보다 크면 경고\r\n");
      out.write("	        if (Number(endDate) - Number(startDate) < 0) {\r\n");
      out.write("	         	alert(\"종료일이 시작일 보다 작습니다.\"); \r\n");
      out.write("	         	return;\r\n");
      out.write("	        }\r\n");
      out.write("	        \r\n");
      out.write("	     	// 시작일과 종료일 같을 때 시간과 분에 대한 유효성 검사\r\n");
      out.write("	        else if(Number(endDate) == Number(startDate)) {\r\n");
      out.write("	        	\r\n");
      out.write("	        	if(Number(startHour) > Number(endHour)){\r\n");
      out.write("	        		alert(\"종료일이 시작일 보다 작습니다.\"); \r\n");
      out.write("	        		return;\r\n");
      out.write("	        	}\r\n");
      out.write("	        	else if(Number(startHour) == Number(endHour)){\r\n");
      out.write("	        		if(Number(startMinute) > Number(endMinute)){\r\n");
      out.write("	        			alert(\"종료일이 시작일 보다 작습니다.\"); \r\n");
      out.write("	        			return;\r\n");
      out.write("	        		}\r\n");
      out.write("	        		else if(Number(startMinute) == Number(endMinute)){\r\n");
      out.write("	        			alert(\"시작일과 종료일이 동일합니다.\"); \r\n");
      out.write("	        			return;\r\n");
      out.write("	        		}\r\n");
      out.write("	        	}\r\n");
      out.write("	        }// end of else if---------------------------------\r\n");
      out.write("	    	\r\n");
      out.write("			// 제목 유효성 검사\r\n");
      out.write("			var subject = $(\"input#subject\").val().trim();\r\n");
      out.write("	        if(subject==\"\"){\r\n");
      out.write("				alert(\"제목을 입력하세요.\"); \r\n");
      out.write("				return;\r\n");
      out.write("			}\r\n");
      out.write("	        \r\n");
      out.write("	        // 캘린더 선택 유무 검사\r\n");
      out.write("			var calType = $(\"select.calType\").val().trim();\r\n");
      out.write("			if(calType==\"\"){\r\n");
      out.write("				alert(\"캘린더 종류를 선택하세요.\"); \r\n");
      out.write("				return;\r\n");
      out.write("			}\r\n");
      out.write("			\r\n");
      out.write("			// 달력 형태로 만들어야 한다.(시작일과 종료일)\r\n");
      out.write("			// 오라클에 들어갈 date 형식(년월일시분초)으로 만들기\r\n");
      out.write("			var sdate = startDate+$(\"select#startHour\").val()+$(\"select#startMinute\").val()+\"00\";\r\n");
      out.write("			var edate = endDate+$(\"select#endHour\").val()+$(\"select#endMinute\").val()+\"00\";\r\n");
      out.write("			\r\n");
      out.write("			$(\"input[name=startdate]\").val(sdate);\r\n");
      out.write("			$(\"input[name=enddate]\").val(edate);\r\n");
      out.write("		\r\n");
      out.write("		//	console.log(\"캘린더 소분류 번호 => \" + $(\"select[name=fk_smcatgono]\").val());\r\n");
      out.write("			/*\r\n");
      out.write("			      캘린더 소분류 번호 => 1 OR 캘린더 소분류 번호 => 2 OR 캘린더 소분류 번호 => 3 OR 캘린더 소분류 번호 => 4 \r\n");
      out.write("			*/\r\n");
      out.write("			\r\n");
      out.write("		//  console.log(\"색상 => \" + $(\"input#color\").val());\r\n");
      out.write("			\r\n");
      out.write("			// 공유자 넣어주기\r\n");
      out.write("			var plusUser_elm = document.querySelectorAll(\"div.displayUserList > span.plusUser\");\r\n");
      out.write("			var joinUserArr = new Array();\r\n");
      out.write("			\r\n");
      out.write("			plusUser_elm.forEach(function(item,index,array){\r\n");
      out.write("			//	console.log(item.innerText.trim());\r\n");
      out.write("				/*\r\n");
      out.write("					이순신(leess) \r\n");
      out.write("					아이유1(iyou1) \r\n");
      out.write("					설현(seolh) \r\n");
      out.write("				*/\r\n");
      out.write("				joinUserArr.push(item.innerText.trim());\r\n");
      out.write("			});\r\n");
      out.write("			\r\n");
      out.write("			var joinuser = joinUserArr.join(\",\");\r\n");
      out.write("		//	console.log(\"공유자 => \" + joinuser);\r\n");
      out.write("			// 이순신(leess),아이유1(iyou1),설현(seolh) \r\n");
      out.write("			\r\n");
      out.write("			$(\"input[name=joinuser]\").val(joinuser);\r\n");
      out.write("			\r\n");
      out.write("			var frm = document.scheduleFrm;\r\n");
      out.write("			frm.action=\"");
      out.print( ctxPath);
      out.write("/schedule/registerSchedule_end.action\";\r\n");
      out.write("			frm.method=\"post\";\r\n");
      out.write("			frm.submit();\r\n");
      out.write("\r\n");
      out.write("		});// end of $(\"button#register\").click(function(){})--------------------\r\n");
      out.write("		\r\n");
      out.write("	}); // end of $(document).ready(function(){}-----------------------------------\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	// ~~~~ Function Declaration ~~~~\r\n");
      out.write("	\r\n");
      out.write("	// div.displayUserList 에 공유자를 넣어주는 함수\r\n");
      out.write("	function add_joinUser(value){  // value 가 공유자로 선택한이름 이다.\r\n");
      out.write("		\r\n");
      out.write("		var plusUser_es = $(\"div.displayUserList > span.plusUser\").text();\r\n");
      out.write("	\r\n");
      out.write("	 // console.log(\"확인용 plusUser_es => \" + plusUser_es);\r\n");
      out.write("	    /*\r\n");
      out.write("	    	확인용 plusUser_es => \r\n");
      out.write(" 			확인용 plusUser_es => 이순신(leess/hanmailrg@naver.com)\r\n");
      out.write(" 			확인용 plusUser_es => 이순신(leess/hanmailrg@naver.com)아이유1(iyou1/younghak0959@naver.com)\r\n");
      out.write(" 			확인용 plusUser_es => 이순신(leess/hanmailrg@naver.com)아이유1(iyou1/younghak0959@naver.com)아이유2(iyou2/younghak0959@naver.com)\r\n");
      out.write("	    */\r\n");
      out.write("	\r\n");
      out.write("		if(plusUser_es.includes(value)) {  // plusUser_es 문자열 속에 value 문자열이 들어있다라면 \r\n");
      out.write("			alert(\"이미 추가한 회원입니다.\");\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		else {\r\n");
      out.write("			$(\"div.displayUserList\").append(\"<span class='plusUser'>\"+value+\"&nbsp;<i class='fas fa-times-circle'></i></span>\");\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		$(\"input#joinUserName\").val(\"\");\r\n");
      out.write("		\r\n");
      out.write("	}// end of function add_joinUser(value){}----------------------------			\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<div style=\"margin-left: 80px; width: 88%;\">\r\n");
      out.write("<h3>일정 등록</h3>\r\n");
      out.write("\r\n");
      out.write("	<form name=\"scheduleFrm\">\r\n");
      out.write("		<table id=\"schedule\" class=\"table table-bordered\">\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th>일자</th>\r\n");
      out.write("				<td>\r\n");
      out.write("					<input type=\"date\" id=\"startDate\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.chooseDate}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" style=\"height: 30px;\"/>&nbsp; \r\n");
      out.write("					<select id=\"startHour\" class=\"schedule\"></select> 시\r\n");
      out.write("					<select id=\"startMinute\" class=\"schedule\"></select> 분\r\n");
      out.write("					- <input type=\"date\" id=\"endDate\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.chooseDate}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" style=\"height: 30px;\"/>&nbsp;\r\n");
      out.write("					<select id=\"endHour\" class=\"schedule\"></select> 시\r\n");
      out.write("					<select id=\"endMinute\" class=\"schedule\"></select> 분&nbsp;\r\n");
      out.write("					<input type=\"checkbox\" id=\"allDay\"/>&nbsp;<label for=\"allDay\">종일</label>\r\n");
      out.write("					\r\n");
      out.write("					<input type=\"hidden\" name=\"startdate\"/>\r\n");
      out.write("					<input type=\"hidden\" name=\"enddate\"/>\r\n");
      out.write("				</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th>제목</th>\r\n");
      out.write("				<td><input type=\"text\" id=\"subject\" name=\"subject\" class=\"form-control\"/></td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th>캘린더선택</th>\r\n");
      out.write("				<td>\r\n");
      out.write("					<select class=\"calType schedule\" name=\"fk_lgcatgono\">\r\n");
      out.write("					");
      if (_jspx_meth_c_005fchoose_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("					</select> &nbsp;\r\n");
      out.write("					<select class=\"small_category schedule\" name=\"fk_smcatgono\"></select>\r\n");
      out.write("				</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th>색상</th>\r\n");
      out.write("				<td><input type=\"color\" id=\"color\" name=\"color\" value=\"#009900\"/></td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th>장소</th>\r\n");
      out.write("				<td><input type=\"text\" name=\"place\" class=\"form-control\"/></td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th>공유자</th>\r\n");
      out.write("				<td>\r\n");
      out.write("				<input type=\"text\" id=\"joinUserName\" class=\"form-control\" placeholder=\"일정을 공유할 회원명을 입력하세요\"/>\r\n");
      out.write("				<div class=\"displayUserList\"></div>\r\n");
      out.write("				<input type=\"hidden\" name=\"joinuser\"/>\r\n");
      out.write("				</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th>내용</th>\r\n");
      out.write("				<td><textarea rows=\"10\" cols=\"100\" style=\"height: 200px;\" name=\"content\" id=\"content\"  class=\"form-control\"></textarea></td>\r\n");
      out.write("			</tr>\r\n");
      out.write("		</table>\r\n");
      out.write("		<input type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loginuser.userid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" name=\"fk_userid\"/>\r\n");
      out.write("	</form>\r\n");
      out.write("	\r\n");
      out.write("	<div style=\"float: right;\">\r\n");
      out.write("	<button type=\"button\" id=\"register\" class=\"btn_normal\" style=\"margin-right: 10px; background-color: #0071bd;\">등록</button>\r\n");
      out.write("	<button type=\"button\" class=\"btn_normal\" style=\"background-color: #990000;\" onclick=\"javascript:location.href='");
      out.print( ctxPath);
      out.write("/schedule/scheduleManagement.action'\">취소</button> \r\n");
      out.write("	</div>\r\n");
      out.write("</div>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fchoose_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    boolean _jspx_th_c_005fchoose_005f0_reused = false;
    try {
      _jspx_th_c_005fchoose_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fchoose_005f0.setParent(null);
      int _jspx_eval_c_005fchoose_005f0 = _jspx_th_c_005fchoose_005f0.doStartTag();
      if (_jspx_eval_c_005fchoose_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("					");
          out.write(" \r\n");
          out.write("					");
          out.write(" \r\n");
          out.write("						");
          if (_jspx_meth_c_005fwhen_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
            return true;
          out.write("\r\n");
          out.write("					");
          out.write(" 	\r\n");
          out.write("						");
          if (_jspx_meth_c_005fotherwise_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
            return true;
          out.write("\r\n");
          out.write("					");
          int evalDoAfterBody = _jspx_th_c_005fchoose_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fchoose_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
      _jspx_th_c_005fchoose_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fchoose_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fchoose_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    boolean _jspx_th_c_005fwhen_005f0_reused = false;
    try {
      _jspx_th_c_005fwhen_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fwhen_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
      // /WEB-INF/views/tiles1/schedule/insertSchedule.jsp(386,6) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fwhen_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginuser.gradelevel =='10'}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fwhen_005f0 = _jspx_th_c_005fwhen_005f0.doStartTag();
      if (_jspx_eval_c_005fwhen_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write(" \r\n");
          out.write("							<option value=\"\">선택하세요</option>\r\n");
          out.write("							<option value=\"1\">내 캘린더</option>\r\n");
          out.write("							<option value=\"2\">사내 캘린더</option>\r\n");
          out.write("						");
          int evalDoAfterBody = _jspx_th_c_005fwhen_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fwhen_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
      _jspx_th_c_005fwhen_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fwhen_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fwhen_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fotherwise_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_005fotherwise_005f0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _005fjspx_005ftagPool_005fc_005fotherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    boolean _jspx_th_c_005fotherwise_005f0_reused = false;
    try {
      _jspx_th_c_005fotherwise_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fotherwise_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
      int _jspx_eval_c_005fotherwise_005f0 = _jspx_th_c_005fotherwise_005f0.doStartTag();
      if (_jspx_eval_c_005fotherwise_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("							<option value=\"\">선택하세요</option>\r\n");
          out.write("							<option value=\"1\">내 캘린더</option>\r\n");
          out.write("						");
          int evalDoAfterBody = _jspx_th_c_005fotherwise_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fotherwise_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
      _jspx_th_c_005fotherwise_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fotherwise_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fotherwise_005f0_reused);
    }
    return false;
  }
}
