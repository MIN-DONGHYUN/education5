/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.72
 * Generated at: 2023-06-01 03:11:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class project_005fdetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/C:/NCS/workspace(spring)/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Watcha/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
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
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems;

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
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.release();
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

    String ctxPath = request.getContextPath();

      out.write("     \r\n");
      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("	body {\r\n");
      out.write("		word-break: break-all; /* 공백없이 영어로만 되어질 경우 해당구역을 뚫고 빠져나감으로 이것을 막기 위해서 사용한다 */\r\n");
      out.write("		padding: 0;            /* 상 우 하 좌 모두 안쪽여백을 0px을 준 것이다. 즉, 바깥여백을 없는 것으로 한 것이다.*/\r\n");
      out.write("	}	\r\n");
      out.write("\r\n");
      out.write("	div#container{\r\n");
      out.write("		width: 70%;\r\n");
      out.write("		margin: 0px auto 20px auto; /* 상 하는 20px 우 좌는 남은 20%에서 좌우로 균등하게 주겠다. 즉, 화면의 가운데로 위치하겠다는 말이다.*/\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	div#left{\r\n");
      out.write("		 float: left;\r\n");
      out.write("		 width: 15%;\r\n");
      out.write("		 height: 420px; \r\n");
      out.write("		 background-color: white; \r\n");
      out.write("	} \r\n");
      out.write("	\r\n");
      out.write("	img#middle {\r\n");
      out.write("		 float: left;\r\n");
      out.write("		 background-repeat: no-repeat;\r\n");
      out.write("		 background-size:cover;  \r\n");
      out.write("		 background-position: center center; \r\n");
      out.write("		 height: 400px;\r\n");
      out.write("  	     width: 70%; \r\n");
      out.write("  	     background-blend-mode: multiply;\r\n");
      out.write("  	     border-radius: 10px 10px;\r\n");
      out.write("	} \r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	div#right{\r\n");
      out.write("		 float: left;\r\n");
      out.write("		 width: 15%;\r\n");
      out.write("		 height: 420px; \r\n");
      out.write("		 background-color: white;\r\n");
      out.write("		 \r\n");
      out.write("	}  \r\n");
      out.write("\r\n");
      out.write("	img#poster{\r\n");
      out.write("	    float: left;\r\n");
      out.write("		border: solid 1px #b3b3b3;\r\n");
      out.write("		width: 23%;\r\n");
      out.write("		height: 400px;\r\n");
      out.write("		border-radius: 10px 10px;\r\n");
      out.write("		background-repeat: no-repeat;\r\n");
      out.write("		background-size:cover;  \r\n");
      out.write("	}	\r\n");
      out.write("	  \r\n");
      out.write("	div#posterInfo{\r\n");
      out.write("	    float: left;\r\n");
      out.write("		border: solid 1px #b3b3b3;\r\n");
      out.write("		width: 75%;\r\n");
      out.write("		height: 400px; \r\n");
      out.write("		margin: 0px 0px 20px 20px; \r\n");
      out.write("		border-radius: 10px 10px;\r\n");
      out.write("	}	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	div#BasicInfo{\r\n");
      out.write("		border: solid 1.5px #b3b3b3;\r\n");
      out.write("		width: 100%;\r\n");
      out.write("		display: inline-block;\r\n");
      out.write("		height: 500px;\r\n");
      out.write("		border-radius: 10px 10px;\r\n");
      out.write("	}	\r\n");
      out.write("	\r\n");
      out.write("	div#cast{\r\n");
      out.write("		border: solid 1.5px #b3b3b3;\r\n");
      out.write("		width: 100%;\r\n");
      out.write("		display: inline-block;\r\n");
      out.write("		height: 470px;\r\n");
      out.write("		margin-top: 20px;\r\n");
      out.write("		border-radius: 10px 10px;	\r\n");
      out.write("	}	 \r\n");
      out.write("	\r\n");
      out.write("	div#Comment{\r\n");
      out.write("		border: solid 1.5px #b3b3b3;\r\n");
      out.write("		width: 100%;\r\n");
      out.write("		display: inline-block;\r\n");
      out.write("		height: 600px;\r\n");
      out.write("		margin-top: 20px;\r\n");
      out.write("		border-radius: 10px 10px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.eee{\r\n");
      out.write("		color: #eee; \r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	/*평가하기 시작*/\r\n");
      out.write("    .rate { display: inline-block;border: 0;margin-right: 15px;}\r\n");
      out.write("	.rate > input {display: none;}\r\n");
      out.write("	.rate > label {float: right;color: #ddd}\r\n");
      out.write("	.rate > label:before {display: inline-block;font-size: 2rem;padding: .3rem .2rem;margin: 0;cursor: pointer;font-family: FontAwesome;content: \"\\f005 \";}\r\n");
      out.write("	.rate .half:before {content: \"\\f089 \"; position: absolute;padding-right: 0;}\r\n");
      out.write("	.rate input:checked ~ label, \r\n");
      out.write("	.rate label:hover,.rate label:hover ~ label { color: #FDD346} \r\n");
      out.write("	.rate input:checked + .rate label:hover,\r\n");
      out.write("	.rate input input:checked ~ label:hover,\r\n");
      out.write("	.rate input:checked ~ .rate label:hover ~ label,  \r\n");
      out.write("	.rate label:hover ~ input:checked ~ label { color: #FDD346} \r\n");
      out.write("	/*평가하기 끝*/\r\n");
      out.write("	\r\n");
      out.write("	/* 출연,제작 시작 */ \r\n");
      out.write("	@media (max-width: 768px) {\r\n");
      out.write("	    .carousel-inner .carousel-item > div {\r\n");
      out.write("	        display: none;\r\n");
      out.write("	    }\r\n");
      out.write("	    .carousel-inner .carousel-item > div:first-child {\r\n");
      out.write("	        display: block;\r\n");
      out.write("	    }\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.carousel-inner .carousel-item.active,\r\n");
      out.write("	.carousel-inner .carousel-item-next,\r\n");
      out.write("	.carousel-inner .carousel-item-prev {\r\n");
      out.write("	    display: flex;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	/* display 3 */\r\n");
      out.write("	@media (min-width: 768px) {\r\n");
      out.write("	    \r\n");
      out.write("	    .carousel-inner .carousel-item-right.active,\r\n");
      out.write("	    .carousel-inner .carousel-item-next {\r\n");
      out.write("	      transform: translateX(33.333%);\r\n");
      out.write("	    }\r\n");
      out.write("	    \r\n");
      out.write("	    .carousel-inner .carousel-item-left.active, \r\n");
      out.write("	    .carousel-inner .carousel-item-prev {\r\n");
      out.write("	      transform: translateX(-33.333%);\r\n");
      out.write("	    }\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.carousel-inner .carousel-item-right,\r\n");
      out.write("	.carousel-inner .carousel-item-left{ \r\n");
      out.write("	  transform: translateX(0);\r\n");
      out.write("	}\r\n");
      out.write("	/* 출연,제작 끝 */\r\n");
      out.write("	\r\n");
      out.write("	/*보고싶어요 시작*/\r\n");
      out.write("	input[type=\"checkbox\"] { \r\n");
      out.write("	   opacity: 0;\r\n");
      out.write("	}\r\n");
      out.write("    /*보고싶어요 끝*/\r\n");
      out.write("	\r\n");
      out.write("	/*코멘트 시작*/\r\n");
      out.write("	div#registerComment{font-family: 'Noto Sans KR', sans-serif;}\r\n");
      out.write("	.modal-body textarea:focus,\r\n");
      out.write("	.modal-body input:focus {outline: none;}\r\n");
      out.write("	.fa-face-meh:hover{color: #ff0558; cursor: pointer;}\r\n");
      out.write("	/*코멘트 끝*/\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("	/* 출연, 제작 시작*/\r\n");
      out.write("	$(document).ready(function(){\r\n");
      out.write("		\r\n");
      out.write("		$('#recipeCarousel').carousel({ \r\n");
      out.write("			  interval: 10000\r\n");
      out.write("		});\r\n");
      out.write("	\r\n");
      out.write("	$('.carousel .carousel-item').each(function(){\r\n");
      out.write("	    var minPerSlide = 7;\r\n");
      out.write("	    var next = $(this).next();\r\n");
      out.write("	    if (!next.length) {\r\n");
      out.write("	        next = $(this).siblings(':first');\r\n");
      out.write("	    }\r\n");
      out.write("	    next.children(':first-child').clone().appendTo($(this));\r\n");
      out.write("	    \r\n");
      out.write("	    for (var i=0;i<minPerSlide;i++) {\r\n");
      out.write("	        next=next.next();\r\n");
      out.write("	        if (!next.length) {\r\n");
      out.write("	        	next = $(this).siblings(':first');\r\n");
      out.write("	      	}\r\n");
      out.write("	        \r\n");
      out.write("	        next.children(':first-child').clone().appendTo($(this));\r\n");
      out.write("	   }\r\n");
      out.write("	});\r\n");
      out.write("	/* 출연, 제작 끝*/\r\n");
      out.write("	\r\n");
      out.write("	/*보고싶어요 시작*/	\r\n");
      out.write("	$(\".seechange2\").hide(); \r\n");
      out.write("	\r\n");
      out.write("	$(\"input:checkbox[name='check_wantsee']\").click(function(){\r\n");
      out.write("		 \r\n");
      out.write("		if($('input:checkbox[name=\"check_wantsee\"]').is(\":checked\")) {\r\n");
      out.write("				$(\".seechange1\").hide(); \r\n");
      out.write("				$(\".seechange2\").show(); \r\n");
      out.write("				$(\".seechange2\").css({\"color\":\"#ff0558\"}); \r\n");
      out.write("			 	$(\".wantseei\").css({\"color\":\"#ff0558\"}); \r\n");
      out.write("			}\r\n");
      out.write("			else if(!$('input:checkbox[name=\"check_wantsee\"]').is(\":checked\")) {\r\n");
      out.write("				$(\".seechange1\").show(); \r\n");
      out.write("				$(\".seechange2\").hide(); \r\n");
      out.write("				$(\".wantseei\").css({\"color\":\"\"}); \r\n");
      out.write("			}\r\n");
      out.write("			\r\n");
      out.write("			$(\"input:checkbox[name='check_wantsee']\").toggle();\r\n");
      out.write("		\r\n");
      out.write("	  });\r\n");
      out.write("	/*보고싶어요 끝*/		\r\n");
      out.write("\r\n");
      out.write("	/*코멘트 시작*/		\r\n");
      out.write("	$(\"input:checkbox[name='check_comment']\").click(function(){\r\n");
      out.write("		\r\n");
      out.write("		if($('input:checkbox[name=\"check_comment\"]').is(\":checked\")) {\r\n");
      out.write("			 \r\n");
      out.write("		 	$(\".commenti\").css({\"color\":\"#ff0558\"}); \r\n");
      out.write("		}\r\n");
      out.write("		else if(!$('input:checkbox[name=\"check_comment\"]').is(\":checked\")) {\r\n");
      out.write("\r\n");
      out.write("			$(\".commenti\").css({\"background-color\":\"\",\"color\":\"\"}); \r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		$(\"input:checkbox[name='check_comment']\").toggle();\r\n");
      out.write("		\r\n");
      out.write("	  });\r\n");
      out.write("	/*코멘트 끝*/\r\n");
      out.write("	\r\n");
      out.write("	/*보는중 시작*/		\r\n");
      out.write("	$(\"input:checkbox[name='check_seeing']\").click(function(){\r\n");
      out.write("		  \r\n");
      out.write("		if($('input:checkbox[name=\"check_seeing\"]').is(\":checked\")) {\r\n");
      out.write("			 \r\n");
      out.write("		 	$(\".seeingi\").css({\"color\":\"#ff0558\"}); \r\n");
      out.write("		}\r\n");
      out.write("		else if(!$('input:checkbox[name=\"check_seeing\"]').is(\":checked\")) {\r\n");
      out.write("\r\n");
      out.write("			$(\".seeingi\").css({\"background-color\":\"\",\"color\":\"\"}); \r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		$(\"input:checkbox[name='check_seeing']\").toggle();\r\n");
      out.write("		\r\n");
      out.write("	  });\r\n");
      out.write("	/*보는중 끝*/ \r\n");
      out.write("	\r\n");
      out.write("	/* 영화 등 정보 불러오기 시작 */\r\n");
      out.write("	\r\n");
      out.write("	/* 영화 등 정보 불러오기 끝 */\r\n");
      out.write("	\r\n");
      out.write("	});//end of $(document).ready(function())----------------------------------------------------------------------------------\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css\">\r\n");
      out.write("\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>제품상세</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("	<div>\r\n");
      out.write("		<div id=\"left\"></div> \r\n");
      out.write("		<img id=\"middle\" src=\"https://image.tmdb.org/t/p/w1280");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.projectInfo.backdrop_path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("		<div id=\"right\"></div>\r\n");
      out.write("	</div>\r\n");
      out.write("	\r\n");
      out.write("	<div id=\"container\">\r\n");
      out.write("		 \r\n");
      out.write("		<img id=\"poster\" src=\"https://image.tmdb.org/t/p/w780");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.projectInfo.poster_path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("	\r\n");
      out.write("		<div id=\"posterInfo\"> \r\n");
      out.write("			<div style=\"margin: 30px 0 0 30px;\">\r\n");
      out.write("			\r\n");
      out.write("				<div style=\"margin: 0 0 20px 0; font-size: 40px; font-weight: bolder;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.projectInfo.movie_title}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</div>\r\n");
      out.write("				\r\n");
      out.write("				<div style=\"font-weight: bold;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.projectInfo.tagline}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</div>\r\n");
      out.write("	\r\n");
      out.write("				<hr style=\"margin-right: 40px;\">	 \r\n");
      out.write("				\r\n");
      out.write("				<div style=\"font-weight: bold;\">개봉일자:&nbsp;");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.projectInfo.release_date}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("&nbsp;&nbsp;<span style=\"color: #eee;\">|</span>&nbsp;&nbsp;러닝타임:&nbsp;");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.projectInfo.runtime}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("분&nbsp;&nbsp;<span style=\"color: #eee;\">|</span>&nbsp;&nbsp;평균별점:&nbsp;</div>  \r\n");
      out.write("				\r\n");
      out.write("				<hr style=\"margin-right: 40px;\"> \r\n");
      out.write("				 \r\n");
      out.write("				<div style=\"margin: 50px 0 10px 77px; font-weight: bold;\">평가하기</div> \r\n");
      out.write("				\r\n");
      out.write("				<fieldset class=\"rate\">\r\n");
      out.write("                     <input type=\"radio\" id=\"rating10\" name=\"rating\" value=\"10\"><label for=\"rating10\" title=\"5점\"></label>\r\n");
      out.write("                     <input type=\"radio\" id=\"rating9\" name=\"rating\" value=\"9\"><label class=\"half\" for=\"rating9\" title=\"4.5점\"></label>\r\n");
      out.write("                     <input type=\"radio\" id=\"rating8\" name=\"rating\" value=\"8\"><label for=\"rating8\" title=\"4점\"></label>\r\n");
      out.write("                     <input type=\"radio\" id=\"rating7\" name=\"rating\" value=\"7\"><label class=\"half\" for=\"rating7\" title=\"3.5점\"></label>\r\n");
      out.write("                     <input type=\"radio\" id=\"rating6\" name=\"rating\" value=\"6\"><label for=\"rating6\" title=\"3점\"></label>\r\n");
      out.write("                     <input type=\"radio\" id=\"rating5\" name=\"rating\" value=\"5\"><label class=\"half\" for=\"rating5\" title=\"2.5점\"></label>\r\n");
      out.write("                     <input type=\"radio\" id=\"rating4\" name=\"rating\" value=\"4\"><label for=\"rating4\" title=\"2점\"></label>\r\n");
      out.write("                     <input type=\"radio\" id=\"rating3\" name=\"rating\" value=\"3\"><label class=\"half\" for=\"rating3\" title=\"1.5점\"></label>\r\n");
      out.write("                     <input type=\"radio\" id=\"rating2\" name=\"rating\" value=\"2\"><label for=\"rating2\" title=\"1점\"></label>\r\n");
      out.write("                     <input type=\"radio\" id=\"rating1\" name=\"rating\" value=\"1\"><label class=\"half\" for=\"rating1\" title=\"0.5점\"></label>\r\n");
      out.write("                 </fieldset>\r\n");
      out.write("				\r\n");
      out.write("				<div style=\"margin: 0 0 0 270px; position: relative; bottom: 60px;\">  \r\n");
      out.write("					<div>\r\n");
      out.write("						<label for=\"check_wantsee\" style=\"cursor: pointer;\">\r\n");
      out.write("						   <i style=\"font-size: 23px;\" class=\"seechange1 fas fa-plus wantseei\"></i><i style=\"font-size: 23px; margin-right: 3.3px;\" class=\"seechange2 fas fa-bookmark\"></i><span class=\"wantseei\" style=\"font-weight: bolder\">&nbsp;&nbsp;보고싶어요</span>\r\n");
      out.write("						   <input type=\"checkbox\" id=\"check_wantsee\" name=\"check_wantsee\"/>\r\n");
      out.write("						</label>\r\n");
      out.write("					</div>\r\n");
      out.write("					\r\n");
      out.write("					");
      out.write("\r\n");
      out.write("			        <div style=\"position: relative; left: 125px; bottom: 33px;\">\r\n");
      out.write("			          <label for=\"check_comment\" style=\"cursor: pointer;\">\r\n");
      out.write("			             <span class=\"commenti\">\r\n");
      out.write("			               <button type=\"button\" data-toggle=\"modal\" data-target=\"#registerComment\" style=\"font-weight: bold; border: none; background-color: transparent;\">\r\n");
      out.write("			                 <i style=\"font-size: 23px;\" class=\"fas fa-pen-nib commenti\"></i>&nbsp;&nbsp;코멘트 등록\r\n");
      out.write("			               </button>\r\n");
      out.write("			             </span>\r\n");
      out.write("			          </label>\r\n");
      out.write("			        </div> \r\n");
      out.write("					\r\n");
      out.write("					<div style=\"position: relative; left: 275px; bottom: 66px; width: 100px;\"> \r\n");
      out.write("					  <label for=\"check_seeing\" style=\"cursor: pointer;\">\r\n");
      out.write("					    <i style=\"font-size: 23px;\" class=\"far fa-eye seeingi\"></i><span class=\"seeingi\" style=\"font-weight: bolder\">&nbsp;&nbsp;보는중</span></label>\r\n");
      out.write("						<input type=\"checkbox\" id=\"check_seeing\" name=\"check_seeing\"/>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("				\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("		<div id=\"BasicInfo\">\r\n");
      out.write("		\r\n");
      out.write("			<h4 style=\"margin: 30px 0 20px 30px; font-weight: bolder; \">기본 정보</h4>\r\n");
      out.write("		       \r\n");
      out.write("		       <div style=\"margin-left: 50px;\"> \r\n");
      out.write("			       <span style=\"margin-right: 65px;\">원제</span><span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.projectInfo.movie_title}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span>\r\n");
      out.write("			       \r\n");
      out.write("			       <hr style=\"margin-right: 40px;\"> \r\n");
      out.write("			        \r\n");
      out.write("			       <span style=\"margin-right: 5px;\">개봉일자 </span><span style=\"margin-left: 27px;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.projectInfo.release_date}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span>\r\n");
      out.write("			       \r\n");
      out.write("			       <hr style=\"margin-right: 40px;\"> \r\n");
      out.write("			       \r\n");
      out.write("			       <span>상영시간 </span><span style=\"margin-left: 35px;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.projectInfo.runtime}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("분</span>\r\n");
      out.write("			       \r\n");
      out.write("			       <hr style=\"margin-right: 40px;\"> \r\n");
      out.write("			         \r\n");
      out.write("			       <span style=\"margin-right: 55px;\">슬로건</span><span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.projectInfo.tagline}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span>  \r\n");
      out.write("			       \r\n");
      out.write("			       <hr style=\"margin-right: 40px;\"> \r\n");
      out.write("			       \r\n");
      out.write("			       <span style=\"width: 10%; vertical-align: top; display: inline-block;\">내용 </span>\r\n");
      out.write("			       \r\n");
      out.write("			       <span style=\"width: 80%; display: inline-block;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.projectInfo.overview}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span> \r\n");
      out.write("			   </div>\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("		<div id=\"cast\">\r\n");
      out.write("		\r\n");
      out.write("			<h4 style=\"margin: 30px 0 0 30px; font-weight: bolder; \">출연/제작</h4>\r\n");
      out.write("\r\n");
      out.write("			<div id=\"html\">\r\n");
      out.write("			");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("			");
      out.write("\r\n");
      out.write("			</div>  \r\n");
      out.write("		 \r\n");
      out.write("		 \r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("		<div id=\"Comment\">\r\n");
      out.write("		\r\n");
      out.write("			<h4 style=\"margin: 30px 0 0 30px; font-weight: bolder; \">코멘트</h4>\r\n");
      out.write("			  	\r\n");
      out.write("			\r\n");
      out.write("				\r\n");
      out.write("				\r\n");
      out.write("		      ");
      out.write("\r\n");
      out.write("		      <div class=\"modal fade\" id=\"registerComment\">\r\n");
      out.write("		        <div class=\"modal-dialog modal-dialog-centered\">\r\n");
      out.write("		          <div class=\"modal-content\">\r\n");
      out.write("		            <div class=\"modal-body\">\r\n");
      out.write("		              <h5 class=\"modal-title\" style=\"font-weight: bold;\">영화제목<button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button></h5>\r\n");
      out.write("		               <div class=\"my-2\">\r\n");
      out.write("		                 <textarea style=\"width: 100%; height: 450px; resize: none; border: none;\" placeholder=\"이 작품에 대한 생각을 자유롭게 표현해주세요.\"></textarea>\r\n");
      out.write("		               </div>\r\n");
      out.write("		               <div style=\"display: inline-block; width: 100%;\">\r\n");
      out.write("		                 <div style=\"display: inline-block; width: 83%;\">\r\n");
      out.write("		                   <label for=\"checkSpoiler\">\r\n");
      out.write("		                    <i class=\"fa-solid fa-face-meh fa-2xl\" style=\"color: #cccccc;\"></i>\r\n");
      out.write("		                    <input type=\"checkbox\" id=\"checkSpoiler\" style=\"display: none;\" />\r\n");
      out.write("		                   </label>\r\n");
      out.write("		                  <span style=\"color: #666666;\">스포일러가 포함된 코멘트를 가려보세요.</span>\r\n");
      out.write("		                 </div>\r\n");
      out.write("		                 <div style=\"display: inline-block; width: 16%; text-align: right;\">\r\n");
      out.write("		                  <button type=\"button\" class=\"btn\" style=\"color: #ffffff; background-color: #ff0558;\">등록</button>\r\n");
      out.write("		                 </div>\r\n");
      out.write("		               </div>\r\n");
      out.write("		            </div>\r\n");
      out.write("		          </div>\r\n");
      out.write("		        </div>\r\n");
      out.write("		      </div>\r\n");
      out.write("		\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("	</div>\r\n");
      out.write("	\r\n");
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
      // /WEB-INF/views/project_detail.jsp(368,3) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty requestScope.projectInfo.actorList}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("			\r\n");
          out.write("				<div class=\"row mx-auto my-auto\">\r\n");
          out.write("			        <div id=\"recipeCarousel\" class=\"carousel slide w-100\" data-ride=\"carousel\">\r\n");
          out.write("			            <div class=\"carousel-inner w-100\" role=\"listbox\">\r\n");
          out.write("			                \r\n");
          out.write("			                ");
          if (_jspx_meth_c_005fforEach_005f0(_jspx_th_c_005fif_005f0, _jspx_page_context))
            return true;
          out.write("\r\n");
          out.write("			                \r\n");
          out.write("			            </div>\r\n");
          out.write("			            <a class=\"carousel-control-prev w-auto\" href=\"#recipeCarousel\" role=\"button\" data-slide=\"prev\">\r\n");
          out.write("			                <span class=\"carousel-control-prev-icon bg-dark border border-dark rounded-circle\" aria-hidden=\"true\"></span>\r\n");
          out.write("			                <span class=\"sr-only\">Previous</span>\r\n");
          out.write("			            </a>\r\n");
          out.write("			            <a class=\"carousel-control-next w-auto\" href=\"#recipeCarousel\" role=\"button\" data-slide=\"next\">\r\n");
          out.write("			                <span class=\"carousel-control-next-icon bg-dark border border-dark rounded-circle\" aria-hidden=\"true\"></span>\r\n");
          out.write("			                <span class=\"sr-only\">Next</span>\r\n");
          out.write("			            </a>\r\n");
          out.write("			        </div>\r\n");
          out.write("		    	</div>\r\n");
          out.write("			");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f0);
      // /WEB-INF/views/project_detail.jsp(374,19) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("actor");
      // /WEB-INF/views/project_detail.jsp(374,19) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/project_detail.jsp(374,19) '${requestScope.projectInfo.actorList}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${requestScope.projectInfo.actorList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      // /WEB-INF/views/project_detail.jsp(374,19) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVarStatus("status");
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("					            <div class=\"carousel-item active\">\r\n");
            out.write("				                    <div class=\"col-md-4\">\r\n");
            out.write("				                        <div class=\"card\"> \r\n");
            out.write("				                            <img class=\"img-fluid card-img-top\" src=\"https://image.tmdb.org/t/p/w1280");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.projectInfo.backdrop_path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\">\r\n");
            out.write("				                            <div class=\"card-body\">\r\n");
            out.write("										    <h5 class=\"card-title\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${actor.actor_name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</h5>\r\n");
            out.write("										    <p class=\"card-text\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${actor.birthday}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</p>\r\n");
            out.write("										    <a href=\"#\" class=\"stretched-link\"></a>\r\n");
            out.write("										  </div>\r\n");
            out.write("				                        </div>\r\n");
            out.write("				                    </div>\r\n");
            out.write("				                </div>\r\n");
            out.write("			                ");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }
}