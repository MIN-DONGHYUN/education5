/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.72
 * Generated at: 2023-05-15 01:20:00 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.tiles1.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class edit_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("    \r\n");
      out.write(" \r\n");
      out.write("\r\n");

   String ctxPath = request.getContextPath();

      out.write("   \r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("  $(document).ready(function(){\r\n");
      out.write("     \r\n");
      out.write("	  // 완료 버튼\r\n");
      out.write("	  $(\"button#btnUpdate\").click(function(){\r\n");
      out.write("		 \r\n");
      out.write("		// 글제목 유효성 검사\r\n");
      out.write("         const subject = $(\"input#subject\").val().trim();\r\n");
      out.write("         if(subject == \"\") {\r\n");
      out.write("            alert(\"글제목을 입력하세요!!\");\r\n");
      out.write("            return;\r\n");
      out.write("         }\r\n");
      out.write("         \r\n");
      out.write("        // 글내용 유효성 검사(스마트 에디터 사용 안 할 경우)\r\n");
      out.write("         const content = $(\"textarea#content\").val().trim();\r\n");
      out.write("         if(content == \"\") {\r\n");
      out.write("            alert(\"글내용을 입력하세요!!\");\r\n");
      out.write("            return;\r\n");
      out.write("         }\r\n");
      out.write("         \r\n");
      out.write("        // 글암호 유효성 검사\r\n");
      out.write("         const pw = $(\"input#pw\").val();\r\n");
      out.write("         if(pw == \"\") {\r\n");
      out.write("            alert(\"글암호를 입력하세요!!\");\r\n");
      out.write("            return;\r\n");
      out.write("         }\r\n");
      out.write("         \r\n");
      out.write("         // 폼(form)을 전송(submit)\r\n");
      out.write("         const frm = document.editFrm;\r\n");
      out.write("         frm.method = \"POST\";\r\n");
      out.write("         frm.action = \"");
      out.print( ctxPath);
      out.write("/editEnd.action\";\r\n");
      out.write("         frm.submit();\r\n");
      out.write("		  \r\n");
      out.write("	  });\r\n");
      out.write("     \r\n");
      out.write("  });// end of $(document).ready(function(){})-------------------------------\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<div style=\"display: flex;\">\r\n");
      out.write("<div style=\"margin: auto; padding-left: 3%;\">\r\n");
      out.write("\r\n");
      out.write("<h2 style=\"margin-bottom: 30px;\">글수정</h2>\r\n");
      out.write("\r\n");
      out.write("<form name=\"editFrm\">\r\n");
      out.write("   <table style=\"width: 1024px\" class=\"table table-bordered\">\r\n");
      out.write("      <tr>\r\n");
      out.write("         <th style=\"width: 15%; background-color: #DDDDDD;\">성명</th>\r\n");
      out.write("         <td>       \r\n");
      out.write("            <input type=\"hidden\" name=\"seq\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.boardvo.seq}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" readonly/>   <!-- readonly는 읽기 전용, ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.boardvo.seq}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" 는 BoardVO에서 설정한것 가져옴 -->      \r\n");
      out.write("         	");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.boardvo.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("  <!-- ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.boardvo.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" 는 BoardVO에서 설정한것 가져옴 작성자  -->      \r\n");
      out.write("         </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      \r\n");
      out.write("      <tr>\r\n");
      out.write("         <th style=\"width: 15%; background-color: #DDDDDD;\">제목</th>\r\n");
      out.write("         <td>\r\n");
      out.write("              <input type=\"text\" name=\"subject\" id=\"subject\" size=\"100\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.boardvo.subject}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"/>  \r\n");
      out.write("         </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      \r\n");
      out.write("      <tr>\r\n");
      out.write("         <th style=\"width: 15%; background-color: #DDDDDD;\">내용</th>\r\n");
      out.write("         <td>\r\n");
      out.write("            <textarea Style=\"width: 100%; height: 612px;\" name=\"content\" id=\"content\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.boardvo.content}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</textarea>\r\n");
      out.write("         </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      \r\n");
      out.write("      <tr>\r\n");
      out.write("         <th style=\"width: 15%; background-color: #DDDDDD;\">글암호</th>\r\n");
      out.write("         <td>\r\n");
      out.write("             <input type=\"password\" name=\"pw\" id=\"pw\" />\r\n");
      out.write("         </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("   </table>\r\n");
      out.write("   \r\n");
      out.write("   <div style=\"margin: 20px;\">\r\n");
      out.write("      <button type=\"button\" class=\"btn btn-secondary btn-sm mr-3\" id=\"btnUpdate\">완료</button>\r\n");
      out.write("      <button type=\"button\" class=\"btn btn-secondary btn-sm\" onclick=\"javascript:history.back()\">취소</button>\r\n");
      out.write("   </div>\r\n");
      out.write("   \r\n");
      out.write("</form>   \r\n");
      out.write("</div>\r\n");
      out.write("</div>    ");
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
