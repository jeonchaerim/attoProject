package org.zerock.myapp.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

// For JUnit 5
//@ExtendWith(SpringExtension.class)

// For JUnit 4
//@RunWith(SpringRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations= {
	"file:src/main/webapp/**/*-context.xml"
})

// Spring MVC 의 Controller 를 테스트 하려면,
// 반드시 아래의 어노테이션을 하나 더 붙여줘야 합니다. (***)
@WebAppConfiguration
public class BoardControllerTests {
	
	// 1) Controller 를 테스트 하려면, Spring Beans Container를 주입받아야함 
	// WebApplicationContext >> 빈즈 컨테이너가 지키는 인터페이스 규격 
	@Autowired
	private WebApplicationContext ctx;
	
	
	@Before
	public void setup() {
		log.trace("setup() invoked.");
		
		assertNotNull(this.ctx);
		log.info("\t+ this.ctx: {}", this.ctx);
	} // setup
	
	
	@Test
	public void testList() throws Exception {
		log.trace("testList() invoked.");
		
		// 표현계층의 User-defined Controller 에 대한 테스트 수행시, 핵심은 WAS 구동없이 테스트 필요:
		// 뭐가 필요한가!? 무얼 알아야 되는가!? (2가지)
		//   (1) @WebAppConfiguration
		//   (2) MockMvc 클래스(가상의 웹브라우저) 사용법:
		//		 가. Spring Bean Container == (WebApplicationContext 를 주입받아야 함)
		//       나. '가'의 주입받은 객체를 이용해서, MockMvcBuilder 객체 생성 
		//       다. '나'의 MockMvcBuilders란 Helper Class의 정적 메소드를 이용해서, MockMvcBuilder 객체를 얻음
		//       라. '다'에서 얻은 MockMvcBuilder.build() 메소드를 이용해서, MockMvc 객체를 얻음
		//       마. 'MockMvcRequestBuilders' Helper class의 정적메소드를 이용해서, MockMvcRequestBuilder 객체를 얻음
		//       바. 'MockMvc'와 '마'에서 얻어낸, 'MockMvcRequestBuilder' 2개의 객체를 가지고 실제 가상의 요청(Request)을 전송
		//            - MockMvc.perform(MockMvcRequestBuilder) 메소드 호출로 수행
		//			  - 테스트 대상인 Controller 의 핸들러 메소드가 수행되면서,
		//			  - 그 결과로 2가지 정보를 얻게 됨((1) 뷰이름,  (2) Model)
		//	     사. `바`에서 얻은 2가지 정보 중, 필요로하는 정보를 얻어내서 사용
		
		

		
		// Step.1 스프링 Beans Container의 주소를 얻은 `MockMvcBuilders`의 정적메소드로 `MockMvcBuilder` 객체 획득
		//MockMvcBuilders >> s 붙은거 helper class 
		
//		MockMvcBuilder bulder = MockMvcBuilders.webAppContextSetup(ctx);
		
		
		// Step.2 `MockMvcBuilder` 객체로부터 build 해서, 우리에게 반드시 필요한 핵심객체인 `MockMvc` 객체 획득
//		MockMvc mockMvc = bulder.build();
		
		// Step.3 실제 `MockMvc` 객체로 요청(Request)을 만들어 내려면, `RequestBuilder` 객체가 우선 필요
		//		  `MockMvcRequestBuilders` Helper 클래스의 메소드를 이용하여, `RequestBuilder` 객체 획득
		//		  (전송방식: GET, Request Mapping URI: /board/list 인 요청을 만들어내는 RequestBuilder 객체 획득)
//		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.get("/board/list");	
		
		// Step.4 위 Step.2에서 얻어낸 `MockMvc`객체와 Step.3에서 얻어낸 `RequestBuilder` 객체, 2개를 이용하여 실제 요청전송
//		ResultActions resultActions = mockMvc.perform(reqBuilder);
		
		// Step.5 호출된 Controller의 Handler 메소드에서 반환된 2개의 데이터(뷰이름 + Model) 를 뽑아냄
//		MvcResult mvcResult = resultActions.andReturn();	// Controller Handler Method가 실행종료되어서 2개의 데이터를 반환하기까지 기다림
		
		// Step.6 `MvcResult`가 가지고 있는 2가지 데이터를 한꺼번에 `ModelAndView` 객체로 얻어냄
//		ModelAndView resultData = mvcResult.getModelAndView();
		
		// Step.7 `ModelAndView`에서, 각각 `Model`과 `View` 객체를 얻어낼 수 있음.
//		String viewName = resultData.getViewName();
//		ModelMap model = resultData.getModelMap();
//		HttpStatus statusCode = resultData.getStatus();
//		
//		log.info("1. statusCode: {}", statusCode);
//		log.info("2. viewName: {}", viewName);
//		log.info("3. model: {}", model);
		
		
//		== Fluent API & Method Chaining 을 이용한 요청전송과 응답 확인
		
		//mockMvc>> 가상의 웹 브라우저를 얻는 것 목표 
		//1.webAppContextSetup 정적 메소드 :: Build a MockMvc instance using the give 빌더 생성 
		MockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(ctx);
		//2.위의 빌더로부터 mockMvc생성 
		MockMvc mockMvc = builder.build();
		//3.mockMvc의 perform메소드를 수행하기 위해서 RequestBuilder가 필요하다.
		//MockMvcRequestBuilders >> RequestBuilder만드는 helper class 
		//요청할 URI와 get or post 방식 설정 
		//가상의 브라우저한테 이 웹 브라우저 URI의 요청을 보낸다 ?
		RequestBuilder reqBuilder = MockMvcRequestBuilders.get("/board/list");
				
		// ModelMap => LinkedHashMap<String, ArrayList>
		//4.mockMvc로부터 요청 전송하고 result(model,view) 결과 반환 
		ModelMap modelMap = 
//		String viewName =
			mockMvc.
				perform(reqBuilder).		// 요청 전송 > Spring MVC framwork로 > controller method 수행결과로 model, list 반환  
				andReturn().				// MvcResult  return : the result of the request : (view and model box)
				getModelAndView().			// ModelAndView 
				getModelMap();				// ModelMap :: 모델은 맵객체이다 ::  model만 받을경우 
//				getViewName();				// viewName :: view 만 받을 경우 
		
		// 자원해제 : Map객체 clear + Map객체저장 참조변수값을 null로 지정 => 빠른 GC가 가능해짐
		modelMap.clear();
		modelMap = null;
		
	} // testGetList
	
	@Test
	public void testListPerPage() throws Exception {
		log.trace("testListPerPage() invoked.");
		
		MockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(ctx);
		MockMvc mockMvc = mockMvcBuilder.build();
		
//		----

		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.get("/board/listPerPage");
		reqBuilder.param("currPage", "7");
		reqBuilder.param("amount", "20");
		
//		----
				
		ModelAndView modelAndView =
			mockMvc.
				perform(reqBuilder).
				andReturn().				// MvcResult
				getModelAndView();			// ModelAndView
		
		log.info("\t+ modelAndView: {}", modelAndView);
	} // testListPerPage
	
	
	@Test
	public void testGet() throws Exception {
		log.trace("testGet() invoked.");
		
		MockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(ctx);
		MockMvc mockMvc = mockMvcBuilder.build();
		
//		----

		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.get("/board/get");
		reqBuilder.param("bno", "88");
		
//		----
				
		ModelAndView modelAndView =
			mockMvc.
				perform(reqBuilder).
				andReturn().				// MvcResult
				getModelAndView();			// ModelAndView
				
		log.info("\t+ modelAndView: {}", modelAndView);
	} // testGet
	
	@Test(timeout=3000)
	public void testRegister() throws Exception {
		log.trace("testGetList() invoked.");
		
		MockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(ctx);
		MockMvc mockMvc = builder.build();
		
//		----
		//MockHttpServletRequestBuilder:required as input to perform requests in MockMvc.
		// Request Mapping : POST, /board/register
		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.post("/board/register");
		// 필요한 전송파라미터를 지정 
		reqBuilder.param("title", "TITLE_NEW");
		reqBuilder.param("content", "CONTENT_NEW");
		reqBuilder.param("writer", "WRITER_NEW");
		
//		----
		
		String viewName = 
			mockMvc.
				perform(reqBuilder).
				andReturn().
				getModelAndView().
				getViewName();
		
		log.info("\t+ viewName: {}", viewName);
	} // testRegister
	
	
	
	@Test
	public void testModify() throws Exception {
		log.trace("testModify() invoked.");
		
		MockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(ctx);
		MockMvc mockMvc = builder.build();
		
//		----
		
		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.post("/board/modify");
		reqBuilder.param("bno", "111");
		reqBuilder.param("title", "title_modified");
		reqBuilder.param("content", "content_modified");
		reqBuilder.param("writer", "writer_modified");
		
//		----

		ModelAndView modelAndView =
			mockMvc.
				perform(reqBuilder).
				andReturn().
				getModelAndView();
		
		log.info("\t+ modelAndView: {}", modelAndView);
	} // testModify
	
	
	@Test
	public void testRemove() throws Exception {
		log.trace("testRemove() invoked.");
		
		MockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(ctx);
		MockMvc mockMvc = builder.build();
		
//		----
		
		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.post("/board/remove");
		reqBuilder.param("bno", "68");
		
//		----

		ModelAndView modelAndView =
			mockMvc.
				perform(reqBuilder).
				andReturn().
				getModelAndView();
		
		log.info("\t+ modelAndView: {}", modelAndView);
	} // testRemove
	
	
	

} // end class
