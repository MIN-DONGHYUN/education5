/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.72
 * Generated at: 2023-06-02 01:23:35 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.tiles1.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class add_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("	  ");
      out.write("\r\n");
      out.write("	  \r\n");
      out.write("	    //전역변수\r\n");
      out.write("	    var obj = [];\r\n");
      out.write("	    \r\n");
      out.write("	    //스마트에디터 프레임생성\r\n");
      out.write("	    nhn.husky.EZCreator.createInIFrame({\r\n");
      out.write("	        oAppRef: obj,\r\n");
      out.write("	        elPlaceHolder: \"content\",     /* content 는 textarea 에 id 값과 같아야 한다. */\r\n");
      out.write("	        sSkinURI: \"");
      out.print( ctxPath);
      out.write("/resources/smarteditor/SmartEditor2Skin.html\",\r\n");
      out.write("	        htParams : {\r\n");
      out.write("	            // 툴바 사용 여부 (true:사용/ false:사용하지 않음)\r\n");
      out.write("	            bUseToolbar : true,            \r\n");
      out.write("	            // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)\r\n");
      out.write("	            bUseVerticalResizer : true,    \r\n");
      out.write("	            // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)\r\n");
      out.write("	            bUseModeChanger : true,\r\n");
      out.write("	        }\r\n");
      out.write("	    });\r\n");
      out.write("	  \r\n");
      out.write("	  \r\n");
      out.write("	  ");
      out.write("\r\n");
      out.write("	  \r\n");
      out.write("	  // 글쓰기 버튼\r\n");
      out.write("	  $(\"button#btnWrite\").click(function(){\r\n");
      out.write("		 \r\n");
      out.write("		 ");
      out.write("\r\n");
      out.write("		 \r\n");
      out.write("		 // id 가 content 인 textarea에 에디터 대입\r\n");
      out.write("		 obj.getById[\"content\"].exec(\"UPDATE_CONTENTS_FIELD\", []);\r\n");
      out.write("		 \r\n");
      out.write("		 ");
      out.write("\r\n");
      out.write("		 \r\n");
      out.write("		 \r\n");
      out.write("		// 글제목 유효성 검사\r\n");
      out.write("         const subject = $(\"input#subject\").val().trim();\r\n");
      out.write("         if(subject == \"\") {\r\n");
      out.write("            alert(\"글제목을 입력하세요!!\");\r\n");
      out.write("            return;\r\n");
      out.write("         }\r\n");
      out.write("         \r\n");
      out.write("        // 글내용 유효성 검사(스마트 에디터 사용 안 할 경우)\r\n");
      out.write("         /* \r\n");
      out.write("           const content = $(\"textarea#content\").val().trim();\r\n");
      out.write("           if(content == \"\") {\r\n");
      out.write("              alert(\"글내용을 입력하세요!!\");\r\n");
      out.write("              return;\r\n");
      out.write("           } \r\n");
      out.write("          */\r\n");
      out.write("         \r\n");
      out.write("       ");
      out.write(" \r\n");
      out.write("         let content = $(\"textarea#content\").val().trim();\r\n");
      out.write("         \r\n");
      out.write("         // 글 내용 유효성 검사하기 \r\n");
      out.write("         \r\n");
      out.write("         // alert(content);   // content 에 아무것도 입력하지 않거나 공백만 여러개를 입력하여 쓰기를 할 경우 알아본것.\r\n");
      out.write("         /*\r\n");
      out.write("         	아무것도 안쓰거나 공백으로 갈때 \r\n");
      out.write("            <p>&nbsp;</p>\r\n");
      out.write("            <p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</p>\r\n");
      out.write("         */\r\n");
      out.write("         \r\n");
      out.write("         content = content.replace(/&nbsp;/gi, \"\");   /* // 이것이 공백(&nbsp;)를 \"\"로 변환한다. */\r\n");
      out.write("         /*    \r\n");
      out.write("                         대상문자열.replace(/찾을 문자열/gi, \"변경할 문자열\");\r\n");
      out.write("             ==> 여기서 꼭 알아야 될 점은 나누기(/)표시안에 넣는 찾을 문자열의 따옴표는 없어야 한다는 점입니다. \r\n");
      out.write("                          그리고 뒤의 gi는 다음을 의미합니다.\r\n");
      out.write("        \r\n");
      out.write("             g : 전체 모든 문자열을 변경 global\r\n");
      out.write("             i : 영문 대소문자를 무시, 모두 일치하는 패턴 검색 ignore\r\n");
      out.write("         */ \r\n");
      out.write("         \r\n");
      out.write("         //alert(content);\r\n");
      out.write("         /*\r\n");
      out.write("         	<p></p>\r\n");
      out.write("         	<p>            </p>\r\n");
      out.write("         */\r\n");
      out.write("         \r\n");
      out.write("         // 최초로 나온는 <p>, </p> \r\n");
      out.write("         content = content.substring(content.indexOf(\"<p>\")+3);\r\n");
      out.write("         content = content.substring(0, content.indexOf(\"</p>\"));\r\n");
      out.write("         \r\n");
      out.write("         if(content.trim().length == 0) {\r\n");
      out.write("        	 alert(\"글내용을 입력하세요!!\");\r\n");
      out.write("        	 return;\r\n");
      out.write("         }\r\n");
      out.write("        \r\n");
      out.write("       ");
      out.write("  \r\n");
      out.write("       \r\n");
      out.write("       // 글암호 유효성 검사\r\n");
      out.write("         const pw = $(\"input#pw\").val();\r\n");
      out.write("         if(pw == \"\") {\r\n");
      out.write("            alert(\"글암호를 입력하세요!!\");\r\n");
      out.write("            return;\r\n");
      out.write("         }\r\n");
      out.write("         \r\n");
      out.write("         // 폼(form)을 전송(submit)\r\n");
      out.write("         const frm = document.addFrm;\r\n");
      out.write("         frm.method = \"POST\";\r\n");
      out.write("         frm.action = \"");
      out.print( ctxPath);
      out.write("/addEnd.action\";\r\n");
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
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<form name=\"addFrm\" enctype=\"multipart/form-data\">\r\n");
      out.write("   <table style=\"width: 1024px\" class=\"table table-bordered\">\r\n");
      out.write("      <tr>\r\n");
      out.write("         <th style=\"width: 15%; background-color: #DDDDDD;\">성명</th>\r\n");
      out.write("         <td>\r\n");
      out.write("            <input type=\"hidden\" name=\"fk_userid\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loginuser.userid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" readonly/>   <!-- readonly는 읽기 전용, userid값을 넘겨주기 위해 hidden 설정  -->\r\n");
      out.write("            <input type=\"text\" name=\"name\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loginuser.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" readonly/>   <!-- readonly는 읽기 전용, ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loginuser.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" 는 BoardVO에서 설정한것 가져옴 -->      \r\n");
      out.write("         </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      \r\n");
      out.write("      <tr>\r\n");
      out.write("         <th style=\"width: 15%; background-color: #DDDDDD;\">제목</th>\r\n");
      out.write("         <td>\r\n");
      out.write("         	  \r\n");
      out.write("			  ");
      out.write("\r\n");
      out.write("			  ");
      if (_jspx_meth_c_005fif_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("              \r\n");
      out.write("              ");
      out.write("\r\n");
      out.write("		   	  ");
      if (_jspx_meth_c_005fif_005f3(_jspx_page_context))
        return;
      out.write("              \r\n");
      out.write("              \r\n");
      out.write("         </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      \r\n");
      out.write("      <tr>\r\n");
      out.write("         <th style=\"width: 15%; background-color: #DDDDDD;\">내용</th>\r\n");
      out.write("         <td>\r\n");
      out.write("            <textarea Style=\"width: 100%; height: 612px;\" name=\"content\" id=\"content\"></textarea>\r\n");
      out.write("         </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      \r\n");
      out.write("      ");
      out.write("\r\n");
      out.write("      \r\n");
      out.write("      <tr>\r\n");
      out.write("         <th style=\"width: 15%; background-color: #DDDDDD;\">파일첨부</th>\r\n");
      out.write("         <td>\r\n");
      out.write("             <input type=\"file\" name=\"attach\" />   ");
      out.write("\r\n");
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
      out.write("   \r\n");
      out.write("   ");
      out.write("\r\n");
      out.write("   <input type=\"hidden\" name=\"fk_seq\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.fk_seq}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" /> \r\n");
      out.write("   <input type=\"hidden\" name=\"groupno\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.groupno}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" />   \r\n");
      out.write("   <input type=\"hidden\" name=\"depthno\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.depthno}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" />  \r\n");
      out.write("   \r\n");
      out.write("   \r\n");
      out.write("   ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("   <div style=\"margin: 20px;\">\r\n");
      out.write("      <button type=\"button\" class=\"btn btn-secondary btn-sm mr-3\" id=\"btnWrite\">글쓰기</button>\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /WEB-INF/views/tiles1/board/add.jsp(132,0) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.fk_seq eq ''}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("	<h2 style=\"margin-bottom: 30px;\">글쓰기</h2>\r\n");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f1_reused = false;
    try {
      _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f1.setParent(null);
      // /WEB-INF/views/tiles1/board/add.jsp(137,0) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.fk_seq ne ''}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
      if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("	<h2 style=\"margin-bottom: 30px; color: blue\">답변글쓰기</h2>\r\n");
          int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      _jspx_th_c_005fif_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f1_reused);
    }
    return false;
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
      // /WEB-INF/views/tiles1/board/add.jsp(165,5) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.fk_seq eq ''}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
      if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("              <input type=\"text\" name=\"subject\" id=\"subject\" size=\"100\"/>  \r\n");
          out.write("              ");
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

  private boolean _jspx_meth_c_005fif_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f3_reused = false;
    try {
      _jspx_th_c_005fif_005f3.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f3.setParent(null);
      // /WEB-INF/views/tiles1/board/add.jsp(170,8) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.fk_seq ne ''}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f3 = _jspx_th_c_005fif_005f3.doStartTag();
      if (_jspx_eval_c_005fif_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("			  <input type=\"text\" name=\"subject\" id=\"subject\" size=\"100\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.subject}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\" readonly/>  \r\n");
          out.write("			  ");
          int evalDoAfterBody = _jspx_th_c_005fif_005f3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
      _jspx_th_c_005fif_005f3_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f3, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f3_reused);
    }
    return false;
  }
}
