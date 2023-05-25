package com.spring.employees.model;

import java.util.List;
import java.util.Map;

public interface InterEmpDAO {

	// employees 테이블에서 근무중인 사원들의 부서번호 가져오기 
	List<String> deptIdList();

	// employees 테이블에서 조건에 만족하는 사원들을 가져오기 
	List<Map<String, String>> empList(Map<String, Object> paraMap);

	// === Excel 파일을 업로드 하면 엑셀데이터를 데이터베이스 테이블에 insert 해주는 예제 === //
	int addEmpList(List<Map<String, String>> paraMapList);

}
