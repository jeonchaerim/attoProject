package org.zerock.myapp.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.myapp.domain.AdminDTO;
import org.zerock.myapp.domain.AdminVO;
import org.zerock.myapp.domain.BoardDTO;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.domain.UserDTO;
import org.zerock.myapp.domain.UserVO;
import org.zerock.myapp.exception.DAOException;
import org.zerock.myapp.exception.ServiceException;
import org.zerock.myapp.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;



@Log4j2

@Service("boardService")
public class BoardServiceImpl
	implements BoardService, InitializingBean, DisposableBean {
	
	@Setter(onMethod_= @Autowired)
	private BoardMapper mapper;
	
	@Override
	public UserVO userLogin(UserDTO dto) throws ServiceException {
		log.trace("userLogin({}) invoked.", dto);
		
		try { return this.mapper.selectUser(dto); }
			catch (DAOException e) {
			throw new ServiceException(e);
		} // try-catch
	} // userLogin
	

	@Override
	public List<BoardVO> getListPerPage(Criteria cri) throws ServiceException {
		log.trace("getListPerPage({}) invoked.", cri);
		
		try { return this.mapper.selectListwithPaging(cri); } 
		catch (DAOException e)  { throw new ServiceException(e); } // try-catch
	} // getListPerPAge


	@Override
	public BoardVO read(BoardDTO dto) throws ServiceException {
		log.trace("read({}) invoked.", dto);
		
		try { return this.mapper.select( dto.getBno() ); }
			catch (DAOException e) {
			throw new ServiceException(e);
		} // try-catch
	} // read


	@Override
	public boolean remove(BoardDTO dto) throws ServiceException {
		log.trace("remove({}) invoked.", dto);
				
		try {
			return this.mapper.delete( dto.getBno() ) == 1 ;
		} catch (DAOException e) {
			throw new ServiceException(e);
		} // try-catch
	} // remove


	@Override
	public boolean create(BoardDTO dto) throws ServiceException {
		log.trace("create({}) invoked.", dto);
		
		try {
			return this.mapper.insertSelectKey(dto) == 1;
		} catch (DAOException e) {
			throw new ServiceException(e);
		} // try-catch
	} // create


	@Override
	public boolean update(BoardDTO dto) throws ServiceException {
		log.trace("update({}) invoked.", dto);
		
		try { return this.mapper.update(dto) == 1; } 
		catch (DAOException e) {
			throw new ServiceException(e);
		} // try-catch
	} // update
	
	
	@Override
	public AdminVO adminLogin(AdminDTO dto) throws ServiceException {
		log.trace("adminLogin({}) invoked.", dto);
		
		try { return this.mapper.selectAdmin(dto); }
			catch (DAOException e) {
			throw new ServiceException(e);
		} // try-catch
	} // adminLogin
	
	
	//===================================================//

	@Override
	public void destroy() throws Exception {			
		log.trace("destroy() invoked.");
		
	} // destroy

	@Override
	public void afterPropertiesSet() throws Exception {	
		log.trace("afterPropertiesSet() invoked.");
		
		Objects.requireNonNull(this.mapper);			
		assert this.mapper != null;						
		
		log.info("\t+ this.mapper: {}", this.mapper);
	}



} // end class
