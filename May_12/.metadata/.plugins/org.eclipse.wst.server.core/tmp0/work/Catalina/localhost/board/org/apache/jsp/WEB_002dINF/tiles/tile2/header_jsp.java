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

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
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

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

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
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      out.write("\r\n");
      out.write('\r');
      out.write('\n');

	String ctxPath = request.getContextPath();

      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- 상단 네비게이션 시작 -->\r\n");
      out.write("	<nav class=\"navbar navbar-expand-lg navbar-light bg-light fixed-top mx-4 py-3\">\r\n");
      out.write("		<!-- Brand/logo --> \r\n");
      out.write("		<a class=\"navbar-brand\" href=\"");
      out.print( ctxPath );
      out.write("/index.action\" style=\"margin-right: 10%;\"><img src=\"");
      out.print( ctxPath );
      out.write("/resources/images/sist_logo.png\" /></a>\r\n");
      out.write("		\r\n");
      out.write("		<!-- 아코디언 같은 Navigation Bar 만들기 -->\r\n");
      out.write("	    <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapsibleNavbar\">\r\n");
      out.write("	      <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("	    </button>\r\n");
      out.write("		\r\n");
      out.write("		<div class=\"collapse navbar-collapse\" id=\"collapsibleNavbar\">\r\n");
      out.write("		  <ul class=\"navbar-nav h5\"> ");
      out.write("  \r\n");
      out.write("		     <li class=\"nav-item dropdown\">\r\n");
      out.write("		        <a class=\"nav-link dropdown-toggle text-info\" href=\"#\" id=\"navbarDropdown\" data-toggle=\"dropdown\">Home</a> \r\n");
      out.write("		                                     ");
      out.write("  \r\n");
      out.write("		        <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\r\n");
      out.write("		           <a class=\"dropdown-item\" href=\"");
      out.print( ctxPath );
      out.write("/index.action\">Home</a>\r\n");
      out.write("		        </div>\r\n");
      out.write("		     </li>\r\n");
      out.write("		     \r\n");
      out.write("		     <li class=\"nav-item dropdown\">\r\n");
      out.write("		        <a class=\"nav-link dropdown-toggle text-info\" href=\"#\" id=\"navbarDropdown\" data-toggle=\"dropdown\">로그인</a>  \r\n");
      out.write("		        <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\r\n");
      out.write("		           ");
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      boolean _jspx_th_c_005fif_005f0_reused = false;
      try {
        _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
        _jspx_th_c_005fif_005f0.setParent(null);
        // /WEB-INF/tiles/tile2/header.jsp(34,13) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty sessionScope.loginuser}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
        int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
        if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("			           <a class=\"dropdown-item\" href=\"#\">회원가입</a>\r\n");
            out.write("			           <a class=\"dropdown-item\" href=\"");
            out.print(ctxPath);
            out.write("/login.action\">로그인</a>\r\n");
            out.write("		           ");
            int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
        _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
        _jspx_th_c_005fif_005f0_reused = true;
      } finally {
        org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
      }
      out.write("\r\n");
      out.write("		           				\r\n");
      out.write("				   ");
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      boolean _jspx_th_c_005fif_005f1_reused = false;
      try {
        _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
        _jspx_th_c_005fif_005f1.setParent(null);
        // /WEB-INF/tiles/tile2/header.jsp(39,7) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty sessionScope.loginuser}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
        int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
        if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("					   <a class=\"dropdown-item\" href=\"#\">나의정보</a>\r\n");
            out.write("					   <a class=\"dropdown-item\" href=\"");
            out.print(ctxPath);
            out.write("/logout.action\">로그아웃</a>\r\n");
            out.write("				   ");
            int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
        _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
        _jspx_th_c_005fif_005f1_reused = true;
      } finally {
        org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f1_reused);
      }
      out.write("\r\n");
      out.write("		        </div>\r\n");
      out.write("		     </li>\r\n");
      out.write("		  \r\n");
      out.write("	 		<li class=\"nav-item dropdown\">\r\n");
      out.write("		        <a class=\"nav-link dropdown-toggle text-info\" href=\"#\" id=\"navbarDropdown\" data-toggle=\"dropdown\">인사관리</a>  \r\n");
      out.write("		        <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\r\n");
      out.write("		           <a class=\"dropdown-item\" href=\"");
      out.print(ctxPath);
      out.write("/emp/empList.action\">직원목록</a>\r\n");
      out.write("		           <a class=\"dropdown-item\" href=\"");
      out.print(ctxPath);
      out.write("/emp/chart.action\">통계차트</a>\r\n");
      out.write("		        </div>\r\n");
      out.write("		    </li>\r\n");
      out.write("		    \r\n");
      out.write("		    <li class=\"nav-item dropdown\">\r\n");
      out.write("		        <a class=\"nav-link dropdown-toggle text-info\" href=\"#\" id=\"navbarDropdown\" data-toggle=\"dropdown\">제품정보</a>  \r\n");
      out.write("		        <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\r\n");
      out.write("		           <a class=\"dropdown-item\" href=\"#\">제품목록</a>\r\n");
      out.write("		        </div>\r\n");
      out.write("		    </li>\r\n");
      out.write("\r\n");
      out.write("			<li class=\"nav-item dropdown\">\r\n");
      out.write("		        <a class=\"nav-link dropdown-toggle text-info\" href=\"#\" id=\"navbarDropdown\" data-toggle=\"dropdown\">일정관리</a>  \r\n");
      out.write("		        <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\r\n");
      out.write("		           <a class=\"dropdown-item\" href=\"");
      out.print(ctxPath);
      out.write("/schedule/scheduleManagement.action\">일정관리</a>\r\n");
      out.write("		        </div>\r\n");
      out.write("		    </li>\r\n");
      out.write("\r\n");
      out.write("			<!-- ==== 인터셉터 알아보기 ====  -->\r\n");
      out.write("		    <li class=\"nav-item dropdown\">\r\n");
      out.write("		        <a class=\"nav-link dropdown-toggle text-info\" href=\"#\" id=\"navbarDropdown\" data-toggle=\"dropdown\">인터셉터알아보기</a>  \r\n");
      out.write("		        <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\r\n");
      out.write("		           <a class=\"dropdown-item\" href=\"");
      out.print(ctxPath);
      out.write("/anyone/anyone_a.action\">누구나접근_A</a>\r\n");
      out.write("		           <a class=\"dropdown-item\" href=\"");
      out.print(ctxPath);
      out.write("/anyone/anyone_b.action\">누구나접근_B</a>\r\n");
      out.write("		           <a class=\"dropdown-item\" href=\"");
      out.print(ctxPath);
      out.write("/member_only/member_a.action\">회원누구나접근_A</a>\r\n");
      out.write("		           <a class=\"dropdown-item\" href=\"");
      out.print(ctxPath);
      out.write("/member_only/member_b.action\">회원누구나접근_B</a>\r\n");
      out.write("		           <a class=\"dropdown-item\" href=\"");
      out.print(ctxPath);
      out.write("/special_member/special_member_a.action\">특정회원만접근_A</a>\r\n");
      out.write("		           <a class=\"dropdown-item\" href=\"");
      out.print(ctxPath);
      out.write("/special_member/special_member_b.action\">특정회원만접근_B</a>\r\n");
      out.write("		        </div>\r\n");
      out.write("		    </li>\r\n");
      out.write("\r\n");
      out.write("		  </ul>\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("		<!-- === #49. 로그인이 성공되어지면 로그인되어진 사용자의 이메일 주소를 출력하기 === -->\r\n");
      out.write("		");
      if (_jspx_meth_c_005fif_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("			\r\n");
      out.write("	</nav>\r\n");
      out.write("	<!-- 상단 네비게이션 끝 -->\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	<div style=\"margin: auto; padding: 5px 0 15px 0; width: 80%;\">\r\n");
      out.write("		\r\n");
      out.write("		<!-- 광고 캐러젤 시작-->\r\n");
      out.write("		<div id=\"myCarousel\" class=\"carousel slide\" data-ride=\"carousel\">\r\n");
      out.write("    	  <!-- Indicators -->\r\n");
      out.write("    	  <ol class=\"carousel-indicators\">\r\n");
      out.write("		      <li data-target=\"#myCarousel\" data-slide-to=\"0\" class=\"active\"></li>\r\n");
      out.write("		      <li data-target=\"#myCarousel\" data-slide-to=\"1\"></li>\r\n");
      out.write("	      </ol>\r\n");
      out.write("\r\n");
      out.write("          <!-- Wrapper for slides -->\r\n");
      out.write("          <div class=\"carousel-inner\">\r\n");
      out.write("		      <div class=\"carousel-item active\">\r\n");
      out.write("		        <img src=\"");
      out.print( ctxPath);
      out.write("/resources/images/advertisement_01.png\" alt=\"붐펫\" class=\"d-block w-100\">\r\n");
      out.write("		      </div>\r\n");
      out.write("		\r\n");
      out.write("		      <div class=\"carousel-item\">\r\n");
      out.write("		        <img src=\"");
      out.print( ctxPath);
      out.write("/resources/images/advertisement_02.png\" alt=\"어도비\" class=\"d-block w-100\">\r\n");
      out.write("		      </div>\r\n");
      out.write("    	  </div>\r\n");
      out.write("\r\n");
      out.write("	      <!-- Left and right controls -->\r\n");
      out.write("	      <a class=\"carousel-control-prev\" href=\"#myCarousel\" role=\"button\" data-slide=\"prev\">\r\n");
      out.write("	         <span class='carousel-control-prev-icon' aria-hidden='true'></span>\r\n");
      out.write("	         <span class=\"sr-only\">Previous</span>\r\n");
      out.write("	      </a>\r\n");
      out.write("	      <a class=\"carousel-control-next\" href=\"#myCarousel\" role=\"button\" data-slide=\"next\">\r\n");
      out.write("	         <span class='carousel-control-next-icon' aria-hidden='true'></span>\r\n");
      out.write("	         <span class=\"sr-only\">Next</span>\r\n");
      out.write("	      </a>\r\n");
      out.write("	  </div>\r\n");
      out.write("      <!-- 광고 캐러젤 끝-->\r\n");
      out.write("      \r\n");
      out.write("	</div>\r\n");
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

  private boolean _jspx_meth_c_005fif_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f2_reused = false;
    try {
      _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f2.setParent(null);
      // /WEB-INF/tiles/tile2/header.jsp(85,2) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty sessionScope.loginuser}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
      if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("			<div style=\"float: right;\">\r\n");
          out.write("			  <span style=\"color: navy; font-weight: bold;\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loginuser.email}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</span> 님 로그인중.. \r\n");
          out.write("			</div>\r\n");
          out.write("		");
          int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
      _jspx_th_c_005fif_005f2_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f2, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f2_reused);
    }
    return false;
  }
}
