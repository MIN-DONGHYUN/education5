/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.72
 * Generated at: 2023-05-10 03:37:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class test_005fform_005f3_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

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
  }

  public void _jspDestroy() {
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
      out.write("    \r\n");

	String ctxPath = request.getContextPath();
    //     /board

      out.write("\r\n");
      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("	table, th, td {\r\n");
      out.write("		border: solid 1px gray;\r\n");
      out.write("		border-collapse: collapse;;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print( ctxPath);
      out.write("/resources/js/jquery-3.6.4.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("	$(document).ready(function(){\r\n");
      out.write("		\r\n");
      out.write("		func_ajax_select();\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		// 확인 버튼 클릭시 \r\n");
      out.write("		$(\"button#btnOK\").click(function() {\r\n");
      out.write("			\r\n");
      out.write("			const no_val = $(\"input#no\").val();       // 이름이 no 인 것의 값을 no_val에 저장 \r\n");
      out.write("			const name_val = $(\"input#name\").val();\r\n");
      out.write("			\r\n");
      out.write("			if(no_val.trim() == \"\" || name_val.trim() == \"\") {  //두개중 한개라도 없다면\r\n");
      out.write("				alert(\"번호와 성명을 모두 입력하세요!!\");\r\n");
      out.write("				return;   							// 종료 \r\n");
      out.write("			}\r\n");
      out.write("			\r\n");
      out.write("			$.ajax({\r\n");
      out.write("				url:\"");
      out.print( ctxPath);
      out.write("/test/ajax_insert.action\",\r\n");
      out.write("				type:\"post\",\r\n");
      out.write("				data:{\"no\":no_val,\r\n");
      out.write("					  \"name\":name_val},\r\n");
      out.write("				dataType:\"json\",\r\n");
      out.write("				success:function(json) {\r\n");
      out.write("					\r\n");
      out.write("					console.log(\"====확인용 :  \" + JSON.stringify(json));   // JSON.stringify(json) 요고 잘 기억하자 제발~~~~\r\n");
      out.write("					// ==== 확인용 : {\"n\":1}\r\n");
      out.write("					\r\n");
      out.write("					if(json.n == 1) { //json의 n 값이 1이라면 \r\n");
      out.write("						func_ajax_select();    // 함수 호출 \r\n");
      out.write("						$(\"input#no\").val(\"\");    // 값 초기화 \r\n");
      out.write("						$(\"input#name\").val(\"\");\r\n");
      out.write("					}\r\n");
      out.write("				},\r\n");
      out.write("				error: function(request, status, error){\r\n");
      out.write("		            alert(\"code: \"+request.status+\"\\n\"+\"message: \"+request.responseText+\"\\n\"+\"error: \"+error);\r\n");
      out.write("		        }\r\n");
      out.write("			});\r\n");
      out.write("			\r\n");
      out.write("			\r\n");
      out.write("		}); // end of $(\"button#btnOK\").click() -----------------------------------------\r\n");
      out.write("\r\n");
      out.write("	}); // end of $(document).ready(function()\r\n");
      out.write("\r\n");
      out.write("			\r\n");
      out.write("	//function Declaration\r\n");
      out.write("	function func_ajax_select() {\r\n");
      out.write("		\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			url:\"");
      out.print( ctxPath);
      out.write("/test/ajax_select.action\",   \r\n");
      out.write("			dataType:\"json\",\r\n");
      out.write("		    success:function(json){\r\n");
      out.write("		    	console.log(JSON.stringify(json) + \" 확인용입니다.\")\r\n");
      out.write("		    	/* [{\"no\":\"601\",\"name\":\"이혜리\",\"writeday\":\"2023-05-10 11:50:49\"},\r\n");
      out.write("		    		{\"no\":\"204\",\"name\":\"민효린\",\"writeday\":\"2023-05-10 11:15:13\"},\r\n");
      out.write("		    		{\"no\":\"203\",\"name\":\"이지은\",\"writeday\":\"2023-05-10 10:51:06\"},\r\n");
      out.write("		    		{\"no\":\"202\",\"name\":\"이나영\",\"writeday\":\"2023-05-10 10:49:56\"},\r\n");
      out.write("		    		{\"no\":\"201\",\"name\":\"홍길동\",\"writeday\":\"2023-05-10 10:09:40\"}]\r\n");
      out.write("		    	*/\r\n");
      out.write("		    	\r\n");
      out.write("		    	let html = `<table>\r\n");
      out.write("		    	              <tr>\r\n");
      out.write("		    	                   <th>번호</th>\r\n");
      out.write("		    	                   <th>입력번호</th>\r\n");
      out.write("		    	                   <th>성명</th>\r\n");
      out.write("		    	                   <th>작성일자</th>\r\n");
      out.write("		    	              </tr>`;\r\n");
      out.write("		    	\r\n");
      out.write("		    	$.each(json, function(index, item){    // 결과물을 뿌리기 위해  반복문 \r\n");
      out.write("		    		html += `<tr>\r\n");
      out.write(" 	                              <td>${index+1}</td>\r\n");
      out.write(" 	                              <td>${item.no}</td>\r\n");
      out.write("			 	                  <td>${item.name}</td>\r\n");
      out.write("			 	                  <td>${item.writeday}</td>\r\n");
      out.write("			 	             </tr>`;\r\n");
      out.write("		    	})  \r\n");
      out.write("		    	\r\n");
      out.write("		    	html += `</table>`;\r\n");
      out.write("		    	\r\n");
      out.write("		    	$(\"div#view\").html(html);   // html 추가하기 \r\n");
      out.write("		    	\r\n");
      out.write("		    	// 백틱 사용\r\n");
      out.write("		    	\r\n");
      out.write("		    	\r\n");
      out.write("		    },\r\n");
      out.write("		    error: function(request, status, error){\r\n");
      out.write("	            alert(\"code: \"+request.status+\"\\n\"+\"message: \"+request.responseText+\"\\n\"+\"error: \"+error);\r\n");
      out.write("	        }\r\n");
      out.write("\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("	} // end of function func_ajax_select()\r\n");
      out.write("			\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("	<h2>Ajax 연습</h2>\r\n");
      out.write("	<p> 안녕하세요? <br> \r\n");
      out.write("		여기는 /board/test/test_form_3.action 페이지 입니다.\r\n");
      out.write("	</p>\r\n");
      out.write("	\r\n");
      out.write("	      번호 : <input type=\"text\" id=\"no\" /><br>\r\n");
      out.write("	      성명 : <input type=\"text\" id=\"name\" /><br>\r\n");
      out.write("	       <button type=\"button\" id=\"btnOK\">확인</button>\r\n");
      out.write("	       <button type=\"reset\" id=\"btnCancel\">취소</button>\r\n");
      out.write("    <br><br>\r\n");
      out.write("    \r\n");
      out.write("    <div id=\"view\"></div>\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
}