package com.test;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// 개발이 끝나고 war 파일로 배포하여 운영할 때 내부 tomcat 이 아닌 외부 Tomcat 같은 Servlet Container 환경내에서 
// Spring Boot 애플리케이션이 동작 가능 하도록 웹 애플리케이션 컨텍스트를 구성한다는 것이다.
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BeginspringbootApplication.class);
	}

}
