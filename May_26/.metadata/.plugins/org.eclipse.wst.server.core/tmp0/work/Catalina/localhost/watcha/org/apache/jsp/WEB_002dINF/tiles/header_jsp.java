/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.72
 * Generated at: 2023-05-24 07:18:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.tiles;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" \r\n");
 String ctxPath = request.getContextPath(); 
      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<!-- Required meta tags -->\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("\r\n");
      out.write("<!-- Bootstrap CSS -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(ctxPath);
      out.write("/bootstrap-4.6.0-dist/css/bootstrap.min.css\" type=\"text/css\">\r\n");
      out.write("    \r\n");
      out.write("<!-- Optional JavaScript -->\r\n");
      out.write("<script src=\"");
      out.print(ctxPath);
      out.write("/js/jquery-3.6.4.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(ctxPath);
      out.write("/bootstrap-4.6.0-dist/js/bootstrap.bundle.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- Font Awesome 6 Icons --> \r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css\">\r\n");
      out.write("<!-- 글꼴 적용하기 -->\r\n");
      out.write("<link rel=\"stylesheet\" as=\"style\" crossorigin href=\"https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.6/dist/web/static/pretendard.css\" />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	@media (max-width: 991px) and (min-width: 860px) {\r\n");
      out.write("		.container {\r\n");
      out.write("			max-width: 830px;\r\n");
      out.write("		}\r\n");
      out.write("	}\r\n");
      out.write("	  \r\n");
      out.write("	.header-a:hover {\r\n");
      out.write("		text-decoration: none;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	.header-li {\r\n");
      out.write("		margin: 0 0 0 18px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.header-list {\r\n");
      out.write("	      font-size: 12pt;\r\n");
      out.write("\r\n");
      out.write("		  cursor: pointer;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.header-main-li {\r\n");
      out.write("		list-style: none;\r\n");
      out.write("		position: relative;\r\n");
      out.write("		top: 43%;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.header-second-li {\r\n");
      out.write("		list-style: none;\r\n");
      out.write("		position: relative;\r\n");
      out.write("		top: 43%;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	button.btn-search1{\r\n");
      out.write("		border: none;\r\n");
      out.write("		background-color: #F5F5F6;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	input#search-header {\r\n");
      out.write("		background-color: #F5F5F6;\r\n");
      out.write("		border: none;\r\n");
      out.write("		width:100%;\r\n");
      out.write("		padding-left: 34px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	input#search-header:focus{   /* input 태그 focus 시 */\r\n");
      out.write("		outline:none;\r\n");
      out.write("	}\r\n");
      out.write("	input#search-header:autofill {   /* 자동완성시 css 부분*/\r\n");
      out.write("		-webkit-box-shadow: 0 0 0px 1000px #F5F5F6 inset;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.header-tag-a {\r\n");
      out.write("		font-size: 27px;\r\n");
      out.write("		font-weight: bold;\r\n");
      out.write("		color: black;\r\n");
      out.write("		margin-right: 10px;\r\n");
      out.write("	}\r\n");
      out.write("	.header-tag-a:hover {\r\n");
      out.write("		color: black;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.header-tag-a-span {\r\n");
      out.write("		margin-right: 10px;\r\n");
      out.write("		bottom: 5px;\r\n");
      out.write("		position: relative;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    /* 크기가 md 이상일때 */\r\n");
      out.write("	@media (min-width: 860px) {\r\n");
      out.write("	  \r\n");
      out.write("	  .header-li {\r\n");
      out.write("	      margin: 0 0 0 24px;\r\n");
      out.write("	   }\r\n");
      out.write("	   \r\n");
      out.write("	  #header-div-input {\r\n");
      out.write("		 background: #F5F5F6;\r\n");
      out.write("	   }\r\n");
      out.write("	   \r\n");
      out.write("	   .header-second-li {\r\n");
      out.write("			margin: 0 0 0 auto;			\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		.footer-label {\r\n");
      out.write("			width: 300px;\r\n");
      out.write("		}\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	@media (max-width: 992px) and (min-width: 860px) {\r\n");
      out.write("		.footer-label {\r\n");
      out.write("			width: 280px;\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	/* 크기가 md 사이즈 이하일때 */\r\n");
      out.write("	@media (max-width: 859px) {\r\n");
      out.write("		.footer-label {\r\n");
      out.write("			background-color: transparent;		\r\n");
      out.write("		    border: none;\r\n");
      out.write("		    cursor: pointer;\r\n");
      out.write("		}\r\n");
      out.write("		.header-second-li {\r\n");
      out.write("			margin: 0 0 0 auto;	\r\n");
      out.write("			width: 26px;		\r\n");
      out.write("		}\r\n");
      out.write("		input#search-header {\r\n");
      out.write("			padding-left: 11px;\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("\r\n");
      out.write("	\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("	$(document).ready(function(){\r\n");
      out.write("		randomInput() ; // INPUT에 PLACEHOLDER 가 랜덤하게 들어가게 하는 방법\r\n");
      out.write("		$('button.btn-search1').on('click', function(event) {   // 버튼 클릭시 \r\n");
      out.write("		    event.preventDefault(); // 새로고침 안함\r\n");
      out.write("		    gosearch();\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("		$(window).on('resize', function() {					// 실시간 창 사이즈가 859 이상일때 버튼이 클릭해서 input 크기가 커졌을때 초기 상태로 돌린다.\r\n");
      out.write("			gosize();    \r\n");
      out.write("		});\r\n");
      out.write("		gosearch();\r\n");
      out.write("		gosize();\r\n");
      out.write("		\r\n");
      out.write("		$('input#search-header').on('keyup', function(event){\r\n");
      out.write("	    	if( event.keyCode == 13 ){\r\n");
      out.write("	    		goSearchWord();\r\n");
      out.write("	    	}\r\n");
      out.write("	    });\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("	}); \r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	function randomInput(){\r\n");
      out.write("	  const placeholders = [\r\n");
      out.write("	    '가디언즈 오브 갤럭시: Volume 3',\r\n");
      out.write("	    '분노의 질주: 더 얼티메이트',\r\n");
      out.write("	    '슬픔의 삼각형',\r\n");
      out.write("	    '인어 공주',\r\n");
      out.write("	    'CSI: 뉴욕',\r\n");
      out.write("	    '범죄도시3'\r\n");
      out.write("	  ];\r\n");
      out.write("	  const randomIndex = Math.floor(Math.random() * placeholders.length);\r\n");
      out.write("	  const button = $('<button>', { class: 'position-absolute btn-search1' }).append($('<i>', { class: 'fa-solid fa-magnifying-glass' }));\r\n");
      out.write("	  const input = $('<input>', { id: 'search-header', type: 'text', placeholder: placeholders[randomIndex],name:'searchWord' });\r\n");
      out.write("	  $('span.header-div-input').empty().append(button).append(input);\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	// 검색창 부분 사이즈 변경마다 다르게 \r\n");
      out.write("	let gosearchone = true;\r\n");
      out.write("	\r\n");
      out.write("	function gosearch() {\r\n");
      out.write("		\r\n");
      out.write("	  let windowWidth = $(window).width();   // 크기를 알아오기 위해 \r\n");
      out.write("\r\n");
      out.write("	  if (gosearchone && windowWidth < 859) {   // 버튼 누를때마다 달라지며 창크기가 859 미만일때 실행 \r\n");
      out.write("		$('.header-second-li').css({\r\n");
      out.write("	      width: ''\r\n");
      out.write("	    });\r\n");
      out.write("	    $('.footer-label').css({\r\n");
      out.write("		      width: ''\r\n");
      out.write("		});\r\n");
      out.write("	    $('input#search-header').css({\r\n");
      out.write("		     padding: '0 0 0 11px'\r\n");
      out.write("	    });\r\n");
      out.write("	    $('.header-li').css({\r\n");
      out.write("	    	display: 'flex'\r\n");
      out.write("	    });\r\n");
      out.write("	    $('button.btn-search1').css(\r\n");
      out.write("			'background-color', 'white'\r\n");
      out.write("		);\r\n");
      out.write("	    $('input#search-header ').css(\r\n");
      out.write("	    	'background-color', 'white'   \r\n");
      out.write("	    );\r\n");
      out.write("	    \r\n");
      out.write("	  } else if(!gosearchone && windowWidth < 859){  // 버튼 누를때마다 달라지며 창 크기가 859미만일대 실행 \r\n");
      out.write("	    \r\n");
      out.write("		$('.header-second-li').css({\r\n");
      out.write("	      width: '349px'\r\n");
      out.write("	    });\r\n");
      out.write("	    $('.footer-label').css({\r\n");
      out.write("		      width: '349px',\r\n");
      out.write("		      margin: '0 0 0 auto'\r\n");
      out.write("		      \r\n");
      out.write("		    });\r\n");
      out.write("	    $('input#search-header').css({\r\n");
      out.write("		     padding: '0 0 0 34px'\r\n");
      out.write("	    });\r\n");
      out.write("	    $('.header-li').css({\r\n");
      out.write("	    	display: 'none'\r\n");
      out.write("	    });\r\n");
      out.write("	    $('button.btn-search1').css(\r\n");
      out.write("			 'background-color', '#F5F5F6'\r\n");
      out.write("		);\r\n");
      out.write("	    $('input#search-header ').css(\r\n");
      out.write("	    	'background-color', '#F5F5F6'   \r\n");
      out.write("	    );\r\n");
      out.write("	  }\r\n");
      out.write("	  \r\n");
      out.write("	  gosearchone = ! gosearchone; // 누를때마다 css 추가\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	// 사이즈 변경 마다 평가하기 부분 & 검색 버튼 아이콘 부분  \r\n");
      out.write("	function gosize() {\r\n");
      out.write("		 let windowWidth = $(window).width();\r\n");
      out.write("		    \r\n");
      out.write("		if(windowWidth > 859){\r\n");
      out.write("	  	   $('.header-star').text('평가하기');\r\n");
      out.write("	  	   $('.header-star').css({\r\n");
      out.write("	  		   color: '#999999'\r\n");
      out.write("	  	   });\r\n");
      out.write("	  	   $('.header-login').text('로그인');\r\n");
      out.write("		   $('input#search-header').css({\r\n");
      out.write("			    padding: '0 0 0 34px'\r\n");
      out.write("		   });\r\n");
      out.write("		   $('button.btn-search1').css(\r\n");
      out.write("			    'background-color', '#F5F5F6'\r\n");
      out.write("		   );\r\n");
      out.write("		   $('input#search-header ').css(\r\n");
      out.write("		    	'background-color', '#F5F5F6'   \r\n");
      out.write("		   );\r\n");
      out.write("		   gosearchone = true;\r\n");
      out.write("	    } else {\r\n");
      out.write("	       $('.header-star').html('<i class=\"fa-solid fa-star fa-lg\"></i>');\r\n");
      out.write("	       $('.header-star').css({\r\n");
      out.write("		   	 color: '#999999'\r\n");
      out.write("		   });\r\n");
      out.write("	       $('.header-login').text('로그인');\r\n");
      out.write("	       $('button.btn-search1').css(\r\n");
      out.write("			    'background-color', 'white'\r\n");
      out.write("		   );\r\n");
      out.write("	       $('input#search-header ').css(\r\n");
      out.write("	    		'background-color', 'white'   \r\n");
      out.write("	       );\r\n");
      out.write("	       gosearchone = false;\r\n");
      out.write("	    }\r\n");
      out.write("	\r\n");
      out.write("		if (windowWidth > 859 && gosearchone) {\r\n");
      out.write("	      $('.header-second-li').css({\r\n");
      out.write("	        width: ''\r\n");
      out.write("	      });\r\n");
      out.write("	      $('.footer-label').css({\r\n");
      out.write("	        width: ''\r\n");
      out.write("	      });\r\n");
      out.write("	      $('input#search-header').css({\r\n");
      out.write("			     padding: '0 0 0 34px'\r\n");
      out.write("		  });\r\n");
      out.write("	      $(\".header-li\").css({\r\n");
      out.write("	        display: 'flex'\r\n");
      out.write("	      });\r\n");
      out.write("	    }\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	function goSearchWord(){\r\n");
      out.write("		// console.log( '확인용 ~~')\r\n");
      out.write("		const searchText = $('input#search-header').val();\r\n");
      out.write("		\r\n");
      out.write("		const searchFrm = document.searchFrm;\r\n");
      out.write("		searchFrm.action=\"");
      out.print(ctxPath);
      out.write("/go.action\";     /* // action 인것 바꾸기 */ \r\n");
      out.write("		searchFrm.method=\"get\";\r\n");
      out.write("		searchFrm.submit();	\r\n");
      out.write("		\r\n");
      out.write("	\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	function goNewMember() {\r\n");
      out.write("		// 회원가입 하러 가기 모달창?? \r\n");
      out.write("		alert(\"회원가입 \");\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<div class=\"d-none d-md-block\">\r\n");
      out.write("		<div class=\"container\">\r\n");
      out.write("			<div class=\"row\">\r\n");
      out.write("				<ul style=\"display: flex; padding: 0; margin: 0; overflow: hidden; width: 100%;\">\r\n");
      out.write("					<li style=\"list-style: none;\">\r\n");
      out.write("						<a href=\"#\"><img src=\"");
      out.print( ctxPath);
      out.write("/resources/images/watchapedia.png\" style=\"top: 10%; position: relative; width: 85%;\"></a>\r\n");
      out.write("					</li>\r\n");
      out.write("					<li class=\"header-main-li header-li\" style=\"margin: 0;\">	\r\n");
      out.write("						<span class=\"header-list\"><a href=\"#\" style=\"color: #999999\" class=\"header-a\">영화</a></span>\r\n");
      out.write("					</li>\r\n");
      out.write("					<li class=\"header-main-li header-li\">	\r\n");
      out.write("						<span class=\"header-list\"><a href=\"#\" style=\"color: #999999\" class=\"header-a\">TV</a></span> \r\n");
      out.write("					</li>	\r\n");
      out.write("					<li class=\"header-main-li header-li\">	\r\n");
      out.write("						<span class=\"header-list\"><a href=\"#\" style=\"color: #999999\" class=\"header-a\">책</a></span>\r\n");
      out.write("					</li>\r\n");
      out.write("					<li class=\"header-main-li header-li\">	\r\n");
      out.write("						<span class=\"header-list\"><a href=\"#\" style=\"color: #999999\" class=\"header-a\">웹툰</a></span>\r\n");
      out.write("					</li>\r\n");
      out.write("					<li class=\"header-second-li\">\r\n");
      out.write("						<div style=\"    position: relative; width: 100%;\">\r\n");
      out.write("						<form name=\"searchFrm\" id=\"searchFrm\">\r\n");
      out.write("							<label class=\"footer-label\">\r\n");
      out.write("							\r\n");
      out.write("								<span class=\"header-div-input\" style=\"top:40%; position: relative;\"></span>	\r\n");
      out.write("							\r\n");
      out.write("							</label>\r\n");
      out.write("						</form>\r\n");
      out.write("						</div>\r\n");
      out.write("					</li>	\r\n");
      out.write("					<li class=\"header-main-li\" style=\"margin-left: 24px;\">\r\n");
      out.write("						\r\n");
      out.write("						<!-- <c:if test=\"\">  로그인 안되어있으면 login 할 수 있게 나타내기 -->\r\n");
      out.write("							 <a href=\"#\" class=\"header-a\"><span class=\"header-login\"></span></a> \r\n");
      out.write("						<!-- </c:if> -->\r\n");
      out.write("						\r\n");
      out.write("						\r\n");
      out.write("						<!-- <c:if test=\"\">  로그인 되어 있으면 평가하기 나타내기 -->\r\n");
      out.write("							<!-- <a href=\"#\" class=\"header-a\"><span class=\"header-star\"></span></a> -->\r\n");
      out.write("						<!-- </c:if> -->\r\n");
      out.write("						\r\n");
      out.write("					</li>\r\n");
      out.write("					<li class=\"header-main-li\" style=\"margin-left: 24px;\">\r\n");
      out.write("						\r\n");
      out.write("						<!-- <c:if test=\"\">  로그인 안 되어 있으면 나타내기 -->	\r\n");
      out.write("							 <button type=\"button\" style=\"border-radius: 5px; bottom: 2px; position: relative; background-color: white; border: solid 1px #999999;\"  onclick=\"goNewMember()\">회원가입</button> \r\n");
      out.write("						<!-- </c:if> -->\r\n");
      out.write("						\r\n");
      out.write("						\r\n");
      out.write("						<!-- <c:if test=\"\">  로그인 되어 있으면 나타내기 -->	\r\n");
      out.write("							<!-- <a href=\"#\"><i class=\"fa-solid fa-user fa-lg\" style=\"color: #999999\"></i></a> -->\r\n");
      out.write("						<!-- </c:if> -->	\r\n");
      out.write("					\r\n");
      out.write("					\r\n");
      out.write("					</li>\r\n");
      out.write("				</ul>\r\n");
      out.write("				\r\n");
      out.write("				<div style=\"border: solid 1px #F5F5F6; width: 100%; margin: 10px 0 30px 0;\"></div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	\r\n");
      out.write("	<div class=\"d-block d-md-none\" >\r\n");
      out.write("		<div class=\"container\">\r\n");
      out.write("			<div class=\"row\">\r\n");
      out.write("				<ul style=\"display: flex; padding-left: 0; margin-bottom: 30px;\">\r\n");
      out.write("					<li class=\"header-main-li\">\r\n");
      out.write("						<a href=\"#\" class=\"header-tag-a header-a\">영화</a>\r\n");
      out.write("						<span class=\"header-tag-a-span\">|</span>\r\n");
      out.write("					</li>\r\n");
      out.write("					<li class=\"header-main-li\">\r\n");
      out.write("						<a href=\"#\" class=\"header-tag-a header-a\">TV</a>\r\n");
      out.write("						<span class=\"header-tag-a-span\">|</span>\r\n");
      out.write("					</li>\r\n");
      out.write("					<li class=\"header-main-li\">\r\n");
      out.write("						<a href=\"#\" class=\"header-tag-a header-a\">책</a>\r\n");
      out.write("						<span class=\"header-tag-a-span\">|</span>\r\n");
      out.write("					</li>\r\n");
      out.write("					<li class=\"header-main-li\">\r\n");
      out.write("						<a href=\"#\" class=\"header-tag-a header-a\">웹툰</a>\r\n");
      out.write("					</li>\r\n");
      out.write("				</ul>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>	\r\n");
      out.write("	</div>\r\n");
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
