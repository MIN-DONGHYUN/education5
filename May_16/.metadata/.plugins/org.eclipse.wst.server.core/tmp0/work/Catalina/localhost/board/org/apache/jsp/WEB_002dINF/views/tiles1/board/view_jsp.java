/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.72
 * Generated at: 2023-05-16 00:44:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.tiles1.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class view_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("jar:file:/C:/NCS/workspace(spring)/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Board/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("jar:file:/C:/NCS/workspace(spring)/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Board/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1683599588119L));
    _jspx_dependants.put("jar:file:/C:/NCS/workspace(spring)/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Board/WEB-INF/lib/jstl-1.2.jar!/META-INF/fn.tld", Long.valueOf(1153352682000L));
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
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

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
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
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

   String ctxPath = request.getContextPath();

      out.write("   \r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("    span.move {cursor: pointer; color: navy;}\r\n");
      out.write("    .moveColor {color: #660029; font-weight: bold; background-color: #ffffe6;}\r\n");
      out.write("    \r\n");
      out.write("    td.comment {text-align: center;}\r\n");
      out.write("    \r\n");
      out.write("    a {text-decoration: none !important;}\r\n");
      out.write("\r\n");
      out.write("</style>   \r\n");
      out.write("    \r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("  $(document).ready(function(){\r\n");
      out.write("     \r\n");
      out.write("	  // 페이징 처리 안한 댓글 읽어오기\r\n");
      out.write("	  goReadComment();  // 문서가 로딩 되자 마자 댓글을 보여주기 위해 쓴다.\r\n");
      out.write("	  \r\n");
      out.write("         \r\n");
      out.write("  });// end of $(document).ready(function(){})------------------------\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  // Function Declaration\r\n");
      out.write("  \r\n");
      out.write("  // == 댓글쓰기 == \r\n");
      out.write("  function goAddWrite() {\r\n");
      out.write("	  \r\n");
      out.write("	  // 유효성 검사 할 것임 \r\n");
      out.write("	  const commentContent = $(\"input#commentContent\").val().trim();\r\n");
      out.write("	  // 내용 가져옴 \r\n");
      out.write("	  \r\n");
      out.write("	  // 가져온 글이 아무것도 없다면 \r\n");
      out.write("	  if(commentContent == \"\") {\r\n");
      out.write("		  alert(\"댓글 내용을 입력하세요!!\");\r\n");
      out.write("		  return ; // 종료 \r\n");
      out.write("	  }\r\n");
      out.write("	  \r\n");
      out.write("	  if($(\"input#attach\").val() == \"\") {\r\n");
      out.write("		  // 첨부 파일이 없는 댓글쓰기인 경우 !!!!\r\n");
      out.write("		  goAddWrite_noAttach();\r\n");
      out.write("  \r\n");
      out.write("	  }\r\n");
      out.write("	  else {\r\n");
      out.write("		  // 첨부 파일이 있는 댓글쓰기인 경우 !!!!\r\n");
      out.write("		  goAddWrite_withAttach();\r\n");
      out.write("	  }\r\n");
      out.write("\r\n");
      out.write("  } // end of  function goAddWrite()\r\n");
      out.write("  \r\n");
      out.write("  // 파일첨부가 없는 댓글쓰기 \r\n");
      out.write("  function goAddWrite_noAttach() {\r\n");
      out.write("	  \r\n");
      out.write("	  ");
      out.write(" \r\n");
      out.write("	  \r\n");
      out.write("	  const queryString = $(\"form[name='addWriteFrm']\").serialize();  ");
      out.write("\r\n");
      out.write("	  \r\n");
      out.write("	  $.ajax({\r\n");
      out.write("		 url:\"");
      out.print( request.getContextPath());
      out.write("/addComment.action\",\r\n");
      out.write("	/*	 \r\n");
      out.write("		 data:{\"fk_userid\":$(\"input#fk_userid\").val()        userid 넘겨줌 \r\n");
      out.write("			  ,\"name\":$(\"input#name\").val()                 성명 넘겨줌 \r\n");
      out.write("			  ,\"content\":$(\"input#commentContent\").val()     댓글 내용 넘겨줌 \r\n");
      out.write("			  ,\"parentSeq\":$(\"input#parentSeq\").val()},     부모 글 번호 까지 넘겨줌 \r\n");
      out.write("		또는 \r\n");
      out.write("	*/\r\n");
      out.write("		 data:queryString,   /* form 태그에 있는 name 값들을 자동적으로 넣어준다. */\r\n");
      out.write("			  \r\n");
      out.write("		 type:\"post\",\r\n");
      out.write("		 dataType:\"json\",\r\n");
      out.write("		 success:function(json){\r\n");
      out.write("			 console.log(\"확인용 ~~ : \" + JSON.stringify(json));\r\n");
      out.write("			 // 확인용 ~~ : {\"name\":\"민동현\",\"n\":0}\r\n");
      out.write("			 // 또는 \r\n");
      out.write("			 // 확인용 ~~ : {\"name\":\"민동현\",\"n\":1}\r\n");
      out.write("			 \r\n");
      out.write("			 if(json.n == 0) {\r\n");
      out.write("				alert(json.name + \"님의 포인트는 300점을 초과할 수 없으므로 댓글쓰기가 불가합니다.\"); \r\n");
      out.write("			 }\r\n");
      out.write("			 else {\r\n");
      out.write("				 goReadComment();// 페이징 처리 안한 댓글 읽어오기\r\n");
      out.write("				 // 페이징 처리 한 댓글 읽어오기 \r\n");
      out.write("			 }\r\n");
      out.write("			 \r\n");
      out.write("			 $(\"input#commentContent\").val(\"\");  // 댓글 썻던 것을 초기화 하기 \r\n");
      out.write("			 \r\n");
      out.write("			 \r\n");
      out.write("		 },\r\n");
      out.write("		 error: function(request, status, error){\r\n");
      out.write("            alert(\"code: \"+request.status+\"\\n\"+\"message: \"+request.responseText+\"\\n\"+\"error: \"+error);\r\n");
      out.write("        }\r\n");
      out.write("	  });\r\n");
      out.write("	  \r\n");
      out.write("	  \r\n");
      out.write("  }// end of function goAddWrite_noAttach()\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  // ==== #169. 파일첨부가 있는 댓글쓰기 ==== // \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  // === 페이징 처리 안한 댓글 읽어오기  === //\r\n");
      out.write("  function goReadComment() {\r\n");
      out.write("	  $.ajax({\r\n");
      out.write("		 url:\"");
      out.print( request.getContextPath());
      out.write("/readComment.action\",\r\n");
      out.write("		 data:{\"parentSeq\":\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.boardvo.seq}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"},\r\n");
      out.write("		 dataType:\"json\",\r\n");
      out.write("		 success:function(json){\r\n");
      out.write("			 //console.log(\"확인용이다 : \" + JSON.stringify(json));\r\n");
      out.write("			 // 확인용이다 : [{\"name\":\"민동현\",\"regdate\":\"2023-05-15 15:24:50\",\"content\":\"넘나 신기하네요 소통을 할 수 있어 좋아요\"},{\"name\":\"민동현\",\"regdate\":\"2023-05-15 15:09:17\",\"content\":\"저도 신기해여\"}]\r\n");
      out.write("			 // 또는 \r\n");
      out.write("			 // 확인용이다 : []\r\n");
      out.write("			 \r\n");
      out.write("			 let html = \"\";\r\n");
      out.write("			 // json 에 하나라도 들어있으면 실행  (item 은 배열의 객체임)\r\n");
      out.write("			 if(json.length > 0) {\r\n");
      out.write("				 // 반복문 \r\n");
      out.write("				 $.each(json, function(index, item) {\r\n");
      out.write("					 html += \"<tr>\" + \r\n");
      out.write("					            \"<td class='comment'>\"+(index+1)+\"</td>\" +\r\n");
      out.write("					            \"<td>\"+item.content+\"</td>\"  +\r\n");
      out.write("					            \"<td></td>\"  +\r\n");
      out.write("					            \"<td></td>\"  +\r\n");
      out.write("					            \"<td class='comment'>\"+item.name+\"</td>\"  +\r\n");
      out.write("					            \"<td class='comment'>\"+item.regdate+\"</td>\"  +\r\n");
      out.write("					         \"</tr>\";\r\n");
      out.write("				 });\r\n");
      out.write("			 }\r\n");
      out.write("			 else{\r\n");
      out.write("				 html += \"<tr>\" + \r\n");
      out.write("				            \"<td colspan='6' class='comment'>댓글이 없습니다</td>\"  +				    \r\n");
      out.write("				         \"</tr>\"\r\n");
      out.write("			 }\r\n");
      out.write("			 \r\n");
      out.write("			 $(\"tbody#commentDisplay\").html(html);   //이 속에 html을 추가하자 \r\n");
      out.write("			 \r\n");
      out.write("		 },\r\n");
      out.write("		 error: function(request, status, error){\r\n");
      out.write("	         alert(\"code: \"+request.status+\"\\n\"+\"message: \"+request.responseText+\"\\n\"+\"error: \"+error);\r\n");
      out.write("	     }\r\n");
      out.write("	  });\r\n");
      out.write("  }\r\n");
      out.write("  \r\n");
      out.write("  // === #127. Ajax로 불러온 댓글내용을  페이징 처리 하기  === //\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  // ==== 댓글내용 페이지바 Ajax로 만들기 ==== //\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<div style=\"display: flex;\">\r\n");
      out.write("<div style=\"margin: auto; padding-left: 3%;\">\r\n");
      out.write("\r\n");
      out.write("   <h2 style=\"margin-bottom: 30px;\">글내용보기</h2>\r\n");
      out.write("\r\n");
      out.write("    ");
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      boolean _jspx_th_c_005fif_005f0_reused = false;
      try {
        _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
        _jspx_th_c_005fif_005f0.setParent(null);
        // /WEB-INF/views/tiles1/board/view.jsp(176,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty requestScope.boardvo}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
        int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
        if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("       <table style=\"width: 1024px\" class=\"table table-bordered table-dark\">\r\n");
            out.write("          <tr>\r\n");
            out.write("              <th style=\"width: 15%\">글번호</th>\r\n");
            out.write("              <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.boardvo.seq}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("          </tr>\r\n");
            out.write("          <tr>\r\n");
            out.write("              <th>성명</th>\r\n");
            out.write("              <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.boardvo.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("          </tr>\r\n");
            out.write("          <tr>\r\n");
            out.write("              <th>제목</th>\r\n");
            out.write("              <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.boardvo.subject}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("          </tr>\r\n");
            out.write("          <tr>\r\n");
            out.write("              <th>내용</th>\r\n");
            out.write("              <td> \r\n");
            out.write("                <p style=\"word-break: break-all;\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.boardvo.content}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</p>\r\n");
            out.write("                ");
            out.write("\r\n");
            out.write("              </td>\r\n");
            out.write("          </tr>\r\n");
            out.write("          <tr>\r\n");
            out.write("              <th>조회수</th>\r\n");
            out.write("              <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.boardvo.readCount}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("          </tr>\r\n");
            out.write("          <tr>\r\n");
            out.write("              <th>날짜</th>\r\n");
            out.write("              <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.boardvo.regDate}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("          </tr>\r\n");
            out.write("          \r\n");
            out.write("          ");
            out.write("\r\n");
            out.write("         <tr>\r\n");
            out.write("            <th>첨부파일</th>\r\n");
            out.write("            <td>\r\n");
            out.write("               \r\n");
            out.write("            </td>\r\n");
            out.write("         </tr>\r\n");
            out.write("         <tr>\r\n");
            out.write("            <th>파일크기(bytes)</th>\r\n");
            out.write("            <td></td>\r\n");
            out.write("         </tr>\r\n");
            out.write("          \r\n");
            out.write("       </table>\r\n");
            out.write("       <br/>\r\n");
            out.write("       \r\n");
            out.write("       ");
            if (_jspx_meth_c_005fset_005f0(_jspx_th_c_005fif_005f0, _jspx_page_context))
              return;
            out.write("\r\n");
            out.write("       \r\n");
            out.write("       ");
            out.write("\r\n");
            out.write("       <div style=\"margin-bottom: 1%;\">이전글제목&nbsp;&nbsp;<span class=\"move\" onclick=\"javascript:location.href='");
            out.print(ctxPath);
            out.write("/view_2.action?seq=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.boardvo.previousseq}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write('\'');
            out.write('"');
            out.write('>');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.boardvo.previoussubject}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</span></div>\r\n");
            out.write("       <div style=\"margin-bottom: 1%;\">다음글제목&nbsp;&nbsp;<span class=\"move\" onclick=\"javascript:location.href='");
            out.print(ctxPath);
            out.write("/view_2.action?seq=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.boardvo.nextseq}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write('\'');
            out.write('"');
            out.write('>');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.boardvo.nextsubject}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</span></div>\r\n");
            out.write("       <br/> \r\n");
            out.write("              \r\n");
            out.write("       <button type=\"button\" class=\"btn btn-secondary btn-sm mr-3\" onclick=\"javascript:location.href='");
            out.print( request.getContextPath());
            out.write("/list.action'\">전체목록보기</button>\r\n");
            out.write("       \r\n");
            out.write("       ");
            out.write("\r\n");
            out.write("       <button type=\"button\" class=\"btn btn-secondary btn-sm mr-3\" onclick=\"\">검색된결과목록보기</button>\r\n");
            out.write("       \r\n");
            out.write("       <button type=\"button\" class=\"btn btn-secondary btn-sm mr-3\" onclick=\"javascript:location.href='");
            out.print( request.getContextPath());
            out.write("/edit.action?seq=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.boardvo.seq}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("'\">글수정하기</button>\r\n");
            out.write("       <button type=\"button\" class=\"btn btn-secondary btn-sm mr-3\" onclick=\"javascript:location.href='");
            out.print( request.getContextPath());
            out.write("/del.action?seq=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.boardvo.seq}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("'\">글삭제하기</button>\r\n");
            out.write("       \r\n");
            out.write("       ");
            out.write("\r\n");
            out.write("       \r\n");
            out.write("       \r\n");
            out.write("       ");
            out.write("\r\n");
            out.write("       ");
            if (_jspx_meth_c_005fif_005f1(_jspx_th_c_005fif_005f0, _jspx_page_context))
              return;
            out.write("\r\n");
            out.write("       \r\n");
            out.write("       ");
            out.write("\r\n");
            out.write("       <h3 style=\"margin-top: 50px;\">댓글내용</h3>\r\n");
            out.write("      <table class=\"table\" style=\"width: 1024px; margin-top: 2%; margin-bottom: 3%;\">\r\n");
            out.write("         <thead>\r\n");
            out.write("         <tr>\r\n");
            out.write("             <th style=\"width: 6%;  text-align: center;\">번호</th>\r\n");
            out.write("            <th style=\"text-align: center;\">내용</th>\r\n");
            out.write("            \r\n");
            out.write("            ");
            out.write("\r\n");
            out.write("            <th style=\"width: 15%;\">첨부파일</th>\r\n");
            out.write("            <th style=\"width: 8%;\">bytes</th>\r\n");
            out.write("            ");
            out.write("\r\n");
            out.write("            \r\n");
            out.write("            <th style=\"width: 8%; text-align: center;\">작성자</th>\r\n");
            out.write("            <th style=\"width: 12%; text-align: center;\">작성일자</th>\r\n");
            out.write("         </tr>\r\n");
            out.write("         </thead>\r\n");
            out.write("         <tbody id=\"commentDisplay\"></tbody>\r\n");
            out.write("      </table>\r\n");
            out.write("      \r\n");
            out.write("      ");
            out.write("\r\n");
            out.write("       \r\n");
            out.write("       \r\n");
            out.write("    ");
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
      out.write("\r\n");
      out.write("   ");
      if (_jspx_meth_c_005fif_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("    \r\n");
      out.write("</div>\r\n");
      out.write("</div>            ");
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

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    boolean _jspx_th_c_005fset_005f0_reused = false;
    try {
      _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f0);
      // /WEB-INF/views/tiles1/board/view.jsp(226,7) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setVar("v_gobackURL");
      // /WEB-INF/views/tiles1/board/view.jsp(226,7) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/tiles1/board/view.jsp(226,7) ''",_jsp_getExpressionFactory().createValueExpression("",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
      if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      _jspx_th_c_005fset_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fset_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fset_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f1_reused = false;
    try {
      _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f0);
      // /WEB-INF/views/tiles1/board/view.jsp(247,7) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty sessionScope.loginuser}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
      if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("    <!-- 로그인을 하지 않는다면 보이지 않고 로그인을 했으면 댓글쓰기 폼을 보여준다. -->\r\n");
          out.write("       \r\n");
          out.write("	       <h3 style=\"margin-top: 50px;\">댓글쓰기</h3>\r\n");
          out.write("	       \r\n");
          out.write("	       <form name=\"addWriteFrm\" id=\"addWriteFrm\" style=\"margin-top: 20px;\">\r\n");
          out.write("	            <table class=\"table\" style=\"width: 1024px\">\r\n");
          out.write("	              <tr style=\"height: 30px;\">\r\n");
          out.write("	                 <th width=\"10%\">성명</th>\r\n");
          out.write("	                 <td>\r\n");
          out.write("	                   	<input type=\"hidden\" name =\"fk_userid\" id=\"fk_userid\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loginuser.userid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\" />   <!--  name 이 VO와 같은것이다. -->\r\n");
          out.write("	                   	<input type=\"text\" name =\"name\" id=\"name\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loginuser.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\" readonly=\"readonly\"/>   <!--  name 이 VO와 같은것이다. -->\r\n");
          out.write("	                 </td>\r\n");
          out.write("	              </tr>\r\n");
          out.write("	              <tr style=\"height: 30px;\">\r\n");
          out.write("	                 <th>댓글내용</th>\r\n");
          out.write("	                 <td>\r\n");
          out.write("	                    <input type=\"text\" name = \"content\" id = \"commentContent\" size = \"100\" />    ");
          out.write("\r\n");
          out.write("	                 	\r\n");
          out.write("	                 	");
          out.write("\r\n");
          out.write("	                 	<input type=\"hidden\" name=\"parentSeq\"  id=\"parentSeq\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.boardvo.seq}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\" />\r\n");
          out.write("	                 	\r\n");
          out.write("	                 </td>\r\n");
          out.write("	              </tr>\r\n");
          out.write("	              \r\n");
          out.write("	              <tr style=\"height: 30px;\">\r\n");
          out.write("	                 <th>파일첨부</th>\r\n");
          out.write("	                 <td>\r\n");
          out.write("	                     <input type=\"file\" name=\"attach\" id=\"attach\" />\r\n");
          out.write("	                 </td>\r\n");
          out.write("	              </tr>\r\n");
          out.write("	              \r\n");
          out.write("	              <tr>\r\n");
          out.write("	                 <th colspan=\"2\">\r\n");
          out.write("	                    <button type=\"button\" class=\"btn btn-success btn-sm mr-3\" onclick=\"goAddWrite()\">댓글쓰기 확인</button>\r\n");
          out.write("	                    <button type=\"reset\" class=\"btn btn-success btn-sm\">댓글쓰기 취소</button>\r\n");
          out.write("	                 </th>\r\n");
          out.write("	              </tr>\r\n");
          out.write("	          </table>         \r\n");
          out.write("	       </form>\r\n");
          out.write("       \r\n");
          out.write("       ");
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
      // /WEB-INF/views/tiles1/board/view.jsp(314,3) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty requestScope.boardvo}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
      if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("       <div style=\"padding: 50px 0; font-size: 16pt; color: red;\" >존재하지 않습니다</div>\r\n");
          out.write("    ");
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