package org.zerock.myapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.zerock.myapp.domain.AdminDTO;
import org.zerock.myapp.domain.AdminVO;
import org.zerock.myapp.domain.BoardDTO;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.domain.UserDTO;
import org.zerock.myapp.domain.UserVO;
import org.zerock.myapp.exception.DAOException;

//DAO
public interface BoardMapper {
	
	public abstract UserVO selectUser(UserDTO dto) throws DAOException;
	public abstract List<BoardVO> selectListwithPaging(Criteria cri) throws DAOException;
	
//	public abstract Integer insert(BoardDTO dto) throws DAOException;
	public abstract Integer insertSelectKey(BoardDTO dto) throws DAOException;
	public abstract Integer update(BoardDTO dto) throws DAOException;
	
	@Delete("DELETE FROM tbl_board WHERE bno = #{bnoToBeDeleted}")
	public abstract int delete(@Param("bnoToBeDeleted") Integer bno) throws DAOException;
	@Select("SELECT * FROM tbl_board WHERE bno = #{bnoToBeRead}")
	public abstract BoardVO select(@Param("bnoToBeRead") Integer bno) throws DAOException;

	public abstract AdminVO selectAdmin(AdminDTO dto) throws DAOException;
	
	
	public abstract Integer updateAnswer(BoardDTO dto) throws DAOException;
	

}//end interface 
