package org.zerock.myapp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.myapp.domain.BoardDTO;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.domain.UserDTO;
import org.zerock.myapp.domain.UserVO;
import org.zerock.myapp.exception.ServiceException;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

@ExtendWith(SpringExtension.class)

@ContextConfiguration(locations= "file:src/main/webapp/**/spring/**/*-context.xml")

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BoardServiceTests {
	
	@Setter(onMethod_= @Autowired)
	private BoardService service;
	
	
	@BeforeAll
	void beforeAll() {
		log.trace("beforeAll() invoked.");
		
		assertNotNull(this.service);
		log.info("\t+ this.service: {}", this.service);
	} // beforeAll
	
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("1. BoardService.testUserLogin test.")
	@Timeout(value=3, unit=TimeUnit.SECONDS)
	void testUserLogin() throws ServiceException {
		log.trace("testUserLogin() invoked.");
		
//		UserDTO dto = new UserDTO("jcr","0000");
//		UserVO vo = this.service.userLogin(dto);
		
		UserDTO dto2 = new UserDTO("jcr","0001");
		UserVO vo2 = this.service.userLogin(dto2);
		
//		assertNotNull(vo);
//		log.info("\t+ vo: {}", vo);
		log.info("\t+ vo: {}", vo2);

	} // testUserLogin
	
	
//	@Disabled
	@Test
	@Order(2)
	@DisplayName("2. BoardService.Read(dto) test.")
	@Timeout(value=3, unit=TimeUnit.SECONDS)
	void testRead() throws ServiceException {
		log.trace("testRead() invoked.");
		
		int testBno = 5;	
		BoardDTO dto= new BoardDTO();
		dto.setBno(testBno);
		
		BoardVO vo = this.service.read(dto);
		
		assertNotNull(vo);
		log.info("\t+ vo: {}", vo);
	} // testRead
	
	
//	@Disabled
	@Test
	@Order(3)
	@DisplayName("3. BoardService.remove(bno) test.")
	@Timeout(value=3, unit=TimeUnit.SECONDS)
	void testRemove() throws ServiceException {
		log.trace("testRemove() invoked.");
		
		int bno = 39;	
		BoardDTO dto= new BoardDTO();
		dto.setBno(bno);
		
		boolean result = this.service.remove(dto);
		
		log.info("\t+ result: {}", result);
	} // testRemove
	
//	@Disabled
	@Test
	@Order(4)
	@DisplayName("4. BoardService.testCreate test.")
	@Timeout(value=3, unit=TimeUnit.SECONDS)
	void testCreate() throws ServiceException {
		log.trace("testCreate() invoked.");
		
		BoardDTO dto = new BoardDTO(null, "TITLE_100", "CONTENT_100", "writer_100", "w");
		
		if(service.create(dto)) {
			log.info("\t + New Board registered.");
			log.info("\t+ dto: " + dto);
		} else {
			log.info("\t + No Board registered");
		}
	} // testCreate
	
//	@Disabled
	@Test
	@Order(5)
	@DisplayName("5. BoardService.testupdate test.")
	@Timeout(value=3, unit=TimeUnit.SECONDS)
	void testupdate() throws ServiceException {
		log.trace("testupdate() invoked.");
		
		BoardDTO dto = new BoardDTO(17, "TITLE_modified", "CONTENT_modified", "WRITER_modified", "w");
		
		if(service.update(dto)) {
			log.info("\t + Board modified.");
		} else {
			log.info("\t + Board didn't modified");
		}
	} // testupdate
	
//	@Disabled
	@Test
	@Order(6)
	@DisplayName("6. testGetListPerPage")
	@Timeout(value=3, unit=TimeUnit.SECONDS)
	void testGetListPerPage() throws ServiceException {
		log.debug("testGetListPerPage() invoked.");
		
		Criteria cri = new Criteria();
		cri.setCurrPage(2);
		cri.setAmount(20);
		
		this.service.getListPerPage(cri).forEach(log::info);
	} // testGetListPerPage
	


}//end class 
