/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.72
 * Generated at: 2023-06-02 05:51:51 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.tiles1.chatting;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class multichat_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/C:/NCS/workspace(spring)/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Board/WEB-INF/lib/jstl-1.2.jar!/META-INF/c-1_0.tld", Long.valueOf(1153352682000L));
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\r\n");
      out.write("	//=== !!! WebSocket 통신 프로그래밍은 HTML5 표준으로써 자바스크립트로 작성하는 것이다. !!! === //\r\n");
      out.write("	//WebSocket(웹소켓)은 웹 서버로 소켓을 연결한 후 데이터를 주고 받을 수 있도록 만든 HTML5 표준이다.\r\n");
      out.write("	//그런데 이러한 WebSocket(웹소켓)은 HTTP 프로토콜로 소켓 연결을 하기 때문에 웹 브라우저가 이 기능을 지원하지 않으면 사용할 수 없다. \r\n");
      out.write("	/*\r\n");
      out.write("	 >> 소켓(Socket)이란? \r\n");
      out.write("	- 어떤 통신프로그램이 네트워크상에서 데이터를 송수신할 수 있도록 연결해주는 연결점으로써 \r\n");
      out.write("	  IP Address와 port 번호의 조합으로 이루어진다. \r\n");
      out.write("	    또한 어떤 하나의 통신프로그램은 하나의 소켓(Socket)만을 가지는 것이 아니라 \r\n");
      out.write("	    동일한 프로토콜, 동일한 IP Address, 동일한 port 번호를 가지는 수십개 혹은 수만 개의 소켓(Socket)을 가질 수 있다.\r\n");
      out.write("	\r\n");
      out.write("	 =================================================================================================  \r\n");
      out.write("	    클라이언트  소켓(Socket)                       서버  소켓(Socket)\r\n");
      out.write("	  211.238.142.70:7942 ◎------------------------------------------◎  211.238.142.72:9090 (9090고정 포트 , 7942는 변동포트)\r\n");
      out.write("	    \r\n");
      out.write("	    클라이언트는 서버인 211.238.142.72:9090 소켓으로 클라이언트 자신의 정보인 211.238.142.70:7942 을 \r\n");
      out.write("	    보내어 연결을 시도하여 연결이 이루어지면 서버는 클라이언트의 소켓인 211.238.142.70:7942 으로 데이터를 보내면서 통신이 이루어진다.\r\n");
      out.write("	  ================================================================================================== \r\n");
      out.write("	         \r\n");
      out.write("	    소켓(Socket)은 데이터를 통신할 수 있도록 해주는 연결점이기 때문에 통신할 두 프로그램(Client, Server) 모두에 소켓이 생성되야 한다.\r\n");
      out.write("	\r\n");
      out.write("	  Server는 특정 포트와 연결된 소켓(Server 소켓)을 가지고 서버 컴퓨터 상에서 동작하게 되는데, \r\n");
      out.write("	    이 Server는 소켓을 통해 Cilent측 소켓의 연결 요청이 있을 때까지 기다리고 있다(Listening 한다 라고도 표현함).\r\n");
      out.write("	  Client 소켓에서 연결요청을 하면(올바른 port로 들어왔을 때) Server 소켓이 허락을 하여 통신을 할 수 있도록 연결(connection)되는 것이다.\r\n");
      out.write("	*/\r\n");
      out.write("	\r\n");
      out.write("	$(document).ready(function(){\r\n");
      out.write("		\r\n");
      out.write("		$(\"div#mycontent\").css({\"background-color\":\"#cce0ff\"});\r\n");
      out.write("		// div#mycontent 는  /Board/src/main/webapp/WEB-INF/tiles/layout/layout-tiles1.jsp 파일의 내용에 들어 있는 <div id=\"mycontent\"> 이다.\r\n");
      out.write("		\r\n");
      out.write("		const url = window.location.host; // 웹브라우저의 주소창의 포트까지 가져옴 \r\n");
      out.write("		//alert(\"url : \" + url);// 192.168.0.47:9090 이렇게만 알아온다.  \r\n");
      out.write("		// 결과 : url : 192.168.0.47:9090\r\n");
      out.write("		\r\n");
      out.write("		const pathname = window.location.pathname;    // 최초 '/' 부터 오른쪽에 있는 모든 경로 \r\n");
      out.write("		//alert(\"pathname : \" + pathname);\r\n");
      out.write("		// 결과 : pathname : /board/chatting/multichat.action\r\n");
      out.write("		\r\n");
      out.write("		const appCtx = pathname.substring( 0 ,pathname.lastIndexOf(\"/\"));  // 마지막으로 / 나오는곳 앞 위치값을 구해옴\r\n");
      out.write("										  // \"전체 문자열\".lastIndexOf(\"검사할 문자\"); \r\n");
      out.write("		// alert(\"appCtx : \"+ appCtx);\r\n");
      out.write("		// 결과 : appCtx : /board/chatting\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		// 웹소켓통신은 http가 아닌 ws:// 로 진행된다. \r\n");
      out.write("		const root = url + appCtx;\r\n");
      out.write("		//alert(\"root : \"+ root);    \r\n");
      out.write("		// 결과 : root : 192.168.0.47:9090/board/chatting\r\n");
      out.write("		\r\n");
      out.write("		const wsUrl = \"ws://\" + root + \"/multichatstart.action\";\r\n");
      out.write("					 //ws://192.168.0.47:9090/board/chatting/multichatstart.action\r\n");
      out.write("		// 웹소켓통신을 하기위해서는 http:// 을 사용하는 것이 아니라 ws:// 을 사용해야 한다. \r\n");
      out.write("		// \"/multichatstart.action\" 에 대한 것은 /WEB-INF/spring/config/websocketContext.xml 파일에 있는 내용이다. \r\n");
      out.write("	\r\n");
      out.write("		const websocket = new WebSocket(wsUrl);\r\n");
      out.write("		// 즉, const websocket = new webSocket(\"ws://192.168.0.47:9090/board/chatting/multichatstart.action\");  이다. !!!!!\r\n");
      out.write("		\r\n");
      out.write("		// >> ====== !!중요!! Javascript WebSocket 이벤트 정리 ====== << //\r\n");
      out.write("	      /*   -------------------------------------\r\n");
      out.write("	                             이벤트 종류             설명\r\n");
      out.write("	           -------------------------------------\r\n");
      out.write("	              onopen        WebSocket 연결\r\n");
      out.write("	              onmessage     메시지 수신\r\n");
      out.write("	              onerror       전송 에러 발생\r\n");
      out.write("	              onclose       WebSocket 연결 해제\r\n");
      out.write("	    */\r\n");
      out.write("	    \r\n");
      out.write("	    \r\n");
      out.write("	    let messageObj = {};   // 자바스크립트 객체 생성함.\r\n");
      out.write("	    \r\n");
      out.write("	    // === 웹소켓에 최초로 연결이 되었을 경우에 실행되어지는 콜백함수 정의 하기 === //\r\n");
      out.write("	    websocket.onopen = function() {\r\n");
      out.write("	    	//alert(\"웹소켓 연결됨\");\r\n");
      out.write("	    	$(\"div#chatStatus\").text(\"정보: 웹소켓에 연결이 성공됨!!\");\r\n");
      out.write("	    	\r\n");
      out.write("	    	messageObj = { message : \"채팅방에 <span style='color: red;'>입장</span> 했습니다\"\r\n");
      out.write("	    				 , type : \"all\"  /* 모든 사람에게 보내기 all, 한사람 one  */\r\n");
      out.write("	    				 , to : \"all\"    /* 타입이 one일때 특정한 사람 아이디 쓰기 */\r\n");
      out.write("	    				 };   // 자바 스크립트에서 객체의 데이터값 초기화 \r\n");
      out.write("	    	\r\n");
      out.write("	    	websocket.send(JSON.stringify(messageObj));			 \r\n");
      out.write("	    	// JSON.stringify(자바스크립트객체) 는 자바스크립트객체를 JSON 표기법의 문자열(string)로 변환한다\r\n");
      out.write("            // JSON.parse(JSON 표기법의 문자열) 는 JSON 표기법의 문자열(string)을 자바스크립트객체(object)로 변환해준다.\r\n");
      out.write("			/*\r\n");
      out.write("			   JSON.stringify({});                  // '{}'\r\n");
      out.write("			   JSON.stringify(true);                // 'true'\r\n");
      out.write("			   JSON.stringify('foo');               // '\"foo\"'\r\n");
      out.write("			   JSON.stringify([1, 'false', false]); // '[1,\"false\",false]'\r\n");
      out.write("			   JSON.stringify({ x: 5 });            // '{\"x\":5}'\r\n");
      out.write("			*/			 \r\n");
      out.write("			\r\n");
      out.write("			\r\n");
      out.write("			\r\n");
      out.write("			\r\n");
      out.write("			\r\n");
      out.write("	    }\r\n");
      out.write("	\r\n");
      out.write("	    // === 메시지 수신시 콜백 함수 정의하기 ===\r\n");
      out.write("	    websocket.onmessage = function(event){\r\n");
      out.write("	    	\r\n");
      out.write("	    	// event.data 는  수신되어진 메시지이다. 즉, 지금은「김유신 이순신 관리자」 이다.\r\n");
      out.write("	    	if(event.data.substr(0,1)==\"「\" && event.data.substr(event.data.length-1)==\"」\")  {   // 맨처음 글자 수가 「 마지막이 」이면\r\n");
      out.write("	    		$(\"div#connectingUserList\").html(event.data);\r\n");
      out.write("	    	}\r\n");
      out.write("	    	else {\r\n");
      out.write("	    		// event.data 는 수신받은 채팅 문자이다. \r\n");
      out.write("	    		$(\"div#chatMessage\").append(event.data);\r\n");
      out.write("	    		$(\"div#chatMessage\").append(\"<br/>\");\r\n");
      out.write("	    		$(\"div#chatMessage\").scrollTop(99999999);   // 스크롤이 맨 밑으로 나온다.\r\n");
      out.write("	    	}\r\n");
      out.write("	    };\r\n");
      out.write("	    \r\n");
      out.write("	    \r\n");
      out.write("	    // === 웹소켓 연결 해제시 콜백함수 정의하기 === //\r\n");
      out.write("	    websocket.onclose = function(){\r\n");
      out.write("	    	// 할 거 없음       \r\n");
      out.write("	    }\r\n");
      out.write("	    \r\n");
      out.write("	 	// === 메시지 입력후 엔터하기 === //\r\n");
      out.write("       $(\"input#message\").keyup(function(e){\r\n");
      out.write("          if(e.keyCode == 13) {\r\n");
      out.write("             $(\"input#btnSendMessage\").click();\r\n");
      out.write("          }\r\n");
      out.write("       });\r\n");
      out.write("	    \r\n");
      out.write("		// === 메시지 보내기 === //\r\n");
      out.write("       let isOnlyOneDialog = false; // 귀속말 여부. true 이면 귀속말, false 이면 모두에게 공개되는 말  \r\n");
      out.write("       \r\n");
      out.write("       $(\"input#btnSendMessage\").click(function(){\r\n");
      out.write("          \r\n");
      out.write("          if( $(\"input#message\").val().trim() != \"\" ) {\r\n");
      out.write("            \r\n");
      out.write("          // ==== 자바스크립트에서 replace를 replaceAll 처럼 사용하기 ====\r\n");
      out.write("            // 자바스크립트에서 replaceAll 은 없다.\r\n");
      out.write("            // 정규식을 이용하여 대상 문자열에서 모든 부분을 수정해 줄 수 있다.\r\n");
      out.write("            // 수정할 부분의 앞뒤에 슬래시를 하고 뒤에 gi 를 붙이면 replaceAll 과 같은 결과를 볼 수 있다.\r\n");
      out.write("            \r\n");
      out.write("               let messageVal = $(\"input#message\").val();\r\n");
      out.write("               messageVal = messageVal.replace(/<script/gi, \"&lt;script\"); \r\n");
      out.write("               // 스크립트 공격을 막으려고 한 것임.\r\n");
      out.write("               \r\n");
      out.write("               ");
      out.write("\r\n");
      out.write("               // 또는\r\n");
      out.write("               messageObj = {}; // 자바스크립트 객체 생성함.\r\n");
      out.write("               messageObj.message = messageVal;\r\n");
      out.write("               messageObj.type = \"all\";\r\n");
      out.write("               messageObj.to = \"all\";\r\n");
      out.write("               \r\n");
      out.write("               // 귓속말 대상이 있으면 one 으로 변경한다.\r\n");
      out.write("               const to = $(\"input#to\").val();\r\n");
      out.write("               if( to != \"\" ) {\r\n");
      out.write("                  messageObj.type = \"one\";\r\n");
      out.write("                   messageObj.to = to;\r\n");
      out.write("               }\r\n");
      out.write("               \r\n");
      out.write("               websocket.send(JSON.stringify(messageObj));\r\n");
      out.write("               // JSON.stringify() 는 값을 그 값을 나타내는 JSON 표기법의 문자열로 변환한다\r\n");
      out.write("            \r\n");
      out.write("            // 위에서 자신이 보낸 메시지를 웹소켓으로 보낸 다음에 자신이 보낸 메시지 내용을 웹페이지에 보여지도록 한다.\r\n");
      out.write("               const now = new Date();\r\n");
      out.write("               let ampm = \"오전 \";\r\n");
      out.write("               let hours = now.getHours();\r\n");
      out.write("               \r\n");
      out.write("               if(hours > 12) {\r\n");
      out.write("                    hours = hours - 12;\r\n");
      out.write("                    ampm = \"오후 \";\r\n");
      out.write("               }\r\n");
      out.write("               \r\n");
      out.write("               if(hours == 0) {\r\n");
      out.write("                    hours = 12;\r\n");
      out.write("               }\r\n");
      out.write("               \r\n");
      out.write("               if(hours == 12) {\r\n");
      out.write("                 ampm = \"오후 \";\r\n");
      out.write("               }\r\n");
      out.write("               \r\n");
      out.write("               let minutes = now.getMinutes();\r\n");
      out.write("               if(minutes < 10) {\r\n");
      out.write("                 minutes = \"0\"+minutes;\r\n");
      out.write("               }\r\n");
      out.write("             \r\n");
      out.write("               const currentTime = ampm + hours + \":\" + minutes; \r\n");
      out.write("               \r\n");
      out.write("               if(isOnlyOneDialog == false) {  // 귀속말이 아닌 경우\r\n");
      out.write("                  $(\"div#chatMessage\").append(\"<div style='background-color: #ffff80; display: inline-block; max-width: 60%; float: right; padding: 7px; border-radius: 15%; word-break: break-all;'>\" + messageVal + \"</div> <div style='display: inline-block; float: right; padding: 20px 5px 0 0; font-size: 7pt;'>\"+currentTime+\"</div> <div style='clear: both;'>&nbsp;</div>\");\r\n");
      out.write("                                                                                                                                                                          /* word-break: break-all; 은 공백없이 영어로만 되어질 경우 해당구역을 빠져나가므로 이것을 막기위해서 사용한다. */\r\n");
      out.write("               }\r\n");
      out.write("               else { // 귀속말인 경우. 글자색을 빨강색으로 함.\r\n");
      out.write("                  $(\"div#chatMessage\").append(\"<div style='background-color: #ffff80; display: inline-block; max-width: 60%; float: right; padding: 7px; border-radius: 15%; word-break: break-all; color: red;'>\" + messageVal + \"</div> <div style='display: inline-block; float: right; padding: 20px 5px 0 0; font-size: 7pt;'>\"+currentTime+\"</div> <div style='clear: both;'>&nbsp;</div>\");\r\n");
      out.write("                                                                                                                                                                           /* word-break: break-all; 은 공백없이 영어로만 되어질 경우 해당구역을 빠져나가므로 이것을 막기위해서 사용한다. */ \r\n");
      out.write("               }\r\n");
      out.write("               \r\n");
      out.write("               $(\"div#chatMessage\").scrollTop(999999999);\r\n");
      out.write("               \r\n");
      out.write("               $(\"input#message\").val(\"\");\r\n");
      out.write("               $(\"input#message\").focus();\r\n");
      out.write("          }\r\n");
      out.write("          \r\n");
      out.write("       });\r\n");
      out.write("       //////////////////////////////////////////////////////\r\n");
      out.write("    \r\n");
      out.write("       // 귀속말대화끊기 버튼은 처음에는 보이지 않도록 한다.\r\n");
      out.write("       $(\"button#btnAllDialog\").hide();\r\n");
      out.write("	    \r\n");
      out.write("       \r\n");
      out.write("\r\n");
      out.write("   	// 아래는 귓속말을 위해서 대화를 나누는 상대방의 이름을 클릭하면 상대방이름의 웹소켓id 를 알아와서 input태그인 귓속말대상웹소켓.getId()에 입력하도록 하는 것. \r\n");
      out.write("         $(document).on(\"click\", \"span.loginuserName\", function(){\r\n");
      out.write("            /* span.loginuserName 은 \r\n");
      out.write("                com.spring.chatting.websockethandler.WebsocketEchoHandler 의 \r\n");
      out.write("                public void handleTextMessage(WebSocketSession wsession, TextMessage message) 메소드내에\r\n");
      out.write("                162번 라인에 기재해두었음.\r\n");
      out.write("             */\r\n");
      out.write("             \r\n");
      out.write("             const ws_id = $(this).prev().text();\r\n");
      out.write("         //  alert(ws_id);\r\n");
      out.write("             $(\"input#to\").val(ws_id);\r\n");
      out.write("             \r\n");
      out.write("             $(\"span#privateWho\").text($(this).text());\r\n");
      out.write("             $(\"button#btnAllDialog\").show();\r\n");
      out.write("             $(\"input#message\").css({'background-color':'black', 'color':'white'});\r\n");
      out.write("             $(\"input#message\").attr(\"placeholder\",\"귀속말 메시지 내용\");\r\n");
      out.write("         \r\n");
      out.write("             isOnlyOneDialog = true; // 귀속말 대화임을 지정\r\n");
      out.write("         });\r\n");
      out.write("   	\r\n");
      out.write("   		\r\n");
      out.write("         // 귀속말대화끊기 버튼을 클릭한 경우에는 전체대상으로 채팅하겠다는 말이다.\r\n");
      out.write("         $(\"button#btnAllDialog\").click(function(){\r\n");
      out.write("            \r\n");
      out.write("            $(\"input#to\").val(\"\");\r\n");
      out.write("            $(\"span#privateWho\").text(\"\");\r\n");
      out.write("            $(\"input#message\").css({'background-color':'', 'color':''});\r\n");
      out.write("            $(\"input#message\").attr(\"placeholder\",\"메시지 내용\");\r\n");
      out.write("            $(this).hide();\r\n");
      out.write("            \r\n");
      out.write("            isOnlyOneDialog = false; // 귀속말 대화가 아닌 모두에게 공개되는 대화임을 지정.\r\n");
      out.write("         });\r\n");
      out.write("         \r\n");
      out.write("         \r\n");
      out.write("   	\r\n");
      out.write("	    \r\n");
      out.write("	});  // end of $(document)ready\r\n");
      out.write("	\r\n");
      out.write("\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"container-fluid\">\r\n");
      out.write("<div class=\"row\">\r\n");
      out.write("<div class=\"col-md-10 offset-md-1\">\r\n");
      out.write("   <div id=\"chatStatus\"></div>\r\n");
      out.write("   <div class=\"my-3\">\r\n");
      out.write("   - 상대방의 대화내용이 검정색으로 보이면 채팅에 참여한 모두에게 보여지는 것입니다.<br>\r\n");
      out.write("   - 상대방의 대화내용이 <span style=\"color: red;\">붉은색</span>으로 보이면 나에게만 보여지는 1:1 귓속말 입니다.<br>\r\n");
      out.write("   - 1:1 채팅(귓속말)을 하시려면 예를 들어, 채팅시 보이는 [이순신]대화내용 에서 이순신을 클릭하시면 됩니다.\r\n");
      out.write("   </div>\r\n");
      out.write("   <input type=\"hidden\" id=\"to\" placeholder=\"귓속말대상웹소켓.getId()\"/>\r\n");
      out.write("   <br/>\r\n");
      out.write("   ♡ 귓속말대상 : <span id=\"privateWho\" style=\"font-weight: bold; color: red;\"></span>\r\n");
      out.write("   <br>\r\n");
      out.write("   <button type=\"button\" id=\"btnAllDialog\" class=\"btn btn-secondary btn-sm\">귀속말대화끊기</button>\r\n");
      out.write("   <br><br>\r\n");
      out.write("   현재접속자명단:<br/>\r\n");
      out.write("   <div id=\"connectingUserList\" style=\" max-height: 100px; overFlow: auto;\"></div>\r\n");
      out.write("   \r\n");
      out.write("   <div id=\"chatMessage\" style=\"max-height: 500px; overFlow: auto; margin: 20px 0;\"></div>\r\n");
      out.write("\r\n");
      out.write("   <input type=\"text\"   id=\"message\" class=\"form-control\" placeholder=\"메시지 내용\"/>\r\n");
      out.write("   <input type=\"button\" id=\"btnSendMessage\" class=\"btn btn-success btn-sm my-3\" value=\"메시지보내기\" />\r\n");
      out.write("   <input type=\"button\" class=\"btn btn-danger btn-sm my-3 mx-3\" onclick=\"javascript:location.href='");
      out.print(request.getContextPath() );
      out.write("/index.action'\" value=\"채팅방나가기\" />\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
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
