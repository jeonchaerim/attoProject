package org.zerock.myapp.controller;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.myapp.domain.AdminDTO;
import org.zerock.myapp.domain.AdminVO;
import org.zerock.myapp.domain.BoardDTO;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.domain.UserDTO;
import org.zerock.myapp.domain.UserVO;
import org.zerock.myapp.exception.ControllerException;
import org.zerock.myapp.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
//@NoArgsConstructor
@AllArgsConstructor

@RequestMapping("/board/*")		// Base URI
@Controller 
public class BoardController implements InitializingBean {
	
	private BoardService boardService;
	
	
	@GetMapping("/home") 
	public void home() throws ControllerException {
	}
	
	//사용자 로그인 
	@PostMapping("/userLogin") 
	public String userLogin(UserDTO dto, RedirectAttributes rttrs, Model model, HttpSession session) throws ControllerException {
		log.info("userLogin() invoked.", dto);
		
		try { 
			UserVO vo = this.boardService.userLogin(dto);
			log.info("vo : ({})", vo);
			
			if(vo != null) {
//				rttrs.addAttribute("_RESULT_", "SUCCESS");
				session.setAttribute("_USER_", vo);
			} else {
				rttrs.addAttribute("_RESULT_", "FAIL");
				
				return "redirect:/board/home"; // 로그인 실패
			}//if-else 
		}catch(Exception e) {
			throw new ControllerException(e);
		}// try-catch	
		return "redirect:/board/listPerPage";//로그인 성공 
	}// loginProcess
	
	
	// 페이징 처리된 게시판 목록조회 
		@GetMapping("/listPerPage")		
		public void listPerPage(Criteria cri, Model model) throws ControllerException {
			log.trace("list({}) invoked.", model);
			
			try {
				List<BoardVO> list = this.boardService.getListPerPage(cri);
//				list.forEach(log::trace);

				model.addAttribute("__LIST_PER_PAGE__", list);
			} catch(Exception e) {
				throw new ControllerException(e);
			} // try-catch
		} // list
	

	// 게시글 조회 
	@GetMapping({"/get"})
	public void get(BoardDTO dto, Model model) throws ControllerException {
		log.debug("get({}, {}) invoked.", dto, model);
		
		try {
			BoardVO vo = this.boardService.read(dto);
			log.info("\t+ vo: " + vo);
			
			model.addAttribute("_BOARD_", vo);	
		} catch(Exception e) {
			throw new ControllerException(e);
		} // try-catch
	} // get
	
	//게시글 수정 
	@GetMapping({"/modify"})
	public void modify(BoardDTO dto, Model model) throws ControllerException {
		log.debug("modify({}, {}) invoked.", dto, model);
		
		try {
			BoardVO vo = this.boardService.read(dto);
			log.info("\t+ vo: " + vo);
			
			model.addAttribute("_BOARD_", vo);	
		} catch(Exception e) {
			throw new ControllerException(e);
		} // try-catch
	} // get
	

	// 게시글 삭제 
	//redirect : request 
	@PostMapping("/remove")
	public String remove(BoardDTO dto, RedirectAttributes rttrs) throws ControllerException {
		log.debug("modify({}, {}) invoked.", dto, rttrs);
		
		try {
			if(this.boardService.remove(dto)) {
				rttrs.addAttribute("_RESULT_", "success");
			} else {
				rttrs.addAttribute("_RESULT_", "failed");
			} // if-else
			
			return "redirect:/board/listPerPage";
		} catch(Exception e) {
			throw new ControllerException(e);
		} // try-catch
	} // remove
	

	// 게시글 등록 
	@PostMapping("/register")
	public String register(BoardDTO dto, RedirectAttributes rttrs) throws ControllerException {
		log.trace("register({}) invoked.", dto);
		
		try { 
			if(this.boardService.create(dto)) {
				rttrs.addAttribute("_RESULT_", "success");
			} else {
				rttrs.addAttribute("_RESULT_", "failed");
			} // if-else
			
			return "redirect:/board/listPerPage";
		} catch(Exception e) {
			throw new ControllerException(e);
		} // try-catch
	} // register
	

	//  게시글 수정 
	@PostMapping("/modify")
	public String modify(BoardDTO dto, RedirectAttributes rttrs) throws ControllerException {
		log.debug("modify({}, {}) invoked.", dto, rttrs);

		try {
			if(this.boardService.update(dto)) {
				rttrs.addAttribute("_RESULT_", "success");	 
			
			} else {
				rttrs.addAttribute("_RESULT_", "failed");
			} // if-else
			
			return "redirect:/board/listPerPage";
		} catch(Exception e) {
			throw new ControllerException(e);
		} // try-catch
	} // modify
	
	//게시글 등록
	@GetMapping("/register")
	public void register() {
		log.trace("register() invoked.");
	}//register
	
	
//=======================================	
	//관리자 로그인 
		@PostMapping("/adminLogin") 
		public String adminLogin(AdminDTO dto, RedirectAttributes rttrs, Model model, HttpSession session) throws ControllerException {
			log.info("adminLogin() invoked.", dto);
			
			try { 
				AdminVO vo = this.boardService.adminLogin(dto);
				log.info("vo : ({})", vo);
				
				if(vo != null) {
					session.setAttribute("_USER_", vo);
				} else {
					rttrs.addAttribute("_RESULT_", "FAIL");
					
					return "redirect:/board/home"; // 로그인 실패
				}//if-else 
			}catch(Exception e) {
				throw new ControllerException(e);
			}// try-catch	
			return "redirect:/board/listPerPageAdmin";//로그인 성공 
		}// loginProcess
		
		@GetMapping("/listPerPageAdmin")		
		public void listPerPageAdmin(Criteria cri, Model model) throws ControllerException {
			log.trace("listPerPageAdmin({}) invoked.", model);
			
			try {
				List<BoardVO> list = this.boardService.getListPerPage(cri);
//				list.forEach(log::trace);
				model.addAttribute("__LIST_PER_PAGE__", list);
			} catch(Exception e) {
				throw new ControllerException(e);
			} // try-catch
		} // list
		
		// 게시글 조회 
		@GetMapping({"/getAdmin"})
		public void getAdmin(BoardDTO dto, Model model) throws ControllerException {
			log.debug("get({}, {}) invoked.", dto, model);
			
			try {
				BoardVO vo = this.boardService.read(dto);
				log.info("\t+ vo: " + vo);
				
				model.addAttribute("_BOARD_", vo);	
			} catch(Exception e) {
				throw new ControllerException(e);
			} // try-catch
		} // get
		
	

//	=========================================
	
	@Override
	public void afterPropertiesSet() throws Exception {
		log.trace("afterPropertiesSet() invoked.");
		
		
		Objects.requireNonNull(this.boardService);
		log.trace("\t+ this.boardService: {}", this.boardService);
	} // list
	

}//end class 
