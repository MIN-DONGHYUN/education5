/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.72
 * Generated at: 2023-05-10 07:08:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.tiles.tile2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class sideinfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 String ctxPath = request.getContextPath(); 
      out.write("\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("   \r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("   $(document).ready(function() {\r\n");
      out.write("      \r\n");
      out.write("	   loopshowNowTime();\r\n");
      out.write("	   \r\n");
      out.write("   }); // end of $(document).ready(); ---------------------------------\r\n");
      out.write("\r\n");
      out.write("   function showNowTime() {\r\n");
      out.write("      \r\n");
      out.write("      var now = new Date();\r\n");
      out.write("   \r\n");
      out.write("      var month = now.getMonth() + 1;\r\n");
      out.write("      if(month < 10) {\r\n");
      out.write("         month = \"0\"+month;\r\n");
      out.write("      }\r\n");
      out.write("      \r\n");
      out.write("      var date = now.getDate();\r\n");
      out.write("      if(date < 10) {\r\n");
      out.write("         date = \"0\"+date;\r\n");
      out.write("      }\r\n");
      out.write("      \r\n");
      out.write("      var strNow = now.getFullYear() + \"-\" + month + \"-\" + date;\r\n");
      out.write("      \r\n");
      out.write("      var hour = \"\";\r\n");
      out.write("       if(now.getHours() < 10) {\r\n");
      out.write("           hour = \"0\"+now.getHours();\r\n");
      out.write("       } \r\n");
      out.write("       else {\r\n");
      out.write("          hour = now.getHours();\r\n");
      out.write("       }\r\n");
      out.write("      \r\n");
      out.write("       \r\n");
      out.write("      var minute = \"\";\r\n");
      out.write("      if(now.getMinutes() < 10) {\r\n");
      out.write("         minute = \"0\"+now.getMinutes();\r\n");
      out.write("      } else {\r\n");
      out.write("         minute = now.getMinutes();\r\n");
      out.write("      }\r\n");
      out.write("      \r\n");
      out.write("      var second = \"\";\r\n");
      out.write("      if(now.getSeconds() < 10) {\r\n");
      out.write("         second = \"0\"+now.getSeconds();\r\n");
      out.write("      } else {\r\n");
      out.write("         second = now.getSeconds();\r\n");
      out.write("      }\r\n");
      out.write("      \r\n");
      out.write("      strNow += \" \"+hour + \":\" + minute + \":\" + second;\r\n");
      out.write("      \r\n");
      out.write("      $(\"span#clock\").html(strNow);\r\n");
      out.write("   \r\n");
      out.write("   }// end of function showNowTime() -----------------------------\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("   function loopshowNowTime() {\r\n");
      out.write("      showNowTime();\r\n");
      out.write("      \r\n");
      out.write("      var timejugi = 1000;   // 시간을 1초 마다 자동 갱신하려고.\r\n");
      out.write("      \r\n");
      out.write("      setTimeout(function() {\r\n");
      out.write("                  loopshowNowTime();   \r\n");
      out.write("               }, timejugi);\r\n");
      out.write("      \r\n");
      out.write("   }// end of loopshowNowTime() --------------------------\r\n");
      out.write("\r\n");
      out.write("   \r\n");
      out.write("   // ------ 기상청 날씨정보 공공API XML데이터 호출하기 -------- //\r\n");
      out.write("   \r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<div style=\"min-height: 1100px; margin-bottom: 50px;\">\r\n");
      out.write("   <div style=\"text-align: center; font-size: 16pt;\">\r\n");
      out.write("      현재시각 :&nbsp; <span id=\"clock\" style=\"color:green; font-weight:bold;\"></span>\r\n");
      out.write("   </div>\r\n");
      out.write("   \r\n");
      out.write("   <div id=\"displayWeather\" style=\"min-width: 90%; max-height: 500px; overflow-y: scroll; margin-top: 40px; margin-bottom: 70px; padding-left: 10px; padding-right: 10px;\"></div> \r\n");
      out.write("\r\n");
      out.write("   <div style=\"margin: 20px;\">\r\n");
      out.write("      ");
      out.write("\r\n");
      out.write("      <figure class=\"highcharts-figure\">\r\n");
      out.write("          <div id=\"chart_container\"></div>\r\n");
      out.write("      </figure> \r\n");
      out.write("   </div>\r\n");
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
}
