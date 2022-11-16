package org.zerock.myapp.service;

import java.util.List;

import org.zerock.myapp.domain.AdminDTO;
import org.zerock.myapp.domain.AdminVO;
import org.zerock.myapp.domain.BoardDTO;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.domain.UserDTO;
import org.zerock.myapp.domain.UserVO;
import org.zerock.myapp.exception.ServiceException;


public interface BoardService {
	
	public abstract UserVO userLogin(UserDTO dto) throws ServiceException;
	
	public abstract List<BoardVO> getListPerPage(Criteria cri) throws ServiceException;
	
	public abstract BoardVO read(BoardDTO dto) throws ServiceException;
	
	public abstract boolean remove(BoardDTO dto) throws ServiceException;
	
	public abstract boolean create(BoardDTO dto) throws ServiceException;	
	
	public abstract boolean update(BoardDTO dto) throws ServiceException;
	
	public abstract AdminVO adminLogin(AdminDTO dto) throws ServiceException;


} // end interface 
