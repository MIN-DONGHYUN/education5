package com.spring.board.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.spring.board.common.FileManager;
import com.spring.board.common.MyUtil;
import com.spring.board.common.Sha256;
import com.spring.board.model.*;
import com.spring.board.service.InterBoardService;


/*                                                     controller 의 의존객체는 service//  service 의 의존 객체는 model
	사용자 웹브라우저 요청(View)  ==> DispatcherServlet ==> @Controller 클래스 <==>> Service단(핵심업무로직단, business logic단) <==>> Model단[Repository](DAO, DTO) <==>> myBatis <==>> DB(오라클)           
	(http://...  *.action)                                  |                                                                                                                              
	 ↑                                                View Resolver
	 |                                                      ↓
	 |                                                View단(.jsp 또는 Bean명)
	 -------------------------------------------------------| 
	
	사용자(클라이언트)가 웹브라우저에서 http://localhost:9090/board/test/test_insert.action 을 실행하면
	배치서술자인 web.xml 에 기술된 대로  org.springframework.web.servlet.DispatcherServlet 이 작동된다.
	DispatcherServlet 은 bean 으로 등록된 객체중 controller 빈을 찾아서  URL값이 "/test_insert.action" 으로
	매핑된 메소드를 실행시키게 된다.                                               
	Service(서비스)단 객체를 업무 로직단(비지니스 로직단)이라고 부른다.
	Service(서비스)단 객체가 하는 일은 Model단에서 작성된 데이터베이스 관련 여러 메소드들 중 관련있는것들만을 모아 모아서
	하나의 트랜잭션 처리 작업이 이루어지도록 만들어주는 객체이다.
	여기서 업무라는 것은 데이터베이스와 관련된 처리 업무를 말하는 것으로 Model 단에서 작성된 메소드를 말하는 것이다.
	이 서비스 객체는 @Controller 단에서 넘겨받은 어떤 값을 가지고 Model 단에서 작성된 여러 메소드를 호출하여 실행되어지도록 해주는 것이다.
	실행되어진 결과값을 @Controller 단으로 넘겨준다.
*/

// ==== #30. 컨트롤러 선언 ====
@Controller
/* XML에서 빈을 만드는 대신에 클래스명 앞에 @Component 어노테이션을 적어주면 해당 클래스는 bean으로 자동 등록된다. 
그리고 bean의 이름(첫글자는 소문자)은 해당 클래스명이 된다. 
즉, 여기서 bean의 이름은 boardController 이 된다. 
여기서는 @Controller 를 사용하므로 @Component 기능이 이미 있으므로 @Component를 명기하지 않아도 BoardController 는 bean 으로 등록되어 스프링컨테이너가 자동적으로 관리해준다. 
*/
@Component
public class BoardController {

	
	// === #35. 의존객체 주입하기(DI: Dependency Injection) ===
	   // ※ 의존객체주입(DI : Dependency Injection) 
	   //  ==> 스프링 프레임워크는 객체를 관리해주는 컨테이너를 제공해주고 있다.
	   //      스프링 컨테이너는 bean으로 등록되어진 BoardController 클래스 객체가 사용되어질때, 
	   //      BoardController 클래스의 인스턴스 객체변수(의존객체)인 BoardService service 에 
	   //      자동적으로 bean 으로 등록되어 생성되어진 BoardService service 객체를  
	   //      BoardController 클래스의 인스턴스 변수 객체로 사용되어지게끔 넣어주는 것을 의존객체주입(DI : Dependency Injection)이라고 부른다. 
	   //      이것이 바로 IoC(Inversion of Control == 제어의 역전) 인 것이다.
	   //      즉, 개발자가 인스턴스 변수 객체를 필요에 의해 생성해주던 것에서 탈피하여 스프링은 컨테이너에 객체를 담아 두고, 
	   //      필요할 때에 컨테이너로부터 객체를 가져와 사용할 수 있도록 하고 있다. 
	   //      스프링은 객체의 생성 및 생명주기를 관리할 수 있는 기능을 제공하고 있으므로, 더이상 개발자에 의해 객체를 생성 및 소멸하도록 하지 않고
	   //      객체 생성 및 관리를 스프링 프레임워크가 가지고 있는 객체 관리기능을 사용하므로 Inversion of Control == 제어의 역전 이라고 부른다.  
	   //      그래서 스프링 컨테이너를 IoC 컨테이너라고도 부른다.
	   
	   //  IOC(Inversion of Control) 란 ?
	   //  ==> 스프링 프레임워크는 사용하고자 하는 객체를 빈형태로 이미 만들어 두고서 컨테이너(Container)에 넣어둔후
	   //      필요한 객체사용시 컨테이너(Container)에서 꺼내어 사용하도록 되어있다.
	   //      이와 같이 객체 생성 및 소멸에 대한 제어권을 개발자가 하는것이 아니라 스프링 Container 가 하게됨으로써 
	   //      객체에 대한 제어역할이 개발자에게서 스프링 Container로 넘어가게 됨을 뜻하는 의미가 제어의 역전 
	   //      즉, IOC(Inversion of Control) 이라고 부른다.
	   
	   
	   //  === 느슨한 결합 ===
	   //      스프링 컨테이너가 BoardController 클래스 객체에서 BoardService 클래스 객체를 사용할 수 있도록 
	   //      만들어주는 것을 "느슨한 결합" 이라고 부른다.
	   //      느스한 결합은 BoardController 객체가 메모리에서 삭제되더라도 BoardService service 객체는 메모리에서 동시에 삭제되는 것이 아니라 남아 있다.
	   
	   // ===> 단단한 결합(개발자가 인스턴스 변수 객체를 필요에 의해서 생성해주던 것)
	   // private InterBoardService service = new BoardService(); 
	   // ===> BoardController 객체가 메모리에서 삭제 되어지면  BoardService service 객체는 멤버변수(필드)이므로 메모리에서 자동적으로 삭제되어진다.   
	
/*	
	@Resource     // bean 객체의 객체명으로 Bean 을 주입해준다.
	private InterBoardService boardService;  // InterBoardService 의 bean 을 찾는다.
	
	@Inject     // type 에 따라 알아서 자동적으로 Bean 을 주입해준다.
	private InterBoardService service;  // InterBoardService 의 bean 을 찾는다.
*/
	
	@Autowired     // type 에 따라 알아서 자동적으로 Bean 을 주입해준다.
	private InterBoardService service;  // InterBoardService 의 bean 을 찾는다.
	
	
	// === #155. 파일업로드 및 다운로드를 해주는 FileManager 클래스 의존객체 주입하기(DI : Dependency Injection) ===  
    @Autowired     // Type에 따라 알아서 Bean 을 주입해준다.
    private FileManager fileManager;
	
	
	
	// ===== ***** spring 기초 시작 ***** ===== //
	@RequestMapping(value="/test/test_insert.action")
	public String test_insert(HttpServletRequest request) {
		
		int n = service.test_insert();    // service단으로 넘긴다.  (InterBoardService 에서 받아온것)
		
		String message = "";
		
		if(n==1) {
			message = "데이터 입력 성공~";
		}
		else {
			message = "데이터 입력 실패 ㅠ";
		}
		
		request.setAttribute("message", message);
		request.setAttribute("n", n);   //request 에 담아서 view 단 페이지로 보내준다.
		
		
		return "test/test_insert";
	// /WEB-INF/views/test/test_insert.jsp 페이지를 만들어야 한다.	
	}
	
	
	@RequestMapping(value="/test/test_select.action")
	public String test_select(HttpServletRequest request) {
		
		List<TestVO> testvoList = service.test_select();
		
		request.setAttribute("testvoList", testvoList);
		
		
		return "test/test_select";
		// /WEB-INF/views/test/test_select.jsp 페이지를 만들어야 한다.		
	}
	
	
	
	// form 태그를 만들어보자 
	// @RequestMapping(value="/test/test_form.action", method = {RequestMethod.POST})   //오로지 POST 방식 만 허락하는 것임.
	// @RequestMapping(value="/test/test_form.action", method = {RequestMethod.GET})   //오로지 GET방식만 허락한다.
	@RequestMapping(value="/test/test_form.action")   //GET방식 및 POST 방식 모두 허락하는 것임.
	public String test_form(HttpServletRequest request) {
		
		String method = request.getMethod();
		
		if("GET".equalsIgnoreCase(method)) {   // GET 방식 이라면 
			
			return "test/test_form";   // view 단 페이지를 띄워라
			//  /WEB-INF/views/test/test_form.jsp 페이지를 만들어야 한다. 
		}
		else {  //post 방식이라면 
			
			String no = request.getParameter("no");
			String name = request.getParameter("name");
			
			// 값을 넘기려면 무조건 map으로 !!
			Map<String, String> paraMap = new HashMap<>();
			paraMap.put("no", no);
			paraMap.put("name", name);
			
			int n = service.test_insert(paraMap);  // insert 하기 위해 
			
			if(n == 1) {   // insert를 하였다면 
				return "redirect:/test/test_select.action";
		    	//   /test/test_select.action 페이지로 redirect(페이지이동)해라는 말이다.
			}
			else {
				return "redirect:/test/test_form.action";   
				// insert 못했다면 자기 페이지에 머무른다.
			}
			
			
		}
		
		
	}
	
	
	
	// form 태그 두번째 예시 VO 이용 
	@RequestMapping(value="/test/test_form_vo.action")   //GET방식 및 POST 방식 모두 허락하는 것임.
	public String test_form_vo(HttpServletRequest request, TestVO vo) {    //TestVO vo 는 자동적으로 TestVO 에 있는 것과 .jsp에 name 이 같다면 TestVO에 있는 Set 에 넣어준다.(현재 SetName, setNo)
		
		String method = request.getMethod();
		
		if("GET".equalsIgnoreCase(method)) {   // GET 방식 이라면 
			
			return "test/test_form_vo";   // view 단 페이지를 띄워라
			//  /WEB-INF/views/test/test_form_vo.jsp 페이지를 만들어야 한다. 
		}
		else {  //post 방식이라면 
			
			int n = service.test_insert(vo);
			
			
			if(n == 1) {   // insert를 하였다면 
				return "redirect:/test/test_select.action";
		    	//   /test/test_select.action 페이지로 redirect(페이지이동)해라는 말이다.
			}
			else {
				return "redirect:/test/test_form_vo.action";   
				// insert 못했다면 자기 페이지에 머무른다.
			}
			
			
		}
		
		
	}
	
	
	// form  세번째 실험 
	@RequestMapping(value="/test/test_form_2.action", method = {RequestMethod.GET})  //오로지 GET방식만 허락한다.
	public String test_form_2() {
		
		return "test/test_form_2";
		//   /WEB-INF/views/test/test_form_2.jsp 페이지를 만들어야 한다.
	}
	
	@RequestMapping(value="/test/test_form_2.action", method = {RequestMethod.POST}) //오로지 POST방식만 허락한다.
	public String test_form_2(HttpServletRequest request, TestVO vo) {
		
		int n = service.test_insert(vo);
		
		
		if(n == 1) {   // insert를 하였다면 
			return "redirect:/test/test_select.action";
	    	//   /test/test_select.action 페이지로 redirect(페이지이동)해라는 말이다.
		}
		else {
			return "redirect:/test/test_form_2.action";   
			// insert 못했다면 자기 페이지에 머무른다.
		}
	}
	
	
	
	
	/// ==== return 타입을 String 대신에 ModelAndView 를 사용해 보겠습니다. ==== //
	
	@RequestMapping(value="/test/test_form_vo_modelAndView.action")   //GET방식 및 POST 방식 모두 허락하는 것임.
	public ModelAndView test_form_vo_modelAndView(HttpServletRequest request, TestVO vo, ModelAndView mav) {    // ModelAndView 은 spring 에서 주고 있는 것이다.
		
		String method = request.getMethod();
		
		if("GET".equalsIgnoreCase(method)) {   // GET 방식 이라면 
			
			mav.setViewName("test/test_form_vo_modelAndView");
			//  /WEB-INF/views/test/test_form_vo.jsp 페이지를 만들어야 한다. 
		}
		else {  //post 방식이라면 
			
			int n = service.test_insert(vo);
			
			
			if(n == 1) {   // insert를 하였다면 
				mav.setViewName("redirect:/test/test_select_modelAndView.action");
		    	//   /test/test_select_modelAndView.action 페이지로 redirect(페이지이동)해라는 말이다.
			}
			else {
				mav.setViewName("redirect:/test/test_form_vo_modelAndView.action");  
				// insert 못했다면 /test_form_vo_modelAndView.action 자기 페이지에 머무른다.
			}
			
			
		}
		
		return mav;
		
		
	}
	
	@RequestMapping(value="/test/test_select_modelAndView.action", method = {RequestMethod.GET})  //오로지 GET방식만 허락한다.
	public ModelAndView test_select_modelAndView(ModelAndView mav) {
		
		
		List<TestVO> testvoList =  service.test_select();
		
		mav.addObject("testvoList", testvoList);     //request.setAttribute 와 같은 것이다.  밑에 경로에 값을 넘긴다.
		
		mav.setViewName("test/test_select_modelAndView");
		//    /WEB-INF/test/test_select_modelAndView.jsp 페이지를 만들어야 한다.
		
		return mav;
		
	}
	
	
	
	/// =============== ajax 연습 시작 ================= ///
	
	@RequestMapping(value="/test/test_form_3.action", method = {RequestMethod.GET})  //오로지 GET방식만 허락한다.
	public ModelAndView test_form_3(ModelAndView mav) {
			
		mav.setViewName("test/test_form_3");    //view 단 페이지를 띄워라 
		//    /WEB-INF/test/test_form_3.jsp 페이지를 만들어야 한다.
		
		return mav;
		
	}
	
	
	
	/*
	    @ResponseBody 란?
	        메소드에 @ResponseBody Annotation이 되어 있으면 return 되는 값은 View 단 페이지를 통해서 출력되는 것이 아니라 
	    return 되어지는 값 그 자체를 웹브라우저에 바로 직접 쓰여지게 하는 것이다. 
	        일반적으로 JSON 값을 Return 할때 많이 사용된다. 
	 */
	@ResponseBody    
	@RequestMapping(value="/test/ajax_insert.action", method = {RequestMethod.POST})  //오로지 POST방식만 허락한다.
	public String ajax_insert(HttpServletRequest request) {
		
		String no = request.getParameter("no");   // ajax 에서 넘어온 no를 대입
		String name = request.getParameter("name");   // ajax 에서 넘어온 no를 대입
		
		Map<String, String> paraMap = new HashMap<>();
		paraMap.put("no",no);
		paraMap.put("name",name);
		
		// map 저장한걸 service 단에 넘겨야 한다.
		
		int n = service.test_insert(paraMap);
		
		// 결과물을 json 형식으로 변경해야 한다.
		JSONObject jsonObj = new JSONObject();  // {} 형태로 나오게 된다.
		jsonObj.put("n", n);   // json 형태로 결과 값을 넣어준다 {"n":1}
		

		return jsonObj.toString();  //"{"n":1}" //String 타입으로 변경   다시 ajax로 돌아감
		
	}
	
	/*
	    @ResponseBody 란?
	        메소드에 @ResponseBody Annotation이 되어 있으면 return 되는 값은 View 단 페이지를 통해서 출력되는 것이 아니라 
	    return 되어지는 값 그 자체를 웹브라우저에 바로 직접 쓰여지게 하는 것이다. 
	        일반적으로 JSON 값을 Return 할때 많이 사용된다. 
	        
	    >>> 스프링에서 json 또는 gson을 사용한 ajax 구현시 데이터를 화면에 출력해 줄때 한글로 된 데이터가 '?'로 출력되어 한글이 깨지는 현상이 있다. 
               이것을 해결하는 방법은 @RequestMapping 어노테이션의 속성 중 produces="text/plain;charset=UTF-8" 를 사용하면 
               응답 페이지에 대한 UTF-8 인코딩이 가능하여 한글 깨짐을 방지 할 수 있다. <<<
	 */
	@ResponseBody
	@RequestMapping(value="/test/ajax_select.action", method = {RequestMethod.GET},  produces="text/plain;charset=UTF-8")  //오로지 GET방식만 허락한다.
	public String ajax_select() {
	
		// 데이터 베이스에 가서 정보를 몽땅 읽어오면 된다.
		List<TestVO> testvoList = service.test_select();
		
		JSONArray jsonArr = new JSONArray();  // 값을 읽어온걸 JSON 형태로 변경하기 위해 
		
		// 리스트에서 정보가 있다면 
		if(testvoList != null) {
			
			for( TestVO vo : testvoList) {   // 리스트를 하나하나 까보면 TestVO 에 있는 것이므로 
				
				JSONObject jsonObj = new JSONObject();  // {} 객체 생성 
				jsonObj.put("no", vo.getNo());   // TestVO 에 get에 저장되어 있으므로 이렇게 써야 한다.   {"no":"601"}
				jsonObj.put("name", vo.getName());   // TestVO 에 get에 저장되어 있으므로 이렇게 써야 한다.   {"no":"601" , "name":"이혜리"}
				jsonObj.put("writeday", vo.getWriteday());   // TestVO 에 get에 저장되어 있으므로 이렇게 써야 한다.   {"no":"601" , "name":"이혜리", "writeday":"2023-05-10 12:18:51"}
				
				jsonArr.put(jsonObj);
				
			}// end of for 
			
		}

		return jsonArr.toString();     // "[{"no":"601" , "name":"이혜리", "writeday":"2023-05-10 12:18:51"}]"
	}
	
	
	/// =============== ajax 연습 끝 ================= ///
	
	
	
	
	/// ===== ***** tiles 연습 시작 ***** ===== ///
	
	@RequestMapping(value="/test/tiles_test_1.action")
	public String tiles_test_1() {
		
		
		return "tiles_test_1.tiles1";
		//  /WEB-INF/views/tiles1/tiles_test_1.jsp 이 페이지를 만들어야 한다.
	}
	
	
	@RequestMapping(value="/test/tiles_test_2.action")
	public String tiles_test_2() {
		
		
		return "test/tiles_test_2.tiles1";
		//   /WEB-INF/views/tiles1/test/tiles_test_2.jsp 이 페이지를 만들어야 한다.
	}
	
	
	@RequestMapping(value="/test/tiles_test_3.action")
	public String tiles_test_3() {
		
		
		return "test/sample/tiles_test_3.tiles1";
		//   /WEB-INF/views/tiles1/test/sample/tiles_test_3.jsp 이 페이지를 만들어야 한다.
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////
	/// 이 앞은 tiles 1/////
	
	////////////////////////////////////////////////////////////////////////////////////////
	/// tiles 2 부분
	
	
	@RequestMapping(value="/test/tiles_test_4.action")
	public ModelAndView tiles_test_4(ModelAndView mav) {
		
		mav.setViewName("tiles_test_4.tiles2");
		//  /WEB-INF/views/tiles2/tiles_test_4.jsp 이 페이지를 만들어야 한다.
		
		return mav;
	}
	
	
	@RequestMapping(value="/test/tiles_test_5.action")
	public ModelAndView tiles_test_5(ModelAndView mav) {
		
		mav.setViewName("test/tiles_test_5.tiles2");
		//  /WEB-INF/views/tiles2/test/tiles_test_5.jsp 이 페이지를 만들어야 한다.
		
		return mav;
	}
	
	
	@RequestMapping(value="/test/tiles_test_6.action")
	public ModelAndView tiles_test_6(ModelAndView mav) {
		
		mav.setViewName("test/sample/tiles_test_6.tiles2");
		//  /WEB-INF/views/tiles2/test/sample/tiles_test_6.jsp 이 페이지를 만들어야 한다.
		
		return mav;
	}
	///////////////////////////////////////////////////////////////////////////////////
	
	
	@RequestMapping(value="/test/tiles_test_7.action")
	public ModelAndView tiles_test_7(ModelAndView mav) {
		
		mav.setViewName("test7/tiles_test_7.tiles3");
		//  /WEB-INF/views/tiles3/test7/content/tiles_test_7.jsp 이 페이지를 만들어야 한다.
		//  /WEB-INF/views/tiles3/test7/side.jsp 페이지를 만들어야 한다.
		return mav;
	}
	
	
	@RequestMapping(value="/test/tiles_test_8.action")
	public ModelAndView tiles_test_8(ModelAndView mav) {
		
		mav.setViewName("test8/tiles_test_8.tiles3");
		//  /WEB-INF/views/tiles3/test8/content/tiles_test_8.jsp 이 페이지를 만들어야 한다.
		//  /WEB-INF/views/tiles3/test8/side.jsp 페이지를 만들어야 한다.
		return mav;
	}
	
	//////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value="/test/tiles_test_9.action")
	public ModelAndView tiles_test_9(ModelAndView mav) {
		
		mav.setViewName("test9/tiles_test_9.tiles4");
		//  /WEB-INF/views/tiles4/test9/content/tiles_test_9.jsp 이 페이지를 만들어야 한다.
		return mav;
	}
	
	
	// tiles 와 관계 없다?
	@RequestMapping(value="/test/test_10.action")
	public ModelAndView tiles_test_10(ModelAndView mav) {
		
		mav.setViewName("test/test10");  // tiles 가 아니므로 1순위가 아니고 2순위인 접두어, 접미어를 만든다. 
		//  /WEB-INF/views/test/test10.jsp 이 페이지를 만들어야 한다.
		return mav;
	}
	
	
	
	
	/// ===== ***** tiles 연습 끝 ***** ===== ///
	
	

	// ===== ***** spring 기초 끝 ***** ===== //
	
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// ========================= ***** 게시판 시작 ***** ========================== // 
	
	// === #36. 메인 페이지 요청 === // 
	
	// 먼저 com.spring.board 패키지에 있는 HomeController 클래스에 가서 @Controller 을 주석처리한다.
	@RequestMapping(value="/")
	public ModelAndView home(ModelAndView mav) {
		
		mav.setViewName("redirect:/index.action");  //  /오로 url 치면 홈인 index.action을 불러온다. 
		// view 페이지 : /WEB-INF/views/tiles1/main/index.jsp 페이지를 생성해야 한다.	
		return mav;
	}
	
/*	
	@RequestMapping(value="/index.action")
	public ModelAndView index(ModelAndView mav) {
		
		
		List<String> imgfilenameList = service.getImgfilenameList();   // 메소드 생성 
		
		mav.addObject("imgfilenameList", imgfilenameList);
		mav.setViewName("main/index.tiles1");  // veiw 단 페이지를 어디로 할지 설정하는 것이다. 
		// view 페이지 : /WEB-INF/views/tiles1/main/index.jsp 페이지를 생성해야 한다.
		
		
		return mav;
	}
*/
	///////////////////////////////////////////////////////////////////////////////////
	// 또는 //
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value="/index.action")
	public ModelAndView index(ModelAndView mav) {
		
		mav = service.index(mav);

		return mav;
	}
	
	
	
	// === #40. 로그인 폼 페이지 요청 === //
	@RequestMapping(value="/login.action", method = {RequestMethod.GET})  // GET방식만 받아온다.
	public ModelAndView login(ModelAndView mav) {
		
		mav.setViewName("login/loginform.tiles1");
	// view 페이지 : /WEB-INF/views/tiles1/login/loginform.jsp 페이지를 생성해야 한다.
		
		return mav;
	}
	
	// === #41. 로그인 처리하기 === //
/*	
	@RequestMapping(value="/loginEnd.action", method = {RequestMethod.POST})  // POST방식만 받아온다.
	public ModelAndView loginEnd(ModelAndView mav, HttpServletRequest request) {  // 아이디와 비밀번호이므로 VO를 만들지 않고 request 를 사용하겠다.
		
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");    // loginform.jsp 에서 form 태그로 전송된것을 받아온다. 
		
		// 값이 두개 이상이므로 map 에 담자 
		Map<String, String> paraMap = new HashMap<>();
		
		paraMap.put("userid",userid);
		paraMap.put("pwd",Sha256.encrypt(pwd));    //패스워드는 암호화가 되어 있으므로 암호화 해서 비교하자  (단방향 암호화)
		
		MemberVO loginuser = service.getLoginMember(paraMap);   // 서비스 단으로 보낸다. (회원 정보를 얻어오는 것이 주 목적 )
		
		
		// 존재하지 않는 아이디 또는 비밀번호를 사용해서 로그인 실패시 
		if(loginuser == null) {
			String message = "아이디 또는 암호가 틀립니다.";
			String loc = "javascript:history.back()";
			
			mav.addObject("message",message);
			mav.addObject("loc",loc);
			
			//msg.jsp 에서 request로 받아오기 위해 addObject 사용 
			// alert("${requestScope.message}");  // 메시지 출력해주기  (어떤 메시지든 여기를 통함)
			// location.href="${requestScope.loc}";// 페이지 이동   ( 어떤 페이지는 이동 페이지 어떤 페이지는 시작 페이지)
			
			mav.setViewName("msg");   // tiles 안써도 됨 
			// view 페이지 : /WEB-INF/views/msg.jsp 페이지를 생성해야 한다.	
			
		}
		else {  // 아이디와 암호가 존재하는 경우 
			
			if(loginuser.getIdle() == 1) {// 로그인 한지 1년이 경과한 경우 
				String message = "로그인을 한지 1년이 지나서 휴먼 상태로 되었습니다. \\n관리자에게 문의바랍니다.";
				String loc = request.getContextPath()+"/index.action";
				// 원래는 위와 같이 index.action아 아니라 휴먼인 계정을 풀어주는  페이지로 잡아주어야 한다. (생략한 것이다.)
				
				mav.addObject("message",message);
				mav.addObject("loc",loc);
				
				//msg.jsp 에서 request로 받아오기 위해 addObject 사용 
				// alert("${requestScope.message}");  // 메시지 출력해주기  (어떤 메시지든 여기를 통함)
				// location.href="${requestScope.loc}";// 페이지 이동   ( 어떤 페이지는 이동 페이지 어떤 페이지는 시작 페이지)
				
				mav.setViewName("msg");   // tiles 안써도 됨 
			}
			else { // 로그인한지 1년이내인 경우
				
				HttpSession session =  request.getSession();
				// 메모리에 생성되어져 있는 session을 불러오는 것이다. 
				
				session.setAttribute("loginuser", loginuser);
				// session(세션)에 로그인 되어진 사용자 정보인 loginuser 을 키이름을 "loginuser" 으로 저장시켜두는 것이다.  
				
				if(loginuser.isRequirepwdChange() == true) {   // 암호를 마지막으로 변경한 것이 3개월이 경과한 경우 
					String message = "비밀번호를 변경하신지 3개월이 지났습니다. \\n암호를 변경하시는 것을 추천합니다.";
					String loc = request.getContextPath()+"/index.action";
					// 원래는 위와 같이 index.action아 아니라 사용자의 암호를 변경해주는 페이지로 잡아주어야 한다. (생략한 것이다.)
					
					mav.addObject("message",message);
					mav.addObject("loc",loc);
					
					//msg.jsp 에서 request로 받아오기 위해 addObject 사용 
					// alert("${requestScope.message}");  // 메시지 출력해주기  (어떤 메시지든 여기를 통함)
					// location.href="${requestScope.loc}";// 페이지 이동   ( 어떤 페이지는 이동 페이지 어떤 페이지는 시작 페이지)
					
					mav.setViewName("msg");   // tiles 안써도 됨 
				}
				else { // 암호를 마지막으로 변경한 것이 3개월 이내인 경우 
					
					// 로그인을 해야만 접근할 수 있는 페이지에 로그인을 하지 않은 상태에서 접근을 시도한 경우 
		            // "먼저 로그인을 하세요!!" 라는 메시지를 받고서 사용자가 로그인을 성공했다라면
		            // 화면에 보여주는 페이지는 시작페이지로 가는 것이 아니라
		            // 조금전 사용자가 시도하였던 로그인을 해야만 접근할 수 있는 페이지로 가기 위한 것이다.
					
					String goBackURL = (String) session.getAttribute("goBackURL");   // BoardAOP 에서 저장해온 session 값을 가져온다.
					
					// 가져온 값이 존재한다면 
					if(goBackURL != null) {
						mav.setViewName("redirect:" + goBackURL);
						session.removeAttribute("goBackURL");   //goBackURL 의 세션을 제거한다.  즉 세션에서 반드시 제거해야 한다.
					}
					else {   // 처음부터 로그인을 시도 했다면 
						mav.setViewName("redirect:/index.action"); // 시작페이지로 이동한다. 
					}
				}
			}
		}
		
	//	mav.setViewName("");
	// view 페이지 : /WEB-INF/views/tiles1/login/loginform.jsp 페이지를 생성해야 한다.	
		
		
		return mav;
	}
*/	
	///////////////////////////////////////////////////////////////////////////
	// 또는 
	///////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value="/loginEnd.action", method = {RequestMethod.POST})  // POST방식만 받아온다.
	public ModelAndView loginEnd(ModelAndView mav, HttpServletRequest request) {  // 아이디와 비밀번호이므로 VO를 만들지 않고 request 를 사용하겠다.
		
	  String userid = request.getParameter("userid");
	  String pwd = request.getParameter("pwd");    // loginform.jsp 에서 form 태그로 전송된것을 받아온다. 
			
	  // 값이 두개 이상이므로 map 에 담자 
	  Map<String, String> paraMap = new HashMap<>();
	 
	  paraMap.put("userid",userid);
	  paraMap.put("pwd",Sha256.encrypt(pwd));    //패스워드는 암호화가 되어 있으므로 암호화 해서 비교하자  (단방향 암호화)
		
	  service.loginEnd(mav, request, paraMap);
	  
		
	  return mav;
	}
	
	
	
	
	// === #50. 로그아웃 처리하기 === //
	@RequestMapping(value="/logout.action")  
	public ModelAndView logout(ModelAndView mav, HttpServletRequest request) {
		
		// 로그아웃시 시작페이지로 돌아가는 것임 
		HttpSession session = request.getSession();
		session.invalidate();    // 세션의 값을 날려버린다. 
		
		String message = "로그아웃 되었습니다.";
		String loc = request.getContextPath()+"/index.action";
		// 원래는 위와 같이 index.action아 아니라 사용자의 암호를 변경해주는 페이지로 잡아주어야 한다. (생략한 것이다.)
		
		mav.addObject("message",message);
		mav.addObject("loc",loc);
		
		//msg.jsp 에서 request로 받아오기 위해 addObject 사용 
		// alert("${requestScope.message}");  // 메시지 출력해주기  (어떤 메시지든 여기를 통함)
		// location.href="${requestScope.loc}";// 페이지 이동   ( 어떤 페이지는 이동 페이지 어떤 페이지는 시작 페이지)
		
		mav.setViewName("msg");   // tiles 안써도 됨 
		//  /WEB-INF/Views/msg.jsp
		
		
		return mav;
	}
	
	
	// === #51. 게시판 글쓰기 폼 페이지 요청 === //
	@RequestMapping(value="/add.action", method = {RequestMethod.GET})
	public ModelAndView requiredLogin_add( HttpServletRequest request, HttpServletResponse response, ModelAndView mav) {   // request 를 통해 세션 정보 얻어오기 response 사용한 이유는 dispatcher 에서 사용하기 위해 
	
		// === $142. 답변 글쓰기가 추가된 경우 시작 === //
		String fk_seq = request.getParameter("fk_seq");
		String groupno = request.getParameter("groupno");
		String depthno = request.getParameter("depthno");
		String subject = "[답변] " + request.getParameter("subject");
		
		/*
	        view.jsp 에서 "답변글쓰기" 를 할때 글제목에 [ 또는 ] 이 들어간 경우 아래와 같은 오류가 발생한다.
	              
	        HTTP 상태 400 – 잘못된 요청
		        메시지 요청 타겟에서 유효하지 않은 문자가 발견되었습니다. 유효한 문자들은 RFC 7230과 RFC 3986에 정의되어 있습니다.
		           
		        해결책은 
		        톰캣의 C:\apache-tomcat-9.0.72\conf\server.xml 에서 
		        <Connector port="9090" URIEncoding="UTF-8" protocol="HTTP/1.1"
		             connectionTimeout="20000"
		             redirectPort="8443" /> 
		                에 가서
		        <Connector port="9090" URIEncoding="UTF-8" protocol="HTTP/1.1"
		             connectionTimeout="20000"
		             redirectPort="8443"
		             relaxedQueryChars="[]()^|&quot;" />  
		                   
		         와 같이 relaxedQueryChars="[]()^|&quot;" 을 추가해주면 된다.    
	    */
		
		
		// 이건 꼭 필요한 것이다. 원글쓰기면 null 이므로 답변하기 에는 적용 X
		if(fk_seq == null){
			fk_seq = "";
		}
		
		mav.addObject("fk_seq",fk_seq);
		mav.addObject("groupno",groupno);
		mav.addObject("depthno",depthno);
		mav.addObject("subject",subject);
		// === $142. 답변 글쓰기가 추가된 경우 끝 === //
		

		mav.setViewName("board/add.tiles1");
		// view 페이지 : /WEB-INF/views/tiles1/board/add.jsp 페이지를 생성해야 한다.
			
		return mav;
	}
	
	
	// === #54. 게시판 글쓰기 완료 요청 === //
	@RequestMapping(value="/addEnd.action", method = {RequestMethod.POST})
	
	// <== 아래의 코드는 After Advice 를 사용하기 전에 사용한 것 
//	public ModelAndView addEnd(ModelAndView mav, BoardVO boardvo) {   // request 를 통해 세션 정보 얻어오기 response 사용한 이유는 dispatcher 에서 사용하기 위해 
//	public ModelAndView pointPlus_addEnd(Map<String,String> paraMap, ModelAndView mav, BoardVO boardvo) {   // <== After Advice 를 사용하기 
	public ModelAndView pointPlus_addEnd(Map<String,String> paraMap, ModelAndView mav, BoardVO boardvo, MultipartHttpServletRequest mrequest) {   // <== After Advice 를 사용하기 및 파일첨부하기 
		   // MultipartHttpServletRequest mrequest 써야 파일 첨부파일 받을수 있다.
		
		/*   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			form 태그의 name 명과 BoardVO 의 필드명이 같다면  (add.jsp 의 form)
			request.getParameter("form 태그의 name명"); 을 사용하지 않더라도
			자동적으로 VoardVO boardvo 에 set 되어진다.
		*/
		
		/*
	      === #151. 파일첨부가 된 글쓰기 이므로  
	              먼저 위의  public ModelAndView pointPlus_addEnd(Map<String,String> paraMap, ModelAndView mav, BoardVO boardvo) { 을 
	              주석처리 한 이후에 아래와 같이 한다.
	       MultipartHttpServletRequest mrequest 를 사용하기 위해서는 
	              먼저 /Board/src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml 에서     
	       #21 파일업로드 및 파일다운로드에 필요한 의존객체 설정하기 를 해두어야 한다.  
	   */
		
		/*
		        웹페이지에 요청 form이 enctype="multipart/form-data" 으로 되어있어서 Multipart 요청(파일처리 요청)이 들어올때 
		        컨트롤러에서는 HttpServletRequest 대신 MultipartHttpServletRequest 인터페이스를 사용해야 한다.
		    MultipartHttpServletRequest 인터페이스는 HttpServletRequest 인터페이스와  MultipartRequest 인터페이스를 상속받고있다.
		        즉, 웹 요청 정보를 얻기 위한 getParameter()와 같은 메소드와 Multipart(파일처리) 관련 메소드를 모두 사용가능하다.     
		*/   
		
		
		// ===  사용자가 쓴 글에 파일이 첨부되어 있는 것인지, 아니면 파일 첨부가 안된 것인지 구분을 지어 주어야 한다.  === //
		// === #153. !!! 첨부파일이 있는 경우 작업 시작 !!! === // 
		
		MultipartFile attach = boardvo.getAttach(); // MultipartFile 을 받는다.
		
		// 파일을 받아왔다면 
		if(!attach.isEmpty()) {
			// attach(첨부파일)이 비어있지 않으면 (즉, 첨부파일이 있는 경우라면 )
			/*
	            1. 사용자가 보낸 첨부파일을 WAS(톰캣)의 특정 폴더에 저장해주어야 한다. 
	            >>> 파일이 업로드 되어질 특정 경로(폴더)지정해주기
	                       우리는 WAS의 webapp/resources/files 라는 폴더로 지정해준다.
	                       조심할 것은  Package Explorer 에서  files 라는 폴더를 만드는 것이 아니다.       
	         */
			
			// WAS(톰켓)dml webapp의 절대경로를 알아와야 한다. 
			HttpSession session = mrequest.getSession();
			String root = session.getServletContext().getRealPath("/");     // wabapp의 절대경로를 알아오는 것이다.
			
			// System.out.println("확인용 webapp의 절대경로 : " + root);
			// 확인용 webapp의 절대경로 : C:\NCS\workspace(spring)\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Board\
			
			String path = root + "resources" +File.separator + "files";
			/* File.separator 는 운영체제에서 사용하는 폴더와 파일의 구분자이다.
		            운영체제가 Windows 이라면 File.separator 는  "\" 이고,
		            운영체제가 UNIX, Linux, 매킨토시(맥) 이라면  File.separator 는 "/" 이다. 
		    */
			
			//path 가 첨부파일이 저장될 WAS(톰캣)의 폴더가 된다. 
			
			// System.out.println("확인용 path의 절대경로 : " + path);
			// 확인용 path의 절대경로 : C:\NCS\workspace(spring)\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Board\resources\files
			
			// (files란 폴더가 없으므로 세팅을 해서 만들기도 해야한다)
			
			/*
				2. 파일 첨부를 위한 변수의 설정 및 값을 초기화 한 후 파일 올리기 
			*/
			String newFileName = "";   // 시-분-초로 나올 것을 설정
			// WAS(톰캣)의 디스크에 저장될 파일명 
			
			byte[] bytes = null;
			// 첨부파일의 내용물을 담는것 
			
			long fileSize = 0;  
			// 첨부 파일의 크기 
			
			try {
				bytes = attach.getBytes();
				// 첨부파일의 내용물을 읽어오는 것 
				
				String originalFilename= attach.getOriginalFilename();   // 첨부되어진 파일 실제 이름을 읽어온다.
				// attach.getOriginalFilename() 이 첨부파일명의 파일명(예: 강아지.png) 이다.
				
				// System.out.println("확인용 originalFilename => " + originalFilename);
				// 확인용 originalFilename => 답변하기 완료시 나오는 모습 .png

									               // 내용물,  원래 파일 이름명,      경로 
				newFileName = fileManager.doFileUpload(bytes, originalFilename, path);  // FileManager 의 29번줄 간다
				// 첨부되어진 파일을 업로드 하는 것이다. 
				
				//System.out.println("확인용 newFileName 은 => " + newFileName);
				// 확인용 newFileName 은 => 20230522103657307555447084700.txt
				// 확인용 newFileName 은 => 20230522103850307668665841200.txt
				
				// => C:\NCS\workspace(spring)\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Board\resources\files 에 첨부파일이 올라갔다.
				// 하지만 똑같은 파일을 올리더라도 나노시간 때문에 파일이름을 달리 만들어 중복이 되지 않는다. 
			
				
				
			/*
				3. BoardVO boardvo 에 fileName 값과 orgFilename 값과 fileSize 값을 넣어주기 
			*/ 
				
				
				
				boardvo.setFileName(newFileName);   
				//WAS(톰캣) 에 저장된 파일명  ex) 20230522103657307555447084700.txt 
				
				boardvo.setOrgFilename(originalFilename);
				// 게시판 페이지에서 첨부된 파일(강아지.png)을 보여줄 때 사용.
	            // 또한 사용자가 파일을 다운로드 할때 사용되어지는 파일명으로 사용.

				
				
				fileSize = attach.getSize();
				boardvo.setFileSize(String.valueOf(fileSize));  // long 타입인 fileSize를 String타입으로 변경 
				
				
				
			} catch (Exception e) {   // 파일을 못 읽어온다면 오류 처리하기 
				e.printStackTrace();
			} 

		}
		
		
		// === #153. !!! 첨부파일이 있는 경우 작업 끝 !!! === // 
		
		// int n = service.add(boardvo);   // <== 파일첨부가 없는 글쓰기 
		
		// === #156. 파일 첨부가 있는 글스기 또는 파일첨부가 없는 글쓰기로 나뉘어서 service 호출하기 === //
		// 먼저 위의 int n = service.add(boardvo); 부분을 주석처리하고서 아래와 같이 한다. //
		
		int n = 0;
		
		if( attach.isEmpty() ) {
			// 파일 첨부가 없는 경우라면
			n = service.add(boardvo);
		}
		else {
			// 파일 첨부가 있는 경우라면 
			n = service.add_withFile(boardvo); 
			
		}
		
		if(n == 1) {
			mav.setViewName("redirect:/list.action");
			// /list.action 페이지로 redirect(페이지 이동) 해라는 말이다.
		}
		else {
			mav.setViewName("board/error/add_error.tiles1");
			// view 페이지 : /WEB-INF/views/tiles1/board/error/add_error.jsp 페이지를 생성해야 한다.
			
		}
		
		// ==== #96. After Advice 를 사용하기 === //
		//           글쓰기를 한 이후에 회원의 포인트를 100 점 증가 
		// === After Advice 를 사용하기 위해 파라미터를 생성하는 것임.
		paraMap.put("userid", boardvo.getFk_userid());    // member 테이블에 user의 포인트를 바꿔야 하므로 userid를 가져옴
		paraMap.put("point", "100");                      // 100 점을 증가시키기 위해 
		
		return mav;
	}
	
	
	// === #58. 글 목록 보기 페이지 요청 === //
	@RequestMapping(value="/list.action")
	public ModelAndView list(ModelAndView mav, HttpServletRequest request) { 
	
		List<BoardVO> boardList = null;  // 글 목록이 없을 수 있으니 기본값 null로 준다.

		//////////////////////////////////////////////////////
		// === #69. 글조회수(readCount)증가 (DML문 update)는
		//          반드시 목록보기에 와서 해당 글제목을 클릭했을 경우에만 증가되고,
		//          웹브라우저에서 새로고침(F5)을 했을 경우에는 증가가 되지 않도록 해야 한다.
		//          이것을 하기 위해서는 session 을 사용하여 처리하면 된다.
		
		HttpSession session = request.getSession();
		session.setAttribute("readCountPermission", "yes");
		
		/*
	        session 에  "readCountPermission" 키값으로 저장된 value값은 "yes" 이다.
	        session 에  "readCountPermission" 키값에 해당하는 value값 "yes"를 얻으려면 
		        반드시 웹브라우저에서 주소창에 "/list.action" 이라고 입력해야만 얻어올 수 있다. 
	     */
       //////////////////////////////////////////////////////
		
		// === 페이징 처리를 안한 검색어가 없는 전체 글 목록을 보여주기 === //
		//boardList = service.boardListNoSearch();    // DB에 검색이 없고 모두 보여주는 메소드
		
		// === #102.페이징 처리를 안한 검색어가 없는 전체 글 목록을 보여주기 === //
	/*	
		String searchType = request.getParameter("searchType");
		String searchWord = request.getParameter("searchWord");
		
		if(searchType == null) {
			searchType = "";
		}
		
		if(searchWord == null) {
			searchWord = "";
		}
		
		if(searchWord != null) {
			searchWord = searchWord.trim();
			// "           "  ==> "" 공백 제거
		}
		
		Map<String, String> paraMap = new HashMap<>();
		paraMap.put("searchType", searchType);
		paraMap.put("searchWord", searchWord);
		
		boardList = service.boardListSearch(paraMap);
		
		// 아래는 검색대상 컬럼과 검색어를 유지시키기 위한 것이다.
		if(!"".equals(searchType) && !"".equals(searchWord)) {
			mav.addObject("paraMap", paraMap);
		}
		
				
		mav.addObject("boardList", boardList);   // request.setAttribute 와 동일하다 
		mav.setViewName("board/list.tiles1");
	// view 페이지 : /WEB-INF/views/tiles1/board/list.jsp 페이지를 생성해야 한다.
		
		return mav;
	}
	
	*/
		/////////////////////////////////////////////////////////////////////////////////
		
		// === #114.페이징 처리를 한 검색어가 있는 전체 글 목록을 보여주기 === //
		
		/* 페이징 처리를 통한 글목록 보여주기는 
        
		        예를 들어 3페이지의 내용을 보고자 한다라면 검색을 할 경우는 아래와 같이
		     list.action?searchType=subject&searchWord=안녕&currentShowPageNo=3 와 같이 해주어야 한다.
		        
		        또는 
		        
		        검색이 없는 전체를 볼때는 아래와 같이 
		     list.action 또는 
		     list.action?searchType=&searchWord=&currentShowPageNo=3 또는 
		     list.action?searchType=subject&searchWord=&currentShowPageNo=3 또는
		     list.action?searchType=name&searchWord=&currentShowPageNo=3 와 같이 해주어야 한다.
		 */
		
		
		String searchType = request.getParameter("searchType");
		String searchWord = request.getParameter("searchWord");
		String str_currentShowPageNo = request.getParameter("currentShowPageNo");
		
		// 타입이 null이거나 subject그리고 이름이 searchType 과 같지 않으면   장난을 막는다 검색을 자동으로 없게 만든다.
		// 즉 검색어가 없는 모든 글들이 나오게 된다. 
		if(searchType == null || (!"subject".equals(searchType) && !"name".equals(searchType))) {
			searchType = "";
		}
		
		if(searchWord == null || "".equals(searchType) || searchWord.trim().isEmpty()) {
			searchType = "";
		}
		
		
		Map<String, String> paraMap = new HashMap<>();
		paraMap.put("searchType", searchType);
		paraMap.put("searchWord", searchWord);
		
		
		// 페이징 처리를 하기 위해 
		// 먼저 총 게시물 건수(totalCount)를 구해와야 한다.
	    // 총 게시물 건수(totalCount)는 검색조건이 있을 때와 없을때로 나뉘어진다. 
	    int totalCount = 0;         // 총 게시물 건수
	    int sizePerPage = 10;       // 한 페이지당 보여줄 게시물 건수 
	    int currentShowPageNo = 0;  // 현재 보여주는 페이지번호로서, 초기치로는 1페이지로 설정함.
	    int totalPage = 0;          // 총 페이지수(웹브라우저상에서 보여줄 총 페이지 개수, 페이지바)
	    
	    int startRno = 0;           // 시작 행번호
	    int endRno = 0;             // 끝 행번호
		
		// 총 게시물 건수(totalCount) 
	    totalCount = service.getTotalCount(paraMap);
		//System.out.println("확인용 입니다. totalCount : "+ totalCount);
		
	    
	    // 만약에 총 게시물 건수(totalCount) 가 127개이라면 
	    // 총 페이지수(totalPage) 는 13개가 되어야 한다.
	    
	    totalPage = (int) Math.ceil((double)totalCount/sizePerPage);
	    // (double)127/10 ===> 12.7 ==> Math.ceil(12.7) ==> 13.0  ==> (int)13.0 => 13
	    
	    if(str_currentShowPageNo == null) {
	    	// 게시판에 보여지는 초기화면 
	    	currentShowPageNo = 1;
	    }
	    else {
	    	// 사용자의 장난을 막기 위해 설정한다.
	    	try {
	    		currentShowPageNo = Integer.parseInt(str_currentShowPageNo);
	    		// 음수 페이지거나 totalPage보다 현재 페이지가 더 높은 숫자일때 
	    		if(currentShowPageNo < 1 || currentShowPageNo > totalPage) {
	    			currentShowPageNo = 1;   // 처음 화면을 보여준다.
	    		}
	    	} catch(NumberFormatException e) {
	    		currentShowPageNo = 1;
	    	}
	    	
	    }
	    
	 // **** 가져올 게시글의 범위를 구한다.(공식임!!!) **** 
      /*
           currentShowPageNo      startRno     endRno
          --------------------------------------------
               1 page        ===>    1           10
               2 page        ===>    11          20
               3 page        ===>    21          30
               4 page        ===>    31          40
               ......                ...         ...
       */
	    
	    startRno = ((currentShowPageNo - 1) * sizePerPage) + 1;
	    endRno = startRno + sizePerPage - 1; 		
		
	    paraMap.put("startRno", String.valueOf(startRno));		//int  타입을 String 으로 바꿈 map 에 넣기 위해서 
	    paraMap.put("endRno", String.valueOf(endRno));	    //int  타입을 String 으로 바꿈 map 에 넣기 위해서 
	    
	    boardList = service.boardListSearchWithPaging(paraMap);
		// 페이징 처리한 글 목록 가져오기(검색이 있든지, 검색이 없든지 모두 다 포함한 것 )
		
	    
	    // 아래는 검색대상 컬럼과 검색어를 유지시키기 위한 것이다.
 		if(!"".equals(searchType) && !"".equals(searchWord)) {
 			mav.addObject("paraMap", paraMap);
 		}
	    
 		
	    // === #121. 페이지바 만들기 === // 
 		int blockSize = 10;
 	      // blockSize 는 1개 블럭(토막)당 보여지는 페이지번호의 개수이다.
 	      /*
 	                       1  2  3  4  5  6  7  8  9 10 [다음][마지막]  -- 1개블럭
 	         [맨처음][이전]  11 12 13 14 15 16 17 18 19 20 [다음][마지막]  -- 1개블럭
 	         [맨처음][이전]  21 22 23
 	      */
 	      
 	      int loop = 1;
 	      /*
 	          loop는 1부터 증가하여 1개 블럭을 이루는 페이지번호의 개수[ 지금은 10개(== blockSize) ] 까지만 증가하는 용도이다.
 	       */
 	      
 	      int pageNo = ((currentShowPageNo - 1)/blockSize) * blockSize + 1;
 	      // *** !! 공식이다. !! *** //
 	      
 	   /*
 	       1  2  3  4  5  6  7  8  9  10  -- 첫번째 블럭의 페이지번호 시작값(pageNo)은 1 이다.
 	       11 12 13 14 15 16 17 18 19 20  -- 두번째 블럭의 페이지번호 시작값(pageNo)은 11 이다.
 	       21 22 23 24 25 26 27 28 29 30  -- 세번째 블럭의 페이지번호 시작값(pageNo)은 21 이다.
 	       
 	       currentShowPageNo         pageNo
 	      ----------------------------------
 	            1                      1 = ((1 - 1)/10) * 10 + 1
 	            2                      1 = ((2 - 1)/10) * 10 + 1
 	            3                      1 = ((3 - 1)/10) * 10 + 1
 	            4                      1
 	            5                      1
 	            6                      1
 	            7                      1 
 	            8                      1
 	            9                      1
 	            10                     1 = ((10 - 1)/10) * 10 + 1
 	           
 	            11                    11 = ((11 - 1)/10) * 10 + 1
 	            12                    11 = ((12 - 1)/10) * 10 + 1
 	            13                    11 = ((13 - 1)/10) * 10 + 1
 	            14                    11
 	            15                    11
 	            16                    11
 	            17                    11
 	            18                    11 
 	            19                    11 
 	            20                    11 = ((20 - 1)/10) * 10 + 1
 	            
 	            21                    21 = ((21 - 1)/10) * 10 + 1
 	            22                    21 = ((22 - 1)/10) * 10 + 1
 	            23                    21 = ((23 - 1)/10) * 10 + 1
 	            ..                    ..
 	            29                    21
 	            30                    21 = ((30 - 1)/10) * 10 + 1
 	   */
 	      
 	      
 	      String pageBar = "<ul style='list-style: none;'>";
 	      String url = "list.action";
 	      
 	      // === [맨처음][이전] 만들기 === //
 	      if(pageNo != 1) {
 	         pageBar += "<li style='display:inline-block; width:70px; font-size:12pt;'><a href='"+url+"?searchType="+searchType+"&searchWord="+searchWord+"&currentShowPageNo=1'>[맨처음]</a></li>";
 	         pageBar += "<li style='display:inline-block; width:50px; font-size:12pt;'><a href='"+url+"?searchType="+searchType+"&searchWord="+searchWord+"&currentShowPageNo="+(pageNo-1)+"'>[이전]</a></li>";
 	      }
 	      
 	      while( !(loop > blockSize || pageNo > totalPage) ) {
 	         
 	         if(pageNo == currentShowPageNo) {
 	            pageBar += "<li style='display:inline-block; width:30px; font-size:12pt; border:solid 1px gray; color:red; padding:2px 4px;'>"+pageNo+"</li>";  
 	         }
 	         else {
 	            pageBar += "<li style='display:inline-block; width:30px; font-size:12pt;'><a href='"+url+"?searchType="+searchType+"&searchWord="+searchWord+"&currentShowPageNo="+pageNo+"'>"+pageNo+"</a></li>"; 
 	         }
 	         
 	         loop++;
 	         pageNo++;
 	         
 	      }// end of while-----------------------
 	      
 	      
 	      // === [다음][마지막] 만들기 === //
 	      if( pageNo <= totalPage ) {
 	         pageBar += "<li style='display:inline-block; width:50px; font-size:12pt;'><a href='"+url+"?searchType="+searchType+"&searchWord="+searchWord+"&currentShowPageNo="+pageNo+"'>[다음]</a></li>";
 	         pageBar += "<li style='display:inline-block; width:70px; font-size:12pt;'><a href='"+url+"?searchType="+searchType+"&searchWord="+searchWord+"&currentShowPageNo="+totalPage+"'>[마지막]</a></li>"; 
 	      }
 	      
 	      pageBar += "</ul>";
 	      
 	      mav.addObject("pageBar", pageBar);
 	      
 	      // === #123. 페이징 처리되어진 후 특정 글제목을 클릭하여 상세내용을 본 이후
 	      //           사용자가 "검색된결과목록보기" 버튼을 클릭했을때 돌아갈 페이지를 알려주기 위해
 	      //           현재 페이지 주소를 뷰단으로 넘겨준다.
 	      String gobackURL = MyUtil.getCurrentURL(request);
 	      
 	      //System.out.println("확인용 gobackURL : "+ gobackURL);
 	      
 	      // 확인용 gobackURL : /list.action?searchType=&searchWord=null&currentShowPageNo=3
 	      // 확인용 gobackURL : /list.action?searchType=subject&searchWord=%EC%9D%B4%EC%88%9C%EC%8B%A0
 	      // %EC%9D%B4%EC%88%9C%EC%8B%A0 은 검색어가 한글로 되어진 이순신이다.
 	      
 	      //mav.addObject("gobackURL", gobackURL); // <== 이것은 틀린것임 & 때문에 구분이 되어서 전체 url 이 넘어가지 않음  즉 &를 치환해서 다른걸로 바꿔야 한다. 밑에줄이 해결방법
 	      
 	     mav.addObject("gobackURL", gobackURL.replaceAll("&", " "));    // url 에서 공백은 + 로 나오므로 &를 공백 " " 으로 바꾼다.
 	      // /list.action?searchType= searchWord=null currentShowPageNo=3
	      // /list.action?searchType=subject searchWord=%EC%9D%B4%EC%88%9C%EC%8B%A0
	      
 	     
 	     
 	     // === 페이징 처리를 한 검색어가 있는 전체 글 목록을 보여주기 끝 ===
 	     
 	      
		mav.addObject("boardList", boardList);   // request.setAttribute 와 동일하다 
		mav.setViewName("board/list.tiles1");
	// view 페이지 : /WEB-INF/views/tiles1/board/list.jsp 페이지를 생성해야 한다.
		
		return mav;
	}
	
	
	// === #62. 글 1개를 보여주는 페이지 요청 === //
	@RequestMapping(value="/view.action")
	public ModelAndView view(ModelAndView mav, HttpServletRequest request) { 
	
		// 조회하고자 하는 글번호 받아오기
		String seq = request.getParameter("seq");
		
		
		// 글목록에서 검색되어진 글내용일 경우 이전글제목, 다음글제목은 검색되어진 결과물내의 이전글과 다음글이 나오도록 하기 위한 것이다.  시작  //
		
		String searchType = request.getParameter("searchType");
		String searchWord = request.getParameter("searchWord");
		
		if(searchType == null) {
			searchType = "";
		}
		if(searchWord == null) {
			searchWord = "";
		}
		
		
		
		// 글목록에서 검색되어진 글내용일 경우 이전글제목, 다음글제목은 검색되어진 결과물내의 이전글과 다음글이 나오도록 하기 위한 것이다.  끝 //
		
		// === #125. 페이징 처리되어진 후 특정 글제목을 클릭하여 상세내용을 본 이후
	    //           사용자가 목록보기 버튼을 클릭했을때 돌아갈 페이지를 알려주기 위해
	    //           현재 페이지 주소를 뷰단으로 넘겨준다.
		String gobackURL = request.getParameter("gobackURL");
		// System.out.println("확인용 : " + gobackURL);
		 // alert 창에 뜨는 것들 list.action
	     // /list.action?searchType= searchWord=null currentShowPageNo=2
		 ///list.action?searchType=subject searchWord=%EC%9D%B4%EC%88%9C%EC%8B%A0
	    		
		
		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 중요부분!!!!!!!!!!!!!!!!!!!!!!!!
		// url 에서 " " 공백이였던 것을 &로 바꾼다.
		if( gobackURL != null && gobackURL.contains(" ") ) {
			gobackURL = gobackURL.replaceAll(" ", "&");
		}
		
		//System.out.println("확인용 gobackURL : " + gobackURL);
		// /list.action?searchType=&searchWord=null&currentShowPageNo=2
		// /list.action?searchType=subject&searchWord=%EC%9D%B4%EC%88%9C%EC%8B%A0
		
		mav.addObject("gobackURL",gobackURL);   //request.setAttribute 와 동일 
		// " " 이였던 것을 다시 & 로 바꿘서 넘겨야 한다.
		 
		// ========= 125번 작업의 끝 ========== //
		
		
		try{
			Integer.parseInt(seq);
			// seq 한개만 보낼것으므로 map 사용 안해도 되지만 나중에 페이징 처리 등을 하기 위해 map을 사용한다
			
			Map<String, String> paraMap = new HashMap<>();
			
			paraMap.put("seq", seq);
			
			paraMap.put("searchType", searchType);	// view.jsp 에서 이전글제목 및 다음글제목 클릭시 사용하기 위해서 임.	 
			paraMap.put("searchWord", searchWord);
			
			mav.addObject("paraMap", paraMap); // view.jsp 에서 이전글제목 및 다음글제목 클릭시 사용하기 위해서 임.	 
			// view 단으로 보낸다.   // request.setAttrebute 와 동일 
			
			
			//세션 값 가져오기 
			HttpSession session = request.getSession();
			
			MemberVO loginuser = (MemberVO) session.getAttribute("loginuser");
			
			String login_userid = null;
			
			// 로그인 했다면 
			if(loginuser != null) {
				login_userid = loginuser.getUserid();  // 세션에서 유저의 아이디를 가져온다.
				// login_userid 는 로그인 되어진 사용자의 userid 이다.
			}
			
			paraMap.put("login_userid", login_userid);   // map 에 저장  
			
			// === #68. !!! 중요 !!! 
	         //     글1개를 보여주는 페이지 요청은 select 와 함께 
	         //     DML문(지금은 글조회수 증가인 update문)이 포함되어져 있다.
	         //     이럴경우 웹브라우저에서 페이지 새로고침(F5)을 했을때 DML문이 실행되어
	         //     매번 글조회수 증가가 발생한다.
	         //     그래서 우리는 웹브라우저에서 페이지 새로고침(F5)을 했을때는
	         //     단순히 select만 해주고 DML문(지금은 글조회수 증가인 update문)은 
	         //     실행하지 않도록 해주어야 한다. !!! === //
			
			
			// 위의 글 목록 보기 #69. 에서  session.setAttribute("readCountPermission", "yes"); 해두었다.
			BoardVO boardvo = null;
			if("yes".equals(session.getAttribute("readCountPermission")) ) {
				// 클 목록보기를 클릭한 다음에 특정 글을 조회해 온 경우이다.
				
				boardvo = service.getView(paraMap);
				// 글 조회수 증가와 함께 글 1개를 조회를 해주는것
				
				session.removeAttribute("readCountPermission");
				// !!!!!!! 중요 !!!!!!!!1 session 에 저장된 readCountPermission 을 삭제한다. 
			}
			else {
				// 웹 브라우저에서 새로고침(F5)을 클릭한 경우이다.
				
				boardvo = service.getViewWithNoAddCount(paraMap);
				// 글 조회수 증가는 없고 단순히  글 1개를 조회를 해주는것
				
			}
			//System.out.println(boardvo.getPrevioussubject());  이전글 보기 
			mav.addObject("boardvo",boardvo);   //mav 에 값을 넘겨준다.
		}
		catch(NumberFormatException e) {
			// e.printStackTrace();
		}
		
		
		mav.setViewName("board/view.tiles1");
	// view 페이지 : /WEB-INF/views/tiles1/board/view.jsp 페이지를 생성해야 한다.	
		
		return mav;
	}
	
	
	
	@RequestMapping(value="/view_2.action")
	public ModelAndView view_2(ModelAndView mav, HttpServletRequest request) { 
	
		// 조회하고자 하는 글번호 받아오기
		String seq = request.getParameter("seq");
		
		String searchType = request.getParameter("searchType");
		String searchWord = request.getParameter("searchWord");
		String gobackURL = request.getParameter("gobackURL");
		
		//System.out.println("~~~~ (확인용)view_2의 searchType : " + searchType);
		//System.out.println("~~~~ (확인용)view_2의 searchWord : " + searchWord);
		//System.out.println("~~~~ (확인용)view_2의 gobackURL : " + gobackURL);
		/*
		 	~~~~ (확인용)view_2의 searchType : subject
			~~~~ (확인용)view_2의 searchWord : 이순신
			~~~~ (확인용)view_2의 gobackURL : /list.action?searchType=subject searchWord=이순신 currentShowPageNo=6
			~~~~ (확인용)view_2의 searchType : subject
			~~~~ (확인용)view_2의 searchWord : java
			~~~~ (확인용)view_2의 gobackURL : /list.action?searchType=subject searchWord=java
		*/
		HttpSession session = request.getSession();
		session.setAttribute("readCountPermission", "yes");
		
		//  redirect:/ 를 할때 한글데이터는 한글이 ? 처럼 깨지므로 아래와 같이 한글깨짐을 방지해주어야 한다.
		try {
			// 한글이 웹브라우저 주소창에서 사용되어질때 한글이 ? 처럼 안깨지게 하려고 하는 것임.
			searchWord = URLEncoder.encode(searchWord,"UTF-8");
			gobackURL = URLEncoder.encode(gobackURL,"UTF-8");
						
			//System.out.println("~~~~ (확인용)view_2의  URLEncoder.encode(searchWord,\"UTF-8\") : " + searchWord);
			//System.out.println("~~~~ (확인용)view_2의 URLEncoder.encode(gobackURL,\"UTF-8\") : "  + gobackURL);
			//~~~~ (확인용)view_2의  URLEncoder.encode(searchWord,"UTF-8") : %EC%9D%B4%EC%88%9C%EC%8B%A0
			//~~~~ (확인용)view_2의 URLEncoder.encode(gobackURL,"UTF-8") : %2Flist.action%3FsearchType%3Dsubject+searchWord%3D%EC%9D%B4%EC%88%9C%EC%8B%A0

			
			//System.out.println(URLDecoder.decode(searchWord,"UTF-8"));   //URL 인코딩 되어진 한글을 원래 한글 모양으로 되돌려 주는 것임
			//System.out.println(URLDecoder.decode(gobackURL,"UTF-8"));   //URL 인코딩 되어진 한글을 원래 한글 모양으로 되돌려 주는 것임
			//이순신
			///list.action?searchType=subject searchWord=이순신
			
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}  
		
		mav.setViewName("redirect:/view.action?seq="+seq+"&searchType="+searchType+"&searchWord="+searchWord+"&gobackURL="+gobackURL);
	    
		
		return mav;
	}

	
	// === #71. 글 1개를 보여주는 페이지 요청 (수정)=== // 
	@RequestMapping(value="/edit.action")
	 public ModelAndView requiredLogin_edit(HttpServletRequest request, HttpServletResponse response, ModelAndView mav) {
 	
		// 글을 수정할 글 번호 가져오기 
		String seq = request.getParameter("seq");
		
		// 글을 수정해야할 글내용 가져오기 (작성자 등등 포함)
		
		Map<String, String> paraMap = new HashMap<>();
		paraMap.put("seq", seq);
		
		/////////////////////////////////////////////
		paraMap.put("searchType", "");
		paraMap.put("searchWord", "");
		/////////////////////////////////////////////
		
		BoardVO boardvo = service.getViewWithNoAddCount(paraMap);  // 조회수 없이 수정할것임
		// 글 조회수 (readCount) 증가없이 단순히 글 1개만 조회해주는 것이다.
		
		HttpSession session = request.getSession();
		MemberVO loginuser = (MemberVO) session.getAttribute("loginuser");
		
		// 내가 쓴 글이 아니라면 안된다고 해줄 것 
		if( !loginuser.getUserid().equals(boardvo.getFk_userid()) ) {

			String message = "다른 사용자의 글은 수정이 불가합니다.";
			String loc = "javascript:history.back()";
			
			mav.addObject("message",message);
			mav.addObject("loc",loc);
			mav.setViewName("msg");   //msg로 감
			
		}
		else {
			//자신의 글을 수정할 경우
			// 가져온 1개 글을 글 수정할 폼이 있는 View 단으로 보내준다. 
			mav.addObject("boardvo",boardvo);   //mav 에 값을 넘겨준다.
			mav.setViewName("board/edit.tiles1");  // board 밑에 edit.jsp를 보여줄것이다 // 총 tiles1 안에 있음 
			// view 페이지 : /WEB-INF/views/tiles1/board/edit.jsp 페이지를 생성해야 한다.	
		}
		return mav;
	}
	
	
	/// == #72. 글수정 페이지 완료하기 === // 
	@RequestMapping(value="/editEnd.action",  method = {RequestMethod.POST})
	public ModelAndView editEnd(ModelAndView mav, BoardVO boardvo, HttpServletRequest request) { 
	
		/*
			글 수정을 하려면 원본 ㄱㄹ의 글 암호와 수정시 입력해준 암호가 일치할 때만 
			글 수정이 가능하도록 해야 한다.
		*/
	
		int n = service.edit(boardvo);
		// n 이 1이라면 정상적으로 수정이 완료됨
		// n 이 0이라면 글 수정에 필요한 글 암호가 틀린 경우를 말한다. 
		
		if(n == 0) {
			mav.addObject("message","암호가 일치하지 않아 글 수정이 불가합니다.");
			mav.addObject("loc", "javascript:history.back()");
		}
		else {
			mav.addObject("message","글 수정 성공");
			mav.addObject("loc", request.getContextPath()+"/view.action?seq="+boardvo.getSeq());
		}
		
		mav.setViewName("msg");   //msg로 감
		
		return mav;
	}
	
	// == #76. 글 삭제 페이지 요청하기 === // 
	@RequestMapping(value="/del.action")
	public ModelAndView requiredLogin_del(HttpServletRequest request, HttpServletResponse response, ModelAndView mav) { 
	
		// 삭제해야할  글 번호 가져오기 
		String seq = request.getParameter("seq");
		
		// 삭제해야 할  글1개 내용 가져와서 로그인한 사람이 쓴 글이라면 글 삭제가 가능하지만 
		// 다른 사람이 쓴 글은 삭제가 불가하도록 해야 한다. 
		
		Map<String, String> paraMap = new HashMap<>();
		paraMap.put("seq", seq);
		paraMap.put("searchType", "");
		paraMap.put("searchWord", "");		   
   
		BoardVO boardvo = service.getViewWithNoAddCount(paraMap);  // 조회수 증가는 필요없이 글을 읽어온다. 
		// 글 조회수 (readCount) 증가없이 단순히 글 1개만 조회해주는 것이다.
		
		HttpSession session = request.getSession();
		MemberVO loginuser = (MemberVO) session.getAttribute("loginuser");
		
		// 내가 쓴 글이 아니라면 안된다고 해줄 것 
		if( !loginuser.getUserid().equals(boardvo.getFk_userid()) ) {

			String message = "다른 사용자의 글은 삭제가 불가합니다.";
			String loc = "javascript:history.back()";
			
			mav.addObject("message",message);
			mav.addObject("loc",loc);
			mav.setViewName("msg");   //msg로 감
		}
		else {
			// 자신의 글을 삭제할 경우
			// 글 작성시 입력해준 글 암호와 일치하는지 여부를 알아오도록 암호를 입력받아주는 del.jsp 페이지를 띄우도록 한다.
			mav.addObject("pw",boardvo.getPw());   //mav 에 값을 넘겨준다.
			mav.addObject("seq",seq);              //mav 에 값을 넘겨준다.
			mav.setViewName("board/del.tiles1");  // board 밑에 edit.jsp를 보여줄것이다 // 총 tiles1 안에 있음 
			// view 페이지 : /WEB-INF/views/tiles1/board/del.jsp 페이지를 생성해야 한다.	
		}
		
		return mav;
	}
	
	// == #77. 글 삭제 페이지 완료하기 === // 
	@RequestMapping(value="/delEnd.action", method = {RequestMethod.POST})
	public ModelAndView delEnd(ModelAndView mav, HttpServletRequest request) { 
	
		String seq = request.getParameter("seq");    // seq 는 key 값
		
		Map<String, String> paraMap = new HashMap<>();
		paraMap.put("seq", seq);
		
		
		///////////////////////////////////////////
		// === #164. 파일첨부가 된 글 이라면 글 삭제시 먼저 첨부파일을 삭제해주어야 한다.  === //
		paraMap.put("searchType", "");
		paraMap.put("searchWord", "");
		
		
		BoardVO boardvo = service.getViewWithNoAddCount(paraMap);   // 조회수 증가는 필요없이 글을 읽어온다. 
		String fileName = boardvo.getFileName();
		
		if( fileName != null && !"".equals(fileName)) {
			HttpSession session = request.getSession();
			String root = session.getServletContext().getRealPath("/");
			String path = root+"resources"+File.separator+"files";      // 이것은 경로이다. 
			
			paraMap.put("path", path);			// 삭제해야할 파일이 저장된 경로 
			paraMap.put("fileName", fileName);  // 삭제해야할 파일명
			
		}
		
		// === 파일첨부가 된 글 이라면 글 삭제시 먼저 첨부파일을 삭제해주어야 한다. 끝  === //
		///////////////////////////////////////////
		
		
		int n = service.del(paraMap);
		
		if(n == 1) {
			
			mav.addObject("message","글 삭제 성공 !!!");
			mav.addObject("loc", request.getContextPath()+"/list.action");
		}
		else {
			mav.addObject("messge","글 삭제 실패");
			mav.addObject("loc", "javascript:history.back()");
		}
		
		mav.setViewName("msg");   //msg로 감
		
		
		
		return mav;
	}
	
	
	// == #84. 댓글쓰기(Ajax 로 처리) === //
	@ResponseBody
	@RequestMapping(value="/addComment.action", method = {RequestMethod.POST}, produces="text/plain;charset=UTF-8")
	public String addComment(CommentVO commentvo) {    // CommentVO 에 있는것을 사용하기 위해 
		
		// 댓글 쓰기에 첨부 파일이 없는 경우 
		int n = 0;		
		try {
			n = service.addComment(commentvo);
			// 댓글쓰기(insert) 및 원게시물(tbl_board 테이블)에 댓글의 개수 증가(update 1씩 증가)하기 
	        // 이어서 회원의 포인트를 50점을 증가하도록 한다. (tbl_member 테이블에 point 컬럼의 값을 50 증가하도록 update 한다.)
			// (transaction 처리)
		} catch (Throwable e) {
			e.printStackTrace();
		}     
		
		// ajax 에서 json 을 사용했으므로 
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("n", n);  
		jsonObj.put("name", commentvo.getName());
		
		return jsonObj.toString();  // "{"n":1, "name":"민동현"}"  // 또는  "{"n":0, "name":"민동현"}"
		// 한글은 기본적으로 깨지기 때문에 produces="text/plain;charset=UTF-8" 필요 
	}
	
	// === #90. 원 게시물에 딸린 댓글들을 조회해 오기 (Ajax 로 처리)=== //
	@ResponseBody
	@RequestMapping(value="/readComment.action", method = {RequestMethod.GET}, produces="text/plain;charset=UTF-8")
	public String readComment(HttpServletRequest request) {    // CommentVO 에 있는것을 사용하기 위해 
	
		String parentSeq = request.getParameter("parentSeq");
		
		List<CommentVO> commentList = service.getCommentList(parentSeq);    
		
		// AJAX로 넘겨줬으니까 JSON으로 받는다 
		JSONArray jsonArr = new JSONArray();
		
		// DB에서 받아온 값이 있다면 
		if(commentList != null) {
			for(CommentVO cmtvo : commentList) {
				
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("name", cmtvo.getName());
				jsonObj.put("content", cmtvo.getContent());
				jsonObj.put("regdate", cmtvo.getRegDate());
				
				jsonArr.put(jsonObj);   // 배열에 json 값들넣는다.
				
			}// end of for 
		}
		
		return jsonArr.toString();
	}	
	
	// === #108. 검색어 입력시 자동글 완성하기 3 === //
/*
	@ResponseBody
	@RequestMapping(value="/wordSearchShow.action", method = {RequestMethod.GET}, produces="text/plain;charset=UTF-8") 
	public String wordSearchShow(HttpServletRequest request) {
	
		String searchType = request.getParameter("searchType");
		String searchWord = request.getParameter("searchWord");
		
		Map<String, String> paraMap = new HashMap<>();
		
		paraMap.put("searchType", searchType);
		paraMap.put("searchWord", searchWord);
		
		List<String> wordList = service.wordSearchShow(paraMap);
		
		// ajax 를 사용했으므로 
		JSONArray jsonArr = new JSONArray();
		
		// 리스트가 존재한다면 실행 
		if(wordList != null) {
			for(String word : wordList) {
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("word", word);
				
				jsonArr.put(jsonObj);
			}// end of for 믄 
		}
		return jsonArr.toString();
	}
*/
	/////////////////////////////////////
	// 또는 
	/////////////////////////////////////
	@ResponseBody
	@RequestMapping(value="/wordSearchShow.action", method = {RequestMethod.GET}, produces="text/plain;charset=UTF-8") 
	public String wordSearchShow(HttpServletRequest request) {
	
		String searchType = request.getParameter("searchType");
		String searchWord = request.getParameter("searchWord");
		
		Map<String, String> paraMap = new HashMap<>();
		
		paraMap.put("searchType", searchType);
		paraMap.put("searchWord", searchWord);
		
		String json = service.wordSearchShow(paraMap);
		
		return json;
	}
	
	
	// === #128. 원 게시물에 딸린 댓글들을 페이징 처리해서 조회해오기(Ajax 로 처리) === //
	@ResponseBody
	@RequestMapping(value="/commentList.action", method = {RequestMethod.GET}, produces="text/plain;charset=UTF-8")
	public String commentList(HttpServletRequest request) {
		
		String parentSeq = request.getParameter("parentSeq"); 
		String currentShowPageNo = request.getParameter("currentShowPageNo");
		
		// 값을 읽어오지 못했으면 
		if(currentShowPageNo == null) {
			currentShowPageNo = "1";
		}
		int sizePerPage = 3;  // 한페이지 당 3개의 댓글을 보여줄 것임 
	//	int sizePerPage = 5;  // 한페이지 당 5개의 댓글을 보여줄 것임 
		/*
	        currentShowPageNo      startRno     endRno
	       --------------------------------------------
	           1page        ==>       1           5
	           2page        ==>       6           10
	           3page        ==>       11          15
	           4page        ==>       16          20
	           ....  
	     */
		
		 int startRno = ((Integer.parseInt(currentShowPageNo) - 1) * sizePerPage) + 1;
		 int endRno = startRno + sizePerPage - 1; 		
		
		 Map<String, String> paraMap = new HashMap<>();
		 paraMap.put("parentSeq", parentSeq);
		 paraMap.put("startRno", String.valueOf(startRno));
		 paraMap.put("endRno",String.valueOf(endRno));    //String.valueOf 는 String 타입으로 변경 
		 
		 
		 List<CommentVO> commentList = service.commentListPaging(paraMap);
		 
		 // json 타입 배열에 넣자 ajax니까 
		 JSONArray jsonArr = new JSONArray();   // []
		 
		 // DB 에서 가쟈온 값이 있다면 
		 if(commentList != null) {
			 for( CommentVO cmtvo : commentList) {
				 
				 JSONObject jsonObj = new JSONObject();
				 jsonObj.put("name", cmtvo.getName());
				 jsonObj.put("content", cmtvo.getContent());
				 jsonObj.put("regDate",  cmtvo.getRegDate());
				 
				 // === 댓글 읽어오기에 있어서 첨부파일 기능을 넣은 경우 시작 === //
				 jsonObj.put("seq", cmtvo.getSeq());
				 jsonObj.put("fileName", cmtvo.getFileName());
				 jsonObj.put("orgFilename", cmtvo.getOrgFilename());
				 jsonObj.put("fileSize", cmtvo.getFileSize());
				 
				 // === 댓글 읽어오기에 있어서 첨부파일 기능을 넣은 경우 끝 === //
				 
				 jsonArr.put(jsonObj);  //json 배열에 값을 저장 
 
			 }// end of for
		 }
		 
		return jsonArr.toString();
	}
	
	// === #132. 원 게시물에 딸린 댓글 totalPage 알아오기(Ajax로 처리) === //
	@ResponseBody
	@RequestMapping(value="/getCommentTotalPage.action", method = {RequestMethod.GET}, produces="text/plain;charset=UTF-8")
	public String getCommentTotalPage(HttpServletRequest request) {
	
		String parentSeq = request.getParameter("parentSeq");
		String sizePerPage = request.getParameter("sizePerPage");
		
		Map<String, String> paraMap = new HashMap<>();
		paraMap.put("parentSeq", parentSeq);
		paraMap.put("sizePerPage", sizePerPage);
		
		// 원글 글번호에 해당하는 댓글의 totalPage 알아오기 (Ajax로 처리)
		String totalPage = service.getCommentTotalPage(paraMap);
		
		return totalPage;
	}
	
	// === #163. 첨부 파일 다운로드 받기 === //
	@RequestMapping(value="/downLoad.action")
	public void requiredLogin_download(HttpServletRequest request, HttpServletResponse response) {
		
		String seq = request.getParameter("seq");   //seq 받아서 저장 
		// 첨부파일이 있는 글번호 
	
		/*
		        첨부파일이 있는 글번호에서
		    20230522115640312338398707600.pdf 처럼
		       이러한 fileName 값을 DB에서 가져와야 한다.
		       또한 orgFilename 값도  DB에서 가져와야 한다.
		*/
		
		Map<String, String> paraMap = new HashMap<>();
		paraMap.put("searchType", "");   //여기서는 "" 로 비워주는것이 맞다. 검색어, 검색타입 필요 없기 때문에 하지만 xml애는 필요하므로 map에 ""로 넣는다.
		paraMap.put("searchWord", "");
		paraMap.put("seq", seq);
		
		
		response.setContentType("text/html; charset=UTF-8");
        
        PrintWriter out = null;
        // out 은 웹브라우저에 기술하는 대상체라고 생각하자.
		
		try {
			Integer.parseInt(seq);   // 숫자로 
			BoardVO boardvo = service.getViewWithNoAddCount(paraMap);   // 글 조회수 없이 하기
			
			// 받아온 값이 없다면  또는 값은 있으나 파일 이름이 없다면 
			if(boardvo == null || (boardvo != null && boardvo.getFileName() == null)) {
				out = response.getWriter();
				// out 은 웹브라우저에 기술하는 대상체라고 생각하자.
				
				out.println("<script type='text/javascript'>alert('존재하지 않는 글번호 이거나 첨부파일이 없으므로 파일다운로드가 불가합니다.'); history.back();</script>");
	            return; // 종료
			}
			else {
				// 정상적으로 다운로드를 할 경우 
				
				String fileName = boardvo.getFileName();
				// 20230522115640312338398707600.pdf 이것이 바로 WAS(톰캣) 디스크에 저장된 파일명이다. 
				
				String orgFilename = boardvo.getOrgFilename();
				// LG_싸이킹청소기_사용설명서.pdf 다운로드시 보여줄 파일명 
				
				// 첨부파일이 저장되어 있는 WAS(톰캣)의 디스크 경로명을 알아와야만 다운로드를 해줄수 있다. 
	            // 이 경로는 우리가 파일첨부를 위해서 /addEnd.action 에서 설정해두었던 경로와 똑같아야 한다.
	            // WAS 의 webapp 의 절대경로를 알아와야 한다.
	            HttpSession session = request.getSession();
	            String root = session.getServletContext().getRealPath("/");

				// System.out.println("확인용 webapp의 절대경로 : " + root);
				// 확인용 webapp의 절대경로 : C:\NCS\workspace(spring)\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Board\
				
				String path = root + "resources" +File.separator + "files";
				/* File.separator 는 운영체제에서 사용하는 폴더와 파일의 구분자이다.
			            운영체제가 Windows 이라면 File.separator 는  "\" 이고,
			            운영체제가 UNIX, Linux, 매킨토시(맥) 이라면  File.separator 는 "/" 이다. 
			    */
				
				//path 가 첨부파일이 저장될 WAS(톰캣)의 폴더가 된다. 
				// System.out.println("확인용 path의 절대경로 : " + path);
				// 확인용 path의 절대경로 : C:\NCS\workspace(spring)\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Board\resources\files
				
				
			    // **** file 다운로드 하기 **** //
				boolean flag = false;  // file 다운로드 성공, 또는 실패를 알려주는 용도 
								
				                      // 다운받을 실제 파일 이름, 다운되어질 파일 이름, 경로, response는 써줌   
				flag = fileManager.doFileDownload(fileName, orgFilename, path, response);
				// file 다운로드 성공시 flag 는 true, 
	            // file 다운로드 실패시 flag 는 false 를 가진다. 
				// FileManager 의 139번줄 
				
				
				// 깃발이 false 라면 
				if(!flag) {
	               // 다운로드가 실패할 경우 메시지를 띄워준다.
	               out = response.getWriter();
	               // out 은 웹브라우저에 기술하는 대상체라고 생각하자.
	               
	               out.println("<script type='text/javascript'>alert('파일다운로드가 실패되었습니다.'); history.back();</script>");
	            }
				
				
				
			}
		
		
		} catch(NumberFormatException | IOException e) {
			try {
				out = response.getWriter();
				// out 은 웹브라우저에 기술하는 대상체라고 생각하자.
				
				out.println("<script type='text/javascript'>alert('파일다운로드가 불가합니다.'); history.back();</script>");
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}						
		}
	}
	
	
	
	// ==== #168. 스마트에디터. 드래그앤드롭을 사용한 다중사진 파일업로드 ====
   @RequestMapping(value="/image/multiplePhotoUpload.action", method= {RequestMethod.POST} )
	public void multiplePhotoUpload(HttpServletRequest request, HttpServletResponse response) {
		
		/*
		   1. 사용자가 보낸 파일을 WAS(톰캣)의 특정 폴더에 저장해주어야 한다.
		   >>>> 파일이 업로드 되어질 특정 경로(폴더)지정해주기
		        우리는 WAS 의 webapp/resources/photo_upload 라는 폴더로 지정해준다.
		*/
		
		// WAS 의 webapp 의 절대경로를 알아와야 한다.
		HttpSession session = request.getSession();
		String root = session.getServletContext().getRealPath("/");
		String path = root + "resources"+File.separator+"photo_upload";
		// path 가 첨부파일들을 저장할 WAS(톰캣)의 폴더가 된다.
		
	//	System.out.println("~~~~ 확인용 path => " + path);
		// ~~~~ 확인용  webapp 의 절대경로 => C:\NCS\workspace(spring)\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Board\resources\photo_upload 
		
		File dir = new File(path);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		try {
			String filename = request.getHeader("file-name"); // 파일명(문자열)을 받는다 - 일반 원본파일명
			// 네이버 스마트에디터를 사용한 파일업로드시 싱글파일업로드와는 다르게 멀티파일업로드는 파일명이 header 속에 담겨져 넘어오게 되어있다. 
			
			/*
			    [참고]
			    HttpServletRequest의 getHeader() 메소드를 통해 클라이언트 사용자의 정보를 알아올 수 있다. 
	
				request.getHeader("referer");           // 접속 경로(이전 URL)
				request.getHeader("user-agent");        // 클라이언트 사용자의 시스템 정보
				request.getHeader("User-Agent");        // 클라이언트 브라우저 정보 
				request.getHeader("X-Forwarded-For");   // 클라이언트 ip 주소 
				request.getHeader("host");              // Host 네임  예: 로컬 환경일 경우 ==> localhost:9090    
			*/
			
		//	System.out.println(">>> 확인용 filename ==> " + filename);
			// >>> 확인용 filename ==> berkelekle%EB%8B%A8%EA%B0%80%EB%9D%BC%ED%8F%AC%EC%9D%B8%ED%8A%B803.jpg 
			
			InputStream is = request.getInputStream(); // is는 네이버 스마트 에디터를 사용하여 사진첨부하기 된 이미지 파일임.
			
			String newFilename = fileManager.doFileUpload(is, filename, path);
			
			int width = fileManager.getImageWidth(path+File.separator+newFilename); // 사진이 스마트에디터 content 부분보다 크면 실행됨 
			
		    if(width > 600) {
		       width = 600;
		    }
		    
		 // System.out.println(">>>> 확인용 width ==> " + width);
		 // >>>> 확인용 width ==> 600
		 // >>>> 확인용 width ==> 121
			
			String ctxPath = request.getContextPath(); //  /board
			
			String strURL = "";
			strURL += "&bNewLine=true&sFileName="+newFilename; 
			strURL += "&sWidth="+width;
			strURL += "&sFileURL="+ctxPath+"/resources/photo_upload/"+newFilename;
			
			// === 웹브라우저 상에 사진 이미지를 쓰기 === //
			PrintWriter out = response.getWriter();   // out이 웹브라우져를 말함 
			out.print(strURL);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
   
    // === #170. 파일첨부가 있는 댓글쓰기 (AJAXFORM 으로 처리) === // 
    @ResponseBody
	@RequestMapping(value="/addComment_withAttach.action", method = {RequestMethod.POST}, produces="text/plain;charset=UTF-8")
	public String addComment_withAttach(CommentVO commentvo, MultipartHttpServletRequest mrequest) {    // CommentVO 에 있는것을 사용하기 위해 
		
		// 댓글 쓰기에 첨부 파일이 있는 경우
    	// 먼저 commentVO 클래스에 가서 첨부파일을 위한 필드를 추가한다. 
    	
    	// ======== !!! 첨부파일 업로드 시작 !!! ========
        MultipartFile attach = commentvo.getAttach();
        
        if( !attach.isEmpty() ) {
        //   System.out.println("~~~~ 댓글쓰기에서 첨부파일 업로드 시작  ~~~~~~");
           // attach(첨부파일)가 비어 있지 않으면(즉, 첨부파일이 있는 경우라면)
           
           /*
              1. 사용자가 보낸 첨부파일을 WAS(톰캣)의 특정 폴더에 저장해주어야 한다. 
              >>> 파일이 업로드 되어질 특정 경로(폴더)지정해주기
                         우리는 WAS의 webapp/resources/files 라는 폴더로 지정해준다.
                         조심할 것은  Package Explorer 에서  files 라는 폴더를 만드는 것이 아니다.       
           */
           // WAS 의 webapp 의 절대경로를 알아와야 한다.
           HttpSession session = mrequest.getSession();
           String root = session.getServletContext().getRealPath("/");
           
        //   System.out.println("~~~~ 확인용  webapp 의 절대경로 => " + root);
           // ~~~~ 확인용  webapp 의 절대경로 => C:\NCS\workspace(spring)\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Board\ 
           
           String path = root+"resources"+File.separator+"files";
           /* File.separator 는 운영체제에서 사용하는 폴더와 파일의 구분자이다.
                    운영체제가 Windows 이라면 File.separator 는  "\" 이고,
                    운영체제가 UNIX, Linux 이라면  File.separator 는 "/" 이다. 
            */
           
           // path 가 첨부파일이 저장될 WAS(톰캣)의 폴더가 된다.
        //   System.out.println("~~~~ 확인용  path => " + path);
           // ~~~~ 확인용  path => C:\NCS\workspace(spring)\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Board\resources\files  
        
           
        /*
           2. 파일첨부를 위한 변수의 설정 및 값을 초기화 한 후 파일 올리기 
        */
           String newFileName = "";
           // WAS(톰캣)의 디스크에 저장될 파일명 
           
           byte[] bytes = null;
           // 첨부파일의 내용물을 담는 것 
           
           long fileSize = 0;
           // 첨부파일의 크기 
           
           try {
              bytes = attach.getBytes();
              // 첨부파일의 내용물을 읽어오는 것
              
              String originalFilename = attach.getOriginalFilename();
            // attach.getOriginalFilename() 이 첨부파일명의 파일명(예: 강아지.png) 이다.
           //   System.out.println("~~~~ 확인용 originalFilename => " + originalFilename);
              // ~~~~ 확인용 originalFilename => LG_싸이킹청소기_사용설명서.pdf
              
              newFileName = fileManager.doFileUpload(bytes, originalFilename, path);
              // 첨부되어진 파일을 업로드 하도록 하는 것이다. 
              
           //   System.out.println(">>> 확인용 newFileName => " + newFileName);
              // >>> 확인용 newFileName => 20220429123036877439302653900.pdf
           
        /*
           3. CommentVO commentvo 에 fileName 값과 orgFilename 값과 fileSize 값을 넣어주기 
        */
              commentvo.setFileName(newFileName);
              // WAS(톰캣)에 저장될 파일명(2022042912181535243254235235234.png)
              
              commentvo.setOrgFilename(originalFilename);
              // 게시판 페이지에서 첨부된 파일(강아지.png)을 보여줄 때 사용.
              // 또한 사용자가 파일을 다운로드 할때 사용되어지는 파일명으로 사용.
              
              fileSize = attach.getSize(); // 첨부파일의 크기(단위는 byte임)
              commentvo.setFileSize(String.valueOf(fileSize));
              
           } catch (Exception e) {
              e.printStackTrace();
           }
           
        }
        // ======== !!! 첨부파일 업로드 끝 !!! ========
    	
		int n = 0;		
		try {
			n = service.addComment(commentvo);
			// 댓글쓰기(insert) 및 원게시물(tbl_board 테이블)에 댓글의 개수 증가(update 1씩 증가)하기 
	        // 이어서 회원의 포인트를 50점을 증가하도록 한다. (tbl_member 테이블에 point 컬럼의 값을 50 증가하도록 update 한다.)
			// (transaction 처리)
		} catch (Throwable e) {
			e.printStackTrace();
		}     
		
		// ajax 에서 json 을 사용했으므로 
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("n", n);  
		jsonObj.put("name", commentvo.getName());
		
		return jsonObj.toString();  // "{"n":1, "name":"민동현"}"  // 또는  "{"n":0, "name":"민동현"}"
		// 한글은 기본적으로 깨지기 때문에 produces="text/plain;charset=UTF-8" 필요 
	}
   
    // === #171. 파일첨부가 있는 댓글 쓰기에서 파일 다운로드 받기 === //
    @RequestMapping(value = "/downloadComment.action")
    public void requiredLogin_downloadComment(HttpServletRequest request, HttpServletResponse response) {
	
    	String seq = request.getParameter("seq");   //seq 받아서 저장 
		// 첨부파일이 있는 글번호 
	
		/*
		        첨부파일이 있는 글번호에서
		    20230522115640312338398707600.pdf 처럼
		       이러한 fileName 값을 DB에서 가져와야 한다.
		       또한 orgFilename 값도  DB에서 가져와야 한다.
		*/
		
		
		response.setContentType("text/html; charset=UTF-8");
        
        PrintWriter out = null;
        // out 은 웹브라우저에 기술하는 대상체라고 생각하자.
		
		try {
			Integer.parseInt(seq);   // 숫자로 
			CommentVO commentvo = service.getCommentOne(seq);    // DB에서 댓글한개 읽어오기  
			
			// 받아온 값이 없다면  또는 값은 있으나 파일 이름이 없다면 
			if(commentvo == null || (commentvo != null && commentvo.getFileName() == null)) {
				out = response.getWriter();
				// out 은 웹브라우저에 기술하는 대상체라고 생각하자.
				
				out.println("<script type='text/javascript'>alert('존재하지 않는 댓글 번호 이거나 첨부파일이 없으므로 파일다운로드가 불가합니다.'); history.back();</script>");
	            return; // 종료
			}
			else {
				// 정상적으로 다운로드를 할 경우 
				
				String fileName = commentvo.getFileName();
				// 20230522115640312338398707600.pdf 이것이 바로 WAS(톰캣) 디스크에 저장된 파일명이다. 
				
				String orgFilename = commentvo.getOrgFilename();
				// LG_싸이킹청소기_사용설명서.pdf 다운로드시 보여줄 파일명 
				
				// 첨부파일이 저장되어 있는 WAS(톰캣)의 디스크 경로명을 알아와야만 다운로드를 해줄수 있다. 
	            // 이 경로는 우리가 파일첨부를 위해서 /addEnd.action 에서 설정해두었던 경로와 똑같아야 한다.
	            // WAS 의 webapp 의 절대경로를 알아와야 한다.
	            HttpSession session = request.getSession();
	            String root = session.getServletContext().getRealPath("/");

				 System.out.println("확인용 webapp의 절대경로 : " + root);
				// 확인용 webapp의 절대경로 : C:\NCS\workspace(spring)\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Board\
				
				String path = root + "resources" +File.separator + "files";
				/* File.separator 는 운영체제에서 사용하는 폴더와 파일의 구분자이다.
			            운영체제가 Windows 이라면 File.separator 는  "\" 이고,
			            운영체제가 UNIX, Linux, 매킨토시(맥) 이라면  File.separator 는 "/" 이다. 
			    */
				
				//path 가 첨부파일이 저장될 WAS(톰캣)의 폴더가 된다. 
				 System.out.println("확인용 path의 절대경로 : " + path);
				// 확인용 path의 절대경로 : C:\NCS\workspace(spring)\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Board\resources\files
				
				
			    // **** file 다운로드 하기 **** //
				boolean flag = false;  // file 다운로드 성공, 또는 실패를 알려주는 용도 
								
				                      // 다운받을 실제 파일 이름, 다운되어질 파일 이름, 경로, response는 써줌   
				flag = fileManager.doFileDownload(fileName, orgFilename, path, response);
				// file 다운로드 성공시 flag 는 true, 
	            // file 다운로드 실패시 flag 는 false 를 가진다. 
				// FileManager 의 139번줄 
				
				System.out.println(flag);
				
				// 깃발이 false 라면 
				if(!flag) {
	               // 다운로드가 실패할 경우 메시지를 띄워준다.
	               out = response.getWriter();
	               // out 은 웹브라우저에 기술하는 대상체라고 생각하자.
	               
	               out.println("<script type='text/javascript'>alert('파일다운로드가 실패되었습니다.'); history.back();</script>");
	            }
				
				
				
			}
		
		
		} catch(NumberFormatException | IOException e) {
			try {
				out = response.getWriter();
				// out 은 웹브라우저에 기술하는 대상체라고 생각하자.
				
				out.println("<script type='text/javascript'>alert('파일다운로드가 불가합니다.'); history.back();</script>");
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}						
		}
    	
    }

	// ========================= ***** 게시판 끝 ***** ========================== // 
	
}
