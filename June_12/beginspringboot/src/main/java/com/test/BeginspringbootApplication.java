package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//프로젝트명+Application 으로 되어진 자바클래스 파일이 프로젝트가 동작할 수 있게 해주는 메인 클래스 파일이다. 
//@SpringBootApplication 어노테이션 속에는 
//@ComponentScan, @SpringBootConfiguration, @EnableAutoConfiguration 등이 들어있기에 이러한 여러 어노테이션들이 다같이 사용되어진다.  
//그래서 @ComponentScan 이 포함되어 있으므로 Spring Legacy Project 에서 설정하였던 src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml 내의 
//<context:component-scan base-package="com.spring.*" /> 기능을 자동적으로 해준다.  

@SpringBootApplication
public class BeginspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeginspringbootApplication.class, args);
	}

}
