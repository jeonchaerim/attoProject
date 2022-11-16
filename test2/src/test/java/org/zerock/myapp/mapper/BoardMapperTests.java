package org.zerock.myapp.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Objects;
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
import org.zerock.myapp.exception.DAOException;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor



@ExtendWith(SpringExtension.class)

@ContextConfiguration(locations= {
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})


@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BoardMapperTests {
	@Setter(onMethod_= {@Autowired})
	private BoardMapper mapper;
	
	
	@BeforeAll
	void beforeAll() {	
		log.trace("beforeAll() invoked.");
		
		assertNotNull(this.mapper);
		log.info("\t+ 1. this.mapper: {}", this.mapper);
		log.info("\t+ 2. type: {}", this.mapper.getClass().getName());
	} // beforeAll
	
		
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("1. BoardMapper.selectUser() test.")
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	void testSelectUser() throws DAOException {
		log.trace("testSelectAllList() invoked.");
		
		UserDTO dto = new UserDTO("jcr","0000");
		UserVO vo = this.mapper.selectUser(dto);
		
		Objects.requireNonNull(vo);
		log.trace(" \t + dto : {}" , vo);
		
	} // testSelectUser
	
		
//	@Disabled
	@Test
	@Order(2)
	@DisplayName("2. BoardMapper.delete(bno) test.")
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	void testDelete() throws DAOException {
		log.trace("testDelete() invoked.");
		
		int bnoToBeDeleted = 33;
		
		int affectedLines = this.mapper.delete(bnoToBeDeleted);
		log.info("\t+ affectedLines: {}", affectedLines);
		
		assert affectedLines == 1;
	} //testDelete
	
	
//	@Disabled
	@Test
	@Order(3)
	@DisplayName("3. BoardMapper.select(bno) test.")
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	void testSelect() throws DAOException {
		log.trace("testSelect() invoked.");
		
		int bnoToBeRead = 44;
		
		BoardVO vo  = this.mapper.select(bnoToBeRead);
		
		Objects.requireNonNull(vo);
		log.trace(" \t + dto : {}" , vo);
	} // testSelect 
	

	
//	@Disabled
	@Test
	@Order(4)
	@DisplayName("4. BoardMapper.insertSelectKey(BoardDTO) test.")
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	void testinsertSelectKey() throws DAOException {
		log.trace("testInsert() invoked.");
		
	
		BoardDTO dto = new BoardDTO(null, "TITLE_100", "CONTENT_100", "writer_100", "W");
		log.trace(" \t +1.  vo : {}" , dto);
		
		//2.VO 파라미터 전달 
		int affectedLines = this.mapper.insertSelectKey(dto);
		log.trace(" \t + 2.  affectedLines : {}" , affectedLines);
		
		assert affectedLines == 1;
	} // testInsert 
	
//	@Disabled
	@Test
	@Order(5)
	@DisplayName("5. BoardMapper.update(BoardDTO) test.")
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	void testUpdate() throws DAOException {
		log.trace("testUpdate() invoked.");
		
		BoardDTO dto = new BoardDTO(44, "TITLE_MODIFIED100", "CONTENT_MODIFIED100", "WRITER_MODIFIED100", "W");
		log.info("\t+ 1. dto: {}", dto);
		
		int affectedLines = this.mapper.update(dto);
		log.info("\t+ 2. affectedLines: {}", affectedLines);
		
		assert affectedLines == 1;
	} // testUpdate
	
//	@Disabled
	@Test
	@Order(6)
	@DisplayName("6. BoardMapper.selectListwithPaging test.")
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	void testselectListwithPaging() throws DAOException {
		log.trace("testselectListwithPaging() invoked.");

		Criteria cri = new Criteria();
		cri.setCurrPage(9); 
		cri.setAmount(10);  
		List<BoardVO> list = this.mapper.selectListwithPaging(cri);
		
		Objects.requireNonNull(list);
		list.forEach(log::info);
	} // testselectListwithPaging
	
	
	

} // end class
