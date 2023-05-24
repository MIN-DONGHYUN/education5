package com.spring.employees.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.employees.service.InterEmpService;

@Controller
public class EmpController {

	@Autowired
	private InterEmpService service;
	
	// === #175. 다중 체크박스를 사용시 sql문에서 in 절을 처리하는 예제 === //
	@RequestMapping(value="/emp/empList.action")
	public String employeeInfoView(HttpServletRequest request) {
		
		// employees 테이블에서 근무 중인 사원들의 부서번호 가져오기
		List<String> deptIdList = service.deptIdList();
			
		String str_DeptId = request.getParameter("str_DeptId");  // 부서번호 알아오자 
		//System.out.println("확인용 str_DeptId : " + str_DeptId);
		// 확인용 str_DeptId :     <- 검색이 없으면 null값이 나온다.
		
		String gender = request.getParameter("gender");  // 성별 알아오자 
		//System.out.println("확인용 gender : " + gender);
		// 확인용 gender :    <- 검색이 없으면 null값이 나온다.
		
		
		Map<String, Object> paraMap = new HashMap<>();  // 모든 타입 담기 위해 object 사용 
		
		if(str_DeptId != null && !"".equals(str_DeptId)) {
			String[] arr_DeptId = str_DeptId.split("\\,");
			paraMap.put("arr_DeptId", arr_DeptId);
			
			request.setAttribute("str_DeptId", str_DeptId);  // view 페이지로 넘김
			// 뷰단에서 체크되어진 값을 유지시키키 위한 것이다.
		}
		
		if(gender != null && !"".equals(gender)) {
			paraMap.put("gender", gender);
			
			request.setAttribute("gender", gender);
			// 뷰단에서 선택한 성별을 유지시키키 위한 것이다.
		}
		
		List<Map<String, String>> empList = service.empList(paraMap);
		
		request.setAttribute("deptIdList", deptIdList);
		request.setAttribute("empList", empList);
		
		return "emp/empList.tiles2";
		// /WEB-INF/views/tiles2/emp/empList.jsp 파일을 생성한다.
	}

	
	
	
}
