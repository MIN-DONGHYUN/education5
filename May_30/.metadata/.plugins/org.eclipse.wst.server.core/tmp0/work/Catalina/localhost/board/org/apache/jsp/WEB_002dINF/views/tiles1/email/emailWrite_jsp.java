/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.72
 * Generated at: 2023-05-30 04:52:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.tiles1.email;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class emailWrite_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("	/* -- CSS 로딩화면 구현 시작(bootstrap 에서 가져옴) -- */    \r\n");
      out.write("   div.loader {\r\n");
      out.write("     border: 16px solid #f3f3f3;\r\n");
      out.write("     border-radius: 50%;\r\n");
      out.write("     border-top: 12px dotted blue;\r\n");
      out.write("     border-right: 12px dotted green; \r\n");
      out.write("     border-bottom: 12px dotted red; \r\n");
      out.write("     border-left: 12px dotted pink; \r\n");
      out.write("     width: 120px;\r\n");
      out.write("     height: 120px;\r\n");
      out.write("     -webkit-animation: spin 2s linear infinite;\r\n");
      out.write("     animation: spin 2s linear infinite;\r\n");
      out.write("   }\r\n");
      out.write("   \r\n");
      out.write("   @-webkit-keyframes spin {\r\n");
      out.write("     0% { -webkit-transform: rotate(0deg); }\r\n");
      out.write("     100% { -webkit-transform: rotate(360deg); }\r\n");
      out.write("   }\r\n");
      out.write("   \r\n");
      out.write("   @keyframes spin {\r\n");
      out.write("     0% { transform: rotate(0deg); }\r\n");
      out.write("     100% { transform: rotate(360deg); }\r\n");
      out.write("   }\r\n");
      out.write("	/* -- CSS 로딩화면 구현 끝(bootstrap 에서 가져옴) -- */   \r\n");
      out.write("\r\n");
      out.write("	\r\n");
      out.write("   div.fileDrop{ display: inline-block; \r\n");
      out.write("                 width: 100%; \r\n");
      out.write("                 height: 100px;\r\n");
      out.write("                 overflow: auto;\r\n");
      out.write("                 background-color: #fff;\r\n");
      out.write("                 padding-left: 10px;}\r\n");
      out.write("                 \r\n");
      out.write("   div.fileDrop > div.fileList > span.delete{display:inline-block; width: 20px; border: solid 1px gray; text-align: center;} \r\n");
      out.write("   div.fileDrop > div.fileList > span.delete:hover{background-color: #000; color: #fff; cursor: pointer;}\r\n");
      out.write("   div.fileDrop > div.fileList > span.fileName{padding-left: 10px;}\r\n");
      out.write("   div.fileDrop > div.fileList > span.fileSize{padding-right: 20px; float:right;} \r\n");
      out.write("   span.clear{clear: both;} \r\n");
      out.write("	\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("  $(document).ready(function(){\r\n");
      out.write("     \r\n");
      out.write("	  $(\"div.loader\").hide();  // CSS 로딩화면 감추기 \r\n");
      out.write("	  \r\n");
      out.write("	  \r\n");
      out.write("	  \r\n");
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
      out.write("	  \r\n");
      out.write("	  ");
      out.write("\r\n");
      out.write("	  \r\n");
      out.write("	  let file_arr = [];  // 첨부되어진 파일 정보 담아 둘 배열 \r\n");
      out.write("	  \r\n");
      out.write("	  // == 파일 Drag & Drop 만들기 == //\r\n");
      out.write("	  $(\"div#fileDrop\").on(\"dragenter\", function(e){  /* \"dragenter\" 이벤트는 드롭대상인 박스 안에 Drag 한 파일이 최초로 들어왔을 때 */ \r\n");
      out.write(" 			\r\n");
      out.write("		  e.preventDefault();\r\n");
      out.write("          ");
      out.write("\r\n");
      out.write("          \r\n");
      out.write("          e.stopPropagation();\r\n");
      out.write("          ");
      out.write("\r\n");
      out.write("		  \r\n");
      out.write("	  }).on(\"dragover\", function(e){   /* \"dragover\" 이벤트는 드롭대상인 박스 안에 Drag 한 파일이 머물러 있는 중일 때. 필수이벤트이다. dragover 이벤트를 적용하지 않으면 drop 이벤트가 작동하지 않음 */\r\n");
      out.write("		  \r\n");
      out.write("		  e.preventDefault();\r\n");
      out.write("		  e.stopPropagation();\r\n");
      out.write("		  $(this).css(\"background-color\", \"#ffd8d8\");   // 드래그 한 상태로 있으면 색상 변경\r\n");
      out.write("		  \r\n");
      out.write("	  }).on(\"dragleave\", function(e){   /* \"dragleave\" 이벤트는 Drag 한 파일이 드롭대상인 박스 밖으로 벗어났을 때  */\r\n");
      out.write("		  \r\n");
      out.write("		  e.preventDefault();\r\n");
      out.write("		  e.stopPropagation();\r\n");
      out.write("		  $(this).css(\"background-color\", \"#fff\");   // 드래그 한 상태로 박스 밖으로 가면  색상 변경\r\n");
      out.write("		  \r\n");
      out.write("		  \r\n");
      out.write("	  }).on(\"drop\", function(e){   /* \"drop\" 이벤트는 드롭대상인 박스 안에서 Drag 한것을 Drop(Drag 한 파일(객체)을 놓는것) 했을 때. 필수이벤트이다. */\r\n");
      out.write("		\r\n");
      out.write("		  e.preventDefault();\r\n");
      out.write("		  \r\n");
      out.write("	  	  var files = e.originalEvent.dataTransfer.files;  \r\n");
      out.write("		  \r\n");
      out.write("	      /*  Drag & Drop 동작에서 파일 정보는 DataTransfer 라는 객체를 통해 얻어올 수 있다. \r\n");
      out.write("              jQuery를 이용하는 경우에는 event가 순수한 DOM 이벤트(각기 다른 웹브라우저에서 해당 웹브라우저의 객체에서 발생되는 이벤트)가 아니기 때문에,\r\n");
      out.write("              event.originalEvent를 사용해서 순수한 원래의 DOM 이벤트 객체를 가져온다.\r\n");
      out.write("              Drop 된 파일은 드롭이벤트가 발생한 객체(여기서는 $(\"div#fileDrop\")임)의 dataTransfer 객체에 담겨오고, \r\n");
      out.write("          	    담겨진 dataTransfer 객체에서 files 로 접근하면 드롭된 파일의 정보를 가져오는데 그 타입은 FileList 가 되어진다. \r\n");
      out.write("           	    그러므로 for문을 사용하든지 또는 [0]을 사용하여 파일의 정보를 알아온다. \r\n");
      out.write("		  */\r\n");
      out.write("		  \r\n");
      out.write("		  //console.log(typeof files);      // object\r\n");
      out.write("		  //console.log(files);          \r\n");
      out.write("		  /*  FileList {0: File, length: 1}\r\n");
      out.write("			  0: File {name: 'berkelekle덩크04.jpg', lastModified: 1605506138000, lastModifiedDate: Mon Nov 16 2020 14:55:38 GMT+0900 (한국 표준시), webkitRelativePath: '', size: 41931, …}\r\n");
      out.write("			  length: 1\r\n");
      out.write("			  [[Prototype]]: FileList     \r\n");
      out.write("	      */\r\n");
      out.write("	      \r\n");
      out.write("	      \r\n");
      out.write("	  	  if(files != null && files != undefined) {\r\n");
      out.write("	  		  console.log(\"files.length 는  =>\" + files.length);\r\n");
      out.write("	  		  // files.length 는  => 1 이 나온다. \r\n");
      out.write("	  		  \r\n");
      out.write("	  		  ");
      out.write("\r\n");
      out.write("	  		  \r\n");
      out.write("	  		  \r\n");
      out.write("	  		  \r\n");
      out.write("	  		  // !!!!!!!!!!!!!! servlet-context.xml 에 최대 업로드 크기를 10MB 로 제한두었다. !!!!!!!!!!!!!\r\n");
      out.write("	  		  // 108~109 번 줄 //\r\n");
      out.write("	  		  \r\n");
      out.write("	  		  \r\n");
      out.write("	  		  let html = \"\";\r\n");
      out.write("	  		  const f = files[0]; // 어차피 files.length 의 값이 1 이므로 위의 for문을 사용하지 않고 files[0] 을 사용하여 1개만 가져오면 된다.\r\n");
      out.write("	  		  let fileSize = f.size/1024/1024;  /* 파일의 크기는 MB로 나타내기 위하여 /1024/1024 하였음 */\r\n");
      out.write("	  		  \r\n");
      out.write("	  		  if(fileSize >= 10) {\r\n");
      out.write("	  			  alert(\"10MB 이상인 파일은 업로드할 수 없습니다.!!\");\r\n");
      out.write("                  $(this).css(\"background-color\", \"#fff\");\r\n");
      out.write("                  return;\r\n");
      out.write("	  		  }\r\n");
      out.write("	  		  else{\r\n");
      out.write("	  			  file_arr.push(f);\r\n");
      out.write("	  			  const fileName = f.name;   // 파일명 \r\n");
      out.write("	  		  \r\n");
      out.write("	  			  fileSize = fileSize < 1 ? fileSize.toFixed(3) : fileSize.toFixed(1);    // 삼항연산자\r\n");
      out.write("                  // fileSize 가 1MB 보다 작으면 소수부는 반올림하여 소수점 3자리까지 나타내며, \r\n");
      out.write("                  // fileSize 가 1MB 이상이면 소수부는 반올림하여 소수점 1자리까지 나타낸다. 만약에 소수부가 없으면 소수점은 0 으로 표시한다.\r\n");
      out.write("                  /* \r\n");
      out.write("                      numObj.toFixed([digits]) 의 toFixed() 메서드는 숫자를 고정 소수점 표기법(fixed-point notation)으로 표시하여 나타난 수를 문자열로 반환해준다. \r\n");
      out.write("                                            파라미터인 digits 는 소수점 뒤에 나타날 자릿수 로써, 0 이상 20 이하의 값을 사용할 수 있으며, 구현체에 따라 더 넓은 범위의 값을 지원할 수도 있다. \r\n");
      out.write("                      digits 값을 지정하지 않으면 0 을 사용한다.\r\n");
      out.write("                      \r\n");
      out.write("                      var numObj = 12345.6789;\r\n");
      out.write("\r\n");
      out.write("                      numObj.toFixed();       // 결과값 '12346'   : 반올림하며, 소수 부분을 남기지 않는다.\r\n");
      out.write("                      numObj.toFixed(1);      // 결과값 '12345.7' : 반올림한다.\r\n");
      out.write("                      numObj.toFixed(6);      // 결과값 '12345.678900': 빈 공간을 0 으로 채운다.\r\n");
      out.write("                 */\r\n");
      out.write("	  			  \r\n");
      out.write("	  			 html += \r\n");
      out.write("                    \"<div class='fileList'>\" +\r\n");
      out.write("                        \"<span class='delete'>&times;</span>\" +\r\n");
      out.write("                        \"<span class='fileName'>\"+fileName+\"</span>\" +\r\n");
      out.write("                        \"<span class='fileSize'>\"+fileSize+\" MB</span>\" +\r\n");
      out.write("                        \"<span class='clear'></span>\" +\r\n");
      out.write("                    \"</div>\";\r\n");
      out.write("                    \r\n");
      out.write("                  $(this).append(html);  \r\n");
      out.write("	  		  }\r\n");
      out.write("	  		  \r\n");
      out.write("	  	  }// end of if(files != null && files != undefined)\r\n");
      out.write("		  \r\n");
      out.write("	  	  $(this).css(\"background-color\", \"#fff\");   // 색상을 흰색으로 변경하기   \r\n");
      out.write("	  		  \r\n");
      out.write("	  		  \r\n");
      out.write("	  });  \r\n");
      out.write("	  \r\n");
      out.write("	  // === Drop 되어진 파일 목록 제거하기 === //\r\n");
      out.write("	  \r\n");
      out.write("	  \r\n");
      out.write("	  \r\n");
      out.write("	  \r\n");
      out.write("	  ");
      out.write("\r\n");
      out.write("	  \r\n");
      out.write("	  \r\n");
      out.write("	  // 보내기 버튼\r\n");
      out.write("	 \r\n");
      out.write("     \r\n");
      out.write("  });// end of $(document).ready(function(){})-------------------------------\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<div style=\"display: flex;\">\r\n");
      out.write("<div style=\"margin: auto; padding-left: 3%;\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div style=\"display: flex\">\r\n");
      out.write("   <div class=\"loader\" style=\"margin: auto\"></div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<h2 style=\"margin-bottom: 30px;\">e메일 쓰기</h2>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<form name=\"addFrm\" enctype=\"multipart/form-data\">\r\n");
      out.write("\r\n");
      out.write("   <div class=\"my-3\">\r\n");
      out.write("      <button type=\"button\" class=\"btn btn-success mr-3\" id=\"btnWrite\">보내기</button>\r\n");
      out.write("      <button type=\"button\" class=\"btn btn-danger\" onclick=\"javascript:location.reload(true)\">취&nbsp;소</button>\r\n");
      out.write("   </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("   <table style=\"width: 1024px\" class=\"table table-bordered\">\r\n");
      out.write("      <tr>\r\n");
      out.write("         <th style=\"width: 15%; background-color: #DDDDDD;\">받는사람</th>\r\n");
      out.write("         <td>\r\n");
      out.write("            <input type=\"email\" name=\"recipient\" id=\"recipient\" size=\"100\" />\r\n");
      out.write("         </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      \r\n");
      out.write("      <tr>\r\n");
      out.write("         <th style=\"width: 15%; background-color: #DDDDDD;\">제목</th>\r\n");
      out.write("         <td>\r\n");
      out.write("         	<input type=\"text\" name=\"subject\" id=\"subject\" size=\"100\" />         \r\n");
      out.write("         </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      \r\n");
      out.write("      ");
      out.write("\r\n");
      out.write("      \r\n");
      out.write("      <tr>\r\n");
      out.write("         <th style=\"width: 15%; background-color: #DDDDDD;\">파일첨부</th>\r\n");
      out.write("         <td>\r\n");
      out.write("             <span style=\"font-size: 10pt;\">파일을 마우스로 끌어 오세요</span>\r\n");
      out.write("             <div id=\"fileDrop\" class=\"fileDrop border border-secondary\"></div>\r\n");
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
      out.write("      \r\n");
      out.write("   </table>\r\n");
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
